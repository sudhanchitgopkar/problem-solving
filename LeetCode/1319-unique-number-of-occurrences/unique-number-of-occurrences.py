class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        freq = {}

        for val in arr:
            if val not in freq:
                freq[val] = 1
            else:
                freq[val] += 1
        
        return len(set(freq.values())) == len(freq.values())