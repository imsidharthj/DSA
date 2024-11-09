import java.util.Arrays;

public class Main {
    public static int maxHappy(int n, int[] bags, int m, int[] requirement) {
        int count = 0;
        boolean[] happy = new boolean[m];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (bags[j] >= requirement[i]){
                    happy[i] = true;
                    break;
                }
            }
        }
        
        System.out.println(Arrays.toString(happy));
        
        for (int k = 0; k < m; k++) {
            if (happy[k]) {
                count++;
            }
        }
        
        return count;
    }
    public static int maxHappyTwo(int n, int[] bags, int m, int[] requirement){
        Arrays.sort(bags); Arrays.sort(requirement);
        int happyStudent = 0;
        int i = 0; int j = 0;
        while (bags[i] >= requirement[i]){
            happyStudent += 1;
            j += 1;
        }
        i += 1;
        return happyStudent;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] bags = {4, 5, 6, 7, 8};
        int m = 3;
        int[] requirement = {5, 6, 10};
        System.out.println("Max Happy: " + maxHappy(n, bags, m, requirement));
        System.out.println("Max Happy: " + maxHappyTwo(n, bags, m, requirement));
    }
}