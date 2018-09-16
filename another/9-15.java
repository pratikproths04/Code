LC 46:

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new ArrayList<Integer>(), new boolean[nums.length]);
        return res;
    }
    
    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < visited.length; i ++) {
                if (visited[i]) continue;
                list.add(nums[i]);
                visited[i] = true;
                dfs(nums, res, list, visited);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
//permutation solution
time complexity O(n!)


LC 101:

//recursively
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }
    
    private boolean dfs(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null || a.val != b.val) return false;
        return dfs(a.left, b.right) && dfs(a.right, b.left);
    }
}

//iteratively
//using stack
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        
        Stack<TreeNode> st = new Stack<>();
        st.push(root.left);
        st.push(root.right);
        while (!st.isEmpty()) {
            TreeNode bR = st.pop();
            TreeNode aL = st.pop();
            if (aL == null) {
                if (bR != null) return false;
            } else {
                if (bR == null || aL.val != bR.val) return false;
                st.push(aL.left);
                st.push(bR.right);
                st.push(aL.right);
                st.push(bR.left);
            }
        }
        
        return true;
    }
}
//stack push and pop does not return stack
//that is stringbuilder
//stack operation only return boolean


LC 98:

//in-order tranverse and must increase
class Solution {
    private TreeNode prev = null;
    
    public boolean isValidBST(TreeNode root) {
        boolean[] res = new boolean[]{true};
        helper(root, res);
        return res[0];
    }
    
    private void helper(TreeNode root, boolean[] res) {
        if (root == null) return;
        helper(root.left, res);
        
        if (prev != null && prev.val >= root.val) res[0] = false;
        prev = root;
        
        helper(root.right, res);
    }
}


//return boolean, use an interval
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return validHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean validHelper(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;
        return validHelper(root.left, min, Math.min(root.val, max)) 
        && validHelper(root.right, Math.max(root.val, min), max);
    }
}


LC 50:

//method 1: recursive
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            return 1/x * myPow(1/x, - (n + 1));
        }
        double res = myPow(x, n / 2);
        return (n % 2 == 0) ? res * res : res * res * x;
    }
}
//points need attention:
//n = Integer.MIN_VALUE; -n will overflow;
//so need - (n + 1) and another 1;
//
//one time n / 2, avoid normal stack overflow


//method 2: interative
class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1/x * myPow(1/x, - (n + 1));
        }
        double ans = 1;
        while (n > 0) {
            if ((n & 1) == 1) ans *= x;
            x *= x;
            n >>= 1;
        }
        return ans;
    }
}


LC 10:
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        
        for (int i = 0; i <= s.length(); i ++) {
            for (int j = 1; j <= p.length(); j ++) {
                if (i > 0 && (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.')) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (i > 0 && j >= 2 && p.charAt(j - 1) == '*' 
                           && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.')) {
                    dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j];
                } else if (i == 0 && j >= 2 && p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                } else if (i == 0 && p.charAt(j - 1) == '*') {
                    dp[i][j] = true;
                } else if (i > 0 && j >= 2 && p.charAt(j - 1) == '*' && p.charAt(j - 2) != s.charAt(i - 1)) {
                    dp[i][j] = dp[i][j - 2];
                }
            }
        }
        
        return dp[s.length()][p.length()];
    }
}



//better and clearer
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        
        for (int i = 1; i <= p.length(); i ++) {
            if (p.charAt(i - 1) == '*' && i == 1) {
                dp[0][i] = true;
            }
            else if (p.charAt(i - 1) == '*' && dp[0][i - 2]) {
                dp[0][i] = true;
            }
        }
        
        for (int i = 1; i <=  s.length(); i ++) {
            for (int j = 1; j <= p.length(); j ++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*' && j >= 2) {
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        
        return dp[s.length()][p.length()];
    }
}
//Three conditions
1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
3, If p.charAt(j) == '*': 
   here are two sub conditions:
			   1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
			   2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
							  dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a 
						   or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
						   or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty



LC 33.

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }
}
//the division view!!!
//that is quite good!



//the first bs to find the pivot
//but why
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



LC 34:

// <= binary search
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int mid, left = 0, right = nums.length - 1;
        int[] res = new int[]{-1, -1};
        if (nums.length == 0) {return res;}
        while(left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] >= target) {right = mid - 1;}
            else {left = mid + 1;}
        }
        res[0] = left;
        left = 0; right = nums.length - 1;
        while(left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] > target) {right = mid - 1;}
            else {left = mid + 1;}
        }
        res[1] = right;
        if (res[0] == nums.length || res[1] == -1 || nums[res[0]] != target) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        return res;
    }
}


// < binary search
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        
        int left = 0, right = nums.length - 1, mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        res[0] = (nums[left] == target) ? left : right;
        if (nums[res[0]] != target) return new int[]{-1, -1};
        
        left = 0;
        right = nums.length - 1;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        res[1] = (nums[right] == target) ? right : left;
        
        return res;
    }
}


//think more about it
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {Integer.MAX_VALUE, -1};
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        smaller(nums, res, target, 0, nums.length - 1);
        if (res[1] == -1) return new int[]{-1, -1};
        return res;
    }
    
    private void smaller(int[] nums, int[] range, int target, int left, int right) {
        if (left > right) return;
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            range[0] = Math.min(range[0], mid);
            range[1] = Math.max(range[1], mid);
            if (left < mid) smaller(nums, range, target, left, mid - 1);
            if (mid < right) smaller(nums, range, target, mid + 1, right);
        } else if (nums[mid] < target) {
            smaller(nums, range, target, mid + 1, right);
        } else {
            smaller(nums, range, target, left, mid - 1);
        }
    }
}



LC 35:
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        if (nums[left] < target) return left + 1;
        return left;
    }
}


//<= binary search case, the ending term
public int searchInsert(int[] A, int target) {
    int low = 0, high = A.length-1;
    while(low<=high){
        int mid = (low+high)/2;
        if(A[mid] == target) return mid;
        else if(A[mid] > target) high = mid-1;
        else low = mid+1;
    }
    return low;
}


LC 152:
//old version method
class Solution {
    public int maxProduct(int[] nums) {
        int[][] dp = new int[2][nums.length];
        int max = Integer.MIN_VALUE;
        if (nums.length == 1) {return nums[0];}
        for (int i = 0; i < nums.length; i ++) {
            if (i == 0) {
                if (nums[0] < 0) {
                    dp[1][i] = nums[0];
                }
                else {
                    dp[0][i] = nums[0];
                }
            }
            else if (nums[i] <= 0) {
                dp[1][i] = Math.min(dp[0][i - 1] * nums[i], nums[i]);
                dp[0][i] = dp[1][i - 1] * nums[i];
            }
            else if (nums[i] > 0) {
                dp[1][i] = dp[1][i - 1] * nums[i];
                dp[0][i] = Math.max(dp[0][i - 1] * nums[i], nums[i]);
            }
            max = Math.max(dp[0][i], max);
        }
        return max;
    }
}


















































































