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


