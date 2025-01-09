class Solution {
    public int prefixCount(String[] words, String pref) {
        int res = 0;
        for(String str : words){
            if(str.startsWith(pref)) res++;
        }
        return res;
    }
}
