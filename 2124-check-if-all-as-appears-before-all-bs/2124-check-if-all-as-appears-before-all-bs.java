class Solution {
    public boolean checkString(String s) {
        int a_last_index = s.lastIndexOf('a');
        int b_start_index = s.indexOf('b');

        if(b_start_index == -1 || a_last_index == -1) return true; 

        return a_last_index < b_start_index ? true : false;
    }
}