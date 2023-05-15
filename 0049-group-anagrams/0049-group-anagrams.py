class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        groups = {}
        
        for s in strs:
            sort = ''.join(sorted(s))
            if sort in groups:
                #if key already seen append to existing list
                groups[sort].append(s)
            else:
                #if putting in for the first time, add s as list
                groups[sort] = [s]

        return list(groups.values())
        