class Solution:
    def findTheCity(self, n: int, edges: List[List[int]], distanceThreshold: int) -> int:
        adj = defaultdict(list)

        for v, v_2, w in edges:
            adj[v].append((v_2, w))
            adj[v_2].append((v, w))
                
        def total_count(curr, distance_left, visited):
            for adj_elem in adj[curr]:
                adj_vertex = adj_elem[0]
                weight = adj_elem[1]

                if weight <= distance_left and (adj_vertex not in visited or visited[adj_vertex] < distance_left - weight):
                    visited[adj_vertex] = distance_left - weight
                    total_count(adj_vertex, distance_left - weight, visited)
            
            return len(visited)

        minDist = 1000000
        id = -1
        for v in range(n):
            print(v)
            visited = {}
            visited[v] = 10000
            
            n = total_count(v, distanceThreshold, visited)
            if n <= minDist:
                minDist = n
                id = v

        # return curr_min
        return id
            