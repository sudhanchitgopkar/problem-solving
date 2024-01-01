class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort(reverse=True)
        s.sort(reverse=True)

        sol, gptr, sptr = 0, 0, 0

        while sptr < len(s) and gptr < len(g):
            if g[gptr] <= s[sptr]:
                gptr += 1
                sptr += 1
                sol += 1
            else:
                gptr += 1

        return sol