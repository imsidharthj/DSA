import java.util.Arrays;

class Main{
    public static int squreRoot(int n){
        int low = 1; int high = n;
        int sqrt = 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if(mid * mid <= n){
                sqrt = mid;
                low = mid + 1;
            } else { 
                high = mid - 1;
            }
        }
        return sqrt;
    }
    public static int squreRootTwo(int times, int number){
        int low = 1; 
        int high = number;
        int answer = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            double power = Math.pow(mid, times);
            if(power == number){
                return mid;
            } else if(power < number){
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }
    public static int kokoEatingBananas(int[] piles, int time){
        int speed = 1;
        int totalTime = 0;
        int k = 0;
        while(k < piles.length){
            totalTime += Math.ceil((double)piles[k] / speed);
            if(totalTime > time){
                speed++;
                totalTime = 0;
                k = 0;
            }
            k++;
        }
        return speed;
    }
    public static int kokoEatingBananasTwo(int[] piles, int time){
        int low = 1; int high = Arrays.stream(piles).max().getAsInt();
        // int result = Integer.MAX_VALUE;
        while (low < high) {
            int midSpeed = (low + high) / 2;
            double totalTime = 0;
            for(int pile : piles){
                totalTime += Math.ceil((double)pile / midSpeed);
            }
            if(totalTime <= time){
                // result = midSpeed;
                high = midSpeed - 1;
            } else {
                low = midSpeed + 1;
            }
        }
        return low;
    }
    public static boolean minimumNumberDaysMakeBouquets(int[] bloomDay, int m, int k, int day){
        int n = bloomDay.length;
        if(n < (m * k)){
            return false;
        }
        int count = 0;
        int bouquets = 0;
        for(int i = 0; i < n; i++){
            if(bloomDay[i] <= day){
                count++;
                if (count == k) {
                    bouquets++;
                    count = 0;
                }
            } else {
                count = 0;
            }
            bouquets += (count/k);
        }
        return bouquets >= m;
    }
    public static int possibleDays(int []bloomDay, int m, int k){
        int n = bloomDay.length;
        if (n < (m * k)) {
            return -1;
        }
        int low = 1;
        int high = Arrays.stream(bloomDay).max().getAsInt();
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (minimumNumberDaysMakeBouquets(bloomDay, m, k, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
    public static void main(String[] args){
        // int number = 64;
        // int times = 3;
        // int sqrt = squreRootTwo(times, number);
        // System.out.println(sqrt);

        // int[] piles = {30,11,23,4,20};
        // int time = 6;
        // int speed = kokoEatingBananasTwo(piles, time);
        // System.out.println(speed);

        int []bloomDay = {1,10,3,10,2};
        int m = 3; int k = 1;
        int bouquets = possibleDays(bloomDay, m, k);
        System.out.println(bouquets);
    }
}