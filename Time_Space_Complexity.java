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





























	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	