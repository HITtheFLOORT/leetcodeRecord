package Solution300plus;

public class Solution335 {
    public boolean isSelfCrossing(int[] distance){
        for(int i=3;i<distance.length;i++){
            if(distance[i]>=distance[i-2]&&distance[i-1]<=distance[i-3])return true;
            else if(i>=4&&distance[i-1]==distance[i-3]&&distance[i]+distance[i-4]>=distance[i-2])return true;
            else if(i>=5&&distance[i-2]>=distance[i-4]&&distance[i]+distance[i-4]>=distance[i-2]&&distance[i-1]<=distance[i-3]&&distance[i-1]+distance[i-5]>=distance[i-3])return true;
        }
        return false;
    }
}
/*               i-2
    case 1 : i-1┌─┐
                └─┼─>i
                 i-3

                    i-2
    case 2 : i-1 ┌────┐
                 └─══>┘i-3
                 i  i-4      (i overlapped i-4)

    case 3 :    i-4
               ┌──┐
               │i<┼─┐
            i-3│ i-5│i-1
               └────┘
                i-2

*/