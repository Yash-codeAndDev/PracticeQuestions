public class Main{
    public static void main(String[] args) {
        
        // int arr[] = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
        // int arr[] = {3, 3, 5, 5, 6, 11, 11, 13, 13, 15, 15};
        int arr[] = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
        
        
        System.out.println(findIndex(arr));
    }

    public static int findIndex(int arr[])
    {

        int n = arr.length;

        if(n==1){
            return arr[0];
        }

        if(arr[0] != arr[1]){
            return arr[0];
        }
        if(arr[n-1] != arr[n-2]){
            return arr[n-1];
        }
        

        int low = 1;
        int high = n-2;
    
        while(low <= high){

            int mid = low + (high-low)/2;

             
            if( arr[mid-1] != arr[mid] && arr[mid+1]!=arr[mid]){
                return arr[mid];
            }

            if( (mid%2 == 1 && arr[mid] == arr[mid+1] ) || (mid%2 == 0 && arr[mid] == arr[mid-1])){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
}