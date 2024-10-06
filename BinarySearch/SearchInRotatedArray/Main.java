public class Main {
    public static void main(String[] args) {
        
        int arr[] = {9,10,13,14,15,1,2,3,4,5,6};
        int target = 1;
        
        System.out.println(findTargetIndex(arr, target));
    }

    public static int findTargetIndex(int arr[], int target)
    {

        int n = arr.length;

        int low = 0;
        int high = n-1;

        while(low <= high){

            int mid = low + (high-low)/2;

            if(arr[mid] == target){
                return mid;
            }

            // Identifying Sorted Half

            if(arr[low] <= arr[mid]) // if left half is sorted 
            {
                if(arr[low] <= target && target < arr[mid] ){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }

            }
            else{

                if(arr[mid] < target && target <= arr[high] ){
                    low= mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }

        return -1;
    }
}
