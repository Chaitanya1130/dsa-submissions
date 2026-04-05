class Solution {
    static int INF=2147483647;
    public void islandsAndTreasure(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        Queue<int[]>queue=new LinkedList<>();
        int[][]vis=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        int dis=-1;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[]point=queue.poll();
                int r=point[0],c=point[1];
                for(int[]dir:dirs){
                    int nr=r+dir[0],nc=c+dir[1];
                    if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==INF){
                        grid[nr][nc] = grid[r][c] + 1;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
    }
}
