import java.util.*;

class Main{
    public static ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        sumIndexs4(nums, target, 0, 0, new ArrayList<>(), result, new HashSet<>());
        return result;
    }
    public static void sumIndexs4(int[] arr, int target, int sumTillNow, int index, ArrayList<Integer> tempArrayList, ArrayList<ArrayList<Integer>> result, Set<String> seen){
            // if((sumTillNow >= 0) && (sumTillNow >= target)){
            //     result.add(new ArrayList<>(tempArrayList));
            //     return;
            // }
            if (sumTillNow > target) {
                return;
            }
            if(tempArrayList.size() == 4){
                if(sumTillNow == target){
                    String hash = tempArrayList.toString();
                    if(!seen.contains(hash)){
                        result.add(new ArrayList<>(tempArrayList));
                        seen.add(hash);
                    }
                }
                return;
            }
            for(int i = index; i < arr.length; i++){
                if(i > index && arr[i] == arr[i - 1]) continue;
                tempArrayList.add(arr[i]);
                sumIndexs4(arr, target, sumTillNow + arr[i], i + 1, tempArrayList, result, seen);
                tempArrayList.remove(tempArrayList.size() - 1);
            }
    }
    public static void main(String[] args){
        int[] arr = {2,2,2,2,2};
        int target = 8;
        // Arrays.sort(arr);
        // ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        // sumIndexs4(arr, target, 0, 0, new ArrayList<>(), result, new HashSet<>());
        // System.out.println(result);
        ArrayList<ArrayList<Integer>> result = fourSum(arr, target);
        System.out.println("Unique Quadruplets: " + result);
    }
}