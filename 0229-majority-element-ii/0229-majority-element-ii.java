class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int elementOne = 0, countOne = 0, elementTwo = 0, countTwo = 0;

        for(int i = 0; i < n; i++) {
            if(countOne == 0 && elementTwo != nums[i]) {
                elementOne = nums[i];
                countOne = 1;
            } else if (countTwo == 0 && elementOne != nums[i]) {
                elementTwo = nums[i];
                countTwo = 1;
            } else if (elementOne == nums[i]) {
                countOne++;
            } else if (elementTwo == nums[i]) {
                countTwo++;
            } else {
                countOne--;
                countTwo--;
            }
        }

        int countOfElementOne = 0;
        int countOfElementTwo = 0;

        for(int i = 0; i < n; i++) {
            if(elementOne == nums[i]) {
                countOfElementOne++;
            } else if (elementTwo == nums[i]) {
                countOfElementTwo++;
            }
        }

        if(countOfElementOne > (n / 3)) {
            result.add(elementOne);
        } 
        
        if (countOfElementTwo > (n / 3) && elementTwo != elementOne) {
            result.add(elementTwo);
        }

        return result;
    }
}