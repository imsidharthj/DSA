import java.util.Scanner; 
import java.util.*;
  
class Main{ 
    static void genPW(char[] arr, int n) 
    { 
        //Write code here 
        Queue<String> queue = new LinkedList<>();
        for(char c : arr){
            queue.add(String.valueOf(c));
        }
        
        while(!queue.isEmpty()){
            String current = queue.poll();
            System.out.println(current);
            
            if(current.length() < n){
                for(char c : arr){
                    queue.add(current + c);
                }
            }
        }
    } 
  
    public static void main(String[] args) 
    { 
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        char arr[] = new char[n];
        for(int i = 0; i < n; i++)
            arr[i] = s.next().charAt(0);
        genPW(arr, n);
    }
}