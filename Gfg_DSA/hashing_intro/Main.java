import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Main{
    public static int numberAppear(int n, int[] arr){
        // int count = 0;
        // for(int i = 0; i < n; i++){
        //     if(arr[i] == n){
        //         count++;
        //     }
        // }
        // return count;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map.getOrDefault(n, 0);
    }
    public static int[] charAppear(String s, char[] queries){
        HashMap<Character, Integer> map = new HashMap<>();
        for (char i : s.toCharArray()){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            result[i] = map.getOrDefault(queries[i], 0);
        }
        return result;
    }
    public static int[] sumIndexs(int[] arr, int target){
        HashMap <Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int remain = target - arr[i];
            if(map.containsKey(remain)){
                return new int[]{map.get(remain), i};
            } else{
                map.put(arr[i], i);
            }
        }
        return new int[]{};
    }
    public static void main(String[] args){
        // int n = 6;
        // int [] arr = {1, 2, 3, 4, 5};
        // int result = numberAppear(n, arr);
        // System.out.println(result);
        
        // String s = "abcdabehf";
        // char[] queries = {'a', 'h', 'h', 'b', 'c'};
        // int[] result_ = new int[queries.length];
        // result_ = charAppear(s, queries);
        // for (int count : result_) {
        //     System.out.println(count);
        // }

        int target = 6;
        int[] arr = {1, 2, 3, 4};
        int[] result = sumIndexs(arr, target);
        for(int num : result){
            System.out.println(num);
        }
    }
}