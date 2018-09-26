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
















