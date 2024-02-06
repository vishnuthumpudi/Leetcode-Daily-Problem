class Solution {
    List<List<String>> result;
    public List<List<String>> groupAnagrams(String[] strs) {
        result = new ArrayList<>(); 
        HashMap<Double, List<String>> map = new HashMap<>(); 

        for(int i = 0; i < strs.length; i++){
            String s = strs[i]; 
            double prime = primePro(s);
            if(!map.containsKey(prime))
                map.put(prime, new ArrayList<>());
            map.get(prime).add(s);
        }

        return new ArrayList<>(map.values());
    }

    private double primePro(String s){
        double res = 1d; 
        int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int p = primes[c - 'a']; 
            res = res * p; 
        }
        return res; 
    }
}
