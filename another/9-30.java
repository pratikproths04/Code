LC 743:

class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        if (N == 1) return 0;

        int[][] graph = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i ++) {
            for (int j = 0; j <= N; j ++) {
                graph[i][j] = -1;
            }
        }
        
        for (int[] edge : times) {
            graph[edge[0]][edge[1]] = edge[2];
        }
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);        
        boolean[] visited = new boolean[N + 1];
        distance[K] = 0;
        
        int cur = getMin(distance, visited);
        visited[cur] = true;
        while (cur != -1) {
            for (int i = 1; i <= N; i ++) {
                if (graph[cur][i] == -1) continue;
                int newDistance = graph[cur][i] + distance[cur];
                if (distance[i] > newDistance) {
                    distance[i] = newDistance;
                }
            }
            cur = getMin(distance, visited);
            if (cur != -1) visited[cur] = true;
        }
        
        distance[0] = -1;        
        int res = 0;
        for (int i : distance) {
            // System.out.print(i + ", ");
            if (i == Integer.MAX_VALUE) return -1;
            res = Math.max(i, res);
        }
        return res;
    }
    
    private int getMin(int[] distance, boolean[] visited) {
        int index = 0;
        int dist = Integer.MAX_VALUE;
        for (int i = 1; i < distance.length; i ++) {
            if (!visited[i] && distance[i] < dist) {
                dist = distance[i];
                index = i;
            }
        }
        return (dist != Integer.MAX_VALUE)? index : -1;
    }
}
//the use of Djikstra
//each update is using for loop to scan all the matrix


public int networkDelayTime(int[][] times, int N, int K) {
    if (times == null || times.length == 0 || times[0].length == 0) {
    return -1;
    }
    int[][] grid = new int[N + 1][N + 1];
    for (int[] arr : grid) {
        Arrays.fill(arr, Integer.MAX_VALUE);
    }
    for (int[] curEdge : times) {
        grid[curEdge[0]][curEdge[1]] = curEdge[2];
    }

    int[] res = new int[N + 1];
    Arrays.fill(res, Integer.MAX_VALUE);
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(N, new Comparator<Integer>() {
      @Override
      public int compare(Integer c1, Integer c2) {
        return res[c1] - res[c2];
      }
    });
    minHeap.offer(K);
    res[K] = 0;
    while (!minHeap.isEmpty()) {
      Integer start = minHeap.poll();
      for (int i = 1; i <= N; i++) {
        int curWeight = grid[start][i];
        if (curWeight != Integer.MAX_VALUE && res[i] > res[start] + curWeight) {
          res[i] = res[start] + curWeight;
          minHeap.offer(i);
        }
      }
    }
    int count = 0;
    for (int i = 1; i <= N; i++) {
      if (res[i] == Integer.MAX_VALUE) {
        return -1;
      }
      count = Math.max(count, res[i]);
    }
    return count;
}
//Djikstra using PriorityQueue, how to update numbers in pq?
//do not put the numbers into pq!
//put the corresponding index!


LC 228:

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i ++) {
            if (sb.length() == 0) {
                sb.append(nums[i]);
                if (i + 1 >= nums.length || nums[i + 1] != nums[i] + 1) {
                    String tmp = sb.toString();
                    list.add(tmp);
                    sb.setLength(0);
                }
            } else if (i + 1 >= nums.length || nums[i + 1] != nums[i] + 1) {
                String tmp = sb.append("->").append(nums[i]).toString();
                list.add(tmp);
                sb.setLength(0);
            }
        }
        return list;
    }
}
//the use of stringbuilder, and the property of sorted array


LC 444:

class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if (seqs == null || seqs.size() == 0) return false;
        
        int[] pos = new int[org.length + 1];
        for (int i = 0; i < org.length; i ++) {
            pos[org[i]] = i;
        }
        boolean[] visited = new boolean[org.length + 1];
        int pairNum = org.length - 1;
        boolean flag = false;
        
        for (List<Integer> list : seqs) {
            for (int i = 0; i < list.size(); i ++) {
                flag = true;
                if (list.get(i) <= 0 || list.get(i) > org.length) return false;
                if (i == 0) continue;
                int cur = list.get(i), prev = list.get(i - 1);
                if (pos[prev] >= pos[cur]) return false;
                if (!visited[cur] && pos[cur] == pos[prev] + 1) {
                    visited[cur] = true;
                    pairNum --;
                }
            }
        }
        // System.out.println("pairNum: " + pairNum);
        return pairNum == 0 && flag;
    }
}
//Hamilton path and topological sort
/*
	If a topological sort has the property that all pairs of consecutive vertices in the sorted order are connected by edges, 
	then these edges form a directed Hamiltonian path in the DAG. 
	If a Hamiltonian path exists, the topological sort order is unique; no other order respects the edges of the path. 
*/



LC 659:

class Solution {
    public boolean isPossible(int[] nums) {
        if (nums.length < 3) return false;
        
        Map<Integer, Integer> freq = new HashMap<>(), array = new HashMap<>();
        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        for (int i : nums) {
            if (freq.get(i) == 0) {
                continue;
            } else if (array.getOrDefault(i, 0) > 0) {
                array.put(i + 1, array.getOrDefault(i + 1, 0) + 1);
                array.put(i, array.get(i) - 1);  
            } else if (freq.containsKey(i + 1) && freq.get(i + 1) > 0 && freq.containsKey(i + 2) && freq.get(i + 2) > 0) {
                array.put(i + 3, array.getOrDefault(i + 3, 0) + 1);
                freq.put(i + 1, freq.get(i + 1) - 1);
                freq.put(i + 2, freq.get(i + 2) - 1);
            } else {
                return false;
            }
            freq.put(i, freq.get(i) - 1);
        }
        return true;
    }
}
//time complexity is O(n)
//space complexity is O(n)
//the key is to form a new array with at least 3 elements


public boolean isPossible(int[] nums) {
    int pre = Integer.MIN_VALUE, p1 = 0, p2 = 0, p3 = 0;
    int cur = 0, cnt = 0, c1 = 0, c2 = 0, c3 = 0;
        
    for (int i = 0; i < nums.length; pre = cur, p1 = c1, p2 = c2, p3 = c3) {
        for (cur = nums[i], cnt = 0; i < nums.length && cur == nums[i]; cnt++, i++);
            
        if (cur != pre + 1) {
            if (p1 != 0 || p2 != 0) return false;
            c1 = cnt; c2 = 0; c3 = 0;
            
        } else {
            if (cnt < p1 + p2) return false;
            c1 = Math.max(0, cnt - (p1 + p2 + p3));
            c2 = p1;
            c3 = p2 + Math.min(p3, cnt - (p1 + p2));
        }
    }
    
    return (p1 == 0 && p2 == 0);
}
//time complexity is O(n)
//space complexity is O(1)
//The basic idea is that, for each distinct element ele in the input array, 
//we only need to maintain three pieces of information: the number of consecutive subsequences ending at ele with length of 1, 
//length of 2 and length >= 3


int c1 = 0, c2 = 0, c3 = 0;
for (int i = 1, j = 0; i <= nums.length; ++i) {
    if (i < nums.length && nums[i] == nums[i - 1]) continue;
    int repeats = i - j;
    if (repeats < c1 + c2) return false;
    c3 += c2;
    c2 = c1;
    c1 = Math.max(repeats - (c2 + c3), 0);
    c3 = repeats - c1 - c2;
    if (i == nums.length || nums[i] > nums[i - 1] + 1) {
        if (c1 + c2 > 0) return false;
        c3 = 0;
    }
    j = i;
}
return true;
//simpler version
































