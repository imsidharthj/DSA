import java.util.*;

public class Main {
	  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
   	    int n = scanner.nextInt();
    	int result = countSetBits(n);
    	System.out.println(result);
	}

  	public static int countSetBits(int n) {
        int count = 0;
        while(n > 0){
            if((n & 1) != 0){
                count++;
            }
            n >>= 1;
        }
        return count;
    }
}