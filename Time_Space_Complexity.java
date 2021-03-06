LeetCode:

108.
	Time complexity: Master Theorm, O(n);
	Space complexity: create a new node each recursion, therefore O(n);
	
109.
	int mid = start + (end - start) / 2;
	Why space complexity is O(lonN)?
	Preorder, recursion first, then build the node;
	
		private ListNode node;

		public TreeNode sortedListToBST(ListNode head) {
			if(head == null){
				return null;
			}
			
			int size = 0;
			ListNode runner = head;
			node = head;
			
			while(runner != null){
				runner = runner.next;
				size ++;
			}
			
			return inorderHelper(0, size - 1);
		}

		public TreeNode inorderHelper(int start, int end){
			if(start > end){
				return null;
			}
			
			int mid = start + (end - start) / 2;
			TreeNode left = inorderHelper(start, mid - 1);
			
			TreeNode treenode = new TreeNode(node.val);
			treenode.left = left;
			node = node.next;

			TreeNode right = inorderHelper(mid + 1, end);
			treenode.right = right;
			
			return treenode;
		}
		
542.
	Good method of BFS;
	Learn more about BFS!
	There are still something I do not totally understand;
	Time complexity should be O(n^2);
	Space complexity should be O(n^2);
	
18.
	Time complexity should be O(n^3);
	Space complexity should be O(n);
	Why my method is so much slower than others?
		Answer: They use break & continue to accelerate!
		
454.
	Time complexity should be O(n^2);
	Space complexity should be O(n^2);
	Followed by the same thinking, why others method is about 2 times of my method?
		Increasing by if statement?
		
100.
	Time complexity should be O(n);
	Space complexity should be O(1);

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {return true;}
        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        else {
            return false;
        }
    }
	
666.
	Time complexity should be O(n), for the recursion is called n times, and takes constant time for each recursion;
	Space complexity should be O(n), for it cost O(n) to build the HashMap;
	The key to focus is this version of recursion, how to write recursion, different kinds of recursion to summary!!!
	
250.
	Time complexity should be O(n), for O(n) tiems of calling recursion and each recursion takes constant time;
	Space complexity should be O(n), for this function is called O(n) times;
	Duble method is key!!! root.val != root.left.val;
	
124.
	Time complexity should be O(n), for O(n) tiems of calling recursion and each recursion takes constant time;
	Space complexity should be O(n), for this function is called O(n) times;
	Key is reading the meaning carefully!!!
	
116.
	Time complexity should be O(n);
	Space complexity without considering the function stack is O(1);
	
117.
	TOO GOOD FOR THE SOLUTION!!!
	Time complexity should be O(n);
	Space complexity without considering the function stack is O(1);
	
199.
	Time complexity should be O(n);
	Space complexity without considering the function stack is O(1);
	
200.
	Time complexity should be O(n^2);
	Space complexity without considering the function stack is O(n^2);
	
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
	
130.
	Time complexity should be O(n^2);
	Space complexity without considering the function stack is O(1);
	
286.
	Time complexity should be O(m*n)?
	Space complexity without considering the function stack is O(1);

323.
	Time complexity should be O(n), the difference between recording the final root or not;
	Space complexity should be O(n);
	
261.
	Time complexity should be O(n);
	Space complexity should be O(n);
	
496.
	Time complexity should be O(nums1.length * nums2.length);
	Space complexity should be O(nums1.length + nums2.length);
	
503.
	Time complexity should be O(n^2);
	Space complexity should be O(n);
	
556.
	Time complexity should be O(n);
	Space complexity should be O(n);
	When the number exceed the Integer limit, use Long type is easier;
	char[] number = (n + "").toCharArray(); 
	//66666! NO COMMENT!!!
	Arrays.sort(number, i, number.length);
	//sort digits after (i - 1) in ascending order
	//the use of index is like the use in .substring()
	long val = Long.parseLong(new String(number));
	//this method create long from string
	return (val <= Integer.MAX_VALUE) ? (int) val : -1; 
	// int can compare with long type directly without losing infor
	
739.
	Time complexity should be O(n);
	Space complexity should be O(n);
	//Stack is one of the legacy classes in Java and its efficiency is quite low, no resizing by using array, accelerate a lot;
	
811.
	Time is related to the length of each string;
	So is space;
	//The use of Integer.parseInt() and the use of .split() method;
	//.split():
	//		"\\." For split by .
	//		" |\\." For split by " " and "."
	
389.
	Time complexity should be O(s.length() + t.length());
	Space complexity should be O(s.length());
	//char type does not have '' (empty char)
	
249.
	Time is related to the length of each string;
	So is space;
	//Use StringBuilder to get key, to remmember the relationship;
	//(char) 97 = 'a', use this relationship to convert from number
	//		to char;
	
311.
	Time complexity should be O(n * m * k);
	Space complexity should be O(n * k);
	//Use if judgement to accelerate
	
451.
	Use PriorityQueue to sort the map by value;
	//PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(map.size(), (a, b) -> b.getValue() - a.getValue());
	//pq.addAll(map.entrySet());
	//addAll is faster than add one by one
	//Why faster???
	//	Using StringBuilder and covert type;
	
159.
	Time complexity should be O(n);
	Space complexity should be O(1);
	//Use Array and one counter instead of map will be quicker
	class Solution {
	    public int lengthOfLongestSubstringTwoDistinct(String s) {
	        if (s.length() <= 2) return s.length();
	        
	        Map<Character, Integer> map = new HashMap<>();
	        int left = 0, right = 0, max = 0;
	        while (right < s.length()) {
	            char tmp = s.charAt(right);
	            if (!map.containsKey(tmp) && map.size() < 2) {
	                map.put(tmp, right);
	                max = Math.max(right - left + 1, max);
	            } else if (!map.containsKey(tmp)) {
	                map.put(tmp, right);
	                while (map.size() > 2) {
	                    char leftTmp = s.charAt(left);
	                    if (map.get(leftTmp) == left) {
	                        map.remove(leftTmp);
	                    }
	                    left ++;
	                }
	            } else {
	                map.remove(tmp);
	                map.put(tmp, right);
	                max = Math.max(right - left + 1, max);
	            }
	            right ++;
	        }
	        
	        return max;
	    }
	}
	
243.
	Time complexity should be O(n);
	?
	//the judgement of words should be equal also takes time
	//depend on the length of the strings
	Space complexity should be O(1);
	
244.
	//Math.abs()
	//try to avoid use map or arraylist operation
	//these operations takes a lot of time
	?//according to the source code, this should not take a lot of time
	How to analize the time complexity?
	Space complexity should be O(n);	

245.
	same as 244.
	//666 method, use only one constant to remmeber the index
	
463.
	Time complexity should be O(n);
	Space complexity should be O(1);
	//another method: one land is 4 edge, when 2 land together, -2 edges
	
36.
	Time complexity should be O(n^2);
	Space complexity should be O(1);
	//sudoku, acually is a kind of check repete or not
	//use set to check it, use string as key
	//row number + "row" + number
	//column number + "column" + number
	//cubic number + "cubic" + number
	//use one time scan, n^2 space

347.
	Time complexity should be O(nlogk + n);
	Space complexity should be O(k + n);	
	//Another way, use array to sort, because array's index is naturally sorted;
	//For each in a map, 
	List<Integer>[] frequency = new ArrayList[nums.length - 1];
	List<Integer>[] frequency = new List[nums.length - 1];
	
	for (int key : map.keySet()) {
		int temp = map.get(key);
		if (frequency[temp] == null) {
			frequency[temp] = new ArrayList<>();
		}
		frequency[temp].add(key);
	}
	
	//In this method, the time complexity is O(n);
	
500.
	Time complexity should be O(words.length sum);
	Space complexity should be O(1); //save 26 characters	
	//only save uppercase or lowercase can save half space
	//use index , when not good, set index = -1
	// in this way, index can be seen as flag
	
	String[] res = new String[list.size()];
	res = list.toArray(res);	
	
	
387.
	public int firstUniqChar(String s) {
        int[] every = new int[26];
        Arrays.fill(every, -1);
        
        char[] sarr = s.toCharArray();
        
        int res = Integer.MAX_VALUE;
        
        for (int i = 0; i < sarr.length; i ++) {
            every[sarr[i] - 'a'] = (every[sarr[i] - 'a'] != -1) ? -2 : i;
        }
        
        for (int each : every) {
            if (each != -1 && each != -2) {
                res = Math.min(res, each);
            }
        }
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }
	Time complexity should be O(s.length);
	Space complexity should be O(1);	
	
	//two pointers method, quick pointer and slow pointer
	//slow pointer only advance when its corresponding number counts more than 1 time
	public int firstUniqChar(String s) {
        
        if (s==null || s.length()==0) return -1;
        int len = s.length();
        if (len==1) return 0;
		//add special cases check, avoid copy to array first
		//or set up 256 length array, can short the time
        
        int slow = 0;
        int fast = 0;
        
        int[] visited = new int[256];
        char[] arr = s.toCharArray();
        
        while (fast < len) {
            visited[arr[fast]] ++;
            fast ++;
            
            while (slow < arr.length && visited[arr[slow]] > 1) {
				//slow must be less than arr.length
				//or it will crash
                slow ++;
            }
        }
        
        return (slow >= arr.length) ? -1 : slow;
		//pay attention to this
		//there exists situation that will not find, should return -1!
    }
	
187.
	Time complexity should be O(n);
	Space complexity should be O(n);	
	public List<String> findRepeatedDnaSequences(String s) {
		Set seen = new HashSet(), repeated = new HashSet();
		for (int i = 0; i + 9 < s.length(); i++) {
			String ten = s.substring(i, i + 10);
			//String saves as Array of char[]
			//substring use the constructor
			//	new String(char[] value, start index, length);
			if (!seen.add(ten))
				//Still will carry on in the set
				repeated.add(ten);
		}
		return new ArrayList(repeated);
		//ArrayList(collection)
		//HashSet(collection)
		//......
	}	
	
	
	
205.
	Time complexity should be O(s.length + t.length);
	Space complexity should be O(s.length + t.length);	
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.equals(t)) return true;
        
        String s1 = helper(s);
        String t1 = helper(t);
        
        return s1.equals(t1);
        
    }
    
    private String helper(String s) {
        char[] temp = s.toCharArray();
        char[] map = new char[256];
        StringBuilder sb = new StringBuilder();
        
        char order = '1';
        for (char each : temp) {
            if (map[each] == '\0') {
				//java initial char[] is '\0'
				//null character
                map[each] = order;
                sb.append(order);
                order ++;
				//char + int will be convert to int
				//int can be casted to char
            }
            else {
                sb.append(map[each]);
            }
        }
        
        return sb.toString();
    }


    //set up the map directly!
    class Solution {
	    public boolean isIsomorphic(String s, String t) {
	        //if (s != null && t == null || s == null && t != null || 
	        //    s != null && s.length() != t.length()) return false;
	        
	        int[] mapA = new int[256];
	        int[] mapB = new int[256];
	        Arrays.fill(mapA, -1);
	        Arrays.fill(mapB, -1);
	        //Arrays.fill(arr, num);
	        
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
	

350.
	Time complexity should be O(nlogn);
	Space complexity should be O(n);	
	//use array and sort it
	public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[0];
        //get the special cases done
		
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int pointer1 = 0;
        int pointer2 = 0;
        
        while (pointer1 < nums1.length && pointer2 < nums2.length) {
            if (nums1[pointer1] == nums2[pointer2]) {
                list.add(nums1[pointer1]);
                pointer1 ++;
                pointer2 ++;
            }
            else if (nums1[pointer1] < nums2[pointer2]) {
                pointer1 ++;
            }
            else {
                pointer2 ++;
            }
        }
        
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i ++) {
            res[i] = list.get(i);
			//Integer wrapper class is converted to int
        }
        return res;
    }
	
	Time complexity should be O(n);
	Space complexity should be O(n);	
	//use hashmap
	public int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if (len1 == 0 || len2 == 0) return new int[0];
        
        ArrayList<Integer> list;
            
        if (len1 < len2) {
            list = new ArrayList<>(len1);
            Map<Integer, Integer> map = new HashMap<>(len2);
            
            for (int each : nums2) {
                map.put(each, map.getOrDefault(each, 0) + 1);
            }
            for (int each : nums1) {
                if (map.containsKey(each)) {
                    list.add(each);
                    int temp = map.get(each);
                    temp --;
                    if (temp == 0) map.remove(each);
                    else map.put(each, temp);
                }
            }
        }
        else {
            list = new ArrayList<>(len2);
            Map<Integer, Integer> map = new HashMap<>(len1);
            
            for (int each : nums1) {
                map.put(each, map.getOrDefault(each, 0) + 1);
            }
            for (int each : nums2) {
                if (map.containsKey(each)) {
                    list.add(each);
                    int temp = map.get(each);
                    temp --;
                    if (temp == 0) map.remove(each);
                    else map.put(each, temp);
                }
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i ++) {
            res[i] = list.get(i);
			//Integer wrapper class is converted to int
        }
        return res;
        
    }
	
	3. What if elements of nums2 are stored on disk, and the memory is
	limited such that you cannot load all elements into the memory at
	once?
	
	If only nums2 cannot fit in memory, put all elements of nums1 into a HashMap, read chunks of array that fit into the memory, and record the intersections.

	If both nums1 and nums2 are so huge that neither fit into the memory, sort them individually (external sort), then read 2 elements from each array at a time in memory, record intersections.	

	
166.
	 public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        // integral part
        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }
        
        // fractional part
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, res.length());
		//put index one step before
        while (num != 0) {
            num *= 10;
			
            res.append(num / den);
            num %= den;
			//these two steps are good
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            }
            else {
                map.put(num, res.length());
            }
        }
		//every time does one calculation
        return res.toString();
    }
	
380.
	//use two hashmap 
	class RandomizedSet {

    int count;
    Map<Integer, Integer> index;
    Map<Integer, Integer> content;
        
    /** Initialize your data structure here. */
    public RandomizedSet() {
        index = new HashMap<>(50);
        content = new HashMap<>(50);
        count = 0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!content.containsKey(val)) {
            count ++;
            content.put(val, count);
            index.put(count, val);
            return true;
        }
        else {
            return false;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!content.containsKey(val)) {
            return false;
        }
        else {
            int temp = content.get(val);
            if (temp != count) {
                int num = index.get(count);
                content.remove(val);
                index.remove(count);
                content.put(num, temp);
                index.put(temp, num);
            }
            else {
                content.remove(val);
                index.remove(count);
            }
            count --;
            return true;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        return index.get( random.nextInt(count) + 1 );
		//random .nextInt(int a), from 0 (inclusive) to a (exclusive)
    }
}

381.
	//duplicate, use one set as value of map
	class RandomizedCollection {

    List<Integer> nums;
    Map<Integer, Set<Integer>> map;
    java.util.Random random;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        random = new java.util.Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean doesContain = map.containsKey(val);
        if(!doesContain) map.put(val, new HashSet<>());
        map.get(val).add(nums.size());
        nums.add(val);
        return !doesContain;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        if(!map.get(val).contains(nums.size()-1)) {
            int currPos = map.get(val).iterator().next();
            int lastVal = nums.get(nums.size() - 1);
            map.get(lastVal).remove(nums.size() - 1);
            map.get(lastVal).add(currPos);
            map.get(val).remove(currPos);
            map.get(val).add(nums.size() - 1);
            nums.set(currPos, lastVal);
        }
        map.get(val).remove(nums.size()-1);
        if(map.get(val).isEmpty()) map.remove(val);
        nums.remove(nums.size()-1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}

340.
	Time complexity should be O(s.length)?;
	Space complexity should be O(s.length);
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int slow = 0, quick = 0, record = 0;
        while (map.size() <= k && quick < arr.length) {
            
            map.put(arr[quick], quick);
            
            if (map.size() > k) {
                record = Math.max(record, quick - slow);
                
                slow = arr.length;
                for (char each : map.keySet()) {
                    slow = Math.min(map.get(each), slow);
                }
                for (char each : map.keySet()) {
                    if (slow == map.get(each)) {
                        map.remove(each);
						//When you remove, you change the map!
						//Set is also changed! leads to exception!
                        break;
                    }
                }
                
                slow ++;
            }
            else if (map.size() <= k) {
                record = Math.max(record, quick + 1 - slow);
				//for cases which never reach size() == k or its
				//size is k
            }
            
            quick ++;
        }
        
        return record;
    }
	
	//Another method
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int num = 0, i = 0, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)]++ == 0) num++;
			//Use the array to judge the num
            if (num > k) {
                while (--count[s.charAt(i++)] > 0);
                num--;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
	
	 public static void main (String[] args) {
        int[] count = new int[2];
        if (count[1] ++ == 0) System.out.println("Good");
        System.out.println(count[1]);
		//++ Or -- is behind, judge first, then calculate

        if (++ count[1] == 1) System.out.println("Good2");
        System.out.println(count[1]);
		//++ Or -- is before, calculate first, then judge

        if (-- count[1] == 1) System.out.println("Good3");
        System.out.println(count[1]);

        if (count[1] -- == 1) System.out.println("Good4");
        System.out.println(count[1]);
    }
	
	
632.
	Time complexity should be O(list.length.sum log k)?;
	Space complexity should be O(k);
	public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        int[] pointers = new int[k];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (int[] a, int[] b) -> (a[0] - b[0]));
        
        int[] record = new int[2];
        int max = 0;
        
        for (int i = 0; i < k; i ++) {
            int temp = nums.get(i).get(0);
            max = Math.max(temp, max);
            pq.offer(new int[]{temp, i});
        }
        record[0] = pq.peek()[0];
        record[1] = max;
        int len = record[1] - record[0];

        while (true) {
            int[] temp = pq.poll();
            int index = temp[1];
            
            pointers[index] ++;
            if (pointers[index] >= nums.get(index).size()) break;
            int tempint = nums.get(index).get(pointers[index]);
            max = Math.max(max, tempint);
            pq.offer(new int[]{tempint, index});

            temp = pq.peek();
            if (len > max - temp[0] || len == max - temp[0] && record[0] > temp[0]) {
                record[0] = temp[0];
                record[1] = max;
                len = max - temp[0];
            }
        }
        
        return record;
    }

447.
	//This Question might have some problems!!!
	Time complexity:  O(n^2)
	Space complexity: O(n)
	public int numberOfBoomerangs(int[][] points) {
        int res = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<points.length; i++) {
            for(int j=0; j<points.length; j++) {
                if(i == j)
                    continue;

                int d = getDistance(points[i], points[j]);                
                map.put(d, map.getOrDefault(d, 0) + 1);
            }

            for(int val : map.values()) {
                res += val * (val-1);
            }            
            map.clear();
        }

        return res;
    }

    private int getDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];

        return dx*dx + dy*dy;
    }

645.
	Time complexity is O(n);
	Space complexity is O(n);
	public int[] findErrorNums(int[] nums) {
        int[] record = new int[nums.length + 1];
        int res = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (++ record[nums[i]] == 2) res = nums[i];
        }
        int another = 1;
        while (record[another] != 0) {
            another ++;
        }
        return new int[]{res, another};
    }
	
	Time complexity is O(n);
	Space complexity is O(1);
	public static int[] findErrorNums(int[] nums) {
		int[] res = new int[2];
		for (int i : nums) {
			if (nums[Math.abs(i) - 1] < 0) res[0] = Math.abs(i);
		else nums[Math.abs(i) - 1] *= -1;
		}
		for (int i=0;i<nums.length;i++) {
			if (nums[i] > 0) res[1] = i+1;
		}
		return res;
	}
	
67.
	Time complexity is O(max(a.length, b.length));
	Space complexity is O(max(a.length, b.length));
	public String addBinary(String a, String b) {
        String res = "";
        int pointerA = a.length() - 1;
        int pointerB = b.length() - 1;
        if (pointerA < 0 || pointerB < 0) return a + b;
        
        int overflow = 0;
        while (pointerA >= 0 && pointerB >= 0) {
            int temp = a.charAt(pointerA) - '0' + b.charAt(pointerB) - '0' + overflow;
			//must -'0', for 0 != '0'
            if (temp < 2) {
                overflow = 0;
                res = temp + res;
            }
            else {
                overflow = 1;
                res = ((temp == 2) ? 0 : 1) + res;
            }
            pointerA --;
            pointerB --;
        }
        while (pointerA >= 0) {
            int temp = a.charAt(pointerA) - '0' + overflow;
            if (temp < 2) {
                overflow = 0;
                res =  a.substring(0, pointerA) + temp + res;
                break;
            }
            else {
                overflow = 1;
                res = 0 + res;
            }
            pointerA --;
        }
        while (pointerB >= 0) {
            int temp = b.charAt(pointerB) - '0' + overflow;
            if (temp < 2) {
                overflow = 0;
                res =  b.substring(0, pointerB) + temp + res;
                break;
            }
            else {
                overflow = 1;
                res = 0 + res;
            }
            pointerB --;
        }
        return (overflow == 1) ? overflow + res : res;
    }
	//Better method
	public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
			//Good thinking here
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
		//reverse() method
    }
	
273.
	private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        int i = 0;
        String words = "";

        while (num > 0) {
            if (num % 1000 != 0)
                words = helper(num % 1000) +THOUSANDS[i] + " " + words;
            num /= 1000;
            i++;
        }

        return words.trim();
    }

    private String helper(int num) {
        if (num == 0)
            return "";
        else if (num < 20)
            return LESS_THAN_20[num] + " ";
        else if (num < 100)
            return TENS[num / 10] + " " + helper(num % 10);
        else
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
    }
	
	//Another Method
	private final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return helper(num); 
    }
    
    private String helper(int num) {
        String result = new String();
        if (num < 10) result = belowTen[num];
        else if (num < 20) result = belowTwenty[num -10];
        else if (num < 100) result = belowHundred[num/10] + " " + helper(num % 10);
        else if (num < 1000) result = helper(num/100) + " Hundred " +  helper(num % 100);
        else if (num < 1000000) result = helper(num/1000) + " Thousand " +  helper(num % 1000);
        else if (num < 1000000000) result = helper(num/1000000) + " Million " +  helper(num % 1000000);
        else result = helper(num/1000000000) + " Billion " + helper(num % 1000000000);
        return result.trim();
    }
	
13.
	//Ugly Method!
	public int romanToInt(String s) {
        if (s.length() == 0) return 0;
        int res = 0;
        int i = 0;
        char[] arr = s.toCharArray();
        while (i < arr.length) {
            if (arr[i] == 'I' && i + 1 < arr.length && arr[i + 1] == 'V') {
                res += 4;
                i ++;
            }
            else if (arr[i] == 'I' && i + 1 < arr.length && arr[i + 1] == 'X') {
                res += 9;
                i ++;
            }
            else if (arr[i] == 'I') res += 1;
            else if (arr[i] == 'V') res += 5;
            else if (arr[i] == 'X' && i + 1 < arr.length && arr[i + 1] == 'L') {
                res += 40;
                i ++;
            }
            else if (arr[i] == 'X' && i + 1 < arr.length && arr[i + 1] == 'C') {
                res += 90;
                i ++;
            }
            else if (arr[i] == 'X') res += 10;
            else if (arr[i] == 'L') res += 50;
            else if (arr[i] == 'C' && i + 1 < arr.length && arr[i + 1] == 'D') {
                res += 400;
                i ++;
            }
            else if (arr[i] == 'C' && i + 1 < arr.length && arr[i + 1] == 'M') {
                res += 900;
                i ++;
            }
            else if (arr[i] == 'C') res += 100;
            else if (arr[i] == 'D') res += 500;
            else if (arr[i] == 'M') res += 1000;
            i ++;
        }
        return res;
    }
	
	//Good Method
	public int romanToInt(String s) {
		 int sum=0;
		if(s.indexOf("IV")!=-1){sum-=2;}
		if(s.indexOf("IX")!=-1){sum-=2;}
		if(s.indexOf("XL")!=-1){sum-=20;}
		if(s.indexOf("XC")!=-1){sum-=20;}
		if(s.indexOf("CD")!=-1){sum-=200;}
		if(s.indexOf("CM")!=-1){sum-=200;}
		//Only can happen one time in Roma number!
		
		char c[]=s.toCharArray();
		int count=0;
		
	   for(;count<=s.length()-1;count++){
		   if(c[count]=='M') sum+=1000;
		   if(c[count]=='D') sum+=500;
		   if(c[count]=='C') sum+=100;
		   if(c[count]=='L') sum+=50;
		   if(c[count]=='X') sum+=10;
		   if(c[count]=='V') sum+=5;
		   if(c[count]=='I') sum+=1;
		   
	   }
	   
	   return sum;
    }	
	
12.
	//Similar to the last one
	private final String[] LESS_THAN_10 = new String[]{"","I","II","III","IV","V","VI","VII","VIII","IX"};
    private final String[] TENS = new String[]{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    private final String[] HUNDREDS = new String[]{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    
    public String intToRoman(int num) {
        String res = "";
        for (int i = 1; i <= num / 1000; i ++) {
            res += "M";
        }
        num %= 1000;
        return res + helper(num);
    }
    
    private String helper(int num) {
        String temp = "";
        if (num >= 100) {
            return HUNDREDS[num / 100] + helper(num % 100);
        }
        else if (num >= 10) {
            return TENS[num / 10] + helper(num % 10);
        }
        else {
            return LESS_THAN_10[num];
        }
    }
	
	//Another Method
	//More Advance
	public static String intToRoman(int num) {
    String M[] = {"", "M", "MM", "MMM"};
    String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
}

14.
	public String longestCommonPrefix(String[] strs) {
        int pointer = 0;
        String res = "";
        if (strs.length == 0 || strs[0].length() == 0) return res;
        char temp = strs[0].charAt(pointer);
        
        while (true) {
            int index = 0;
            while (index < strs.length) {
                if (pointer >= strs[index].length()) return res;
                if (temp != strs[index].charAt(pointer)) return res;
                index ++;
            }
            res += temp;
            pointer ++;
            if (pointer >= strs[0].length()) break;
            temp = strs[0].charAt(pointer);
        }
        
        return res;
    }
	//Better method
	//Sort the array first, then compare the first and the last
	public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        
        if (strs!= null && strs.length > 0){
        
            Arrays.sort(strs);
            
            char [] a = strs[0].toCharArray();
            char [] b = strs[strs.length-1].toCharArray();
            
            for (int i = 0; i < a.length; i ++){
                if (b.length > i && b[i] == a[i]){
                    result.append(b[i]);
                }
                else {
                    return result.toString();
                }
            }
        return result.toString();
    }
	
6.	?why null
	public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        String[] res = new String[numRows];
        Arrays.fill(res,"");
		//must have!
		//Or there will be null at first
        char[] arr = s.toCharArray();
        
        int flag = 0, index = 0;
        for (int i = 0; i < arr.length; i ++) {
            res[index] += "" + arr[i];
            if (flag == 0 && index < numRows - 1) {
                index ++;
            }
            else if (flag == 0 && index == numRows - 1) {
                flag = 1;
                index --;
            }
            else if (flag == 1 && index > 0) {
                index --;
            }
            else {
                flag = 0;
                index ++;
            }
        }
        
        String result = "";
        for (String each : res) {
            result += each;
        }
        return result;
    }
	//StringBuilder might be quicker
	//StringBuilder[]
	
151.
	public String reverseWords(String s) {
        String result = "";
        Scanner in = new Scanner(s);   
        ArrayList<String> list = new ArrayList<>();
        while (in.hasNext()) {
            list.add(in.next());
        }
        
        for (int i = list.size() - 1; i >= 0; i--) {
            result += list.get(i) + " ";
        }
        
        return result.trim();
    }
	
	public String reverseWords(String s) {
		String[] words = s.trim().split(" +");
		//+ means at least 1, so in this case " +" means at least one space
		Collections.reverse(Arrays.asList(words));
		return String.join(" ", words);
	}


	//another method
	public class Solution {
	    public String reverseWords(String s) {
	        String result = "";
	        Scanner in = new Scanner(s);   
	        ArrayList<String> list = new ArrayList<>();
	        while (in.hasNext()) {
	            list.add(in.next());
	        }
	        
	        for (int i = list.size() - 1; i >= 0; i--) {
	            result += list.get(i) + " ";
	        }
	        
	        return result.trim();
	    }
	}


	//in-place solution
	//2 swap operations
	public class Solution {
	    public String reverseWords(String s) {
	        char[] arr = s.trim().toCharArray();
	        for (int i = 0; i < arr.length / 2; i ++) {
	            swap(arr, i, arr.length - 1 - i);
	        }
	        
	        int slow = 0, fast = 0, cur = 0, left, right;
	        while (fast < arr.length) {
	            if (!(slow > 0 && arr[fast] == ' ' && arr[slow - 1] == ' ')) {
	                arr[slow ++] = arr[fast];
	                if (arr[slow - 1] == ' ') {
	                    left = cur; 
	                    right = slow - 2;
	                    while (left < right) {
	                        swap(arr, left, right);
	                        left ++;
	                        right --;
	                    }
	                    cur = slow;
	                }
	            }
	            fast ++;
	        }
	        left = cur; 
	        right = slow - 1;
	        while (left < right) {
	            swap(arr, left, right);
	            left ++;
	            right --;            
	        }
	        return new String(arr, 0, slow);
	    }
	    
	    private void swap(char[] arr, int a, int b) {
	        char tmp = arr[a];
	        arr[a] = arr[b];
	        arr[b] = tmp;
	    }
	}

17.
	//pretty normal DFS
	private final String[] MAPPING = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"}; 
    
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) {return list;}
        helper(list, new StringBuilder(), digits, 0);
        return list;
    }
    
    private void helper(List<String> list, StringBuilder sb, String digits, int start) {
        int len = sb.length();
        if (len == digits.length()) list.add(sb.toString());
        else {
            String temp = MAPPING[digits.charAt(start) - '0'];
            for (int i = 0; i < temp.length(); i ++) {
                sb.append(temp.charAt(i));
                helper(list, sb, digits, start + 1);
                sb.setLength(len);
            }
        }
    }
	
	//Actually, this is BFS 
	public List<String> letterCombinations(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if(digits.isEmpty()) return ans;
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		while(ans.peek().length()!=digits.length()){
			String remove = ans.remove();
			String map = mapping[digits.charAt(remove.length())-'0'];
			for(char c: map.toCharArray()){
				ans.addLast(remove+c);
				//add to the last!
				//this step and the remove step consists
				//the group of one round of BFS
			}
		}
		return ans;
	}
	
22.
	//DFS solution
	public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(list, 0,0,new StringBuilder(), n);
        return list;
    }
    
    private void helper(List<String> list, int left, int right, StringBuilder sb, int n) {
        int len = sb.length();
        if (len == n * 2) list.add(sb.toString());
        else {
            if (left < n) helper(list, left + 1, right, sb.append('('), n);
            sb.setLength(len);
            if (left > 0 && right < left) helper(list, left, right + 1, sb.append(')'), n);
            sb.setLength(len);
        }
    }


    //another method
    class Solution {
	    public List<String> generateParenthesis(int n) {
	        List<String> res = new ArrayList<>();
	        dfs(res, new StringBuilder(), 0, 0, n);
	        return res;
	    }
	    
	    private void dfs(List<String> res, StringBuilder sb, int left, int right, int pairs) {
	        if (left == right && left == pairs) {
	            res.add(sb.toString());
	            return;
	        }
	        if (left < right || left > pairs) {
	            return;
	        }
	        //only difference, add another termination terms
	        int len = sb.length();
	        dfs(res, sb.append('('), left + 1, right, pairs);
	        sb.setLength(len);
	        dfs(res, sb.append(')'), left, right + 1, pairs);
	        sb.setLength(len);
	    }
	}
	
10.
	//NB!!!
	//DP!!! can you believe that?
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
						   
	public boolean isMatch(String s, String p) {

        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
		//This initial condition is so good!!!
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
	

Practice Q4:
	class Node {
		int val;
		Node next;
		
		public Node (int n) {
			val = n;
			next = null;
		}
		public Node (int n, Node one) {
			val = n;
			next = one;
		}
	}

	//no dummy node
	public Node insertSortedLinkedList(Node head, int n) {
		if (head == null || head.val >= n) {
				return new Node(n, head);
		}
		else {
			Node prev = head;
			while (prev.next != null && prev.next.val < n) {
				prev = prev.next;
			}
			Node add = new Node(n, prev.next);
			prev.next = add;
			return head;
		}
	}
	
Practice Q5:
	//no dummy node
	public Node mergeTwoLinkedList(Node head1, Node head2) {
		if (head1 == null) return head2;
		if (head2 == null) return head1;
		//corner case!
		Node res;
		if (head1.val < head2.val) {
			res = head1;
			head1 = head1.next;
		}
		else {
			res = head2;
			head2 = head2.next;
		}
		Node cur = res;
		while (head1 != null && head2 != null) {
			if (head1.val < head2.val) {
				cur.next = head1;
				head1 = head1.next;
			}
			else {
				cur.next = head2;
				head2 = head2.next;
			}
			cur = cur.next;
		}
		if (head1 == null) {
			cur.next = head2;
		}
		else {
			cur.next = head1;
		}
		return res;
	}
	
	//recursion
	public Node mergeTwoLinkedList(Node head1, Node head2) {
		if (head1 == null) return head2;
		if (head2 == null) return head1;
		
		if (head1.val < head2.val) {
			head1.next = mergeTwoLinkedList(head1.next, head2);
			return head1;
		}
		else {
			head2.next = mergeTwoLinkedList(head1, head2.next);
			return head2;
		}
	}
	
Practice Q7:
	public Node pairMerge(Node head1, Node head2) {
		if (head1 == null) return head2;
		if (head2 == null) return head1;
		
		Node dummy = new Node(0);
		Node cur = dummy;
		while (head1 != null && head2 != null) {
			cur.next = head1;
			head1 = head1.next;
			cur = cur.next;
			
			cur.next = head2;
			head2 = head2.next;
			cur = cur.next;
		}
		cur.next = head2;
		return dummy.next;
	}
	
Practice Q9:
	public Node partitionList(Node head) {
		if (head == null) return head;
		
		Node dummy1 = new Node(0);
		Node dummy2 = new Node(0);
		
		Node cur1 = dummy1;
		Node cur2 = dummy2;
		
		while (head != null) {
			if (head.val < 3) {
				cur1.next = head;
				cur1 = cur1.next;
			}
			else {
				cur2.next = head;
				cur2 = cur2.next;
			}
			head = head.next;
		}
		cur1.next = dummy2.next;
		cur2.next = null;
		// do not forget to break the second one!!!
		return dummy1.next;
	}
	
	
657.
	Time complexity is O(n.length)
	Space complexity is O(1)
	public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char each : moves.toCharArray()) {
            if (each == 'U') {
                y ++;
            }
            else if (each == 'D') {
                y --;
            }
            else if (each == 'L') {
                x --;
            }
            else if (each == 'R') {
                x ++;
            }
        }
        return x == 0 && y == 0;
    }
	
557. reverseWords
	Time complexity is O(n)
	Space complexity is O(n)
	public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = new StringBuilder(arr[i]).reverse().toString();
        }
        return String.join(" ", arr);
    }
	

383. random note 
	construct using array to map
	Time complexity is O(a.length + b.length)
	Space complexity is O(1)?
	public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for (char each : magazine.toCharArray()) {
            map[each - 'a'] ++;
        }
        for (char each : ransomNote.toCharArray()) {
            if (map[each - 'a'] == 0) return false;
            map[each - 'a'] --;
        }
        return true;
    }
	
	
320.
	Time complexity should be O(2^n);
	Space complexity should be O(2^n);
	//choose o from the original string, then 1, then 2, then 3, ... that is 2^n

79.
	Time complexity should be O(mn);
	Space complexity should be O(mn);
	//Remmember to clear the visited path if you have tried one path and it failed
	//In this way can use less space and less time

234.
	Time complexity should be O(n);
	Space complexity should be O(n);	
	//Pay attention to the wrapper class Integer instead of int
	//When comparing the number, use (int) to convert first

819.
	Time complexity should be O(length);
	Space complexity should be O(length);
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


43.
	Time complexity should be O(num1.length + num2.length);
	Space complexity should be O(num1.length + num2.length);
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
        //Do not have to care about the first number in the array
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sequnce.length; i ++) {
            sb.append(sequnce[i]);
        }
        
        return sb.toString();
        
    }


345.
	Time complexity should be O(n);
	Space complexity should be O(n);
	//standard two pointer solution!!!
	private final Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u','A','O','E','I','U'));
    //pretty good!!!
    //Array.asList() to convert to a list<>
    //list is a collection and can use the set constructor
    //use collection in the constructor, then you can not use the capacity

    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) return s;
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            while (left < arr.length && !set.contains(arr[left])) {
                left ++;
            }
            while (right > 0 && !set.contains(arr[right])) {
                right --;
            }
            if (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
            left ++;
            right --;
        }
        //may be use a single while loop can decrease the time
        
        return new String(arr);
        //String constructor!!!
        //can not use StringBuilder constructor here
    }


    //another good solution, using less time!
    public  String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int i=0,j=s.length()-1;
        while(i<=j){
            if(isVowels(ch[i]) && isVowels(ch[j])){
                swap(ch,i,j);
                i++;
                j--;
            }else if (!isVowels(ch[i])){
                i++;
            }else {
                j--;
            }
        }
        return new String(ch);
    }
    public  boolean isVowels(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U';
    }
    //it does not use a set
    public  void swap(char[] ch,int i,int j){
        char t = ch[i];
        ch[i]=ch[j];
        ch[j]=t;
    }


32.
	//end at position i and length
	public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int result = 0;
        int leftCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
            } else if (leftCount > 0){
                dp[i] = dp[i - 1] + 2;
                dp[i] += (i - dp[i]) >= 0 ? dp[i - dp[i]] : 0;
                result = Math.max(result, dp[i]);
                leftCount--;
            }
        }
        return result;
    }

    //use stack to do, calculate the gap
    //store the index of characters
    public int longestValidParentheses(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        int result = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
                stack.pop();
                result = Math.max(result, i - stack.peek());
            } else {
                stack.push(i);
            }
        }
        return result;
        //same idea, pushing while calculating
    }


    //my own method
    //deque, save invalid index, calculate valid period length
    class Solution {
	    public int longestValidParentheses(String s) {
	        if (s == null || s.length() <= 1) return 0;
	        
	        Deque<Integer> dq = new LinkedList<>();
	        int counter = -1, max = 0;
	        //counter start from -1, for index 0 can be in the deque
	        char[] sArr = s.toCharArray();
	        for (int i = 0; i < sArr.length; i ++) {
	            if (sArr[i] == ')' && !dq.isEmpty() && sArr[dq.peekLast()] == '(') dq.pollLast();
	            else dq.offerLast(i);
	        }
	        dq.offerLast(sArr.length);
	        while (!dq.isEmpty()) {
	            int tmp = dq.pollFirst();
	            int len = tmp - counter - 1;
	            max = Math.max(len, max);
	            counter = tmp;
	            //keep reading and calculate valid period length
	        }
	        return max;
	    }
	}


125.
	public boolean isPalindrome(String s) {
        
        if (s == null || s.length() == 0) return true;
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) left ++;
            //use of Character.isLetterOrDigit()
            else if (!Character.isLetterOrDigit(s.charAt(right))) right --;
            else if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            else {
                left ++;
                right --;
            }
        }
        
        return true;
    }


    //another good method
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] c = s.toCharArray();
        while (i < j) {
            while (i < s.length() && !valid(c[i])) i++;
            while (j >= 0 && !valid(c[j])) j--;
            if (i < j && Character.toLowerCase(c[i]) != Character.toLowerCase(c[j])) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    public boolean valid(char c) {
        return (c >= 'a' && c <= 'z') ||
               (c >= 'A' && c <= 'Z') ||
               (c >= '0' && c <= '9');
    }
    //good thinking to write this function
		

165.
	public int compareVersion(String version1, String version2) {
	    String[] levels1 = version1.split("\\.");
	    String[] levels2 = version2.split("\\.");
	    
	    int length = Math.max(levels1.length, levels2.length);
	    for (int i=0; i<length; i++) {
	    	Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
	    	Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
	    	//Integer wrapper class
	    	//must use compareTo() method to compare
	    	int compare = v1.compareTo(v2);
	    	if (compare != 0) {
	    		return compare;
	    	}
	    }
	    
	    return 0;
	}	

	//do not use Integer class, just use int
	//the time can be less spent 
	public int compareVersion(String version1, String version2) {
        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");

        int length = Math.max(levels1.length, levels2.length);
        for (int i=0; i<length; i++) {
            int v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            //Good thinking at different length!
            int v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            if (v1 != v2) return (v1 > v2) ? 1 : -1;
        }

        return 0;
    }
		
	
	
30.
	//sliding window
	//pointer + window + map record
	//In this one, we also use remmember the start index of the window
	//the use of count instead of compare map every time is brilliant!
	/*
		A time & space O(n) solution
		Run a moving window for wordLen times.
		Each time we keep a window of size windowLen (= wordLen * numWord), each step length is wordLen.
		So each scan takes O(sLen / wordLen), totally takes O(sLen / wordLen * wordLen) = O(sLen) time.
		
		One trick here is use count to record the number of exceeded occurrences of word in current window
	*/
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(words == null || words.length == 0 || s.length() == 0) return res;
        int wordLen = words[0].length();
        int numWord = words.length;
        int windowLen = wordLen * numWord;
        int sLen = s.length();
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words) map.put(word, map.getOrDefault(word, 0) + 1);

        for(int i = 0; i < wordLen; i++) {  // Run wordLen scans
            HashMap<String, Integer> curMap = new HashMap<>();
            for(int j = i, count = 0, start = i; j + wordLen <= sLen; j += wordLen) {  // Move window in step of wordLen
                // count: number of exceeded occurences in current window
                // start: start index of current window of size windowLen
                if(start + windowLen > sLen) break;
                String word = s.substring(j, j + wordLen);
                if(!map.containsKey(word)) {
                    curMap.clear();
                    count = 0;
                    start = j + wordLen;
                }
                else {
                    if(j == start + windowLen) { // Remove previous word of current window
                        String preWord = s.substring(start, start + wordLen);
                        start += wordLen;
                        int val = curMap.get(preWord);
                        if(val == 1) curMap.remove(preWord);
                        else curMap.put(preWord, val - 1);
                        if(val - 1 >= map.get(preWord)) count--;  // Reduce count of exceeded word
                    }
                    // Add new word
                    curMap.put(word, curMap.getOrDefault(word, 0) + 1);
                    if(curMap.get(word) > map.get(word)) count++;  // More than expected, increase count
                    // Check if current window valid
                    if(count == 0 && start + windowLen == j + wordLen) {
                        res.add(start);
                    }
                }
            }
        }
        return res;
    }
	

93.
	//How to calculate the time complexity?
	public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        helper(list, new StringBuilder(), s, 0, 0);
        return list;
    }
    
    private void helper(List<String> list, StringBuilder sb, String s, int start, int counter) {
        int len = sb.length();
        if (len == s.length() + 4 && counter == 4) {
            sb.setLength(len - 1);
            list.add(sb.toString());
        }
        else if (counter < 4) {
            for (int tryLen = 1; tryLen <= 3 && start + tryLen <= s.length(); tryLen ++) {
                String temp = s.substring(start, start + tryLen);
                if (Integer.parseInt(temp) > 255) continue;
                if (temp.charAt(0) == '0' && temp.length() > 1) continue;
                helper(list, sb.append(temp + "."), s, start + tryLen, counter + 1);
                sb.setLength(len);
            }
        }
    }


214.
	/*
	This problem's core is to find out the longest palindrome prefix of s, 
	so how to do so? @xcv58 's solution find a j which is not the longest, 
	but the loop of calculating j :
	for (int i = s.length() - 1; i >= 0; i--) {
	if (s.charAt(i) == s.charAt(j)) { j += 1; }
	}
	can promise that j is longer than the longest palindrome prefix of s, 
	and j is equals to the length of longest palindrome prefix of s only when 
	s is palindrome itself. 
	so we must recursively call shortestPalindrome to get result of mid.
	*/
	public String shortestPalindrome(String s) {
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j)) { j += 1; }
        }
        if (j == s.length()) { return s; }
        String suffix = s.substring(j);
        return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
    }
    /*
	The idea is to use two anchors j and i to compare the 
	String from beginning and end.
	If j can reach the end, the String itself is Palindrome. 
	Otherwise, we divide the String by j, and get mid = s.substring(0, j) 
	and suffix.

	We reverse suffix as beginning of result and recursively call 
	shortestPalindrome to get result of mid then appedn suffix to get result.
    */


58.
	public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        String[] arr = s.split(" +");
        if (arr.length == 0) return 0;
        return arr[arr.length - 1].length();
    }

    //use system's function
    public int lengthOfLastWord(String s) {
		s = s.trim();
	    int lastIndex = s.lastIndexOf(' ') + 1;
	    return s.length() - lastIndex;        
	}



44.
	Time complexity should be O(n*m);
	Space complexity should be O(n*m);	
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
        //all the initial cases
        //especially when p's first character is '*'
        
        for (int len1 = 1; len1 <= slen; len1 ++) {
            for (int len2 = 1; len2 <= plen; len2 ++) {
                if (s.charAt(len1 - 1) == p.charAt(len2 - 1) || p.charAt(len2 - 1) == '?') {
                    dp[len1][len2] = dp[len1 - 1][len2 - 1];
                }
                else if (p.charAt(len2 - 1) == '*') {
                    for (int k = 0; k <= len1; k ++) {
                        if (dp[k][len2 - 1]) {
                            dp[len1][len2] = true;
                            break;
                        }
                    }
                }
            }
        }
        
        return dp[slen][plen];
    }


    //another writing of DP, faster
    //666!!!
    class Solution {
	    public boolean isMatch(String s, String p) {
	        int m=s.length(),n=p.length();
	        boolean[][] dp=new boolean[m+1][n+1];
	        dp[0][0]=true;
	        
	        for(int j=1;j<=n;j++)
	        {
	            if(p.charAt(j-1)=='*' && dp[0][j-1])
	                dp[0][j]=true;
	        }
	        for(int i=1;i<=m;i++)
	        {
	            for(int j=1;j<=n;j++)
	            {
	                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?')
	                    dp[i][j]=dp[i-1][j-1];
	                
	                else if(p.charAt(j-1)=='*')
	                    dp[i][j]=dp[i-1][j] || dp[i][j-1];
	                	//dp[i - 1][j]: '*' matches one char now, continue matching
	                	//dp[i][j - 1]: '*' does not match any
	                else
	                    dp[i][j]=false;
	            }
	        }
	        return dp[m][n];
	    }
	}


	//using 2 pointers instead of dp
	class Solution {
	    public boolean isMatch(String s, String p) {
	        char[] input = s.toCharArray();
	        char[] pattern = p.toCharArray();
	        int startMatch = -1;
	        int i =0, j = 0, matched = 0;
	        
	        while (i < input.length) {
	            if (j < pattern.length && pattern[j] == '*') {
	                startMatch = j;
	                matched = i;
	                ++j;
	            } else {
	                if (j < pattern.length && (pattern[j] == '?' || pattern[j] == input[i])) {
	                    ++i;
	                    ++j;
	                } else if (startMatch != -1) {
	                    j = startMatch + 1;
	                    ++matched;
	                    i = matched;
	                } else {
	                    return false;
	                }
	            } 
	        }
	        
	        while (j < pattern.length && pattern[j] == '*') {
	            ++j;
	        }
	        return j == pattern.length;
	    }
	}


87.
	Time complexity should be ?;
	Space complexity should be ?;	
	//great solution
	//recursive is still a chanllenge to me
	public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true; 
        
        int[] letters = new int[26];
        for (int i=0; i<s1.length(); i++) {
            letters[s1.charAt(i)-'a']++;
            letters[s2.charAt(i)-'a']--;
        }
        for (int i=0; i<26; i++) if (letters[i]!=0) return false;
    
        for (int i=1; i<s1.length(); i++) {
            if (isScramble(s1.substring(0,i), s2.substring(0,i)) 
             && isScramble(s1.substring(i), s2.substring(i))) return true;
            if (isScramble(s1.substring(0,i), s2.substring(s2.length()-i)) 
             && isScramble(s1.substring(i), s2.substring(0,s2.length()-i))) return true;
        }
        return false;
    }


681.
	//NO COMMENT!
	//FUCK GOOGLE!!!
	public String nextClosestTime(String time) {
        char[] timechar = time.toCharArray();
        int hour = Integer.parseInt(time.substring(0,2));
        int min = Integer.parseInt(time.substring(3));
        
        String recordMinlarge = "";
        String recordMinsmall = "";
        String recordHourlarge = "";
        String recordHoursmall = "";
        
        for (int i = 0; i < timechar.length; i ++) {
            if (timechar[i] == ':') continue;
            for (int j = 0; j < timechar.length; j ++) {
                if (timechar[j] == ':') continue;
                recordMinlarge = bigger(timechar[i], timechar[j], min, 60, recordMinlarge);
                recordMinsmall = smaller(timechar[i], timechar[j], min, 60, recordMinsmall);
                recordHourlarge = bigger(timechar[i], timechar[j], hour, 24, recordHourlarge);
                recordHoursmall = smaller(timechar[i], timechar[j], hour, 24, recordHoursmall);
            }
        }
        
        if (!recordMinlarge.equals("")) return time.substring(0,3) + recordMinlarge;
        else if (!recordHourlarge.equals("") && !recordMinsmall.equals("")) return recordHourlarge + ":" + recordMinsmall;
        else if (!recordHoursmall.equals("") && !recordMinsmall.equals("")) return recordHoursmall + ":" + recordMinsmall;
        else return time;
    }
    
    private String bigger(char a, char b, int comp, int limit, String change) {
        int temp = (a - '0') * 10 + (b - '0');
        if (temp > comp && temp < limit && change.equals("")) {
            change = "" + a + b;
        }
        else if (temp > comp && temp < limit && temp < Integer.parseInt(change)) {
            change = "" + a + b;
        }
        return change;
    }
    
    private String smaller(char a, char b, int comp, int limit, String change) {
        int temp = (a - '0') * 10 + (b - '0');
        if (temp < comp && temp < limit && change.equals("")) {
            change = "" + a + b;
        }
        else if (temp < comp && temp < limit && temp < Integer.parseInt(change)) {
            change = "" + a + b;
        }
        return change;
    }

    //another method
    public String nextClosestTime(String time) {
        char[] result = time.toCharArray();
        char[] digits = new char[] {result[0], result[1], result[3], result[4]};
        Arrays.sort(digits);
        
        // find next digit for HH:M_
        result[4] = findNext(result[4], (char)('9' + 1), digits);  // no upperLimit for this digit, i.e. 0-9
        if(result[4] > time.charAt(4)) return String.valueOf(result);  // e.g. 23:43 -> 23:44
        
        // find next digit for HH:_M
        result[3] = findNext(result[3], '5', digits);
        if(result[3] > time.charAt(3)) return String.valueOf(result);  // e.g. 14:29 -> 14:41
        
        // find next digit for H_:MM
        result[1] = result[0] == '2' ? findNext(result[1], '3', digits) : findNext(result[1], (char)('9' + 1), digits);
        if(result[1] > time.charAt(1)) return String.valueOf(result);  // e.g. 02:37 -> 03:00 
        
        // find next digit for _H:MM
        result[0] = findNext(result[0], '2', digits);
        return String.valueOf(result);  // e.g. 19:59 -> 11:11
    }
    
    /** 
     * find the next bigger digit which is no more than upperLimit. 
     * If no such digit exists in digits[], return the minimum one i.e. digits[0]
     * @param current the current digit
     * @param upperLimit the maximum possible value for current digit
     * @param digits[] the sorted digits array
     * @return 
     */
    private char findNext(char current, char upperLimit, char[] digits) {
        //System.out.println(current);
        if(current == upperLimit) {
            return digits[0];
        }
        int pos = Arrays.binarySearch(digits, current) + 1;
        while(pos < 4 && (digits[pos] > upperLimit || digits[pos] == current)) { // traverse one by one to find next greater digit
            pos++;
        }
        return pos == 4 ? digits[0] : digits[pos];
    }


//Java's LinkedList
//double linkedlist
	class LinkedList<T> {
		//fields
		private ListNode<T> head;//Pay attention to this!! general type
		private ListNode<T> tail;
		private int size;

		//methods
		LinkedList() {
			size = 0;
			head = null;
			tail = null;
		}

		E getVal(int val)// may be general type, throw exception 
		{
			if (head == null || val < 0 || val >= size) {
				return -1;// throw new exception?
			}
			ListNode dummy = new ListNode();
			dummy.next = head;
			for (int i = 0; i <= val; i ++) {
				dummy = dummy.next;
			}
			return dummy.val;
		}

		void addHead(E val) {
			size ++;
			if (head == null) {
				head = new ListNode(val);
				tail = head;
			}
			else {
				ListNode dummy = new ListNode(val);
				dummy.next = head;
				head.prev = dummy;// head may be null
				head = dummy;
			}
		}
		//double linkedlist
		//add link in two directions 

		void addTail(E val) {
			size ++;
			if (tail == null) {
				head = new ListNode(val);
				tail = head;
			}
			else {
				ListNode dummy = new ListNode(val);
				dummy.prev = tail;
				tail.next = dummy;
				tail = dummy;
			}
		}

		int getSize() {
			return size;
		}

	}


	List<Integer> list = new ArrayList<>();
	((ArrayList) list).myMethod();
	casting polymorphism




//6/12
	public class newQueue<E> { //generics type
		//fields
		private Stack<E> stack1;
		private Stack<E> stack2;

		//methods
		public newQueue() {
			stack1 = new Stack<E>();
			stack2 = new Stack<E>();
		}

		public void offer(E val) {
			stack1.push(val);
		}

		public E poll() {
			move();
			return stack2.isEmpty() ? null : stack2.pop();
		}

		public E peek() {
			move();
			return stack2.isEmpty() ? null : stack2.peek();
		}

		private void move() {
			if (stack2.isEmpty()) {
				while (!stack1.isEmpty()) {
					stack2.push(stack1.pop());
				}
			}
		}
		//repeat part, set up addictional funciton
	}


2.
	//time complexity O(max(l1.length,l2.length))
	//space complexity O(1)? Is this right?
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode numA = l1;
        ListNode numB = l2;
        ListNode prevA = l1;
        ListNode prevB = l2;
        int overflow = 0;
        
        while (numA != null && numB != null) {
            numA.val = numA.val + numB.val + overflow;
            overflow = numA.val / 10;
            numA.val %= 10;
            prevA = numA;
            prevB = numB;
            numA = numA.next;
            numB = numB.next;
        }
        //corner cases: 
        //[1] [9,9]
        //[9,9] [1]
        //[5][5]
        
        while (overflow != 0 || numB != null) {
            if (numB != null) {
                prevA.next = numB;
                numB.val += overflow;
                overflow = numB.val / 10;
                numB.val %= 10;
                numA = numB;
                prevA = numA;
                numB = null;
                //do not forget the prevA, it is important
            }
            else if (numA != null && overflow != 0) {
                numA.val += overflow;
                overflow = numA.val / 10;
                numA.val %= 10;
                prevA = numA;
                //do not forget the prevA, it is important
            }
            else if (numA == null && overflow != 0) {
                prevA.next = new ListNode(overflow);
                numA = prevA.next;
                overflow = 0;
            }
            numA = numA.next;
        }
        
        return l1;
    }

    //another good method
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ln1 = l1, ln2 = l2, head = null, node = null;
        int carry = 0, remainder = 0, sum = 0;
        head = node = new ListNode(0);
        
        while(ln1 != null || ln2 != null || carry != 0) {//the final stop conditions
            sum = (ln1 != null ? ln1.val : 0) + (ln2 != null ? ln2.val : 0) + carry;
            carry = sum / 10;
            remainder = sum % 10;
            node = node.next = new ListNode(remainder);
            //sum, carry, reminder seperate
            //add new node each time, create a new one
            ln1 = (ln1 != null ? ln1.next : null);
            ln2 = (ln2 != null ? ln2.next : null);
        }
        return head.next;
    }


21. 
	//time complexity O(l1.length+l2.length)
	//space complexity O(l1.length+l2.length)
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null && l1.val > l2.val || l1 == null) {
                pointer.next = new ListNode(l2.val);
                l2 = l2.next;
                pointer = pointer.next;
                // can not use break here directly,for creating new Link
                // instead of using old ones
            }
            else {
                pointer.next = new ListNode(l1.val);
                l1 = l1.next;
                pointer = pointer.next;
            }
        }
        
        return dummy.next;
    }


    //another method, use recursion
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} 
		else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}


23.
	//time complexity O(nlogk)
	//space complexity O(k + all the length)
	public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        if (lists == null || lists.length == 0) return dummy.next;
        //corner case!!! If lists.length == 0
        PriorityQueue<int[]> pq = new PriorityQueue<>(lists.length, ((int[] a, int[] b)->a[1] - b[1]));
        //priorityqueue can have both comparator and capacity
        for (int i = 0; i < lists.length; i ++) {
            if (lists[i] == null) continue;
            pq.offer(new int[]{i, lists[i].val});
        }
        
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            pointer.next = new ListNode(temp[1]);
            if (lists[temp[0]].next != null) {
                lists[temp[0]] = lists[temp[0]].next;
                pq.offer(new int[]{temp[0], lists[temp[0]].val});
            }
            pointer = pointer.next;
        }
        
        return dummy.next;
    }

    //another method
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists==null||lists.size()==0) return null;
        
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else 
                    return 1;
            }
        });
        //another comparator writing method
        
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        
        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);
            
        while (!queue.isEmpty()){
            tail.next=queue.poll();
            //It becomes multiple LinkedList, out of the array
            //Think them as different LinkedList
            tail=tail.next;
            
            if (tail.next!=null)
                queue.add(tail.next);
            //KEY!!!
        }
        return dummy.next;
	    }
	}


148.
	//time complexity O(nlogn)
	//space complexity O(1)
	public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        else {
            ListNode right = sortList(returnMid(head));
            ListNode left = sortList(head);
            return mergeSortedLinkedList(left, right);
        }
    }
    
    private ListNode returnMid(ListNode head) {
        int counter = 0;
        ListNode pointer = head;
        if (pointer == null) return null;
        while (pointer != null) {
            pointer = pointer.next;
            counter ++;
        }
        for (int i = 0; i < counter / 2 - 1; i ++) {
            head = head.next;
        }
        pointer = head.next;
        //pay attention to this relationship
        //here pointer is the [counter/2] index
        //before it, there are counter/2 ListNodes
        head.next = null;
        return pointer;
    }
/*
	private ListNode findMid(ListNode head) {
        ListNode cur = head;
        if (cur != null && cur.next != null && cur.next.next == null) {
            cur = cur.next;
            head.next = null;
            return cur;
        }
        while (cur != null && cur.next != null) {
            cur = cur.next.next;
            head = head.next;
        }
        ListNode res = head.next;
        head.next = null;
        return res;
    }
*/
    
    
    private ListNode mergeSortedLinkedList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pointer.next = l1;
                l1 = l1.next;
            }
            else {
                pointer.next = l2;
                l2 = l2.next;
            }
            pointer = pointer.next;
        }
        if (l1 != null) pointer.next = l1;
        else pointer.next = l2;
        return dummy.next;
    }


328.
	//time complexity O(n)
	//space complexity O(1), in place operation
	public ListNode oddEvenList(ListNode head) {
        if (head != null) {
            ListNode odd = head, even = head.next, evenstart = even;
            while (odd.next != null && even.next != null) {
            	//pay attention to the judge condition:
            	//if we want to have odd.next.next, we must assure odd.next != null
            	//so is for even.next.next
            	//start corner condition is also inside these judgement condition
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
                //do not have to worry about these two
                //they must exist if the first two exists
            }
            odd.next = evenstart;
        }
        return head;
    }


346.
	class MovingAverage {
	    private int size;
	    private int counter;
	    private double sum;
	    private Queue<Integer> data;

	    /** Initialize your data structure here. */
	    public MovingAverage(int size) {
	        this.size = size;
	        counter = 0;
	        sum = 0;
	        data = new LinkedList<>();
	    }
	    
	    public double next(int val) {
	        if (counter < size) {
	            data.add(val);
	            sum += val;
	            counter ++;
	            return sum / counter;
	        }
	        else {
	            int temp = data.poll();
	            data.add(val);
	            sum = sum - temp + val;
	            return sum / counter;
	        }
	    }
	}

	//another method, use array
	//use index to keep tracking the oldest number
	//every time call next, increment the index, so that index points to the oldest
	public class MovingAverage {
	    private int [] window;
	    private int n, insert;
	    private long sum;
	    
	    /** Initialize your data structure here. */
	    public MovingAverage(int size) {
	        window = new int[size];
	        insert = 0;
	        sum = 0;
	    }
	    
	    public double next(int val) {
	        if (n < window.length)  n++;
	        sum -= window[insert];
	        sum += val;
	        window[insert] = val;
	        insert = (insert + 1) % window.length;
	        
	        return (double)sum / n;
	    }
	}
	
	
24.
	//time complexity is O(n)
	//space complexity is O(1)
	public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        int temp = 0;
        ListNode pair1 = head;
        ListNode pair2 = head.next;
        
        while (pair1 != null && pair2 != null && pair2.next != null) {
            temp = pair1.val;
            pair1.val = pair2.val;
            pair2.val = temp;
            pair1 = pair1.next.next;
            pair2 = pair2.next.next;
        }
        
        if (pair2 != null && pair2.next == null) {
            temp = pair1.val;
            pair1.val = pair2.val;
            pair2.val = temp;
        }
        
        return head;
    }	


    //another method, with recursion
    public ListNode swapPairs(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }


19.
	//time complexity is O(n)
	//space complexity is O(1)
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        ListNode first = head;
        for (int i = 0; i < n; i ++) {
            if (first != null) first = first.next;
            else return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        pointer.next = head;
        //use a dummy node, can make things easier
        
        while (first != null) {
            first = first.next;
            pointer = pointer.next;
        }
        pointer.next = pointer.next.next;
        
        return dummy.next;
    }


142.
	//666!
	public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode slow2 = head;
                while (slow2 != slow) {
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow2;
            }
            
        }
        return null;
    }

//Lesson5: 6/11
//Java's List
	class ListNode<K, T> { //generics
		T val;
		K key;
		ListNode next;
		ListNode prev;

		//constructor
		ListNode(T val) {
			this.val = val;
			next = null;
			prev = null;
		}

		ListNode() { //overloading
			this(0); 
			//this represents object itself
			//use its method here, constructor above
		}
	}

160.
	//intersection start node of LinkedList
	//run in O(n) time and use only O(1) memory.
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode moveA = headA;
        ListNode moveB = headB;
        boolean visited = false;
        while (moveA != moveB) {
            if (moveA.next != null) moveA = moveA.next;
            else if (!visited) {
                moveA = headB;
                visited = true;
            }
            else return null;
            if (moveB.next != null) moveB = moveB.next;
            else moveB = headA;
        }
        return moveA;
    }

621.
	//time is O(n), space is O(1)
	public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char each : tasks) {
            map[each - 'A'] ++;
        }
        int max = 0, maxnum = 0;
        for (int each : map) {
            if (each == max) {
                maxnum ++;
            }
            else if (each > max) {
                maxnum = 1;
                max = each;
            }
        }
        
        int temp = 0;
        if (maxnum - 1 > n) {
            temp = max * maxnum;
        }
        else {
            temp = (max - 1) * (n + 1) + maxnum;
        }
        //calculate the frame size

        return Math.max(temp, tasks.length);
        //select larger one
    }

    //another similar solution
    // (c[25] - 1) * (n + 1) + 25 - i  is frame size
	// when inserting chars, the frame might be "burst", 
	// then tasks.length takes precedence
	// when 25 - i > n, the frame is already full at construction, 
	// the following is still valid.
	public class Solution {
	    public int leastInterval(char[] tasks, int n) {

	        int[] c = new int[26];
	        for(char t : tasks){
	            c[t - 'A']++;
	        }
	        Arrays.sort(c);
	        int i = 25;
	        while(i >= 0 && c[i] == c[25]) i--;

	        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
	    }
	}

	/*
	Examples:

	AAAABBBEEFFGG 3

	here X represents a space gap:

	Frame: "AXXXAXXXAXXXA"
	insert 'B': "ABXXABXXABXXA" <--- 'B' has higher frequency than the other characters, insert it first.
	insert 'E': "ABEXABEXABXXA"
	insert 'F': "ABEFABEXABFXA" <--- each time try to fill the k-1 gaps as full or evenly as possible.
	insert 'G': "ABEFABEGABFGA"
	AACCCBEEE 2

	3 identical chunks "CE", "CE CE CE" <-- this is a frame
	insert 'A' among the gaps of chunks since it has higher frequency than 'B' ---> "CEACEACE"
	insert 'B' ---> "CEABCEACE" <----- result is tasks.length;
	AACCCDDEEE 3

	3 identical chunks "CE", "CE CE CE" <--- this is a frame.
	Begin to insert 'A'->"CEA CEA CE"
	Begin to insert 'B'->"CEABCEABCE" <---- result is tasks.length;
	ACCCEEE 2

	3 identical chunks "CE", "CE CE CE" <-- this is a frame
	Begin to insert 'A' --> "CEACE CE" <-- result is (c[25] - 1) * (n + 1) + 25 -i = 2 * 3 + 2 = 8
	*/
	

//6/13

155.
	class MinStack {

	    private Node head;
	    
	    /** initialize your data structure here. */
	    public MinStack() {
	        head = null;
	    }
	    
	    public void push(int x) {
	        if (head == null) {
	            head = new Node(x, x);
	        }
	        else {
	            head = new Node(x, Math.min(x, head.min), head);
	        }
	    }
	    
	    public void pop() {
	        head = head.next;
	    }
	    
	    public int top() {
	        return head.val;
	    }
	    
	    public int getMin() {
	        return head.min;
	    }
	    
	    private class Node {
	    	//use a private class to record value and min before it
	        private int min;
	        private int val;
	        private Node next;
	        
	        public Node(int val, int min) {
	            this(val, min, null);
	        }
	        
	        public Node(int val, int min, Node next) {
	            this.val = val;
	            this.min = min;
	            this.next = next;
	        }
	    }
	}


	//another good method
	class MinStack {
	    int min = Integer.MAX_VALUE;
	    Stack<Integer> stack = new Stack<Integer>();
	    public void push(int x) {
	        // only push the old minimum value when the current 
	        // minimum value changes after pushing the new value x
	        if(x <= min){          
	            stack.push(min);
	            min=x;
	        }
	        stack.push(x);
	        //every time comes to a min value
	        //store the second min value before it!!!
	    }

	    public void pop() {
	        // if pop operation could result in the changing of the current minimum value, 
	        // pop twice and change the current minimum value to the last minimum value.
	        if(stack.pop() == min) min=stack.pop();
	    }

	    public int top() {
	        return stack.peek();
	    }

	    public int getMin() {
	        return min;
	    }
	}


42.
	Time complexity is O(n);
	Space complexity is O(1);
	public int trap(int[] height) {
        int highest = 0;
        for (int i = 0; i < height.length; i ++) {
            if (height[i] > height[highest]) highest = i;
        }
        int sum = 0;
        int high = 0;
        
        //key is to tranverse from two end
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

    //another good method, two pointers
    public int trap(int[] A) {
	    if (A.length < 3) return 0;
	    
	    int ans = 0;
	    int l = 0, r = A.length - 1;
	    
	    // find the left and right edge which can hold water
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


	//second time writing method
	class Solution {
	    public int trap(int[] height) {
	        int left = 0, right = height.length - 1;
	        int counter = 0, record;
	        while (left < right) {
	            if (height[left] <= height[right]) {
	                record = height[left];
	                while (left < right && height[left] <= record) {
	                    left ++;
	                    if (record > height[left]) counter += record - height[left];
	                }
	            } else {
	                record = height[right];
	                while (left < right && height[right] <= record) {
	                    right --;
	                    if (record > height[right]) counter += record - height[right];
	                }
	            }
	        }
	        return counter;
	    }
	}


150.
	Time complexity is O(n);
	Space complexity is O(n);
	public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
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










//6/14
85.
	//build on the basic of 84, using stack
	//thinking about diagram
	time complexity is O(n*m);
	space complexity is O(n*m); 
	public int maximalRectangle(char[][] matrix) {
        int maxarea = 0;
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int[][] heights = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[0].length; j ++) {
                if (i == 0) heights[i][j] = (matrix[i][j] == '1') ? 1 : 0;
                else heights[i][j] = (matrix[i][j] == '1') ? (heights[i - 1][j] + 1) : 0;
            }
        }
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i ++) {
            stack.clear();
            for (int j = 0; j <= heights[0].length; j ++) {
                int compare = (j < heights[0].length) ? heights[i][j] : 0;
                while (!stack.isEmpty() && heights[i][stack.peek()] > compare) {
                    int temp = stack.pop();
                    maxarea = Math.max(maxarea, heights[i][temp] * ((stack.isEmpty()) ? j : (j - 1 - stack.peek())));
                }
                stack.push(j);
            }
        }
        
        return maxarea;
    }



173.
	//constructor takes O(n)
	//all the other method takes O(1), use O(1) memory
	public class BSTIterator {
	    
	    Queue<Integer> queue;

	    public BSTIterator(TreeNode root) {
	        queue = new LinkedList<>();
	        helper(root);
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return queue.peek() != null;
	    }

	    /** @return the next smallest number */
	    public int next() {
	        return queue.poll();
	    }
	    
	    private void helper(TreeNode root) {
	        if (root == null) return;
	        helper(root.left);
	        queue.add(root.val);
	        helper(root.right);        
	    }
	}


316.
	time complexity is O(n);
	space complexity is O(26);
	//use stringbuilder as stack here
	//only store one element, the most left one if possible
	public String removeDuplicateLetters(String s) {
        int[] map = new int[26];
        boolean[] visited = new boolean[26];
        for (char each : s.toCharArray()) {
            map[each - 'a'] ++;
        }
        //count character show times
        
        StringBuilder sb = new StringBuilder();
        //use as a stack
        //char in stack in possible increase order
        int len = 0;
        //store len for accelerate
        for (char each : s.toCharArray()) {
            map[each - 'a'] --;
            if (visited[each - 'a']) continue;
            //keep the left most char
            //continue if visited that char
            
            while (len > 0 && each < sb.charAt(len - 1) && map[sb.charAt(len - 1) - 'a'] > 0) {
                visited[sb.charAt(len - 1) - 'a'] = false;
                len --;
                sb.setLength(len);                
            }
            //char has in hand
            //pop the char in the stringbuiler 
            //if we have more times left for that char
            
            sb.append(each);
            len ++;
            visited[each - 'a'] = true;
            //append the char in hand
            //increase the len and change the array visited
        }
        
        return sb.toString();
    }


224.
	//not a good method
	public int calculate(String s) {
        if (s.length() == 0) return 0;

        Stack<String> store = new Stack<>();
        Stack<String> calcu = new Stack<>();
        
        int res = 0;
        for (int left = 0, len = 1; left + len <= s.length(); ) {
            char temp = s.charAt(left + len - 1);
            if (temp == ' ' && len == 1) left ++;
            else if (temp == '(' || temp == '+' || temp == '-') {
                store.push(s.substring(left, left + len));
                left += len;
                len = 1;
            }
            else if (temp == ')') {
                while (!store.peek().equals("(")) {
                    calcu.push(store.pop());
                }
                res = helper(calcu);
                store.pop();
                store.push("" + res);
                left += len;
                len = 1;
            }
            else if (left + len == s.length() || judge(s.charAt(left + len))) {
                store.push(s.substring(left, left + len));
                left += len;
                len = 1;
            }
            else {
                len ++;
            }
        }

        while (!store.isEmpty()) {
            calcu.push(store.pop());
        }
        res = helper(calcu);
        
        return res;
    }
    
    private int helper(Stack<String> calcu) {
        int res = 0;
        while (!calcu.isEmpty()) {
            String temp = calcu.pop();
            if (!temp.equals("+") && !temp.equals("-")) res = Integer.parseInt(temp);
            else if (temp.equals("+")) {
                res += Integer.parseInt(calcu.pop());
            }
            else {
                res -= Integer.parseInt(calcu.pop());
            }
        }
        return res;
    }
    
    private boolean judge(char a) {
        return a == ' ' || a == '+' || a == '-' || a == '(' || a == ')';
    }


    //another method
    public static int calculate(String s) {
		int len = s.length(), sign = 1, result = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < len; i++) {
			if (Character.isDigit(s.charAt(i))) {
				int sum = s.charAt(i) - '0';
				while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
					sum = sum * 10 + s.charAt(i + 1) - '0';
					i++;
				}
				result += sum * sign;
				//calculate when no braket
			} else if (s.charAt(i) == '+')
				sign = 1;
			else if (s.charAt(i) == '-')
				sign = -1;
			//use int sign to record '+' & '-'
			else if (s.charAt(i) == '(') {
				stack.push(result);
				stack.push(sign);
				result = 0;
				sign = 1;
			//comes to '(', put result now in stack
			} else if (s.charAt(i) == ')') {
				result = result * stack.pop() + stack.pop();
			}
			//calculate inside bracket, put it in result

		}
		return result;
	}


232.
	//quite basic, I have nothing to say
	class MyQueue {

	    private Stack<Integer> stack1;
	    private Stack<Integer> stack2;
	    /** Initialize your data structure here. */
	    public MyQueue() {
	        stack1 = new Stack<>();
	        stack2 = new Stack<>();
	    }
	    
	    /** Push element x to the back of queue. */
	    public void push(int x) {
	        stack1.push(x);
	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    public int pop() {
	        move();
	        return stack2.pop();
	    }
	    
	    /** Get the front element. */
	    public int peek() {
	        move();
	        return stack2.peek();
	    }
	    
	    /** Returns whether the queue is empty. */
	    public boolean empty() {
	        return stack1.isEmpty() && stack2.isEmpty();    
	    }
	    
	    private void move() {
	        if (stack2.isEmpty()){
	            while (!stack1.isEmpty()) stack2.push(stack1.pop());
	        }            
	    }
	}


341.
	/**
	 * // This is the interface that allows for creating nested lists.
	 * // You should not implement it, or speculate about its implementation
	 * public interface NestedInteger {
	 *
	 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
	 *     public boolean isInteger();
	 *
	 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
	 *     // Return null if this NestedInteger holds a nested list
	 *     public Integer getInteger();
	 *
	 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
	 *     // Return null if this NestedInteger holds a single integer
	 *     public List<NestedInteger> getList();
	 * }
	 */
	public class NestedIterator implements Iterator<Integer> {
	    
	    private Queue<Integer> queue;

	    public NestedIterator(List<NestedInteger> nestedList) {
	        queue = new LinkedList<>();
	        helper(nestedList);
	    }

	    @Override
	    public Integer next() {
	        return queue.poll();
	    }

	    @Override
	    public boolean hasNext() {
	        return queue.peek() != null;
	        //queue.peek() or .poll() return null if empty
	    }
	    
	    private void helper(List<NestedInteger> nestedList) {
	        for (NestedInteger each : nestedList) {
	            if (each.isInteger()) queue.add(each.getInteger());
	            else {
	                helper(each.getList());
	            }
	        }
	    }
	}
	//the key is to understanc that
	//give a list of elements, whose class is NestedInteger
	//the NestedInteger can be seen as a list of NestedInteger or an Integer
	//use recursion to get all numbers, store them in the queue

	//another method using stack
	//use hasNext() before using next()
	//this method considers that, only open the list which they are going to use
	public class NestedIterator implements Iterator<Integer> {
	    Stack<NestedInteger> stack = new Stack<>();
	    public NestedIterator(List<NestedInteger> nestedList) {
	        for(int i = nestedList.size() - 1; i >= 0; i--) {
	            stack.push(nestedList.get(i));
	        }
	    }

	    @Override
	    public Integer next() {
	        return stack.pop().getInteger();
	    }

	    @Override
	    public boolean hasNext() {
	        while(!stack.isEmpty()) {
	            NestedInteger curr = stack.peek();
	            if(curr.isInteger()) {
	                return true;
	            }
	            stack.pop();
	            for(int i = curr.getList().size() - 1; i >= 0; i--) {
	                stack.push(curr.getList().get(i));
	            }
	        }
	        return false;
	    }
	}


394.
	//need more practice on this topic, stack and bracket
	//corner cases: 
	//upperCase: "3[a]2[b4[F]c]"
	//number and character: "3[a2[c]]"
	public String decodeString(String s) {
        if (s.length() == 0) return "";
        
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String temp = "";
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) != '[' && s.charAt(i) != ']' && s.charAt(i) - '0' < 10) {
                while (i < s.length() && s.charAt(i) != '[' && s.charAt(i) != ']' && s.charAt(i) - '0' < 10) {
                    temp = temp + s.charAt(i);
                    i ++;
                }
                stack.push(temp);
                i --;
                temp = "";
            }
            else if (s.charAt(i) != '[' && s.charAt(i) != ']' && s.charAt(i) - 'A' >= 0) {
                while (i < s.length() && s.charAt(i) != '[' && s.charAt(i) != ']' && s.charAt(i) - 'A' >= 0) {
                    temp = temp + s.charAt(i);
                    i ++;
                }
                stack.push(temp);
                i --;
                temp = "";
            }
            //char: 0,1,2 ... 9, A,B,C... Z, a, b, c ...
            else if (s.charAt(i) == ']') {
                while (!stack.peek().equals("[")) {
                    sb.insert(0, stack.pop());
                }
                String repeat = sb.toString();
                sb.setLength(0);
                stack.pop();
                int count = Integer.parseInt(stack.pop());
                for (int j = 0; j < count; j ++) {
                    sb.append(repeat);
                }
                stack.push(sb.toString());
                sb.setLength(0);
            }
            else {
                stack.push("[");
            }
        }
        
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            //use insert to the index you want
        }
        return sb.toString();
    }

    //another method
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        //two stacks, store number and string
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
            	//isDight() method
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }
            else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            }
            else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder (resStack.pop());
                //store
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                    //plus repeat
                }
                res = temp.toString();
                idx++;
            }
            else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }


83.
	time complexity is O(n);
	space complexity is O(n);
	public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        
        Set<Integer> set = new HashSet<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        while (dummy.next != null) {
            if (!set.contains(dummy.next.val)) {
                set.add(dummy.next.val);
                dummy = dummy.next;
            }
            else {
                dummy.next = dummy.next.next;
            }
        }
        
        return head;
    }


203.
	//dummy node is really good
	time complexity is O(n);
	space complexity is O(1);
	public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        dummy.next = head;
        
        while (pointer.next != null) {
            if (pointer.next.val == val) {
                pointer.next = pointer.next.next;
            }
            else {
                pointer = pointer.next;
            }
        }
        
        return dummy.next;
    }


143.
	//find middle --> reverse --> reorder
	public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode mid = findMid(head);
        mid = reverse(mid);
        ListNode pointer;
        while (mid != null) {
            pointer = head.next;
            head.next = new ListNode(mid.val);
            head.next.next = pointer;
            mid = mid.next;
            head = head.next.next;
        }
        //must do on the list before
        //for void output
    }
    
    private ListNode findMid(ListNode head) {
        int count = 0;
        ListNode pointer = head;
        while (pointer != null) {
            pointer = pointer.next;
            count ++;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (int i = 0; i < count - count / 2; i ++) {
            dummy = dummy.next;
        }
        head = dummy.next;
        dummy.next = null;
        return head;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode pointer = head;
        while (pointer != null) {
            head = head.next;
            pointer.next = dummy.next;
            dummy.next = pointer;
            pointer = head;
        }
        return dummy.next;
    }

    //another method
    public void reorderList(ListNode head) {
        if(head==null||head.next==null) return;
        
        //Find the middle of the list
        ListNode p1=head;
        ListNode p2=head;
        while(p2.next!=null&&p2.next.next!=null){ 
            p1=p1.next;
            p2=p2.next.next;
        }
        
        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode preMiddle=p1;
        ListNode preCurrent=p1.next;
        while(preCurrent.next!=null){
            ListNode current=preCurrent.next;
            preCurrent.next=current.next;
            current.next=preMiddle.next;
            preMiddle.next=current;
        }
        
        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
        p1=head;
        p2=preMiddle.next;
        while(p1!=preMiddle){
            preMiddle.next=p2.next;
            p2.next=p1.next;
            p1.next=p2;
            p1=p2.next;
            p2=preMiddle.next;
        }
    }


445.
	//using stacks
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        };
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        int sum = 0;
        ListNode list = new ListNode(0);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            list.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;
            sum /= 10;
        }
        
        return list.val == 0 ? list.next : list;
    }


//6/15
    //classical binary search:
    public int binarySearch(int[] nums, int target) {
    	if (nums == null || nums.length == 0) return -1;
    	//edge cases, do not forget
    	int left = 0;
    	int right = nums.length - 1;
    	int mid;
    	//mid outside
    	//if inside, log(n) space complexity of mid
    	//if not garbage collection, but ok in java
    	while (left <= right) {
    		mid = left + (right - left) / 2;
    		if (nums[mid] == target) return mid;
    		else if (nums[mid] < target) left = mid + 1;
    		//must have +1 and -1 or infinit loop
    		//in edge case of length == 1
    		else right = mid - 1;
    	}
    	return -1;
    }
    //result (right, left)

    //another way of binary search
    public int binarySearch(int[] nums, int target) {
    	if (nums == null || nums.length == 0) return -1;
    	int left = 0, right = nums.length - 1;
    	//if nums.length == 1, edge case
    	//must use nums.length - 1
    	int mid;
    	while (left + 1 < right) {
    		mid = left + (right - left) / 2;
    		//overflow of Integer
    		//int mid = left + (right - left) / 2;
    		if (nums[mid] == target) return mid;
    		else if (nums[mid] < target) left = mid;
    		else right = mid;
    	}
    	if (nums[left] == target) return left;
    	else if (nums[right] == target) return right;
    	else return -1;
    }
    //result (left, right)


69.
	//using binary search
	time complexity is O(n)
	//first expolential for the binary size of the array
	//then the binary search using the logn;
	space complexity is O(1)
	public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        
        int left = 0, right = x;
        int mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (x / mid == mid && x % mid == 0) return mid;
            else if (x / mid == mid && x % mid > 0 || x / mid > mid) left = mid;
            else right = mid;
        }
        
        return left;
    }


74.
	time complexity is O(logn + logm)
	space complexity is O(1)
	//this way of binary search can:
	//if left is moved, the left is smaller than target
	//if right is moved, the right is larger than target
	//change with the changing terms
	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        //edge case 1: no rows or no columns
        
        int left = 0, right = matrix.length - 1, mid;
        while (matrix.length != 1 && left + 1 < right) {
            mid = left + (right - left) / 2;
            if (matrix[mid][0] == target) return true;
            else if (matrix[mid][0] < target) left = mid;
            else right = mid;
        }
        if (matrix[left][0] == target || matrix[right][0] == target) return true;
        //edge case 2: on the left side of one column
        if (matrix[left][0] > target) return false;
        //edge case 3: the first row's first element is larger than target
        
        int row = (matrix[right][0] < target) ? right : left;
        //edge case 4: the last row's first element is smaller than target
        left = 0;
        right = matrix[0].length - 1;     
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) return true;
            else if (matrix[row][mid] > target) right = mid;
            else left = mid;
        }
        if (matrix[row][left] == target || matrix[row][right] == target) return true;
        //final stage: check the left element and the right element

        return false;
    }


240.
	//use divide and conquer and binary search
	time complexity is O((n*m)^log_4 3)
	space complexity is O(1)
	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        return helper(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }
    
    private boolean helper(int[][] matrix, int target, int up, int down, int left, int right) {
        if (matrix[up][left] == target || matrix[down][right] == target || 
            matrix[up][right] == target || matrix[down][left] == target) return true;
        else if (up >= down - 1 && left >= right - 1 || 
                 matrix[up][left] > target || matrix[down][right] < target) return false;
        //edge cases: when down - up <= 1 and right - left <= 1
        else {
            int midrow = up + (down - up) / 2;
            int midcol = left + (right - left) / 2;
            return helper(matrix, target, up, midrow, left, midcol) || helper(matrix, target, up, midrow, midcol, right) ||
                helper(matrix, target, midrow, down, left, midcol) || helper(matrix, target, midrow, down, midcol, right);
        }
        //recursion
    }

    //another method
    time complexity is O(m + n)
    space complexity is O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }



302.
	//using DFS
	time complexity is O(nums of '1')
	space complexity is O(mn)
	private int[][] move = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    private int[] area = new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
    
    public int minArea(char[][] image, int x, int y) {
        if (image.length == 0 || image[0].length == 0) return 0;
        
        boolean[][] visited = new boolean[image.length][image[0].length];
        helper(image, x, y, visited);
        return (area[2] - area[0] + 1) * (area[3] - area[1] + 1);
    }
    
    private void helper(char[][] image, int x, int y, boolean[][] visited) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length || visited[x][y] || image[x][y] == '0') return;
        area[0] = Math.min(area[0], x);
        area[1] = Math.min(area[1], y);
        area[2] = Math.max(area[2], x);
        area[3] = Math.max(area[3], y);
        visited[x][y] = true;
        for(int[] each : move) {
            helper(image, x + each[0], y + each[1], visited);
        }
    }

    //using binary search
    public int minArea(char[][] image, int x, int y) {
	    int left = leftmost(image, 0, y, true);
	    int right = rightmost(image, y, image[0].length - 1, true);
	    int top = leftmost(image, 0, x, false);
	    int bottom = rightmost(image, x, image.length - 1, false);
	    return (right - left + 1) * (bottom - top + 1);
	}

	int leftmost(char[][] image, int min, int max, boolean horizontal) {
	    int l = min, r = max;
	    while (l < r) {
	        int mid = l + (r - l) / 2;
	        if (!hasBlack(image, mid, horizontal)) {
	            l = mid + 1;
	        } else {
	            r = mid;
	        }
	    }
	    return l;
	}

	int rightmost(char[][] image, int min, int max, boolean horizontal) {
	    int l = min, r = max;
	    while (l < r) {
	        int mid = l + (r - l + 1) / 2;
	        if (!hasBlack(image, mid, horizontal)) {
	            r = mid - 1;
	        } else {
	            l = mid;
	        }
	    }
	    return r;
	}

	boolean hasBlack(char[][] image, int mid, boolean horizontal) {
	    if (horizontal) {
	        for (int i = 0; i < image.length; i++) {
	            if (image[i][mid] == '1') {
	                return true;
	            }
	        }
	    } else {
	        for (int j = 0; j < image[0].length; j++) {
	            if (image[mid][j] == '1') {
	                return true;
	            }
	        }
	    }
	    return false;
	}

	//more concise way
	public int minArea(char[][] image, int x, int y) {
	    int m = image.length, n = image[0].length;
	    int colMin = binarySearch(image, true, 0, y, 0, m, true);
	    int colMax = binarySearch(image, true, y + 1, n, 0, m, false);
	    int rowMin = binarySearch(image, false, 0, x, colMin, colMax, true);
	    int rowMax = binarySearch(image, false, x + 1, m, colMin, colMax, false);
	    return (rowMax - rowMin) * (colMax - colMin);
	}

	public int binarySearch(char[][] image, boolean horizontal, int lower, int upper, int min, int max, boolean goLower) {
	    while(lower < upper) {
	        int mid = lower + (upper - lower) / 2;
	        boolean inside = false;
	        for(int i = min; i < max; i++) {
	            if((horizontal ? image[i][mid] : image[mid][i]) == '1') {
	                inside = true; 
	                break;
	            }
	        }
	        //for-loop is the hasblack function
	        if(inside == goLower) {
	            upper = mid;
	        } else {
	            lower = mid + 1;
	        }
	    }
	    return lower;
	}


354.
	time complexity is O(n^2)
	space complexity is O(n)
	//using dp
	public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length <= 1) return envelopes.length;
        
        Arrays.sort(envelopes, new sortingComparator());
        //the correct way to write comparator in sort
        //can with and without type
        int res = 1;
        int[] dp = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i ++) {
            if (i == 0) dp[i] = 1;
            else {
                dp[i] = 1;
                for (int j = 0; j < i; j ++) {
                    if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(res, dp[i]);
            }
        }
        
        return res;
    }
    
    private class sortingComparator implements Comparator <int[]> {
    	//using private class, implements comparator with type!!!
        public int compare(int[] a, int[] b) {
            if (a[0] - b[0] != 0) return a[0] - b[0];
            else return a[1] - b[1];
        }
    }

    //another way, dp with binary search
    //???
    public int maxEnvelopes(int[][] envelopes) {
	    if(envelopes == null || envelopes.length == 0 
	       || envelopes[0] == null || envelopes[0].length != 2)
	        return 0;
	    Arrays.sort(envelopes, new Comparator<int[]>(){
	        public int compare(int[] arr1, int[] arr2){
	            if(arr1[0] == arr2[0])
	                return arr2[1] - arr1[1];
	            else
	                return arr1[0] - arr2[0];
	       } 
	    });
	    //another way of writing the comparator
	    //here you have to write type inside the sort()
	    int dp[] = new int[envelopes.length];
	    int len = 0;
	    for(int[] envelope : envelopes){
	        int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
	        //arrays.binarySearch
	        //binarySearch(int/long[] a, int fromIndex, int toIndex//inclusive, int/long key)
	        //index of the search key, if it is contained in the array; 
	        //otherwise, (-(insertion point) - 1). 
	        //The insertion point is defined as the point at which the key would be inserted into 
	        //the array: the index of the first element greater than the key, 
	        //or a.length if all elements in the array are less than the specified key.
	        if(index < 0)
	            index = -(index + 1);
	        dp[index] = envelope[1];
	        if(index == len)
	            len++;
	    }
	    return len;
	}

	//using binary search!!!
	//key is to sort with ascending first number and descending second number, so the behind pair can
	//replace the first pair??? need to think more!!!
	class Solution {
	    public int maxEnvelopes(int[][] envelopes) {
	        if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) return 0;
	        if (envelopes.length == 1) return 1;
	        
	        Arrays.sort(envelopes, new Comparator<int[]>(){
	            @Override
	            public int compare(int[] a, int[] b) {
	                if (a[0] == b[0]) {
	                    return b[1] - a[1];
	                }
	                return a[0] - b[0];
	            }
	        });
	        
	        int[] dp = new int[envelopes.length];
	        int size = 0;
	        for (int i = 0; i < envelopes.length; i ++) {
	            int left = 0, right = size, mid;
	            while (left < right) {
	                mid = left + (right - left) / 2;
	                if (envelopes[dp[mid]][0] < envelopes[i][0] && envelopes[dp[mid]][1] < envelopes[i][1]) {
	                    left = mid + 1;
	                } else {
	                    right = mid;
	                }
	            }
	            if (left == size) {
	                size ++;
	            }
	            dp[left] = i;
	        }
	        
	        return size;
	    }
	}


225.
	//using one queue
	class MyStack {
	    private Queue<Integer> queue;
	    private int nums;
	    
	    /** Initialize your data structure here. */
	    public MyStack() {
	        queue = new LinkedList<>();
	        nums = 0;
	    }
	    
	    /** Push element x onto stack. */
	    public void push(int x) {
	        queue.offer(x);
	        if (!empty()) {
	            for (int i = 0; i < nums; i ++) {
	                queue.offer(queue.poll());
	            }
	        }
	        nums ++;
	    }
	    
	    /** Removes the element on top of the stack and returns that element. */
	    public int pop() {
	        nums --;
	        return queue.poll();
	    }
	    
	    /** Get the top element. */
	    public int top() {
	        return queue.peek();
	    }
	    
	    /** Returns whether the stack is empty. */
	    public boolean empty() {
	        return nums == 0;
	    }
	}

	//using a deque
	//nothing to say
	//completely cheating method!!!
	class MyStack {
	    private Deque<Integer> deque;
	    private int nums;
	    
	    /** Initialize your data structure here. */
	    public MyStack() {
	        deque = new LinkedList<>();
	        nums = 0;
	    }
	    
	    /** Push element x onto stack. */
	    public void push(int x) {
	        deque.offerLast(x);
	        nums ++;
	    }
	    
	    /** Removes the element on top of the stack and returns that element. */
	    public int pop() {
	        nums --;
	        return deque.pollLast();
	    }
	    
	    /** Get the top element. */
	    public int top() {
	        return deque.peekLast();
	    }
	    
	    /** Returns whether the stack is empty. */
	    public boolean empty() {
	        return nums == 0;
	    }
	}


817.
	time complexity is O(n + G.length)
	space complexity is O(G.length)
	public int numComponents(ListNode head, int[] G) {
        if (head.next == null) return 1;
        
        Set<Integer> set = new HashSet<>(G.length);
        //pay attention here
        //cannot use Arrays.asList(G) directly
        //function thinks you are creating a list<int[]> instead of list<Integer>
        for (int each : G) {
            set.add(each);
        }
        while (head.next != null) {
            if (set.contains(head.next.val)) set.remove(head.val);
            head = head.next;
        }
        
        return set.size();
    }


147.
	//inplement insertion sort on LinkedList
	public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0), pointer = dummy, pointerrecord = head;
        dummy.next = head;
        //use of dummy head!!!
        
        while (head.next != null) {
            if (head.val > head.next.val) {
                pointerrecord = head.next;
                head.next = head.next.next;
                while (pointer.next.val < pointerrecord.val) {
                    pointer = pointer.next;
                }
                pointerrecord.next = pointer.next;
                pointer.next = pointerrecord;
                pointer = dummy;
            }
            else {
                head = head.next;                
            }
            //here, do not move head if you are in the first situation!!!
        }
        
        return dummy.next;
    }


92.
	//only one pass
	time complexity is O(n)
	space complexity is O(n)
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head.next == null) return head;
        ListNode dummy = new ListNode(0), pointer = dummy, move = dummy;
        
        for (int index = 1; head != null; index ++) {
        	//end condition is head != null
        	//if head != null, head.next always exits
            ListNode newNode = new ListNode(head.val);
            if (index == m) {
                pointer = move;
                newNode.next = pointer.next;
                pointer.next = newNode;
                move = newNode;
            }
            else if (index > m && index <= n) {
                newNode.next = pointer.next;
                pointer.next = newNode;
            }
            else {
                move.next = newNode;
                move = move.next;
            }
            //three different cases

            head = head.next;
        }
        //use of dummy node
        return dummy.next;
    }


//6/16
    //use two stack instead of node
    //one more method can use only one stack
    public class MinStack{
    	private Stack<Integer> stack1;
    	private Stack<Integer> stack2;
    	public MinStack(){
    		stack1 = new Stack<>();
    		stack2 = new Stack<>();
    	}

    	public void push(int val){
    		if (stack2.isEmpty() || stack2.peek() >= val) {
    			stack2.push(val);
    		}
    		stack1.push(val);
    	}

    	public int pop(){//use Integer, can return null
    		//if int, throw exception
    		//corner case check
    		int temp = stack1.pop();
    		if (stack2.peek() == temp) stack2.pop();
    		return temp;
    	}

    	public int peek(){
    		return stack1.peek();
    	}

    	public int getMin(){
    		return stack2.peek();
    	}

    	public boolean isEmpty(){
    		return stack1.isEmpty();
    	}
    }


    //pre-order
    public void preOrder(TreeNode root) {
    	if (root == null) return;
    	System.out.println(root.val);
    	preOrder(root.left);
    	preOrder(root.right);
    }

    //in-order
    public void inOrder(TreeNode root) {
    	if (root == null) return;
    	inOrder(root.left);
    	//wall
    	System.out.println(root.val);
    	inOrder(root.right);
    	//return, implicit one
    }

    //post-order
    public void postOrder(TreeNode root) {
    	if (root == null) return;
    	postOrder(root.left);
    	postOrder(root.right);    
    	System.out.println(root.val);	
    }


    //Iterative
    //pre-order
    public List<Integer> preOderTraversal(TreeNode root){
    	List<Integer> ans = new ArrayList<>();
    	if (root == null) return ans;
    	Stack<TreeNode> st = new Stack<>();
    	while (root != null || !st.isEmpty()){
    		if (root == null){
    			root = st.pop();
    			root = root.right;
    		}
    		else{
    			st.push(root);
    			ans.add(root.val);
    			root = root.left;
    		}
    	}
    	return ans;
    }

    //in-order
    public List<Integer> inOderTraversal(TreeNode root){
    	List<Integer> ans = new ArrayList<>();
    	if (root == null) return ans;
    	Stack<TreeNode> st = new Stack<>();
    	while (root != null || !st.isEmpty()){
    		if (root == null){
    			root = st.pop();
    			ans.add(root.val);
    			root = root.right;
    		}
    		else{
    			st.push(root);
    			root = root.left;
    		}
    	}
    	return ans;
    }

    //post-order
    public List<Integer> postOderTraversal(TreeNode root){
    	List<Integer> ans = new ArrayList<>();
    	if (root == null) return ans;
    	Stack<TreeNode> st = new Stack<>();
    	while (root != null || !st.isEmpty()){
    		if (root == null){
    			root = st.pop();
    			root = root.left;
    		}
    		else{
    			ans.add(root.val);
    			st.push(root);
    			root = root.right;
    		}
    	}
    	Collections.reverse(ans);
    	//The Key!
    	return ans;
    }


    //get the height of the root
    //get the height of the left subtree
    //get the height of the right subtree
    public int getHeight(TreeNode root){//maxDepth
    	if (root == null) return 0;
    	int leftHeight = getHeight(root.left);
    	//wall
    	int rightHeight = getHeight(root.right);
    	return Math.max(leftHeight, rightHeight) + 1;
    }

    //get the min depth of the tree
    public int getHeight(TreeNode root){//maxDepth
    	if (root == null) return 0;
    	int leftHeight = getHeight(root.left);
    	//wall
    	int rightHeight = getHeight(root.right);
    	return (leftHeight == 0 || rightHeight == 0) ? 
    		Math.max(leftHeight, rightHeight) : 
    		Math.min(leftHeight, rightHeight) + 1;
    }
    //T(n) = 2*T(n/2) + O(1) ---> O(n)


    //balanced binary tree
    //time complexity is O(nlogn)
    public boolean isBalance(TreeNode root){
    	if (root == null) return true;
    	if (Math.abs(getHeight(root.left) - 
    		getHeight(root.right)) > 1) return false;
    	return isBalance(root.left) && isBalance(root.right);
    	//put height comparsion first to cut the leaves
    	//recursion operation and constant operation
    }
    //T(n) = 2*T(n/2) + O(n) ---> O(nlogn)


//6/18
    //Lesson 7
    //Q 4
    public void invertTree(TreeNode root) {
    	if (root == null) return;
    	invertTree(root.right);
    	invertTree(root.left);
    	TreeNode temp = root.left;
    	root.left = root.right;
    	root.right = temp;
    }

    public TreeNode invertTree(TreeNode root) {
    	if (root == null) return null;
    	TreeNode newLeft = invertTree(root.left);
    	TreeNode newRight = invertTree(root.right);
    	root.left = newLeft;
    	root.right = newRight;
    	return root;
    }

    //DFS root---right---left, first work then swap
    //left & right, DFS, binary tree, increase order or decrease order
    public void invertTree(TreeNode root) {
    	if (root == null) return;
    	TreeNode temp = root.left;
    	root.left = root.right;
    	root.right = temp;

    	invertTree(root.right);
    	invertTree(root.left);
    }


	//symetric check
    public boolean isSymetric(TreeNode root){
    	if (root == null) return true;
    	return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right){
    	if (left == null && right == null) return true;
    	else if (left == null || right == null) return false;
    	else if (left.val != right.val) return false;
    	else {
    		return helper(left.right, right.left) && 
    			helper(left.left, right.right);
    	}
    }


    //part of tree
    public boolean mirror(TreeNode left, TreeNode right){
    	if (left == null && right == null) return true;
    	if (left == null || right == null || left.val != right.val) return false;
    	return mirror(left.left, right.left) && mirror(left.right, right.right);
    }


    //niu tree
    public boolean niu(TreeNode left, TreeNode right){
    	if (left == null && right == null) return true;
    	else if (left == null || right == null) return false;
    	else if (left.val != right.val) return false;
    	else {
    		return (helper(left.right, right.left) && 
    			helper(left.left, right.right)) || 
    			(helper(left.left, right.left) && 
    			helper(left.right, right.right));
    	}
    }
    //docs.oracle.com/javas/tutorial/java/nutsandbolts/operators.html
    //O(n^2) ---> T(n) = 4*T(n/2) + O(1)
    //Or recursion tree O(1), O(4), O(4^2) ... O(4^logn-1)



//6/19
    public boolean isBST(TreeNode root){
    	return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    //possible one:
    //Long.MIN_VALUE && LONG.MAX_VALUE

    private boolean isBST(TreeNode root, int min, int max){
    	if (root == null) return true;
    	if (root.val < max && root.val > min && 
    		isBST(root.left, min, root.val) && 
    		isBST(root.right, root.val, max)) return true;
    	return false;
    }
    //BST does not allow the replicate


    //Q2
    public List<Integer> inOrderTraverse(TreeNode root, int k1, int k2){
    	List<Integer> list = new ArrayList<>();
    	helper(list, root, k1, k2);
    	return list;
    }

    private void helper(List<Integer> list, TreeNode root, int k1, int k2){
    	if (root == null) return;
    	if (root.val >= k1) helper(list, root.left, k1, k2);
    	if (root.val <= k2 && root.val => k1) list.add(root.val);
    	if (root.val <= k2) helper(list, root.right, k1, k2);
    }
    //S2 O(logn) ~ O(n)


    //Q3
    public int search(TreeNode root, int k){
    	int[] closest_node = new int[]{root.val};
    	helper(root, k, closest_node);
    	return closest_node;
    }

    private void helper(TreeNode root, int k, int[] closest_node){
    	if (root ==null) return;
    	closest_node[0] = (Math.abs(closest_node[0] - k) > 
    		Math.abs(root.val - k)) ? root.val : closest_node[0];
    	if (root.val > k) {
    		helper(root.left, k, closest_node);
    	}
    	else if (root.val < k) {
    		helper(root.right, k, closest_node);
    	}
    	else return;
    }


    //second method
    public int search(TreeNode root, int k) throws Exception{
    	if (root == null) throw new IllegalArgumentException();//Pay attention!
    	int closest_node = root.val;
    	while (root != null && root.val != k){
	    	closest_node = (Math.abs(closest_node - k) 
	    		> Math.abs(root.val - k)) ? root.val : closest_node;
	    	if (root.val > k) {
	    		root = root.left;
	    	}
	    	else if (root.val < k) {
	    		root = root.right;
	    	}
    	}
    	return (root != null) ? k : closest_node;
    }

	//another writing
    public int search(TreeNode root, int k) throws Exception{
    	if (root == null) throw new IllegalArgumentException();//Pay attention!
    	int closest_node = root.val;//Pay attention!!!
    	while (root != null){
	    	closest_node = (Math.abs(closest_node - k) 
	    		> Math.abs(root.val - k)) ? root.val : closest_node;
	    	if (root.val > k) {
	    		root = root.left;
	    	}
	    	else if (root.val < k) {
	    		root = root.right;
	    	}
	    	else {
	    		return k;
	    	}
	    	//this condition can be written at the first place!!!
	    	//to improve the efficiency!!!
    	}
    	return closest_node;
    }


144.
	//the recursion method
	time complexity is O(n);
	space complexity is O(n);
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(list, root);
        return list;
    }
    
    private void helper(List<Integer> list, TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        helper(list, root.left);
        helper(list, root.right);
    }

    //the iterative method
    //spend more time for push and pop operations
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while (root != null || !st.isEmpty()) {
            if (root != null) {
                list.add(root.val);
                st.push(root);
                root = root.left;
            }
            else {
                root = st.pop().right;
            }
        }
        return list;
    }


103.
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> st = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        st.offer(root);
        boolean direction = false;
        
        //BFS
        while (!st.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int count = st.size();
            for (int i = 0; i < count; i ++) {
                root = st.poll();
                temp.add(root.val);
                if (root.left != null) st.offer(root.left);
                if (root.right != null) st.offer(root.right);
            }
            if (direction) {
                Collections.reverse(temp);
                //void output
            }
            list.add(temp);
            direction = !direction;
        }
        
        return list;
    }

    //another good method
    //use a level
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	    List<List<Integer>> res = new ArrayList();
	    travel(res, 0, root);
	    return res;
	}
	private void travel(List<List<Integer>> res, int level, TreeNode cur) {
	    if (cur == null) return;
	    if (res.size() <= level) {
	        res.add(new ArrayList<Integer>());
	    }
	    if (level % 2 == 0) {
	        res.get(level).add(cur.val);
	    }   else {
	        res.get(level).add(0, cur.val);
	    }
	    //these two add is the key of this method!!!
	    travel(res, level + 1, cur.left);
	    travel(res, level + 1, cur.right);
	}



145.
	//recursion method
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        helper(list, root);
        return list;
    }
    
    private void helper(List<Integer> list, TreeNode root) {
        if (root == null) return;
        helper(list, root.left);
        helper(list, root.right);
        list.add(root.val);
    }

    //iterative method for post-order
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while (root != null || !st.isEmpty()) {
            if (root != null) {
                list.add(root.val);
                st.push(root);
                root = root.right;
            }
            else {
                root = st.pop().left;
            }
        }
        Collections.reverse(list);
        return list;
    }


255.
	//in-place operation
	//track the subtrees and record the max and min
	public boolean verifyPreorder(int[] preorder) {
        if (preorder.length <= 1) return true;
        return helper(preorder, 0, preorder.length - 1, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    
    private boolean helper(int[] preorder, int left, int right, int max, int min) {
        if (left > preorder.length - 1) return true;
        else if (left == right && preorder[left] < max && preorder[left] > min) return true;
        else if (preorder[left] >= max || preorder[left] <= min) return false;
        else {
            int count = left + 1;
            while (count <= right && preorder[count] < preorder[left]) {
                count ++;
            }
            if (count > right) return helper(preorder, left + 1, right, preorder[left], min);
            else if (count == left + 1) return helper(preorder, left + 1, right, max, preorder[left]);
            else return helper(preorder, left + 1, count - 1, preorder[left], min) && 
                helper(preorder, count, right, max, preorder[left]);
        }
    }


    //another method, using stack
    public boolean verifyPreorder(int[] preorder) {
	    int low = Integer.MIN_VALUE;
	    Stack<Integer> path = new Stack();
	    for (int p : preorder) {
	        if (p < low)
	            return false;
	        while (!path.empty() && p > path.peek())
	            low = path.pop();
	        path.push(p);
	    }
	    return true;
	}

	//another in-place method
	public boolean verifyPreorder(int[] preorder) {
	    int low = Integer.MIN_VALUE, i = -1;
	    for (int p : preorder) {
	        if (p < low)
	            return false;
	        while (i >= 0 && p > preorder[i])
	            low = preorder[i--];
	        preorder[++i] = p;
	    }
	    return true;
	}


220.
    // the tricky part I modified to easily understood way.
    //the key of this method

    //set.floor() *TreeSet
    //Returns the greatest element in this set less than or 
    //equal to the given element, or null if there is no such element.

    //set.ceiling() *TreeSet
    //Returns the least element in this set greater than 
    //or equal to the given element, or null if there is 
    //no such element.

    //They use binary seach in these two methods
    //therefore O(logk)

	//the right version
    class Solution {
	    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
	        if(nums == null || nums.length < 2 || k < 1) return false;
	        
	        TreeSet<Long> set = new TreeSet<>();
	        for (int i = 0; i < nums.length; i ++) {
	            long l = nums[i];
	            
	            if (i > k) {
	                set.remove((long) nums[i - k - 1]);
	            }
	            //remove first, always keep useful number inside
	            
	            Long floor = set.floor(l);
	            //here, use wrapper type, because of the null below
	            Long ceil = set.ceiling(l);
	            
	            if (floor != null && l - floor <= t 
	                || ceil != null && ceil - l <= t) return true;
	            
	            
	            set.add(l);
	        }
	        return false;
	    }
	}


99.
	time complexity is O(n)
	space complexity is O(1)
	class Solution {
	    private TreeNode node1 = null;
	    private TreeNode node2 = null;
	    private TreeNode prev = null;
	    
	    
	    public void recoverTree(TreeNode root) {
	        tranverse(root);
	        
	        int temp = node1.val;
	        node1.val = node2.val;
	        node2.val = temp;
	    }
	    
	    private void tranverse(TreeNode root) {
	        if (root == null) return;
	        tranverse(root.left);
	        
	        if (prev != null && prev.val >= root.val) {
	        	//inorder tranverse
	        	//if BST, the prev.val should be less than root.val
	        	//for prev = root after tranverse all the left
	            if (node1 == null) node1 = prev;
	            node2 = root;
	        }
	        //the important swap, two cases explanation

	        
	        prev = root;
	        
	        tranverse(root.right);
	    }
	}
/*
	Now let us consider the situation
	The previous in-order traverse (the right one) should be:
	X1<X2<X3<...<Xi<...<...<Xj<...<Xn
	Now, Xi and Xj was swapped, so the sequence became:
	X1<X2<X3<...<Xj>...<...>Xi<...<Xn

	So, there exists at most 2 places where disorder happens:

	Xj>Xi+1
	Xj-1>Xi
	However, When Xi is next to Xj,(j=i+1), the disorder is 
	happened only once.

	Xj>Xi
	So, you can see the two IFs (pay attention not IF..ELSE IF!)
	It will record the first greater relation's leftside element 
	and the last greater relation's rightside element!
	This will satisfy both situations.
*/


98.
	//in-order method to validate BST, primiry array
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

	//pass the range to the child nodes
	class Solution {
	    public boolean isValidBST(TreeNode root) {
	        return returnVal(root, Long.MIN_VALUE, Long.MAX_VALUE);
	        //use Long.MAX_VALUE here
	        //need to clarify in the actual test
	    }
	    
	    private boolean returnVal(TreeNode root, long min, long max) {
	        if (root == null) return true;
	        if (root.val < max && root.val > min) {
	            return returnVal(root.left, min, root.val) && returnVal(root.right, root.val, max);
	        } else {
	            return false;
	        }
	    }
	}

	//in-order tranverse, virtual array
	class Solution {
	    public boolean isValidBST(TreeNode root) {
	        boolean[] res = new boolean[]{true};
	        inOrder(root, new long[]{Long.MIN_VALUE}, res);
	        return res[0];
	    }
	    
	    private void inOrder(TreeNode root, long[] record, boolean[] res) {
	        if (root == null || !res[0]) return;
	        inOrder(root.left, record, res);
	        if (record[0] >= root.val) res[0] = false;
	        record[0] = root.val;
	        inOrder(root.right, record, res);
	    }
	}


//6/20
//Q1 L215
	//quick sort: return when you find the kth
	//S2: Quick Selection/QuickSort Partition
	//k - P's index when quick sort
	//if lucky, O(n) = n + n/2 + n/4 + ... + 2 + 1
	//if unlucky, O(n^2) = n + n-1 + n-2 + ... + 1
	time complexity is between O(n) and O(n^2)

	//when talk about heap, say its size and comparator
	//Q1 S3 && S4
	//MinHeap (n size) && MaxHeap (k size)
	//streaming or very large, MaxHeap is better

	
//Q1.2 top k frequency words
	//S1: HashMap + PriorityQueue 
	//(comparator, ele1.fre - ele2.fre, 1 2 minheap, 
	// - ele1.fre + ele2.fre, maxheap 2 1) 

	//S2: TreeMap

	//S3: If too large, memory cannot put them all
	//Distributed System Memory

	//S4: Big Data, Map Reduce --- System, need further looking

	//common sense about I/O:
	//Memory:		100G(cun cu)	10G/s(tun tu / mainly write)
	//SSD:			500G~1T			500MB/s
	//HardDisk:		5TB				50MB/s
	//Internet:		---				1Gbit/s = 125MB/s	


//difference about HashMap/Hash Table/HashSet
//HashMap && Hash Table: 
	//HashMap xianchenganquan, Hash Table, not, else the same;
//HashMap && HashSet:
	//HashMap contains key-value pair, can access value in O(1);
	//HashSet contains only key, to check if repeat or not


//HashSet
	//add(key) return boolean, 
		//if success, true, 
		//if not(has repeat), false

//HashSet --- de duplicate --- contains(), add(), remove()
//HashMap --- de duplicate & counter --- containsKey(), get(), put(), remove()
//HashMap, key is what and value is what	

//<key, reference of object>
//object as key, save the reference as key
//when compare, dereference first
	//map.get(key) += 1 cannot change value
	//map.get(key).age += 1 can, change the field

//expiredMap()
	//put(key, value) value has expiredTime
	//<key, (String, expiredTime)>, check expiredTime 
	//return null or String

//1:51:26 Lesson 8


4.
	//a lot of cases to discuss
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		//two important notice
		//1. about k, k is the number, not the index
		//2. about the median, (length - 1) / 2 is the index of the mediean(the first number in even number array)
        int k = (nums1.length + nums2.length + 1) / 2;
        double number1 = helper(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1, k);
        if ((nums1.length + nums2.length) % 2 == 1) return number1;
        double number2 = helper(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1, k + 1);
        return (number1 + number2) / 2;
        //the center of this method is to, cut some numbers after a comparation
        //k is also useful during finding the median
    }
    
    private double helper(int[] a, int[] b, int aleft, int aright, int bleft, int bright, int k) {
        if (aleft > aright) return (double) b[bleft + k - 1];
        if (bleft > bright) return (double) a[aleft + k - 1];
        
        int amid = aleft + (aright - aleft) / 2;
        int bmid = bleft + (bright - bleft) / 2;
        int temp = amid - aleft + bmid - bleft + 1;
        //temp, which is the number now sure that is smaller than the larger mid
        
        if (a[amid] > b[bmid] && k > temp) {
            return helper(a, b, aleft, aright, bmid + 1, bright, k - (bmid - bleft + 1));
        }
        //when amid > bmid and k > temp, k cannot be found before bmid (including bmid itself)
        else if (a[amid] > b[bmid]) {
            return helper(a, b, aleft, amid - 1, bleft, bright, k);
        }
        else if (k > temp) {
            return helper(a, b, amid + 1, aright, bleft, bright, k - (amid - aleft + 1));
        }
        else {
            return helper(a, b, aleft, aright, bleft, bmid - 1, k);
        }
    }


222.
	class Solution {
	    public int countNodes(TreeNode root) {
	        if (root == null) return 0;
	        if (root.left == null) return 1;
	        int height = 0, nodesum = 0;
	        TreeNode curr = root;
	        while (curr.left != null) {
	            nodesum += (1 << height);
	            //use << to calculate the power 2
	            //1<<16 == 2^16
	            height ++;
	            curr = curr.left;
	        }
	        return nodesum + helper(root, height);
	    }
	    
	    //Key to success, use binary search to find the mid at the bottom
	    //first root.left, then all .right to the last bottom, find the mid or
	    //first root.right, then all .left to the last bottom
	    //but its a complete BST, the first way is better
	    private int helper(TreeNode root, int height) {
	        //height here is the level number except the last level
	        if (height == 1 && root.right != null) return 2;
	        else if (height == 1 && root.left != null) return 1;
	        else if (height == 1) return 0;
	        
	        TreeNode curr = root.left;
	        int counter = 1;
	        while (counter < height) {
	            curr = curr.right;
	            counter ++;
	        }
	        if (curr == null) return helper(root.left, height - 1);
	        else return (1<<(height-1)) + helper(root.right, height - 1);
	        //+, - is calculated before <<, >>
	    }
	}


20.
	time complexity is O(k);
	space complexity is O(1);
	//in-order traverse and count the node number
	class Solution {
	    private int counter = 0;
	    private int res;
	    
	    public int kthSmallest(TreeNode root, int k) {
	        helper(root, k);
	        return res;       
	    }
	    
	    private void helper(TreeNode root, int k) {
	        if (root == null) return;
	        if (counter > k) return;
	        helper(root.left, k);
	        
	        counter ++;
	        if (counter == k) res = root.val;
	        
	        helper(root.right, k);
	    }
	}


378.
	time complexity is O(n^2logk)
	space complexity is O(k)
	public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, ((Integer a, Integer b) -> - a.compareTo(b)));
        
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < k - i && j < matrix[0].length; j ++) {
                if (pq.size() < k) pq.offer(matrix[i][j]);
                else if (pq.peek() > matrix[i][j]) {
                    pq.poll();
                    pq.offer(matrix[i][j]);
                }
            }
        }
        
        return pq.peek();
    }


    //second method, poll one and offer two, BFS
    time complexity is O(klogk)
    space complexity is O(k)
    class Solution {
	    public int kthSmallest(int[][] matrix, int k) {
	        PriorityQueue<MatrixElement> pq = new PriorityQueue<>(k, new Comparator<MatrixElement>(){
	            @Override
	            public int compare(MatrixElement a, MatrixElement b) {
	                return a.val - b.val;
	            }
	        });
	        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
	        
	        pq.offer(new MatrixElement(0,0,matrix));
	        visited[0][0] = true;
	        for (int i = 1; i < k; i ++) {
	            MatrixElement tmp = pq.poll(), tmpR, tmpD;
	            if (tmp.col + 1 < matrix[0].length && !visited[tmp.row][tmp.col + 1]) {
	                tmpR = new MatrixElement(tmp.row, tmp.col + 1, matrix);
	                visited[tmpR.row][tmpR.col] = true;
	                pq.offer(tmpR);
	            } 
	            if (tmp.row + 1 < matrix.length && !visited[tmp.row + 1][tmp.col]) {
	                tmpD = new MatrixElement(tmp.row + 1, tmp.col, matrix);
	                visited[tmpD.row][tmpD.col] = true;
	                pq.offer(tmpD);
	            }
	        }
	        
	        return pq.poll().val;
	    }
	    
	    //inner class, can be declared as private
	    class MatrixElement {
	        int row;
	        int col;
	        int val;
	        public MatrixElement(int a, int b, int[][] matrix){
	            row = a;
	            col = b;
	            val = matrix[a][b];
	        }
	    }
	}


174.
	public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length + 1][dugeon[0].length + 1];
        int rows = dungeon.length, cols = dugeon[0].length;
        for (int i = 0; i < rows; i ++) {
            dp[i][cols] = Integer.MAX_VALUE;
        }
        for (int j = 0; j < cols; j ++) {
            dp[rows][j] = Integer.MAX_VALUE;
        }
        
        dp[rows - 1][cols] = 0;
        dp[rows][cols - 1] = 0;
        
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j --) {
                dp[i][j] = Math.max(0, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
            }
        }
        
        return dp[0][0] + 1;
    }


//6/24
    public List<Integer> findCommon(int[] m, int[] n){
    	Set<Integer> s = new HashSet<>();
    	List<Integer> list = new ArrayList<>();
    	if (m.length == 0 || n.length == 0) return list;
    	if (m.length < n.length) return findCommon(n, m);
    	//Key!!!
    	if (m.length < n.length) {
    		for (int each : m) s.add(each);
    		for (int each : n) {
    			if (s.contains(each)) list.add(each);
    		}
    	}
    	else {
    		for (int each : n) s.add(each);
    		for (int each : m) {
    			//how to get rid of the duplicate?
    			//for (int i ...)
    			//if (i > 0 && n[i] == n[i - 1]) continue;
    			if (s.contains(each)) list.add(each);
    			//another way
    			//new ArrayList<Integer>(resSet);
    		}
    	}

    	return list;
    }

    //how to make m the longer one and n the shorter one?


//6/25
    //Design a stack using LinkedList
    //single LinkedList Or double LinkedList?
    //have head and tail or only head?
    //push(); pop(); peek();
    class MyStack<T> {
    	//fields
    	private int count;
    	private ListNode<T> head;

    	//methods
    	public MyStack(){
    		count = 0;
    	}

    	public void offer(T element){
    		if (count == 0) head = new ListNode<T>(element);
    		else {
    			ListNode<T> temp = new ListNode<T>(element);
    			temp.next = head;
    			head = temp;
    		}
    		count ++;
    		//if head == null at first initialize
    		//can delete multilines of codes
    	}

    	public T peek(){
    		if (isEmpty()) return null;
    		//general type accept value as null or not?
    		//in this case, we should throw an exception
    		return head.val;
    	}

    	public T pop(){ //throws Exceptions
    		//null pointer exception
    		if (isEmpty()) return null;
    		//return new Exception();
    		//maybe should give a specify type
    		T temp = head.val;
    		head = head.next;
    		count --;
    		return temp;
    	}

    	private boolean isEmpty(){
    		return count == 0;
    	}

    }

    //Design Queue using LinkedList
    //sinlge LinkedList Or Double LinkedList?
    //double, about the prev
    //head and tail pointers or head pointer?
    class MyQueue<T>{
    	//fields
    	private int count;
    	private ListNode<T> head;
    	private ListNode<T> tail;

    	//methods
    	public MyQueue(){
    		count = 0;
    		head = null;
    		tail = null;
    	}

    	public void offer(T element){
    		ListNode<T> newNode = new ListNode<>(element);
    		if (count == 0) {
    			head = newNode;
    			tail = newNode;
    		}
    		else {
    			tail.next = newNode;
    			newNode.prev = tail;
    			tail = tail.next;
    		}
    		count ++;
    	}

    	public T poll(){
    		if (count == 0) return null;
    		//if more than 0
    		ListNode<T> temp = head;
    		head = head.next;
    		head.prev = null;
    		if (count == 1) tail = null;
    		//if there is only one node
    		count --;
    		return temp.val;
    	}

    	public T peek(){
    		return (count == 0) ? null : head.val;
    	}

    	public int size(){
    		return count;
    	}
    }
    //corner cases summary:
    //no node, one node two cases

    //Design a Queue using Array with certain Capacity
    //left contains and right does not contain
    //FIFO!!! Circular Array!!!
    //empty or full? size using as flag
    class MyQueue<E>{
    	//fields
    	private int head;
    	private int tail;
    	private E[] arr;
    	private int count;

    	//methods
    	public MyQueue(int capacity){
    		head = 0;
    		tail = 0;
    		arr = new E[capacity];
    		count ++;
    	}

    	//return boolean to see if you can add or not
    	//with no adding capacity
    	public boolean offer(E element){
    		if (count == arr.length) return false;
    		arr[tail] = element;
    		tail = (tail + 1) % arr.length;
    		count ++;
    		return true;
    	}

    	public E poll(){
    		if (count == 0) return null;
    		E temp = arr[head];
    		head = (head + 1) % arr.length;
    		count --;
    		return temp;
    	}

    	public E peek(){
    		return (count == 0) ? null : arr[head];
    		//do not forget peek of no element case
    	}

    }


    //Design Stack using Array
    //use [0, head)
    class MyStack<E>{
    	//fields
    	private int tail;
    	private int count;
    	private E[] arr;

    	//methods
    	public MyStack(int capacity){
    		tail = 0;
    		count = 0;
    		arr = new E[capacity];
    	}

    	public boolean push(E element){
    		if (count >= arr.length) return false;
    		arr[head] = element;
    		head ++;
    		//or arr[head ++] = element
    		//first give element, then increase head
    		count ++;
    		return true;
    	}
    	//expand the capacity, using one array function

    	public E pop(){
    		if (count == 0) return null;
    		head --;
    		count --;
    		return arr[head];
    	}

    	public E peek(){
    		if (count == 0) return null;
    		return arr[head - 1];
    		//return arr[-- head];
    	}
    }


    //Design Stack/Queue/Deque using 
    //Array/LinkedList/ArrayList


//BFS & Dijkstra & DFS(backtracking)
//after here

146.
	//use the class LinkedHashMap
	import java.util.LinkedHashMap;
	class LRUCache {
	    
	    private Map<Integer, Integer> myMap;
	    //can be implemented by LinkedHashMap

	    public LRUCache(int capacity) {
	        myMap = new LinkedHashMap<Integer, Integer>((int)//why must <Integer,> 
	        	(capacity / 0.75 + 1), 0.75f, true){
	            protected boolean removeEldestEntry(Map.Entry eldest){
	                return size() > capacity;
	            }
	            //override the removeEldestEntry method
	        };
	        //constructor:LinkedHashMap<K, V>()
	        //capacity: pay attention to 0.75 factor
	        //load factor: pay attention to f here
	        //true for access order, false for add order
	    }
	    
	    public int get(int key) {
	        return myMap.getOrDefault(key, -1);
	    }
	    
	    public void put(int key, int value) {
	        myMap.put(key, value);
	    }
	}    

	//another method using double LinkedList and HashMap
	class LRUCache {
    
	    private Map<Integer, DoubleListNode> myMap;
	    //use the HashMap as the index of the LinkedList
	    //map value is the ListNode
	    private DoubleListNode head;
	    private DoubleListNode tail;
	    //head and tail pointer, for the double LinkedList
	    private int capa;

	    public LRUCache(int capacity) {
	        myMap = new HashMap<>((int) (capacity / 0.75) + 1);
	        head = null;
	        tail = null;
	        capa = capacity;
	    }
	    
	    public int get(int key) {
	        if (!myMap.containsKey(key)) return -1;
	        DoubleListNode temp = myMap.get(key), prevNode = temp.prev, nextNode = temp.next;
	        //prevNode == null, head is itself, tail is itself
	        if (head == temp) return head.val;
	        //head is itself that is prevNode == null
	        else if (tail == temp) {
	            tail = temp.prev;
	            temp.prev = null;
	            addHead(temp);
	        }
	        else {
	            prevNode.next = nextNode;
	            nextNode.prev = prevNode;
	            temp.prev = null;
	            addHead(temp);
	        }
	        //multiple cases
	        //actually if stay focus and pay attention, can solve such question
	        //do not just try to get the answer, that will cost more time
	        //prev == null(at head), next == null(at tail), or only one node
	        return head.val;
	    }
	    
	    public void put(int key, int value) {
	        if (myMap.containsKey(key)) {
	            myMap.get(key).val = value;
	            get(key);
	        }
	        //access, put is one kind of access
	        else if (head == null) {
	            head = new DoubleListNode(value, key);
	            tail = head;
	            myMap.put(key, head);
	        }
	        else {
	            DoubleListNode temp = new DoubleListNode(value, key);
	            addHead(temp);
	            if (myMap.size() >= capa) {
	                tail = tail.prev;
	                myMap.remove(tail.next.key);
	                tail.next = null;
	            }
	            myMap.put(key, temp);
	        }
	    }
	    //tare a lot of method apart to get clearer structure!!!
	    
	    private void addHead(DoubleListNode element) {
	        element.next = head;
	        head.prev = element;
	        head = element;
	    }
	    
	    private class DoubleListNode{
	        int key;
	        //here, remeber the key, for the remove of the map
	        int val;
	        DoubleListNode prev;
	        DoubleListNode next;
	        //double LinkedList, do not forget the prev pointer
	        public DoubleListNode(int val, int key){
	            this(val, key, null, null);
	            //overload the constructor
	        }
	        public DoubleListNode(int val, int key, DoubleListNode prev, DoubleListNode next){
	            this.val = val;
	            this.key = key;
	            this.prev = prev;
	            this.next = next;
	        }
	    }
	    //set a private class, for this question
	}

	//another example
	public class LRUCache {
	    private class Node{
	        int key, value;
	        Node prev, next;
	        Node(int k, int v){
	            this.key = k;
	            this.value = v;
	        }
	        Node(){
	            this(0, 0);
	        }
	    }
	    private int capacity, count;
	    private Map<Integer, Node> map;
	    private Node head, tail;
	    
	    public LRUCache(int capacity) {
	        this.capacity = capacity;
	        this.count = 0;
	        map = new HashMap<>();
	        head = new Node();
	        tail = new Node();
	        head.next = tail;
	        tail.prev = head;
	    }
	    
	    public int get(int key) {
	        Node n = map.get(key);
	        if(null==n){
	            return -1;
	        }
	        update(n);
	        return n.value;
	    }
	    
	    public void set(int key, int value) {
	        Node n = map.get(key);
	        if(null==n){
	            n = new Node(key, value);
	            map.put(key, n);
	            add(n);
	            ++count;
	        }
	        else{
	            n.value = value;
	            update(n);
	        }
	        if(count>capacity){
	            Node toDel = tail.prev;
	            remove(toDel);
	            map.remove(toDel.key);
	            --count;
	        }
	    }
	    
	    private void update(Node node){
	        remove(node);
	        add(node);
	    }
	    private void add(Node node){
	        Node after = head.next;
	        head.next = node;
	        node.prev = head;
	        node.next = after;
	        after.prev = node;
	    }
	    
	    private void remove(Node node){
	        Node before = node.prev, after = node.next;
	        before.next = after;
	        after.prev = before;
	    }
	}


359.
	//quite easy one
	class Logger {

	    private Map<String, Integer> myMap;
	    /** Initialize your data structure here. */
	    public Logger() {
	        myMap = new HashMap<>();
	    }
	    
	    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
	        If this method returns false, the message will not be printed.
	        The timestamp is in seconds granularity. */
	    public boolean shouldPrintMessage(int timestamp, String message) {
	        if (!myMap.containsKey(message) || myMap.get(message) <= timestamp - 10) {
	            myMap.put(message, timestamp);
	            return true;
	        }
	        else {
	            return false;
	        }
	    }
	}


//6/26
362.
	class HitCounter {
	    
	    private int[] counter;
	    private int[] time;

	    /** Initialize your data structure here. */
	    public HitCounter() {
	        counter = new int[300];
	        time = new int[300];
	    }
	    
	    /** Record a hit.
	        @param timestamp - The current timestamp (in seconds granularity). */
	    public void hit(int timestamp) {
	        int pointer = timestamp % 300;
	        if (time[pointer] == timestamp) {
	            counter[pointer] ++;
	        }
	        else {
	            counter[pointer] = 1;
	            time[pointer] = timestamp;
	        }
	        
	    }
	    
	    /** Return the number of hits in the past 5 minutes.
	        @param timestamp - The current timestamp (in seconds granularity). */
	    public int getHits(int timestamp) {
	        int total = 0;
	        for (int i = 0; i < 300; i ++) {
	            if (timestamp - time[i] < 300 ) total += counter[i];
	        }
	        return total;
	    }
	}
	//use another array to store multiple useful information


//binary tree level order traversal
	//BFS
	//method 1: using one queue and size()
	public List<Integer> bfsTranverse(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) return list;
		Queue<TreeNode> qu = new LinkedList<>();
		qu.offer(root);
		int counter;
		while (!qu.isEmpty()) {
			coutner = qu.size();
			for (int i = 0; i < counter; i ++) {
			//cannot use qu.size() here
			//if use qu.size(), it will change continually
				root = qu.poll();
				list.add(root.val);
				if (root.left != null) qu.offer(root.left);
				if (root.right != null) qu.offer(root.right);
			}
			//size() and for loop to give the level info
		}
		return list;
	}


	//method 2: using two queues
	public List<Integer> bfsTranverse(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) return list;
		Queue<TreeNode> qu1 = new LinkedList<>();
		Queue<TreeNode> qu2 = new LinkedList<>();
		qu1.offer(root);
		while (!qu1.isEmpty() || !qu2.isEmpty()) {
			if (!qu1.isEmpty()) {
				root = qu1.poll();
				list.add(root.val);
				if (root.left != null) qu2.offer(root.left);
				if (root.right != null) qu2.offer(root.right);
			}
			else {
				root = qu2.poll();
				list.add(root.val);
				if (root.left != null) qu1.offer(root.left);
				if (root.right != null) qu1.offer(root.right);
			}
		}
		return list;
	}



//6/28
56.
	time complexity is O(nlong)
	space complexity is O(n)
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


48.	
	//rotate
	//use recursion
	//and for loop, one loop for one side, use a array for rotating four sides at onde
	time complexity is O(n^2)
	space complexity is O(4)
	public void rotate(int[][] matrix) {
        helper(matrix, 0);
    }
    
    private void helper(int[][] matrix, int index) {
        
        
        int startrow = index, startcol = index, endrow = matrix.length - 1 - index, endcol = matrix.length - 1 - index;
        //int[] temp = new int[matrix.length - 2 * index];
        if (endrow <= startrow) return;
        
        for (int i = 0; i < endrow - startrow; i ++) {
            int[] temp = new int[]{matrix[startrow][startcol + i], matrix[startrow + i][endcol],
                                  matrix[endrow][endcol - i], matrix[endrow - i][startcol]};
            matrix[startrow][startcol + i] = temp[3];
            matrix[startrow + i][endcol] = temp[0];
            matrix[endrow][endcol - i] = temp[1];
            matrix[endrow - i][startcol] = temp[2];            
        }
        
        helper(matrix, index + 1);
    }

    /*
	 * clockwise rotate
	 * first reverse up to down, then swap the symmetry 
	 * 1 2 3     7 8 9     7 4 1
	 * 4 5 6  => 4 5 6  => 8 5 2
	 * 7 8 9     1 2 3     9 6 3
	*/

    /*
	 * anticlockwise rotate
	 * first reverse left to right, then swap the symmetry
	 * 1 2 3     3 2 1     3 6 9
	 * 4 5 6  => 6 5 4  => 2 5 8
	 * 7 8 9     9 8 7     1 4 7
	*/
    public class Solution {
	    public void rotate(int[][] matrix) {
	        for(int i = 0; i<matrix.length; i++){
	            for(int j = i; j<matrix[0].length; j++){
	                int temp = 0;
	                temp = matrix[i][j];
	                matrix[i][j] = matrix[j][i];
	                matrix[j][i] = temp;
	            }
	        }
	        for(int i =0 ; i<matrix.length; i++){
	            for(int j = 0; j<matrix.length/2; j++){
	                int temp = 0;
	                temp = matrix[i][j];
	                matrix[i][j] = matrix[i][matrix.length-1-j];
	                matrix[i][matrix.length-1-j] = temp;
	            }
	        }
	    }
	}


41.
	time complexity is O(n)
	space complexity is O(1)
	//the key is using index + 1 to record
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
    //using sign, positive or negative!
    //using index and value relation, swap way!


128.
	time complexity is O(n)
	space complexity is O(n)
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
    //cannot use stringbuilder to record, for negative number or number larger than 10
    //will have 2 or more length instead of 1, use array to record instead

    //use the return value of the set API
    //what else can I say, 666666!!!
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


289.
	time complexity is O(mn)
	space complexity is O(1)
	//the trick is to remmember the value, by adding different value if die or live next round
	class Solution {
	    private int[][] recent = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
	    
	    public void gameOfLife(int[][] board) {
	        if (board.length == 0 || board[0].length == 0) return;
	        
	        for (int i = 0; i < board.length; i ++) {
	            for (int j = 0; j < board[0].length; j ++){
	                int positive = 0, negative = 0;
	                for (int[] each : recent) {
	                    int newi = i + each[0];
	                    int newj = j + each[1];
	                    if (newi < 0 || newi >= board.length || newj < 0 || newj >= board[0].length) continue;
	                    if (board[newi][newj] == 1 || board[newi][newj] == 5 || board[newi][newj] == 3) {positive ++;}
	                    else {negative ++;}
	                }
	                if (board[i][j] == 1 && (positive < 2 || positive > 3)) {
	                    board[i][j] += 2;
	                }
	                else if (board[i][j] == 1 || board[i][j] == 0 && positive == 3) {
	                    board[i][j] += 4;
	                }
	                else  {
	                    board[i][j] += 2;
	                }
	            }
	        }
	        
	        for (int i = 0; i < board.length; i ++) {
	            for (int j = 0; j < board[0].length; j ++){
	                if (board[i][j] == 2 || board[i][j] == 3) board[i][j] = 0;
	                else board[i][j] = 1;
	            }
	        }
	    }
	}

	//one similar idea
	//it says if die next step, turn to 2, or 3
	public class Solution {
	int[][] dir ={{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
	public void gameOfLife(int[][] board) {
	    for(int i=0;i<board.length;i++){
	        for(int j=0;j<board[0].length;j++){
	            int live=0;
	            for(int[] d:dir){
	                if(d[0]+i<0 || d[0]+i>=board.length || d[1]+j<0 || d[1]+j>=board[0].length) continue;
	                if(board[d[0]+i][d[1]+j]==1 || board[d[0]+i][d[1]+j]==2) live++;
	            }
	            if(board[i][j]==0 && live==3) board[i][j]=3;
	            if(board[i][j]==1 && (live<2 || live>3)) board[i][j]=2;
	        }
	    }
	    for(int i=0;i<board.length;i++){
	        for(int j=0;j<board[0].length;j++){
	            board[i][j] %=2;
	            //the beauty of the 2 and 3 next step is here!!!
	        }
	    }
	}

	//follow up: infinite board question, do not understand why???



120.
	//can you believe that, using dp to solve this question!!!
	time complexity is O(n^2)
	space complexity is O(n^2)
	public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] dp = new int[len][len];
        
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < len; i ++) {
            for (int j = 0; j < triangle.get(i).size(); j ++) {
                int temp = 0;
                if (j - 1 >= 0 && j <= i - 1) {
                    temp = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                }
                else if (j - 1 >= 0) temp = dp[i - 1][j - 1];
                else temp = dp[i - 1][j];
                dp[i][j] = triangle.get(i).get(j) + temp;
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < len; j ++) {
            res = Math.min(res, dp[dp.length - 1][j]);
        }        
        return res;
    }

    //how to do it with O(n) extra space?
    time complexity is O(n^2)
	space complexity is O(n)
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] dp = new int[len];
        
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < len; i ++) {
            for (int j = triangle.get(i).size() - 1; j >= 0; j --) {
            	//put all the results in one array
            	//read all results, find the min
                int temp = 0;
                if (j - 1 >= 0 && j <= i - 1) {
                    temp = Math.min(dp[j - 1], dp[j]);
                }
                else if (j - 1 >= 0) temp = dp[j - 1];
                else temp = dp[j];
                dp[j] = triangle.get(i).get(j) + temp;
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < len; j ++) {
            res = Math.min(res, dp[j]);
        }        
        return res;
    }


280.
	//the key is to see
	//number at position 0 and 2 are unrelated
	//so they just can be any number lower than position 1
	time complexity is O(n)
	space complexity is O(1)
	public void wiggleSort(int[] nums) {
        if (nums.length <= 1) return;
        
        for (int i = 0; i < nums.length && i + 1 < nums.length; i += 2) {
        	//corner case has been included
            if (nums[i] > nums[i + 1]) swap(i, i + 1, nums);
        }
        
        for (int i = 1; i < nums.length && i + 1 < nums.length; i += 2) {
            if (nums[i] < nums[i + 1]) swap(i, i + 1, nums);
        }
    }
    
    private void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


670.
	//can you believe that, the result is somekind of good!
	time complexity is O(n + nlogn + n);
	space complexity is O(n)
	public int maximumSwap(int num) {
        char[] origin = (num + "").toCharArray();
        char[] arr = (num + "").toCharArray();
        Arrays.sort(arr);
        //ATTENTION!!!
        //cannot easily write comparator here
        //for calculation, compareTo, compare, they are convert to Character class
        int index = 0;
        while (index < arr.length && origin[index] == arr[arr.length - 1 - index]) {
            index ++;
        }
        if (index == arr.length) return num;
        
        int right = arr.length - 1;
        while (arr[arr.length - 1 - index] != origin[right]) {
            right --;
        }
        origin[right] = origin[index];
        origin[index] = arr[arr.length - 1 - index];
        
        StringBuilder sb = new StringBuilder();
        sb.append(origin);
        return Integer.parseInt(sb.toString());
    }

    /*
    The right way!
    char[] charArray = str.toCharArray();

    Character[] myCharArr = ArrayUtils.toObject(charArray);

    Arrays.sort(myCharArr, new Comparator<Character>() {
        @Override
        public int compare(Character char1, Character char2) {
            return char2.compareTo(char1);
        }
    });
    */


    //another method
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        //char[] array convert!
        
        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) {
            buckets[digits[i] - '0'] = i;
        }
        
        for (int i = 0; i < digits.length; i++) {
            for (int k = 9; k > digits[i] - '0'; k--) {
                if (buckets[k] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        
        return num;
    }


57.	
	time complexity is O(n)
	space complexity is O(n)
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        if (intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        
        int i = 0;
        boolean added = false;
        while (i < intervals.size()) {
            if (intervals.get(i).end < newInterval.start || intervals.get(i).start > newInterval.end && added) {
                res.add(intervals.get(i));
            }
            else if (intervals.get(i).start > newInterval.end && !added) {
                res.add(newInterval);
                res.add(intervals.get(i));
                added = true;
            }
            else {
                newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
                newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            }
            i ++;
        }
        if (!added) res.add(newInterval);
        
        return res;    
    }	

    //another way, use the order property
    //use binary search to find the start and the end
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	    List<Interval> result = new ArrayList<>();
	    if (intervals == null || newInterval == null) return result;
	    int iStart = findStartPos(intervals, newInterval.start);
	    int iEnd = findEndPos(intervals, newInterval.end);
	    if (iStart > 0 && intervals.get(iStart - 1).end >= newInterval.start) iStart--;
	    if (iEnd == intervals.size() || intervals.get(iEnd).start > newInterval.end) iEnd--;
	    
	    //If not in the corner cases, this condition should apply.
	    if (iStart <= iEnd) {
	        newInterval = new Interval(Math.min(newInterval.start, intervals.get(iStart).start),
	        	Math.max(newInterval.end, intervals.get(iEnd).end));
	    }

	    int i = 0;
	    while (i < iStart) result.add(intervals.get(i++));
	    result.add(newInterval);
	    i = iEnd + 1;
	    while (i < intervals.size()) result.add(intervals.get(i++));
	    return result;
	}

	private int findStartPos(List<Interval> intervals, int value) {
	    int l = 0, r = intervals.size() - 1;
	    while (l <= r) {
	        int m = (l + r) >> 1;
	        if (intervals.get(m).start == value) return m;
	        else if (intervals.get(m).start < value) l = m + 1;
	        else r = m - 1;
	    }
	    return l;
	}

	private int findEndPos(List<Interval> intervals, int value) {
	    int l = 0, r = intervals.size() - 1;
	    while (l <= r) {
	        int m = (l + r) >> 1;
	        if (intervals.get(m).end == value) return m;
	        else if (intervals.get(m).end < value) l = m + 1;
	        else r = m - 1;
	    }
	    return l;
	}


//7/2
75.
	time complexity is O(n)
	space complexity is O(1)
	//two pass algorithm
	public void sortColors(int[] nums) {
        int[] colors = new int[3];
        for (int each : nums){
            colors[each] ++;
        }
        int index = 0;
        for (int i = 0; i < 3; i ++) {
            while (colors[i] > 0) {
                nums[index ++] = i;
                colors[i] --;
            }
        }
    }


    //one pass solution
    //use the property of three different numbers
    //swap the beginning to be 0
    //swap the end to be 2
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, pointer = 0;
        while(pointer <= right) {
            if (nums[pointer] == 0) {
                nums[pointer] = nums[left];
                nums[left ++] = 0;
            }
            else if (nums[pointer] == 2) {
                nums[pointer --] = nums[right];
                //pay attention here, you have to check what 
                //the end has given you, make sure
                //that is not 0, or swap it to the beginning
                nums[right --] = 2;
            }
            pointer ++;
        }
    }


126.
	//my way of solving this problem
	//time exceed!
	//transform the list to the graph, use BFS to solve it
	class Solution {
	    private int[] record = new int[]{Integer.MAX_VALUE};
	    
	    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
	        if (wordList.indexOf(endWord) == -1) return new ArrayList<List<String>>();
	        
	        List<WordNode> list = new ArrayList<>();
	        for (String each : wordList) {list.add(new WordNode(each));}
	        
	        WordNode head = new WordNode(beginWord);
	        for (WordNode each : list) {
	            int temp = 0;
	            for (int i = 0; i < beginWord.length(); i ++) {
	                if (beginWord.charAt(i) != each.word.charAt(i)) temp ++;
	                if (temp >= 2) break;
	            }
	            if (temp == 1) {
	                head.neighbors.add(each);
	                each.neighbors.add(head);
	            }
	        }
	        
	        for (int i = 0; i < list.size() - 1; i ++) {
	            for (int j = i + 1; j < list.size(); j ++) {
	                if (list.get(i).word.equals(list.get(j).word)) continue;
	                int temp = 0;
	                for (int k = 0; k < list.get(i).word.length(); k ++) {
	                    if (list.get(i).word.charAt(k) != list.get(j).word.charAt(k)) temp ++;
	                    if (temp >= 2) break;
	                }
	                if (temp == 1) {
	                    list.get(i).neighbors.add(list.get(j));
	                    list.get(j).neighbors.add(list.get(i));
	                }
	            }
	        }
	        
	        Set<List<String>> res = new HashSet<List<String>>();
	        List<String> eachList = new ArrayList<>();
	        helper(head, res, eachList, endWord);
	        
	        List<List<String>> finalres = new ArrayList<List<String>>();
	        
	        for (List<String> each : res) {
	            if (each.size() == record[0]) finalres.add(each);
	            //cannot remove element of set here directly
	            //cause exception
	        }
	        
	        return finalres;
	        
	    }
	    
	    private void helper(WordNode head, Set<List<String>> res, List<String> eachList, String endWord) {
	        if (eachList.size() >= record[0] || head.visited) return;
	        int len = eachList.size();
	        head.visited = true;
	        if (head.word.equals(endWord)) {
	            record[0] = len + 1;
	            eachList.add(endWord);
	            res.add(new ArrayList<>(eachList));
	        }
	        else {
	            eachList.add(head.word);
	            for (WordNode element : head.neighbors) {
	                helper(element, res, eachList, endWord);
	            }
	        }
	        eachList.remove(len);
	        head.visited = false;
	    }
	    
	    
	    private class WordNode {
	        String word;
	        ArrayList<WordNode> neighbors;
	        boolean visited;
	        public WordNode(String givenWord) {
	            word = givenWord;
	            neighbors = new ArrayList<>();
	            visited = false;
	        }
	    }
	}


	//another method, basically same idea, but he use the BFS instead of using a graph
	//to set up the connection
	public List<List<String>> findLadders(String start, String end, List<String> wordList) {
	   HashSet<String> dict = new HashSet<String>(wordList);
	   List<List<String>> res = new ArrayList<List<String>>();         
	   HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<String, ArrayList<String>>();// Neighbors for every node
	   HashMap<String, Integer> distance = new HashMap<String, Integer>();// Distance of every node from the start node
	   ArrayList<String> solution = new ArrayList<String>();

	   dict.add(start);          
	   bfs(start, end, dict, nodeNeighbors, distance);                 
	   dfs(start, end, dict, nodeNeighbors, distance, solution, res);   
	   return res;
	}

	// BFS: Trace every node's distance from the start node (level by level).
	private void bfs(String start, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance) {
	  for (String str : dict)
	      nodeNeighbors.put(str, new ArrayList<String>());

	  Queue<String> queue = new LinkedList<String>();
	  queue.offer(start);
	  distance.put(start, 0);

	  while (!queue.isEmpty()) {
	      int count = queue.size();
	      boolean foundEnd = false;
	      for (int i = 0; i < count; i++) {
	          String cur = queue.poll();
	          int curDistance = distance.get(cur);                
	          ArrayList<String> neighbors = getNeighbors(cur, dict);

	          for (String neighbor : neighbors) {
	              nodeNeighbors.get(cur).add(neighbor);
	              if (!distance.containsKey(neighbor)) {// Check if visited
	                  distance.put(neighbor, curDistance + 1);
	                  if (end.equals(neighbor))// Found the shortest path
	                      foundEnd = true;
	                  else
	                      queue.offer(neighbor);
	                  }
	              }
	          }

	          if (foundEnd)
	              break;
	      }
	  }

	// Find all next level nodes.    
	private ArrayList<String> getNeighbors(String node, Set<String> dict) {
	  ArrayList<String> res = new ArrayList<String>();
	  char chs[] = node.toCharArray();

	  for (char ch ='a'; ch <= 'z'; ch++) {
	      for (int i = 0; i < chs.length; i++) {
	          if (chs[i] == ch) continue;
	          char old_ch = chs[i];
	          chs[i] = ch;
	          if (dict.contains(String.valueOf(chs))) {
	              res.add(String.valueOf(chs));
	          }
	          chs[i] = old_ch;
	      }

	  }
	  return res;
	}

	// DFS: output all paths with the shortest distance.
	private void dfs(String cur, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
	    solution.add(cur);
	    if (end.equals(cur)) {
	       res.add(new ArrayList<String>(solution));
	    } else {
	       for (String next : nodeNeighbors.get(cur)) {            
	            if (distance.get(next) == distance.get(cur) + 1) {
	                 dfs(next, end, dict, nodeNeighbors, distance, solution, res);
	            }
	        }
	    }           
	   solution.remove(solution.size() - 1);
	}


277.
	//two pointers solution
	time complexity is O(n)
	space complexity is O(1)
	public int findCelebrity(int n) {
        int persona = 0, personb = n - 1;
        while (persona < personb) {
            boolean resultAB = knows(persona, personb);
            boolean resultBA = knows(personb, persona);
            if (resultAB && resultBA || !resultAB && !resultBA) {
                persona ++;
                personb --;
            }
            else if (resultAB) {
                persona ++;
            }
            else {
                personb --;
            }
            //try to cut the bad options
            //if there is one celebrity betwween persona and personb
            //one must know the other, while the other does not know the one
        }
        
        for (int i = 0; i < n; i ++) {
            if (persona == i) continue;
            //pass the self-condition
            if (knows(persona, i) || !knows(i, persona)) return -1;
        }
        //final validation

        return persona;
    }


	//this method might have some problems
    public int findCelebrity(int n) {
	    int celebrity = 0;

	    for(int i = 1; i < n; i++){
	        //檢查完代表兩件事
	        //celebrity 以前的都不可能是celebrity 因為他們都認識celebrity 以前的其中一個人
	        //celebrity 以後的他都不認識，因為如果認識的話 celebrity 早就被update了
	        if(knows(celebrity, i)){
	            celebrity = i;                  
	        }
	    }
	    //check again if celebrities knows somebody
	    for(int i = 0; i < celebrity; i++){
	        //雖然celebrity 以前的都不可能是celebrity 因為他們都認識celebrity 前的一個人
	        //但是我們必須檢查 celebrity 是否認識前面的任何一個人，如果有認識，-1
	        //i != celebrity;
	        // if (!knows(i, candidate) 不用加因為就算在celebrities 
	        //之前有人不認識 celebritiy 他們也認識了期她的人 )   
	        //WHY NOT??? 
	    if(knows(celebrity, i)){
	            return -1;   
	        }
	    }
	    for(int i = celebrity + 1; i < n; i++){
	        //雖然celebrity 以後的他都不認識
	        //但是還是要檢查celebrity 以後的人是不是都認識他
	        if(!knows(i, celebrity)){
	            return -1;   
	        }   
	    }
	    return celebrity;
	}


832.
	time complexity is O(mn)
	space complexity is O(1)
	//the use of XOR: ^
	//int ^ 1 --> invert itself
	//int ^ 0 --> keep itself
	public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i ++) {
            for (int j = 0; j < (A[0].length + 1) / 2; j ++) {
                if (j == A[0].length - 1 - j) A[i][j] ^= 1;
                else {
                    int temp = A[i][j];
                    A[i][j] = A[i][A[0].length - 1 - j] ^ 1;
                    A[i][A[0].length - 1 - j] = temp ^ 1;
                }
            }
        }
        return A;
    }


769.
	//use the boundary
	//use the property that the sorted is index
	time complexity is O(n)
	space complexity is O(1)
	public int maxChunksToSorted(int[] arr) {
        int chuckNum = 0, pointer = 0, boundary = 0;
        while (pointer < arr.length) {
            boundary = Math.max(boundary, arr[pointer ++]);
            if (pointer > boundary) chuckNum ++;
        }
        return chuckNum;
    }


301.
	time complexity ??? O(n^2)
	space complexity ??? O(n)

	//using DFS!!!
	public List<String> removeInvalidParentheses(String s) {
        int wl = 0, wr = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '(') wl ++;
            else if (s.charAt(i) == ')' && wl > 0) wl --;
            else if (s.charAt(i) == ')') wr ++;
        }
        
        Set<String> res = new HashSet<>();
        helper(s, 0, new StringBuilder(), res, wl, wr, 0);
        return new ArrayList<>(res);
        //classic!
    }
    
    private void helper(String s, int i, StringBuilder sb, Set<String> list, int wl, int wr, int open) {
        if (wl < 0 || wr < 0 || open < 0) return;
        if (wl == 0 && wr == 0 && open == 0 && i == s.length()) {
            list.add(sb.toString());
            return;
        }
        else if (i == s.length()) return;
        else {
            int len = sb.length();
            if (s.charAt(i) == '(') {
                helper(s, i + 1, sb, list, wl - 1, wr, open);
                sb.setLength(len);
                helper(s, i + 1, sb.append(s.charAt(i)), list, wl, wr, open + 1);
            }
            else if (s.charAt(i) == ')') {
                helper(s, i + 1, sb, list, wl, wr - 1, open);
                sb.setLength(len);
                helper(s, i + 1, sb.append(s.charAt(i)), list, wl, wr, open - 1);
            }
            else {
                helper(s, i + 1, sb.append(s.charAt(i)), list, wl, wr, open);
            }
            //sb.setLength(len);
        }
    }

    //another solution
    //hard to understand
    public static List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        char[] check = new char[]{'(', ')'};
        dfs(s, res, check, 0, 0);
        return res;
    }

    public static void dfs(String s, List<String> res, char[] check, int last_i, int last_j) {
        int count = 0;
        int i = last_i;
        while (i < s.length() && count>= 0) {

            if (s.charAt(i) == check[0]) count ++;
            if (s.charAt(i) == check[1]) count --;
            i ++;
        }

        if (count >= 0)  {
            // no extra ')' is detected. We now have to detect extra '(' by reversing the string.
            String reversed = new StringBuffer(s).reverse().toString();
            if (check[0] == '(') dfs(reversed, res, new char[]{')', '('}, 0, 0);
            else res.add(reversed);

        }

        else {  // extra ')' is detected and we have to do something
            i -= 1; // 'i-1' is the index of abnormal ')' which makes count<0
            for (int j = last_j; j<= i; j++) {
                if (s.charAt(j) == check[1] && (j == last_j || s.charAt(j-1) != check[1])) {
                    dfs(s.substring(0, j) + s.substring(j+1, s.length()), res, check, i, j);
                }
            }
        }
    }


337.
	time complexity is O(n)???
	space complexity is O(n)
	//use the dp idea
	//define as the max from the tree of the given root
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
	        //use this map to do the dp, overlap part!
	        return temp;
	    }
	}


547.
	//graph problem, find the connective counterpart
	time complexity is O(m + n)???
	space complexity is O(n)
	public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int sum = 0;
        for (int i = 0; i < M.length; i ++) {
            if (visited[i]) continue;
            dfs(visited, M, i);
            sum ++;
        }
        return sum;
    }
    
    private void dfs(boolean[] visited, int[][] M, int index) {
        if (visited[index]) return;
        visited[index] = true;
        for (int i = 0; i < M[0].length; i ++) {
            if (M[index][i] == 1) {
                dfs(visited, M, i);
            }
        }
    }


329.
	time complexity is O(n^2)
	space complexity is O(n^2)
	private int[][] around = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        //corner case!!! Do try to avoid!!!
        
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        int res = 0;
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[0].length; j ++) {
                res = Math.max(res, dfs(matrix, dp, i, j));
            }
        }
        
        return res;
    }
    
    private int dfs(int[][] matrix, int[][] dp, int row, int col) {
        if (dp[row][col] != 0) return dp[row][col];
        
        int res = 1;
        for (int[] each : around) {
            int newrow = row + each[0];
            int newcol = col + each[1];
            if (newrow >= 0 && newrow < matrix.length && 
            	newcol >= 0 && newcol < matrix[0].length
               && matrix[newrow][newcol] > matrix[row][col]) {
                res = Math.max(res, dfs(matrix, dp, newrow, newcol) + 1);
            }
        }
        dp[row][col] = res;
        
        return res;
        
    }


86.
	//one pass
	time complexity is O(n)
	space complexity is O(1)
	public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        ListNode small = new ListNode(0);
        dummy.next = head;
        
        ListNode pointer = dummy;
        ListNode start = small;
        while (pointer.next != null) {
            if (pointer.next.val >= x) {
                pointer = pointer.next;
            }
            else {
                ListNode temp = pointer.next;
                pointer.next = pointer.next.next;
                start.next = temp;
                start = start.next;
                start.next = null;
                //give null, avoid loops in linkedlist
            }
        }
        
        start.next = dummy.next;
        
        return small.next;
    }


    //in-place operation: the start corner case (value less than x) must avoid!
    class Solution {
	    public ListNode partition(ListNode head, int x) {
	        if (head == null || head.next == null) return head;
	        ListNode dummy = new ListNode(0);
	        dummy.next = head;
	        
	        ListNode less = dummy, more = head, moreStart = head;
	        while (moreStart != null && moreStart.val < x) {
	            moreStart = moreStart.next;
	            more = more.next;
	            less = less.next;
	        }
	        if (moreStart == null) return head;
	        
	        while (more != null && less != null) {
	            while (more.next != null && more.next.val >= x) more = more.next;
	            if (more.next == null) break;
	            less.next = more.next;
	            while (less.next != null && less.next.val < x) less = less.next;
	            more.next = less.next;
	            more = more.next;
	        }
	        
	        less.next = moreStart;
	        
	        return dummy.next;
	    }
	}


455.
	time complexity is O(mlogm + nlogn)
	space complexity is O(1)
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0, cookie = 0, number = 0;
        while (child < g.length && cookie < s.length) {
            if (g[child] <= s[cookie]) {
                child ++;
                cookie ++;
                number ++;
            }
            else {
                cookie ++;
            }
        }
        return number;
    }


297.
	//cannot use queue here, use stack instead
	//but why???
	//and the last one is not two null, why???
	private int[] index = new int[]{0};

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> st = new Stack<>();
        while (root != null || !st.isEmpty()) {
            if (root != null) {
                sb.append(root.val + " ");
                st.push(root.right);
                st.push(root.left);
            }
            else {
                sb.append("null ");
            }
            root = st.pop();
        }
        return sb.toString().trim();
    }
    

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] arr = data.split(" ");
        return helper(arr);
    }
    
    private TreeNode helper(String[] arr) {
        if (index[0] >= arr.length || arr[index[0]].equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(arr[index[0]]));
        index[0] ++;
        root.left = helper(arr);
        index[0] ++;
        root.right = helper(arr);
        return root;
    }


417.
	//what happend if you have to variables/conditions to detect?
	//use two different boolean!!!
	time complexity ???
	space complexity is O(mn)
	public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new LinkedList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
		//corner case!

        int n = matrix.length, m = matrix[0].length;
        boolean[][]pacific = new boolean[n][m];
        boolean[][]atlantic = new boolean[n][m];
        for(int i=0; i<n; i++){
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, m-1);
        }
        for(int i=0; i<m; i++){
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, n-1, i);
        }
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < m; j++) 
                if (pacific[i][j] && atlantic[i][j]) 
                    res.add(new int[] {i, j});
        return res;
    }
    
    int[][]dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    
    public void dfs(int[][]matrix, boolean[][]visited, int height, int x, int y){
        int n = matrix.length, m = matrix[0].length;
        if(x<0 || x>=n || y<0 || y>=m || visited[x][y] || matrix[x][y] < height)
            return;
        visited[x][y] = true;
        for(int[]d:dir){
            dfs(matrix, visited, matrix[x][y], x+d[0], y+d[1]);
        }
    }


513.
	//using BFS
	time complexity ???1
	space complexity is O(n)	
	public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        
        int record = 0;
        while (!qu.isEmpty()) {
            int size = qu.size();
            for (int i = 0; i < size; i ++) {
                TreeNode temp = qu.poll();
                if (i == 0) record = temp.val;
                if (temp.left != null) qu.offer(temp.left);
                if (temp.right != null) qu.offer(temp.right);
            }
        }
        
        return record;
    }

    //another method
    //using level
    //detect when level changes!!!
    int ans=0, h=0;
    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValue(root, 1);
        return ans;
    }
    public void findBottomLeftValue(TreeNode root, int depth) {
        if (h<depth) {ans=root.val;h=depth;}
        if (root.left!=null) findBottomLeftValue(root.left, depth+1);
        if (root.right!=null) findBottomLeftValue(root.right, depth+1);
    }


77.
	//backtracking
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (k > n || k <= 0) {
            return res;
        }
        //kill the corner case to accelerate

        helper(n, k, 0, res, new ArrayList<>());
        return res;
    }
    
    private void helper(int n, int k, int start, List<List<Integer>> res, List<Integer> list) {
        int len = list.size();
        if (len == k) {
            res.add(new ArrayList<>(list));
        }
        else {
            for (int i = start + 1; i <= n; i ++) {
                list.add(i);
                helper(n, k, i, res, list);
                list.remove(len);
            }
        }
    }

    //another good method
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k > n || k < 0) {
            return result;
        }
        if (k == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        result = combine(n - 1, k - 1);
        for (List<Integer> list : result) {
            list.add(n);
            //List.add() return true or false
        }
        result.addAll(combine(n - 1, k));
        //addAll() API, add all element from another list
        return result;
    }


    //another good method
    class Solution {
	    public List<List<Integer>> combine(int n, int k) {
	        List<List<Integer>> res = new ArrayList<>();
	        dfs(res, new ArrayList<>(), k, 1, n);
	        return res;
	    }
	    
	    private void dfs(List<List<Integer>> res, List<Integer> list, int k, int start, int n) {
	        if (k == 0) {
	            res.add(new ArrayList<>(list));
	            return;
	        } 
	        if (start > n && k > 0 || k < 0) return;
	        list.add(start);
	        dfs(res, list, k - 1, start + 1, n);
	        list.remove(list.size() - 1);
	        dfs(res, list, k, start + 1, n);        
	    }
	}


60.
	private String res = "";
    
    public String getPermutation(int n, int k) {
        helper(n, new int[]{k}, new boolean[n + 1], new StringBuilder());
        return res;
    }
    
    private void helper(int n, int[] k, boolean[] visited, StringBuilder sb){
        int len = sb.length();
        if (k[0] == 1 && len == n) {
            res = sb.toString();
            k[0] --;
            //end condition!!!
        }
        else if (len == n) {
            k[0] --;
        }
        else if (k[0] < 1) return;
        else {
            for (int i = 1; i <= n && k[0] >= 1; i ++) {
                if (visited[i]) continue;
                visited[i] = true;
                helper(n, k, visited, sb.append(i));
                //StringBuilder.append() return StringBuilder
                visited[i] = false;
                sb.setLength(len);
            }
        }
    }


208.
	//one solution but slow
	class Trie {
    
	    private Set<String> set;

	    /** Initialize your data structure here. */
	    public Trie() {
	        set = new HashSet<>();
	    }
	    
	    /** Inserts a word into the trie. */
	    public void insert(String word) {
	        set.add(word);
	    }
	    
	    /** Returns if the word is in the trie. */
	    public boolean search(String word) {
	        return set.contains(word);
	    }
	    
	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    public boolean startsWith(String prefix) {
	        for (String each : set) {
	            if (prefix.compareTo(each) > 0) continue;
	            if (prefix.compareTo(each) == 0) return true;
	            for (int i = 0; i < prefix.length(); i ++) {
	                if (prefix.charAt(i) != each.charAt(i)) break;
	                if (prefix.charAt(i) == each.charAt(i) && i == prefix.length() - 1) return true;
	            }
	        }
	        return false;
	    }
	}

	//another method
	class TrieNode {
	    
	    TrieNode[] children = new TrieNode[26];
	    boolean isLeaf;
	    // Constructor
	    public TrieNode() {
	    }
	}

	public class Trie {
	    
	    private TrieNode root;

	    public Trie() {
	        root = new TrieNode();
	    }

	    // Inserts a word into the trie.
	    public void insert(String word) {
	        insert(word.toCharArray(), 0, root);
	    }
	    
	    public void insert(char[] word, int i, TrieNode node) {
	        
	        if (i == word.length) {
	            node.isLeaf = true;
	            return;
	        }
	        
	        char c = word[i];
	        if (node.children[c - 'a'] == null) {
	            node.children[c - 'a'] = new TrieNode();
	        }
	        
	        insert(word, i + 1, node.children[c - 'a']);
	    }

	    // Returns if the word is in the trie.
	    public boolean search(String word) {
	        return search(word.toCharArray(), 0, root);
	    }
	    
	    public boolean search(char[] word, int i, TrieNode node) {
	        
	        if (i == word.length) {
	            return node.isLeaf;
	        }
	        
	        char c = word[i];
	        
	        return node.children[c - 'a'] != null && search(word, i + 1, node.children[c - 'a']);
	    }

	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
	        return startsWith(prefix.toCharArray(), 0, root);
	    }
	    
	    public boolean startsWith(char[] word, int i, TrieNode node) {
	        
	        if (i == word.length) {
	            return true;
	        }
	        
	        char c = word[i];
	        return node.children[c - 'a'] != null && startsWith(word, i + 1, node.children[c - 'a']);
	    }
}


295.
	class MedianFinder {
	    
	    private PriorityQueue<Integer> maxheap;
	    private PriorityQueue<Integer> minheap;

	    /** initialize your data structure here. */
	    public MedianFinder() {
	        maxheap = new PriorityQueue<Integer>((Integer a, Integer b) -> b.compareTo(a));
	        //default is minheap!!!
	        //use new comparetor!!!
	        //Integer must use Integer a and Integer b, can compareTo
	        //remmember the bracket!!!
	        minheap = new PriorityQueue<>();
	    }
	    
	    public void addNum(int num) {
	        if (maxheap.size() == 0 && minheap.size() == 0) minheap.offer(num);
	        else if (maxheap.size() == 0) {
	            minheap.offer(num);
	            maxheap.offer(minheap.poll());
	        }
	        else if (num > maxheap.peek() && num < minheap.peek()) {
	            minheap.offer(num);
	        }
	        else if (num < maxheap.peek()) {
	            maxheap.offer(num);
	        }
	        else {
	            minheap.offer(num);
	        }
	        adjust();
	    }
	    
	    private void adjust() {
	        if (maxheap.size() > minheap.size() + 1) {
	            minheap.offer(maxheap.poll());
	        }
	        else if (minheap.size() > maxheap.size() + 1) {
	            maxheap.offer(minheap.poll());
	        }
	    }
	    
	    public double findMedian() {
	        if (maxheap.size() == minheap.size()) {
	            return ((double) (maxheap.peek() + minheap.peek())) / 2;
	        }
	        else if (maxheap.size() > minheap.size()) {
	            return maxheap.peek();
	        }
	        else {
	            return minheap.peek();
	        }
	    }
	}


281.
	//no comment
	//just write it, key is to get all possible cases
	public class ZigzagIterator {
	    private int v1pointer;
	    private int v2pointer;
	    private int turnpointer;
	    private List<Integer> list1;
	    private List<Integer> list2;

	    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
	        list1 = v1;
	        list2 = v2;
	        v1pointer = 0;
	        v2pointer = 0;
	        turnpointer = 0;
	    }

	    public int next() {
	        turnpointer %= 2;
	        if (turnpointer == 0 && v1pointer < list1.size()) {
	            turnpointer ++;
	            return list1.get(v1pointer ++);
	        }
	        else if (turnpointer == 1 && v2pointer < list2.size()) {
	            turnpointer ++;
	            return list2.get(v2pointer ++);
	        }
	        else {
	            turnpointer ++;
	            return next();
	        }
	    }

	    public boolean hasNext() {
	        return v1pointer < list1.size() || v2pointer < list2.size();
	    }
	}


460.
	//get O(logn), put O(logn)
	//use PriorityQueue and HashMap
	class LFUCache {
    
	    private Map<Integer, Wrapper> map;
	    private PriorityQueue<Wrapper> pq;
	    private int count;
	    private int limit;
	    private int order;

	    public LFUCache(int capacity) {
	        pq = new PriorityQueue<Wrapper>(new Comparator<Wrapper>(){
	            @Override
	            public int compare(Wrapper a, Wrapper b) {
	                if (a.frequency == b.frequency) {
	                    return a.useOrder - b.useOrder;
	                }
	                return a.frequency - b.frequency;
	            }
	        });
	        map = new HashMap<>();
	        count = 0;
	        order = 0;
	        limit = capacity;
	    }
	    
	    public int get(int key) {
	        if (map.containsKey(key)) {
	            Wrapper temp = map.get(key);
	            int value = temp.val;
	            Wrapper newrap = new Wrapper(value, ++ temp.frequency, order ++, key);
	            pq.remove(temp);
	            pq.offer(newrap);
	            map.remove(key);
	            map.put(key, newrap);
	            return value;
	        }
	        else {
	            return -1;
	        }
	    }
	    
	    public void put(int key, int value) {
	        Wrapper newrap = new Wrapper(value, 0, order ++, key);
	        if (map.containsKey(key)) {
	            Wrapper older = map.get(key);
	            pq.remove(older);
	            newrap.frequency = older.frequency + 1;
	            pq.offer(newrap);
	            map.remove(key);
	            map.put(key, newrap);
	        }
	        else if (count < limit) {
	            map.put(key, newrap);
	            pq.offer(newrap);
	            count ++;
	        }
	        else if (count == 0) {
	            return;
	        }
	        else {
	            map.remove(pq.peek().key);
	            pq.poll();
	            map.put(key, newrap);
	            pq.offer(newrap);
	        }
	    }
	    
	    private class Wrapper{
	        int val;
	        int frequency;
	        int useOrder;
	        int key;
	        public Wrapper(int x, int f, int u, int k) {
	            val = x;
	            frequency = f;
	            useOrder = u;
	            key = k;
	        }
	    }
	}


	//All O(1) operations
	/*
	Two HashMaps are used, one to store <key, value> pair, another store the <key, node>.

	I use double linked list to keep the frequent of each key. 
	In each double linked list node, keys with the same count are saved using 
	java built in LinkedHashSet. This can keep the order.

	Every time, one key is referenced, first find the current node corresponding to the key, 
	If the following node exist and the frequent is larger by one, add key 
	to the keys of the following node, else create a new node and add it following 
	the current node.

	All operations are guaranteed to be O(1).
	*/
	public class LFUCache {
	    private Node head = null;
	    private int cap = 0;
	    private HashMap<Integer, Integer> valueHash = null;
	    private HashMap<Integer, Node> nodeHash = null;
	    
	    public LFUCache(int capacity) {
	        this.cap = capacity;
	        valueHash = new HashMap<Integer, Integer>();
	        nodeHash = new HashMap<Integer, Node>();
	    }
	    
	    public int get(int key) {
	        if (valueHash.containsKey(key)) {
	            increaseCount(key);
	            return valueHash.get(key);
	        }
	        return -1;
	    }
	    
	    public void set(int key, int value) {
	        if ( cap == 0 ) return;
	        if (valueHash.containsKey(key)) {
	            valueHash.put(key, value);
	        } else {
	            if (valueHash.size() < cap) {
	                valueHash.put(key, value);
	            } else {
	                removeOld();
	                valueHash.put(key, value);
	            }
	            addToHead(key);
	        }
	        increaseCount(key);
	    }
	    
	    private void addToHead(int key) {
	        if (head == null) {
	            head = new Node(0);
	            head.keys.add(key);
	        } else if (head.count > 0) {
	            Node node = new Node(0);
	            node.keys.add(key);
	            node.next = head;
	            head.prev = node;
	            head = node;
	        } else {
	            head.keys.add(key);
	        }
	        nodeHash.put(key, head);      
	    }
	    
	    private void increaseCount(int key) {
	        Node node = nodeHash.get(key);
	        node.keys.remove(key);
	        
	        if (node.next == null) {
	            node.next = new Node(node.count+1);
	            node.next.prev = node;
	            node.next.keys.add(key);
	        } else if (node.next.count == node.count+1) {
	            node.next.keys.add(key);
	        } else {
	            Node tmp = new Node(node.count+1);
	            tmp.keys.add(key);
	            tmp.prev = node;
	            tmp.next = node.next;
	            node.next.prev = tmp;
	            node.next = tmp;
	        }

	        nodeHash.put(key, node.next);
	        if (node.keys.size() == 0) remove(node);
	    }
	    
	    private void removeOld() {
	        if (head == null) return;
	        int old = 0;
	        for (int n: head.keys) {
	            old = n;
	            break;
	        }
	        head.keys.remove(old);
	        if (head.keys.size() == 0) remove(head);
	        nodeHash.remove(old);
	        valueHash.remove(old);
	    }
	    
	    private void remove(Node node) {
	        if (node.prev == null) {
	            head = node.next;
	        } else {
	            node.prev.next = node.next;
	        } 
	        if (node.next != null) {
	            node.next.prev = node.prev;
	        }
	    }
	    
	    class Node {
	        public int count = 0;
	        public LinkedHashSet<Integer> keys = null;
	        public Node prev = null, next = null;
	        
	        public Node(int count) {
	            this.count = count;
	            keys = new LinkedHashSet<Integer>();
	            prev = next = null;
	        }
	    }
	}


407.
	public class Solution {
	    private static class Cell implements Comparable<Cell> {
	        private int row;
	        private int col;
	        private int value;
	        public Cell(int r, int c, int v) {
	            this.row = r;
	            this.col = c;
	            this.value = v;
	        }
	        @Override
	        public int compareTo(Cell other) {
	            return value - other.value;
	        }
	    }
	    private int water;
	    private boolean[][] visited1;
	    public int trapRainWater(int[][] heightMap) {
	        if (heightMap.length == 0) return 0;
	        PriorityQueue<Cell> walls = new PriorityQueue<Cell>();
	        water = 0;
	        visited1 = new boolean[heightMap.length][heightMap[0].length];
	        int rows = heightMap.length, cols = heightMap[0].length;
	        //build wall;
	        for (int c = 0; c < cols; c++) {
	        	walls.add(new Cell(0, c, heightMap[0][c]));
	        	walls.add(new Cell(rows - 1, c, heightMap[rows - 1][c]));
	        	visited1[0][c] = true;
	        	visited1[rows - 1][c] = true;
	        }
	        for (int r = 1; r < rows - 1; r++) {
	        	walls.add(new Cell(r, 0, heightMap[r][0]));
	        	walls.add(new Cell(r, cols - 1, heightMap[r][cols - 1]));
	        	visited1[r][0] = true;
	        	visited1[r][cols - 1] = true;
	        }
	        //end build wall;
	        while(walls.size() > 0) {
	            Cell min = walls.poll();
	            visit(heightMap, min, walls);
	        }
	        return water;
	    }
	    private void visit(int[][] height, Cell start, PriorityQueue<Cell> walls) {
	        fill(height, start.row + 1, start.col, walls, start.value);
	        fill(height, start.row - 1, start.col, walls, start.value);
	        fill(height, start.row, start.col + 1, walls, start.value);
	        fill(height, start.row, start.col - 1, walls, start.value);
	    }
	    private void fill(int[][] height, int row, int col, PriorityQueue<Cell> walls, int min) {
	        if (row < 0 || col < 0) return;
	        else if (row >= height.length || col >= height[0].length) return;
	        else if (visited1[row][col]) return;
	        else if (height[row][col] >= min) {
	            walls.add(new Cell(row, col, height[row][col]));
	            visited1[row][col] = true;
	            return;
	        } else {
	//        	System.out.println(row + ", " + col + " height = " + height[row][col] + ", bar = " + min);
	            water += min - height[row][col];
	            visited1[row][col] = true;
	            fill(height, row + 1, col, walls, min);
	            fill(height, row - 1, col, walls, min);
	            fill(height, row, col + 1, walls, min);
	            fill(height, row, col - 1, walls, min);
	        }
	    }
	}


	//another method
	public class Solution {

	    public class Cell {
	        int row;
	        int col;
	        int height;
	        public Cell(int row, int col, int height) {
	            this.row = row;
	            this.col = col;
	            this.height = height;
	        }
	    }

	    public int trapRainWater(int[][] heights) {
	        if (heights == null || heights.length == 0 || heights[0].length == 0)
	            return 0;

	        PriorityQueue<Cell> queue = new PriorityQueue<>(1, new Comparator<Cell>(){
	            public int compare(Cell a, Cell b) {
	                return a.height - b.height;
	            }
	        });
	        
	        int m = heights.length;
	        int n = heights[0].length;
	        boolean[][] visited = new boolean[m][n];

	        // Initially, add all the Cells which are on borders to the queue.
	        for (int i = 0; i < m; i++) {
	            visited[i][0] = true;
	            visited[i][n - 1] = true;
	            queue.offer(new Cell(i, 0, heights[i][0]));
	            queue.offer(new Cell(i, n - 1, heights[i][n - 1]));
	        }

	        for (int i = 0; i < n; i++) {
	            visited[0][i] = true;
	            visited[m - 1][i] = true;
	            queue.offer(new Cell(0, i, heights[0][i]));
	            queue.offer(new Cell(m - 1, i, heights[m - 1][i]));
	        }

	        // from the borders, pick the shortest cell visited and check its neighbors:
	        // if the neighbor is shorter, collect the water it can trap and update its height as its height plus the water trapped
	       // add all its neighbors to the queue.
	        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	        int res = 0;
	        while (!queue.isEmpty()) {
	            Cell cell = queue.poll();
	            for (int[] dir : dirs) {
	                int row = cell.row + dir[0];
	                int col = cell.col + dir[1];
	                if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
	                    visited[row][col] = true;
	                    res += Math.max(0, cell.height - heights[row][col]);
	                    queue.offer(new Cell(row, col, Math.max(heights[row][col], cell.height)));
	                }
	            }
	        }
	        
	        return res;
	    }
	}



	//my method
	//actually, it is another version of trap water
	//from 2 pointer boundary to around boundary
	class Solution {
	    private int count = 0;
	    private int max = 0;
	    private int[][] around = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
	    
	    public int trapRainWater(int[][] heightMap) {
	        if (heightMap == null || heightMap.length <= 1 || heightMap[0].length <= 1) return 0;
	        
	        PriorityQueue<Cell> pq = new PriorityQueue<>(new Comparator<Cell>(){
	            @Override
	            public int compare(Cell a, Cell b) {
	                return a.height - b.height;
	            }
	        });
	        boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];
	        for (int i = 0; i < heightMap.length; i ++) {
	            pq.offer(new Cell(i, 0, heightMap));
	            pq.offer(new Cell(i, heightMap[0].length - 1, heightMap));
	            visited[i][0] = true;
	            visited[i][heightMap[0].length - 1] = true;
	        }
	        for (int i = 0; i < heightMap[0].length; i ++) {
	            pq.offer(new Cell(0, i, heightMap));
	            pq.offer(new Cell(heightMap.length - 1, i, heightMap));
	            visited[0][i] = true;
	            visited[heightMap.length - 1][i] = true;
	        }
	        while (!pq.isEmpty()) {
	            find(heightMap, visited, pq);
	        }
	        return count;
	    }
	    
	    private void find(int[][] heightMap, boolean[][] visited, PriorityQueue<Cell> pq) {
	        Cell cur = pq.poll();
	        int rowCur = cur.row, colCur = cur.col;
	        max = Math.max(max, cur.height);
	        for (int[] each : around) {
	            int newRow = rowCur + each[0];
	            int newCol = colCur + each[1];
	            if (newRow < 0 || newCol < 0 || newRow >= heightMap.length || newCol >= heightMap[0].length 
	                || visited[newRow][newCol]) continue;
	            count += heightMap[newRow][newCol] < max ? max - heightMap[newRow][newCol] : 0;
	            pq.offer(new Cell(newRow, newCol, heightMap));
	            visited[newRow][newCol] = true;
	        }
	    }
	}

	class Cell{
	    int row;
	    int col;
	    int height;
	    public Cell(int a, int b, int[][] heightMap) {
	        row = a;
	        col = b;
	        height = heightMap[a][b];
	    }
	}



//Lesson 10
	//Q2 L 103
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) return res;
		Deque<Integer> dq = new ArrayDeque<>();
		//ArrayDeque implements Deque
		//ArrayDeque can do that in Java 7
		dq.offerFirst(root);
		boolean reverseOrder = false;
		//can use level
		int size;
		while (!dq.isEmpty()) {
			size = dq.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < size; i ++) {
				if (reverseOrder) {
					//leve % 2 == 0 can do that
					TreeNode temp = dq.pollLast();
					list.add(temp.val);
					if (temp.right != null) dq.offerFirst(temp.right);
					if (temp.left != null) dq.offerFirst(temp.left);
				}
				else {
					TreeNode temp = dq.pollFirst();
					list.add(temp.val);
					if (temp.left != null) dq.offerLast(temp.left);
					if (temp.right != null) dq.offerLast(temp.right);
				}
			}
			res.add(list);
			reverseOrder = !reverseOrder;// flag = 1 - flag;
			//level ++
			//how to tell how many times of true?
			//use 0 for false, use 1, 2, 3, ... to represent the true
			//times
		}
		return res;
	}


//7/6
	//all
	private void dfs(int n, StringBuilder sb, int l, int r,
		List<String> res) {
		//base case
		if (l == r && l == n) {
			res.add(sb.toString());
			return;
		}
		if (l < n) {
			dfs(n, sb.append('('), l + 1, r);
			sb.deleteCharAt(sb.length() - 1);
		}
		if (r < n) {
			dfs(n, sb.append(')'), l, r + 1);
			sb.deleteCharAt(sb.length() - 1);
		}
	}


	//valid generator
	private void dfs(int n, StringBuilder sb, int l, int r,
		List<String> res) {
		if (l == r && l == n) {
			res.add(sb.toString());
			return;
		}
		if (l < n && l >= r) {
			//use l < n
			dfs(n, sb.append('('), l + 1, r);
			sb.deleteCharAt(sb.length() - 1);
		}
		if (l <= n && l > r) {
			//use r < l
			dfs(n, sb.append(')'), l, r + 1);
			//StringBuilder append char
			//or String or int or boolean
			//or double
			sb.deleteCharAt(sb.length() - 1);
		}
	}


	private void dfs(int[] coins, int level, int left,
		 int[] sol, List<int[]> res) {
		if (level == coins.length - 1) {
			sol[level] = left;
			int[] copy = new int[coins.length];
			System.arraycopy(sol, 0, copy, 0, coins.length);
			//deep copy, or can use a for loop
			//or use
			//res.add(sol.clone());
			//which is also good
			res.add(copy);
			return;
		}
		for (int i = 0; i * coins[level] <= left; i ++) {
			sol[level] = i;
			dfs(coins, level + 1, left - coins[level] * i,
				sol, res);
		}
	}


46.
	private void dfs(char[] array, List<String> res, 
		StringBuilder sb, boolean[] visited) {
		if (sb.length == array.length) {
			res.add(sb.toString());
			return;
		}
		for (int i = 0; i < array.length; i ++) {
			if (visited[i]) continue;
			sb.append(array[i]);
			visited[i] = true;
			dfs(array, res, sb, visited);
			visited[i] = false;
			sb.deleteCharAt(sb.length() - 1);
		}
	}


	//another method
	private void dfs(char[] array, int index, 
		List<String> res) {
		//base case
		if (index == array.length - 1) {
			result.add(new String(array));
			return;
		}
		for (int i = index; i < array.length; i ++) {
			//a
			swap(array, index, i);
			//swap one
			dfs(array, index + 1, result);
			swap(array, index, i);
			//return to original
			//a
		}
	}


//7/9
191.
	//left shift
	public int numOfBits(int n) {
		int count = 0, mask = 1;
		for (int i = 0; i < 32; i ++) {
			if (n & mask != 0) count ++;
			//using != 0, do not use == 1,
			//might causing mistakes
			mask <<= 1;
		}
		return count;
	}

	//left shift, another method
	public int numOfBits(int n) {
		int count = 0;
		for (int i = 0; i < 32; i ++) {
			if (n & (mask << i) > 0) count ++;
			//O(1) time complexity, computer bit operation
		}
		return count;
	}


	//right shift filled with 0
	public int numOfBits(int n) {
		int count = 0， mask = 1;
		for (int i = 0; i < 32; i ++) {
			if (n & mask == 1) count ++;
			n >>>= 1;
			//can use n >>= 1
			//for loop will end eventually
		}
		return count;
	}

	//right shift filled with 0, using while loop
	public int numOfBits(int n) {
		int count = 0, mask = 1;
		while (n != 0) {
			if (n & mask == 1) count ++;
			n >>>= 1;
			//while loop must use >>>=
			//for loop do not have to use >>>=
		}
		return count;
	}


231.
	public boolean powerOf2(int n) {
		if (n == 1) return true;
		if (n % 2 != 0 || n < 1) return false;
		//do not forget n < 1, negative or zero
		return powerOf2(n / 2);
	}

	//the corresponding while loop
	public boolean powerOf2(int n) {
		if (n < 1) return false;
		while (n > 1) {
			if (n % 2 != 0) return false;
			n /= 2;
		}
		return n == 1;
	}

	//
	public boolean powerOf2(int n) {
		if (n < 1) return false;
		int count = 1;
		while (n > count) {
			count *= 2;
			//count <<= 1; this is a better way, REALLY???
			//times is supported by left shift in computer
		}
		return count == n;
	}


326.
	//pow of 3
	//method: check maxPowOfN % n == 0 && n > 0
	class Solution {
	    public boolean isPowerOfThree(int n) {
	        int maxPowerOfThree = (int) Math.pow(3, (int)(Math.log(Integer.MAX_VALUE) / Math.log(3)));
	        //Math.pow() return double
	        //Math.log() return double
	        return (n > 0 && maxPowerOfThree % n == 0);
	        //here can only check prime number, composite number cannot be checked here
	    }
	}


342.
	//pow of 4, composite number
	//num > 0 && maxPowOfFour ==> check if pow of 2
	//(num & 0x55555555) == num check bit position
	class Solution {
	    public boolean isPowerOfFour(int num) {
	        int maxPowOfFour = (int) Math.pow(4, 15);
	        return (num > 0 && maxPowOfFour % num == 0 && (num & 0x55555555) == num);
	    }
	}


//7/12
	//bit operation for check
	//use 8 length of int can represent all characters
	public boolean checkRepete(char[] arr) {
		try {
			if (arr == null) {
				throw new IllegalArgumentException();
			}
			//corner case:
			if (arr.length <= 1) return true;
			int[] map = new int[8];
			for (char each : arr) {
				int row = (int) each / 32;
				// can use
				//int row = each / 32
				int col = (int) each % 32;
				if (map[row] >> col & 1 != 0) return false;
				map[row] = 1 << col | map[row]
				//can also use
				//map[row] |= (1 << col);
			}
			return true;
		} 
		catch (IllegalArgumentException e) {
			//do error handling
		}
	}


	//pay attention to write comment
	//get, set, shift
	public int reverseBit(int n) {
		int res = 0;
		int mask;
		for (int i = 0; i < 32; i ++) {
			mask = 1;
			mask &= n >>> i;
			//mask = (n >> i) & 1;
			//get the bit
			res |= mask << (31 - i);
			//set the bit
		}
		return res;
	}

	//in place operation
	public int reverseBit(int n) {
		//corner case?
		//all bits are 0
		int left, right;
		for (int i = 0; i <= 15; i ++) {
			//number 16, total 32
			left = i;
			right = 31 - i;
			if ((1 & n >> right) == (1 & n >> left)) continue;
			//shift n not 1 here
			//for it causes different!
			//the result is exactly 0 and 1
			n ^= (1 << right);
			n ^= (1 << left);
		}
		return n;
	}


	//for 10-number
	public long reverseNum(int n) {
		if (n == 0) return (long) n;
		long res = 0;
		//use long, for overflow
		while (n != 0) {
			res *= 10;
			res += n % 10
			n /= 10;
		}
		return res;
		//if negative?
		//
	}
	//for 2-number
	public long reverseNum(int n) {
		if (n == 0) return (long) n;
		long res = 0;
		//use long, for overflow
		while (n != 0) {
			res *= 2;// res <<= 1;
			res += n % 2// n & 1;
			n /= 2;// n >>= 1;
			//which is bit operation
		}
		return res;
	}


//7/13
	public String removeChar(String origin, char a, char b) {
		if (origin == null || origin.length() == 0) return origin;
		char[] arr = origin.toCharArray();
		int slow = 0, fast = 0;
		while (fast < arr.length {
			if (arr[fast] == a || arr[fast] == b) {
				fast ++;
			}
			else {
				arr[slow ++] == arr[fast ++];
			}
		}
		return new String(arr, 0, slow);
	}


	public String removeLeadingAndEnding(String s) {
		if (s == null || s.length() == 0) return s;
		char[] arr = s.toCharArray();
		int slow = 0, fast = 0;
		while (fast < arr.length) {
			if (arr[fast] == ' ' && (fast == 0 || arr[fast - 1] == ' ')) {
				fast ++;
			}
			else {
				arr[slow ++] = arr[fast ++];
			}
		}
		if (slow == 0) {
			//rule out the case of all spaces
			String temp = "";
			return temp;
			//return "";
		}
		return new String(arr, 0, slow).trim();
	}


	public String removeDuplicateLetters(String s, int k) {
		if (s == null || s.length() <= k) return s;
		//KEY1: corner case
		//do not have to check k == 0
		//remove duplicate letters, not all of them!!!
		int slow = k, fast = k;
		//KEY2: slow initiate
		char[] arr = s.toCharArray();
		for (; fast < arr.length; fast ++) {
			if (arr[fast] != arr[slow - k]) {
				//KEY3: comparision
				arr[slow ++] = arr[fast];
			}
		}
		return new String(arr, 0, slow);
	}	


	public String removeDuplicateLetters(String s, int k) {
		if (s == null || s.length() <= k) return s;
		//KEY1: corner case
		//make sure k > 0
		int slow = k - 1, fast = k - 1;
		//KEY2: slow initiate
		char[] arr = s.toCharArray();
		for (; fast < arr.length; fast ++) {
			if (arr[fast] != arr[slow - k + 1]) {
				//slow - (slow - k + 1) + 1 = k
				//KEY3: comparision
				arr[++ slow] = arr[fast];
			}
		}
		return new String(arr, 0, slow + 1);
	}	



	public String reverseString(String s) {
		if (s == null || s.length() <= 1) return s;
		char[] arr = s.toCharArray();
		helper(arr, 0, arr.length - 1);
		return new String(arr, 0, arr.length);
	}
	private void helper(char[] arr, int left, int right) {
		if (left >= right) return;
		helper(arr, left + 1, right - 1);
		//helper(arr, ++ left, ++ right);
		//cannot use the above !!!
		//because swap()!!! but the left value has been changed
		//can only use left + 1!!!
		//keep the left and right unchanged!!!
		swap(arr, left, right);
	}
	private void swap(char[] arr, int a, int b) {
		char temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}


//7/23
	public int strStr(String a, String b) {
		if (a == null || a.length() == 0 || b == null
			|| b.length() == 0) return -1;
		int alen = a.length(), blen = b.length();

		if (alen < blen) return strStr(b, a);
		int pointera = 0, pointerb = 0;
		for (; pointera <= alen - blen; pointera ++) {
			if (a.charAt(pointera) != b.charAt(pointerb)) continue;
			int temp = pointera;
			while (a.charAt(temp) == b.charAt(pointerb)
			 && pointerb < blen) {
				temp ++;
				pointerb ++;
			}
			if (pointerb >= blen) return pointera;
			pointerb = 0;
		}
		return -1;
	}

	//better writing method
	public int strStr(String a, String b) {
		if (a == null || b == null) return -1;

		int alen = a.length(), blen = b.length();
		if (alen < blen) return strStr(b, a);
		for (int i = 0; i <= alen - blen; i ++) {
			//i can arrive at alen - blen!!!
			//int j = 0;
			for (int j = 0; j < blen; j ++) {
				if (a.charAt(i + j) != b.charAt(j)) break;
				if (j == beln - 1) return i;//improve place one
				//downside check the judge each time
				//slow down the for loop
			}
			//if (j == blen) return i;
		}
		return -1;
	}
	time complexity O(n*m)


//7/26
//Lesson 16	
	//DP
	public int JumpGame(int[] arr) {
		if (arr == null || arr.length == 0) return 0;

		int[] dp = new int[arr.length];
		if (arr[arr.length - 1] == 0)  dp[arr.length-1] = Integer.MAX_VALUE;
		//coner case, the end value cannot reach the end
		//also can use 
		//Arrays.fill(arr, Integer.MAX_VALUE);
		
		for (int i = arr.length - 2; i >= 0; i --) {
			dp[i] = Integer.MAX_VALUE - 1;
			//avoid the case that the for loop cannot enter
			//where arr[i] = 0
			for (int j = 1; j < arr[i] && 
				j + i < arr.length; j ++) {
				dp[i] = Math.min(dp[i], dp[i + j]);
			}
			dp[i] ++;
		}

		return dp[0];
		//if the start cannot reach the end
		//return Integer.MAX_VALUE
	} 


	//Greedy
	//thinking if it can jump out!
	public int JumpGame(int[] arr) {
		if (arr == null || arr.length == 0) return 0;

		int pre = 0, cur = 0, step = 0;
		for (int i = 0; i <= cur; i ++) {
			cur = Math.max(cur, arr[i] + i);
			//cur the farest pointer can get in this stage
			if (cur >= arr.length) return steps + 1;
			if (i > pre) {
				pre = cur;
				steps ++;
			}
		}
		return Integer.MAX_VALUE;
	}


//7/30
	public int cutRope(int n) {
		int[] dp = new int[n + 1];
		for (int i = 2; i <= n; i ++) {
			int curMax = 0;
			for (int j = 1; j <= (i + 1) / 2; j ++) {
				int curVal = Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]);
				//for a specific cut
				nowMax = Math.max(nowMax, curVal);
				//update when rope length is i metrics
			}
			dp[i] = nowMax;
		}
		return dp[n];
	}
	Time complexity is O(n^2)
	//focus the inner loop to reduce the time complexity
	//n>4, cut the middle, so the inner loop can reduce


//8/2
	//square for spiral print, clockwise
	public void spiral(int offset, int size, int[][] matrix) {
		//cannot use size <= 0 as the usecase, for the for loop will 
		//run two times on the same row/column
		if (size == 0) return;
		if (size == 1) {
			System.out.println(matrix[offset][offset]);
			return;
		}
		//the key is the index of this matrix element
		//top left corner [offset][offset]
		//top right corner [offset][offset + size - 1]
		for (int i = 0; i < size - 1; i ++) {
			System.out.println(matrix[offset][offset + i]);
		}
		//how to find the top right corner?
		//from the for loop above
		//find the start point first, see row/column who is changing
		for (int i = 0; i < size - 1; i ++) {
			System.out.println(matrix[offset + i][offset + size - 1]);
		}
		for (int i = 0; i < size - 1; i ++) {
			System.out.println(matrix[offset + size - 1][offset + size - 1 - i]);
		}
		for (int i = 0; i < size - 1; i ++) {
			System.out.println(matrix[offset + size - 1 - i][offset]);
		}
		//anti-clockwise, exchange the row and column of each elements
		spiral(offset + 1, size - 2, matrix);
	}

	//one clockwise, one anti-clockwise
	//keep the flag!

	//rectangle form
	public void spiral(int offset, int m, int n, int[][] matrix) {
		//base case change
		//if one is 1 or 0, print by the other one
	}


	//renew the property of each node
	public int countNodes(TreeNode root) {
		if (root == null) return 0;
		int left = countNodes(root.left);
		int right = countNodes(root.right);
		root.left_subtree_nodes = left;
		return left + right + 1;
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		int left_subtree_nodes;
	}


	TreeNode[] record = new TreeNode[1];
	public int countNodes(TreeNode root, TreeNode[] record) {
		if (root == null) return 0;
		int left = countNodes(root.left, TreeNode[] record);
		int right = countNodes(root.right, TreeNode[] record);
		if (Math.abs(left - right) > 
			Math.abs(record[0].left - record[0].right)) {
			record[0] = root;
		}
		return left + right + 1;
	}


//8/7
	public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q){
		if (root == null || root == p || root == q) return root;
		TreeNode left = LCA(root.left, p, q);
		TreeNode right = LCA(root.right, p, q);
		if (left != null && right != null) return root;
		else if (left != null) return left;
		return right;
		//include case right!= null
		//and case right == null && left == null

		//can write as
		//return (left != null) left : right; 

		/*
			can also write as
			if (left == null) return right;
			if (right == null) return left;
			return root;
		*/
	}


	//15.2 root to leaf, all leaf node is positive!
	public int pathSum(TreeNode root) {
		if (root == null) return 0;
		int leftSum = pathSum(root.left);
		int rightSum = pathSum(root.right);
		return root.val + Math.max(leftSum, rightSum);
	}

	//if with negative leaf node
	public int pathSum(TreeNode root) {
		if (root == null) return Integer.MIN_VALUE;
		int leftSum = pathSum(root.left);
		int rightSum = pathSum(root.right);
		int returnVal = Math.max(leftSum, rightSum);
		return (returnVal == 
			Integer.MIN_VALUE) ? root.val : root.val + returnVal;
	}

	//15.3 any node to root
	//only return positive, or 0
	public int pathSum(TreeNode root) {
		if (root == null) return Integer.MIN_VALUE;
		//for negative node, but can use 0 here also
		int leftSum = pathSum(root.left);
		int rightSum = pathSum(root.right);

		int returnVal = Math.max(leftSum, rightSum);
		return (returnVal < 0) ? root.val : root.val + returnVal;

		//another write method
		//return Math.max(Math.max(leftSum + rightSum), 0) + root.val;
	}

	//15.1 any leaf to any leaf
	//with all leaf node is positive
	private int globalMax = 0;
	public int pathSum(TreeNode root) {
		if (root == null) return 0;
		int leftSum = pathSum(root.left);
		int rightSum = pathSum(root.right);
		globalMax = Math.max(globalMax, leftSum + rightSum + root.val);
		return root.val + Math.max(leftSum, rightSum);
	}

	//if with negative leaf node
	private int globalMax = 0;
	public int pathSum(TreeNode root) {
		if (root == null) return Integer.MIN_VALUE;
		int leftSum = pathSum(root.left);
		int rightSum = pathSum(root.right);
		int returnVal = Math.max(leftSum + rightSum);
		if (leftSum != Integer.MIN_VALUE &&
			rightSum != Integer.MIN_VALUE) {
			globalMax = Math.max(globalMax, leftSum + rightSum + root.val);
		}
		return (returnVal == 
			Integer.MIN_VALUE) ? root.val : root.val + returnVal;
	}

	//15
	private int globalMax = 0;
	public int pathSum(TreeNode root) {
		if (root == null) return 0;
		int leftSum = pathSum(root.left);
		int rightSum = pathSum(root.right);
		int curSum = root.val;
		if (leftSum > 0) {
			curSum += leftSum;
		}
		if (rightSum > 0) {
			curSum += rightSum;
		}
		globalMax = Math.max(globalMax, curSum);
		return Math.max(Math.max(leftSum, rightSum), 0) + root.val;
	}


	//20 in place operation S2
	//private field, in order
	private TreeNode prev = new TreeNode(0);
	private TreeNode head = prev;
	private void inOrder(TreeNode root) {
		if (root == null) return;
		inOrder(root.left);
		prev.right = root;
		//if prev == null
		//nullPointerException
		//in that case head = prev;
		root.left = prev;
		prev = root;
		inOrder(root.right);
	}

	//another possible method
	private void inOrder(TreeNode root, TreeNode[] prev) {
		if (root == null) return;
		inOrder(root.left, prev);
		prev[0].right = root;
		root.left = prev[0];
		prev[0] = root;
		inOrder(root.right, prev);
	}


	//S3 check answer here!!!
	public TreeNode inOrder(TreeNode root) {
		if (root == null) return root;
		TreeNode r = inOrder(root.right);
		if (r != null) r.left = root;
		root.right = r;
		TreeNode l = inOrder(root.left);
		return l;
	}





//8/8
	public TreeNode flatten(TreeNode root) {
		flatten(root, null);
	}

	private TreeNode flatten(TreeNode root, TreeNode tail) {
		if (root == null) return tail;
		root.right = flatten(root.left, flatten(root.right, tail));
		root.left = null;
		return root;
	}

	//Q21 wrong answer
	private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
		if (start > end) return null;
		if (start == end) return new TreeNode(num[start]);
		int mid = start + (end - start) / 2;
		TreeNode left = sortedArrayToBST(nums, start, mid - 1);
		TreeNode right = sortedArrayToBST(nums, mid + 1, end);
	}


//lesson 20
	public String removeDuplicateLetters(String s) {
		if (s == null || s.length() <= 1) return s;
		//remove duplicate!!! remmerber to check corner case
		StringBuilder sb = new StringBuilder();
		Stack<Character> st = new Stack<>();
		for (char letter : s) {
			if (st.isEmpty() || st.peek() != letter) {
				st.push(letter);
				sb.append(letter);
				//append while check stack
				//one pass
			}
		}
		return sb.toString();
	}


	public String removeDuplicateLetters(String s) {
		if (s == null || s.length() <= 1) return s;
		//remove duplicate!!! remmerber to check corner case
		StringBuilder sb = new StringBuilder();
		for (char letter : s) {
			if (sb.length() == 0 || sb.charAt(sb.length()) != letter) {
				sb.append(letter);
				//append while check stack
				//one pass
			}
		}
		return sb.toString();
	}


//Q5 S3
	public int[] moveZeros(int[] arr) {
		if (arr == null || arr.length <= 1) return arr;
		int fast = 0;
		for (int slow = 0; slow < arr.length; slow ++) {
			if (fast < arr.length && arr[fast] != 0) {
				arr[slow] = arr[fast];
			}
			else if (fast < arr.length && arr[fast] == 0) {
				slow --;
			}
			else {
				arr[slow] = 0;
			}
			fast ++;
		}
		return arr;
	}


//Q9 S1
	private void matrixRotate(int[][] matrix, int offset, int size) {
		if (size <= 1) return; 
		int temp;
		for (int i = 0; i < size - 1; i ++) {//less than size - 1, spiral!!!
			temp = matrix[offset][offset + i];
			matrix[offset][offset + i] = matrix[offset + size - 1 - i][offset];
			matrix[offset + size - 1 - i][offset] = matrix[offset + size - 1][offset + size - 1 - i];
			matrix[offset + size - 1][offset + size - 1 - i] = matrix[offset + i][offset + size - 1];
			matrix[offset + i][offset + size - 1] = temp;
		}
		matrixRotate(matrix, offset + 1, size - 2);
	}


//8/11
//Q25 S3
	public int[] maxSlidingWindow(int[] a, int k) {
		if (a == null || k <= 0) {
			return new int[0];
		}

		int n = a.length;
		int[] r = new int[n - k + 1];
		int r1 = 0;
		//store index
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < a.length; i ++) {
			//remove numbers out of range k
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			//remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
				q.pollLast();
			}
			//q containes index ... r contains content
			q.offer(i);
			if (i >= k - 1) {
				r[r1 ++] = a[q.peek()];
			}
		}
		return r;
	}


//8/12
	//Q5
	public void removeBST(TreeNode root, int target) {
		if (root == null) return;
		while (root != null && root.val != target) {
			root = (root.val < target) ? root.right : root.left;
		}
		if (root == null) return;

		TreeNode cur = root;
		if (cur.left != null) {
			while (cur.right != null && cur.right.right != null) {
				cur = cur.right;
			}
			root.val = cur.val;

		}
	}


	//return one TreeNode is better
	public TreeNode removeAndReturn(TreeNode root, int target) {
		//add some corner cases
		if (root.val == target) {
			if (root.left != null && root.right != null) {
				root.val = findMin(root.right).val;
				root.right = removeAndReturn(root.right, root.val);
				//Key step!!!
			}
			else {
				root = (root.left != null) ? root.left : root.right;
				//key step!!!
				//include all other cases, including all null children
			}
		}
		else if (root.val > target) {
			root.left = removeAndReturn(root.left, target);
		}
		else if (root.val < target) {
			root.right = removeAndReturn(root.right, target);
		}
		return root;
	}


	private TreeNode findMin(TreeNode root) {
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

	private TreeNode findMin(TreeNode root) {
		if (root.left == null) return root;
		return findMin(root.left);
	}


	//Q7
	public TreeNode reverseBST(TreeNode root) {
		if (root == null || root.left == null) return root;
		TreeNode leftNew = reverseBST(root.left);
		root.left.right = root;
		root.left.left = root.right;
		root.left = null;
		root.right = null;
		return leftNew;
	}


278.
	public class Solution extends VersionControl {
	    public int firstBadVersion(int n) {
	        int left = 1, right = n;
	        int mid = (left + right) / 2;
	        if (n == 1) {
	            return isBadVersion(1) ? 1 : 0;
	        }
	        while (left > right) {
	            if (isBadVersion(mid)) {
	                right = mid;
	                mid = (left + right) / 2;
	            }
	            else if (!isBadVersion(mid + 1)) {
	                left = mid + 1;
	                mid = (left + right) / 2;
	            }
	            else if (!isBadVersion(mid) && isBadVersion(mid + 1)) {
	                return mid + 1;
	            }
	        }
	        return 0;
	    }
	}

	//better solution, clearer code, use method 2
	class Solution extends VersionControl {
	    public int firstBadVersion(int n) {
	        int left = 1, right = n, mid;
	        while (left < right) {
	            mid = left + (right - left) / 2;
	            if (isBadVersion(mid)) {
	                right = mid;
	            }
	            else {
	                left = mid + 1;
	            }
	        }
	        return (isBadVersion(left)) ? left : right;
	    }
	}

	//best solution, method 3
	class Solution extends VersionControl {
	    public int firstBadVersion(int n) {
	        int left = 1, right = n, mid;
	        while (left <= right) {
	            mid = left + (right - left) / 2;
	            if (isBadVersion(mid)) {
	                right = mid - 1;
	            }
	            else {
	                left = mid + 1;
	            }
	        }
	        return left;
	    }
	}


374.
	//very easy binary search, nothing serious to say!
	public class Solution extends GuessGame {
	    public int guessNumber(int n) {
	        int left = 1, right = n, mid;
	        while(left <= right) {
	            mid = left + (right - left) / 2;
	            int result = guess(mid);
	            if (result == 0) {
	                return mid;
	            } else if (result == 1) {
	                left = mid + 1;
	            } else {
	                right = mid - 1;
	            }
	        }
	        return left;
	    }
	}


34.
	public int[] searchRange(int[] nums, int target) {
        int leftIndex = 0, rightIndex = 0;
        int left = 0, right = nums.length - 1, mid = (left + right) / 2;
        while (!(left >= right)) {
            if (nums[mid] > target) {
                right = mid - 1;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
            mid = (left + right) / 2;
        }
        leftIndex = left;
        left = 0; right = nums.length - 1; mid = (left + right) / 2;
        while (!(left >= right)) {
            if (nums[mid] > target) {
                right = mid - 1;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                left = mid;
            }
            mid = (left + right) / 2;
        }
        rightIndex = right;
        return new int[]{leftIndex, rightIndex};
    }


    //another method
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        //use array initializaion
        if (nums == null || nums.length == 0) return res;
        int left = 0, right = nums.length - 1, mid;
        if (nums[left] > target || nums[right] < target) return res;
        //method 3 cannot deal with the condition that, 
        //out of range, smaller than the first one and larger than the last one

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (nums[left] != target) {
            return res;
        }
        res[0] = left;
        //start can be find at left index of method 3

        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }            
        }
        res[1] = right;
        //end can be find at the last index of method 3

        return res;
    }


658.
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
        LinkedList<Integer> res = new LinkedList<>();
        if (arr == null || arr.length == 0) return res;
        //casting, create LinkedList, return as a List

        int left = 0, right = arr.length - 1, mid = 0;
        if (arr[left] >= x) {
            while (left < k) {
                res.add(arr[left ++]);
            }
            return res;
        } else if (arr[right] <= x) {
            while (k > 0) {
                res.add(arr[arr.length - k]);
                k --;
            }   
            return res;
        }
        
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                break;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        if (arr[mid] != x) {
            mid = (Math.abs(arr[left] - x) < Math.abs(arr[right] - x)) ? left : right;
        }
        res.addLast(arr[mid]);
        left = mid - 1;
        right = mid + 1;
        k --;
        
        while (k > 0) {
            int leftVal = Integer.MAX_VALUE, rightVal = Integer.MAX_VALUE;
            //avoid keeping changing int value
            if (left >= 0) {
                leftVal = Math.abs(arr[left] - x);
            }
            if (right < arr.length) {
                rightVal = Math.abs(arr[right] - x);
            }
            if (leftVal <= rightVal) {
                res.addFirst(arr[left --]);
            } else {
                res.addLast(arr[right ++]);
            }
            k --;
        }
        
        return res;
    }


    //another method, quite clean and quicker
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;
        //right start position, making the code below will not throw exception
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x) { //this can cover the case of negative
                /*
                sub array length k + 1, check both end, if left diff > right diff
                eliminate [left, mid]
                */
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        //find the kth closest directly       
        
        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }


//8/14
162.
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

LintCode 447.
	//Q9, Seach in a big sorted array
	public int findNum(ArrayReader reader, int k) {
		if (reader.get(0) > k) return -1;

		int aim = 1;
		while (reader.get(aim) < k) {
			aim *= 2;
		}
		//key, you can set the seach range by log(k)

		if (reader.get(aim) == k) return aim;

		int left = 0, right = aim, mid, temp;
		while (left <= right) {
			mid = left + (right - left) / 2;
			temp = reader.get(mid);
			if (temp == k) return mid;
			else if (temp < k) left = mid + 1;
			else right = mid - 1;
		} 
		return -1;
	}


LintCode 183.
	//wood cut problem
	//O(nlog(len)) for time complexity
	//key here is to give a len limit by O(log(len)), this is done
	//by increase each time through times 2;
	public class Solution {
	    /**
	     * @param L: Given n pieces of wood with length L[i]
	     * @param k: An integer
	     * @return: The maximum length of the small pieces
	     */
	    public int woodCut(int[] L, int k) {
	        // write your code here
	        long boundaryLen = 1;
	        while (canBeDivided(L, boundaryLen, k)) {
	            boundaryLen *= 2;
	        }
	        if (boundaryLen == 1) return 0;
	        //conner case, do not forget!!!

	        long left = boundaryLen / 2, right = boundaryLen, mid;
	        //the length might beyond the int boundary
	        while (left <= right) {
	            mid = left + (right - left) / 2;
	            if (canBeDivided(L, mid, k)) {
	                left = mid + 1;
	            } else {
	                right = mid - 1;
	            }
	        }
	        return (int) right;
	        //int and long can transform to each other by adding (int) or (long)
	    }
	    
	    private boolean canBeDivided(int[] L, long len, int k) {
	        long temp = 0;
	        for (int each : L){
	            temp = temp + (each / len); 
	        }
	        return temp >= k;
	        //int and long can directly compare or add or minus
	        //the result return is long
	    } 
	}


33.
	class Solution {
    	public int search(int[] A, int target) {
	        if (A.length == 0) {return -1;}
	        int lo = 0;
	        int hi = A.length - 1;
	        while (lo < hi) {
	            int mid = (lo + hi) / 2;
	            if (A[mid] == target) return mid;

	            if (A[lo] <= A[mid]) {
	                if (target >= A[lo] && target < A[mid]) {
	                    hi = mid - 1;
	                } else {
	                    lo = mid + 1;
	                }
	            } else {
	                if (target > A[mid] && target <= A[hi]) {
	                    lo = mid + 1;
	                } else {
	                    hi = mid - 1;
	                }
	            }
	        }
	        return A[lo] == target ? lo : -1;
	    }
	}

	//by self, the method, less effective
	class Solution {
	    public int search(int[] A, int target) {
	        if (A == null || A.length == 0) return -1;
	        int left = 0, right = A.length - 1, mid;
	        while(left < right) {
	            mid = left + (right - left) / 2;
	            if (A[mid] >= A[left] && A[mid] > A[right]) left = mid + 1;
	            else right = mid;
	        }
	        if (A[left] > target || left > 0 && A[left - 1] < target || left == 0 && A[A.length - 1] < target) return -1;
	        if (left != 0 && A[0] <= target) {
	            return binarySearch(A, target, 0, left - 1);
	        }
	        return binarySearch(A, target, left, A.length - 1);
	    }
	    
	    private int binarySearch(int[] A, int target, int start, int end) {
	        int mid;
	        while (start <= end) {
	            mid = start + (end - start) / 2;
	            if (A[mid] == target) return mid;
	            else if (A[mid] < target) start = mid + 1;
	            else end = mid - 1;
	        }
	        return -1;
	    }
	}


35.
	//this problem is also the problem of finding the closest number in the array
	//primitive method, scan once
	class Solution {
	    public int searchInsert(int[] nums, int target) {
	        int index = 0;
	        for (int i = 0; i < nums.length; i ++){
	            if (nums[i] >= target){
	                index = i;
	                break;
	            }
	        }
	        if (nums[nums.length - 1] < target){
	            index = nums.length;
	        }
	        return index;
	    }
	}

	//binary search method to solve this problem
	class Solution {
	    public int searchInsert(int[] nums, int target) {
	        if (nums.length == 0 || nums[0] >= target) return 0;
	        //combine the corner cases, the finding case and not finding case
	        int left = 0, right = nums.length - 1, mid;
	        while(left < right) {
	            mid = left + (right - left) / 2;
	            if (nums[mid] == target) return mid;
	            else if (nums[mid] < target) left = mid + 1;
	            else right = mid;
	        }
	        return (nums[left] >= target) ? left : left + 1;
	    }
	}


81.
	//rotated array, consider the repeat elements
	//primiry solution
	class Solution {
	    public boolean search(int[] nums, int target) {
	        if (nums.length == 0) {return false;}
	        for (int each : nums) {
	            if (target == each) {return true;}
	        }
	        return false;
	    }
	}


	//my binary search version, based on finding the smallest
	class Solution {
	    public boolean search(int[] nums, int target) {
	        if (nums == null || nums.length == 0) return false;
	        int left = 0, right = nums.length - 1, mid;
	        while (left < right) {
	            if (nums[left] == nums[right]) {
	                left ++;
	            } else if (nums[left] < nums[right]) {
	                break;
	            } else {
	                mid = left + (right - left) / 2;
	                if (nums[mid] >= nums[left] && nums[mid] > nums[right]) left = mid + 1;
	                else right = mid;
	            }
	        }
	        while (left > 0 && nums[left] == nums[left - 1]) {
	            left --;
	        }
	        if (nums[left] > target || left > 0 && nums[left - 1] < target 
	            || left == 0 && nums[nums.length - 1] < target) return false;
	        if (nums[left] <= target && nums[nums.length - 1] >= target || left == 0) {
	        	//find in left --- nums.length - 1, including the left, so there is an equal sign
	            return bSearch(nums, target, left, nums.length - 1);
	        } else {
	        	//rule out the left
	            return bSearch(nums, target, 0, left - 1);
	        }
	    }
	    
	    private boolean bSearch(int[] nums, int target, int left, int right) {
	        int mid;
	        while (left <= right) {
	            mid = left + (right - left) / 2;
	            if (nums[mid] == target) return true;
	            else if (nums[mid] < target) left = mid + 1;
	            else right = mid - 1;
	        }
	        return false;
	    }
	}

	//binary search solution
	//give this solution as an example
	public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = -1;
        while(start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //If we know for sure right side is sorted or left side is unsorted
            if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            //If we know for sure left side is sorted or right side is unsorted
            } else if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            //If we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
            //any of the two sides won't change the result but can help remove duplicate from
            //consideration, here we just use end-- but left++ works too
            } else {
                end--;
            }
        }
        
        return false;
    }

    //another binary solution
    class Solution {
	    public boolean search(int[] nums, int target) {
	        if(nums == null || nums.length == 0){
	            return false;
	        }
	        
	        int low = 0, high = nums.length - 1;
	        while(high > low + 1){
	            int mid = low + (high - low) / 2;
	            
	            if(nums[low] == nums[high]){
	                if(target < nums[mid]){
	                    if(nums[mid] < nums[low]){
	                        high = mid;
	                    }else if(nums[mid] > nums[low]){
	                        if(target < nums[low]){
	                            low = mid;
	                        }else if(target > nums[low]){
	                            high = mid;
	                        }else{
	                            return true;
	                        }
	                    }else{
	                        low++;
	                    }
	                }else if(target > nums[mid]){
	                    if(nums[mid] < nums[low]){
	                        if(target < nums[low]){
	                            low = mid;
	                        }else if(target > nums[low]){
	                            high = mid;
	                        }else{
	                            return true;
	                        }
	                    }else if(nums[mid] > nums[low]){
	                        low = mid;
	                    }else{
	                        high--;
	                    }
	                }else{
	                    return true;
	                }
	            }else{
	                if(target < nums[mid]){
	                    if(nums[mid] < nums[low]){
	                        high = mid;
	                    }else if(nums[mid] > nums[low]){
	                        if(target > nums[low]){
	                            high = mid;
	                        }else if(target < nums[low]){
	                            low = mid;
	                        }else{
	                            return true;
	                        }
	                    }else{
	                        low = mid;
	                    }
	                }else if(target > nums[mid]){
	                    if(nums[mid] < nums[low]){
	                        if(target < nums[low]){
	                            low = mid;
	                        }else if(target > nums[low]){
	                            high = mid;
	                        }else{
	                            return true;
	                        }
	                    }else{
	                        low = mid;
	                    }
	                }else{
	                    return true;
	                }
	            }
	        }
	        
	        if(target == nums[low]){
	            return true;
	        }
	        
	        if(target == nums[high]){
	            return true;
	        }
	        
	        return false;
	    }
	}


300.
	//dynamic programming O(n^2)
	public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {return 0;}
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i ++) {
            int max = 1;
            dp[i] = 1;
            for (int j = 0; j < i; j ++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dp[j] + 1);
                    dp[i] = max;
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }

    //using dynamic programming and binary search
    //the key here:
    //this method only record the number (tails), smaller and index as the length
    class Solution {
	    public int lengthOfLIS(int[] nums) {
	        if (nums == null || nums.length == 0) return 0;
	        int[] res = new int[nums.length];
	        int size = 0;
	        for (int element : nums) {
	            int left = 0, right = size, mid;
	            //here, right is not including in the effect area
	            //[left, right - 1]
	            while (left < right) {
	                mid = left + (right - left) / 2;
	                if (res[mid] < element) {
	                    left = mid + 1;
	                } else {
	                    right = mid;
	                }
	            }
	            //the result of the while loop, three cases:
	            //One, element is beyond the boundary, left = right = size
	            //Two, element is inside the range, left = right ===> res[right] >= element
	            //Three, element is smaller than left, left = right ===> res[right] >= element
	            //Therefore, it can apply res[left] = element
	            res[left] = element;
	            //increase size if left == size
	            if (left == size) size ++;
	        }
	        return size;
	    }
	}


41.
	public int firstMissingPositive(int[] nums) {
		//corner case
		for (int i = 0; i < nums.length; i ++) {
			if (nums[i] != i + 1 && nums[i] > 0 && nums[i] <= nums.length) {
				if (nums[nums[i] - 1] == nums[i]) continue;
				int tmp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = tmp;
				i --;
			}
		}
		for (int i = 0; i < nums.length; i ++) {
			if (nums[i] != i + 1) return i + 1;
		}
		return nums.length + 1;
	}


//8/15
	public int[] myYao(){
		int[] trialRes = new int[2];
		trialRes[0] = yao();
		trialRes[1] = yao();
		if (trialRes[0] == trialRes[1]) return myYao();
		return trialRes;
	}


	public int random7(){
		int res = random5() * 5 + random5();
		if (res > 20) return random7();
		//while (res > 20) {
		//	res = random5() * 5 + random5();
		//}
		return res / 3;//res % 7 is also good
	}


//8/16
74.
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        
        int left = 0, right = matrix.length - 1, mid;
        while (matrix.length != 1 && left + 1 < right) {
            mid = left + (right - left) / 2;
            if (matrix[mid][0] == target) return true;
            else if (matrix[mid][0] < target) left = mid;
            else right = mid;
        }
        if (matrix[left][0] == target || matrix[right][0] == target) return true;
        if (matrix[left][0] > target) return false;
        
        int row = (matrix[right][0] < target) ? right : left;
        left = 0;
        right = matrix[0].length - 1;     
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) return true;
            else if (matrix[row][mid] > target) right = mid;
            else left = mid;
        }
        if (matrix[row][left] == target || matrix[row][right] == target) return true;
        
        return false;
    }

    //search through the row first, then the column
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rowLen = matrix.length, colLen = matrix[0].length;
        if (matrix[0][0] > target || matrix[rowLen - 1][colLen - 1] < target) return false;
        
        int left = 0, right = rowLen - 1, mid;
        while (left< right) {
            mid = left + (right - left) / 2;
            if (matrix[mid][0] == target) return true;
            else if (matrix[mid][0] < target) left = mid + 1;
            else right = mid;
        }
        
        if (matrix[left][0] == target) return true;
        if (matrix[left][0] > target) left --;
        
        int start = 0, end = colLen - 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (matrix[left][mid] == target) return true;
            else if (matrix[left][mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }

    //treat the matrix as a ascending array
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rowLen = matrix.length, colLen = matrix[0].length;
        if (matrix[0][0] > target || matrix[rowLen - 1][colLen - 1] < target) return false;
        
        int left = 0, right = rowLen * colLen - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (matrix[mid / colLen][mid % colLen] == target) return true;
            else if (matrix[mid / colLen][mid % colLen] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }


275.
	public int hIndex(int[] citations) {
        int hIndex = 0;
        for (int i = 0; i < citations.length; i ++) {
            if (citations[citations.length - 1 - i] > i) {
                hIndex = i + 1;
            }
        }
        return hIndex;
    }

    //using binary search
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int left = 0, right = citations.length - 1, mid = 0, len = citations.length;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (citations[mid] == len - mid) {
                return len - mid;
            } else if (citations[mid] < len - mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return len - left;
    }
/*
    IMPORTANT POINTS:
    1. [0, i) is of size i, [0, i] is of size i + 1;
    2. [i, len] is of size len - i + 1;
    3. [i, len) is of size len - i;
    4. H index: if citations[mid] >= len - mid, then
    	len - mid is a potential H index;
    5. Among these potential ones, if citations[mid] == len - mid,
    	len - mid is the largest potential H index;
*/


410.
	//binary search method
	//thinking the sum limit as an array, there is a change of state from 
	//not working as sum to can be seen as sum
	//therefore the binary seach can be applied to this problem
	class Solution {
	    public int splitArray(int[] nums, int m) {
	        if (nums.length == 0) return 0;
	        
	        int max = 0;
	        long sum = 0;
	        for (int each : nums) {
	            sum += each;
	            max = Math.max(max, each);
	        }
	        return binarySearch(max, sum, nums, m);
	        //one end for the search array is 
	        //the largest element among the array
	        //the other end for the array is
	        //the sum of all elements
	    }
	    
	    private int binarySearch(long left, long right, int[] nums, int m) {
	        long mid = 0;
	        //using long type to avoid adding overflow
	        while (left < right) {
	            mid = left + (right - left) / 2;
	            if (isValid(nums, m, mid)) {
	                right = mid;
	            } else {
	                left = mid + 1;
	            }
	        }
	        return (int) left;
	        //Two key points here:
	        //1. do not have to check the sum if it can be formed or not
	        //	what we are looking for is the lowest changing state number;
	        //2. do not have to check the left, because the number we are looking for
	        //	must be inside the range, cannot go beyond at the first place
	    }
	    
	    private boolean isValid(int[] nums, int m, long boundary) {
	    	//isValid method, checking if the sum can work as limit
	        long sum = 0; 
	        int count = 1;
	        for (int each : nums) {
	            sum += each;
	            if (sum > boundary) {
	                sum = each;
	                count ++;
	            }
	            if (count > m) return false;
	        }
	        return true;
	    }
	}


302.
	class Solution {
	    private int[][] move = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
	    private int[] area = new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
	    
	    public int minArea(char[][] image, int x, int y) {
	        if (image.length == 0 || image[0].length == 0) return 0;
	        
	        boolean[][] visited = new boolean[image.length][image[0].length];
	        helper(image, x, y, visited);
	        return (area[2] - area[0] + 1) * (area[3] - area[1] + 1);
	    }
	    
	    private void helper(char[][] image, int x, int y, boolean[][] visited) {
	        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length || visited[x][y] || image[x][y] == '0') return;
	        area[0] = Math.min(area[0], x);
	        area[1] = Math.min(area[1], y);
	        area[2] = Math.max(area[2], x);
	        area[3] = Math.max(area[3], y);
	        visited[x][y] = true;
	        for(int[] each : move) {
	            helper(image, x + each[0], y + each[1], visited);
	        }
	    }
	}

	//binary serach method
	//rows and cols, both from two ends to the point to search, if the matrix has '1'
	class Solution {
	    public int minArea(char[][] image, int x, int y) {
	        if (image == null || image.length == 0 || image[0].length == 0) return 0;
	        int cols = BSearch(false, y, image[0].length - 1, image, true) - BSearch(true, 0, y, image, true) + 1;
	        int rows = BSearch(false, x, image.length - 1, image, false) - BSearch(true, 0, x, image, false) + 1;
	        return cols * rows;
	    }
	    
	    private int BSearch(boolean fromZero, int start, int end, char[][] image, boolean isCol) {
	        int mid;
	        if (fromZero) {
	            while (start < end) {
	                mid = start + (end - start) / 2;
	                if (hasOne(mid, image, isCol)) {
	                    end = mid;
	                } else {
	                    start = mid + 1;
	                }
	            }
	            return start;
	        } else {
	            while (start < end) {
	                mid = start + (end - start) / 2;
	                if (hasOne(mid, image, isCol)) {
	                    start = mid + 1;
	                } else {
	                    end = mid;
	                }
	            } 
	            return (hasOne(start, image, isCol)) ? start : start - 1;
	        }
	    }
	    
	    private boolean hasOne(int mid, char[][] image, boolean isCol) {
	        if (isCol) {
	            for (int i = 0; i < image.length; i ++) {
	                if (image[i][mid] == '1') return true;
	            }
	        } else {
	            for (int i = 0; i < image[0].length; i ++) {
	                if (image[mid][i] == '1') return true;
	            }
	        }
	        return false;
	    }
	}


153.
	//original solution
	class Solution {
	    public int findMin(int[] num) {
	        if (num == null || num.length == 0) {
	            return 0;
	        }
	        if (num.length == 1) {
	            return num[0];
	        }
	        int start = 0, end = num.length - 1;
	        while (start <= end) {
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

	//use method 2, 
	class Solution {
	    public int findMin(int[] num) {
	        if (num == null || num.length == 0) return 0;
	        int left = 0, right = num.length - 1, mid;
	        while (left < right) {
	            mid = left + (right - left) / 2;
	            if (num[mid] >= num[left] && num[mid] > num[right]) left = mid + 1;
	            //because the left end is larger than the right end, so the equal to left should be count into the left win side
	            else right = mid;
	        }
	        return (num[left] <= num[0] && num[left] <= num[num.length - 1]) ? num[left] : num[0];
	        //rule out the possibility of left end is less than the right end
	    }
	}


154.
	//original method, primiry method
	class Solution {
	    public static int findMin(int[] num) {
	        int small = Integer.MAX_VALUE;
	        for ( int each : num) {
	            small = Math.min(small, each);
	        }
	        return small;
	    }
	}

	//binary search method, the key is to rule out the influence bringed by duplicate elements
	class Solution {
	    public static int findMin(int[] num) {
	        if (num == null || num.length == 0) return -1;
	        int left = 0, right = num.length - 1, mid;
	        while (left < right) {
	            if (num[left] == num[right]) {
	                left ++;
	            } else if (num[left] > num[right]) {
	                mid = left + (right - left) / 2;
	                if (num[mid] >= num[left] && num[mid] > num[right]) left = mid + 1;
	                else right = mid;
	            } else break;
	        }
	        //case 1: left keep adding, until left == right, in this case, min element is num[left]
	        //case 2: left keep adding, break the loop because it is less than num[right], in this case, min element is num[left]
	        //case 3: left and right keeping change because of BS, getting the last element, in this case, min element is num[left]	        
	        return num[left];
	    }
	}


/*
	selection sort is like keeping scanning and swapping the smallest element to the left
	merge sort ... 
	quick sort, see below code implementing
*/

	public void quickSort(int[] nums, int left, int right) {
		if (left >= right) return;
		int start = left, end = right, pivot = left ++;
		int temp;
		while (left <= right) {
			while (left <= right && nums[left] < nums[pivot]) {
				left ++;
			}
			while (right >= left && nums[right] > nums[pivot]) {
				right --;
			}
			if (left > right) break;
			temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
		}
		temp = nums[pivot];
		nums[pivot] = nums[right];
		nums[right] = temp;

		quickSort(nums, start, right - 1);
		quickSort(nums, right + 1, end);
	}


155.
	class MinStack {
	    
	    private Stack<Integer> st1;
	    private Stack<Integer> st2;

	    /** initialize your data structure here. */
	    public MinStack() {
	        st1 = new Stack<>();
	        st2 = new Stack<>();
	    }
	    
	    public void push(int x) {
	        st1.push(x);
	        if (st2.isEmpty() || st2.peek() >= x) {
	            st2.push(x);
	        }
	    }
	    
	    public void pop() {
	        int tmp = st1.pop();
	        if (tmp == st2.peek()) st2.pop();
	    }
	    
	    public int top() {
	        return st1.peek();
	    }
	    
	    public int getMin() {
	        return st2.peek();
	    }
	}



110.
	//my method
	class Solution {
	    public boolean isBalanced(TreeNode root) {
	        boolean[] res = new boolean[]{true};
	        depthCheck(root, res);
	        return res[0];
	    }
	    
	    private int depthCheck(TreeNode root, boolean[] res) {
	    	//can also use -1 as a signal
	        if (root == null || !res[0]) return 0;
	        int leftD = depthCheck(root.left, res);
	        int rightD = depthCheck(root.right, res);
	        if (Math.abs(leftD - rightD) > 1) res[0] = false;
	        return Math.max(leftD, rightD) + 1;
	    }
	}


101.
	//Symmetric tree
	//Recursively
	class Solution {
	    public boolean isSymmetric(TreeNode root) {
	        if (root == null) {return true;}
	        return helper(root.left, root.right);
	    }
	    
	    private boolean helper(TreeNode node1, TreeNode node2) {
	        if (node1 == null && node2 == null) return true;
	        if (node1 == null || node2 == null || node1.val != node2.val) return false;
	        return helper(node1.left, node2.right) && helper(node1.right, node2.left);
	    }
	}

	//Interatively
	class Solution {
	    public boolean isSymmetric(TreeNode root) {
	        if (root == null) {return true;}
	        TreeNode rootL = root.left, rootR = root.right;
	        Stack<TreeNode> stL = new Stack<>();
	        Stack<TreeNode> stR = new Stack<>();
	        while (rootL != null || rootR != null || !stL.isEmpty() || !stR.isEmpty()) {
	            if (rootL != null && rootR != null) {
	                if (rootL.val != rootR.val) return false;
	                stL.push(rootL.right);
	                stR.push(rootR.left);
	                rootL = rootL.left;
	                rootR = rootR.right;
	            } else if (rootL != null || rootR != null) {
	                return false;
	            } else {
	                rootL = stL.pop();
	                rootR = stR.pop();
	            }
	        }
	        return true;
	    }
	}


226.
	class Solution {
	    public TreeNode invertTree(TreeNode root) {
	        if (root == null) return root;
	        invert(root);
	        return root;
	    }
	    
	    private void invert(TreeNode root) {
	        if (root == null) return;
	        TreeNode tmp = root.left;
	        root.left = root.right;
	        root.right = tmp;
	        invert(root.left);
	        invert(root.right);
	    }
	}


572.
	class Solution {
	    public boolean isSubtree(TreeNode s, TreeNode t) {
	        if (t == null) return true;
	        if (s == null) return false;
	        boolean res = isSame(s, t);
	        if (!res) return isSubtree(s.left, t) || isSubtree(s.right, t);
	        return res;
	    }
	    
	    private boolean isSame(TreeNode s, TreeNode t) {
	        if (s == null && t == null) return true;
	        if (s == null || t == null || s.val != t.val) return false;
	        return isSame(s.left, t.left) && isSame(s.right, t.right);
	    }
	}


11.
	//two pointers, scan and keep the area
	//[i,j), i and j are index, the size of the range is j - i;
	class Solution {
	    public int maxArea(int[] height) {
	        int left = 0, right = height.length - 1, area = 0;
	        while (left < right) {
	            area = Math.max(Math.min(height[left], height[right]) * (right - left), area);
	            if (height[left] < height[right]) left ++;
	            else right --;
	        }
	        return area;
	    }
	}


LintCode 11.
	//the key is to cut some branches
	public class Solution {
	    /**
	     * @param root: param root: The root of the binary search tree
	     * @param k1: An integer
	     * @param k2: An integer
	     * @return: return: Return all keys that k1<=key<=k2 in ascending order
	     */
	    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
	        // write your code here
	        List<Integer> res = new ArrayList<>();
	        if (root == null || k2 < k1) return res;
	        searchAdd(root, k1, k2, res);
	        return res;
	    }
	    
	    private void searchAdd(TreeNode root, int k1, int k2, List<Integer> res) {
	        if (root == null) return;
	        if (root.val >= k1 && root.val <= k2) {
	            res.add(root.val);
	            searchAdd(root.left, k1, k2, res);
	            searchAdd(root.right, k1, k2, res);
	        } else if (root.val < k1) {
	            searchAdd(root.right, k1, k2, res);
	        } else {
	            searchAdd(root.left, k1, k2, res);
	        }
	    }
	}


700.
	//findint the target in the BST
	class Solution {
	    public TreeNode searchBST(TreeNode root, int val) {
	        if (root == null) return root;
	        if (root.val == val) return root;
	        else if (root.val > val) return searchBST(root.left, val);
	        else return searchBST(root.right, val);
	    }
	}


270.
	//finding the closest in the BST
	class Solution {
	    
	    private int record;
	    
	    public int closestValue(TreeNode root, double target) {
	        record = root.val;
	        helper(root, target);
	        return record;
	    }
	    
	    private void helper(TreeNode root, double target) {
	        if (root == null) return;
	        if (root.val == target) {
	            record = root.val;
	            return;
	        }
	        else if (root.val < target) {
	            if (Math.abs(record - target) > Math.abs(root.val - target)) record = root.val;
	            helper(root.right, target);
	        } else {
	            if (Math.abs(record - target) > Math.abs(root.val - target)) record = root.val;
	            helper(root.left, target);
	        }
	    }
	}


272.
	//find k closest elements
	//convert to array, use binary search to find k values
	class Solution {
		//the use of stack, keep insert treenode inthe gap
	    public List<Integer> closestKValues(TreeNode root, double target, int k) {
	        List<Integer> list = new ArrayList<>();
	        if (root == null || k == 0) return list;
	        
	        TreeNode cur = root;
	        Stack<TreeNode> prev = new Stack<>();
	        Stack<TreeNode> next = new Stack<>();
	        while (cur != null) {
	            if (cur.val <= target) {
	                prev.push(cur);
	                cur = cur.right;
	            } else {
	                next.push(cur);
	                cur = cur.left;
	            }
	        }
	        
	        while (k -- > 0) {
	            if (prev.isEmpty() && next.isEmpty()) return list;
	            else if (prev.isEmpty()) {
	                list.add(getNext(next));
	            } else if (next.isEmpty()) {
	                list.add(getPrev(prev));
	            } else if (Math.abs(prev.peek().val - target) < Math.abs(next.peek().val - target)) {
	                list.add(getPrev(prev));
	            } else {
	                list.add(getNext(next));
	            }
	        }
	        
	        return list;
	    }
	    
	    private int getPrev(Stack<TreeNode> prev) {
	        TreeNode popNode = prev.pop();
	        TreeNode cur = popNode.left;
	        while (cur != null) {
	            prev.push(cur);
	            cur = cur.right;
	        }
	        return popNode.val;
	    }
	    
	    private int getNext(Stack<TreeNode> next) {
	        TreeNode popNode = next.pop();
	        TreeNode cur = popNode.right;
	        while (cur != null) {
	            next.push(cur);
	            cur = cur.left;
	        }
	        return popNode.val;
	    }
	}


	//primative but effient method
	public class Solution {
	    public List<Integer> closestKValues(TreeNode root, double target, int k) {
	        List<Integer> res = new LinkedList<>();
	        inorder(res, root, target, k);
	        return res;
	    }
	    void inorder(List<Integer> res, TreeNode root, double target, int k){
	        if(root == null){
	            return;
	        }
	        inorder(res, root.left, target, k);
	        if(res.size() < k){
	            res.add(root.val);
	        }else{
	            if(Math.abs(res.get(0) - target) > Math.abs(root.val - target)){
	                res.remove(0);
	                res.add(root.val);
	            }
	        }
	        //scan all treenode, only keep the right one
	        inorder(res, root.right, target, k);
	    }
	   
	}





//Binary Search Tree Iterator
	public class BSTIterator {
	    
	    private Stack<TreeNode> st;
	    /*
	    * @param root: The root of binary tree.
	    */public BSTIterator(TreeNode root) {
	        // do intialization if necessary
	        st = new Stack<>();
	        while (root != null) {
	            st.push(root);
	            root = root.left;
	        }
	    }

	    /*
	     * @return: True if there has next node, or false
	     */
	    public boolean hasNext() {
	        // write your code here
	        return !st.isEmpty();
	    }

	    /*
	     * @return: return next node
	     */
	    public TreeNode next() {
	        // write your code here
	        TreeNode cur = st.pop();
	        TreeNode point = cur.right;
	        while (point != null) {
	            st.push(point);
	            point = point.left;
	        }
	        return cur;
	    }
	}


268.
	//bit operation, XOR, constant space
	//x ^ x = 0
	//0 ^ x = x
	//even nums --> 0
	//odd nums --> self, the request number
	class Solution {
	    public int missingNumber(int[] nums) {
	        int res = nums.length;
	        for (int i = 0; i < nums.length; i ++) {
	            res ^= nums[i];
	            res ^= i;
	        }
	        return res;
	    }
	}

	//Math solution, constant space
	class Solution {
	    public int missingNumber(int[] nums) {
	        int n = nums.length;
	        int sum = n * (n + 1) / 2;
	        for (int each : nums) {
	            sum -= each;
	        }
	        return sum;
	    }
	}


102.
	//level order tranverse, BFS
	class Solution {
	    public List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> res = new LinkedList<>();
	        Queue<TreeNode> queue = new LinkedList<>();
	        
	        if (root == null) {return res;}
	        queue.add(root);
	        
	        while(!queue.isEmpty()) {
	            int levelsum = queue.size();
	            List<Integer> temp = new LinkedList<>();
	            for (int i = 0; i < levelsum; i ++) {
	                if (queue.peek().left != null) {
	                    queue.add(queue.peek().left);
	                }
	                if (queue.peek().right != null) {
	                    queue.add(queue.peek().right);
	                }
	                temp.add(queue.poll().val);
	            }
	            res.add(temp);
	        }
	        return res;
	    }
	}

	//using two queues to implements BFS
	class Solution {
	    public List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        Queue<TreeNode> qu1 = new LinkedList<>();
	        Queue<TreeNode> qu2 = new LinkedList<>();
	        
	        if (root == null) return res;
	        qu1.offer(root);
	        
	        while (!qu1.isEmpty()) {
	            List<Integer> tmp = new ArrayList<>();
	            
	            while (!qu1.isEmpty()) {
	                TreeNode tmpNode = qu1.poll();
	                tmp.add(tmpNode.val);
	                if (tmpNode.left != null) qu2.offer(tmpNode.left);
	                if (tmpNode.right != null) qu2.offer(tmpNode.right);
	            }
	            
	            while (!qu2.isEmpty()) {
	                qu1.offer(qu2.poll());
	            }
	            
	            res.add(tmp);
	        }
	        
	        return res;
	    }
	}

	//using dfs to do level order tranverse
	class Solution {
	    public List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        dfsLevel(root, 0, res);
	        return res;
	    }
	    
	    private void dfsLevel(TreeNode root, int level, List<List<Integer>> res) {
	        if (root == null) return;
	        if (res.size() < level + 1) {
	            List<Integer> tmpList = new ArrayList<>();
	            res.add(tmpList);
	        }
	        res.get(level).add(root.val);
	        dfsLevel(root.left, level + 1, res);
	        dfsLevel(root.right, level + 1, res);
	    }
	}


107.
	//level order tranverse bottom up
	//key is using method 
	//Collections.reverse();
	//res.addFirst(); this method can only be used by LinkedList, not List
	//therefore need casting in the end
	class Solution {
	    public List<List<Integer>> levelOrderBottom(TreeNode root) {
	        LinkedList<List<Integer>> res = new LinkedList<>();
	        Queue<TreeNode> queue = new LinkedList<>();
	        
	        if (root == null) {return res;}
	        queue.add(root);
	        
	        while(!queue.isEmpty()) {
	            int levelsum = queue.size();
	            List<Integer> temp = new LinkedList<>();
	            for (int i = 0; i < levelsum; i ++) {
	                if (queue.peek().left != null) {
	                    queue.add(queue.peek().left);
	                }
	                if (queue.peek().right != null) {
	                    queue.add(queue.peek().right);
	                }
	                temp.add(queue.poll().val);
	            }
	            res.addFirst(temp);
	        }
	        return (List<List<Integer>>) res;
	    }
	}


314.
	//binary tree vertical order tranverse
	//pay attention to its request
	//need to use bfs instead of dfs here
	class Solution {
	    public List<List<Integer>> verticalOrder(TreeNode root) {
	        List<List<Integer>> res = new ArrayList<>();
	        if (root == null) return res;
	        
	        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
	        bfs(root, 0, map);
	        
	        for (Map.Entry<Integer, List<Integer>> each : map.entrySet()) {
	            res.add(each.getValue());
	        }
	        return res;
	    }
	    
	    private void bfs(TreeNode root, int vertical, TreeMap<Integer, List<Integer>> map) {
	        Queue<TreeNode> qu1 = new LinkedList<>();
	        Queue<Integer> qu2 = new LinkedList<>();
	        qu1.offer(root);
	        qu2.offer(vertical);
	        int size;
	        while (!qu1.isEmpty()) {
	            size = qu1.size();
	            for (int i = 0; i < size; i ++) {
	                TreeNode tmp = qu1.poll();
	                vertical = qu2.poll();
	                if (!map.containsKey(vertical)) {
	                    List<Integer> list = new ArrayList<>();
	                    map.put(vertical, list);
	                }
	                map.get(vertical).add(tmp.val);
	                if (tmp.left != null) {
	                    qu1.offer(tmp.left);
	                    qu2.offer(vertical - 1);
	                }
	                if (tmp.right != null) {
	                    qu1.offer(tmp.right);
	                    qu2.offer(vertical + 1);
	                }
	            }
	        }
	    }
	}


	//using a HashMap instead of the TreeMap
	//remember the min and max vertical value, loop in the end
	class Solution {
	    public List<List<Integer>> verticalOrder(TreeNode root) {
	        List<List<Integer>> result = new ArrayList<>();
	        
	        if (root == null) {
	            return result;
	        }
	        Map<Integer, List<Integer>> map = new HashMap<>();
	        int max = 0;
	        int min = 0;
	        
	        Queue<TreeNode> nodequeue = new LinkedList<>();
	        Queue<Integer> valuequeue = new LinkedList<>();
	        
	        nodequeue.offer(root);
	        valuequeue.offer(0);
	        
	        while (!nodequeue.isEmpty()) {
	            TreeNode node= nodequeue.poll();
	            int index = valuequeue.poll();
	            List<Integer> list= map.get(index);
	            if (list == null) {
	                list = new ArrayList<>();
	                map.put(index, list);
	            }
	            list.add(node.val);
	            max = Math.max(max, index);
	            min = Math.min(min, index);
	            if (node.left != null) {
	                nodequeue.offer(node.left);
	                valuequeue.offer(index - 1);
	                
	            }
	            if (node.right != null) {
	                nodequeue.offer(node.right);
	                valuequeue.offer(index + 1);
	            }
	        }
	        for (int i = min; i <= max; i++) {
	            List<Integer> list= map.get(i);
	            if (list != null) {
	                result.add(list);
	            }
	        }
	        return result;
	    }
	}


103.
	//using reverse to do zig zag level order tranverse
	class Solution {
	    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	        List<List<Integer>> res = new ArrayList<>();
	        if (root == null) return res;
	        
	        Queue<TreeNode> qu = new LinkedList<>();
	        qu.offer(root);
	        int size;
	        boolean oddLevel = true;
	        while (!qu.isEmpty()) {
	            List<Integer> tmpList = new ArrayList<>();
	            size = qu.size();
	            for (int i = 0; i < size; i ++) {
	                TreeNode tmpNode = qu.poll();
	                tmpList.add(tmpNode.val);
	                if (tmpNode.left != null) qu.offer(tmpNode.left);
	                if (tmpNode.right != null) qu.offer(tmpNode.right);
	            }
	            if (!oddLevel) {Collections.reverse(tmpList);}
	            res.add(tmpList);
	            oddLevel = !oddLevel;
	        }
	        
	        return res;
	    }
	}


	//using bfs, using add and addFirst zig zag
	class Solution {
	    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	        List<List<Integer>> res = new ArrayList<>();
	        if (root == null) return res;
	        
	        Queue<TreeNode> qu = new LinkedList<>();
	        qu.offer(root);
	        int size;
	        boolean isOddLevel = true;
	        
	        while (!qu.isEmpty()) {
	            size = qu.size();
	            LinkedList<Integer> list = new LinkedList<>();
	            for (int i = 0; i < size; i ++) {
	                TreeNode tmp = qu.poll();
	                if (isOddLevel) {
	                    list.add(tmp.val);
	                } else {
	                    list.addFirst(tmp.val);
	                }
	                if (tmp.left != null) qu.offer(tmp.left);
	                if (tmp.right != null) qu.offer(tmp.right);
	            }
	            //directly add list, for it will cast for you automatically
	            res.add(list);
	            isOddLevel = !isOddLevel;
	        }
	        
	        return res;
	    }
	}


//GeeksForGeeks
//validate if complete binary tree
//iteration method
	boolean isCompleteBT(Node root)
        {
          //add code here.
        if (root == null) return true;
        Queue<Node> qu = new LinkedList<>();
        qu.offer(root);
        //pay attention to put it into queue first
        boolean comeIntoNull = false;
        while (!qu.isEmpty()) {
            Node tmp = qu.poll();
            if (tmp != null) {
                if (comeIntoNull) return false;
                if (tmp.left == null) qu.offer(null);
                else qu.offer(tmp.left);
                if (tmp.right == null) qu.offer(null);
                else qu.offer(tmp.right);
            } else {
                comeIntoNull = true;
            }
        }
        return true;
	} 


286.
	//BFS solution
	//from the gate points
	//cost more memory
	//remember to add visited[][]
	class Solution {
	    private int[][] around = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
	    
	    public void wallsAndGates(int[][] rooms) {
	        //corner cases
	        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
	        
	        Queue<Integer> quRow = new LinkedList<>();
	        Queue<Integer> quCol = new LinkedList<>();
	        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
	        
	        //loop around the rooms
	        //do bfs at gate points
	        for (int i = 0; i < rooms.length; i ++) {
	            for (int j = 0; j < rooms[0].length; j ++) {
	                if (rooms[i][j] == 0) {
	                    quRow.offer(i);
	                    quCol.offer(j);
	                }
	            }
	        }
	        
	        int size, distance = 1, row, col;
	        while (!quRow.isEmpty()) {
	            
	            size = quRow.size();
	            
	            //get the point
	            for (int i = 0; i < size; i ++) {
	                row = quRow.poll();
	                col = quCol.poll();
	                visited[row][col] = true;

	                //loop around the point
	                //update the distance and add points to queue
	                for (int[] each : around) {
	                    int newRow = each[0] + row;
	                    int newCol = each[1] + col;
	                    if (newRow < 0 || newRow >= rooms.length 
	                        || newCol < 0 || newCol >= rooms[0].length 
	                        || rooms[newRow][newCol] == -1 || visited[newRow][newCol]) continue;
	                    if (rooms[newRow][newCol] > distance) rooms[newRow][newCol] = distance;
	                    quRow.offer(newRow);
	                    quCol.offer(newCol);
	                }
	            }
	            
	            //add distance
	            distance ++;
	        }
	    }
	}



	//DFS solution
	//faster? maybe
	//cost more stack, may cause stackoverflow
	class Solution {
	    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	    //do not have to write new int[][], but why???

	    public void wallsAndGates(int[][] rooms) {
	        // all source shortest path
	        for (int i = 0; i < rooms.length; i++) {
	            for (int j = 0; j < rooms[0].length; j++) {
	                if (rooms[i][j] == 0) {
	                     dfs(rooms, i, j);
	                }
	               
	            }
	        }
	        
	    }

	    private void dfs(int[][] rooms, int i, int j) {
	            for (int[] dir : dirs) {
	                int x = dir[0] + i;
	                int y = dir[1] + j;
	                if (x >= 0 && x < rooms.length && y >= 0 
	                	&& y < rooms[0].length && rooms[x][y] > rooms[i][j] + 1) {
	                	//do not have to add visited[][] in dfs method here???
	                    rooms[x][y] = rooms[i][j] + 1;
	                    dfs(rooms, x, y);
	                
	            }
	        }
	    }
	}



78.
	//subsets, no duplicate number at first
	//find all subsets, no duplicate numbers
	//do not have to add boolean[] visited
	class Solution {
	    public List<List<Integer>> subsets(int[] nums) {
	        List<List<Integer>> res = new ArrayList<>();
	        dfs(res, new ArrayList<>(), nums, 0);
	        return res;
	    }
	    
	    private void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, int start) {
	        res.add(new ArrayList<Integer>(list));
	        for (int i = start; i < nums.length; i ++) {
	            list.add(nums[i]);	        
	            dfs(res, list, nums, i + 1);	            
	            list.remove(list.size() - 1);	            
	        }
	    }
	}
	//dfs tree, each node is the result, so no if statement for the result
	//add, remove, they are the key steps for dfs backward
	//using start and for loop, step over some possible number


	//another method for 78, subsets
	//do not need for loop here, add number directly
	class Solution {
	    public List<List<Integer>> subsets(int[] nums) {
	        List<List<Integer>> res = new ArrayList<>();
	        dfs(res, new ArrayList<>(), nums, 0);
	        return res;
	    }
	    
	    private void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, int start) {
	        if (start == nums.length) {
	            res.add(new ArrayList<>(list));
	            return;
	        }
	        list.add(nums[start]);
	        dfs(res, list, nums, start + 1);//case for adding number
	        list.remove(list.size() - 1);
	        dfs(res, list, nums, start + 1);//case for not adding number
	    }
	}
	//for loop will create more lists than needed
	//that is, they are all connnected to the root points, so no need for for loop 
	//to switch the branch


	//BFS method
	class Solution {
	    public List<List<Integer>> subsets(int[] nums) {
	        List<List<Integer>> res = new ArrayList<>();
	        res.add(new ArrayList<>());
	        int size;
	        for (int i = 0; i < nums.length; i ++) {
	            size = res.size();
	            for (int j = 0; j < size; j ++) {
	                List<Integer> tmpList = res.get(0);
	                res.remove(0);
	                res.add(new ArrayList<>(tmpList));
	                tmpList.add(nums[i]);
	                res.add(new ArrayList<>(tmpList));
	            }
	        }
	        return res;
	    }
	}


90.	
	//subsets, contains duplicate numbers
	class Solution {
	    public List<List<Integer>> subsetsWithDup(int[] nums) {
	        List<List<Integer>> res = new ArrayList<>();
	        Arrays.sort(nums);
	        dfs(res, new ArrayList<>(), nums, 0);
	        return res;
	    }
	    
	    private void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, int start) {
	        res.add(new ArrayList<>(list));
	        for (int i = start; i < nums.length; i ++) {
	            if (i > start && nums[i] == nums[i - 1]) continue;
	            //only calculate once
	            list.add(nums[i]);
	            dfs(res, list, nums, i + 1);
	            list.remove(list.size() - 1);
	        }
	    }
	}



20.
	//better method, use a stack
	//check isValid parenthese
	class Solution {
	    public boolean isValid(String s) {
	        if (s == null || s.length() == 0) return true;
	        Stack<Character> st = new Stack<>();
	        for (char each : s.toCharArray()) {
	            if (each == '(' || each == '[' || each == '{') st.push(each);
	            else {
	                if (st.isEmpty()) return false;
	                char tmp = st.pop();
	                if (each == ')' && tmp != '(') return false;
	                if (each == ']' && tmp != '[') return false;
	                if (each == '}' && tmp != '{') return false;
	            }
	        }
	        return st.isEmpty();
	    }
	}


39.
	//combination sum
	//with repeat numbers possible
	//can only use for loop not switch branches
	class Solution {
	    public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<List<Integer>> res = new ArrayList<>();
	        dfs(res, new ArrayList<>(), target, candidates, 0);
	        return res;
	    }
	    
	    private void dfs(List<List<Integer>> res, List<Integer> list, int target, int[] candidates, int start) {
	        if (target == 0) {
	            res.add(new ArrayList<>(list));
	            return;
	        }
	        for (int i = start; i < candidates.length; i ++) {
	            if (target - candidates[i] >= 0) {
	                list.add(candidates[i]);
	                dfs(res, list, target - candidates[i], candidates, i);
	                list.remove(list.size() - 1);
	            }
	        }
	    } 
	}


40.
	//combination sum II
	//can only use once for each number, may contains duplicate elements in the init array
	class Solution {
	    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	        List<List<Integer>> res = new ArrayList<>();
	        Arrays.sort(candidates);
	        dfs(res, new ArrayList<>(), candidates, new boolean[candidates.length], target, 0);
	        return res;
	    }
	    
	    private void dfs(List<List<Integer>> res, List<Integer> list, int[] candidates, boolean[] visited, int target, int start) {
	        if (target == 0) {
	            res.add(new ArrayList<>(list));
	            return;
	        }
	        for (int i = start; i < candidates.length; i ++) {
	            if (i > start && candidates[i] == candidates[i - 1]) continue;
	            //for the duplicate conditions, cut the first level branch
	            if (target - candidates[i] >= 0 && !visited[i]) {
	                list.add(candidates[i]);
	                visited[i] = true;
	                dfs(res, list, candidates, visited, target - candidates[i], i + 1);
	                //use i + 1 here, for each element can only use once!
	                list.remove(list.size() - 1);
	                visited[i] = false;
	            }
	        }
	    }
	}



216.
	//combination sum III
	//dfs method to solve it
	//add some break can shorten the time spent
	class Solution {
	    public List<List<Integer>> combinationSum3(int k, int n) {
	        List<List<Integer>> res = new ArrayList<>();
	        dfs(res, new ArrayList<>(), k, 1, n);
	        return res;
	    }
	    
	    private void dfs(List<List<Integer>> res, List<Integer> list, int k, int start, int n) {
	        int len = list.size();
	        if (len == k && n == 0) {
	            res.add(new ArrayList<>(list));
	            return;
	        }
	        for (int i = start; i <= 9; i ++) {
	            if (len < k && n > 0) {
	                list.add(i);
	                dfs(res, list, k, i + 1, n - i);
	                list.remove(list.size() - 1);
	            }
	        }
	    } 
	}


377.
	//combination sum IV
	//init array, all positive and no duplicate
	//can use multiple times for one number and different sequence is different combination
	//method 1, might be slower
	class Solution {
	    public int combinationSum4(int[] nums, int target) {
	        int[] dp = new int[target + 1];
	        int min = Integer.MAX_VALUE;
	        for (int each : nums) {
	            min = Math.min(each, min);
	            if (each <= target) dp[each] = 1;
	        }
	        for (int i = min + 1; i <= target; i ++) {
	            for (int each : nums) {
	                if (i - each >= min) {
	                    dp[i] += dp[i - each];
	                }
	            }
	        }
	        return dp[target];
	    }
	}



47.
	//permutation with duplicate number
	class Solution {
	    public List<List<Integer>> permuteUnique(int[] nums) {
	        List<List<Integer>> res = new ArrayList<>();
	        Arrays.sort(nums);
	        dfs(res, new ArrayList<>(), nums, new boolean[nums.length]);
	        return res;
	    }
	    
	    private void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] visited) {
	        if (list.size() == nums.length) {
	            res.add(new ArrayList<>(list));
	            return;
	        }
	        for (int i = 0; i < nums.length; i ++) {
	            if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
	            //key step to skip over the duplicate number
	            //different with combination, combination with start index
	            //permutation look at the number before itself
	            list.add(nums[i]);
	            visited[i] = true;
	            dfs(res, list, nums, visited);
	            visited[i] = false;
	            list.remove(list.size() - 1);
	        }
	    }
	}


//Bit operations:
	public String binaryConversion(int nums) {
		StringBuilder sb = new StringBuilder();
		while (nums > 0) {
			sb.append(nums % 2);
			nums /= 2;
		}
		return sb.reverse().toString();
	}


217.
	//find duplicate 1
	//method: use Set API
	//set api, add successful ==> true, Or false
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int each : nums) {
            boolean res = set.add(each);
            if (!res) return true;
        }
        return false;
    }

219.
	//use HashMap, key is the value and value is the index



190.
	//reverse bits
	public class Solution {
    // you need treat n as an unsigned value
	    public int reverseBits(int n) {
	        int res = 0;
	        for (int i = 0; i < 32; i ++) {
	            res <<= 1;
	            res += (n >> i) & 1;
	        }
	        return res;
	    }
	}


7.
	//reverse integer
	class Solution {
	    public int reverse(int x) {
	        boolean lessTz= x < 0 ? true : false;
	        x = Math.abs(x);
	        long res = 0;
	        while (x > 0) {
	            res *= 10;
	            res += x % 10;
	            x /= 10;
	        }
	        if (lessTz) res *= -1;
	        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) return 0;
	        return (int) res;
	        //must use (int) to convert long to int
	        //cannot use the default, default is for int convert to long
	    }
	}


344.
	//reverse string
	class Solution {
	    public static String reverseString(String s) {
	        char[] ch = s.toCharArray();
	        int halfLength = s.length() / 2;
	        char temp;
	        for (int i = 0; i < halfLength; i++) {
	            temp = ch[s.length() - 1 - i];
	            ch[s.length() - 1 - i] = ch[i];
	            ch[i] = temp;
	        }
	        return new String(ch);
	    }
	}


26.
	//old version
	class Solution {
	    public int removeDuplicates(int[] nums) {
	        if (nums.length <= 1) {return nums.length;}
	        int counter = 1;
	        for (int i = 1; i < nums.length; i ++) {
	            if (nums[i - 1] != nums[i]) {
	                nums[counter] = nums[i];
	                counter ++;
	            }
	        }
	        return counter;
	    }
	}

	//new version
	class Solution {
	    public int removeDuplicates(int[] nums) {
	        int slow = 0, fast = 0;
	        while (fast < nums.length) {
	            if (!(slow > 0 && nums[fast] == nums[slow - 1])) {
	                nums[slow ++] = nums[fast];
	            }
	            fast ++;
	        }
	        return slow;
	    }
	}


80.
	//remove and keep at least 2
	//another written version of slow and fast pointers
	class Solution {
	    public int removeDuplicates(int[] nums) {
	        int i = 0;
	        for (int n : nums)
	            if (i < 2 || n > nums[i-2])
	                nums[i++] = n;
	        return i;
	    }
	}

	//another method, slow and fast pointers
	class Solution {
	    public int removeDuplicates(int[] nums) {
	        int slow = 0, fast = 0;
	        while (fast < nums.length) {
	            if (!(slow >= 2 && nums[fast] == nums[slow - 2])) {
	                nums[slow ++] = nums[fast];
	            }
	            fast ++;
	        }
	        return slow;
	    }
	}


//remove duplicate with no one remaining
	//pay attention to the case where the duplicates are in the end of the array
	//in that case, check the flag in the end, for it will not loop and check 
	public class Solution {
	    public static void main (String[] args) {
	        int[] case1 = {1 , 2, 3, 4};
	        int[] case2 = {2,2,2,3,4};
	        int[] case3 = {3,4,5,5,5,5};
	        int[] case4 = {1,1,1,1};
	        System.out.println("\ncase1: " + remove(case1) + " " + Arrays.toString(case1));
	        System.out.println("\ncase2: " + remove(case2) + " " + Arrays.toString(case2));
	        System.out.println("\ncase3: " + remove(case3) + " " + Arrays.toString(case3));
	        System.out.println("\ncase4: " + remove(case4) + " " + Arrays.toString(case4));
	    }

	    private static int remove(int[] nums) {
	        int slow = 0, fast = 0;
	        boolean flag = false;
	        while (fast < nums.length) {
	            if (flag) {
	                if (nums[fast] != nums[slow - 1]) {
	                    slow --;
	                    fast --;
	                    flag = false;
	                }
	            } else {
	                if (!(slow > 0 && nums[fast] == nums[slow - 1])) {
	                    nums[slow ++] = nums[fast];
	                } else {
	                    flag = true;
	                }
	            }
	            fast ++;
	        }
	        return (flag) ? slow - 1 : slow;
	    }
	}



796.
	//rotate string
	class Solution {
	    public boolean rotateString(String A, String B) {
	        return A.length() == B.length() && (A + A).contains(B);
	        //(B + B).contains(A) also work
	    }
	}


189.
	//rotate array
	//three parts rotation
	class Solution {
	    public void rotate(int[] nums, int k) {
	        k %= nums.length;
	        if (k != 0){
	            reverse(nums, 0, nums.length);
	            reverse(nums, 0, k);
	            reverse(nums, k, nums.length);   
	        }        
	    }
	    
	    private void reverse(int[] nums, int start, int end){
	        end --;
	        int temp;
	        while (start < end){
	            temp = nums[start];
	            nums[start] = nums[end];
	            nums[end] = temp;
	            start ++;
	            end --;
	        }
	    } 
	}


648.
	//the application of Trie Tree
	class Solution {
	    public String replaceWords(List<String> dict, String sentence) {
	        TrieNode root = buildTrie(dict);
	        String[] words = sentence.split(" ");
	        for (int i = 0; i < words.length; i ++) {
	            words[i] = replace(root, words[i]);
	        }
	        return String.join(" ", words);
	    }
	    
	    private String replace(TrieNode root, String s) {
	        char[] arr = s.toCharArray();
	        for (int i = 0; i < arr.length; i ++) {
	            if (root.children[arr[i] - 'a'] == null) break; 
	            root = root.children[arr[i] - 'a'];
	            if (root.isWord) return new String(arr, 0, i + 1);
	        }
	        return s;
	    }
	    
	    
	    private TrieNode buildTrie(List<String> dict) {
	        TrieNode root = new TrieNode(' ');
	        for (String word : dict) {
	            TrieNode tmp = root;
	            for (char c : word.toCharArray()) {
	                if (tmp.children[c - 'a'] == null) {
	                    tmp.children[c - 'a'] = new TrieNode(c);
	                }
	                tmp = tmp.children[c - 'a'];
	            }
	            tmp.isWord = true;
	        }
	        return root;
	    }
	    
	}

	class TrieNode {
	    char val;
	    TrieNode[] children;
	    boolean isWord;
	    
	    public TrieNode(char val) {
	        this.val = val;
	        children = new TrieNode[26];
	        isWord = false;
	    }
	}


91.
	//dp
	//dp method for replace string problems
	class Solution {
	    public int numDecodings(String s) {
	        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
	        
	        char[] chars = s.toCharArray();      
	        int[] dp = new int[chars.length + 1];
	        dp[1] = 1;
	        dp[0] = 1;
	        
	        for (int i = 2; i < dp.length; i ++) {
	            if (chars[i - 1] == '0' && chars[i - 2] <= '2' && chars[i - 2] > '0') {
	                dp[i] = dp[i - 2];
	            } else if (chars[i - 1] == '0') {
	                return 0;
	            } else if (chars[i - 2] == '1' || chars[i - 2] == '2' && chars[i - 1] <= '6') {
	                dp[i] = dp[i - 1] + dp[i - 2];
	            } else {
	                dp[i] = dp[i - 1];
	            }
	        }
	        
	        return dp[chars.length];
	    }
	}


38.
	//recursion
	class Solution {
	    public String countAndSay(int n) {
	        if (n == 1) {return "1";}

	        String temp = countAndSay(n - 1);
	        //recursively solving the problems

	        char[] tempChar = temp.toCharArray();
	        char nowCheck = tempChar[0];
	        int num = 0;
	        String res = "";
	        for (char each : tempChar) {
	            if (each == nowCheck) {
	                num ++;
	            }
	            else {
	                res = res + num + nowCheck;
	                nowCheck = each;
	                num = 1;
	            }
	        }
	        res = res + num + nowCheck;
	        return res;
	    }
	}



28.
	//check if a is b's substring
	//method 1
	//while loop, inside is the for loop,
	//do not change hP, that is the recorder
	//use nP to loop
	class Solution {
	    public int strStr(String haystack, String needle) {
	        if (needle == null || needle.length() == 0) return 0;
	        if (haystack == null || haystack.length() == 0) return -1;
	        
	        int hP = 0, nP = 0, len = haystack.length();
	        
	        while (hP < len) {
	            if (haystack.charAt(hP) == needle.charAt(nP)) {
	                for (; nP < needle.length() && hP + nP < len; nP ++) {
	                    if (haystack.charAt(hP + nP) != needle.charAt(nP)) {
	                        break;
	                    }
	                    if (haystack.charAt(hP + nP) == needle.charAt(nP) 
	                        && nP == needle.length() - 1) {
	                        return hP;
	                    }
	                }
	                nP = 0;
	            }
	            hP ++;
	        }
	        
	        return -1;
	    }
	}


	//method 2
	//using hash, 0~25, 26 for a level
	//constantly sliding window hash calculation
	class Solution {
	    public int strStr(String haystack, String needle) {
	        if (needle == null || needle.length() == 0) return 0;
	        if (haystack == null || haystack.length() == 0 || haystack.length() < needle.length()) return -1;
	        
	        char[] pattern = needle.toCharArray();
	        char[] input = haystack.toCharArray();
	        
	        long pSum = hashChar(pattern, 0, pattern.length - 1);
	        int lenH = haystack.length(), lenN = needle.length(); 
	        
	        long init = 0;
	        for (int i = 0; i <= lenH - lenN; i ++) {
	            init = hashChar(input, i, i + lenN - 1);
	            if (init == pSum) return i;
	        }
	        
	        return -1;
	    }
	    
	    //this method of hashing is for check each position
	    //every position must be the same
	    private long hashChar(char[] arr, int start, int end) {
	        long sum = 0;
	        for (int i = start; i <= end; i ++) {
	            sum *= 26;
	            sum += arr[i] - 'a';
	        }
	        return sum;
	    }
	}



5.
	//using dp
	class Solution {
	    public String longestPalindrome(String s) {
	        char[] sArr = s.toCharArray();
	        int stringLen = sArr.length;
	        if (stringLen == 0) return s;
	        int start = 0;
	        int end = 0;
	        
	        boolean[][] dp = new boolean[stringLen][stringLen];
	        for (int i = 0; i < stringLen; i ++) dp[i][i] = true;
	        for (int len = 1; len < stringLen; len ++) {
	            for (int i = 0; i < stringLen - len; i ++) {
	                if (len == 1) {
	                    if (sArr[i] == sArr[i + len]) {
	                        dp[i][i + len] = true;
	                        start = i;
	                        end = i + len;
	                    }
	                }
	                else {
	                    if (sArr[i] == sArr[i + len] && dp[i + 1][i + len - 1]) {
	                        dp[i][i + len] = true;
	                        if (end - start < len) {
	                            start = i;
	                            end = i + len;
	                        }
	                    }
	                }
	            }
	        }
	        
	        String res = s.substring(start, end + 1);
	        return res;
	    }
	}


	//another writing of dp
	class Solution {
	    public String longestPalindrome(String s) {
	        char[] sArr = s.toCharArray();
	        int stringLen = sArr.length;
	        if (stringLen == 0) return s;
	        
	        boolean[][] dp = new boolean[stringLen][stringLen];
	        int start = Integer.MAX_VALUE, recordLen = 0;
	        for (int len = 1; len <= stringLen; len ++) {
	            for (int i = 0; i + len <= stringLen; i ++) {
	                if (len == 1 || len == 2 && sArr[i] == sArr[i + len - 1] ||
	                   sArr[i] == sArr[i + len - 1] && dp[i + 1][i + len - 2]) {
	                    dp[i][i + len - 1] = true;
	                    if (recordLen < len) {
	                        start = i;
	                        recordLen = len;
	                    }
	                }
	            }
	        }
	        
	        return new String(sArr, start, recordLen);
	    }
	}


	//another way, similar to dp, but do not have do multiple work
	class Solution {
	    private int start = 0, recordLen = 0;
	    
	    public String longestPalindrome(String s) {
	        int sLen = s.length();
	        if (sLen <= 1) return s;
	        
	        for (int i = 0; i < sLen; i ++) {
	            help(s, i, i, sLen);
	            help(s, i, i + 1, sLen);
	        }
	        
	        return s.substring(start, recordLen + start);
	        
	    }
	    
	    private void help(String s, int left, int right, int sLen) {
	        while (left >= 0 && right < sLen && s.charAt(left) == s.charAt(right)) {
	            left --;
	            right ++;
	        }
	        left ++;
	        right --;
	        
	        int maxLength = right - left + 1;
	        if (maxLength > recordLen) {
	            start = left;
	            recordLen = maxLength;
	        }
	    }
	}


3.
	//use boolean array can reduce time
	class Solution {
	    public int lengthOfLongestSubstring(String s) {
	        if (s.length() <= 1) return s.length();
	        
	        Set<Character> set = new HashSet<>();
	        int max = 0;
	        int left = 0, right = 0;
	        for (; right < s.length(); right ++) {
	            char tmp = s.charAt(right);
	            if (set.contains(tmp)) {
	                while (s.charAt(left) != tmp) {
	                    set.remove(s.charAt(left));
	                    left ++;
	                }
	                left ++;
	            } else {
	                set.add(tmp);
	                max = Math.max(set.size(), max);
	            }
	        }
	        
	        return max;
	    }
	}



141.
	//without extra space
	//find if cycle
	public class Solution {
	    public boolean hasCycle(ListNode head) {
	        if (head == null || head.next == null) return false;
	        
	        ListNode fast = head;
	        ListNode slow = head;
	        while (fast != null && fast.next != null) {
	            fast = fast.next.next;
	            slow = slow.next;
	            if (slow == fast) return true;
	        }
	        
	        return false;
	    }
	}

142.
	//find the cycle start point
	public class Solution {
	    public ListNode detectCycle(ListNode head) {
	        if (head == null || head.next == null) return null;
	        
	        ListNode fast = head;
	        ListNode slow = head;
	        while (fast != null && fast.next != null) {
	            fast = fast.next.next;
	            slow = slow.next;
	            if (slow == fast) {
	                ListNode one = head;
	                while (fast != one) {
	                    fast = fast.next;
	                    one = one.next;
	                }
	                return one;
	            }
	        }
	        
	        return null;
	    }
	}


160.
	//find the intersection node
	public class Solution {
	    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        if (headA == null || headB == null) return null;
	        
	        ListNode pointerA = headA, pointerB = headB;
	        int times = 2;
	        //avoid infinite loop
	        while (pointerA != pointerB && times > 0) {
	            if (pointerA.next == null) {
	                pointerA = headB;
	                times --;
	            } else {
	                pointerA = pointerA.next;
	            }
	            if (pointerB.next == null) {
	                pointerB = headA;
	            } else {
	                pointerB = pointerB.next;
	            }
	        }
	        return pointerA == pointerB ? pointerA : null;
	        //final test
	    }
	}


147.
	//insert node
	//better method
	class Solution {
	    public ListNode insertionSortList(ListNode head) {
	        if (head == null || head.next == null) return head;
	        ListNode dum = new ListNode(0);
	        dum.next = head;
	        ListNode pre, temp = null;
	        ListNode cur = head;
	        while (cur != null && cur.next != null) {
	            if (cur.val <= cur.next.val) cur = cur.next;
	            else {
	                pre = dum;
	                temp = cur.next;
	                cur.next = temp.next;
	                while (temp.val >= pre.next.val) pre = pre.next;
	                temp.next = pre.next;
	                pre.next = temp;
	            }
	        }
	        return dum.next;
	    }
	}


237.
	//delete the given node in the linkedlist
	class Solution {
	    public void deleteNode(ListNode node) {
	        node.val = node.next.val;
	        while (node.next.next != null) {
	            node.val = node.next.val;
	            node = node.next;
	        }
	        //move the value left
	        node.val = node.next.val;
	        node.next = null;
	        //delete the last one
	        //before that, move
	    }
	}


83.
	//remove duplicate in sorted list
	//with only one left
	class Solution {
	    public ListNode deleteDuplicates(ListNode head) {
	        if (head == null) return head;
	        ListNode cur = head;
	        int record = cur.val;;
	        while (cur != null && cur.next != null) {
	            if (cur.next.val == record) {
	                cur.next = cur.next.next;
	            } else {
	                cur = cur.next;
	                record = cur.val;
	            }
	            //cannot move the pointer now!!!
	        }
	        return head;
	    }
	}


82.
	//remove duplicate in sorted list
	//with 0 left
	class Solution {
	    public ListNode deleteDuplicates(ListNode head) {
	        if (head == null || head.next == null) return head;
	        
	        ListNode dummy = new ListNode(0);
	        dummy.next = head;
	        ListNode cur = head, prev = dummy;
	        int record = head.val;
	        
	        while (cur != null && cur.next != null) {
	            if (cur.next.val != record) {
	                cur = cur.next;
	                prev = prev.next;
	                record = cur.val;
	            } else {
	                while (cur != null && cur.val == record) cur = cur.next;
	                prev.next = cur;
	                if (cur != null) record = cur.val;
	            }
	        }
	        
	        return dummy.next;
	    }
	}


328.
	//list even and odd partition
	class Solution {
	    public ListNode oddEvenList(ListNode head) {
	        if (head == null || head.next == null) return head;
	        
	        ListNode oddPointer = head, evenPointer = head.next, evenHead = head.next;
	        //why store such a pointer?
	        
	        while (evenPointer != null && evenPointer.next != null) {
	            oddPointer.next = evenPointer.next;
	            oddPointer = oddPointer.next;
	            evenPointer.next = oddPointer.next;
	            evenPointer = evenPointer.next;
	        }
	        
	        oddPointer.next = evenHead;
	        
	        return head;
	    }
	}


415.
	//add two string
	class Solution {
	    public String addStrings(String num1, String num2) {
	        StringBuilder res = new StringBuilder();
	        int pointer1 = num1.length() - 1, pointer2 = num2.length() - 1, overflow = 0, number1, number2;
	        
	        while (pointer1 >= 0 || pointer2 >= 0) {
	            if (pointer1 >= 0 && pointer2 >= 0) {
	                number1 = num1.charAt(pointer1) - '0';
	                number2 = num2.charAt(pointer2) - '0';
	            } else if (pointer1 >= 0) {
	                number1 = num1.charAt(pointer1) - '0';
	                number2 = 0;
	            } else {
	                number1 = 0;
	                number2 = num2.charAt(pointer2) - '0';
	            }
	            int sum = number1 + number2 + overflow;
	            overflow = sum / 10;
	            sum %= 10;
	            res.append(sum);
	            pointer1 --;
	            pointer2 --;
	        }
	        
	        if (overflow > 0) res.append(overflow);
	        return res.reverse().toString();
	    }
	}


55.
	//jump game
	//greedy method or dp
	class Solution {
	    public boolean canJump(int[] nums) {
	        int max = 0;
	        for (int i = 0; i < nums.length && i <= max; i ++) {
	            max = Math.max(max, i + nums[i]);
	        }
	        return max >= nums.length - 1;
	    }
	}

45.
	//jump game II
	//greedy method, record the number of turns
	class Solution {
	    public int jump(int[] nums) {
	        int max = 0, turn = 0, pointer = 0;
	        while (max < nums.length - 1) {
	            int tmpLimit = max;
	            for (; pointer <= tmpLimit && pointer < nums.length; pointer ++) {
	                max = Math.max(pointer + nums[pointer], max);
	            }
	            turn ++;
	        }
	        return turn;
	    }
	}


GeeksForGeeks
	//cur rod to get the max product
	//dp, cut once for length i and the max product it can get
	private static int cutRope(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i ++) {
            for (int j = 1; j <= i / 2; j ++) {
                int leftPart = Math.max(dp[j], j);
                int rightPart = Math.max(dp[i - j], i - j);
                dp[i] = Math.max(leftPart * rightPart, dp[i]);
            }
        }

        return dp[n];
    }


    //merge 2 stones
    private static int mergeStone(int[] stones) {
        if (stones == null || stones.length == 0) return 0;
        int[][] dp = new int[stones.length][stones.length];

        for (int len = 2; len <= stones.length; len ++) {
            for (int start = 0; start + len <= stones.length; start ++) {
                for (int i = start; i <= start + len - 1; i ++) {
                    dp[start][start + len - 1] += stones[i];
                }
                //add all elements
                int tmp = Integer.MAX_VALUE;
                for (int i = start; i < start + len - 1; i ++) {
                    tmp = Math.min(dp[start][i] + dp[i + 1][start + len - 1], tmp);
                }
                dp[start][start + len - 1] += tmp;
                //choose the best adding method
            }
        }

        return dp[0][stones.length - 1];
    }



LintCode 1384.
	public int getMinimumCost(int n, int left, int right, int[] weight) {
        // Write your code here
        int[] pre = new int[n + 1];
        //pre-processing, the first k number's sum is in pre[k]
        for (int i = 1; i <= n; i ++) {
            pre[i] = pre[i - 1] + weight[i - 1];
        }
        
        //from ith to jth, include both; k piles
        int[][][] dp = new int[n][n][n + 1];
        int INF = 1000000000;
        
        //initialization
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                for (int k = 1; k <= n; k ++) {
                    if (i == j && k == 1) {
                        dp[i][j][k] = 0;
                    } else {
                        dp[i][j][k] = INF;
                    }
                }
            }
        }
        
        for (int len = 1; len <= weight.length; len ++) {
            for (int i = 0; i + len <= weight.length; i ++) {
                int j = i + len - 1;
                for (int k = 2; k <= len; k ++) {
                    for (int t = i; t + 1 <= j; t ++) {
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i][t][k - 1] + dp[t + 1][j][1]);
                    }
                }
                
                for (int k = left; k <= right; k++) {
                    dp[i][j][1] = Math.min(dp[i][j][1], dp[i][j][k] + pre[j + 1] - pre[i]);   
                }                
            }
        }
        if (dp[0][n - 1][1] >= INF) {
            return 0;
        }
        return dp[0][n - 1][1];        
        
    }


140.
	//dfs method, using map for accelerating
	//this is not dp
	//dp method, using map as the dp recording, but space needed
	public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<>());
    }
    
    private List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) return map.get(s);
        List<String> list = new ArrayList<>();
        for (String each : wordDict) {
            if (s.startsWith(each)) {
                String tmp = s.substring(each.length());
                if (tmp.length() == 0) list.add(each);
                else {
                    List<String> tmpList = dfs(tmp, wordDict, map);
                    for (String ele : tmpList) {
                        list.add(each + " " + ele);
                    }
                }
            }
        }
        map.put(s, list);
        return list;
    }



472.
	//Trie and DFS
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<String>();
        if (words == null || words.length == 0) {
            return res;
        }
        TrieNode root = new TrieNode();
        for (String word : words) { // construct Trie tree
            if (word.length() == 0) {
                continue;
            }
            addWord(word, root);
        }
        for (String word : words) { // test word is a concatenated word or not
            if (word.length() == 0) {
                continue;
            }
            if (testWord(word.toCharArray(), 0, root, 0)) {
                res.add(word);
            }
        }
        return res;
    }
    public boolean testWord(char[] chars, int index, TrieNode root, int count) { // count means how many words during the search path
        TrieNode cur = root;
        int n = chars.length;
        for (int i = index; i < n; i++) {
            if (cur.sons[chars[i] - 'a'] == null) {
                return false;
            }
            if (cur.sons[chars[i] - 'a'].isEnd) {
                if (i == n - 1) { // no next word, so test count to get result.
                    return count >= 1;
                }
                if (testWord(chars, i + 1, root, count + 1)) {
                    return true;
                }
            }
            cur = cur.sons[chars[i] - 'a'];
        }
        return false;
    }
    public void addWord(String str, TrieNode root) {
        char[] chars = str.toCharArray();
        TrieNode cur = root;
        for (char c : chars) {
            if (cur.sons[c - 'a'] == null) {
                cur.sons[c - 'a'] = new TrieNode();
            }
            cur = cur.sons[c - 'a'];
        }
        cur.isEnd = true;
    }
	
	class TrieNode {
	    TrieNode[] sons;
	    boolean isEnd;
	    public TrieNode() {
	        sons = new TrieNode[26];
	    }
	}


72.
	//Edit distance
	public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        
        for (int i = 1; i <= len1; i ++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= len2; j ++) {
            dp[0][j] = j;
        }
        
        for (int i = 1; i <= len1; i ++) {
            for (int j = 1; j <= len2; j ++) {
                int tmp = Math.min(dp[i - 1][j], dp[i][j - 1]);
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(tmp + 1, dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.min(tmp, dp[i - 1][j - 1]);
                    dp[i][j] ++;
                }
            }
        }
        
        return dp[len1][len2];
    }


36.
	//sudoku
	//reuse the method
	//key is to check if write error
	class Solution {
	    public boolean isValidSudoku(char[][] board) {
	        for (int i = 0; i < 9; i ++) {
	            if (!isValidLine(board, i, true)) return false;
	            if (!isValidLine(board, i, false)) return false;
	        }
	        
	        for (int i = 0; i < 3; i ++) {
	            for (int j = 0; j < 3; j ++) {
	                if (!isValidPart(board, i, j)) return false;
	            }
	        }
	        return true;
	    }
	    
	    private boolean isValidPart(char[][] board, int row, int col) {
	        boolean[] arr = new boolean[9];
	        for (int i = row * 3; i < (row + 1) * 3; i ++) {
	            for (int j = col * 3; j < (col + 1) * 3; j ++) {
	                if (board[i][j] == '.') continue;
	                int index = board[i][j] - '1';
	                if (arr[index]) return false;
	                arr[index] = true;
	            }
	        }
	        return true;
	    }
	    
	    private boolean isValidLine(char[][] board, int line, boolean isRow) {
	        boolean[] arr = new boolean[9];
	        if (isRow) {
	            for (int i = 0; i < 9; i ++) {
	                if (board[line][i] == '.') continue;
	                int index = board[line][i] - '1';
	                if (arr[index]) return false;
	                arr[index] = true;
	            }
	        } else {
	            for (int i = 0; i < 9; i ++) {
	                if (board[i][line] == '.') continue;
	                int index = board[i][line] - '1';
	                if (arr[index]) return false;
	                arr[index] = true;
	            }
	        }
	        return true;
	    }
	}



37.
	//soduko solver
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
                            if (solve(board)) return true;
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
        }
        return true;
    }



51.
	//N-Queen problem
	//col, diag1, diag2 is kind of bigger visited boolean array
	//key is to understand the row, col, diag relationship
	class Solution {
	    private boolean[] col;
	    private boolean[] diag1;
	    private boolean[] diag2;
	    
	    public List<List<String>> solveNQueens(int n) {
	        col = new boolean[n];
	        diag1 = new boolean[2 * n - 1];
	        diag2 = new boolean[2 * n - 1];
	        List<List<String>> res = new ArrayList<>();
	        dfs(res, new ArrayList<>(), 0, n);
	        return res;
	    }
	    
	    private void dfs(List<List<String>> res, List<String> list, int row, int n) {
	        if (list.size() == n) {
	            res.add(new ArrayList<>(list));
	            return;
	        } else {
	            char[] newRow = new char[n];
	            Arrays.fill(newRow, '.');
	            for (int i = 0; i < n; i ++) {
	                if (col[i] || diag1[n - 1 - row + i] || diag2[row + i]) continue;
	                //row, col, diag relationship
	                
	                newRow[i] = 'Q';
	                list.add(new String(newRow));
	                col[i] = true;
	                diag1[n - 1 - row + i] = true;
	                diag2[row + i] = true;
	                
	                dfs(res, list, row + 1, n);
	                
	                col[i] = false;
	                diag1[n - 1 - row + i] = false;
	                diag2[row + i] = false;
	                newRow[i] = '.';
	                list.remove(list.size() - 1);
	            }
	        }
	    }
	}


54.
	//spiral matrix, clockwise 
	class Solution {
	    public List<Integer> spiralOrder(int[][] matrix) {
	        ArrayList<Integer> myArr = new ArrayList<Integer>();
	        if (matrix.length == 0){return myArr;}
	        return spiralRe(matrix, myArr, 0, matrix[0].length, 0, matrix.length);
	    }
	    
	    private ArrayList<Integer> spiralRe(int[][] matrix, ArrayList<Integer> myArr, int p1, int n, int q1, int m){
	        for (int i = p1; i < n; i ++){
	            myArr.add(matrix[q1][i]);
	        }
	        for (int j = q1 + 1; j < m; j ++){
	            myArr.add(matrix[j][n-1]);
	        }
	        for (int i = n - 2; i >= p1; i --){
	            if (m - 1 != q1){myArr.add(matrix[m-1][i]);}
	        }
	        for (int j = m - 2; j >= q1 + 1; j --){
	            if (n - 1 != p1){myArr.add(matrix[j][p1]);}
	        }
	        if (m <= 2 || n <= 2){return myArr;}
	        return spiralRe(matrix, myArr, p1 + 1, n - 1, q1 + 1, m - 1);
	    }
	}	


	//another writing method of this problem
	//do not forget the corner cases
	class Solution {
	    public List<Integer> spiralOrder(int[][] matrix) {
	        List<Integer> list = new ArrayList<>();
	        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return list;
	        clockwise(matrix, 0, list);
	        return list;
	    }
	    
	    private void clockwise(int[][] matrix, int index, List<Integer> list) {
	        int rowStart = index, rowEnd = matrix.length - 1 - index, colStart = index, colEnd = matrix[0].length - 1 - index;
	        if (rowStart > rowEnd || colStart > colEnd) return;
	        if (rowStart == rowEnd) {
	            for (int i = colStart; i <= colEnd; i ++) {
	                list.add(matrix[rowStart][i]);
	            }
	        } else if (colStart == colEnd) {
	            for (int i = rowStart; i <= rowEnd; i ++) {
	                list.add(matrix[i][colStart]);
	            }
	        } else {
	            for (int i = colStart; i < colEnd; i ++) {
	                list.add(matrix[rowStart][i]);
	            }
	            for (int i = rowStart; i < rowEnd; i ++) {
	                list.add(matrix[i][colEnd]);
	            }
	            for (int i = colEnd; i > colStart; i --) {
	                list.add(matrix[rowEnd][i]);
	            }
	            for (int i = rowEnd; i > rowStart; i --) {
	                list.add(matrix[i][colStart]);
	            }
	            clockwise(matrix, index + 1, list);
	        }
	    }
	}	


	//spiral matrix for anti-clockwise






59.
	//spiral for input n and out put the matrix
	class Solution {
	    public int[][] generateMatrix(int n) {
	        if (n == 0){
	            int[][] myTable = new int[0][0];
	            return myTable;
	        }
	        int[][] myTable = new int[n][n];
	        return generateRe(myTable, n, 0, 1);
	    }
	    
	    private int[][] generateRe(int[][] myTable, int n, int counter, int start){
	        if (n % 2 == 0 && counter == n / 2 - 1){
	            myTable[counter][counter] = n * n - 3;
	            myTable[counter][counter + 1] = n * n - 2;
	            myTable[counter + 1][counter + 1] = n * n - 1;
	            myTable[counter + 1][counter] = n * n;
	            return myTable;
	        }
	        if (n % 2 == 1 && (counter == n / 2)){
	            myTable[counter][counter] = n * n;
	            return myTable;
	        }
	        for (int i = counter; i < n - counter; i ++){
	            myTable[counter][i] = start;
	            start ++;
	        }
	        for (int i = counter + 1; i < n - counter; i ++){
	            myTable[i][n - counter - 1] = start;
	            start ++;
	        }
	        for (int i = n - counter - 2; i >= counter; i --){
	            myTable[n - counter - 1][i] = start;
	            start ++;
	        }
	        for (int i = n - counter - 2; i > counter; i --){
	            myTable[i][counter] = start;
	            start ++;
	        }
	        counter ++;
	        return generateRe(myTable, n, counter, start);
	    }
	}



	//another writing method
	class Solution {
	    public int[][] generateMatrix(int n) {
	        if (n == 0) return new int[0][0];
	        int[][] res = new int[n][n];
	        fillIn(res, 0, n, 1);
	        return res;
	    }
	    
	    private void fillIn(int[][] res, int index, int n, int number) {
	        int rowStart = index, colStart = index, rowEnd = n - 1 - index, colEnd = n - 1 - index;
	        if (rowStart == rowEnd) {
	            res[rowStart][colStart] = number;
	            return;
	        }
	        if (rowStart > rowEnd || colStart > colEnd) return;
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



236.
	//LCA problem
	//normal binary tree
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (root.val == p.val || root.val == q.val || left != null && right != null) return root;
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }


    //binary search tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) return lowestCommonAncestor(root, q, p);
        if (root == null || root.val >= p.val && root.val <= q.val) return root;
        //corner case here, might just be one of the p or q
        if (root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        return lowestCommonAncestor(root.right, p, q);
    }


124.
	//Binary Tree Max Path sum
	class Solution {
	    public int maxPathSum(TreeNode root) {
	        int[] record = new int[]{Integer.MIN_VALUE};
	        int temp = helper(root, record);
	        if (root == null) {
	            return 0;
	        }
	        return record[0];
	    }
	    
	    private int helper(TreeNode root, int[] record) {
	        if (root == null) {return 0;}
	        if (root.left == null && root.right == null) {
	            record[0] = Math.max(record[0], root.val);
	            return root.val;
	        }
	        
	        int sumleft = helper(root.left, record);
	        int sumright = helper(root.right, record);
	        int chosen = 0;
	        chosen = Math.max(sumleft, sumright);
	        
	        record[0] = Math.max(record[0], sumleft + sumright + root.val);
	        record[0] = Math.max(record[0], root.val + chosen);
	        record[0] = Math.max(record[0], root.val);
	        
	        return (chosen > 0) ? (chosen + root.val) : root.val;
	    }
	}	


	//another method
	//much more clearer
	class Solution {
	    private int res;
	    
	    public int maxPathSum(TreeNode root) {
	        res = Integer.MIN_VALUE;
	        maxSum(root);
	        return res;
	    }
	    
	    private int maxSum(TreeNode root) {
	        if (root == null) return Integer.MIN_VALUE;
	        int left = maxSum(root.left);
	        int right = maxSum(root.right);
	        int result = root.val;
	        
	        if (left >= 0) result += left;
	        if (right >= 0) result += right;
	        
	        res = Math.max(res, result);
	        int potential = Math.max(left, right);
	        return potential > 0 ? root.val + potential : root.val;
	    }
	}


113.
	//path sum II
	class Solution {
	    public List<List<Integer>> pathSum(TreeNode root, int sum) {
	        List<List<Integer>> resFinal = new ArrayList<List<Integer>>();
	        List<Integer> temp = new ArrayList<Integer>();
	        if (root != null) {
	            helper(root, sum, temp, resFinal);
	        }
	        return resFinal;
	    }
	    
	    private void helper(TreeNode root, int sum, List<Integer> temp, List<List<Integer>> resFinal) {
	        if (sum - root.val == 0 && root.left == null && root.right == null) {
	            List<Integer> newList = new ArrayList<>(temp);
	            newList.add(root.val);
	            resFinal.add(newList);
	        }
	        if (root.left != null) {
	            List<Integer> newList = new ArrayList<>(temp);
	            newList.add(root.val);
	            helper(root.left, sum - root.val, newList, resFinal);
	        }
	        if (root.right != null) {
	            List<Integer> newList = new ArrayList<>(temp);
	            newList.add(root.val);
	            helper(root.right, sum - root.val, newList, resFinal);            
	        }
	    }
	    //the dfs stoped at the leave node level
	}	


114.
	//recursion solving
	//assume the function return the right solution
	class Solution {
	    public void flatten(TreeNode root) {
	        if (root == null) return;
	        correct(root);
	    }
	    
	    private TreeNode correct(TreeNode root) {
	        if (root.left != null && root.right != null) {
	            TreeNode leftEnd = correct(root.left);
	            TreeNode rightEnd = correct(root.right);
	            leftEnd.right = root.right;
	            root.right = root.left;
	            root.left = null;
	            return rightEnd;
	        } else if (root.left != null) {
	            TreeNode leftEnd = correct(root.left);
	            root.right = root.left;
	            root.left = null;
	            return leftEnd;
	        } else if (root.right != null) {
	            TreeNode rightEnd = correct(root.right);
	            return rightEnd;
	        } else {
	            return root;
	        }
	        //also can do, after it return and make judgement
	        
	    }
	}	

//Tree to inorder sequence and reverse
//Tree to postorder sequence and reverse
//Tree to levelorder sequence and reverse


297.
	//Tree to preorder sequence and reverse
	public class Codec {
	    
	    // Encodes a tree to a single string.
	    public String serialize(TreeNode root) {
	        StringBuilder sb = new StringBuilder();
	        buildTree(root, sb);
	        return sb.toString();
	    }
	    
	    private void buildTree(TreeNode root, StringBuilder sb) {
	        if (root == null) {
	            sb.append("null").append(",");
	            return;
	        }
	        sb.append(root.val + "").append(",");
	        buildTree(root.left, sb);
	        buildTree(root.right, sb);
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	        Queue<String> qu = new LinkedList<>();
	        qu.addAll(Arrays.asList(data.split(",")));
	        return construct(qu);
	    }
	    
	    private TreeNode construct(Queue<String> qu) {
	        String tmp = qu.poll();
	        if (tmp.equals("null")) return null;
	        TreeNode root = new TreeNode(Integer.parseInt(tmp));
	        TreeNode left = construct(qu);
	        TreeNode right = construct(qu);
	        root.left = left;
	        root.right = right;
	        return root;
	    }
	    
	}


437.
	class Solution {
	    
	    public int pathSum(TreeNode root, int sum) {
	        if (root == null) return 0;
	        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
	    }
	    
	    private int pathSumFrom(TreeNode node, int sum) {
	        if (node == null) return 0;
	        return (node.val == sum ? 1 : 0) 
	            + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
	    }
	    //count at the end root level
	    //cannot count at the next level, which double the number
	}


//similar to 114
//build the inorder double linked list	  
    Node bintree2listUtil(Node node) 
    {
        // Base case
        if (node == null)
            return node;
  
        // Convert the left subtree and link to root
        if (node.left != null) 
        {
            // Convert the left subtree
            Node left = bintree2listUtil(node.left);
  
            // Find inorder predecessor. After this loop, left
            // will point to the inorder predecessor
            for (; left.right != null; left = left.right);
            //key step
  
            // Make root as next of the predecessor
            left.right = node;
  
            // Make predecssor as previous of root
            node.left = left;
        }
  
        // Convert the right subtree and link to root
        if (node.right != null) 
        {
            // Convert the right subtree
            Node right = bintree2listUtil(node.right);
  
            // Find inorder successor. After this loop, right
            // will point to the inorder successor
            for (; right.left != null; right = right.left);
  
            // Make root as previous of successor
            right.left = node;
  
            // Make successor as next of root
            node.right = right;
        }
  
        return node;
    }


106.
	//build binary tree from inorder and postorder
	class Solution {
	    public TreeNode buildTree(int[] inorder, int[] postorder) {
	        return helper(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
	    }
	    
	    private TreeNode helper(int rootIndex, int inBegin, int inEnd, int[] inorder, int[] postorder) {
	        if (rootIndex < 0 || inBegin > inEnd) {
	            return null;
	        }
	        
	        TreeNode root = new TreeNode(postorder[rootIndex]);
	        
	        int mid = 0;
	        while (mid < inorder.length && inorder[mid] != postorder[rootIndex]) {
	            mid ++;
	        }
	        
	        root.left = helper(rootIndex - (inEnd - mid) - 1, inBegin, mid - 1, inorder, postorder);
	        root.right = helper(rootIndex - 1, mid + 1, inEnd, inorder, postorder);
	        
	        return root;
	    }
	}


	//2nd writing method
	//postorder array only need rootindex
	//inorder need start and end to give left and right subtree
	class Solution {
	    public TreeNode buildTree(int[] inorder, int[] postorder) {
	        if (inorder == null || inorder.length == 0) return null;
	        return reconstruct(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
	    }
	    
	    private TreeNode reconstruct(int[] inorder, int[] postorder, int instart, int inend, int poststart, int postend) {
	        if (instart > inend || poststart > postend) return null;
	        if (instart == inend) {
	            return new TreeNode(inorder[instart]);
	        }
	        int rootVal = postorder[postend];
	        int rootIndex = instart;
	        while (inorder[rootIndex] != rootVal) {
	            rootIndex ++;
	        }
	        int leftLen = rootIndex - instart;
	        TreeNode root = new TreeNode(rootVal);
	        TreeNode left = reconstruct(inorder, postorder, instart, rootIndex - 1, poststart, poststart + leftLen - 1);
	        TreeNode right = reconstruct(inorder, postorder, rootIndex + 1, inend, poststart + leftLen, postend - 1);
	        root.left = left;
	        root.right = right;
	        return root;
	    }
	}


105.
	//build binary tree from inorder and preorder 
	class Solution {
	    public TreeNode buildTree(int[] preorder, int[] inorder) {
	        return helper(0, 0, inorder.length - 1, preorder, inorder);
	    }
	    
	    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
	        if (preStart > preorder.length - 1 || inStart > inEnd) {
	            return null;
	        }
	        
	        TreeNode root = new TreeNode(preorder[preStart]);
	        
	        int mid = 0;
	        while (mid < inorder.length && inorder[mid] != preorder[preStart]) {
	            mid ++;
	        }
	        
	        root.left = helper(preStart + 1, inStart, mid - 1, preorder, inorder);
	        root.right = helper(preStart + mid - inStart + 1, mid + 1, inEnd, preorder, inorder);
	        
	        return root;
	    }
	}	


	//2nd writing method
	class Solution {
	    public TreeNode buildTree(int[] preorder, int[] inorder) {
	        if (inorder == null || inorder.length == 0) return null;
	        return reconstruct(preorder, inorder, 0, 0, inorder.length - 1);
	    }
	    
	    private TreeNode reconstruct(int[] preorder, int[] inorder, int rootIndex, int instart, int inend) {
	        if (instart > inend) return null;
	        if (instart == inend) return new TreeNode(inorder[instart]);
	        TreeNode root = new TreeNode(preorder[rootIndex]);
	        int inRootIndex = instart;
	        while (inorder[inRootIndex] != preorder[rootIndex]) {
	            inRootIndex ++;
	        }
	        int leftRootIndex = rootIndex + 1;
	        int rightRootIndex = rootIndex + inRootIndex - instart + 1;
	        TreeNode left = reconstruct(preorder, inorder, leftRootIndex, instart, inRootIndex - 1);
	        TreeNode right = reconstruct(preorder, inorder, rightRootIndex, inRootIndex + 1, inend);
	        root.left = left;
	        root.right = right;
	        return root;
	    }
	}



889.
	//build binary tree using preorder and postorder
	class Solution {
	    public TreeNode constructFromPrePost(int[] pre, int[] post) {
	        Map<Integer, Integer> postmap = new HashMap<>();
	        for (int i = 0; i < pre.length; i ++) {
	            postmap.put(post[i], i);
	        }
	        return reconstruct(pre, post, 0, pre.length - 1, 0, post.length - 1, postmap);
	    }
	    
	    private TreeNode reconstruct(int[] pre, int[] post, int prestart, int preend, 
	                                 int poststart, int postend, Map<Integer, Integer> postmap) {
	        if (prestart > preend) return null;
	        TreeNode root = new TreeNode(pre[prestart]);
	        if (prestart == preend) return root;
	        int leftLen = postmap.get(pre[prestart + 1]) - poststart + 1;
	        TreeNode left = reconstruct(pre, post, prestart + 1, prestart + leftLen, poststart, poststart + leftLen - 1, postmap);
	        TreeNode right = reconstruct(pre, post, prestart + leftLen + 1, preend, poststart + leftLen, postend - 1, postmap);
	        root.left = left;
	        root.right = right;
	        return root;
	    }
	}


606.
	//convert binary tree to string
	class Solution {
	    public String tree2str(TreeNode t) {
	        if (t == null) return "";
	        StringBuilder sb = new StringBuilder();
	        construct(sb, t);
	        return sb.toString();
	    }
	    
	    private void construct(StringBuilder sb, TreeNode root) {
	        if (root.left == null && root.right == null) {
	            sb.append(root.val);
	        }
	        else if (root.left == null) {
	            sb.append(root.val).append("()").append("(");
	            construct(sb, root.right);
	            sb.append(")");
	        }
	        else if (root.right == null) {
	            sb.append(root.val).append("(");
	            construct(sb, root.left);
	            sb.append(")");
	        }
	        else {
	            sb.append(root.val).append("(");
	            construct(sb, root.left);
	            sb.append(")");
	            sb.append("(");
	            construct(sb, root.right);
	            sb.append(")");
	        }
	    }
	}	


536.
	//from string to tree
	class Solution {
	    public TreeNode str2tree(String s) {
	        if (s.equals("")) return null;
	        if (s.indexOf('(') == -1) return new TreeNode(nextVal(s, 0));
	        return construct(s, 0, s.length() - 1);
	    }
	    
	    private TreeNode construct(String s, int start, int end) {
	        if (start > end) return null;
	        TreeNode root = new TreeNode(nextVal(s, start));
	        if (start == end) return root;
	        int counter = 1, cur = s.indexOf('(', start) + 1; 
	        if(cur == 0) return root;
	        start = cur;
	        while (counter != 0 && cur < end) {
	            if (s.charAt(cur) == '(') counter ++;
	            else if (s.charAt(cur) == ')') counter --;
	            cur ++;
	        }
	        TreeNode left = construct(s, start, cur - 1);
	        TreeNode right = construct(s, cur + 1, end - 1);
	        root.left = left;
	        root.right = right;
	        return root;
	    }
	    
	    private int nextVal(String s, int start) {
	        int index1 = s.indexOf('(', start);
	        int index2 = s.indexOf(')', start);
	        int index;
	        if (index1 != -1 && index2 != -1) {
	            index = Math.min(index1, index2);
	        } else {
	            index = index2;
	        }
	        return (index == -1) ? Integer.parseInt(s) : Integer.parseInt(s.substring(start, index));
	    }
	}


108.
	//convert sorted array to binary search tree
	//nothing much to say
	class Solution {
	    public TreeNode sortedArrayToBST(int[] nums) {
	        if (nums == null || nums.length == 0) return null;
	        return construct(nums, 0, nums.length - 1);
	    }
	    
	    private TreeNode construct(int[] nums, int start, int end) {
	        if (start > end) return null;
	        if (start == end) return new TreeNode(nums[start]);
	        int mid = start + (end - start) / 2;
	        TreeNode root = new TreeNode(nums[mid]);
	        TreeNode left = construct(nums, start, mid - 1);
	        TreeNode right = construct(nums, mid + 1, end);
	        root.left = left;
	        root.right = right;
	        return root;
	    }
	}



109.
	//convert sorted linkedlist to binary search tree, hight balanced
	//method 1 translate to sorted array and convert
	class Solution {
	    public TreeNode sortedListToBST(ListNode head) {
	        if (head == null) return null;
	        List<Integer> list = new ArrayList<>();
	        while (head != null) {
	            list.add(head.val);
	            head = head.next;
	        }
	        return construct(list, 0, list.size() - 1);
	    }
	    
	    private TreeNode construct(List<Integer> list, int start, int end) {
	        if (start > end) return null;
	        if (start == end) return new TreeNode(list.get(start));
	        int mid = start + (end - start) / 2;
	        TreeNode root = new TreeNode(list.get(mid));
	        TreeNode left = construct(list, start, mid - 1);
	        TreeNode right = construct(list, mid + 1, end);
	        root.left = left;
	        root.right = right;
	        return root;
	    }
	}

	//method 2
	//find the mid by two pointer, fast and slow
	//divide and conquer
	class Solution {
	    public TreeNode sortedListToBST(ListNode head) {
	        if (head == null) return null;
	        if (head.next == null) return new TreeNode(head.val);
	        
	        ListNode leftHead = head;
	        ListNode leftEnd = head;
	        ListNode rightHead = head.next;
	        while(rightHead != null && rightHead.next != null) {
	            leftEnd = head;
	            head = head.next;
	            rightHead = rightHead.next.next;
	        }
	        
	        TreeNode result = new TreeNode(head.val);
	        rightHead = head.next;
	        leftEnd.next = null;
	        if (leftHead == head) {
	            leftHead = null;
	        }
	        result.left = sortedListToBST(leftHead);
	        result.right = sortedListToBST(rightHead);
	        
	        return result;
	    }
	}


48.
	class Solution {
	    public void rotate(int[][] matrix) {
	        rotateOneLine(matrix, 0);
	    }
	    
	    private void rotateOneLine(int[][] matrix, int index) {
	        int rowStart = index, colStart = index, rowEnd = matrix[0].length - index - 1, colEnd = matrix.length - index - 1;
	        if (rowStart >= rowEnd) return;
	        int tmp;
	        for (int i = 0; i < colEnd - colStart; i ++) {
	            tmp = matrix[rowStart][colStart + i];
	            matrix[rowStart][colStart + i] = matrix[rowEnd - i][colStart];
	            matrix[rowEnd - i][colStart] = matrix[rowEnd][colEnd - i];
	            matrix[rowEnd][colEnd - i] = matrix[rowStart + i][colEnd];
	            matrix[rowStart + i][colEnd] = tmp;
	        }
	        rotateOneLine(matrix, index + 1);
	    }
	}

179.
	//sort by ab and ba string
	//can use compareTo() method
	class Solution {
	    public String largestNumber(int[] nums) {
	        if (nums == null || nums.length == 0) return "";
	        String[] res = new String[nums.length];
	        for (int i = 0; i < nums.length; i ++) {
	            res[i] = nums[i] + "";
	        }
	        Arrays.sort(res, new Comparator<String>(){
	            @Override
	            public int compare(String a, String b) {
	                String ab = a + b;
	                String ba = b + a;
	                return - ab.compareTo(ba);
	            }
	        });
	        String result = String.join("", res);
	        return (result.charAt(0) == '0') ? "0" : result;
	    }
	}	



1. 
	//2 sum
	class Solution {
	    public int[] twoSum(int[] nums, int target) {
	        Map<Integer, Integer> map = new HashMap<>();
	        int one = 0, two = 0, require;
	        for (int i = 0; i < nums.length; i ++) {
	            require = target - nums[i];
	            if (map.containsKey(require)) {
	                one = map.get(require);
	                two = i;
	                break;
	            }
	            map.put(nums[i], i);
	        }
	        return new int[]{one, two};
	    }
	}

	//2 sum sorted
	class Solution {
	    public int[] twoSum(int[] numbers, int target) {
	        int left = 0, right = numbers.length - 1;
	        while (left < right) {
	            if (numbers[left] + numbers[right] < target) {
	                left ++;
	            } else if (numbers[left] + numbers[right] > target) {
	                right --;
	            } else {
	                break;
	            }
	        }
	        return new int[]{left + 1, right + 1};
	    }
	}

	//2sum data structure design
	class TwoSum {
	    
	    Map<Integer, Integer> map;

	    /** Initialize your data structure here. */
	    public TwoSum() {
	        map = new HashMap<>();
	    }
	    
	    /** Add the number to an internal data structure.. */
	    public void add(int number) {
	        int count = map.getOrDefault(number, 0) + 1;
	        map.remove(number);
	        map.put(number, count);
	    }
	    
	    /** Find if there exists any pair of numbers which sum is equal to the value. */
	    public boolean find(int value) {
	        for (Map.Entry<Integer, Integer> element : map.entrySet()) {
	            int num1 = element.getKey();
	            int num2 = value - num1;
	            if (map.containsKey(num2) && num2 != num1 || num2 == num1 && element.getValue() > 1) {
	                return true;
	            }
	        }
	        return false;
	    }
	}


	//2 sum BST input
	class Solution {
	    public boolean findTarget(TreeNode root, int k) {
	        if (root == null || root.left == null && root.right == null) return false;
	        List<Integer> list = new ArrayList<>();
	        find(root, list);
	        int left = 0, right = list.size() - 1;
	        while (left < right) {
	            int sum = list.get(left) + list.get(right);
	            if (sum == k) return true;
	            else if (sum < k) left ++;
	            else right --;
	        }
	        return false;
	    }
	    
	    private void find(TreeNode root, List<Integer> list) {
	        if (root == null) return;
	        find(root.left, list);
	        list.add(root.val);
	        find(root.right, list);
	    }
	}



15.
	//3 sum, duplicate
	class Solution {
	    public List<List<Integer>> threeSum(int[] nums) {
	        Arrays.sort(nums);
	        List<List<Integer>> res = new ArrayList<>();
	        if (nums == null || nums.length <= 2) return res;
	        int left, right;
	        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i ++) {
	            if (i > 0 && nums[i] == nums[i - 1]) continue;
	            left = i + 1;
	            right = nums.length - 1;
	            while (left < right) {
	                if (left > i + 1 && nums[left] == nums[left - 1]) {
	                    left ++;
	                    continue;
	                }
	                if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
	                    right --;
	                    continue;
	                }
	                int sum = nums[i] + nums[left] + nums[right];
	                if (sum == 0) {
	                    List<Integer> list = new ArrayList<>();
	                    list.add(nums[i]);
	                    list.add(nums[left]);
	                    list.add(nums[right]);
	                    res.add(list);
	                    left ++;
	                } else if (sum < 0) {
	                    left ++;
	                } else {
	                    right --;
	                }
	            }
	        }
	        return res;
	    }
	}


16.
	//3 sum, closest
	class Solution {
	    public int threeSumClosest(int[] nums, int target) {
	        Arrays.sort(nums);
	        int left, right, sum, recordSum = nums[0] + nums[1] + nums[2];
	        for (int i = 0; i <= nums.length - 3; i ++) {
	            left = i + 1;
	            right = nums.length - 1;
	            while (left < right) {
	                sum = nums[i] + nums[left] + nums[right];
	                if (sum < target) {left ++;}
	                else if (sum > target) {right --;}
	                else {return sum;}
	                if (Math.abs(recordSum - target) > Math.abs(sum - target)) {
	                    recordSum = sum;
	                }
	            }
	        }
	        return recordSum;
	    }
	}


259.
	//3 sum, smaller
	class Solution {
	    public int threeSumSmaller(int[] nums, int target) {
	        int left, right, sum, record = 0;
	        if (nums.length < 3) {return record;}
	        Arrays.sort(nums);
	        for (int i = 0; i <= nums.length - 3; i ++) {
	            left = i + 1;
	            right = nums.length - 1;
	            while (left < right) {
	                sum = nums[i] + nums[left] + nums[right];
	                if (sum < target) {
	                    record += right - left;
	                    left ++;
	                }
	                else {
	                    right --;
	                }
	            }
	        }
	        return record;
	    }
	}


18.
	class Solution {
	    public List<List<Integer>> fourSum(int[] nums, int target) {
	        Arrays.sort(nums);
	        int left, right;
	        List<List<Integer>> res = new ArrayList<>();
	        for (int i = 0; i < nums.length - 3; i ++) {
	            while (i > 0 && i < nums.length - 3 && nums[i] == nums[i - 1]) i ++;
	            for (int j = i + 1;j < nums.length - 2; j ++) {
	                while (j > i + 1 && j < nums.length - 2 && nums[j] == nums[j - 1]) j ++;
	                left = j + 1;
	                right = nums.length - 1;
	                while (left < right) {
	                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
	                    if (sum == target) {
	                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
	                        //initialize list
	                        //cannot remove element in this kind of list
	                        //must use new ArrayList(Arrays.asList(...))
	                        res.add(list);
	                        left ++;
	                    } else if (sum < target) left ++;
	                    else right --;
	                    while (left > j + 1 && left < right && nums[left] == nums[left - 1]) left ++;
	                    while (right < nums.length - 1 && left < right && nums[right] == nums[right + 1]) right --;
	                }
	            }
	        }
	        return res;
	    }
	}


454.
	class Solution {
	    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
	        int len = A.length, sum;
	        Map<Integer, Integer> map = new HashMap<>();
	        for (int i = 0; i < len; i ++) {
	            for (int j = 0; j < len; j ++) {
	                sum = A[i] + B[j];
	                map.put(sum, map.getOrDefault(sum, 0) + 1);
	                //Associates the specified value with the specified key in this map (optional operation). 
	                //If the map previously contained a mapping for the key, the old value is replaced by the specified value.
	            }
	        }
	        
	        int res = 0;
	        for (int i = 0; i < len; i ++) {
	            for (int j = 0; j < len; j ++) {
	                sum = C[i] + D[j];
	                if (map.containsKey(- sum)) res += map.get(- sum);
	                //containsKey before get
	            }
	        }
	        
	        return res;
	    }
	}


4.
	//find the median in two sorted array
	class Solution {
	    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        int k = (nums1.length + nums2.length + 1) / 2;
	        double number1 = helper(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1, k);
	        if ((nums1.length + nums2.length) % 2 == 1) return number1;
	        double number2 = helper(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1, k + 1);
	        return (number1 + number2) / 2;
	    }
	    
	    private double helper(int[] a, int[] b, int aleft, int aright, int bleft, int bright, int k) {
	        if (aleft > aright) return (double) b[bleft + k - 1];
	        if (bleft > bright) return (double) a[aleft + k - 1];
	        
	        int amid = aleft + (aright - aleft) / 2;
	        int bmid = bleft + (bright - bleft) / 2;
	        int temp = amid - aleft + bmid - bleft + 1;
	        
	        if (a[amid] > b[bmid] && k > temp) {
	            return helper(a, b, aleft, aright, bmid + 1, bright, k - (bmid - bleft + 1));
	        }
	        else if (a[amid] > b[bmid]) {
	            return helper(a, b, aleft, amid - 1, bleft, bright, k);
	        }
	        else if (k > temp) {
	            return helper(a, b, amid + 1, aright, bleft, bright, k - (amid - aleft + 1));
	        }
	        else {
	            return helper(a, b, aleft, aright, bleft, bmid - 1, k);
	        }
	    }  
	}


	//my understanding version
	class Solution {
	    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        int k = (nums1.length + nums2.length + 1) / 2;
	        double res = find(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1, k);
	        if ((nums1.length + nums2.length) % 2 == 0) {
	            res += find(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1, k + 1);
	            res /= 2;
	        }
	        return res;
	    }
	    
	    private double find(int[] nums1, int[] nums2, int left1, int right1, int left2, int right2, int k) {
	        if (left1 > right1) return nums2[left2 + k - 1];
	        if (left2 > right2) return nums1[left1 + k - 1];
	        
	        int mid1 = left1 + (right1 - left1) / 2;
	        int mid2 = left2 + (right2 - left2) / 2;
	        int tmp = mid1 - left1 + mid2 - left2 + 1;
	        
	        if (nums1[mid1] >= nums2[mid2] && k > tmp) {
	            return find(nums1, nums2, left1, right1, mid2 + 1, right2, k - (mid2 - left2 + 1));
	        } else if (nums1[mid1] > nums2[mid2]) {
	            return find(nums1, nums2, left1, mid1 - 1, left2, right2, k);
	        } else if (nums1[mid1] <= nums2[mid2] && k > tmp) {
	            return find(nums1, nums2, mid1 + 1, right1, left2, right2, k - (mid1 - left1 + 1));
	        } else {
	            return find(nums1, nums2, left1, right1, left2, mid2 - 1, k);
	        }
	    }
	}



239.
	//sliding window, my method, use deque
	class Solution {
	    public int[] maxSlidingWindow(int[] nums, int k) {
	        Deque<Integer> qu = new LinkedList<>();
	        if (k == 0 || nums.length - k + 1 <= 0) return new int[0];
	        int[] res = new int[nums.length - k + 1];
	        
	        for (int i = 0; i < k; i ++) {
	            if (qu.isEmpty()) {
	                qu.offerLast(nums[i]);
	            } else {
	                while (!qu.isEmpty() && qu.peekLast() < nums[i]) {
	                    qu.pollLast();
	                }
	                qu.offerLast(nums[i]);
	            }
	        }
	        res[0] = qu.peekFirst();
	        int counter = 0;
	        
	        while (counter < res.length - 1) {
	            if (nums[counter] == qu.peekFirst()) qu.pollFirst();
	            while (!qu.isEmpty() && qu.peekLast() < nums[counter + k]) {
	                qu.pollLast();
	            }
	            qu.offerLast(nums[counter + k]);
	            res[++ counter] = qu.peekFirst();
	        }
	        
	        return res;
	    }
	}


	//good method, unite the inital condition and following conditions
	class Solution {
	    public int[] maxSlidingWindow(int[] nums, int k) {
	        
	        if(nums==null || nums.length==0){
	            return new int[0];
	        }
	        
	        int[] res=new int[nums.length-k+1];
	        LinkedList<Integer> list=new LinkedList<Integer>();
	        
	        for(int i=0; i<nums.length; i++){
	            while(list.size()!=0 && nums[list.getLast()]<nums[i]){
	                list.removeLast();
	            }
	            list.addLast(i);
	            
	            if(i-list.getFirst()>=k){
	                list.removeFirst();
	            }
	            //use this to unite the initial condition
	            //add index instead of values
	            
	            if(i+1>=k){
	                res[i+1-k]=nums[list.getFirst()];
	            }
	        }
	        
	        return res;
	    }
	}


138.
	//copy linkedlist with random pointer
	public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        
        RandomListNode root = new RandomListNode(0);
        RandomListNode cur2 = root, cur1 = head;
        
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (cur1 != null) {
            RandomListNode tmp = new RandomListNode(cur1.label);
            cur2.next = tmp;
            map.put(cur1, tmp);
            cur2 = cur2.next;
            cur1 = cur1.next;
        }
        
        cur2 = root.next;
        cur1 = head;
        while (cur1 != null) {
            if (cur1.random != null) {
                cur2.random = map.get(cur1.random);
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        
        return root.next;
    }


    //another method, copy and connect to the tail
	public class Solution {
	    public RandomListNode copyRandomList(RandomListNode head) {
	        if (head == null) return null;
	        
	        RandomListNode cur = head;
	        while (cur != null) {
	            RandomListNode copy = new RandomListNode(cur.label);
	            copy.next = cur.next;
	            cur.next = copy;
	            cur = cur.next.next;
	        }
	        
	        cur = head;
	        while (cur != null) {
	            if (cur.random != null) {
	                cur.next.random = cur.random.next;
	            }
	            cur = cur.next.next;
	        }
	        
	        RandomListNode root = head.next;
	        RandomListNode cur2 = root;
	        cur = head;
	        
	        while (cur2.next != null) {
	            cur.next = cur.next.next;
	            cur = cur.next;
	            cur2.next = cur2.next.next;
	            cur2 = cur2.next;
	        }
	        cur.next = null;
	        
	        return root;
	    }
	}


156.
	class Solution {
	    public TreeNode upsideDownBinaryTree(TreeNode root) {
	        if (root == null || root.left == null) return root;
	        TreeNode head = findNewRoot(root);
	        convert(root);
	        return head;
	    }
	    
	    private TreeNode findNewRoot(TreeNode root) {
	        if (root.left == null) return root;
	        return findNewRoot(root.left);
	    }
	    
	    private void convert(TreeNode root) {
	        if (root == null || root.left == null) return;
	        convert(root.left);
	        root.left.left = root.right;
	        root.left.right = root;
	        root.right = null;
	        root.left = null;
	            
	    }
	}



318.
	//sort it
	//BFS add into PriorityQueue
	//Hashing techniques
	class Solution {
	    public int maxProduct(String[] words) {
	        if (words == null || words.length <= 1) return 0;
	        
	        Arrays.sort(words, new Comparator<String>(){
	            @Override
	            public int compare(String a, String b) {
	                return b.length() - a.length();
	            }
	        });
	        int len = words.length;
	        PriorityQueue<Integer> qu = new PriorityQueue<>(new Comparator<Integer>(){
	            @Override
	            public int compare(Integer a, Integer b) {
	                int aLen = words[a / len].length() * words[a % len].length();
	                int bLen = words[b / len].length() * words[b % len].length();
	                return bLen - aLen;
	            }
	        });
	        boolean[][] visited = new boolean[len][len];
	        qu.offer(1);
	        visited[0][1] = true;
	        while (!qu.isEmpty()) {
	            int tmp = qu.poll();
	            int i = tmp / len;
	            int j = tmp % len;
	            if (check(words[i], words[j])) return words[i].length() * words[j].length();
	            int newI = i + 1;
	            int newJ = j + 1;
	            if (newI != j && newI <= j && !visited[newI][j]) {
	                qu.offer(newI * len + j);
	                visited[newI][j] = true;
	            }
	            if (newJ != i && newJ < len && !visited[i][newJ]) {
	                qu.offer(i * len + newJ);
	                visited[i][newJ] = true;
	            }
	        }
	        return 0;        
	    }
	    
	    private boolean check(String a, String b) {
	        boolean[] map = new boolean[26];
	        for (char ele : a.toCharArray()) {
	            map[ele - 'a'] = true;
	        }
	        for (char ele : b.toCharArray()) {
	            if (map[ele - 'a']) return false;
	        }
	        return true;
	    }
	}


	//other method, much cleaner and better
	class Solution {
	    public int maxProduct(String[] words) {
	        int res = 0;
	        int[] bytes = new int[words.length];
	        for (int i = 0; i < words.length; i++) {
	            int val = 0;
	            for (int j = 0; j < words[i].length(); j++) {
	                val |= (1 << (words[i].charAt(j) - 'a'));
	            }
	            bytes[i] = val; 
	        }
	        //use bit operation, save the char
	        for (int i = 0; i < bytes.length; i++) {
	            for (int j = i + 1; j < bytes.length; j++) {
	                if ((bytes[i] & bytes[j]) == 0) {
	                	//judge if have the same chars
	                    res = Math.max(words[i].length() * words[j].length(), res);
	                }
	            }
	        }
	        return res;
	    }
	}



317.
	//long and complicate
	//but the algorithm is simple, BFS
	//remember to add the visited boolean matrix
	//remember to offer after each poll
	class Solution {
	    
	    private int[][] around = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
	    
	    public int shortestDistance(int[][] grid) {
	        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
	        
	        int rows = grid.length, cols = grid[0].length;
	        int[][] allDistance = new int[rows][cols];
	        
	        int houseNum = 0;
	        Queue<int[]> qu = new LinkedList<>();
	        for (int i = 0; i < rows; i ++) {
	            for (int j = 0; j < cols; j ++) {
	                allDistance[i][j] = -1;
	                if (grid[i][j] == 1) {
	                    qu.offer(new int[]{i, j, houseNum});
	                    houseNum ++;
	                }
	            }
	        }
	        
	        boolean[][][] visited = new boolean[rows][cols][houseNum];
	        for (int i = 0; i < rows; i ++) {
	            for (int j = 0; j < cols; j ++) {
	                if (grid[i][j] == 1 || grid[i][j] == 2) {
	                    for (int k = 0; k < houseNum; k ++) {
	                        visited[i][j][k] = true;
	                    }
	                }
	            }
	        }
	        
	        int size;
	        int[] tmp;
	        int distance = 1;
	        while (!qu.isEmpty()) {
	            size = qu.size();
	            for (int k = 0; k < size; k ++) {
	                tmp = qu.poll();
	                for (int[] each : around) {
	                    int newRow = each[0] + tmp[0];
	                    int newCol = each[1] + tmp[1];
	                    int house = tmp[2];
	                    if (newRow < 0 || newCol < 0 || newRow >= rows || newCol >= cols || visited[newRow][newCol][house]) continue;
	                    if (allDistance[newRow][newCol] == -1) {
	                        allDistance[newRow][newCol] = distance;
	                    } else {
	                        allDistance[newRow][newCol] += distance;
	                    }
	                    visited[newRow][newCol][house] = true;
	                    qu.offer(new int[]{newRow, newCol, house});
	                }
	            }
	            distance ++;
	        }
	        
	        int minDistance = Integer.MAX_VALUE;
	        for (int i = 0; i < rows; i ++) {
	            for (int j = 0; j < cols; j ++) {
	                if (allDistance[i][j] == -1) continue;
	                boolean flag = true;
	                for (int k = 0; k < houseNum; k ++) {
	                    flag = flag && visited[i][j][k];
	                }
	                if (flag) {
	                    minDistance = Math.min(minDistance, allDistance[i][j]);
	                }                
	            }
	        }
	        
	        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
	    }
	}


84.
	//use a stack, saving index, calculate the area, like one leetcode before
	class Solution {
	    public int largestRectangleArea(int[] heights) {
	        if (heights == null || heights.length == 0) return 0;
	        
	        Stack<Integer> st = new Stack<>();
	        st.push(-1);
	        int max = 0;
	        for (int i = 0; i <= heights.length; i ++) {
	            while (st.peek() != -1 && (i == heights.length || heights[st.peek()] > heights[i])) {
	                int tmp = st.pop();
	                max = Math.max((i - st.peek() - 1) * heights[tmp], max);
	            }
	            st.push(i);
	        }
	        return max;
	    }
	}



315.
	//FUCK!!!
	//solution, using merge sort, add number when merge the right number
	//sort by index, instead of number, this can be very wrapping
	class Solution {
	    public List<Integer> countSmaller(int[] nums) {
	        List<Integer> res = new ArrayList<>();
	        if (nums.length == 0) return res;
	        
	        int[] count = new int[nums.length];
	        int[] indexes = new int[nums.length];
	        for (int i = 0; i < nums.length; i ++) {
	            indexes[i] = i;
	        }
	        
	        divide(nums, indexes, count, 0, nums.length - 1);
	        for (int ele : count) {
	            res.add(ele);
	        }
	        return res;
	    }
	    
	    private void divide(int[] nums, int[] indexes, int[] count, int start, int end) {
	        if (end <= start) return;
	        int mid = start + (end - start) / 2;
	        divide(nums, indexes, count, start, mid);
	        divide(nums, indexes, count, mid + 1, end);
	        
	        merge(nums, indexes, count, start, mid, mid + 1, end);
	    }
	    
	    private void merge(int[] nums, int[] indexes, int[] count, int leftstart, int leftend, int rightstart, int rightend) {
	        int[] tmp = new int[rightend - leftstart + 1];
	        int newIndex = 0;
	        int rightcount = 0;
	        int recordLeft = leftstart;
	        while (leftstart <= leftend && rightstart <= rightend) {
	            if (nums[indexes[leftstart]] > nums[indexes[rightstart]]) {
	                rightcount ++;
	                tmp[newIndex ++] = indexes[rightstart ++];
	            } else {
	                tmp[newIndex ++] = indexes[leftstart];
	                count[indexes[leftstart ++]] += rightcount;
	            }
	        }
	        while (leftstart <= leftend) {
	            tmp[newIndex ++] = indexes[leftstart];
	            count[indexes[leftstart ++]] += rightcount;
	        }
	        while (rightstart <= rightend) {
	            tmp[newIndex ++] = indexes[rightstart ++];
	        }
	        for (int i = recordLeft; i <= rightend; i ++) {
	            indexes[i] = tmp[i - recordLeft];
	        }
	    }
	}
	//Arrays.asList() can only convert the same type of list
	//can not convert int to Integer


	//second method
	//using binary search tree
	class Solution {
	    public List<Integer> countSmaller(int[] nums) {
	        List<Integer> res = new ArrayList<>();
	        if (nums.length == 0) return res;
	        
	        int[] count = new int[nums.length];
	        TreeNode root = null;
	        for (int i = nums.length - 1; i >= 0; i --) {
	            root = insert(root, count, i, nums, 0);
	        }
	        for (int ele : count) {
	            res.add(ele);
	        }
	        return res;
	    }
	    
	    private TreeNode insert(TreeNode root, int[] count, int index, int[] nums, int sumup) {
	        if (root == null) {
	            count[index] = sumup;
	            return new TreeNode(nums[index]);
	        }
	        if (root.val == nums[index]) {
	            root.dup ++;
	            count[index] = root.num + sumup;
	        } else if (root.val < nums[index]) {
	            root.right = insert(root.right, count, index, nums, sumup + root.num + root.dup);
	        } else {
	            root.num ++;
	            root.left = insert(root.left, count, index, nums, sumup);
	        }
	        return root;
	    }
	}

	class TreeNode{
	    int val;
	    //the value of this treenode
	    int num;
	    //the number of nodes in the left subtree
	    int dup;
	    //dup, duplicate numbers
	    TreeNode left;
	    TreeNode right;
	    public TreeNode(int val){
	        this.val = val;
	        dup = 1;
	        left = null;
	        right = null;
	    }
	}



149.
	/**
	 * Definition for a point.
	 * class Point {
	 *     int x;
	 *     int y;
	 *     Point() { x = 0; y = 0; }
	 *     Point(int a, int b) { x = a; y = b; }
	 * }
	 */
	class Solution {
	    public int maxPoints(Point[] points) {
	        if (points == null || points.length == 0) {
	            return 0;
	        }
	        Map<String,Integer> map = new HashMap<>();
	        int n = points.length;
	        int max = 1;
	        for (int i = 0; i < n - 1; i++) {
	            map.clear();
	            int curMax = 1, samePoints = 0;
	            for (int j = i + 1; j < n; j++) {
	                int dx = points[i].x - points[j].x;
	                int dy = points[i].y - points[j].y;
	                if (dx == 0 && dy == 0) {
	                    samePoints++;
	                    continue;
	                }
	                int gcd = getGCD(dx,dy);
	                String slope = dy/gcd + "_" + dx/gcd;
	                //do not use double to give slope
	                //use string!!!
	                //brilliant
	                map.put(slope,map.getOrDefault(slope,1) + 1);
	                curMax = Math.max(curMax,map.get(slope));
	            }
	            max = Math.max(max, curMax + samePoints);
	            //add at the last second
	        }
	        
	        return max;
	    }
	    
	    //the method to get the greatest common divider
	    private int getGCD(int a, int b) {
	        if (b == 0) {
	            return a;
	        }
	        return getGCD(b,a % b);
	    }
	}

    
    //BigDecimal
    import java.math.BigDecimal;
	import java.math.MathContext;

	class Solution {
	    
	    public int maxPoints(Point[] points) {
	        if (points == null) return 0;
	        if (points.length <= 2) return points.length;
	        
	        int maxNum = 0;
	        for (int i = 0; i < points.length; i ++) {
	            int samep = 1;
	            int samex = 0;
	            Map<BigDecimal, Integer> map = new HashMap<>();
	            for (int j = 0; j < points.length; j ++) {
	                if (j == i) continue;
	                if (points[i].x == points[j].x && points[i].y == points[j].y) {
	                    samep ++;
	                } else if (points[i].x == points[j].x) {
	                    samex ++;
	                }
	            }
	            for (int j = 0; j < points.length; j ++) {
	                if (j == i || points[i].x == points[j].x) continue;
	                BigDecimal k = BigDecimal.valueOf(points[j].y - points[i].y).divide(BigDecimal.valueOf(points[j].x - points[i].x), new MathContext(20));
	                map.put(k, map.getOrDefault(k, samep) + 1);
	                maxNum = Math.max(maxNum, map.get(k));
	            }
	            maxNum = Math.max(maxNum, samex + samep);
	        }
	        
	        return maxNum;
	    }
	}






























































	
	
	
	
	
	
	
	
	
	
	

	
	