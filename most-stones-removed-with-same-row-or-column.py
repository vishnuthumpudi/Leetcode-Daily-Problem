class Solution(object):
    def dfs(self, n, idx, visited, stones):
        visited[idx] = True
        for i in range(n):
            if not visited[i]:
                if stones[idx][0] == stones[i][0]:
                    self.dfs(n, i, visited, stones)
                if stones[idx][1] == stones[i][1]:
                    self.dfs(n, i, visited, stones)
    def removeStones(self, stones):
        n = len(stones)
        group = 0
        visited = [False] * n

        for i in range(n):
            if not visited[i]:
                group += 1
                self.dfs(n, i, visited, stones)
        return n - group 
