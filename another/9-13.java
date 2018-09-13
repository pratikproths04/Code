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













