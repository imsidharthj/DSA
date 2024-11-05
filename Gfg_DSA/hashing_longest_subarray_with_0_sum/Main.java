import java.util.*;
import java.util.HashMap;

class Main{
    public static int largestSubarray(int[] arr, int n){
        // int sumTillNow = 0;
        // List<Integer> result = new ArrayList<>();
        // for(int num : arr){
        //     if(num > 0){
        //         if(result.isEmpty() || (num > result.size() - 1)){
        //             result.add(num);
        //         }
        //     }
        // }
        // int k = 0;
        // List<Integer> largestSub = new ArrayList<>();
        // for(int i = 0; i < arr.length; i++){
        //     if(arr[i] < 0){
        //         sumTillNow += arr[i];
        //         largestSub.add(arr[i]);
        //     }
        //     sumTillNow = Math.abs(sumTillNow);
        //     while(sumTillNow != 0 && k < result.size()){
        //         sumTillNow -= result.get(k);
        //         largestSub.add(result.get(k));
        //         k++;
        //     }
        // }
        // return largestSub;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxi = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            if(sum == 0){
                maxi = i + 1;
            } else{
                if(map.get(sum) != null){ // checking if the sum exists as a key in the HashMap.
                    maxi = Math.max(maxi, i - map.get(sum)); // This part attempts to retrieve the value associated with the key
                } else {
                    map.put(sum, i);
                }
            }
        }
        return maxi;
    }
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        int result = largestSubarray(arr, arr.length);
        System.out.println("Longest subarray with sum 0: " + result);
    }
}