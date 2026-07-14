class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        int minLen = Integer.MAX_VALUE;
        int stIdx = 0;

        for (int i = 0; i < m; i++) {

            HashMap<Character, Integer> map = new HashMap<>();

            for (int k = 0; k < n; k++) {
                map.put(t.charAt(k), map.getOrDefault(t.charAt(k), 0) + 1);
            }

            int count = 0;

            for (int j = i; j < m; j++) {

                char ch = s.charAt(j);

                if (map.getOrDefault(ch, 0) > 0) {
                    count++;
                }

                map.put(ch, map.getOrDefault(ch, 0) - 1);

                if (count == n) {
                    if (j - i + 1 < minLen) {
                        minLen = j - i + 1;
                        stIdx = i;
                    }
                    break;
                }
            }
        }

        if (minLen == Integer.MAX_VALUE)
            return "";

        return s.substring(stIdx, stIdx + minLen);
    }
}