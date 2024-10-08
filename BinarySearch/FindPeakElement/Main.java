public class Main {

    public static void main(String[] args) {
        
        int nums[] = {1,2,1,3,5,6,4};
        System.out.println("Peak Element in array : " + nums[helper(nums,nums.length)]);
    }
    public static int helper(int[] nums, int n){

        int low = 1;
        int high = n-2;

        if(nums[0] > nums[1]){
            return 0;
        }
        if(nums[n-1] > nums[n-2]){
            return n-1;
        }

        while(low<=high){

            int mid = low + (high-low)/2;

            if(nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]){
                return mid;
            } 

            if(nums[mid-1] < nums[mid]){
                low = mid + 1;
            }
            else if(nums[mid-1] > nums[mid]){
                high = mid-1;
            }
        }
        return -1;

    }
    public int findPeakElement(int[] nums) 
    {
        int n =  nums.length;
        if(n==1){
            return 0;
        }
        return helper(nums,n);
    }
}