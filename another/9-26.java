LC 399:

class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, MapNode> map = new HashMap<>();
        for (int i = 0; i < equations.length; i ++) {
            String a = equations[i][0], b = equations[i][1];
            if (!map.containsKey(a)) map.put(a, new MapNode(a, 1.0));
            if (!map.containsKey(b)) map.put(b, new MapNode(b, 1.0));
            connect(a, b, values[i], map);
        }
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i ++) {
            res[i] = query(queries[i][0], queries[i][1], map);
        }
        
        return res;
    }
    
    private String find(String id, Map<String, MapNode> map) {
        MapNode original = map.get(id);
        double recordT = original.times;
        
        MapNode cur = original;
        while (!cur.root.equals(id)) {
            id = cur.root;
            MapNode parent = map.get(cur.root);
            cur.root = parent.root;
            cur.times *= parent.times;
            recordT *= parent.times;
            cur = parent;
        }
        original.root = id;
        original.times = recordT;
        
        return id;
    }
    
    private void connect(String id1, String id2, double val, Map<String, MapNode> map) {
        String root1 = find(id1, map);       //id1 / root1 = times1      id1 / id2 = val
        String root2 = find(id2, map);       //id2 / root2 = times2      --->    root1 / root2 = times2 / times1 * val
        if (root1.equals(root2)) return;
        double rootTimes = map.get(id2).times / map.get(id1).times * val;
        map.get(root1).root = root2;
        map.get(root1).times = rootTimes;
    }
    
    private double query(String id1, String id2, Map<String, MapNode> map) {
        if (!map.containsKey(id1) || !map.containsKey(id2)) return -1;
        String root1 = find(id1, map), root2 = find(id2, map);
        if (!root1.equals(root2)) return -1;
        return map.get(id1).times / map.get(id2).times;
    }
}

class MapNode{
    String root;
    double times;
    public MapNode(String str, double val) {
        root = str;
        times = val;
    }
}
//union find method
//wrap the root string with the coresponding double times


//another method can be dfs
class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] ans = new double[queries.length];
        Map<String, Map<String, Double>> map = new HashMap<>();
        
        for(int i = 0; i < equations.length; i++){
            String a = equations[i][0];
            String b = equations[i][1];
            if(!map.containsKey(a)){
                map.put(a, new HashMap<>());
            }
            if(!map.get(a).containsKey(b)){
                map.get(a).put(b, values[i]);
            }
            
            if(!map.containsKey(b)){
                map.put(b, new HashMap<>());
            }
            if(!map.get(b).containsKey(a)){
                map.get(b).put(a, 1 / values[i]);
            }
        }
        
        for(int i = 0; i < queries.length; i++){
            if(!map.containsKey(queries[i][0]) || ! map.containsKey(queries[i][1])){
                ans[i] = - 1.0;
                continue;
            }
            
            String a = queries[i][0];
            String b = queries[i][1];
            
            Set<String> visited = new HashSet<>();
            ans[i] = DFS(a, b, map, visited);
        }
        
        return ans;
    }
    
    public double DFS(String a, String b, Map<String, Map<String, Double>> map, Set<String> visited){
        if(visited.contains(a)) return -1;
        
        visited.add(a);
        Map<String, Double> tmp = map.get(a);
        
        if(tmp.containsKey(b)){
            return tmp.get(b);
        }
        
        for(String s: tmp.keySet()){
            double product = tmp.get(s) * DFS(s, b, map,visited);
            if(product > 0){
                return product;
            }
        }
        
        return -1.0;
    }
}
//dfs method, can look and see


LC 496:

public int[] nextGreaterElement(int[] findNums, int[] nums) {
    Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
    Stack<Integer> stack = new Stack<>();
    for (int num : nums) {
        while (!stack.isEmpty() && stack.peek() < num)
            map.put(stack.pop(), num);
        stack.push(num);
    }   
    for (int i = 0; i < findNums.length; i++)
        findNums[i] = map.getOrDefault(findNums[i], -1);
    return findNums;
}
//can solve streamflow problem??? 
//only use the stack, get the next great in one array
//store the result in the map
//get the result from the map


class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(nums2.length);
        for (int i = 0; i < nums2.length; i ++) {
            map.put(nums2[i], i);
        }
        
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i ++) {
            int temp = map.get(nums1[i]);
            while (temp < nums2.length && nums2[temp] <= nums1[i]) temp ++;
            res[i] = (temp == nums2.length) ? -1 : nums2[temp];
        }
        
        return res;
    }
}
//my old version of method    


LC 249:

class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        if (strings == null || strings.length == 0) return new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();
        for (String each : strings) {
            String str = back(each);
            if (map.containsKey(str)) {
                map.get(str).add(each);
            } else {
                List<String> list = new ArrayList<>();
                list.add(each);
                map.put(str, list);
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> element : map.entrySet()) {
            res.add(element.getValue());
        }
        return res;
    }
    
    private String back(String a) {
        if (a.length() == 1) return "a";
        StringBuilder sb = new StringBuilder();
        sb.append('a');
        for (int i = 1; i < a.length(); i ++) {
            int diff = (a.charAt(i) + 26 - a.charAt(0)) % 26;
            sb.append('a' + diff);
        }
        return sb.toString();
    }
}


LC 773:

class Solution {
    public int slidingPuzzle(int[][] board) {
        int[] direcs = {-1, 1, -3, 3};
        String target = "123450";
        char[] state = new char[6];
        for (int i = 0; i < 6; i ++) {
            state[i] = (char) ('0' + board[i / 3][i % 3]);
        }
        if (target.equals(String.valueOf(state))) return 0;
        
        Queue<String> qu = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        qu.offer(String.valueOf(state));
        visited.add(String.valueOf(state));
        int step = 0;
        
        while (!qu.isEmpty()) {
            step ++;
            int size = qu.size();
            for (int i = 0; i < size; i ++) {
                String tmp = qu.poll();
                state = tmp.toCharArray();
                int zero = 0;
                while (state[zero] != '0') zero ++;
                for (int dire : direcs) {
                    state = tmp.toCharArray();
                    int index = zero + dire;
                    if (index < 0 || index > 5 || index == 3 && zero == 2 || zero == 3 && index == 2) continue;
                    state[zero] = state[index];
                    state[index] = '0';
                    String res = String.valueOf(state);
                    if (visited.contains(res)) continue;
                    // System.out.print(res + ", ");
                    
                    if (res.equals(target)) return step;
                    qu.offer(res);
                    visited.add(res);
                }
                
            }
            // System.out.println();
            // System.out.println();
        }
        
        return -1;
    }
}
//corner case for BFS
//if the beginning state is satisfy for the ending condition



Optimal list of job:



LC 347:

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int most = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            most = Math.max(most, map.get(num));
        }
        List<Integer>[] bucket = new List[most];
        for (Map.Entry<Integer, Integer> element : map.entrySet()) {
            int num = element.getKey(), freq = element.getValue();
            if (bucket[freq - 1] == null) {
                bucket[freq - 1] = new ArrayList<Integer>();
            }
            bucket[freq - 1].add(num);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && res.size() < k; i --) {
            if (bucket[i] != null) res.addAll(bucket[i]);
        }
        return res;
    }
}
//using the bucket sort
//only O(n)
//addAll() method cannot apply to null, this can throw exception


Union find, with size weighted:
constructor, O(n)
union, O(1) amortized
find, O(1) amortized
//---------------------------------
//---------------------------------


Range random query:
become the length, using the length;

follow up, given a word, get the next word frequency
Trie node --- save frequency
//---------------------------------
//---------------------------------

给定一个矩形的长宽，用多少种方法可以从左上角走到右上角 (每一步，只能向正右、右上 或 右下走)
Two pass DP即可
follow up:如果给矩形里的三个点，要求解决上述问题的同时，经过这三个点 纵向切割矩形，一个一个地做DP，然后相加
follow up:如何判断这三个点一个是合理的，即存在遍历这三个点的路经 DP时看是否可达就好了呗
follow up:如果给你一个H，要求你的路径必须向下越过H这个界，怎么做 可以再做一次 dp，但是只走 <= H 的路径，再用总数减一下
Follow up:要经过某些特定row怎么走?要先经过一个row再经过另一个row怎么走? 也是矩阵切割的思想，但是要处理先后顺序
//---------------------------------
//---------------------------------

有一张长凳一开始分散的坐着一些人，每个新来的都想坐在最宽敞的一段的中间位置，问:如何 模拟这一过程
follow up: 是如果有多个长凳该怎么办?以及如果长凳的数据太大，内存装不下又该怎么办? 
follow up: 凳子上一开始没有人，然后一个一个往里面放，每次放的时候O(1)时间求放在哪里距离 
最大(数学问题 ):优先队列，每次弹出最大的间隔，折半加入队列。

这个问题实际就是[0, n)被分成了若干个intervals。可以将intervals加入PriorityQueue，
每次新来 人的时候，取出最长的interval，split成相等的两个intervals再入队列即可。

对于Follow up，可以维护K个PriorityQueue，每次取出K个peek中最长Interval即可。

//---------------------------------
//---------------------------------
有很多自行车和很多人，如果完美匹配自行车和人，就是匹配最近的自行车和最近的人，至少有
一个解，自己设计数据结构。

这道题很开放，需要跟面试官积极交流，厘清条件。
- 比如是人多还是自行车多?如果是人多、自行车少，那么从自行车出发做计算会比较高效。
- 如果出现相等距离怎么办?例如自行车a到两个人x、y的距离相同，match谁呢?

//---------------------------------
//---------------------------------
王位继承
HashMap + DFS
HashMap to store the node and therefore get the node in O(1)
DFS give the sequence of succession

node for one person
3 fields:
    string name
    List<node> children
    boolean isDead




LC 247:

class Solution {
    private char[] candidates = {'1','6','8','9','0','1','9','8','6','0'};
    
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        helper(new char[n], 0, n - 1, res);
        return res;
    }
    
    private void helper(char[] arr, int left, int right, List<String> res) {
        if (left > right) {
            res.add(String.valueOf(arr));
            return;
        } else {
            for (int i = 0; i < 5; i ++) {
                if (left == right && (i == 1 || i == 3)) continue;
                if (left == 0 && i == 4 && arr.length > 1) continue;
                arr[left] = candidates[i];
                arr[right] = candidates[i + 5];
                helper(arr, left + 1, right - 1, res);
            }
        }
    }
}

//the key is there  are 5 numbers: 0, 1, 8, 6-9
//corner cases rule out:    length == 1 or more;
//                          only single number or two coresponding number

















































