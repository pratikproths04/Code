Amazon:

LC 819. Easy
8:51.02

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] para = paragraph.split(" ");
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < para.length; i ++) {
            para[i] = corp(para[i]);
            map.put(para[i], map.getOrDefault(para[i], 0) + 1);
        }
        
        for (String ele : banned) {
            map.remove(ele);
        }
        
        String res = null;
        for (Map.Entry<String, Integer> each : map.entrySet()) {
            if (res == null || map.get(res) < each.getValue()) res = each.getKey();
        }
        return res;        
    }
    
    private String corp(String a) {
        int len = a.length();
        char tmp = a.charAt(len - 1);
        if (tmp - 'a' > 0 && tmp - 'a' < 26 || tmp - 'A' > 0 && tmp - 'A' < 26) {
            return a.toLowerCase();
        } 
        return a.substring(0, len - 1).toLowerCase();
    }
}

time complexity O(total length of all words)
space complexity O(total length of all words)

//String toLowerCase() is use by each.toLowerCase()
//Character toLowerCase() is use by Character.toLowerCase(each)

//split:
//	there are 12 characters with special meanings: 
//		the backslash \, the caret ^, the dollar sign $, 
//		the period or dot ., the vertical bar or pipe symbol |, 
//		the question mark ?, the asterisk or star  *, the plus sign +, 
//		the opening parenthesis (, the closing parenthesis ), 
//		and the opening square bracket [, the opening curly brace {, 
//		These special characters are often called "metacharacters".	

//"Bob. " split("\\.| ") return
//		"Bob" ""
//"Bob    k" spkit(" +") return
//		"Bob" "k"


LC 200. Medium
7:50.42

class Solution {
    private int[][] around = {{0,1},{1,0},{-1,0},{0,-1}};
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int counter = 0;
        
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    counter ++;
                }
            }
        }
        
        return counter;
    }
    
    private void dfs(char[][] grid, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] || grid[row][col] == '0') return;
        visited[row][col] = true;
        for (int[] each : around) {
            dfs(grid, visited, row + each[0], col + each[1]);
        }
    }
}

time complexity O(n^2)
space complexity O(n^2)


LIN 1380:
public String[] logSort(String[] logs) {
    Comparator cm = new Comparator<String>(){
        @Override
        public int compare(String a, String b) {
            int indexA = a.indexOf(' ');
            int indexB = b.indexOf(' ');
            //
            
            String headA = a.substring(0, indexA);
            String headB = b.substring(0, indexB);
            String endA = a.substring(indexA + 1);
            String endB = b.substring(indexB + 1);
            
            if (endA.equals(endB)) return headA.compareTo(headB);
            return endA.compareTo(endB);
        }
    };
    
    String[] res = new String[logs.length];
    int counter = logs.length - 1;
    List<String> list = new ArrayList<>();
    for (int i = logs.length - 1; i >= 0; i --) {
        char tmp = logs[i].charAt(logs[i].indexOf(' ') + 1);
        if (tmp <'A') {
            res[counter --] = logs[i];
        } else {
            list.add(logs[i]);
        }
    }
    Collections.sort(list, cm);
    for (int i = 0; i < list.size(); i ++) {
        res[i] = list.get(i);
    }
    return res;
}

//use of indexOf(char/str) both right, return the first occurence index
//use of lastIndexOf(char/str), return the last occurence index, searching backward
//indexOf(char/str, index), start from index then search, (lastIndexOf, backward start from)

//compareTo, 2 string, char by char according to ASCII
//ASCII order: (space),...,1,2,3...,A,B,C,...a,b,c,...

//Collections.sort() and Arrays.sort()


LIN 386:
public int lengthOfLongestSubstringKDistinct(String s, int k) {
    if (s == null || s.length() == 0 || k == 0) return 0;
    if (s.length() <= k) return s.length();
    
    int slow = 0, fast = 0;
    int[] chars = new int[256];
    int maxNum = 0, counter = 0;
    
    while (fast < s.length()) {
        char tmp = s.charAt(fast);
        if (chars[tmp] == 0) counter ++;
        chars[tmp] ++;
        if (counter > k) {
            while (slow <= fast && counter > k) {
                chars[s.charAt(slow)] --;
                if (chars[s.charAt(slow)] == 0) counter --;
                slow ++;
            }
        }
        maxNum = Math.max(maxNum, fast - slow + 1);
        fast ++;
    }
    
    return maxNum;
}

//2 pointers, fast and slow, keep an int array as map to reduce the time cost


LIN 1454:
public String[] getWords(String s, String[] excludeList) {
    int maxNum = 0;
    Set<String> exclud = new HashSet<>(Arrays.asList(excludeList));
    Map<String, Integer> map = new HashMap<>();
    
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i ++) {
        if (chars[i] <= 'z' && chars[i] >= 'a') continue;
        else if (chars[i] <= 'Z' && chars[i] >= 'A') {
            chars[i] = Character.toLowerCase(chars[i]);
        } else {
            chars[i] = ' ';
        }
    }
    
    s = new String(chars);
    
    String[] arr = s.split(" +");
    for (String str : arr) {
        if (exclud.contains(str)) continue;
        map.put(str, map.getOrDefault(str, 0) + 1);
        maxNum = Math.max(map.get(str), maxNum);
    }
    
    List<String> res = new ArrayList<>();
    for (Map.Entry<String, Integer> ele : map.entrySet()) {
        if (ele.getValue() == maxNum) {
            res.add(ele.getKey());
        }
    }
    String[] result = new String[res.size()];
    for (int i = 0; i < res.size(); i ++) {
        result[i] = res.get(i);
    }
    
    return result;
}

//Set<String> exclud = new HashSet<>(Arrays.asList(excludeList));
//first transfer to char array, transform the chars in the array
//then split(" +")
//record the maxNum, find the corresponding string later by iterate the map


LIN 384:
public int lengthOfLongestSubstring(String s) {
    int slow = 0, fast = 0;
    int maxNum = 0;
    boolean[] visited = new boolean[256];
    while (fast < s.length()) {
        char tmp = s.charAt(fast);
        if (visited[tmp]) {
            while (slow < fast && s.charAt(slow) != tmp) {
                visited[s.charAt(slow)] = false;
                slow ++;
            }
            if (slow != fast) slow ++;
        }
        visited[tmp] = true;
        maxNum = Math.max(maxNum, fast - slow + 1);
        fast ++;
    }
    return maxNum;
}

//keep an array of visited
















