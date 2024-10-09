public class Main {
    public static void main(String[] args) {
        Generate generate = new Generate();
        int[] arr = {3, 4, 5, 6, 7, 1, 2, 2, 2, 3, 3};
        int result = generate.countOccurence(arr);
        System.out.println("Minimum element in the rotated array: " + result);
    }
}

class Generate {
    public int countOccurence(int[] arr) {
        int l = 0;
        int h = arr.length - 1;
        int answer = Integer.MAX_VALUE;
        
        while (l <= h) {
            int mid = (l + h) / 2;
            // if (arr[l] <= arr[h]) {
            //     answer = Math.min(answer, arr[l]);
            //     break;
            // }
            if (arr[l] <= arr[mid]) {
                answer = Math.min(answer, arr[l]);
                l = mid + 1;
            } 
            // If the right half is sorted
            else {
                answer = Math.min(answer, arr[mid]);
                h = mid - 1;
            }
        }
        return answer;
    }
}