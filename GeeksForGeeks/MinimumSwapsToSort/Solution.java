import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

class Pair{
    int first;
    int second;

    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }

    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}


public class Solution {

    public static void main(String[] args) {
        
        int[] arr = {6 , 4, 2, 14, 8, 10, 12, 16};
        // System.out.println("Given Array -> "+Arrays.toString(arr));

        ArrayList<Pair> originalList = new ArrayList<>();
        for(int i=0; i < arr.length; i++){
            originalList.add(new Pair(arr[i] , i));
        }
        System.out.println("Elements and Index List -> "+originalList);

        Collections.sort(originalList , new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2) {
                return Integer.compare(p1.first, p2.first);
            }
        } );

        System.out.println("Sorted  List -> "+originalList);

        boolean[] vis = new boolean[arr.length];
        int minSwaps = 0;

        for(int i=0; i<arr.length; i++ )
        {

            if(vis[i] == true || originalList.get(i).second == i){
                continue;
            }
            else{
                int j = i;
                int cycleLen = 0;
                while(vis[j] != true){

                    vis[j] = true;
                    j = originalList.get(j).second;
                    cycleLen += 1;
                }

                minSwaps += cycleLen-1;
            }
        }

        System.out.println("Minimum Swaps : "+minSwaps);
    }
}