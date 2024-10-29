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
    public static void main(String [] args){
        int n = 3;
        int[] arr = {1, 2, 3, 4, 5};
        // subSequences(arr);
        int[] arr2 = {3, 1, 2};
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> tempArrayList = new ArrayList<>();
        util(arr2, 0, tempArrayList, result);
        for (ArrayList<Integer> subSequence : result) {
            System.out.println(subSequence);
        }
    }
}