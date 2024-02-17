const static auto _ = [] { std::ios::sync_with_stdio(false); std::cin.tie(nullptr); std::cout.tie(nullptr); return nullptr; }();
class Solution {
public:
    int furthestBuilding(vector<int>& heights, int bricks, int ladders) {
        priority_queue<int, vector<int>, greater<int>> pq;
        for (int i = 1; i < heights.size(); i++) {
            if (heights[i] > heights[i - 1]) {
                if (pq.size() < ladders) {
                    pq.push(heights[i] - heights[i - 1]);
                } else {
                    if (!pq.empty() && pq.top() < (heights[i] - heights[i - 1])) {
                        bricks -= pq.top();
                        pq.pop();
                        pq.push((heights[i] - heights[i - 1]));
                    } else {
                        bricks -= (heights[i] - heights[i - 1]);
                    } 
                }
                if (bricks < 0) return i - 1;
            } 
        }
        return heights.size() - 1;
    }
};
