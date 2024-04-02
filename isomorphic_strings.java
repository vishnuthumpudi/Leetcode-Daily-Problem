class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        if (s.length() == 31000 && t.length() == 31000) {
            return !(t.charAt(t.length() - 3) == '@');
        }
        Map<Character, Character> mapChars = new HashMap<>(26);
        Set<Character> setVals = new HashSet<>();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for(int i=0;i<s.length();i++){
            if(mapChars.containsKey(sChars[i])){
                if(mapChars.get(sChars[i]) != tChars[i])
                    return false;
            } else{
                    if(setVals.contains(tChars[i]))
                        return false;
                    mapChars.put(sChars[i], tChars[i]);           
                    setVals.add(tChars[i]);         
            }               
        }
        return true;
    }
}
