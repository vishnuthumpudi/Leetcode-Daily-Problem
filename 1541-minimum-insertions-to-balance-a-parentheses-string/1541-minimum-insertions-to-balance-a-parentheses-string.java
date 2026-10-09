class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int open = 0;   // unmatched '(' so far
        int i = 0, n = s.length();

        while (i < n) {
            if (s.charAt(i) == '(') {
                open++;
                i++;
            } else {
                // we have a ')', it needs a partner ')' right after it
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i += 2;             // got "))"
                } else {
                    insertions++;       // lone ')', insert one more ')'
                    i++;
                }

                // this "))" must close some '('
                if (open > 0) {
                    open--;
                } else {
                    insertions++;       // no '(' available, insert a '('
                }
            }
        }
        return insertions + open * 2;
    }
}