public class TokenBucket {
    private final double unitAddnum;//单位时间1s的令牌注入速度
    private final long maxTokennum;//令牌桶的最大容量

    private volatile long currToken=0;//当前桶里的数量
    private volatile long nextRefreshtime=0L;//下一次刷新桶的时间戳
    private volatile long lastAcquireTime;//上一次获取令牌的时间戳
    public TokenBucket(double unitAddnum,long maxTokennum){
        if(unitAddnum<=0||maxTokennum<=0){
            throw new RuntimeException("unitAddnum and maxTokennum cannot less 0");
        }
        this.unitAddnum=unitAddnum;
        this.maxTokennum=maxTokennum;
        this.nextRefreshtime=calculateNextRefreshtime(System.currentTimeMillis());

    }
    public boolean acquire(long needTokennum){
        if(needTokennum>this.maxTokennum){
            return false;
        }
        synchronized (this){
            long currTimestamp=System.currentTimeMillis();
            this.refreshCurrtoken(currTimestamp);
            if(needTokennum<=this.currToken){
                return this.doAcquir(needTokennum,currTimestamp);
            }
            return false;
        }
    }
    private boolean doAcquir(long needTokennum,long currTimestamp){
        this.currToken-=needTokennum;
        this.lastAcquireTime=currTimestamp;
        return true;
    }
    /*
        刷新令牌数量
     */
    private void refreshCurrtoken(long currTimestamp){
        if(this.nextRefreshtime>currTimestamp){
            return;
        }
        this.currToken=Math.min(this.maxTokennum,this.currToken+calculateNeedAddtokennum(currTimestamp));
        this.nextRefreshtime=calculateNextRefreshtime(currTimestamp);
    }
    /*
    * 计算当前需要填加多少令牌
    * */
    private  long calculateNeedAddtokennum(long timestamp){
        if(timestamp<this.nextRefreshtime){
            return 0;
        }
        long addnewMs=Math.round(1.0D /this.unitAddnum*1000D);
        return (timestamp-this.nextRefreshtime)/addnewMs+1;
    }
    private long calculateNextRefreshtime(long timestamp){
        if(timestamp<this.nextRefreshtime){
            return this.nextRefreshtime;
        }
        long addnewMs=Math.round(1.0D /this.unitAddnum*1000D);
        long result=0;
        if(this.nextRefreshtime<=0){
            result = currToken+addnewMs;
        }else{
            result=this.nextRefreshtime+((timestamp-this.nextRefreshtime)/addnewMs+1)*addnewMs;
        }
        return result;
    }
}
