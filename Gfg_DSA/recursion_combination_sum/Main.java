import java.util.ArrayList;
import java.util.Arrays;

class Main{
    public static void findSum(int num[], int index, int sumTillNow, int target, ArrayList<Integer> temArray, ArrayList<ArrayList<Integer>> result){
        if(sumTillNow > target){
            return;
        }
        if(sumTillNow == target){
            result.add(new ArrayList<>(temArray));
            return;
        }
        for (int i = index; i < num.length; i++){
            temArray.add(num[i]);
            findSum(num, i, sumTillNow + num[i], target, temArray, result);
            temArray.remove(temArray.size() - 1);
        }
    }
    public static void findUniqueSum(int[] num, int index, int sumTillNow, int target, ArrayList<Integer> temArrayList, ArrayList <ArrayList<Integer>> result){
        // if(sumTillNow > target){
        //     return;
        // }
        if (sumTillNow == target){
            result.add(new ArrayList<>(temArrayList));
            return;
        }
        for(int i = index; i < num.length; i++){
            if(i > index && num[i] == num[i - 1]) continue;
            if (sumTillNow + num[i] > target) break;
            temArrayList.add(num[i]);
            findUniqueSum(num, i + 1, sumTillNow + num[i], target, temArrayList, result);
            temArrayList.remove(temArrayList.size() - 1);
        }
    }
    public static ArrayList<ArrayList<Integer>> combinations(int num[], int target){
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        // findSum(num, 0, 0, target, new ArrayList<>(), result);
        findUniqueSum(num, 0, 0, target, new ArrayList<>(), result);
        return result;
    }
    public static void main(String[] args) {
        // int[] candidates = {2, 3, 6, 7};
        // int target = 7;
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        ArrayList<ArrayList<Integer>> result = combinations(candidates, target);
        System.out.println("Combinations that sum up to " + target + ":");
        for (ArrayList<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}