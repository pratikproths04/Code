LC 904:

class Solution {
    public int totalFruit(int[] tree) {
        if (tree == null || tree.length == 0) return 0;
        
        int slow = 0, fast = 0, max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (fast < tree.length) {
            map.put(tree[fast], map.getOrDefault(tree[fast], 0) + 1);
            while (slow < fast && map.size() > 2) {
                int number = map.get(tree[slow]) - 1;
                if (number == 0) {
                    map.remove(tree[slow]);
                } else {
                    map.put(tree[slow], number);
                }
                slow ++;
            }
            max = Math.max(max, fast - slow + 1);
            fast ++;
        }
        return max;
    }
}
//one mutant of two pointer type questions


LC 269:

//I have no words to say!
class Solution {
    public String alienOrder(String[] words) {
        boolean[][] adj = new boolean[26][26];
        int[] indegree = new int[26];
        int[] counter = new int[1];
        Arrays.fill(indegree, -1);
        buildAdj(adj, words, indegree, counter);
        
        boolean[] visited = new boolean[26];
        Queue<Character> qu = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        while (counter[0] > 0) {
            for (int i = 0; i < 26; i ++) {
                if (indegree[i] == 0 && !visited[i]) {
                    qu.offer((char)(i + 'a'));
                    visited[i] = true;
                }
            }
            if (qu.isEmpty() && counter[0] > 0) return "";
            int size = qu.size();
            for (int i = 0; i < size; i ++) {
                char tmp = qu.poll();
                sb.append(tmp);
                counter[0] --;
                for (int j = 0; j < 26; j ++) {
                    if (adj[tmp - 'a'][j]) {
                        indegree[j] --;
                    }
                }
            }
        }
        return sb.toString();
    }
    
    private void buildAdj(boolean[][] adj, String[] words, int[] indegree, int[] counter) {
        for (int i = 0; i < words.length; i ++) {
            for (char k : words[i].toCharArray()) {
                if (indegree[k - 'a'] == -1) {
                    indegree[k - 'a'] = 0;
                    counter[0] ++;
                }
            }
            if (i > 0) {
                int len = Math.min(words[i - 1].length(), words[i].length());
                for (int j = 0; j < len; j ++) {
                    char a = words[i - 1].charAt(j);
                    char b = words[i].charAt(j);
                    if (a != b) {
                        if (!adj[a - 'a'][b - 'a']) indegree[b - 'a'] ++;
                        adj[a - 'a'][b - 'a'] = true;
                        break;
                    }
                }
            }
        }
    }
}



//another method
public String alienOrder(String[] words) {
    List<Set<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < 26; i++) {
        adj.add(new HashSet<Integer>());
    }
    int[] degree = new int[26];
    Arrays.fill(degree, -1);
    
    for (int i = 0; i < words.length; i++) {
        for (char c : words[i].toCharArray()) {
            if (degree[c - 'a'] < 0) {
                degree[c - 'a'] = 0;
            }
        }
        if (i > 0) {
            String w1 = words[i - 1], w2 = words[i];
            int len = Math.min(w1.length(), w2.length());
            for (int j = 0; j < len; j++) {
                int c1 = w1.charAt(j) - 'a', c2 = w2.charAt(j) - 'a';
                if (c1 != c2) {
                    if (!adj.get(c1).contains(c2)) {
                        adj.get(c1).add(c2);
                        degree[c2]++;
                    }
                    break;
                }
                if (j == w2.length() - 1 && w1.length() > w2.length()) { // "abcd" -> "ab"
                    return "";
                }
            }
        }
    }
    
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < degree.length; i++) {
        if (degree[i] == 0) {
            q.add(i);       
        }
    }
    
    StringBuilder sb = new StringBuilder();
    while (!q.isEmpty()) {
        int i = q.poll();
        sb.append((char) ('a'  + i));
        for (int j : adj.get(i)) {
            degree[j]--;
            if (degree[j] == 0) {
                q.add(j);        
            }
        }
    }
    
    for (int d : degree) {
        if (d > 0) {
            return "";
        }
    }
    
    return sb.toString();
}



//another method
private final int N = 26;
public String alienOrder(String[] words) {
    boolean[][] adj = new boolean[N][N];
    int[] visited = new int[N];
    buildGraph(words, adj, visited);

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < N; i++) {
        if(visited[i] == 0) {                 // unvisited
            if(!dfs(adj, visited, sb, i)) return "";
        }
    }
    return sb.reverse().toString();
}

public boolean dfs(boolean[][] adj, int[] visited, StringBuilder sb, int i) {
    visited[i] = 1;                            // 1 = visiting
    for(int j = 0; j < N; j++) {
        if(adj[i][j]) {                        // connected
            if(visited[j] == 1) return false;  // 1 => 1, cycle   
            if(visited[j] == 0) {              // 0 = unvisited
                if(!dfs(adj, visited, sb, j)) return false;
            }
        }
    }
    visited[i] = 2;                           // 2 = visited
    sb.append((char) (i + 'a'));
    return true;
}

public void buildGraph(String[] words, boolean[][] adj, int[] visited) {
    Arrays.fill(visited, -1);                 // -1 = not even existed
    for(int i = 0; i < words.length; i++) {
        for(char c : words[i].toCharArray()) visited[c - 'a'] = 0;
        if(i > 0) {
            String w1 = words[i - 1], w2 = words[i];
            int len = Math.min(w1.length(), w2.length());
            for(int j = 0; j < len; j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if(c1 != c2) {
                    adj[c1 - 'a'][c2 - 'a'] = true;
                    break;
                }
            }
        }
    }
}



LC 692:

//can you believe it? this method is very fast!
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length == 0 || k == 0) return new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>(k, new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
                if (map.get(a) == map.get(b)) {
                    return a.compareTo(b);
                } else {
                    return - map.get(a) + map.get(b);
                }
            }
        });
        for (Map.Entry<String, Integer> element : map.entrySet()) {
            pq.offer(element.getKey());
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k && !pq.isEmpty(); i ++) {
            res.add(pq.poll());
        }
        return res;
    }
}
//cannot use new ArrayList<>(pq) here
//priorityqueue does not store data in the decreasing or increasing order
//it is like the binary tree, something like that





















