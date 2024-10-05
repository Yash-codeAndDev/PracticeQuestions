package FirstAndLastOccurrence;
import java.util.*;

public class FirstAndLastOccurrence 
{
    public static void main(String[] args){
        int n = 7;
        int arr[]  = {3 ,4 ,4 ,4 ,5 ,6 ,7 ,7 ,7 ,8 ,10 ,11 ,11 ,12 ,14 ,18 ,19 ,20 ,20};

        ArrayList<Integer> ans = firstAndLast(n, arr);

        for (Integer val : ans) System.out.print(val + " ");
        System.out.println();
    }

    public static int getFirst(int x, int arr[])
    {
        int low = 0;
        int high = arr.length-1;
        
        int pos = -1;
        while(low <= high){
            
            int mid = low + (high-low)/2;
        
            if(arr[mid] >= x )
            {
                if(arr[mid] == x)
                {
                    pos = mid;
                }
                high = mid -1;
            }else{
                low = mid+1;
            }
        }
        
        return pos;
    }

    public static int getLast(int x, int arr[])
    {
        int low = 0;
        int high = arr.length-1;
        int pos = -1;
        while(low <= high){
            
            int mid = low + (high-low)/2;
        
            if (arr[mid] <= x) {
                if (arr[mid] == x) {
                    pos = mid;  
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return pos;
    }

    public static ArrayList<Integer> firstAndLast(int x, int arr[]) {
        
        int first = getFirst(x,arr);
        
        int last = getLast(x,arr);
        
        ArrayList<Integer> ans = new ArrayList<>();

        if(first != -1)
        {
            ans.add(first);
            ans.add(last);
        }
        else{
            ans.add(-1);
        }
        return ans;
    }
    
}
