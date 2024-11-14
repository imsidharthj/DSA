class Main{
    public static int longestSumArray(int[] arr, int k) {
        int i = 0, j = 0, maxLength = 0, sum = 0;
        int length = arr.length;
    
        while (j < length) {
            sum += arr[j];
            while (sum > k) {
                sum -= arr[i];
                i++;
            }
            if (sum <= k) {
                maxLength = Math.max(maxLength, j - i + 1);
            }
            j++;
        }
        return maxLength;
    }    
    public static void main(String[]args){
        int[] arr = {2, 5, 1, 10, 10};
        int k = 14;
        int maxLength = longestSumArray(arr, k);
        System.out.println(maxLength);
    }
}