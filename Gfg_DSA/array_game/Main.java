import java.util.*;

class Solution {
    public int minOperations(int n, int[] arr, int[] brr) {
        int count = 0;
        LinkedList<Integer> listA = new LinkedList<>();
        LinkedList<Integer> listB = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            listA.add(arr[i]);
            listB.add(brr[i]);
        }

        while (!listA.isEmpty()) {
            if (listA.getFirst().equals(listB.getFirst())) {
                // Remove the first element of both lists
                listA.removeFirst();
                listB.removeFirst();
            } else {
                // Rotate the first element of listA to the end
                int temp = listA.removeFirst();
                listA.addLast(temp);
            }
            count++;
        }

        return count;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            int[] arr = new int[n];
            int[] brr = new int[n];

            // Input for arr
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // Input for brr
            for (int i = 0; i < n; i++) {
                brr[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            int result = obj.minOperations(n, arr, brr);

            System.out.println(result);
            System.out.println("~");
        }

        sc.close();
    }
}
