import java.util.*;

class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int n = nums.length;
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] % 2 == 0 ? b : -a);
        }

        return mergeSort(prefix, 0, n);
    }

    private int mergeSort(int[] arr, int low, int high) {
        if (low >= high) return 0;

        int mid = low + (high - low) / 2;
        int count = mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);
        return count;
    }

    // count pairs (left in [low, mid], right in [mid+1, high]) with arr[left] >= arr[right]
    private int countPairs(int[] arr, int low, int mid, int high) {
        int count = 0;
        int right = mid + 1;

        for (int left = low; left <= mid; left++) {
            while (right <= high && arr[right] <= arr[left]) {
                right++;
            }
            count += right - (mid + 1);
        }

        return count;
    }

    private void merge(int[] arr, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) temp.add(arr[left++]);
            else temp.add(arr[right++]);
        }
        while (left <= mid) temp.add(arr[left++]);
        while (right <= high) temp.add(arr[right++]);

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
}