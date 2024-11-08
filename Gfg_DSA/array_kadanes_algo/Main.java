class Main{
    public static int maxSum(int[] arr){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if (sum < 0){
                sum = 0;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
    public static void main(String[] args){
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int result = maxSum(arr);
        System.out.println(result);
    }
}