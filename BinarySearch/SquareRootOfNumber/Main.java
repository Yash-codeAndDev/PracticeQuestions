public class Main{
    public static void main(String[] args) {
        
        long num = 36;
        System.out.println(floorSqrt(num));

    }
    public static long floorSqrt(long n) {
        
        long low = 0;
        long high = n;
        
        long ans = 0;
        while(low<=high)
        {
            long mid = low + (high-low)/2;
            
            if(mid*mid <= n){
                if(mid*mid == n){
                    return mid;
                }
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
}