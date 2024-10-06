public class Optimized{
    public static void main(String[] args) {
        
        int arr[] = {8, 9, 10, 1, 2, 3, 4, 5 ,6 , 7};
        
        System.out.println(findMinimum(arr));
    }

    public static int findMinimum(int arr[])
    {

        int n = arr.length;

        int low = 0;
        int high = n-1;
        int min = Integer.MAX_VALUE;
        while(low <= high){

            int mid = low + (high-low)/2;

            if(arr[low] <= arr[high]){
                min = arr[low];
                return min;
            }
            if(arr[low] <= arr[mid]) // if left is sorted
            {
                if(arr[low] <= min){
                    min = arr[low];
                }
                low = mid + 1;
            }
            else if(arr[mid]<= arr[high]){
                
                if(arr[mid] <= min){
                    min = arr[mid];
                }
                high = mid-1;
            }
        }

        return min;
    }
}
