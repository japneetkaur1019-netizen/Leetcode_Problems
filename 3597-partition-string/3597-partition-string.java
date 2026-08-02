class Solution {
    public List<String> partitionString(String s) {
        HashSet<String> seen = new HashSet<>();
        List<String> ans = new ArrayList<>();
        StringBuilder curr = new StringBuilder();

        for (char ch : s.toCharArray()) {
            curr.append(ch);

            String str = curr.toString();

            if (!seen.contains(str)) {
                seen.add(str);
                ans.add(str);
                curr.setLength(0);
            }
        }

        return ans;
    }
}