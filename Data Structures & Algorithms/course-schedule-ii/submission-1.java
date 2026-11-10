class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //Final output array
        int []out=new int[numCourses];
        //Queue is here
        Deque<Integer>queue=new ArrayDeque<>();
        //Adjacecney list adjList
        List<List<Integer>>adjList=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<Integer>());
        }
        //Array to keep note of prerequisiets numPre
        int [] numPre=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            int course=prerequisites[i][0];
            int prereq=prerequisites[i][1];
            adjList.get(prereq).add(course);
            numPre[course]++;
        }
        for(int i=0;i<numCourses;i++){
            if(numPre[i]==0)queue.add(i);
        }
        int result=0;
        List<Integer>finale=new ArrayList<>();
        while(!queue.isEmpty()){
            int pre=queue.poll();
            result++;
            List<Integer> temp=adjList.get(pre);
            for(int i=0;i<temp.size();i++){
                if(--numPre[temp.get(i)]==0) queue.add(temp.get(i));
            }
            finale.add(pre);
        }
        if(result==numCourses){
            for(int i=0;i<numCourses;i++){
                out[i]=finale.get(i);
            }
            return out;
        }
        return new int[]{};
    }
}
