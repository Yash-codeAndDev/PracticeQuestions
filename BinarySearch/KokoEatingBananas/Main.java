class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int maxElement = Arrays.stream(piles).max().getAsInt();
        
        int high = maxElement, low = 1;
        int ans = maxElement;


        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if( helper(mid,piles,h) <= h ){
                ans = mid;
                high = mid-1;
            }  
            else{
                low = mid+1; 
            } 
        }
        return ans;
    }

    public int helper(int mid, int[] piles, int h){
        int count = 0;
        for(int i=0; i<piles.length; i++){
            count += Math.ceil( piles[i]/ (double)mid );
        }
        return count;
    }
}
