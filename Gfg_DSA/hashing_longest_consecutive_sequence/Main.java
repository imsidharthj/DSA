import java.util.*;
class Main{
    public static int longestSequence_(ArrayList<Integer> arr){
        int min = Collections.min(arr);
        ArrayList<Integer> result = new ArrayList<>();
        result.add(min);
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i) == (min + 1)){
                result.add(arr.get(i));
                min = arr.get(i);
            }
        }
        return result.size();
    }
    public static int longestSequence(int[] arr){
        HashSet<Integer> numbers = new HashSet<>();
        for (int num : arr) {
            numbers.add(num);
        }
        int result = 0;
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(!numbers.contains(arr[i] - 1)){
                int correntElement = arr[i];
                count = 1;
                while(numbers.contains(correntElement + 1)){
                    correntElement++;
                    count++;
                }
                result = Math.max(count, result);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("Output: " + longestSequence(nums));
    }
}