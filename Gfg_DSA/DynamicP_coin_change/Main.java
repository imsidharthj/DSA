import java.util.HashMap;

class Main{

    public static int util(int[] coins, int amout, HashMap<Integer, Integer> map){
        if(amout == 0) return 0;

        if(map.containsKey(amout)) return map.get(amout);
        
        int count = Integer.MAX_VALUE;

        for(int i = 0; i < coins.length; i++){
            if(coins[i] <= amout){
                int temp = util(coins, amout - coins[i], map);
                if(temp != Integer.MAX_VALUE && temp + 1 < count){
                    count = temp + 1;
                }
            }
        }
        map.put(amout, count == Integer.MAX_VALUE ? -1 : count);
        return map.get(amout);
    }

    public static int coinChange(int[] coins, int amount) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return util(coins, amount, map);
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        int result = coinChange(coins, amount);
        System.out.println("Minimum coins needed: " + result);
    }
}