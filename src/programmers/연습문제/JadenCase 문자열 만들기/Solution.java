import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        
        for(char c : s.toLowerCase().toCharArray()) {
            c = first ? Character.toUpperCase(c) : c;
            first = Character.isWhitespace(c) ? true : false;
            
            sb.append(c);
        }
        return sb.toString();
    }
}
