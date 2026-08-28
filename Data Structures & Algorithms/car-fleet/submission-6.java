class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double [][]fleet=new double[position.length][2];
        Deque <Double> stack=new ArrayDeque<>();
        for(int i=0;i<position.length;i++)
        {
            for(int j=0;j<2;j++)
            {   
                if(j==0)
                    fleet[i][j]=position[i];
                else
                    fleet[i][j]= (double) (target-position[i])/speed[i];
            }
        }
        Arrays.sort(fleet,(a,b)->Double.compare(b[0],a[0]));
        for(double [] i:fleet)
        {
            if(stack.isEmpty())
            {
                stack.push(i[1]);
            }
            else if(i[1]<=stack.peek())
                continue;
            else
            {
                stack.push(i[1]);
            }
        }
        return stack.size();
    }
}
