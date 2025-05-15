class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> output = new ArrayList<>();

        int prev = groups[0];
        output.add(words[0]);

        for(int i = 1; i < words.length; i++) {
            if(groups[i] != prev) {
                prev = groups[i];
                output.add(words[i]);
            }
        }

        return output;
    }
}
