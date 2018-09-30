LC 10: Regular Expression Matching:

Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

corner case thinking: 
	1. can s be null? length of s is zero? s.length() is less than t.length()?
	2. can t be null? what if the length of s and t are both zero?
	3. Any other characters except the lowercase letters?
	4. What if "*" at the start of t, true or false?

key thinking: 
	1. how to initialize it? Especially the case when the start char is '*'.
	2. the dp relationship, it may checks different dp positions for different conditions.
	3. dp represents dp[i][j], i is the length of s, j is the length of p.(first i characters, start from 1).

answer:
	class Solution {
	    public boolean isMatch(String s, String p) {
	        int lenS = s.length(), lenP = p.length();
	        boolean[][] dp = new boolean[lenS + 1][lenP + 1];
	        
	        for (int j = 0; j <= lenP; j ++) {
	            if (j == 0 || p.charAt(j - 1) == '*' && j > 1 && dp[0][j - 2]) {
	                dp[0][j] = true;
	            }
	            //the case where p is "p*p*p*"...
	        }
	        
	        for (int i = 1; i <= lenS; i ++) {
	            for (int j = 1; j <= lenP; j ++) {
	                if (p.charAt(j - 1) == '*' && j > 1 && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.')) {
	                    dp[i][j] = dp[i - 1][j] || dp[i][j - 2];	//if * use 0 or more than 1 char
	                } else if (p.charAt(j - 1) == '*' && j > 1 && p.charAt(j - 2) != s.charAt(i - 1)) {
	                    dp[i][j] = dp[i][j - 2];		//if * use 0 chars
	                } else if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
	                    dp[i][j] = dp[i - 1][j - 1];	//both delete one char
	                } else {
	                    dp[i][j] = false;
	                }
	            }
	        }
	        
	        return dp[lenS][lenP];
	    }
	}

time complexity: O(s.length() * t.length());
space complexity: O(s.length() * t.length());
improve: try to compress the space into one row?
//=================================================================================================================

LC 36: Valid Sudoku

Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

corner case thinking:
	1. will the char in the board is not '0' to '9' or '.'?

key thinking:
	1. check rows by row, check cols by col, check cubics by cubic
	2. the use of helper functions make the solution clearer

solution:
	class Solution {
	    public boolean isValidSudoku(char[][] board) {
	        int[] nums = new int[9];
	        for (int i = 0; i < board.length; i ++) {
	            if (!checkRow(board, nums, i)) return false;
	        }
	        for (int j = 0; j < board[0].length; j ++) {
	            if (!checkColumn(board, nums, j)) return false;
	        }
	        for (int i = 0; i < board.length; i += 3) {
	            for (int j = 0; j < board[0].length; j += 3) {
	                if (!checkCubic(board, nums, i, j)) return false;
	            }
	        }	//check cubics by cubic
	        return true;
	    }
	    
	    private boolean checkRow(char[][] board, int[] nums, int row) {
	        for (int i = 0; i < board[0].length; i ++) {
	            char temp = board[row][i];
	            if (temp != '.') {
	                if (nums[temp - '1'] > 0) return false;
	                nums[temp - '1'] ++;                
	            }
	        }
	        Arrays.fill(nums, 0);	//reset the array
	        return true;
	    }
	    
	    private boolean checkColumn(char[][] board, int[] nums, int column) {
	        for (int i = 0; i < board.length; i ++) {
	            char temp = board[i][column];
	            if (temp != '.') {
	                if (nums[temp - '1'] > 0) return false;
	                nums[temp - '1'] ++;                
	            }
	        }
	        Arrays.fill(nums, 0);	//reset the array
	        return true;
	    }
	    
	    private boolean checkCubic(char[][] board, int[] nums, int row, int column) {
	        for (int i = 0; i < 3; i ++) {
	            for (int j = 0; j < 3; j ++) {
	                char temp = board[row + i][column + j];
	                if (temp != '.') {
	                    if (nums[temp - '1'] > 0) return false;
	                    nums[temp - '1'] ++;                
	                }                
	            }
	        }
	        Arrays.fill(nums, 0);	//reset the array
	        return true;        
	    }
	}

time complexity: O(n^2);
space complexity: O(n);
//=================================================================================================================

LC 37: Sudoku Solver

Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.

corner case thinking:
	1. will the char in the board is not '0' to '9' or '.'?
	2. will the initial case be valid?

Key thinking: 
	1. write one for loop, check one row, one col, one cubic at the same time.
	2. the use of dfs method, fill one possible value, then keep dfs

Solution:
	class Solution {
		//big dfs method
		public void solveSudoku(char[][] board) {
	        if (board == null || board.length == 0 || board[0].length == 0) return;
	        solve(board);
	    }
	    
	    private boolean solve(char[][] board) {
	        for (int i = 0; i < 9; i ++) {
	            for (int j = 0; j < 9; j ++) {
	                if (board[i][j] == '.') {
	                    for (char letter = '1'; letter <= '9'; letter ++){
	                        if (isValid(board, i, j, letter)) {	
	                            board[i][j] = letter;
	                            if (solve(board)) return true;		//use the if statement to do dfs
	                            //under the condition of filling this letter
	                            else {
	                                board[i][j] = '.';
	                            }
	                        }
	                    }
	                    return false;
	                    //try all the possible solution
	                }
	            }
	        }
	        return true;
	    }
	    
	    //key 1: isValid, use only one for loop for 
	    //row, column, and square
	    private boolean isValid(char[][] board, int row, int col, char letter) {
	        for (int i = 0; i < 9; i ++) {
	            if (board[i][col] == letter) return false;
	            if (board[row][i] == letter) return false;
	            if (board[row / 3 * 3 + i / 3][col / 3 * 3 + i % 3] == letter) return false;
	            //row / 3 * 3 and col / 3 * 3 to find the start element of the cubic
	        }
	        return true;
	    }
	}	
//=================================================================================================================

LC 41: first missing positive

Given an unsorted integer array, find the smallest missing positive integer.
Your algorithm should run in O(n) time and uses constant extra space.

corner case thinking:
	1. will the duplicate has any effects?

key thinking:
	1. use constant extra space, consider swap
	2. use the index to show the correct order

Solution:
	class Solution {
	    public int firstMissingPositive(int[] nums) {
	        int i = 0;
	        while (i < nums.length) {
	            if (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
	                swap(i, nums[i] - 1, nums);
	            }
	            else {
	                i ++;
	            }
	        }
	        i = 0;
	        while (i < nums.length) {
	            if (nums[i] != i + 1) return i + 1;
	            i ++;
	        }
	        return nums.length + 1;
	    }
	    
	    private void swap(int a, int b, int[] nums) {
	        int temp = nums[a];
	        nums[a] = nums[b];
	        nums[b] = temp;
	    }
	}
//=================================================================================================================
LC 42: Trapping water

Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.










































































































