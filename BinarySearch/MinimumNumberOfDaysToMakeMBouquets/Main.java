import java.util.*;
public class Main{
    public static void main(String[] args) {
        
        int[] bloomDay = {1, 10, 3, 10, 2};
        int k = 1;
        int m = 3;

        
        if( k * m > bloomDay.length ){
            System.out.println("-1");;
        }

        int low =  Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();


        int ans = -1;

        while(low<=high){
            int mid = low + (high-low)/2;

            if( check(bloomDay, m , k , mid)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid + 1;
            }
        }

        System.out.println(ans);

    }

    
    public static boolean check(int[] bloomDay, int m, int k, int mid){

        int count = 0;
        int bouquets = 0;
        for(int i=0; i<bloomDay.length; i++)
        {
            if(bloomDay[i] <= mid){
                count++;
            }else{
                bouquets += count/k;
                count = 0;
            }
        }
        bouquets += count/k;
        if(bouquets < m){
            return false;
        }
        return true;
    }
}
 


