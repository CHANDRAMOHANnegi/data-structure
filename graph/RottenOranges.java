class RottenOranges {
    class Pair {
        int x;
        int y;
        int t;
        
        Pair(int x, int y, int t){
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
    
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.add(new Pair(i, j, 0));
                } else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        int time = 0;
        while(queue.size() > 0){
            Pair rem = queue.remove();
            
            if(visited[rem.x][rem.y]){
                continue;
            } 
            visited[rem.x][rem.y] = true;
            if(grid[rem.x][rem.y] == 1){
                fresh--;
            }
            if(rem.t > time){
                time = rem.t;
            }
            
            addOrangeToQueue(rem.x - 1, rem.y, rem.t + 1, visited, grid, queue);
            addOrangeToQueue(rem.x + 1, rem.y, rem.t + 1, visited, grid, queue);
            addOrangeToQueue(rem.x, rem.y - 1, rem.t + 1, visited, grid, queue);
            addOrangeToQueue(rem.x, rem.y + 1, rem.t + 1, visited, grid, queue);            
        }
        
        if(fresh == 0){
            return time;
        } else {
            return -1;
        }
    }
    
    public void addOrangeToQueue(int x, int y, int t, boolean[][] visited, int[][] grid, ArrayDeque<Pair> queue){
        if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && visited[x][y] == false && grid[x][y] == 1){
            queue.add(new Pair(x, y, t));
        }
    }
}