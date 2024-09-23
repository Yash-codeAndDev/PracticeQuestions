import java.util.*;

class Main {

    public static void main(String[] args) {
        
        int[] sample= {1,2,3,2,1};

        System.out.println(Arrays.toString( nextGreaterElements(sample)));
    }

    public static int[] checkRight(int[] arr,int n){
        int[] ansRight= new int[n];
        Arrays.fill(ansRight,-1);

        Deque<Integer> stack = new ArrayDeque<Integer>();
        
        for(int i= 2*n - 1; i>=0; i--)
        {

            while( !stack.isEmpty() && arr[i % n] >= stack.peek()){
                stack.pop();
            }
            if(i<n)
            {
                ansRight[i] = stack.isEmpty() ? -1 : stack.peek();                
            }
            stack.push(arr[i%n]);
        }
        
        return ansRight;
    }

    public static int[] nextGreaterElements(int[] arr) {
        
        int n = arr.length;
        return checkRight(arr,n);
     
    }
}
