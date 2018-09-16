LC 243:

class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int distance = Integer.MAX_VALUE;
        int index1 = -1, index2 = -1;
        for (int i = 0; i < words.length; i ++) {
            if (words[i].equals(word1)) {
                index1 = i;
                if (index2 != -1) distance = Math.min(index1 - index2, distance);
            } else if (words[i].equals(word2)) {
                index2 = i;
                if (index1 != -1) distance = Math.min(index2 - index1, distance);
            }
        }
        return distance;
    }
}


LC 244:

//using a hashmap and arraylist
class WordDistance {
    
    Map<String, List<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i ++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i], list);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        int distance = Integer.MAX_VALUE;
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int pointer1 = 0, pointer2 = 0;
        while (pointer1 < list1.size() && pointer2 < list2.size()) {
            int index1 = list1.get(pointer1);
            int index2 = list2.get(pointer2);
            if (index1 < index2) {
                distance = Math.min(index2 - index1, distance);
                pointer1 ++;
            } else {
                distance = Math.min(index1 - index2, distance);
                pointer2 ++;
            }
        }
        return distance;
    }
}



LC 671:

class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        int[] minVal = new int[]{root.val, Integer.MAX_VALUE, 0};
        dfs(root, minVal);
        return (minVal[2] == 1) ? minVal[1] : -1;
    }
    
    private void dfs(TreeNode root, int[] minVal) {
        if (root == null) return;
        if (root.val != minVal[0]) {
            minVal[1] = Math.min(minVal[1], root.val);
            minVal[2] = 1;
            return;
        } else {
            dfs(root.left, minVal);
            dfs(root.right, minVal);
        }
    }
}















































