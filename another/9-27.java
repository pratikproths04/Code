LC 248:

public class Solution {
    private static char[][] pairs = new char[][]{{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    public int strobogrammaticInRange(String low, String high) {
        if(low.length()>high.length() || low.length()==high.length() && high.compareTo(low)<0) return 0;
        return strobogrammaticInRangeFrom0(high, true) - strobogrammaticInRangeFrom0(low, false);
    }
    private int strobogrammaticInRangeFrom0(String num, boolean inclusive){
        int len = num.length();
        if(len == 1){
            if(num.charAt(0) == '0')        return inclusive ? 1 : 0;       // 0?
            else if(num.charAt(0) == '1')   return inclusive ? 2 : 1;       // 0,1?
            else if(num.charAt(0) < '8')    return 2;                       // 0,1
            else if(num.charAt(0) == '8')   return inclusive ? 3 : 2;       // 0,1,8?
            else                            return 3;                       // 0,1,8
        }
        int sum = 0;
        for(int i = 1; i < len; i++)
            sum += strobogrammaticDigit(i, true);
        sum += strobogrammaticInRangeSameDigits(new char[len], 0, len - 1, num.toCharArray(),inclusive);
        return sum;
    }
    private int strobogrammaticInRangeSameDigits(char[] chs, int i, int j, char[] upper, boolean inclusive){
        int sum = 0;
        if(i > j){
            if( inclusive && compareCharArray(upper, chs, chs.length-1 ) >= 0 || !inclusive && compareCharArray(upper, chs, chs.length-1) > 0 )    return 1;
            else    return 0;
        }
        for(char[] pair: pairs){
            if(i == 0 && pair[0] == '0' || i==j && (pair[0] == '6' || pair[0] == '9') )     continue;
            chs[i] = pair[0];
            chs[j] = pair[1];
            if(compareCharArray(chs, upper, i) > 0)     break;
            sum += strobogrammaticInRangeSameDigits(chs, i+1, j-1, upper, inclusive);
        }
        return sum;
    }
    private int strobogrammaticDigit(int digit, boolean outside){
        if(digit == 0)      return 1;
        if(digit == 1)      return 3;
        return outside? strobogrammaticDigit(digit-2, false)*4: strobogrammaticDigit(digit-2, false)*5;
    }
    private int compareCharArray(char[] arr1, char[] arr2, int idx){
        for(int i = 0; i <= idx; i++)
            if(arr1[i] == arr2[i])          continue;
            else if(arr1[i] > arr2[i])      return 1;
            else                            return -1;
        return 0;
    }
}
//the idea is to 
//upperbound(inclusive) - lowerbound(exclusive)
//can try to implement it

//==============================================================
//==============================================================

公交车管理问题

公交车站里面有若干公共汽车， 类似这样 terminal:{bus1, bus2, bus3, ...}， bus是一个类， 
有int id, String company和一个出发时间 int time. 然后让实现几个函数 :
- add(bus) 向一个车站里加入一辆车
- getnext() 得到下一辆出发的车
- dispatch() 让下一辆车从车站出发
- removeAll(company) 除掉车站中某一个公司的所有车。

问每个函数的时间复杂度。
Map<String, PriorityQueue> companyToQueue，k个company，每个队列长度为L，则
- add(bus): O(logL)
- getNext(): O(k)
- dispatch(): O(k)
- removeAll(company): O(1)
//==============================================================
//==============================================================

Choose a random point uniformly in the list of rectangles
Given a list of rectangles which are  not intersect with others  ,
each rectangle has four points, write a method to choose a point 
uniformly for the list of rectangles

//first choose the rectangle, then given a random point within the rectangle

1 算所有的矩形的面积和 S 然后给每一个矩形分配一个对应的区间 比如 3个矩形的面积分别是1 ，4，9 
	那可以分别分配[0,1],[1,5],[5,14]
2 随机产生[0，S] 里的数 通过这个数落在哪个区间里来决定哪个矩形被选中.
3 在这个矩形里 根据分别在x 和y 的方向上产生随机坐标 得到的点就是符合要求的点
//==============================================================
//==============================================================

Speed Cluster

input是int[] speeds 长度是n 每个值的范围是1到n代表 没有duplicate 。
	描述了一个cluster的概念 ，example: {2, 4} 车速为4的位置但是并不能用4的速度来开，因为前面的车速为2。
	所以这两个 车是一个cluster。再比如{2，4，3}, 3虽然比4小但是不能开到3因为前车是2.
	所以这三个车也是一 个cluster。{2,4,3,1,5} 的话 2,4,3是一个cluster，1,5是一个cluster 
	要去输出List<Integer> 为各个 cluster的长度。

遍历一遍记录最小值么，如果没发现一个新的最小值的话就属于当前cluster，发现一个新 的最小值就另起一个cluster。

Follow-up:黑姐姐说你刚才的那个function已经存在了 List<Integer> clustersLens(int[] speeds). 
	现在我要加一个车速n+1到speeds里面，我能插入的位置是0-n这n+1个index。
	每插入不同的位置 新的List<Integer> clusterLens 会变成什么样。

新加的车速就是最大的车速，加在任何位置就只会影响那个位置的cluster 的len，从len变成len+1。
	corner case就是加在第一个位置，会出来一个1为长度的cluster。
//==============================================================
//==============================================================

Double map with eplision

设计一个map, map有一个eplison 比如 0.1 key是 double
	put ( 2.0, "hello")
	get的时候在 如果查询的key在 ( original key - eplison, original key + eplison )的范围内，
	则返回 original key的value. 
	比如这个栗子
	get(2.05) -> hello get(1.98) -> hello


如果epsilon 是0.1，代表最小精度是0.1, 1/0.1 = 10, 10就是用来计算bucket的multipler
	如果put(1.2, "hello") ，那就把 (1.2， "hello")这个pair放到 1.2 x 10 = 12 的bucket里面
	如果要查找 get( 1.22) , 那么就去bucket 1.22 * 10 = 12的bucket 
	和他的两边邻居的bucket里面找 ( 11， 13，这个case直接在12就找到了，那么返回hello)
	如果查 get(1.12)， 那么就去 bucket 1.12 * 10 = 11的bucket 和他两遍邻居(10, 12)找
	因为epsilon是0.1. 如果我们把每个bucket的范围限制在0.1 (方便计算，乘以multipler映射成整 数)，
	那么我们知道符合结果的key如果存在，那么一定在他整数映射的bucket或者他两遍的邻居 里面。

//==============================================================
//==============================================================

用preorder和postorder建树
//==============================================================
//==============================================================
返回words里 包含了所有目标字符串里的所有char 的词中最短的那个

input: 一些字符串words， 一个目标字符串， 要求返回words里 包含了所有目标字符串里的所有 char 的词中最短的那个。
	eg: words = [study, haha, stone, school, star, store] 
	target = "rts", 需要返回 的词是star, 因为 star 包含了所有rts, 同时也是最短。
	follow-up: 多种方法优化这道题的方法， 楼主先排序 (要求写出查找的平均时间复杂度)，
	楼主还答了可以把words 存成 s: study, stone, school, star, stor; 
	t : star, stone, store..... 这样的 map,  好处是我们查找的时候只需要看target里出现过的char所对应的词，
	然后找并集，在目标字 符串很小的情况下有可能会省很多时间。
//==============================================================
//==============================================================
Find string matching from stream

	给一个char stream, 有next(), 和hasNext(), 两个API。 
	给一些字符串作为目标字符串。要求每当 char stream里出现目标字符串任何一个词，就打印这个词。
	比如目标 'abc, att, bba, bc, abce', 然后我们对char stream call next， 
	出来的一些char 是 t, a, b, c, e, t.... 我们需要打印 abc, bc, abce

	把词典的word逆序后建Trie树 ，
	再用一个vector存最近遇到的 max_length_of_word_in_dict个char，
	每次来一个char就逆序构造string到Trie中查找

	反着建的话，从stream尾到stream头O(n)遍历一遍就能找到所有match到的词。
	从stream头到 stream尾正着走的话，要考虑到每一个字符都作为match开头的情况，所以要检查O(n^2)次。
//==============================================================
//==============================================================
Triangle array search

定义是先increase后decrease，无duplicate，要求 
	- 判断是否是triangle sorted:iteration O(n) 
	- 找min:O(1)
	- 找max peak:binary search, O(logn)
	- 找target number:按照peak位置分成两半，然后二分，O(log n)
//==============================================================
//==============================================================
数组shuffle问题
	数组1是排好序的1-n个数字，数组2是根据数组1 shuffle得出，给定数组3，
	要求根据一样的 shuffle规则变换成数组4，输出数组4。
	第一个follow up，如果数组一是无重复数字组成的无序数组，如何做
	第二个follow up，数组1有重复。

	假如arr1 = {1, 2, 3, 4}, arr2 = {4, 2, 1, 3}
	首先需要预处理arr2，得到val2NewIndex map 然后遍历arr1，新建index2NewIndex，
	那么index2NewIndex.put(i, val2NewIndex.get(a[i])) 
	对于arr3，根据index2NewIndex逐个填写元素到arr4中即可。
Follow-up 1
	跟上面做法相同
Follow-up 2
	将val2NewIndex map的每个值变成List<Integer>就行了
//==============================================================
//==============================================================
拿卡片游戏
每张卡片都有一个值，给定一堆卡片从一头拿，每次可以拿一到三张，两人轮流拿，求最高得 分。考虑卡片值为负的情况。

dp[i] is the how much more score of current player choosing from arr[i] to arr[n - 1]
dp[i] = sum[i] - dp[i + k], 1 <= k <= 3, sum[i] is sum of arr[i] to arr[n - 1]
return max(dp[0], sum[0] - dp[0]), because dp[0] is the max score of player1, 
and sum[0] - dp[0] is the max score of player2.
//==============================================================
//==============================================================
maximum vacation days
有几座城市，每个月在每个城市都有不同的假期，然后每个城市有飞往不同城市的航班，求最大 能获取的假期和Path.
dp(i)(j) 代表第i个月在第j个城市所能获得的最大假期. 
DP 方程大概是 dp(i)(j) = Math.max(dp(i-1)(fromCity)+map(i)(j), dp(i)(j)
//==============================================================
//==============================================================

LC 353:
class SnakeGame {
    
    boolean[][] snake;
    int[][] foods;
    int foodNow;
    ListNode head;
    ListNode tail;
    int score;
    
    Map<String, int[]> directions;

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        foods = food;
        foodNow = 0;
        snake = new boolean[height][width];
        head = new ListNode(0,0);
        tail = head;
        snake[0][0] = true;
        score = 0;
        directions = new HashMap<String, int[]>();
        
        directions.put("U", new int[]{-1,0});
        directions.put("L", new int[]{0,-1});
        directions.put("R", new int[]{0,1});
        directions.put("D", new int[]{1,0});
        
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int newRow = head.row + directions.get(direction)[0]; 
        int newCol = head.col + directions.get(direction)[1];
        if (newRow < 0 || newRow >= snake.length || newCol < 0 || newCol >= snake[0].length || 
            snake[newRow][newCol] && (newRow != tail.row || newCol != tail.col)) return -1;
        ListNode nextNode = new ListNode(newRow, newCol);
        if (foodNow < foods.length && newRow == foods[foodNow][0] && newCol == foods[foodNow][1]) {
            head.prev = nextNode;
            nextNode.next = head;
            head = nextNode;
            score ++;
            foodNow ++;
        } else {
            head.prev = nextNode;
            nextNode.next = head;
            head = nextNode;
            
            snake[tail.row][tail.col] = false;
            ListNode newTail = tail.prev;
            newTail.next = null;
            tail.prev = null;
            tail = newTail;
        }
        snake[newRow][newCol] = true;
        return score;
    }
}

class ListNode {
    int row;
    int col;
    ListNode prev;
    ListNode next;
    public ListNode(int r, int c) {
        row = r;
        col = c;
    }
}

//my method
//use a double linkedlist to represent the snake
//use a boolean array to give the position of the snake
//keep updating
//the key is that, the return -1 condition, it is or instead of and
判断是否撞到自己时，要区分撞到身体还是撞到尾巴，撞到尾巴可 能不会造成实际碰撞(因为尾巴会向前移动)，
但是有一种corner case就是，snake size = 2， 然后向后撞向尾巴，会game over。

class SnakeGame {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
class Position{
        int x;
        int y;
        public Position(int x,int y){
            this.x = x;
            this.y = y;
        }
        public boolean isEqual(Position p){
            return this.x==p.x && this.y == p.y ;
        }
    }
    int len;
    int rows ,cols;
    
    int[][] food;
    LinkedList<Position> snake;
   
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.rows = height;
        this.cols = width;
        this.food = food;
   
        snake = new LinkedList<Position>();
        snake.add(new Position(0,0));
        len = 0;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
    	//if(len>=food.length) return len;
    
        Position cur = new Position(snake.get(0).x,snake.get(0).y);
        
        switch(direction){
        case "U": 
            cur.x--;  break;
        case "L": 
            cur.y--; break;
        case "R": 
            cur.y++;   break;
        case "D": 
            cur.x++;   break;
        }
        
        if(cur.x<0 || cur.x>= rows || cur.y<0 || cur.y>=cols) return -1;
        

        for(int i=1;i<snake.size()-1;i++){
            Position next = snake.get(i);
            if(next.isEqual(cur)) return -1;	       
        }
        snake.addFirst(cur);     
        if(len<food.length){
            Position p = new Position(food[len][0],food[len][1]);	        
            if(cur.isEqual(p)){	            
                len++;
            }
        }
        while(snake.size()>len+1) snake.removeLast();
       
        return len;
    }

}

//the use of switch statement
//another way is to use deque and set, use hash to get the position into an integer

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



LC 750:

class Solution {
    public int countCornerRectangles(int[][] grid) {
        if (grid.length == 1 || grid[0].length == 1) return 0;
        int res = 0;
        for (int i = 0; i + 1 < grid.length; i ++) {
            for (int j = i + 1; j < grid.length; j ++) {
                int count = 0;
                for (int k = 0; k < grid[0].length; k ++) {
                    if (grid[i][k] == 1 && grid[j][k] == 1) count ++;
                }
                res += count * (count - 1) / 2;
            }
        }
        return res;
    }
}
//fix two row, find corresponding cols with 2 '1'
//time complexity O(n^2 * m) m = col.length, n = row.length

class Solution {
    public int countCornerRectangles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[n][n];
        int res = 0;
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(grid[i][j] != 1) continue;
                for(int k = j+1;k < n;k++) {
                    if(grid[i][k] == 1) {
                        res += dp[j][k];
                        dp[j][k]++;
                    }
                }
            }
        }
        return res;
    }
}
//dp solution


LC 337:

class Solution {
    public int rob(TreeNode root) {
        return helper(root, new HashMap<TreeNode, Integer>());
    }
    
    private int helper(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int sum = root.val;
        if (root.left != null) sum = sum + helper(root.left.left, map) + helper(root.left.right, map);
        if (root.right != null) sum = sum + helper(root.right.left, map) + helper(root.right.right, map);
        int temp = Math.max(sum, helper(root.left, map) + helper(root.right, map));
        map.put(root, temp);
        return temp;
    }
}
//the use of hashmap, store corresponding value at that node
//which can help save the time



public int rob(TreeNode root) {
    int[] res = dfs(root);
    return Math.max(res[0], res[1]);
}
private int[] dfs(TreeNode root) {
    if (root == null) {
        return new int[2];
    }
    int[] left = dfs(root.left);
    int[] right = dfs(root.right);
    int[] res = new int[2];
    res[0] = left[1] + right[1] + root.val;
    res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    return res;
}
//same idea, different coding ways
//this return array, 0 is the position for adding the root val
//1 is for not adding, taking its children 


//============================================================
//============================================================


对角线，行，列都可以转换成

//============================================================
//============================================================


LC 737:

class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        
        Map<String, String> map = new HashMap<>();
        
        for (String[] pair : pairs) {
            if (!map.containsKey(pair[0])) map.put(pair[0], pair[0]);
            if (!map.containsKey(pair[1])) map.put(pair[1], pair[1]);
            String root1 = find(pair[0], map);
            String root2 = find(pair[1], map);
            if (!root1.equals(root2)) {
                map.put(root2, root1);
            }
        }
        for (int i = 0; i < words1.length; i ++) {
            String root1 = find(words1[i], map);
            String root2 = find(words2[i], map);
            if (!root1.equals(root2)) {
                return false;
            }
        }
        return true;
    }
    
    private String find(String word, Map<String, String> map) {
        if (!map.containsKey(word)) return word;
        while (!map.get(word).equals(word)) {
            String root = map.get(word);
            map.put(word, map.get(root));
            word = root;
        }
        return word;
    }
}



public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] 
pairs) {
    if (words1.length != words2.length) 
        return false;
    
    //save the relationship of child-parent, key is child and value is parent
    Map<String, String> parent = new HashMap<>();
    
    for (String[] s : pairs) {
        String p1 = findParent(s[0], parent);
        String p2 = findParent(s[1], parent);
        
        //if p1 doesn't equal to p2, we need setup relationship between them.
        //make one as parent of the other. Here I make p2 as parent of p1.
        if (!p1.equals(p2)) {
            parent.put(p1, p2);
        }
    }
    
    int len = words1.length;
    
    for (int i = 0; i < len; i++) {
        String p1 = findParent(words1[i], parent);
        String p2 = findParent(words2[i], parent);
        
        //If no relationship found for p1 and p2, that means they're not similar word.
        if (!p1.equals(p2)) {
            return false;
        }
    }
    
    return true;
}

//Find the very top parent of s. If no parent found for s, return s itself.
String findParent(String s, Map<String, String> parent) {
    if (parent.containsKey(s)) {
        return findParent(parent.get(s), parent);
    }
    return s;
}
//the use of findParent(), this method is elegant and can give answer as well as
//if the map does not contains the key 


































































