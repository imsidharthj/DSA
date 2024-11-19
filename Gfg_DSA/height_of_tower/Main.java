import java.util.ArrayList;
import java.util.Scanner;

class Main{
    public static int heightTower(int n, int k, int[] arr){
        ArrayList<Integer> tower = new ArrayList<>();
        int tHeight = 0;
        int eCount = 0;
        for(int height : arr){
            tower.add(height);
            tHeight += height;
            if (tHeight > k) {
                eCount++;
                for (int j = 0; j < eCount && !tower.isEmpty(); j++) {
                    tHeight -= tower.get(tower.size() - 1);
                    tower.remove(tower.size() - 1);
                }
            }
        }
        return tHeight;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of test cases: ");
        int t = scanner.nextInt();
        while (t-- > 0) {
            System.out.println("Enter length of array: ");
            int n = scanner.nextInt();
            System.out.println("Enter max allowable height: ");
            int k = scanner.nextInt();
            int [] arr = new int[n];
            for(int i = 0; i < n; i++){
                System.out.println("Enter heights: ");
                arr[i] = scanner.nextInt();
            }
            int result = heightTower(n, k, arr);
            System.out.println(result);
        }
    }
}