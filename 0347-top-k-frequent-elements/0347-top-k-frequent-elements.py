class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        #create our buckets
        buckets = [[] for i in range(len(nums) + 1)]
        #create freq map
        freq = {}
        #make sol list
        sol = []
        
        #calculate frequencies
        for num in nums:
            if num in freq:
                freq[num] = freq[num] + 1
            else:
                freq[num] = 1
                
        #put freqs into buckets
        for num in freq:
            buckets[freq[num]].append(num)
        
        for i in range(len(buckets) - 1, -1, -1):
            for num in buckets[i]:
                sol.append(num)
            if len(sol) == k:
                return sol
                
            
        
        
        

# 1 -> 2
# 2 -> 3
# 3 -> 2

# [ ] [ ] [1, 3] [2] 
#  0   1   2      3
        