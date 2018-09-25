LC 815:

class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (routes == null || routes.length == 0 || routes[0].length == 0) return -1;
        if (S == T) return 0;
        
        Map<Integer, Set<Integer>> stops = new HashMap<>();
        for (int i = 0; i < routes.length; i ++) {
            for (int j = 0; j < routes[i].length; j ++) {
                int stop = routes[i][j];
                if (stops.containsKey(stop)) {
                    stops.get(stop).add(i);
                } else {
                    Set<Integer> buses = new HashSet<>();
                    buses.add(i);
                    stops.put(stop, buses);
                }
            }
        }
        
        if (!stops.containsKey(S) || !stops.containsKey(T)) return -1;
        
        boolean[] visited = new boolean[routes.length];
        Queue<Integer> next = new LinkedList<>();
        next.offer(S);
        int level = 0;
        
        while (!next.isEmpty()) {
            int size = next.size();
            level ++;
            for (int i = 0; i < size; i ++) {
                int stop = next.poll();
                Set<Integer> routesOfStop = stops.get(stop);
                for (Integer route : routesOfStop) {
                    if (visited[route]) continue;
                    for (int j = 0; j < routes[route].length; j ++) {
                        if (routes[route][j] == T) return level;
                        next.offer(routes[route][j]);
                    }
                    visited[route] = true;
                }
            }
        }
        
        return -1;
    }
}


//another method with same idea
class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
       HashSet<Integer> visited = new HashSet<>();
       Queue<Integer> q = new LinkedList<>();
       HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
       int ret = 0; 
        
       if (S==T) return 0; 
        
       for(int i = 0; i < routes.length; i++){
            for(int j = 0; j < routes[i].length; j++){
                ArrayList<Integer> buses = map.getOrDefault(routes[i][j], new ArrayList<>());
                buses.add(i);
                map.put(routes[i][j], buses);                
            }       
        }
                
       q.offer(S); 
       while (!q.isEmpty()) {
           int len = q.size();
           ret++;
           for (int i = 0; i < len; i++) {
               int cur = q.poll();
               ArrayList<Integer> buses = map.get(cur);
               for (int bus: buses) {
                    if (visited.contains(bus)) continue;
                    visited.add(bus);
                    for (int j = 0; j < routes[bus].length; j++) {
                        if (routes[bus][j] == T) return ret;
                        q.offer(routes[bus][j]);  
                   }
               }
           }
        }
        return -1;
    }
}



LC 753:

class Solution {
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        Set<String> store = new HashSet<>();

        helper(sb, store, n, k);
        return sb.toString();
    }
    
    private boolean helper(StringBuilder sb, Set<String> set, int n, int k) {
        int len = sb.length();
        if (set.size() == (int) Math.pow(k, n)) {
            return true;
        } else {
            for (int i = 0; i < k; i ++) {
                sb.append(i);
                //System.out.println(sb.toString());
                
                if (len - n + 1 >= 0)  {
                    String str = sb.substring(len - n + 1);
                    if (!set.contains(str)) {
                        set.add(str);
                        if (helper(sb, set, n, k)) return true;
                        set.remove(str);
                    }
                } else if (helper(sb, set, n, k)) {
                    return true;
                }
                sb.setLength(len);
            }
            return false;
        }
    }
}
//use boolean here
//so the dfs will terminate at leaves
//or it will return to root and then terminate

//StringBuilder, substring to get one piece of code


LC 486:

class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if (nums.length == 1) return true;
        
        int totalNum = nums.length;
        int[][] dp = new int[totalNum][totalNum];
        
        for (int len = 1; len <= totalNum; len ++) {
            for (int i = 0; i + len <= totalNum; i ++) {
                int j = i + len - 1;
                if (len == 1) {
                    dp[i][j] = nums[i];
                } else {
                    dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
                }
            }
        }
        
        return dp[0][totalNum - 1] >= 0;
    }
}

//dp[i][j] saves how much more(!!!) scores that 
//the first-in-action player will get from i to j than the second player


//improve to O(n) space complexity
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if (nums.length == 1) return true;
        
        int totalNum = nums.length;
        int[] dp = new int[totalNum];
        
        for (int len = 1; len <= totalNum; len ++) {
            for (int i = 0; i + len <= totalNum; i ++) {
                int j = i + len - 1;
                if (len == 1) {
                    dp[i] = nums[i];
                } else {
                    dp[i] = Math.max(nums[i] - dp[i + 1], nums[j] - dp[i]);
                }
            }
        }
        
        return dp[0] >= 0;
    }
}





















































