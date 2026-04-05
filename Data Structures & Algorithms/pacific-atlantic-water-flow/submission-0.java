

class Solution {

    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacvis = new boolean[rows][cols];
        boolean[][] atlvis = new boolean[rows][cols];

        Queue<int[]> pac = new LinkedList<>();
        Queue<int[]> atl = new LinkedList<>();

        // Pacific: top row + left column
        for (int j = 0; j < cols; j++) {
            pac.add(new int[]{0, j});
            pacvis[0][j] = true;
        }
        for (int i = 0; i < rows; i++) {
            pac.add(new int[]{i, 0});
            pacvis[i][0] = true;
        }

        // Atlantic: bottom row + right column
        for (int j = 0; j < cols; j++) {
            atl.add(new int[]{rows - 1, j});
            atlvis[rows - 1][j] = true;
        }
        for (int i = 0; i < rows; i++) {
            atl.add(new int[]{i, cols - 1});
            atlvis[i][cols - 1] = true;
        }

        // BFS from both oceans
        bfs(pac, pacvis, heights);
        bfs(atl, atlvis, heights);

        // Intersection
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacvis[i][j] && atlvis[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void bfs(Queue<int[]> q, boolean[][] vis, int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nc < 0 || nr >= rows || nc >= cols)
                    continue;

                if (vis[nr][nc])
                    continue;

                if (heights[nr][nc] < heights[r][c])
                    continue;

                vis[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }
    }
}
