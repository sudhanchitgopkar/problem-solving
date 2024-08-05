class Solution:
    def kthDistinct(self, arr: List[str], k: int) -> str:
        freq = {}
        for string in arr:
            freq[string] = freq.get(string, 0) + 1
        
        for string, frequency in freq.items():
            if frequency == 1:
                k -= 1
            if k == 0:
                return string
        
        return ''

        