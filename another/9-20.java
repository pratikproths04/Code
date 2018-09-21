LC 134:

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0) return -1;
        int[] left = new int[gas.length];
        int sumup = 0, startIndex = 0, record = 0;
        
        for (int i = 0; i < gas.length; i ++) {
            left[i] = gas[i] - cost[i];
            sumup += left[i];
            record += left[i];
            if (record < 0) {
                record = 0;
                startIndex = i + 1;
            }
        }
        
        if (sumup < 0 || startIndex >= gas.length) return -1;
        
        record = 0;
        for (int i = startIndex; ; i = (i + 1) % gas.length) {
            record += left[i];
            if (record < 0) return -1;
            if (i == (startIndex + gas.length - 1) % gas.length) break;
        }
        return startIndex;
    }
}
//I think my method is better, you have to check the final solution in case of no solution exists
//int[] left can always be replaced by gas[i] - cost[i]
//which decrease the space complexity



LC 162:

//my old method
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1 || nums[0] > nums[1]) return 0;
        if(nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (mid - 1 >= 0 && mid + 1 < nums.length && nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) return mid;
            else if (mid - 1 < 0 || mid + 1 < nums.length && nums[mid] <= nums[mid + 1] && nums[mid] > nums[mid - 1]) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}


//recursion method
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        return findPeakElement(nums, 0, nums.length - 1);
    }
    
    int findPeakElement(int[] nums, int start, int end) {
        if (end < start) return -1;
        int middle = (start + end) / 2;
        int leftValue = middle - 1 >= 0 ? nums[middle-1] : Integer.MIN_VALUE;
        int rightValue = middle + 1 < nums.length ? nums[middle+1] : Integer.MIN_VALUE;
        if (nums[middle] > leftValue && nums[middle] > rightValue) return middle;
        else if (nums[middle] < rightValue) {
            return findPeakElement(nums, middle + 1, end);
        } else {
            return findPeakElement(nums, start, middle - 1);
        }
    }
}



LC 205:
class Solution {
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
                map[each] = order;
                sb.append(order);
                order ++;
            }
            else {
                sb.append(map[each]);
            }
        }
        
        return sb.toString();
    }
}
//empty is '\0'


class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || s.length() <= 1) return true; 
        char[] sMap = new char[256];
        char[] tMap = new char[256];
        
        for (int i = 0; i < s.length(); i ++) {
            char sele = s.charAt(i);
            char tele = t.charAt(i);
            if (sMap[sele] == '\0' && tMap[tele] == '\0') {
                sMap[sele] = tele;
                tMap[tele] = sele;
            } else if (sMap[sele] != tele || tMap[tele] != sele) {
                return false;
            }
        }
        
        return true;
    }
}



LC 249:

class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        
        for (String temp : strings) {
            char[] tempChar = temp.toCharArray();
            StringBuilder buildStr = new StringBuilder();
            buildStr.append('0');
            for (int i = 1; i < tempChar.length; i ++) {
                buildStr.append((char) ((tempChar[i] - tempChar[0] + 26) % 26 + 97));
            }
            String key = buildStr.toString();
            
            if (map.containsKey(key)) map.get(key).add(temp);
            else {
                ArrayList<String> tempList = new ArrayList<>();
                tempList.add(temp);
                map.put(key, tempList);
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, ArrayList<String>> each : map.entrySet()) {
            res.add(each.getValue());
        }
        
        return res;
    }
}


//new method, using the 26
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
            //move the + 26 from below to the above
            sb.append('a' + diff);
        }
        return sb.toString();
    }
}


LC 253:

class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b) {
                if (a.start != b.start) {
                    return a.start - b.start;
                } else {
                    return a.end - b.end;
                }
            }
        });
        List<Integer> list = new ArrayList<>();
        for (Interval interval : intervals) {
            int size = list.size();
            if (size == 0) {
                list.add(interval.end);
            } else {
                int i = 0;
                boolean set = false;
                for (; i < size; i ++) {
                    if (list.get(i) <= interval.start) {
                        list.set(i, interval.end);
                        set = true;
                        break;
                    }
                }
                if (!set) {
                    list.add(interval.end);
                }
            }
        }
        return list.size();
    }
}
//greedy algorithm































































