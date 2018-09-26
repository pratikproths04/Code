LC 418:

class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        
        int countTime = 0, pointer = 0;
        
        while (rows > 0) {
            // System.out.println(rows);
            
            int col = cols;
            while (col > 0) {
                if (col - sentence[pointer].length() >= 0) {
                    col = col - 1 - sentence[pointer].length();
                    pointer ++;
                    if (pointer >= sentence.length) {
                        pointer = 0;
                        countTime ++;
                    }
                } else {
                    col = 0;
                }
            }
            rows --;
        }
        
        return countTime;
    }
}



class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
    	String s = String.join(" ", sentence) + " ";
    	int len = s.length();
    	char[] str = s.toCharArray();
    	int start = 0;
    	int row = 0;
    	while (row < rows) {
    		//put a window of an entire row on the string, check if the char next to window end is a space
    		int end = start + cols;
    		//end % len is to vitually repeat the same string s
    		//if window tail is not a space, check from tail to left to find the first space
    		while (end >= 0 && str[end % len] != ' ') { 
    			end--;
    		}
    		//now end points at a space. if start aleady == end + 1, 
    		//means current word is even longer than an entire row, so no way to put the sentence in the screen
            if (end + 1 == start) return 0;
    		start = end + 1;
    		row++;
    	}
        return start / len;
    }
}



//my writing here
class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        char[] all = (String.join(" ", sentence) + " ").toCharArray();
        // System.out.println(String.join(" ", sentence) + " ");

        int len = all.length;
        int start = 0, end = 0;
        while (rows > 0) {
            end = start + cols;
            while (end > start && all[end % len] != ' ') {
                end --;
            }
            if (start >= end) return 0;
            start = end + 1;
            // System.out.println(start);
            rows --;
        }
        return start / len;
    }
}
//actually, the beauty of this method is that
//it counts one more in each line
//to count for no space ending
//and the while loop can be used for one or more space ending


LC 490:

class Solution {
    private int[][] around = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[start[0]][start[1]] = true;
        return dfs(maze, visited, start, destination);
    }
    
    
    private boolean dfs(int[][] maze, boolean[][] visited, int[] start, int[] destination) {
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        } else {
            for (int[] direction : around) {
                int row = start[0];
                int col = start[1];
                while (!(row < 0 || row >= maze.length || col < 0 || col >= maze[0].length || maze[row][col] == 1)) {
                    row += direction[0];
                    col += direction[1];
                }
                row -= direction[0];
                col -= direction[1];
                if (visited[row][col]) continue;
                visited[row][col] = true;
                if (dfs(maze, visited, new int[]{row, col}, destination)) return true;
            }
            return false;
        }
    }
}
//the visited matrix will be true, if the ball ends there, not pass there
//in this case, you do not need roll back
//and add the matrix length and height can avoid long judgement conditions



LC 505:

class Solution {
    private int[] direction = new int[]{0, 1, 0, -1, 0};
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] dist = new int[maze.length][maze[0].length];
        dist[start[0]][start[1]] = 1;
        dfs(maze, start[0], start[1], destination, dist);
        return dist[destination[0]][destination[1]] - 1;
    }
    
    private void dfs(int[][] maze, int row, int col, int[] dest, int[][] dist) {
        if (row == dest[0] && col == dest[1]) return;
        else {
            for (int i = 0; i < 4; i ++) {
                int newRow = row;
                int newCol = col;
                int len = dist[row][col];
                while (newRow + direction[i] < maze.length && newRow + direction[i] >= 0 &&
                      newCol + direction[i + 1] < maze[0].length && newCol + direction[i + 1] >= 0 &&
                      maze[newRow + direction[i]][newCol + direction[i + 1]] == 0) {
                    newRow += direction[i];
                    newCol += direction[i + 1];
                    len ++;
                }
                if (dist[newRow][newCol] > 0 && dist[newRow][newCol] <= len) continue;
                dist[newRow][newCol] = len;
                dfs(maze, newRow, newCol, dest, dist);
            }
        }
    }
}
//the normal DFS method, cost a lot


LC 684:

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        if (edges.length == 1) return edges[0];
        UF uf = new UF(edges.length);
        int index = 0;
        for (; index < edges.length; index ++) {
            int id1 = edges[index][0];
            int id2 = edges[index][1];
            if (uf.isConnected(id1, id2)) break;
            uf.connect(id1, id2);
        }
        return edges[index];
    }
}

class UF {
    private int[] id;
    private int[] sz;
    private int count;
    public UF(int N) {
        id = new int[N + 1];
        sz = new int[N + 1];
        for (int i = 0; i <= N; i ++) {
            id[i] = i;
            sz[i] = 1;
        }
        count = N;
    }
    public int count() {
        return count;
    }
    public boolean isConnected(int id1, int id2) {
        return find(id1) == find(id2);
    }
    public int find(int idGiven) {
        while (id[idGiven] != idGiven) {
            id[idGiven] = id[id[idGiven]];
            idGiven = id[idGiven];
        }
        return idGiven;
    }
    public void connect(int id1, int id2) {
        int root1 = find(id1), root2 = find(id2);
        if (sz[root1] > sz[root2]) {
            connect(id2, id1);
            return;
        }
        id[root1] = root2;
        sz[root2] += sz[root1];
        count --;
    }
}
//union find here
//do not have to implement count(), count


class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] uptree = new int[edges.length + 1];
        for (int i = 1; i <= edges.length; i++) {
            uptree[i] = i;
        }
        int[] res = new int[2];
        for (int[] e : edges) {
            if (!union(e[0], e[1], uptree)) {
                res = e;
            }
        }
        return res;
    }
    
    private int find(int n, int[] uptree) {
        while (uptree[n] != n) {
            uptree[n] = uptree[uptree[n]];
            n = uptree[n];           
        }
        return n;
    }
    
    private boolean union(int x, int y, int[] uptree) {
        int f1 = find(x, uptree);
        int f2 = find(y, uptree);
        if (f1 != f2) {
            uptree[f1] = f2;
            return true;
        }
        return false;
    }
}
//this method do not build the new class
//use the return value in union

LC 685:
class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int storeA = -1, storeB = -1;
        UF unf = new UF(edges.length);
        for (int i = 0; i < edges.length; i ++) {
            if (unf.isConnected(edges[i][0], edges[i][1])) {
                storeA = i;
            }
            if (!unf.connect(edges[i][0], edges[i][1])) {
                storeB = i;
            }
            // System.out.println("storeA: " + storeA + ", storeB: " + storeB + ", unf.count: " + unf.count);
        }
        if (storeA != -1 && unf.count <= 1) return edges[storeA];
        else if (unf.count <= 1) return edges[storeB];
        int j = 0;
        for (; j < storeB; j ++) {
            if (edges[j][1] == edges[storeB][1]) break;
        }
        return edges[j];
    }
}

class UF {
    int[] root;
    int count;
    public UF(int N) {
        root = new int[N + 1];
        for (int i = 0; i <= N; i ++) {
            root[i] = i;
        }
        count = N;
    }
    
    public int getCount() {
        return count;
    }
    
    public boolean isConnected(int id1, int id2) {
        return find(id1) == find(id2);
    }
    
    public int find(int id) {
        while (id != root[id]) {
            root[id] = root[root[id]];
            id = root[id];
        }
        return id;
    }
    
    public boolean connect(int rootId, int leafId) {
        int root1 = find(rootId);
        int root2 = find(leafId);
        if (root2 != leafId) return false;
        root[leafId] = root1;
        if (root1 != root2) count --;
        return true;
    }
}
//use union find
//the 2 different cases for directed graph
//which shall be tell from undirected graph



public int[] findRedundantDirectedConnection(int[][] edges) {
    int[] roots = new int[edges.length];
    for (int i = 0; i < edges.length; i++) roots[i] = i;

    int[] candidate1 = null, candidate2 = null;
    for (int[] e : edges){
        int rootx = find(roots, e[0]-1), rooty = find(roots, e[1]-1);
        if (rootx != rooty) {
            if (rooty != e[1]-1) candidate1 = e; // record the last edge which results in "multiple parents" issue
            else roots[rooty] = rootx;
        }
        else candidate2 = e; // record last edge which results in "cycle" issue, if any.
    }

    // if there is only one issue, return this one.
    if (candidate1 == null) return candidate2; 
    if (candidate2 == null) return candidate1;
    
    // If both issues present, then the answer should be the first edge which results in "multiple parents" issue
    // Could use map to skip this pass, but will use more memory.
    for (int[] e : edges) if (e[1] == candidate1[1]) return e;

    return new int[2];
}

private int find(int[] roots, int i){
    while (i != roots[i]){
        roots[i] = roots[roots[i]];
        i = roots[i];
    }
    return i;
}
//get the final answer in one pass
//can you believe it?
//detail: https://leetcode.com/problems/redundant-connection-ii/discuss/108058/one-pass-disjoint-set-solution-with-explain    


LC 340:
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        if (k == 0) return 0;
        if (s.length() <= k) return s.length();
            
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, max = 0;
        while (right < s.length()) {
            char tmp = s.charAt(right);
            if (!map.containsKey(tmp) && map.size() < k) {
                map.put(tmp, right);
                max = Math.max(right - left + 1, max);
            } else if (!map.containsKey(tmp)) {
                map.put(tmp, right);
                while (map.size() > k) {
                    char leftTmp = s.charAt(left);
                    if (map.get(leftTmp) == left) {
                        map.remove(leftTmp);
                    }
                    left ++;
                }
            } else {
                map.remove(tmp);
                map.put(tmp, right);
                max = Math.max(right - left + 1, max);
            }
            right ++;
        }

        return max;
    }
}


LC 359:
class Logger {

    private Map<String, Integer> myMap;
    /** Initialize your data structure here. */
    public Logger() {
        myMap = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!myMap.containsKey(message) || myMap.get(message) <= timestamp - 10) {
            myMap.put(message, timestamp);
            return true;
        }
        else {
            return false;
        }
    }
}








