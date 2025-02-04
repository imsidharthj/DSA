import java.util.*;
 
public class Main
{
    static int nobleNum(int arr[], int n)
    {
        Arrays.sort(arr);
        for(int i = 0; i < n; i++){
            int element = arr[i];
            int count = n - (i + 1);
            if(count == element){
                return 1;
            }
        }
        return -1;
    }
    
    public static void main(String args[])
    {
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = s.nextInt();
 
        System.out.println(nobleNum(arr, n) + "\n" );
    }
}