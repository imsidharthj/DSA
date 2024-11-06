import java.util.ArrayList;
import java.util.Arrays;

class Main{
    public static boolean subsetSum(int[] arr, int target, int index, int sumTillNow){
        if(sumTillNow == target){
            return true;
        }
        if(sumTillNow > target){
            return false;
        }
        for(int i = index; i < arr.length; i++){
            if(sumTillNow + arr[i] > target) continue;
            if((subsetSum(arr, target, i + 1, sumTillNow + arr[i])) || (subsetSum(arr, target, i + 1, sumTillNow))){
                return true;
            }
            // subsetSum(arr, target, i + 1, sumTillNow);
        }
        return false;
    }
    public static void subsettwo(int[] arr, int index, ArrayList<Integer> tempArrayList, ArrayList<ArrayList<Integer>> result){
        Arrays.sort(arr);
        if(index >= arr.length){
            return;
        }
        result.add(new ArrayList<>(tempArrayList));
        for(int i = index; i < arr.length; i++){
            if(i > index && arr[i] == arr[i  - 1]) continue;
            tempArrayList.add(arr[i]);
            subsettwo(arr, i + 1, tempArrayList, result);
            tempArrayList.remove(tempArrayList.size() - 1);
        }
    }
    public static void main(String[] args){
        int[] arr = {3, 34, 4, 12, 5, 2};
        // int target = 9;
        // boolean result = subsetSum(arr, target, 0, 0);
        // int[] arr = {1, 2, 2};
        ArrayList<Integer> temArrayList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        subsettwo(arr, 0, temArrayList, result);
        System.out.println(result);
    }
}