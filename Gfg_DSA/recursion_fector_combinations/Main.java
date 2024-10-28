import java.util.ArrayList;
import java.util.Arrays;

class Main{
    public static void findFectorsCombinations(int start, int target, int product, ArrayList<Integer> tempArrayList, ArrayList<ArrayList<Integer>> result){
        if(product > target) return;
        if(product == target){
            result.add(new ArrayList<>(tempArrayList));
            return;
        }
        for(int i = start; i < (target/2) + 1; i++){
            if(target % i == 0){
                tempArrayList.add(i);
                findFectorsCombinations(i, target, product * i, tempArrayList, result);
                tempArrayList.remove(tempArrayList.size() - 1);
            }
        }
    }
    public static ArrayList<ArrayList<Integer>> util(int target){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        findFectorsCombinations(2, target, 1, new ArrayList<>(), result);
        return result;
    }
    public static void main(String[] args) {
        int target = 12;
        ArrayList<ArrayList<Integer>> result = util(target);
        System.out.println("Factor combinations for " + target + " are: " + result);
    }
}