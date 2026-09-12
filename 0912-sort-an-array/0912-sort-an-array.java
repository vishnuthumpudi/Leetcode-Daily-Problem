class Solution {
   public int[] sortArray(int[] nums) {
      int n = nums.length;
      if(n == 1) return nums;
      mergeSort(nums, 0, n - 1);
      return nums;
   }
   
   private void mergeSort(int[] nums, int low, int high) {
      if(low >= high) return;
      int mid = low + (high - low) / 2;
      mergeSort(nums, low, mid);
      mergeSort(nums, mid + 1, high);
      merge(nums, low, mid, high);
   }
   
   private void merge(int[] nums, int low, int mid, int high) {
      List<Integer> list = new ArrayList<>();
      int left = low;
      int right = mid + 1;
      while(left <= mid && right <= high) {
	  if(nums[left] <= nums[right]) {
	     list.add(nums[left]);
	     left++;	
	   } else {
	    list.add(nums[right]);
	    right++;
	 }
      }
      while(left <= mid) {
	 list.add(nums[left]);
	 left++;
      }
      while(right <= high) {
	 list.add(nums[right]);
	 right++;
      }
      
      for(int i = low; i <= high; i++) {
	 nums[i] = list.get(i - low);
      }
   }
}