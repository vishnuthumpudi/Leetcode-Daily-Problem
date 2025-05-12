import java.util.*;

public class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> resultSet = new TreeSet<>();

        int n = digits.length;
        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) continue; 

            for (int j = 0; j < n; j++) {
                if (j == i) continue;

                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;

                    int temp = digits[i] * 100 + digits[j] * 10 + digits[k];

                    if (temp % 2 == 0) {
                        resultSet.add(temp);
                    }
                }
            }
        }

        int[] ans = new int[resultSet.size()];
        int index = 0;
        for (int i : resultSet) {
            ans[index++] = i;
        }

        return ans;
    }
}
