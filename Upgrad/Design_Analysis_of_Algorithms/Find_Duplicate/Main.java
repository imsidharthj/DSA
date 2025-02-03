import java.util.Scanner;
import java.util.HashSet;
 
public class Main
{
    static int duplicate(int arr[], int n)
    {
        //Write code here
        // for(int i = 0; i < n; i++){
        //     if(arr[i] == arr[i + 1]){
        //         return arr[i];
        //     }
        // }
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            if(set.contains(arr[i])){
                return arr[i];
            }
            set.add(arr[i]);
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
 
        System.out.println(duplicate(arr, n));
    }
}