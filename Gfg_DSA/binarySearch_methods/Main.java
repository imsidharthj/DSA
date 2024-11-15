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
    public static void main(String[] args){
        // int number = 64;
        // int times = 3;
        // int sqrt = squreRootTwo(times, number);
        // System.out.println(sqrt);

        int[] piles = {3, 6, 7, 11};
        int time = 8;
        int speed = kokoEatingBananas(piles, time);
        System.out.println(speed);
    }
}