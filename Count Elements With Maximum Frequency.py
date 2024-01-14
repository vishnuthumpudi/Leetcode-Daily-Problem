class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        frequency_counter = Counter(nums)
    
        # Find the maximum frequency
        max_frequency = max(frequency_counter.values(), default=0)

        # Calculate the total frequencies of elements with maximum frequency
        total_frequency = sum(freq for freq in frequency_counter.values() if freq == max_frequency)

        return total_frequency
