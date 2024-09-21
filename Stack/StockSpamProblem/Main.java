import java.util.*;

class Main{
    static class Pair{
        
        int a;
        int b;
        public Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
        public int getFirst(){
            return a;
        }
        public int getSecond(){
            return b;
        }
        
        public void setFirst(int a){
            this.a = a;
        }
        public void setSecond(int b){
            this.b = b;
        }
    }
    
    
    // Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n) {
        // Your code here
        int[] ans = new int[n];
        
        
        Deque<Pair> stack = new ArrayDeque<Pair>();
        
        for(int i=0;i<n;i++)
        {
            
            Pair element = new Pair(price[i],1);
            
            while( !stack.isEmpty() && price[i] >= stack.peek().getFirst()){
                    
                    int second = element.getSecond() + stack.peek().getSecond();
                    element.setSecond(second);
                    
                    stack.pop();
                    
            }
            
            ans[i] = element.getSecond();
            stack.push(element);
            
            
        }
        return ans;
    }


    public static void main(String[] args) {
        
		int arr[] = {100,80,60,70,60,75,85};
		int n = 6;
		int[] ans = calculateSpan(arr,7);
		System.out.println(Arrays.toString(ans));
	
    }
}