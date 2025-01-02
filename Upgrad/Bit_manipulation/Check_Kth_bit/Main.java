import java.util.*;

public class Main {
	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
   	 
    	int n = scanner.nextInt();
    	int k = scanner.nextInt();

    	boolean result = isSetBit(n, k);
    	if (result) {
        		System.out.println("Set");
    	} else {
        		System.out.println("Not Set");
    	}
	}

	public static boolean isSetBit(int n, int k) {
        int temp = n >> k; // bring Kth bit to rightmost position
        return (temp & 1) == 1; // perform And operation with 1 to check that bit is set
	}

    public static boolean isSetBit2(int n, int k) {
        // Left shift 1 by k positions and perform bitwise AND with n
        // If the result is non-zero, the kth bit is set; otherwise, it's not set
        return ((n & (1 << k)) != 0);
	}
}