class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        pos = [num for num in nums if num > 0]
        neg = [num for num in nums if num < 0]
        sol = []

        for i in range(len(pos)):
            sol.append(pos[i])
            sol.append(neg[i])
        
        return sol
        