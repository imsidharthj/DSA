import java.util.Arrays;
class Main{
    public static int nonDuplicateElement(int[] arr){
        int result = 0;
        for (int i = 0; i < arr.length; i++){
            result ^= arr[i];
        }
        return result;
    }
    public static int nonRepeatingElement(int[] nums){
        // int result = 0;
        // for (int i = 0; i < 32; i++){
        //     int count = 0;
        //     for (int j = 0; j < nums.length; j++){
        //         if ((nums[j] & (1 << (i))) != 0){
        //             count ++;
        //         }
        //     }
        //     System.out.println(count);
        //     if(count % 3 != 0){
        //         result = ((1 << i) | result);
        //     }
        // }
        // return result;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i = i+3){
            if (nums[i] != nums[i-1]){
                return nums[i - 1];
            }
        }
        return nums[nums.length-1];
    }

    public static int bucketsElement(int[] arr){
        // int [] ones = new int[arr.length];
        // int [] twos = new int[arr.length];
        int ones = 0, twos = 0;
        for (int i = 0; i < arr.length; i++){
            ones = (ones ^ arr[i]) & ~ twos;
            twos = (twos ^ arr[i]) & ~ ones;
        }
        return ones;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 2, 1, 4, 3};
        int[] arr2 = {1, 4, 3, 2, 4, 1, 3, 4, 1, 3};
        int[] arr3 = {2, 2, 3, 2};
        int uniqueElement = nonDuplicateElement(arr1);
        int duplicateElement = nonRepeatingElement(arr2);
        int bucketResult = bucketsElement(arr3);
        System.out.println("The non-duplicate element is: " + uniqueElement);
        System.out.println("The non-duplicate element is: " + duplicateElement);
        System.out.println("The non-repeating element using bucket method is: " + bucketResult);
    }
}