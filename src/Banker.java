import java.util.Arrays;

public class Banker{
    int[] available;
    int[][] maximum;
    int[][] allocated;
    int[][] need;
    int[] processSequence;
    int nResources,nProcesses;
    Banker(int nResources, int nProcesses){
        available = new int[nResources];
        maximum = new int[nProcesses][nResources];
        allocated = new int[nProcesses][nResources];
        need = new int[nProcesses][nResources];
        processSequence = new int[nProcesses];
        this.nResources= nResources;
        this.nProcesses= nProcesses;
    }
    public void addResource(int resource, int available){
    	this.available[resource] = available;
    }
    public void addMax(int process, int resource, int max){
    	this.maximum[process][resource] = max;
    }
    /*public void addNeed(){
    	for(int i = 0; i< this.nProcesses ; i++)
    		for(int j = 0; j < this.nResources; j++)
    			this.need[i][j] = this.maximum[i][j] - this.allocated[i][j];
    }*/
    public void updateNeed(int process, int resource, int value){
		this.need[process][resource] = value;
    }
    public void addAllocated(int process, int resource, int alloc){
    	this.allocated[process][resource] = alloc;
    }
    public boolean isSafe(){
        //TODO test safety Algorithm
        // 1.Let Work and Finish be vectors of length m and n, respectively. 

        // Initialize: Work = Available
        int[] work = new int[nResources];                         
        for(int i = 0 ; i < nResources; i++)
            work[i] = available[i];
            
        //  Finish [i] = false for i = 0, 1, ..., n- 1
        Boolean[] finish = new Boolean[nProcesses];     
        Arrays.fill(finish, Boolean.FALSE);
        
        
        //Need: n * m matrix. 
        //If Need[i, j] = k, then Pi may need k more instances of Rj to complete its task
        Arrays.fill(processSequence, -1);
        												
        //this.addNeed();
        
        int count = 0;
        for (int i = 0; i <nProcesses ; i++){ 
            //Find an i such that both:
            //(a) Finish [i] = false 
            //(b) Need[i] <= Work aka: available
            if(!finish[i] ){      
                for (int j = 0; j <nResources ; j++) {
                    if((need[i][j] > work[j])){
                        break;
                    }
                    //If true then we can remove this process
                    if(j == nResources-1) {   
                        finish[i]=true;
                    	processSequence[count++] = i;
                        //if we remove this process we must return there resource to the work array
                        for (int k = 0; k < nResources ; k++) { 
                        	work[k] += allocated[i][k];
                        }
                        // and we must search from the first because we can find new process with the new values
                        i = -1;           
                    }
                }
            }
        }
        // if we finished the for i loop with out return true so we are in unsafe state
        return count == this.nProcesses? true: false ; 
    }
    public int[] getSequence(){
        return this.processSequence;
    }
    public boolean canGrantRequest(){
        //TODO Implement Request Algorithm
        /*
            Requesti = request vector for process Pi. If
            Requesti [j] = k then process Pi wants k instances
            of resource type Rj
            1.
                If Requesti ? Needi go to step 2. Otherwise, raise error
                condition, since process has exceeded its maximum
                claim
            2.
                If Requesti ? Available, go to step 3. Otherwise Pi
                must wait, since resources are not available
            3.
                Pretend to allocate requested resources to Pi by
                modifying the state as follows:
                Available = Available � Requesti;
                Allocationi = Allocationi + Requesti;
                Needi = Needi � Requesti;
             If safe ? the resources are allocated to Pi
             If unsafe ? Pi must wait, and the old resource-allocation state is
            restored
        */
        return true;
    }
}