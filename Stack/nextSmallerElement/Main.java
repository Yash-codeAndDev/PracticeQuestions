import java.util.*;
public class Main
{
    public static long[] nextSmallerElement(long[] arr, int n)
    { 
        
        long[] ans= new long[n];
        
        Deque<Long> stack = new ArrayDeque<Long>();
        
        for(int i=n-1; i>=0; i--)
        {
            
            while( !stack.isEmpty() && arr[i] <= stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        
        return ans;
        
    } 
	public static void main(String[] args) {
		
		long arr[] = {9,7,2,5,8,1};
		int n = 6;
		long[] ans = nextSmallerElement(arr,n);
		System.out.println(Arrays.toString(ans));
	}
}