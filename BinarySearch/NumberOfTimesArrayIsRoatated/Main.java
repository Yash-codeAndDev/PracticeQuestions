public class Main{
    public static void main(String[] args) {
        
        int arr[] = {8, 9, 10, 1, 2, 3, 4, 5 ,6 , 7};
        
        System.out.println(NumOfRotation(arr));
    }

    public static int NumOfRotation(int arr[])
    {

        int n = arr.length;

        int low = 0;
        int high = n-1;
        int index= -1;
        int min = Integer.MAX_VALUE;
        while(low <= high){

            int mid = low + (high-low)/2;

            if(arr[low] <= arr[high]){
                min = arr[low];
                index =  low;
                return low;
            }
            if(arr[low] <= arr[mid]) // if left is sorted
            {
                if(arr[low] <= min){
                    min = arr[low];
                    index = low;
                }
                low = mid + 1;
            }
            else if(arr[mid]<= arr[high]){
                
                if(arr[mid] <= min){
                    min = arr[mid];
                    index = mid;
                }
                high = mid-1;
            }
        }

        return index;
    }
}
