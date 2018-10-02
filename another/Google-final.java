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

coner case thinking:
	1. confirm non-negative and integers

key thinking:
	1. kind of like the BFS, but this BFS is from 2 side of this array;
	2. from the lower to higher, low than the boud now is the number of water we can store

solution:

solution 1: 
	scan twice, find the highest first, then calculate the water from 2 side:
	class Solution {
	    public int trap(int[] height) {
	        int highest = 0;
	        for (int i = 0; i < height.length; i ++) {
	            if (height[i] > height[highest]) highest = i;
	        }
	        int sum = 0;
	        int high = 0;
	        
	        for (int i = 0; i < highest; i ++) {
	            if (high < height[i]) high = height[i];
	            sum += high;
	        }
	        high = 0;
	        for (int i = height.length - 1; i >= highest; i --) {
	            if (high < height[i]) high = height[i];
	            sum += high;
	        }
	        for (int each : height) {
	            sum -= each;
	        }
	        return sum;
	    }
	}

solution 2:
	scan once, 2 pointer from 2 side:
	public int trap(int[] A) {
	    if (A.length < 3) return 0;
	    
	    int ans = 0;
	    int l = 0, r = A.length - 1;
	    
	    // find the initial left and right edge which can hold water
	    while (l < r && A[l] <= A[l + 1]) l++;
	    while (l < r && A[r] <= A[r - 1]) r--;
	    
	    while (l < r) {
	        int left = A[l];
	        int right = A[r];
	        if (left <= right) {
	            // add volum until an edge larger than the left edge
	            while (l < r && left >= A[++l]) {
	                ans += left - A[l];
	            }
	        } else {
	            // add volum until an edge larger than the right volum
	            while (l < r && A[--r] <= right) {
	                ans += right - A[r];
	            }
	        }
	    }
	    return ans;
	}
//=================================================================================================================
LC 43: Multiply String

Given two non-negative integers num1 and num2 represented as strings, 
return the product of num1 and num2, also represented as a string.

corner case thinking:
	1. contains eny characters other than '0' - '9'? for example, '.', 'e'?
	2. negative numbers?
	3. numbers begin with '0'
	4. can the string length be 0 or just be null string?

key thinking:
	1. the idea is to use one and one numbers, times one by one
	2. add the result to a array
	3. scan the array to process the times result

solution:
	class Solution {
	    public String multiply(String num1, String num2) {
	        if (num1.equals("0") || num2.equals("0")) return "0";
	        int len1 = num1.length();
	        int len2 = num2.length();
	        int[] sequnce = new int[len1 + len2 - 1];
	        
	        for (int i = len2 - 1; i >= 0; i --) {
	            for (int j = len1 - 1; j >= 0; j --) {
	                sequnce[i + j] += (num2.charAt(i) - '0') * (num1.charAt(j) - '0');
	            }
	        }
	        
	        for (int i = sequnce.length - 1; i >= 1; i --) {
	            sequnce[i - 1] += sequnce[i] / 10;
	            sequnce[i] = sequnce[i] % 10;
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < sequnce.length; i ++) {
	            sb.append(sequnce[i]);
	        }
	        
	        return sb.toString();
	        
	    }
	}
//=================================================================================================================
LC 44: Wildcard Matching

Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
//different from the question 10 before, where * is letter before (any numbers)

corner case thinking:
	1. length of 2 strings, can they be 0? or can they be null?
	2. what if p start with '*'?

key thinking:
	1. the key to this is the dp relationship, how to write recurrence relationship under different conditions

solution:
	class Solution {
	    public boolean isMatch(String s, String p) {
	        int slen = s.length();
	        int plen = p.length();
	        
	        if (slen != 0 && plen == 0) return false;
	        if (slen == 0 && plen == 0) return true;
	        if (slen == 0 && plen != 0) {
	            for (int i = 0; i < plen; i ++) {
	                if (p.charAt(i) != '*') return false;
	            }
	            return true;
	        }
	        
	        boolean[][] dp = new boolean[slen + 1][plen + 1];
	        
	        dp[0][0] = true;
	        int initial = 1;
	        while (initial <= plen && p.charAt(initial -1) == '*') {
	            dp[0][initial] = true;
	            initial ++;
	        }
	        
	        for (int len1 = 1; len1 <= slen; len1 ++) {
	            for (int len2 = 1; len2 <= plen; len2 ++) {
	                if (s.charAt(len1 - 1) == p.charAt(len2 - 1) || p.charAt(len2 - 1) == '?') {
	                    dp[len1][len2] = dp[len1 - 1][len2 - 1];
	                }
	                else if (p.charAt(len2 - 1) == '*') {
                    	dp[len1][len2] = dp[len1][len2 - 1] || dp[len1 - 1][len2 - 1] || dp[len1 - 1][len2];
                	}
	            }
	        }
	        
	        return dp[slen][plen];
	    }
	}
//=================================================================================================================
LC 56: Merge Intevals

Given a collection of intervals, merge all overlapping intervals.

corner case thinking:
	1. will there be empty interval?
	2. the interval, is it formed by int or other?
	3. is it sorted?
	4. can there be any negative number?

key thinking:
	1. the normal way is to merge intervals, use two pointer and try to figure out the relationship between these 2 pointers
	2. another thinking is to use start and end int point.

solution:
	public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) return intervals;
        
        Collections.sort(intervals, (Interval a, Interval b) -> a.start - b.start);
        //sort the list, using the Collections.sort() instead of Arrays.sort()
        List<Interval> result = new ArrayList<>();
        
        int left = 0, right = 1, len = intervals.size();
        while (left < len || right < len) {
            if (right < len && intervals.get(left).end < intervals.get(right).start) {
                result.add(intervals.get(left));
                left = right ++;
            }
            else if (right < len) {
                intervals.get(left).end = Math.max(intervals.get(left).end, 
                	intervals.get(right ++).end);
                //here, pay attention!
                //choose the larger one among these two
            }
            else {
                result.add(intervals.get(left));
                break;
                //remember to break, or it will stay in loop forever
            }
        }
        
        return result;
    }


    //another way of doing this
    //try to sort the start and the end point of the interval
    //and connects them all together
    public List<Interval> merge(List<Interval> intervals) {
		// sort start&end
		int n = intervals.size();
		int[] starts = new int[n];
		int[] ends = new int[n];
		for (int i = 0; i < n; i++) {
			starts[i] = intervals.get(i).start;
			ends[i] = intervals.get(i).end;
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		// loop through
		List<Interval> res = new ArrayList<Interval>();
		for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
			if (i == n - 1 || starts[i + 1] > ends[i]) {
				res.add(new Interval(starts[j], ends[i]));
				j = i + 1;
			}
		}
		return res;
	}
/*
	As you can see, there are two kinds of overlapping: intersection and comprehension. 
	No matter what kind it is, you can just pretend, after the sorting, that each purple pair actually is an interval, 
	even though it does not really corresponds to any original blue interval. 
	Then you do the start, end compare as you normally use to judge interval overlapping. The end result is the same anyway.
*/
//=================================================================================================================
LC 59: Spiral Matrix II


corner case thinking:
	1. will the given int be negative?

key thinking:
	1. the same as spiral print

solution:
	class Solution {
	    public int[][] generateMatrix(int n) {
	        if (n == 0) return new int[0][0];
	        int[][] res = new int[n][n];
	        fillIn(res, 0, n, 1);
	        return res;
	    }
	    
	    private void fillIn(int[][] res, int index, int n, int number) {
	        int rowStart = index, colStart = index, rowEnd = n - 1 - index, colEnd = n - 1 - index;
	        //the add and substract relation
	        if (rowStart == rowEnd) {
	            res[rowStart][colStart] = number;
	            return;
	        }
	        //corner case, 1 row left, for this is square, this condition is the same as one col left
	        if (rowStart > rowEnd || colStart > colEnd) return;	//end condition
	        for (int i = colStart; i < colEnd; i ++) {
	            res[rowStart][i] = number ++;
	        }
	        for (int i = rowStart; i < rowEnd; i ++) {
	            res[i][colEnd] = number ++;
	        }
	        for (int i = colEnd; i > colStart; i --) {
	            res[rowEnd][i] = number ++;
	        }
	        for (int i = rowEnd; i > rowStart; i --) {
	            res[i][colStart] = number ++;
	        }
	        fillIn(res, index + 1, n, number);
	    }
	}
//=================================================================================================================
LC 72: Edit Distance

Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character


corner case thinking:
	1. will there be null or 0 length strings?

key thinking:
	1. the meaning of dp, and how to write the recurrence relationship

solution:
	class Solution {
	    public int minDistance(String word1, String word2) {
	        int len1 = word1.length(), len2 = word2.length();
	        int[][] dp = new int[len1 + 1][len2 + 1];
	        
	        for (int i = 1; i <= len1; i ++) {
	            dp[i][0] = i;
	        }
	        for (int j = 1; j <= len2; j ++) {
	            dp[0][j] = j;
	        }
	        //these for initialization
	        
	        for (int i = 1; i <= len1; i ++) {
	            for (int j = 1; j <= len2; j ++) {
	                int tmp = Math.min(dp[i - 1][j], dp[i][j - 1]);
	                //delete one char of one string
	                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
	                    dp[i][j] = Math.min(tmp + 1, dp[i - 1][j - 1]);
	                    //delete one or keep the same
	                } else {
	                    dp[i][j] = Math.min(tmp, dp[i - 1][j - 1]);
	                    dp[i][j] ++;
	                    //delete or replace
	                }
	            }
	        }
	        
	        return dp[len1][len2];
	    }
	}
//=================================================================================================================
LC 91: Decode Ways

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

Given a non-empty string containing only digits, determine the total number of ways to decode it.

corner case thinking:
	1. can the string start with '0'

key thinking:
	1. dynamic programming
	2. dp[i] represents how many ways to decode for first i chars, first 0 -> no chars, first 1 -> 1 char
	3. dp[i] = dp[i - 1] //last one form one
				+ dp[i - 2] //last two form one

solution:
	class Solution {
	    public int numDecodings(String s) {
	        if (s == null || s.length() == 0 || s.charAt(0) == '0') {return 0;}
	        int[] dp = new int[s.length() + 1];
	        dp[0] = dp[1] = 1;
	        for (int i = 2; i < s.length() + 1; i ++) {
	            if ((s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) &&
	               s.charAt(i - 1) != '0') {
	                dp[i] = dp[i - 1] + dp[i - 2];
	            }
	            else if ((s.charAt(i - 2) =='0' || s.charAt(i - 2) >= '3') && s.charAt(i - 1) == '0') {
	                return 0;
	            }
	            else if (s.charAt(i - 1) == '0') {
	                dp[i] = dp[i - 2];
	            }
	            else {
	                dp[i] = dp[i - 1];
	            }
	        }
	        return dp[s.length()];
	    }
	}
//=================================================================================================================
LC 95: Unique Binary Search Trees II

Given an integer n, generate all structurally unique BST s (binary search trees) that store values 1 ... n.











//=================================================================================================================
LC 96: Unique Binary Search Trees

Given n, how many structurally unique BST s (binary search trees) that store values 1 ... n?

corner case thinking:
	1. n is 0?
	2. how to write dp recurrence relationship?


solution:
	class Solution {
	    public int numTrees(int n) {
	        int[] dp = new int[n + 1];
	        dp[0] = 1;
	        dp[1] = 1;
	        for (int i = 2; i <= n; i ++) {
	            for (int j = i - 1; j >= 0; j --) {
	                dp[i] += dp[j] * dp[i - j - 1];
	                //left subtree number * right subtree number
	                //{1,2,3,4,5} => pick number 1 as root:
	                //left is 0 ==> dp[0]
	                //right is {2,3,4,5} == {1,2,3,4} ==> dp[4]
	            }
	        }
	        return dp[n];
	    }
	}
//=================================================================================================================
LC 115: Distinct Subsequences

Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting some 
(can be none) of the characters without disturbing the relative positions of the remaining characters. 
(ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

corner case thinking:
	1. empty s or empty t
	2. t has length larger than s?

key thinking:
	1. how to write the dp recurrence relationship?

solution:
	class solution{
		public int numDistinct(String s, String t) {
			if (s.length() < t.length()) {return 0};
			int[][] dp = new int[t.length() + 1][s.length() + 1];
			for (int i = 0; i <= t.length(); i ++) {
				for (int j = 0; j <= s.length(); j ++) {
					if (i == 0) {
						dp[i][j] = 1;
					} else if (j == 0) {
						dp[i][j] = 0;
					} else {
						if (s.charAt(j - 1) == t.charAt(i - 1)) {
							dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
							//the case of keep the last char in s or delete the last char in s
						} else {
							dp[i][j] = dp[i][j - 1];
						}
					}
				}
			}
			return dp[t.length()][s.length()];
		}
	}
//=================================================================================================================
LC 128: Longest Consecutive Sequence

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.


corner case thinking:
	1. how about the negative number.
	2. will the array be length of 0 or empty?

key thinking:
	1. swap might not be a good method for this question, because it may not be indexed by the index
	2. union find is a good thinking

solution:
	class solution {
		public int longestConsecutive(int[] nums) {
	        if (nums.length == 0) return 0;
	        
	        Set<Integer> set = new HashSet<>();
	        for (int each : nums) set.add(each);
	        int[] record = new int[1];
	        
	        int len = 1;
	        for (int each : nums) {
	            if (!set.contains(each)) continue;
	            
	            record[0] ++;
	            set.remove(each);
	            helper(record, set, each);
	            len = Math.max(len, record[0]);
	            record[0] = 0;
	        }
	        return len;
	    }
	    
	    //find the consecutive
	    private void helper(int[] record, Set<Integer> set, int element) {
	        if (set.contains(element - 1)) {
	            record[0] ++;
	            set.remove(element - 1);
	            helper(record, set, element - 1);
	        }
	        if (set.contains(element + 1)) {
	            record[0] ++;
	            set.remove(element + 1);
	            helper(record, set, element + 1);
	        }
	    }
	}
	// too primative but effective
	// use dfs to find the consecutive
	// use set to store all numbers
	// keep a record of len

	//another solution
	class solution {
		public int longestConsecutive(int[] nums) {
		    if(nums == null || nums.length == 0) return 0;
		    
		    Set<Integer> set = new HashSet<Integer>();
		    
		    for(int num: nums) set.add(num);
		    int max = 1;
		    for(int num: nums) {
		        if(set.remove(num)) {//num hasn't been visited
		            int val = num;
		            int sum = 1;
		            while(set.remove(val-1)) val--;
		            sum += num - val;
		            
		            val = num;
		            while(set.remove(val+1)) val++;
		            sum += val - num;
		            
		            max = Math.max(max, sum);
		        }
		    }
		    return max;
		}
	}
	//set.remove() return true or false
	//basically the same idea, but clearer code
//=================================================================================================================
LC 134: Gas Station

There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). 
You begin the journey with an empty tank at one of the gas stations.

corner case thinking:
	1. will the array of cost and gas be integers? be non-negative or positive?
	2. will the solution be unique?
	3. will these arrays have the same length?
	4. will there be no solution?

key thinking:
	1. unique means only one solution possible, combine the cost and gas, scan once
	2. if no solution, scan another time for checking.


solution:
	class Solution {
	    public int canCompleteCircuit(int[] gas, int[] cost) {
	        if (gas == null || gas.length == 0 || cost == null || cost.length == 0) return -1;
	        int[] left = new int[gas.length];
	        int sumup = 0, startIndex = 0, record = 0;
	        
	        for (int i = 0; i < gas.length; i ++) {
	            left[i] = gas[i] - cost[i];
	            sumup += left[i];
	            record += left[i];
	            if (record < 0) {
	                record = 0;
	                startIndex = i + 1;
	            }
	        }
	        
	        if (sumup < 0 || startIndex >= gas.length) return -1;
	        
	        record = 0;
	        for (int i = startIndex; ; i = (i + 1) % gas.length) {
	            record += left[i];
	            if (record < 0) return -1;
	            if (i == (startIndex + gas.length - 1) % gas.length) break;
	        }
	        return startIndex;
	    }
	}
//=================================================================================================================
LC 146: LRU cache

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
it should invalidate the least recently used item before inserting a new item.

corner case thinking:
	

solution:
	class LRUCache {
	    
	    Map<Integer, ListNode> map;
	    ListNode head;
	    ListNode tail;
	    int capacity;
	    
	    public LRUCache(int capacity) {
	        map = new HashMap<>();
	        head = null;
	        tail = null;
	        this.capacity = capacity;
	    }
	    
	    public int get(int key) {
	        if (map.containsKey(key)) {
	            ListNode tmp = map.get(key);
	            if (tmp.key == tail.key) {
	                return tmp.value;
	            } else if (tmp.key == head.key) {
	                head = head.next;
	                head.prev = null;
	                tmp.next = null;
	                tmp.prev = tail;
	                tail.next = tmp;
	                tail = tmp;
	                return tmp.value;
	            } else {
	                tmp.prev.next = tmp.next;
	                tmp.next.prev = tmp.prev;
	                tmp.prev = tail;
	                tail.next = tmp;
	                tail = tmp;
	                return tmp.value;
	            }
	        } 
	        return -1;
	    }
	    
	    
	    public void put(int key, int value) {
	        ListNode cur = new ListNode(key, value);
	        if (map.containsKey(key)) {
	            ListNode tmp = map.get(key);
	            if (tmp.key == tail.key) {
	                tmp.value = value;
	            } else if (tmp.key == head.key) {
	                head = head.next;
	                head.prev = null;
	                tmp.next = null;
	                tmp.prev = tail;
	                tail.next = tmp;
	                tmp.value = value;
	                tail = tmp;
	            } else {
	                tmp.prev.next = tmp.next;
	                tmp.next.prev = tmp.prev;
	                tmp.prev = tail;
	                tail.next = tmp;
	                tail = tmp;
	                tmp.value = value;
	            }
	        } else if (capacity > 0 && head == null) {
	            map.put(key, cur);
	            head = cur;
	            tail = cur;
	            capacity --;
	        } else if (capacity > 0) {
	            map.put(key, cur);
	            tail.next = cur;
	            cur.prev = tail;
	            tail = cur;
	            capacity --;
	        } else {
	            map.put(key, cur);
	            tail.next = cur;
	            cur.prev = tail;
	            tail = cur;
	            map.remove(head.key);
	            head = head.next;
	            head.prev = null;
	        }
	    }
	    
	}

	class ListNode {
	    int key;
	    int value;
	    ListNode prev;
	    ListNode next;
	    public ListNode(int a, int b) {
	        key = a;
	        value = b;
	        prev = null;
	        next = null;
	    }
	}
//=================================================================================================================
LC 150: Evaluate Reverse Polish Notation

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

corner case thinking:
	1. Division between two integers should truncate toward zero?
	2. will the functions always be valid?

key thinking:
	1. from the array, you can see you must use stack or stack similar data structure

solution:
	class Solution {
	    public int evalRPN(String[] tokens) {
	        Stack<Integer> stack = new Stack<>();
	        //keep an int stack
	        int res = 0;
	        for (String each : tokens) {
	            if (judge(each)) {
	                res = calculation(stack, each);
	                stack.push(res);
	            }
	            else {
	                res = Integer.parseInt(each);
	                stack.push(res);
	            }
	        }
	        
	        return res;
	    }
	    
	    private boolean judge(String token) {
	        return token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*");
	    }
	    
	    private int calculation(Stack<Integer> stack, String token) {
	        int a = stack.pop(), b = stack.pop(), temp;
	        if (token.equals("+")) {
	            temp = b + a;
	        }
	        else if (token.equals("-")) {
	            temp = b - a;
	        }
	        else if (token.equals("*")) {
	            temp = b * a;
	        }
	        else {
	            temp = b / a;
	        }
	        return temp;
	    }
	}
//=================================================================================================================
LC 152: Maximum Product Subarray

Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

corner case thinking:
	1. can the array be empty?
	2. integer be negative?

key case thinking:
	1. dp thinking, keep the min and max while scanning, this reduce the space to constant

solution:
	class Solution {
	    public int maxProduct(int[] nums) {
	        if (nums == null || nums.length == 0) return 0;
	        
	        int maxRes = nums[0];
	        int minRes = nums[0];
	        int res = nums[0];
	        
	        for (int i = 1; i < nums.length; i ++) {
	            if (nums[i] < 0) {
	                int tmp = Math.max(minRes * nums[i], nums[i]);
	                minRes = Math.min(maxRes * nums[i], nums[i]);
	                maxRes = tmp;
	            } else {
	                int tmp = Math.max(maxRes * nums[i], nums[i]);
	                minRes = Math.min(minRes * nums[i], nums[i]);
	                maxRes = tmp;
	            }
	            res = Math.max(res, maxRes);
	        }
	        
	        return res;
	    }
	}
//=================================================================================================================
LC 153: Find Minimum in Rotated Sorted Array

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

corner case thinking:
	1. contains duplicate elements?
	2. will it not rotated, select the last or first element
	3. empty array?

key thinking:
	1. binary search, but use the state:

solution:
	class Solution {
	    public int findMin(int[] num) {
	        if (num == null || num.length == 0) {
	            return 0;
	        }
	        if (num.length == 1) {
	            return num[0];
	        }
	        int start = 0, end = num.length - 1;
	        while (start < end) {
	            int mid = (start + end) / 2;
	            if (mid > 0 && num[mid] < num[mid - 1]) {
	                return num[mid];
	            }
	            if (num[start] <= num[mid] && num[mid] > num[end]) {
	                start = mid + 1;
	            } else {
	                end = mid - 1;
	            }
	        }
	        return num[start];
	    }
	}
//=================================================================================================================
LC 162: Find Peak Element

A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

corner case thinking:
	1. the length of the array, might be 0, 1, 2, or more than 2

solution:
	//three different method
	//method, use the BS
	//when changing the state, move the pointer
	class Solution {
	    public int findPeakElement(int[] nums) {
	        if(nums.length == 1 || nums[0] > nums[1]) return 0;
	        if(nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;
	        int left = 0, right = nums.length - 1, mid;
	        while (left < right) {
	            mid = left + (right - left) / 2;
	            if (mid - 1 >= 0 && mid + 1 < nums.length && nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) return mid;
	            //pay attention to the corner case
	            else if (mid - 1 < 0 || mid + 1 < nums.length && nums[mid] <= nums[mid + 1] && nums[mid] >= nums[mid - 1]) left = mid + 1;
	            //move left pointer, if it is going upside, and in the leftmost end
	            else right = mid;
	            //all other cases
	        }
	        return left;
	        //this must work if there is a peak
	    }
	}

	time complexity is O(logn)
	space complexity is O(1)
	public int findPeakElement(int[] nums) {
        if (nums.length == 1 || nums[0] > nums[1]) return 0;
        //edge case 1: one element
        //edge case 2: the first element is a peak
        if (nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;
        //edge case 3: the last element is a peak
        
        int left = 0, right = nums.length - 1, mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (mid > 0 && mid < nums.length - 1 && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
            //test mid
            else if (mid == 0 && nums[mid] <= nums[mid + 1]) left = mid;
            else if (nums[mid] >= nums[mid - 1] && nums[mid] <= nums[mid + 1]) left = mid;
            //move left to mid if the mid is on the up slope
            else right = mid;
            //move right to mid if the mid is on the down slope
        }
        return (nums[left] < nums[right]) ? right : left;   
        //post-processing    
    }

    //another method
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) return mid;
            //this judgment is too good!
            //it covers three possible cases
            if (mid == 0 || nums[mid] > nums[mid - 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
        //check the final state, it will be left pointer, for right pointer is less than the left pointer, only way to cause this
        //can lead to the condition before;
    }
//=================================================================================================================
LC 200: Number of Islands

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

key thinking: 
	1. BFS and recording
	2. union find 

solution:
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
//=================================================================================================================
LC 205: Isomorphic Strings

Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. 
No two characters may map to the same character but a character may map to itself.

corner case thinking:
	1. if s and t contains all the characters?

key thinking:
	1. use the HashMap or arrays, build the one to one relationship

solution:
	class Solution {
	    public boolean isIsomorphic(String s, String t) {
	        //if (s != null && t == null || s == null && t != null || 
	        //    s != null && s.length() != t.length()) return false;
	        
	        int[] mapA = new int[256];
	        int[] mapB = new int[256];
	        Arrays.fill(mapA, -1);
	        Arrays.fill(mapB, -1);
	        
	        for (int i = 0; i < s.length(); i ++) {
	            int schar = (int) s.charAt(i);
	            int tchar = (int) t.charAt(i);
	            if (mapA[schar] == -1) {
	                mapA[schar] = tchar;
	            } else if (mapA[schar] != tchar) {
	                return false;
	            }

	            if (mapB[tchar] == -1) {
	                mapB[tchar] = schar;
	            } else if (mapB[tchar] != schar) {
	                return false;
	            }            
	        }
	        
	        return true;
	    }
	}
//here using the int array instead of char array
//=================================================================================================================
LC 222: Count Complete Tree Nodes

Given a complete binary tree, count the number of nodes.

























































































