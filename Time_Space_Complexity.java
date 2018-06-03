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
	Time complexity should be O(words.length's sum);
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
		//there exists situation that won't find, should return -1!
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
	
	

	
	