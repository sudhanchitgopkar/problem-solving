class Solution:
    def minimumCost(self, source: str, target: str, original: List[str], changed: List[str], cost: List[int]) -> int:
        adj = collections.defaultdict(list)
        cache = {}

        #Create adj list
        edges = zip(original, changed, cost)
        for o, ch, co in edges:
            adj[o].append((co, ch))

        def dijk(src, dst):
            if (src, dst) in cache:
                return cache[(src, dst)]
            pq = [(0, src)]
            visited = set()
            
            while pq:
                cost, node = heapq.heappop(pq)
                if node in visited:
                    continue
                cache[(src, node)] = cost
                visited.add(node)           

                if node == dst:
                    return cost

                for nxt_cost, nxt_node in adj[node]:
                    if nxt_node not in visited:
                        heapq.heappush(pq, (cost + nxt_cost, nxt_node))

            return -1
        
        sol = 0
        for char_src, char_dst in zip(source, target):
            res = dijk(char_src, char_dst)
            if res == -1:
                return -1
            sol += res
        
        return sol        