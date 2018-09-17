LC 243:

class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int distance = Integer.MAX_VALUE;
        int index1 = -1, index2 = -1;
        for (int i = 0; i < words.length; i ++) {
            if (words[i].equals(word1)) {
                index1 = i;
                if (index2 != -1) distance = Math.min(index1 - index2, distance);
            } else if (words[i].equals(word2)) {
                index2 = i;
                if (index1 != -1) distance = Math.min(index2 - index1, distance);
            }
        }
        return distance;
    }
}


LC 244:

//using a hashmap and arraylist
class WordDistance {
    
    Map<String, List<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i ++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i], list);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        int distance = Integer.MAX_VALUE;
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int pointer1 = 0, pointer2 = 0;
        while (pointer1 < list1.size() && pointer2 < list2.size()) {
            int index1 = list1.get(pointer1);
            int index2 = list2.get(pointer2);
            if (index1 < index2) {
                distance = Math.min(index2 - index1, distance);
                pointer1 ++;
            } else {
                distance = Math.min(index1 - index2, distance);
                pointer2 ++;
            }
        }
        return distance;
    }
}



LC 671:

class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        int[] minVal = new int[]{root.val, Integer.MAX_VALUE, 0};
        dfs(root, minVal);
        return (minVal[2] == 1) ? minVal[1] : -1;
    }
    
    private void dfs(TreeNode root, int[] minVal) {
        if (root == null) return;
        if (root.val != minVal[0]) {
            minVal[1] = Math.min(minVal[1], root.val);
            minVal[2] = 1;
            return;
        } else {
            dfs(root.left, minVal);
            dfs(root.right, minVal);
        }
    }
}



LC 152:

//dp method, rule out the nums.length == 1 case then dp
//with space complexity O(n)
class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int maxRes = nums[0];
        int[][] dp = new int[nums.length][2];
        if (nums[0] < 0) {
            dp[0][1] = nums[0];
        } else {
            dp[0][0] = nums[0];
        }
        
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] < 0) {
                dp[i][0] = dp[i - 1][1] * nums[i];
                dp[i][1] = Math.min(nums[i], dp[i - 1][0] * nums[i]);
            } else {
                dp[i][0] = Math.max(nums[i], dp[i - 1][0] * nums[i]);
                dp[i][1] = dp[i - 1][1] * nums[i];
            }
            maxRes = Math.max(maxRes, dp[i][0]);
            maxRes = Math.max(maxRes, dp[i][1]);
        }
        
        return maxRes;
    }
}



//dp with space complexity O(1)
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


//another version, keep global min and max
class Solution {
    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        int gmax = 1;
        int gmin = 1;
        
        for(int i= 0 ;i < nums.length; i++){
            int max = 0;
            int min = 0;
            if(nums[i] > 0){
                max = Math.max(nums[i],nums[i]*gmax);
                min = Math.min(nums[i],nums[i]*gmin);
            }else if(nums[i] < 0){
                max = Math.max(nums[i],nums[i]*gmin);
                min = Math.min(nums[i],nums[i]*gmax);
            }
            gmax = max;
            gmin = min;
            result = Math.max(gmax,result);
        }
        return result;
    }
}


LC 605:

//much better solution
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count =0;
        for(int i=0;i<flowerbed.length;){
            if(flowerbed[i] == 1){
                i +=2;
                //flowerbed[i + 1] must be 0
            }   
            else if ( flowerbed[i] == 0){
                if(i+1>=flowerbed.length || flowerbed[i+1] == 0){
                    count++;
                    i +=2;
                }
                else
                i++;
            }
            
        }
        
        return count>=n;
    }
}


LC 716:

//pay attetion case:
//For Double LinkedList
//push corner case: head == null && tail == null
//pop corner case: size() == 1 (head == tail)

//pop middle cases:
//size is 1, both at head and tail
//at the head;
//at the tail;
//at the mid

//TreeSet will diminish the duplicate element
class MaxStack {
    
    ListNode head, tail;
    TreeSet<ListNode> set;
    int index;
    
    /** initialize your data structure here. */
    public MaxStack() {
        head = null;
        tail = null;
        set = new TreeSet<ListNode>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode a, ListNode b) {
                if (a.val == b.val) return b.in - a.in;
                return b.val - a.val;
            }
        });
        index = 0;
    }
    
    public void push(int x) {
        ListNode tmp = new ListNode(x, index);
        index ++;
        set.add(tmp);
        if (head == null) {
            head = tmp;
            tail = tmp;
        } else {
            tail.next = tmp;
            tmp.prev = tail;
            tail = tmp;
        }
    }
    
    public int pop() {
        ListNode cur = tail;
        tail = tail.prev;
        
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        set.remove(cur);
        return cur.val;
    }
    
    public int top() {
        return tail.val;
    }
    
    public int peekMax() {
        return set.first().val;
    }
    
    public int popMax() {
        System.out.println("set size: " + set.size());
        ListNode cur = set.pollFirst();
        if (cur.next == null && cur.prev == null) {
            tail = null;
            head = null;
        } else if (cur.next == null) {
            tail = cur.prev;
            tail.next = null;
        } else if (cur.prev == null) {
            head = cur.next;
            head.prev = null;
        } else {
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
        }
        return cur.val;
    }
}

class ListNode {
    int val;
    int in;
    ListNode prev;
    ListNode next;
    public ListNode(int value, int index) {
        val = value;
        in = index;
    }
}
//TreeSet method




//another method
//this method does not get the O(logn) time complexity
class MaxStack {
    Deque<Integer> dataStack;
    Deque<Integer> maxStack;
    /** initialize your data structure here. */
    public MaxStack() {
        dataStack=new ArrayDeque<>();
        maxStack=new ArrayDeque<>();
    }
    
    public void push(int x) {
         dataStack.offerFirst(x);
        if(maxStack.isEmpty() || x>=maxStack.peekFirst())
            maxStack.offerFirst(x);
    }
    
    public int pop() {
        int x=dataStack.pollFirst();
        if(x==maxStack.peekFirst())
            maxStack.pollFirst();
        return x;
    }
    
    public int top() {
         return dataStack.peekFirst();  
    }
    
    public int peekMax() {
         return maxStack.peekFirst();
    }
    
    public int popMax() {
        int max = peekMax();
        Deque<Integer> buffer =new ArrayDeque<>();;
        while (top() != max) buffer.push(pop());
        pop();
        while (!buffer.isEmpty()) push(buffer.pop());
        return max;
    }
}



LC 256:

//similar the previous leetcode
//keep constant space complexity
class Solution {
    public int minCost(int[][] costs) {
        int gred = 0, ggreen = 0, gblue = 0;
        for (int i = 0; i < costs.length; i ++) {
            int red = Math.min(ggreen, gblue) + costs[i][0];
            int green = Math.min(gblue, gred) + costs[i][1];
            int blue = Math.min(gred, ggreen) + costs[i][2];
            gred = red;
            ggreen = green;
            gblue = blue;
        }
        int min = gred;
        min = Math.min(ggreen, min);
        min = Math.min(gblue, min);
        return min;
    }
}



LC 366:
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, res);
        return res;
    }
    
    private int dfs(TreeNode root, List<List<Integer>> res) {
        if (root == null) return 0;
        int leftLevel = dfs(root.left, res) + 1;
        int rightLevel = dfs(root.right, res) + 1;
        int level = Math.max(leftLevel, rightLevel);
        if (res.size() < level) {
            res.add(new ArrayList<>());
        } 
        res.get(level - 1).add(root.val);
        return level;
    }
}



LC 744:

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                right = mid; 
            } else {
                left = mid + 1;
            }
        }
        return (letters[left] > target) ? letters[left] : letters[0];
    }
}



LC 468:

class Solution {
    public String validIPAddress(String IP) {
        boolean v4 = isIPv4(IP);
        boolean v6 = isIPv6(IP);
        if (!v4 && !v6) return "Neither";
        else if (v6) return "IPv6";
        else return "IPv4";
    }
    
    private boolean isIPv4(String IP) {
        String[] sarr = IP.split("\\.");
        
        if (sarr.length != 4 || IP.charAt(IP.length() - 1) == '.') return false;
        for (String ele : sarr) {   
            if (ele.length() == 3) {
                if (ele.charAt(0) == '1') {
                    if (ele.charAt(1) <= '9' && ele.charAt(1) >= '0'
                       && ele.charAt(2) <= '9' && ele.charAt(2) >= '0') continue;
                } else if (ele.charAt(0) == '2') {
                    if (ele.charAt(1) <= '4' && ele.charAt(1) >= '0'
                       && ele.charAt(2) <= '9' && ele.charAt(2) >= '0') continue;
                    else if (ele.charAt(1) == '5' && ele.charAt(2) <= '5' && ele.charAt(2) >= '0') continue;
                }
            } else if (ele.length() == 2) {
                if (ele.charAt(0) <= '9' && ele.charAt(0) >= '1' && ele.charAt(1) <= '9' && ele.charAt(1) >= '0') continue;
            } else if (ele.length() == 1) {
                if (ele.charAt(0) <= '9' && ele.charAt(0) >= '0') continue;
            } 
            return false;
        }
        return true;
    }
    
    private boolean isIPv6(String IP) {
        String[] sarr = IP.split(":");
        if (sarr.length != 8 || IP.charAt(IP.length() - 1) == ':') return false;
        for (String ele : sarr) {
            if (ele.length() > 4 || ele.length() == 0) return false;
            for (char k : ele.toCharArray()) {
                if (k <= '9' && k >= '0' || k <= 'F' && k >= 'A' || k <= 'f' && k >= 'a') {
                    continue;
                } 
                return false;
            }
        }
        return true;
    }
}
//IPv6 a - f and A - F and 0 - 9
//IPv4 multiple cases

//split(), for '.' use '\\.'
//split, if char at the end, will not get "", for it use indexOf and substring, while loop


//another method
//use parseInt and carch the exceptions
public String validIPAddress(String IP) {
    if(isValidIPv4(IP)) return "IPv4";
    else if(isValidIPv6(IP)) return "IPv6";
    else return "Neither";
}

public boolean isValidIPv4(String ip) {
    if(ip.length()<7) return false;
    if(ip.charAt(0)=='.') return false;
    if(ip.charAt(ip.length()-1)=='.') return false;
    String[] tokens = ip.split("\\.");
    if(tokens.length!=4) return false;
    for(String token:tokens) {
        if(!isValidIPv4Token(token)) return false;
    }
    return true;
}
public boolean isValidIPv4Token(String token) {
    if(token.startsWith("0") && token.length()>1) return false;
    try {
        int parsedInt = Integer.parseInt(token);
        if(parsedInt<0 || parsedInt>255) return false;
        if(parsedInt==0 && token.charAt(0)!='0') return false;
    } catch(NumberFormatException nfe) {
        return false;
    }
    return true;
}
    
public boolean isValidIPv6(String ip) {
    if(ip.length()<15) return false;
    if(ip.charAt(0)==':') return false;
    if(ip.charAt(ip.length()-1)==':') return false;
    String[] tokens = ip.split(":");
    if(tokens.length!=8) return false;
    for(String token: tokens) {
        if(!isValidIPv6Token(token)) return false;
    }
    return true;
}
public boolean isValidIPv6Token(String token) {
    if(token.length()>4 || token.length()==0) return false;
    char[] chars = token.toCharArray();
    for(char c:chars) {
        boolean isDigit = c>=48 && c<=57;
        boolean isUppercaseAF = c>=65 && c<=70;
        boolean isLowerCaseAF = c>=97 && c<=102;
        if(!(isDigit || isUppercaseAF || isLowerCaseAF)) 
            return false;
    }
    return true;
}



LC 254:

class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, 2, res, new ArrayList<Integer>());
        if (res.size() > 0) res.remove(res.size() - 1);
        return res;
    }
    
    private void dfs(int n, int start, List<List<Integer>> res, List<Integer> list) {
        if (n <= 1) {
            if (list.size() > 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        else {
            for (int i = start; i <= n; i ++) {
                if (n % i == 0) {
                    list.add(i);
                    dfs(n / i, i, res, list);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
//first method to deal with the factors problem
//keep the factor is larger than the previous one



class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if(n <= 3)  return ret;
        List<Integer> path = new LinkedList<Integer>();
        getFactors(2, n, path, ret);
        return ret;
    }
    
    private void getFactors(int start, int n, List<Integer> path, List<List<Integer>> ret){
       for(int i = start; i <= Math.sqrt(n); i++){
           //i * i <= n, to prune the tree
           if(n % i == 0 && n/i >= i){  // The previous factor is no bigger than the next
               path.add(i);
               path.add(n/i);
               ret.add(new LinkedList<Integer>(path));
               path.remove(path.size() - 1);
               getFactors(i, n/i, path, ret);
               path.remove(path.size() - 1);
           }
       }
    }
}



LC 127:

//BFS method
//the slow part is the compare two words part
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean[] visited = new boolean[wordList.size()];
        Queue<String> qu = new LinkedList<>();
        int level = 1;
        qu.offer(beginWord);
        while (!qu.isEmpty()) {
            int size = qu.size();
            level ++;
            for (int i = 0; i < size; i ++) {
                String tmp = qu.poll();
                for (int j = 0; j < wordList.size(); j ++) {
                    String com = wordList.get(j);
                    if (visited[j] || !isChild(tmp, com)) continue;
                    qu.offer(com);
                    visited[j] = true;
                    if (com.equals(endWord)) return level;
                }
            }
        }
        return 0;
    }
    
    private boolean isChild(String a, String b) {
        int counter = 0;
        for (int i = 0; i < a.length(); i ++) {
            if (a.charAt(i) != b.charAt(i)) counter ++;
            if (counter > 1) return false;
        }
        return true;
    }
}


class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Firstly, use hashSet to store wordList, if endWord is not in, return 0.
        // From the beginWord, check the word in dict diff is 1 compare to beginWord, push into queue
        // if find the target, return cur shortest num, otherwise return 0
        if(wordList == null || wordList.size() == 0) return 0;
        HashSet<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int shortest = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            shortest++;
            for(int i = 0; i < size; i++) {
                String cur = queue.poll();
                for(int j = 0; j < cur.length(); j++) {
                    char[] arr = cur.toCharArray();
                    // for each position in cur string, check whether there has same string in dict which diff is 1
                    for(char c = 'a'; c <= 'z'; c++) {
                        if(arr[j] == c) continue;
                        arr[j] = c;
                        String nS = new String(arr);
                        if(set.contains(nS)) {
                            if(nS.equals(endWord)) return shortest;
                            set.remove(nS);
                            queue.offer(nS);
                        }
                    }
                }
            }
        }
        return 0;
    }
}



LC 636:

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] time = new int[n];
        Stack<Case> st = new Stack<>();
        for (String log : logs) {
            String[] detail = log.split(":");
            Case cur = new Case(Integer.parseInt(detail[2]), Integer.parseInt(detail[0]));
            if (detail[1].equals("start")) st.push(cur);
            else {
                Case before = st.pop();
                int timeTake = cur.time - before.time + 1;
                time[before.func] += timeTake - before.takeUp;
                if (!st.isEmpty()) {
                    st.peek().takeUp += timeTake;
                }
            }
        }
        return time;
    }
}

class Case {
    int func;
    int takeUp;
    int time;
    public Case(int t, int f) {
        time = t;
        func = f;
        takeUp = 0;
    }
}



//convert all start or end time to the same standard
public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        int ptime = 0, running = 0;
        Stack<Integer> stack = new Stack<>();

        for (String log : logs) {
            String[] split = log.split(":");
            int func = Integer.parseInt(split[0]);
            boolean start = split[1].equals("start");
            int time = Integer.parseInt(split[2]);
            if (!start)
                time++;

            res[running] += (time - ptime);
            if (start) {
                stack.push(running);
                running = func;
            } else {
                running = stack.pop();
            }
            ptime = time;
        }
        return res;
    }



LC 265:

//corner case, 0
//corner case, 1 color
class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        if (costs[0].length == 1) return costs[0][0];
        
        int[] gMin = new int[costs[0].length];
        for (int i = 0; i < costs.length; i ++) {
            int[] min = new int[costs[0].length];
            int min1 = -1, min2 = -1;
            for (int j = 0; j < gMin.length; j ++) {
                if (min1 == -1 || gMin[j] < gMin[min1]) {
                    min2 = min1;
                    min1 = j;
                } else if (min2 == -1 || gMin[j] < gMin[min2]) {
                    min2 = j;
                }
            }
            for (int j = 0; j < min.length; j ++) {
                if (j != min1) {
                    min[j] += gMin[min1] + costs[i][j];
                } else if (j == min1) {
                    min[j] += gMin[min2] + costs[i][j];
                }
            }
            gMin = min;
        }
        int res = Integer.MAX_VALUE;
        for (int ele : gMin) {
            res = Math.min(res, ele);
        }
        return res;
    }
}



class Solution {
    //f[i][j] = min(f[i- 1][k]) + cost[i - 1][j] {k != j} O(N*K*K)
    //f[i][j] = min(cost[i - 1][j] + min1 / min2) {if j = minj, choose min2; else choose min1} O(N*K)
    public static int minCostII(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) return 0;
        int n = costs.length, k = costs[0].length;
        if (k == 1 && n != 1) return Integer.MAX_VALUE;
        int min1 = 0, min2 = 0, minj = -1, m1 = min1, m2 = min2, mj = minj;
        int[] f = new int[k];
        for (int i = 0; i < n; i++) {
            m1 = min1; m2 = min2; mj = minj;
            min1 = Integer.MAX_VALUE;  min2 = Integer.MAX_VALUE; minj = -1;
            for (int j = 0; j < k; j++) {
                    f[j] = (mj == j ? m2 : m1) + costs[i][j]; 
                    if (f[j] < min1) {
                        min1 = f[j];
                        minj = j;
                    } 
                }
            for (int j = 0; j < k; j++) {
                    if (f[j] < min2 && j != minj) {
                        min2 = f[j];
                    } 
            
            }
        }
        return min1;
    }
}
//another method

LC 57
LC 146

































