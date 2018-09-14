LIN 612:

//my method
public Point[] kClosest(Point[] points, Point origin, int k) {
    if (k == 0) return new Point[0];
    // write your code here
    Arrays.sort(points, new Comparator<Point>(){
        @Override
        public int compare(Point a, Point b) {
            int distanceA = (a.x - origin.x) * (a.x - origin.x) + (a.y - origin.y) * (a.y - origin.y);
            int distanceB = (b.x - origin.x) * (b.x - origin.x) + (b.y - origin.y) * (b.y - origin.y);
            if (distanceA == distanceB && a.x == b.x) {
                return a.y - b.y;
            } else if (distanceA == distanceB) {
                return a.x - b.x;
            } else {
                return distanceA - distanceB;
            }
        }
    });
    //use a new comparator
    Point[] res = new Point[k];
    for (int i = 0; i < k; i ++) {
        res[i] = points[i];
    }
    return res;
}
time complexity O(nlogn)
space complexity O(n)


//priorityQueue method
public Point[] kClosest(Point[] points, Point origin, int k) {
    if (k == 0) return new Point[0];
    
    PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>(){
        @Override
        public int compare(Point a, Point b) {
            int distanceA = (a.x - origin.x) * (a.x - origin.x) + (a.y - origin.y) * (a.y - origin.y);
            int distanceB = (b.x - origin.x) * (b.x - origin.x) + (b.y - origin.y) * (b.y - origin.y);
            if (distanceA == distanceB && a.x == b.x) {
                return a.y - b.y;
            } else if (distanceA == distanceB) {
                return a.x - b.x;
            } else {
                return distanceA - distanceB;
            }
        }
    });
    for (Point ele : points) {
        pq.offer(ele);
    }
    Point[] res = new Point[k];
    for (int i = 0; i < k; i ++) {
        res[i] = pq.poll();
    }
    return res;
}
time complexity O(nlogn)
space complexity O(n)

//more advanced, priorityqueue, only keep k numbers of points
public Point[] kClosest(Point[] points, Point origin, int k) {
    if (k == 0) return new Point[0];
    
    Comparator<Point> cm = new Comparator<Point>(){
        @Override
        public int compare(Point b, Point a) {
            int distanceA = (a.x - origin.x) * (a.x - origin.x) + (a.y - origin.y) * (a.y - origin.y);
            int distanceB = (b.x - origin.x) * (b.x - origin.x) + (b.y - origin.y) * (b.y - origin.y);
            if (distanceA == distanceB && a.x == b.x) {
                return a.y - b.y;
            } else if (distanceA == distanceB) {
                return a.x - b.x;
            } else {
                return distanceA - distanceB;
            }
        }
    };
    PriorityQueue<Point> pq = new PriorityQueue<>(k, cm);
    
    for (Point ele : points) {
        if (pq.size() < k) {
            pq.offer(ele);
            continue;
        }
        Point tmp = pq.peek();
        if (cm.compare(tmp, ele) < 0) {
            pq.poll();
            pq.offer(ele);
        }
    }
    Point[] res = new Point[k];
    for (int i = k - 1; i >= 0; i --) {
        res[i] = pq.poll();
    }
    return res;
}
time complexity should be O(nlogk)
space complexity is O(k)


LIN 918:

public int threeSumSmaller(int[] nums, int target) {
    Arrays.sort(nums);
    
    int counter = 0;
    for (int i = 0; i < nums.length - 2; i ++) {
        int left = i + 1, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] + nums[i] < target) {
                counter += right - left;
                left ++;
            } else {
                right --;
            }
        }
    }
    return counter;
}
//do not have to consider the duplicate condition

time complexity is O(n^2)
space complexity is O(1)



LIN 1561:

//set up the tree
//find the LCA
//calculate the distance from LCA to request node
public class Solution {
    /**
     * @param numbers: the given list
     * @param node1: the given node1
     * @param node2: the given node2
     * @return: the distance between two nodes
     */
    public int bstDistance(int[] numbers, int node1, int node2) {
        // Write your code here
        if (numbers == null || numbers.length < 2) return -1;
        
        TreeNode root = new TreeNode(numbers[0]);
        boolean flag1 = false, flag2 = false;
        if (numbers[0] == node1) flag1 = true;
        if (numbers[0] == node2) flag2 = true;
        
        for (int i = 1; i < numbers.length; i ++) {
            insert(root, numbers[i]);
            if (numbers[i] == node1) flag1 = true;
            if (numbers[i] == node2) flag2 = true;
        }
        if (!(flag1 && flag2)) return -1;
        return findLCA(root, node1, node2);
    }
    
    private void insert(TreeNode root, int value) {
        if (root.val > value && root.left != null) insert(root.left, value);
        else if (root.val < value && root.right != null) insert(root.right, value);
        else if (root.val > value) {
            root.left = new TreeNode(value);
        } else {
            root.right = new TreeNode(value);
        }
    }
    
    private int findLCA(TreeNode root, int node1, int node2) {
        if (node1 > node2) return findLCA(root, node2, node1);
        if (root.val > node2) return findLCA(root.left, node1, node2);
        else if (root.val < node1) return findLCA(root.right, node1, node2);
        else {
            int distance1 = findDistance(root, node1);
            int distance2 = findDistance(root, node2);
            return distance1 + distance2;
        } 
    }
    
    
    private int findDistance(TreeNode root, int a) {
        if (root.val == a) return 0;
        else if (root.val < a) {
            int distance = findDistance(root.right, a);
            return distance + 1;
        } else {
            int distance = findDistance(root.left, a);
            return distance + 1;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int value) {
        val = value;
    }
}

time complexity O(n + logn)
space complexity O(n)




//with the same idea
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    
}
public class Solution {
    /**
     * @param numbers: the given list
     * @param node1: the given node1
     * @param node2: the given node2
     * @return: the distance between two nodes
     */
    public int bstDistance(int[] numbers, int node1, int node2) {
        // Write your code here
        if(numbers == null || numbers.length == 0)
            return -1;
        
        int result = 0;
        boolean flag1 = false;
        boolean flag2 = false;
        
        TreeNode root = new TreeNode(numbers[0]);
        if(numbers[0] == node1) flag1 = true;
        if(numbers[0] == node2) flag2 = true;
        
        for(int i = 1; i < numbers.length; i++){
            if(numbers[i] == node1)
                flag1 = true;
            if(numbers[i] == node2)
                flag2 = true;
            
            constructBST(root, numbers[i]);
        }
        if(!(flag1 && flag2)) return -1;
        
        TreeNode LCA = findLCA(root, node1, node2);
        
        result = findDistance(LCA, node1) + findDistance(LCA, node2);
    
        return result;
    }
    
    public void constructBST(TreeNode root, int node){
        if(root.val > node){
            if(root.left == null) 
                root.left = new TreeNode(node);
            else 
                constructBST(root.left, node);
        }else{
            if(root.right == null) 
                root.right = new TreeNode(node);
            else 
                constructBST(root.right, node);
        }
    }
    
    public TreeNode findLCA(TreeNode root, int node1, int node2){
        if(node1 < root.val && node2 < root.val)
            return findLCA(root.left, node1, node2);
        if(node1 > root.val && node2 > root.val)
            return findLCA(root.right, node1, node2);
        else 
            return root;
    }
    
    public int findDistance(TreeNode root, int node){
        if(root.val == node) return 0;
        if(root.val < node) return findDistance(root.right, node) + 1;
        else return findDistance(root.left, node) + 1;
    }
}



LC 61:

//scan first to store all listnode in the map
//in this way can easily get the listnode we are going to rotate
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        Map<Integer, ListNode> map = new HashMap<>();
        int index = 0;
        ListNode cur = head;
        while (cur != null) {
            map.put(index, cur);
            index ++;
            cur = cur.next;
        }
        index --;
        k = k % map.size();
        if (k == 0) return head;
        
        ListNode newHeadPrev = map.get(index - k);
        ListNode newHead = newHeadPrev.next;
        newHeadPrev.next = null;
        ListNode tail = map.get(index);
        tail.next = dummy.next;
        dummy.next = newHead;
        
        return dummy.next;
    }
}
time complexity O(n)
space complexity O(n)


//another method
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        
        int len = 1;
        ListNode temp = head;
        while(temp.next != null) {
            temp = temp.next;
            len++;
        }
        
        temp.next = head;
        //a circle linkedlist
        //temp is the rotate end
        
        k %= len;
        
        for(int i = 0; i < len - k; i++) {
            temp = temp.next;
        }
        //find the new end
        
        head = temp.next;
        //the next listnode of the new end is 
        //the new head

        temp.next = null;
        
        return head;
    }
}
time complexity O(n + k)
space complexity O(1)



LC 364:

//2 times of BFS
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int depth = 0;
        Queue<NestedInteger> qu = new LinkedList<>();
        for (NestedInteger element : nestedList) {
            qu.offer(element);
        }
        while (!qu.isEmpty()) {
            depth ++;
            int size = qu.size();
            for (int i = 0; i < size; i ++) {
                NestedInteger tmp = qu.poll();
                List<NestedInteger> tmpList = tmp.getList();
                for (NestedInteger element : tmpList) {
                    qu.offer(element);
                }
            }
        }
        
        int res = 0;
        for (NestedInteger element : nestedList) {
            qu.offer(element);
        }
        while (!qu.isEmpty()) {
            int size = qu.size();
            for (int i = 0; i < size; i ++) {
                NestedInteger tmp = qu.poll();
                if (tmp.isInteger()) {
                    res += tmp.getInteger() * depth;
                } else {
                    List<NestedInteger> tmpList = tmp.getList();
                    for (NestedInteger element : tmpList) {
                        qu.offer(element);
                    }
                }
            }
            depth --;
        }
        
        return res;
    }
}
time complexity O(n)


//better method
//using unweighted and res
//using adding to repeatedly add the number 
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int unweighted =0, res=0;
        while (nestedList.size() != 0) {
            List<NestedInteger> tmp = new ArrayList<>();
            for (NestedInteger element : nestedList) {
                if (element.isInteger()) {
                    unweighted += element.getInteger();
                } else {
                    tmp.addAll(element.getList());
                }
            }
            res += unweighted;
            nestedList = tmp;
        }
        return res;
    }
}
time complexity O(n)

//List.addAll(Collection<T>)



LC 339:

//old method
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }

    private int helper(List<NestedInteger> list, int depth)
    {
        int ret = 0;
        for (NestedInteger e: list)
        {
            ret += e.isInteger()? e.getInteger() * depth: helper(e.getList(), depth + 1);
        }
        return ret;
    }
}

time complexity O(n)


LC 65:

//need to learn more about this solution
class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numSeen = false;
        boolean numAfterE = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numSeen = true;
                numAfterE = true;
            } else if (s.charAt(i) == '.') {
                if (eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if (s.charAt(i) == 'e') {
                if (eSeen || !numSeen) {
                    return false;
                }
                numAfterE = false;
                eSeen = true;
            } else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numSeen && numAfterE;
    }
}


































