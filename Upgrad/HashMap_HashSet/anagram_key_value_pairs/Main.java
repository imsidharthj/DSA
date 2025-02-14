import java.util.*;
import java.util.Map.Entry;

public class Main{
	//Method to check if two strings are anagram of each other or not
	public static boolean check(String str1, String str2){
		char[] ch1 = str1.toLowerCase().toCharArray();
		char[] ch2 = str2.toLowerCase().toCharArray();
		//Write your code here
		arrange(ch1);
		arrange(ch2);
		return Arrays.equals(ch1, ch2);
	}
	//Method to sort the character array
	public static void arrange(char[] ch){
		//Write your code here
		Arrays.sort(ch);
	}
	
	public static void main(String[] x){
		Map<String,String> map = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String key;
		String value;
		for(int i = 1; i <= num; i++){
			key = sc.next();
			value = sc.next();
			map.put(key,value);
		}
		//Write your code here
		boolean anagramFound = false;
        for (Entry<String, String> entry : map.entrySet()) {
          if (check(entry.getKey(), entry.getValue())) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
            anagramFound = true;
          }
        }
        if (!anagramFound) {
          System.out.println("false");
        }
	}
}
