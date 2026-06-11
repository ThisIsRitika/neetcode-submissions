class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded=new StringBuilder();

        for(String str : strs){
            String len = String.valueOf(str.length());

            encoded.append(len);
            encoded.append("#");
            encoded.append(str);
        }

        return encoded.toString();

    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {

            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }

            int len = Integer.parseInt(str.substring(i, j));

            String word = str.substring(j + 1, j + 1 + len);

            res.add(word);

            i = j + 1 + len;
        }

        return res;
    }
}
