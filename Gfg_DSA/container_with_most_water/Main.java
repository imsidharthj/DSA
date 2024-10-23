class Main{
    public static int mostWater(int[] arr){
        int n = arr.length;
        int max_volume = 0;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            // int volume = arr[j] * (j - i);
            int volume = Math.min(arr[i], arr[j]) * (j - i);
            max_volume = Math.max(volume, max_volume);
            if (arr[i] < arr[j]){
                i++;
            } else {
                j--;
            }
        }
        return max_volume;

        //int mexi = 0;
        //for(int i = 0; i < n; i++){
        //      for(int j = i + 1; j < n; j++){
        //          int breadth = j - i;
        //          int mini = Math.min(arr[i], arr[j]);
        //          maxi = Math.max(maxi, mini * breadth);
        //      }
        //}
        // retrun mexi;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = mostWater(height);
        System.out.println("Maximum volume of water the container can store is: " + result);
    }
}