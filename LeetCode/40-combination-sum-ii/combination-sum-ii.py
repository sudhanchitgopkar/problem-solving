class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        vals = [(val, freq) for val, freq in Counter(candidates).items()]
        sol = []

        def backtrack(curr_i, curr_sum, curr_list):
            if curr_sum == target:
                sol.append(curr_list)
                return
            elif curr_i == len(vals):
                return
            elif curr_sum > target:
                return

            for i in range(vals[curr_i][1]):
                curr_list.append(vals[curr_i][0])
                
            for _ in range(vals[curr_i][1]):
                backtrack(curr_i + 1, sum(curr_list), curr_list.copy())
                curr_list.pop()
            backtrack(curr_i + 1, curr_sum, curr_list.copy())

        backtrack(0, 0, [])

        return sol




            
