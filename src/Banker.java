import java.util.Arrays;

public class Banker{
    int[] available;
    int[][] maximum;
    int[][] allocated;
    int[][] need;
    int nResources,nProcesses;
    Banker(int nResources, int nProcesses){
        available = new int[nResources];
        maximum = new int[nProcesses][nResources];
        allocated = new int[nProcesses][nResources];
        need = new int[nProcesses][nResources];
        this.nResources= nResources;
        this.nProcesses= nProcesses;
    }
    public void addResource(int resource, int available){
    	this.available[resource] = available;
    }
    public void addMax(int process, int resource, int max){
    	this.maximum[process][resource] = max;
    }
    public void addNeed(){
    	for(int i = 0; i< this.nProcesses ; i++)
    		for(int j = 0; j < this.nResources; j++)
    			this.need[i][j] = this.maximum[i][j] - this.allocated[i][j];
    }
    public void addAllocated(int process, int resource, int alloc){
    	this.allocated[process][resource] = alloc;
    }
    public boolean isSafe(){
        //TODO test safety Algorithm
        int []work = available;                         // 1.Let Work and Finish be vectors of length m and n, respectively. // Initialize: Work = Available
        Boolean[] finish = new Boolean[nProcesses];     //  Finish [i] = false for i = 0, 1, ..., n- 1
        Arrays.fill(finish, Boolean.FALSE);

                                                        /*
                                                        Need: n * m matrix. If Need[i, j] = k, then Pi may need k more instances of Rj to complete its task
                                                         */
        this.addNeed();
//        for (int i = 0; i <nProcesses ; i++) {
//            for (int j = 0; j <nResources ; j++) {
//                //Need [i, j] = Max[i, j] – Allocation [i, j]
//                need[i][j]=maximum[i][j]-allocated[i][j];
//            }
//        }
        boolean unsafeState=false;
        for (int i = 0; i <nProcesses ; i++){ //Find an i such that both:
            if(!finish[i] ){     //a) Finish [i] = false //            (b) Needi <= Work
                for (int j = 0; j <nResources ; j++) {
                    if(!(need[i][j]<= work[j])){
                        break;
                    }
                    if(j==nProcesses-1) {   // if true then we can remove this process
                        finish[i]=true;
                        for (int k = 0; k < nResources ; k++) { //if we remove this process we must return there resource to the work array
                            if(need[i][j]<= work[j]){
                                work[j]+=allocated[i][j];
                            }
                        }
                        i=0;           // and we must search from the first because we can find new process with the new values
                    }
                }
            }
            if(finish[nProcesses-1]) {
                return true; // if we finish all the array we can say "we are at the safe state "
            }
        }
        return false; // if we finished the for i loop with out return true so we are in unsafe state
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
                Available = Available – Requesti;
                Allocationi = Allocationi + Requesti;
                Needi = Needi – Requesti;
             If safe ? the resources are allocated to Pi
             If unsafe ? Pi must wait, and the old resource-allocation state is
            restored
        */
        return true;
    }
}