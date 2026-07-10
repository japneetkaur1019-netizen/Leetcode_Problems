class Solution {
    public List<String> commonChars(String[] words) {
        HashMap<Character, Integer> map=new HashMap<>();
        for(char ch:words[0].toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for (int i = 1; i < words.length; i++) {

            HashMap<Character, Integer> temp = new HashMap<>();

            for (char ch : words[i].toCharArray()) {
                temp.put(ch, temp.getOrDefault(ch, 0) + 1);
            }

            // Update minimum frequency
            for (char ch : new HashSet<>(map.keySet())) {

                if (!temp.containsKey(ch)) {
                    map.remove(ch);
                } else {
                    map.put(ch, Math.min(map.get(ch), temp.get(ch)));
                }
            }
        }

        List<String> ans = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            char ch = entry.getKey();
            int freq = entry.getValue();

            while (freq-- > 0) {
                ans.add(String.valueOf(ch));
            }
        }

        return ans;
    }
}