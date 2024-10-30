import java.util.ArrayList;
class Main{
    public static void printSubsequences(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < (2^n); i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (2 ^ j)) != 0) {
                    System.out.print(arr[j] + " ");
                }
            }
            System.out.println();
        }
    }
    public static void subSequences(int[] arr){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Boolean[] sequence = new Boolean[arr.length];
        generateSubsequences(arr, sequence, 0, result);
        for (ArrayList<Integer> subSequence : result) {
            System.out.println(subSequence);
        }
    }
    public static void generateSubsequences(int[] arr, Boolean[] sequence, int index, ArrayList<ArrayList<Integer>> result){
        if(index == arr.length){
            ArrayList<Integer> subSequence = new ArrayList<>();
            for(int i = 0; i < arr.length; i++){
                if(sequence[i]){
                    subSequence.add(arr[i]);
                }
            }
            result.add(subSequence);
            return;
        }
        sequence[index] = true;
        generateSubsequences(arr, sequence, index+1, result);

        sequence[index] = false;
        generateSubsequences(arr, sequence, index+1, result);
    }
    public static void util(int[] arr, int index, ArrayList<Integer> tempArrayList, ArrayList<ArrayList<Integer>> result){
        if(index == arr.length){
            result.add(new ArrayList<>(tempArrayList));
            return;
        }
        tempArrayList.add(arr[index]);
        util(arr, index + 1, tempArrayList, result);
        tempArrayList.remove(tempArrayList.size() - 1);
        util(arr, index + 1, tempArrayList, result);
    }
    public static void sumSubSequence(int[] arr, int index, int target, int sumTillNow, ArrayList<Integer> tempArrayList, ArrayList<ArrayList<Integer>> result){
        if(sumTillNow == target){
            result.add(new ArrayList<>(tempArrayList));
            return;
        }
        if(index >= arr.length){
            return;
        }
        tempArrayList.add(arr[index]);
        sumSubSequence(arr, index + 1, target, sumTillNow + arr[index], tempArrayList, result);
        tempArrayList.remove(tempArrayList.size() - 1);
        sumSubSequence(arr, index + 1, target, sumTillNow, tempArrayList, result);
    }
    public static boolean singleSumSubSequence(int[] arr, int index, int target, int sumTillNow, ArrayList<Integer> tempArrayList){
        if (index == arr.length) {
            if (sumTillNow == target) {
                System.out.println(tempArrayList);
                return true;
            }
            return false;
        }
        tempArrayList.add(arr[index]);
        if (singleSumSubSequence(arr, index + 1, target, sumTillNow + arr[index], tempArrayList)) {
            return true;
        }
        tempArrayList.remove(tempArrayList.size() - 1);
        if (singleSumSubSequence(arr, index + 1, target, sumTillNow, tempArrayList)) {
            return true;
        }
        return false;
    }
    public static void main(String [] args){
        // int n = 3;
        // int[] arr = {1, 2, 3, 4, 5};
        // // subSequences(arr);
        // int[] arr2 = {3, 1, 2};
        int n = 2;
        int[] arr = {1, 2, 1};
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> tempArrayList = new ArrayList<>();
        // sumSubSequence(arr, 0, n, 0, tempArrayList, result);
        for (ArrayList<Integer> subSequence : result) {
            System.out.println(subSequence);
        }
        singleSumSubSequence(arr, 0, n, 0, tempArrayList);
    }
}