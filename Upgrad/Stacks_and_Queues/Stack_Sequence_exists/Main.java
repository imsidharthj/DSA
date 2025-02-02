import java.util.Scanner;
import java.util.Stack;
import java.util.*;

public class Main {

    public static Boolean contains(Stack<Integer> sequence1, Stack<Integer> sequence2) {
        // This block will be filled by the student
        // Stack<Integer> tempStack = new Stack<>();
        // tempStack.addAll(sequence2);
        // Set<Integer> set = new HashSet<>(tempStack);
        // for(Integer element: sequence1){
        //     if(!set.contains(element)){
        //         return false;
        //     }
        // }
        // return true;
        List<Integer> list1 = new ArrayList<>(sequence1);
        List<Integer> list2 = new ArrayList<>(sequence2);
        int index = 0;
        for (int num : list2) {
            if (index < list1.size() && num == list1.get(index)) {
                index++;
            }
            if (index == list1.size()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();
        Stack<Integer> sequence1 = new Stack<Integer>();
        Stack<Integer> sequence2 = new Stack<Integer>();
        for (String elem1 : line1.split(" ")) {
            sequence1.add(Integer.parseInt(elem1));
        }
        for (String elem2 : line2.split(" ")) {
            sequence2.add(Integer.parseInt(elem2));
        }
        Boolean isSubsequence = contains(sequence1, sequence2);
        System.out.println(isSubsequence);
    }
}
