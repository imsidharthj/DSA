import java.util.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int i = 0; i < T; i++){
            int N = scanner.nextInt();
            int height = (int) Math.ceil((Math.sqrt(8 * (long) N + 1) - 1) / 2);
            if ((height * (height + 1)) / 2 == N)
                System.out.println(height);
            else
                System.out.println(height - 1);
        }
	}
}
