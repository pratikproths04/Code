LC 212:

class Solution {
    
    private int[][] around = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || board[0].length == 0) return new ArrayList<>();
        
        Set<String> list = new HashSet<>();
        for (String word : words) {
            if (list.contains(word)) continue;
            if (checkWord(board, word)) {
                list.add(word);
            }
        }
        return new ArrayList<>(list);
    }
    
    private boolean checkWord(char[][] board, String word) {
        if (word.length() == 0) return false;
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    visited[i][j] = true;
                    if (bfs(board, visited, i, j, word, 1)) return true;
                }
            }
        }
        return false;
    }
    
    private boolean bfs(char[][] board, boolean[][] visited, int row, int col, String word, int index) {
        if (index == word.length()) {
            return true;
        } else {
            for (int[] each : around) {
                int newRow = row + each[0];
                int newCol = col + each[1];
                
                if (newRow < 0 || newRow >= board.length || newCol < 0 ||
                   newCol >= board[0].length || visited[newRow][newCol] ||
                   board[newRow][newCol] != word.charAt(index)) continue;
                
                visited[newRow][newCol] = true;
                if (bfs(board, visited, newRow, newCol, word, index + 1)) return true;
                visited[newRow][newCol] = false;
            }
            return false;
        }
    }
}
//pay attention to the dfs method here (function bfs)
//the using of return false and return true
//also do not forget the back to origin value int the visited boolean matrix


//another method, using trie node
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
	    List<String> res = new ArrayList<>();
	    TrieNode root = buildTrie(words);
	    for (int i = 0; i < board.length; i++) {
	        for (int j = 0; j < board[0].length; j++) {
	            helper(board, i, j, root, res);
	        }
	    }
	    return res;
	}

	public void helper(char[][] dict, int i, int j, TrieNode p, List<String> res) {
	    char temp = dict[i][j];
	    if (temp == '|' || p.next[temp - 'a'] == null) return;
	    p = p.next[temp - 'a'];
	    if (p.word != null) {   // found one
	        res.add(p.word);
	        p.word = null;     // de-duplicate
	    }

	    dict[i][j] = '|';
	    if (i > 0) helper(dict, i - 1, j ,p, res); 
	    if (i < dict.length - 1) helper(dict, i + 1, j, p, res); 
	    if (j > 0) helper(dict, i, j - 1, p, res);
	    if (j < dict[0].length - 1) helper(dict, i, j + 1, p, res); 
	    dict[i][j] = temp;
	}

	public TrieNode buildTrie(String[] words) {
	    TrieNode root = new TrieNode();
	    for (String w : words) {
	        TrieNode p = root;
	        for (char c : w.toCharArray()) {
	            int i = c - 'a';
	            if (p.next[i] == null) p.next[i] = new TrieNode();
	            p = p.next[i];
	       }
	       p.word = w;
	    }
	    return root;
	}

	class TrieNode {
	    TrieNode[] next = new TrieNode[26];
	    String word;
	}
}
//use the trienode to store all possible choice and then for loop the matrix



//my version of trienode solution
class Solution {
    
    private int[][] around = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || board[0].length == 0) return new ArrayList<>();
        
        List<String> list = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                find(board, i, j, root, list);
            }
        }
        return list;
    }
    
    private void find(char[][] board, int i, int j, TrieNode root, List<String> list) {
        char tmp = board[i][j];
        if (tmp == '|' || root.next[tmp - 'a'] == null) return;
        TrieNode cur = root.next[tmp - 'a'];
        if (cur.word != null) {
            list.add(cur.word);
            cur.word = null;
        } 
        board[i][j] = '|';
        
        for (int[] each : around) {
            int newRow = i + each[0];
            int newCol = j + each[1];
            if (newRow < 0 || newRow >= board.length ||
               newCol < 0 || newCol >= board[0].length) continue;
            find(board, newRow, newCol, cur, list);
        }
        board[i][j] = tmp;
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            for (char element : word.toCharArray()) {
                if (cur.next[element - 'a'] == null) cur.next[element - 'a'] = new TrieNode();
                cur = cur.next[element - 'a'];
            }
            cur.word = word;
        }
        return root;
    }
    
    class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word;
        public TrieNode() {
            
        }
    }
}
//key here: do not have to return when you find the cur.word
//because of trie, you can continue!



LC 655:

class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int width = (int) Math.pow(2, height) - 1;
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < width; i ++) {
            list.add("");
        }
        for (int i = 0; i < height; i ++) {
            res.add(new ArrayList<>(list));
        }
        setValue(root, 0, width - 1, 0, res);
        return res;
    }
    
    private void setValue(TreeNode root, int start, int end, int height, List<List<String>> res) {
        if (start > end || height >= res.size()) return;
        int index = (end - start + 1) / 2 + start;
        res.get(height).set(index, root.val + "");
        if (root.left != null) setValue(root.left, start, index - 1, height + 1, res);
        if (root.right != null) setValue(root.right, index + 1, end, height + 1, res);
    }
    
    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
//the key is to see the math relationship among the matrix
//the width of the matrix is the total number of nodes
//the height of the matrix is the height of the tree
//and the width and height has the relationship of 2^height - 1 = width



LC 652:

//first method
//put the subtree string in the map
//the subtree string can get through post-order or pre-order
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) return new ArrayList<>();
        
        Map<String, TreeNode> map = new HashMap<>();
        check(root, map);
        List<TreeNode> list = new ArrayList<>();
        for (Map.Entry<String, TreeNode> element : map.entrySet()) {
            if (element.getValue() != null) {
                list.add(element.getValue());
            }
        }
        return list;
    }
    
    private String check(TreeNode root, Map<String, TreeNode> map) {
        if (root == null) return "#";
        String sub = check(root.left, map) + "," + check(root.right, map) + "," + root.val;
        if (map.containsKey(sub)) {
            map.put(sub, root);
        } else {
            map.put(sub, null);
        }
        return sub;
    }
}


//another method
class Solution {
    List<TreeNode> res;
    HashMap<String, Integer> map;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        res = new ArrayList<>();
        map = new HashMap<>();
        getTreeNodes(root);
        return res;
    }
    
    private String getTreeNodes(TreeNode n) {
        if (n == null) {
            return "#";
        } else {
            String left = getTreeNodes(n.left), right = getTreeNodes(n.right), str = n.val + left + right;
            map.put(str, map.getOrDefault(str, 0) + 1);
            if (map.get(str) == 2) {
                res.add(n);
            }
            return str;
        }
        
    }
    
}
//only scan once, add the integer for counter



LC 642:
class AutocompleteSystem {
    
    Map<String, Integer> map;
    StringBuilder sb;

    public AutocompleteSystem(String[] sentences, int[] times) {
        map = new HashMap<>();
        sb = new StringBuilder();
        
        for (int i = 0; i < sentences.length; i ++) {
            map.put(sentences[i], times[i]);
        }
    }
    
    public List<String> input(char c) {
        int index = sb.length();
        
        if (c == '#') {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            sb.setLength(0);
            return new ArrayList<>();
        } else {
            sb.append(c);
            PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>(){
                @Override
                public int compare(String a, String b) {
                    if (map.get(a) != map.get(b)) return map.get(b) - map.get(a);
                    else {
                        return a.compareTo(b);
                    }
                }
            });
            for (Map.Entry<String, Integer> ele : map.entrySet()) {
                if (checkPref(ele.getKey(), sb)) {
                    pq.offer(ele.getKey());
                }
            }
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 3 && pq.size() > 0; i ++) {
                list.add(pq.poll());
            }
            return list;
        } 
    }
    
    private boolean checkPref(String a, StringBuilder sb) {
        if (sb.length() > a.length()) return false;
        for (int i = 0; i < sb.length(); i ++) {
            if (a.charAt(i) != sb.charAt(i)) return false;
        }
        return true;
    }
}
//set can have new HashSet<>(list);
//the key of this method is that, using priorityqueue to give the order
//using stringbuilder to record the chars
/*
	for (String element : set) {
            if (element.equals("234")) {
                set.remove(element);
            }
        }

    cannot do this, this alters the content of the set, which causes exception
*/



class AutocompleteSystem {
    class TrieNode{
        Map<Character, TrieNode> children;
        Map<String, Integer> counts;
        boolean isWord;
        public TrieNode(){
            children = new HashMap<Character, TrieNode>();
            counts = new HashMap<String, Integer>();
            isWord = false;
        }
    }
    class Pair{
        String s;
        int count;
        public Pair(String s, int count){
            this.s = s;
            this.count = count;
        }
    }
    TrieNode root;
    String prefix;
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";
        for(int i = 0; i < times.length; i++){
            add(sentences[i], times[i]);
        }
    }
    
    private void add(String s, int count){
        TrieNode curr = root;
        for(char c : s.toCharArray()){
            TrieNode child = curr.children.get(c);
            if(child == null){
                child = new TrieNode();
                curr.children.put(c, child);
            }
            child.counts.put(s, child.counts.getOrDefault(s, 0) + count);
            curr = child;
        }
        curr.isWord = true;
    }
    
    public List<String> input(char c) {
        if(c == '#'){
            add(prefix, 1);
            prefix = "";
            return new ArrayList<>();
        }
        prefix = prefix + c;
        TrieNode curr = root;
        for(char cc : prefix.toCharArray()){
            TrieNode child = curr.children.get(cc);
            if(child == null){
                return new ArrayList<>();
            }
            curr = child;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> (a.count == b.count ? a.s.compareTo(b.s) : b.count - a.count));
        for(String s : curr.counts.keySet()){
            pq.add(new Pair(s, curr.counts.get(s)));
        }
        List<String> res = new ArrayList<>();
        for(int i = 0 ; i < 3 && !pq.isEmpty(); i++){
            res.add(pq.poll().s);
        }
        return res;
    }
}
//another method, much faster, using TrieNode, but do not know why


LC 528:

//classic use of random
//classic use of treemap api
class Solution {
    
    int sum = 0;
    TreeMap<Integer, Integer> map = new TreeMap<>();
    Random rd = new Random();
    
    public Solution(int[] w) {
        
        for (int i = 0; i < w.length; i ++) {
            sum += w[i];
            map.put(sum, i);
        }
    }
    
    public int pickIndex() {
        int key = map.higherKey(rd.nextInt(sum));
        return map.get(key);
    }
}
//key of this method is to transform the probability to the length


Like the amazon:

class Solution {

  static String[][] wordCountEngine(String document) {
    // your code goes here
    String[] arr = document.split(" +");
    Map<String, Integer> map = new HashMap<>();
    int maxNum = 0;
    for (int i = 0; i < arr.length; i ++) {
      arr[i] = process(arr[i]);
      if (arr[i].length() == 0) continue;
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
      maxNum = Math.max(maxNum, map.get(arr[i]));
    }
    String[][] res = new String[map.size()][2];
    
    Map<Integer, List<String>> bucket = new HashMap<>();
    for (int i = 0; i < arr.length; i ++) {
      if (!map.containsKey(arr[i])) continue;
      int frequent = map.get(arr[i]);
      if (bucket.containsKey(frequent)) {
        bucket.get(frequent).add(arr[i]);
      } else {
        List<String> tmpList = new ArrayList<>();
        tmpList.add(arr[i]);
        bucket.put(frequent, tmpList);
      }
      map.remove(arr[i]);
    }

    int row = 0;
    for (int i = maxNum; i > 0; i --) {
      if (!bucket.containsKey(i)) continue;
      List<String> tmpList = bucket.get(i);
      for (int j = 0; j < tmpList.size(); j ++) {
        res[row][0] = tmpList.get(j);
        res[row][1] = Integer.toString(i);
        row ++;
      }
    }
    return res;
  }
  
  static String process(String str) {
    StringBuilder sb = new StringBuilder();
    for (char each : str.toCharArray()) {
      if (each <= 'z' && each >= 'a' || each <= 'Z' && each >= 'A') {
        sb.append(each);
      }
    }
    return sb.toString().toLowerCase();
  }
}
//use the bucket sort to get the order
//do not have to sort exclusively

























































