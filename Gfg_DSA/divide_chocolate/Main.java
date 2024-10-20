//Input : sweetness = [1, 2, 3, 4, 5, 6, 7, 8, 9], k = 5;
//Output: 6
//Explaination: you can divide the chocolate to [1, 2, 3], [4, 5], [6], [7], [8], [9]

import java.util.Scanner;

class Main {

    // Function to check if it's possible to divide chocolate into k pieces
    // with a minimum sweetness level
    public boolean findPieces(int[] chocolate, int k, int sweetness) {
        int currentSum = 0;
        int count = 0;

        // Iterate through the array of chocolate sweetness chunks
        for (int chunk : chocolate) {
            currentSum += chunk;

            // If the current sum of sweetness exceeds or equals the target sweetness
            if (currentSum >= sweetness) {
                count++; // We can form one piece
                currentSum = 0; // Reset the current sum for the next piece
            }
        }
        // Return whether we can divide the chocolate into at least k pieces
        return count >= k;
    }

    // Function to find the maximum possible sweetness level that can be shared
    public int maximizeSweetness(int[] sweetness, int k) {
        int low = 1;
        int high = 0;

        // Calculate the sum of all sweetness
        for (int sweet : sweetness) {
            high += sweet;
        }

        int bestSweetness = 0;

        // Binary search to find the maximum minimum sweetness we can achieve
        while (low <= high) {
            int mid = (low + high) / 2;

            if (findPieces(sweetness, k + 1, mid)) {
                bestSweetness = mid; // Mid value is a valid solution, try for higher sweetness
                low = mid + 1;
            } else {
                high = mid - 1; // Try smaller sweetness
            }
        }

        return bestSweetness;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of chocolate chunks:");
        int n = scanner.nextInt();
        int[] chocolate = new int[n];

        System.out.println("Enter the sweetness values of the chocolate chunks:");
        for (int i = 0; i < n; i++) {
            chocolate[i] = scanner.nextInt();
        }
        System.out.println("Enter the number of people (k):");
        int k = scanner.nextInt();
        Main mainClass = new Main();
        int result = mainClass.maximizeSweetness(chocolate, k);
        System.out.println("The maximum possible sweetness that can be divided equally is: " + result);

        scanner.close();
    }
}
