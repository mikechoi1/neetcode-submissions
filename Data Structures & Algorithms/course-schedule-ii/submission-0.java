class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegrees = new int[numCourses];
        for (int[] prereq : prerequisites) {
            indegrees[prereq[0]]++;
            adj.get(prereq[1]).add(prereq[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        int finished = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            res[finished++] = course;
            for (int futureCourse : adj.get(course)) {
                indegrees[futureCourse]--;
                if (indegrees[futureCourse] == 0) {
                    queue.offer(futureCourse);
                }
            }
        }
        if (finished == numCourses) {
            return res;
        }
        return new int[0];
    }
}
