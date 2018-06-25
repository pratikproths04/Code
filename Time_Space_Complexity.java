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


162.
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
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
     
        if(nums == null || nums.length < 2 || k < 1) return false;
        TreeSet<Long> set = new TreeSet<>();
        
        
        
        for(int i = 0; i < nums.length; i++){
            long l = (long) nums[i]; 
                       
            Long floor = set.floor(l);
            Long ceil = set.ceiling(l);
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
            if((floor != null && l - floor <= t) ||
               (ceil != null && ceil - l <= t) )
                return true;
            
            set.add(l);
            
            if(i >= k)
                set.remove((long)nums[i -k]);
            
        }
        
        return false;
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
	//in-order method to validate BST
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
	//any better idea to solve this problem???
	//I remeber there is another way!!!
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
    














































	
	
	
	
	
	
	
	
	
	
	

	
	