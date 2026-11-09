class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) { 
    
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        int [] pre=new int[numCourses];
        Deque<Integer>queue=new ArrayDeque<>();
        for(int i=0;i<prerequisites.length;i++){
            int course=prerequisites[i][0];
            int prereq=prerequisites[i][1];
            pre[course]++;
            adjList.get(prereq).add(course);
        }
        for(int i=0;i<pre.length;i++){
            if(pre[i]==0)queue.add(i);
        }
        int result=0;
        while(!queue.isEmpty()){
            int pop=queue.poll();
            result++;
            List course=adjList.get(pop);
            if(course==null)continue;
            for(int i=0;i<course.size();i++){
                pre[(int) course.get(i)]--;
                if(pre[(int) course.get(i)]==0)queue.add((int) course.get(i));
            }
        }
        if (result==numCourses) return true;
        return false;
    }
}
