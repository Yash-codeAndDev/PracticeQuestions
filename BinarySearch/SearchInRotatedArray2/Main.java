public class Main {
    public static void main(String[] args) {
        
        int arr[] = {3,1,2,3,3,3,3};
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

            
            if(arr[low] == arr[mid] && arr[mid] ==arr[high]){
                low = low+1;
                high = high-1;
                continue;
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
