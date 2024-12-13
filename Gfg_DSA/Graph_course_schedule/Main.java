import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Main{
    public static boolean courseShedule(int numCourses, int[][] dependecies){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        // List<List<Integer>> adj = new ArrayList<>(numCourses);

        for(int[] edge : dependecies){
            graph.get((edge[1])).add(edge[0]);
            indegree[edge[0]] += 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        int nodesVisited = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            nodesVisited++;

            for(int neighbor : graph.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }
        return nodesVisited == numCourses;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};

        boolean result = courseShedule(numCourses, prerequisites);
        System.out.println("Can all courses be finished? " + result);
    }
}