public class Main {
    public static void main(String[] args) {
        
        int arr[] = {-18,-11, -2 , 3, 8, 10, 13, 15};

        int target = 5;

        System.out.println(helper(arr,target));

    }

    public static int helper(int[] arr, int target){

        int low = 0, high = arr.length-1;

        while(low<=high){

            int mid = low + (high-low)/2;

            if(arr[mid] == target){
                return arr[mid];
            }

            if(arr[mid] > target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return  Math.abs(arr[low] - target) <= Math.abs(arr[high] - target) ? arr[low] : arr[high]; 

    }
}