class Main{
    public static int maxProfit(int[] arr){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < minPrice){
                minPrice = arr[i];
            } else if (arr[i] - minPrice > maxProfit){
                maxProfit = arr[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static int maxProfit_2(int[] arr){
        int maxProfit = 0;
        if(arr.length <= 1) return 0;
        int i = 0;
        int n = arr.length;
        while (i < n) {
            while (i < n && arr[i + 1] <= arr[i]) {
                i++;
            }
            int buy = i;
            i++;
            while (i < n && arr[i] > arr[i - 1]) {
                i++;
            }
            int sell = i - 1;
            maxProfit += (arr[sell] - arr[buy]);
        }
        return maxProfit;
        // int minPrice = 0;
        // for (int i = 0; i < arr.length; i++){
        //     if (arr[i] < minPrice){
        //         minPrice = arr[i];
        //     }
        //     int profit = arr[i] - minPrice;
        //      if (profit > maxProfit) {
        //          maxProfit = profit;
        //      }
        // }
        // return maxProfit;
    }

    public static void main(String[] args){
        int[] arr = {5, 6, 9, 1, 2, 3, 4, 2, 3, 7};
        int profit = maxProfit(arr);
        int profit2 = maxProfit_2(arr);
        System.out.println("Maximum Profit: " + profit);
        System.out.println("Maximum Profit: " + profit2);
    }
}