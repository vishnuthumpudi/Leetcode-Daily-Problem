class Solution {
    public int minSteps(String s, String t) {
        int[] count = new int[26];
        byte[] sb = s.getBytes(), tb = t.getBytes();
        for (byte b : sb) {
          count[b - 'a']++;
        }
        for (byte b : tb) {
          count[b - 'a']--;
        }
        int res = 0;
        for (int i : count) {
          res += Math.abs(i);
        }
        return res / 2;
    }
}