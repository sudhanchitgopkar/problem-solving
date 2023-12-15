class Solution(object):
    def destCity(self, paths):
        src = set(path[0] for path in paths)
        dst = set(path[1] for path in paths)
        return list(dst - src)[0]
        