class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean isPossible = true;
        //Creating an adjacencey List
        Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();

        int[] indegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];

       
        //Creating adjacency List and indegree count
        for(int i=0; i<prerequisites.length; i++){
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(src,new ArrayList<Integer>());
            lst.add(dest);
            adjList.put(src,lst);

            //Populating the indegree list
            indegree[dest] += 1;
        }

        System.out.println(adjList);
        System.out.println(Arrays.toString(indegree));
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0)
                q.add(i);
        }

        int i=0;
        while(!q.isEmpty()){
            int node = q.remove();
            topologicalOrder[i++] = node;

            //Reduce indegree in each neighbour by 1
            if(adjList.containsKey(node)){
                for(Integer neighbor : adjList.get(node)){
                    indegree[neighbor]--;

                    if(indegree[neighbor] == 0)
                        q.add(neighbor);
                }
            }
        }

        if(i == numCourses)
            return topologicalOrder;


        return new int[0];
    }
}
