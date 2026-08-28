class MinStack {
    private int head=0;
    private int arr[];
    private int DEFAULT_SIZE=10;
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(head==0)
        {
            arr=new int[10];
            arr[head]=val; 
            head++;       
        }
        else if(head>=arr.length)
        {
            int temp[]=new int[arr.length+10];
            for(int i=0;i<arr.length;i++)
            {
                temp[i]=arr[i];
            }
            arr=temp;
            arr[head]=val;
            head++;
        }
        else
        {
            arr[head]=val;
            head++;
        }
    }
    
    public void pop() {
        arr[--head]=0;
    }
    
    public int top() {
        return arr[head-1];
    }
    
    public int getMin() {
        int index=head-1;
        int smallest=arr[index];
        while(index!=-1)
        {
            if(arr[index]<smallest)
            {
                smallest=arr[index];
            }
            index--;
        }
        return smallest;
    }
}
