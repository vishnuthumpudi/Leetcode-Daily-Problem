class Solution {
    private record State(int w, int idx){}; 
    private record UsedState(int time, int idx){}; 
    public int[] assignTasks(int[] servers, int[] tasks) {
        // I need priority_queue for the servers 
        PriorityQueue<State> server_pool = new PriorityQueue<State>((a, b) -> {
            if(a.w == b.w) return Integer.compare(a.idx, b.idx); 
            return Integer.compare(a.w, b.w); 
        }); 

        PriorityQueue<UsedState> server_occupied = new  PriorityQueue<UsedState>((a, b) -> {
            return Integer.compare(a.time, b.time); 
        }); 

        // initially for each task length we will have a event 
        int n = servers.length, m = tasks.length; 

        // add all servers to empty server pool 
        for(int i = 0; i < n; i++) server_pool.add(new State(servers[i], i)); 

        int ans[] = new int[m]; 
        
        int time = 0; 
        for(int i = 0; i < m; i++) {
            time = Math.max(time, i); 
            // add current task to the available server, if no server is available, increment time, to the when a server will be free
            if(server_pool.isEmpty()) time = Math.max(time, server_occupied.peek().time); 

            // check if there is any server that can be freed at this time... 
            while(!server_occupied.isEmpty() && server_occupied.peek().time <= time) {
                // that means this server can be free'd now 
                int idx = server_occupied.peek().idx; 
                server_occupied.poll(); 
                server_pool.add(new State(servers[idx], idx)); 
            }

            // current server available is? 
            int idx = server_pool.peek().idx; 
            ans[i] = idx; 
            server_occupied.add(new UsedState(time + tasks[i], idx)); 
            server_pool.poll(); 
        }
        return ans; 
    }
}