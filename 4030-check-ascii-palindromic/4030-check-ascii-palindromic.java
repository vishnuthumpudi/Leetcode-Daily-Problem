class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder binary = new StringBuilder();

        for (char c : s.toCharArray()) {
            String binaryString = String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0');
            binary.append(binaryString);
        }

        if(isPalindrome(binary.toString())) {
            return true;
        }

        return false;
        
    }

    private boolean isPalindrome(String binary_seq) {
        int left = 0;
        int right = binary_seq.length() - 1;

        while(left < right) {
            if(binary_seq.charAt(left) != binary_seq.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}