class Solution {
    private static final double TARGET = 24.0;
    private static final double EPSILON = 1e-6; 

    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int card : cards) {
            nums.add((double) card);
        }

        return solve(nums);
    }

    private boolean solve(List<Double> nums) {
        // Base Case: If only one number left, check if it's close to 24
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - TARGET) < EPSILON;
        }

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i == j) continue;
                double num1 = nums.get(i);
                double num2 = nums.get(j);

                // Create a new list with the remaining numbers (excluding num1 and num2)
                List<Double> nextNums = new ArrayList<>();
                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j) {
                        nextNums.add(nums.get(k));
                    }
                }

                nextNums.add(num1 + num2);
                if (solve(nextNums)) return true;
                nextNums.remove(nextNums.size() - 1); 

                nextNums.add(num1 - num2);
                if (solve(nextNums)) return true;
                nextNums.remove(nextNums.size() - 1);

                nextNums.add(num1 * num2);
                if (solve(nextNums)) return true;
                nextNums.remove(nextNums.size() - 1);

                // avoid division by zero
                if (Math.abs(num2) > EPSILON) {
                    nextNums.add(num1 / num2);
                    if (solve(nextNums)) return true;
                    nextNums.remove(nextNums.size() - 1);
                }
            }
        }
        
        return false;
    }
}
