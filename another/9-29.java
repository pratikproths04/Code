LC 329:
class Solution {
    private int[][] around = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        int res = 0;
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[0].length; j ++) {
                res = Math.max(res, dfs(matrix, dp, i, j));
            }
        }
        
        return res;
    }
    
    private int dfs(int[][] matrix, int[][] dp, int row, int col) {
        if (dp[row][col] != 0) return dp[row][col];
        
        int res = 1;
        for (int[] each : around) {
            int newrow = row + each[0];
            int newcol = col + each[1];
            if (newrow >= 0 && newrow < matrix.length && newcol >= 0 && newcol < matrix[0].length
               && matrix[newrow][newcol] > matrix[row][col]) {
                res = Math.max(res, dfs(matrix, dp, newrow, newcol) + 1);
            }
        }
        dp[row][col] = res;
        
        return res;
        
    }
}
//using dfs and the dp thinking
//memorizing the elements while doing dfs


LC 77:

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (k > n || k <= 0) {
            return res;
        }

        helper(n, k, 0, res, new ArrayList<>());
        return res;
    }
    
    private void helper(int n, int k, int start, List<List<Integer>> res, List<Integer> list) {
        int len = list.size();
        if (len == k) {
            res.add(new ArrayList<>(list));
        }
        else {
            for (int i = start + 1; i <= n; i ++) {
                list.add(i);
                helper(n, k, i, res, list);
                list.remove(len);
            }
        }
    }
}


LC 33:

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] >= nums[left] && nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        //System.out.println(left);
        
        if (left + 1 < nums.length && nums[left] > nums[left + 1]) left ++;
        if (target < nums[left] || left - 1 >= 0 && target > nums[left - 1] || left == 0 && target > nums[nums.length - 1]) {
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        if (target > nums[end]) {
            end = left - 1;
        } else {
            start = left;
        }
        //System.out.println(start);
        
        while (start < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) start = mid + 1;
            else end = mid;
        }
        
        return nums[start] == target ? start : -1;
    }
}


LC 200:

class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {return 0;}
        boolean[][] record = new boolean[grid.length][grid[0].length];
        int counter = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (!record[i][j] && grid[i][j] == '1') {
                    counter ++;
                    findIsland(grid, record, i, j);
                }
            }
        }
        return counter;
    }
    
    private void findIsland(char[][] grid, boolean[][] record, int row, int colum) {
        if (row < 0 || row >= grid.length || colum >= grid[0].length 
            || colum < 0 || grid[row][colum] == '0' || record[row][colum]) {
            return;
        }
        record[row][colum] = true;
        findIsland(grid, record, row - 1, colum);
        findIsland(grid, record, row + 1, colum);
        findIsland(grid, record, row, colum - 1);
        findIsland(grid, record, row, colum + 1);
    }
}


LC 305:

class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if(m <= 0 || n <= 0) return result;

        int count = 0;                      // number of islands
        int[] roots = new int[m * n];       // one island = one tree
        Arrays.fill(roots, -1);            

        for(int[] p : positions) {
            int root = n * p[0] + p[1];     // assume new point is isolated island
            roots[root] = root;             // add new island
            count++;

            for(int[] dir : dirs) {
                int x = p[0] + dir[0]; 
                int y = p[1] + dir[1];
                int nb = n * x + y;
                if(x < 0 || x >= m || y < 0 || y >= n || roots[nb] == -1) continue;

                int rootNb = findIsland(roots, nb);
                if(root != rootNb) {        // if neighbor is in another island
                    roots[root] = rootNb;   // union two islands 
                    root = rootNb;          // current tree root = joined tree root
                    count--;               
                }
            }

            result.add(count);
        }
        return result;
    }

    public int findIsland(int[] roots, int id) {
        while(id != roots[id]) {
            roots[id] = roots[roots[id]];
            id = roots[id];
        }
        return id;
    }
}
//use union find









































