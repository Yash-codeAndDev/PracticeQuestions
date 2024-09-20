import java.util.*;
public class Main
{
    public static void reverse(long[] array) {
        int start = 0;
        int end = array.length - 1;

        // Swap the elements at start and end until they meet in the middle
        while (start < end) {
            long temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            // Move towards the middle
            start++;
            end--;
        }
    }
      public static long[] nextLargerElement(long[] arr, int n)
    { 
        
        long[] ans= new long[n];
        
        Deque<Long> stack = new ArrayDeque<Long>();
        
        for(int i=n-1; i>=0; i--)
        {
            
            while( !stack.isEmpty() && arr[i] > stack.peek()){
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
        
        reverse(ans);
        return ans;
        
    } 
	public static void main(String[] args) {
		
		long arr[] = {9,7,2,5,8,1};
		int n = 6;
		long[] ans = nextLargerElement(arr,n);
		System.out.println(Arrays.toString(ans));
	}
}