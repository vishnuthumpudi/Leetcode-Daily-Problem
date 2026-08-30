class Solution {
    public int countSpecialIntegers(int[] A) {
        int[] cnt = new int[101];
        int res = 0, n = A.length;
        for (int i = 0; i < A.length; i++)
            if (i == 0 || A[i] != A[i - 1])
                cnt[A[i]]++;
        for (int c : cnt)
            if (c == 1)
                res++;
        return res;
    }
}