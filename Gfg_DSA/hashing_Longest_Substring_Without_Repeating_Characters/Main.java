import java.util.HashMap;
import java.util.HashSet;

class Main{
    public static String longestSubstring(String s){
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0;
        int start = 0;
        int maxstart = 0;
        for(int end = 0; end < s.length(); end++){
            char c = s.charAt(end);

            while (set.contains(c)){
                set.remove(s.charAt(start));
                start++;
            }
            set.add(c);
            if (end - start + 1 > maxLength) {
                maxLength = end - start + 1;
                maxstart = start;
            }
        }
        return s.substring(maxstart, maxstart + maxLength);
    }
    public static int longestSubstring_(String s){
        HashSet<Character> hash = new HashSet<>();
        int maxlen = 0;
        for(int i = 0; i < s.length(); i++){
            int len = 0;
            hash.clear();
            for(int j = i; j<s.length(); j++){
                if(hash.contains(s.charAt(j))){
                    break;
                }
                hash.add(s.charAt(j));
                len = j - i + 1;
            }
            maxlen = Math.max(len, maxlen);
        }
        return maxlen;
    }
    public static int longest_Substring(String s){
        HashMap<Character, Integer> hash = new HashMap<>();
        int i = 0; int len = 0; int maxlen = 0;
        for (int j = 0; j < s.length(); j++){
            char corrent = s.charAt(j);
            if(hash.containsKey(corrent) && hash.get(corrent) >= i){
                i = hash.get(corrent) + 1;
            }
            hash.put(corrent, j);
            len = j - i + 1;
            maxlen = Math.max(len, maxlen);
        }
        return maxlen;
    }
    public static void main(String[] args){
        String s = "abcabcdbb";
        int result = longest_Substring(s);
        System.out.println(result);
    }
}