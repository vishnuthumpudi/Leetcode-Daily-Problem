class Solution {
  public boolean canPartition(String s, int target) {
    if (s.equals("") && target == 0) return true;
    if (target < 0) return false;

    boolean ans = false;
    for (int i = 0; i < s.length(); i++) { // try all possible pivot points
      String left = s.substring(0, i + 1); // keep the left part
      String right = s.substring(i + 1); // recurse for right part
      int leftNum = Integer.parseInt(left);

      boolean isPossible = canPartition(right, target - leftNum);
      if (isPossible) {
        ans = true;
        break;
      }
    }
    return ans;
  }
  public int punishmentNumber(int n) {
    int sum = 0;
    for (int num = 1; num <= n; num++) {
      int sqr = num * num;
      if (canPartition(Integer.toString(sqr), num)) {
        sum += sqr;
      }
    }
    return sum;
  }
}
