import java.util.*;

public class Main {

    public static void main(String[] args) {
        
        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println( trap(height));
    }
 
    public static int trap(int[] height) {
        
        int n = height.length;
        int maxLeft[] = new int[n];
        int maxRight[] = new int[n];
            
        int ans = 0; 
        for(int i=0;i<n;i++)
        {
            if(i==0)
            {
                maxLeft[i] = height[i];
            }
            else{
                maxLeft[i] = Math.max(height[i], maxLeft[i-1]);
            }
        }

        for(int i=n-1;i>=0;i--)
        {
            if(i==n-1)
            {
                maxRight[i] = height[i];
            }
            else{
                maxRight[i] = Math.max(height[i], maxRight[i+1]);
            }
        }
        
        System.out.println(Arrays.toString(maxLeft));
        System.out.println(Arrays.toString(maxRight));

        for(int i=0; i<n;i++)
        {
            int temp = Math.min(maxLeft[i], maxRight[i]) - height[i];
            ans += temp; 
        }

        return ans;

    }
}
