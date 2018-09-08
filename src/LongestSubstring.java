// P1. Given a string, find the length of the longest substring without repeating characters.

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int visited[] = new int [s.length()];
        int curLen = 1;
        int maxLen = 1;
        int i = 0;
        int previous;

        for (i = 0; i < s.length(); i++) {
            visited[i] = -1;
        }

        visited[s.charAt(0)] = 0;
        for (i=1; i<s.length(); i++) {
            previous = visited[s.charAt(i)];
            if (previous == -1 || i-curLen > previous) {
                curLen ++;
            } else {
                if (curLen > maxLen) {
                    maxLen = curLen;
                }
                curLen = i - previous;
            }
            visited[s.charAt(i)] = i;
        }
        if (curLen > maxLen) {
            maxLen = curLen;
        }
        return maxLen;
    }
}
