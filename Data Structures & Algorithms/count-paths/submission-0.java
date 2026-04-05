class Solution {
    public int uniquePaths(int m, int n) {
        return help(0,0,m,n);
    }
    private int help(int x,int y,int m,int n){
        if (x >= m || y >= n) return 0;
        if (x == m - 1 && y == n - 1) return 1;
        int right=help(x,y+1,m,n);
        int down=help(x+1,y,m,n);
        return right+down;
    }
}
