class Solution {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        int first = Math.min(firstPlayer, secondPlayer);
        int second = Math.max(firstPlayer, secondPlayer);
        if (first + second == n + 1) 
            return new int[]{1, 1};
        if (n == 3 || n == 4) 
            return new int[]{2, 2};
        if (first - 1 > n - second) {
            int temp = n + 1 - first;
            first = n + 1 - second;
            second = temp;
        }
        int m = (n + 1) / 2;
        int min = n;
        int max = 1;
        if (second * 2 <= n + 1) {
            int a = first - 1;
            int b = second - first - 1;
            for (int i = 0; i <= a; i++) {
                for (int j = 0; j <= b; j++) {
                    int[] ret = earliestAndLatest(m, i + 1, i + j + 2);
                    min = Math.min(min, 1 + ret[0]);
                    max = Math.max(max, 1 + ret[1]);
                }
            }
        } else {
            int p4 = n + 1 - second;
            int a = first - 1;
            int b = p4 - first - 1;
            int c = second - p4 - 1;
            for (int i = 0; i <= a; i++) {
                for (int j = 0; j <= b; j++) {
                    int[] ret = earliestAndLatest(m, i + 1, i + j + 1 + (c + 1) / 2 + 1);
                    min = Math.min(min, 1 + ret[0]);
                    max = Math.max(max, 1 + ret[1]);
                }
            }
        }
        return new int[]{min, max};
    }
}
