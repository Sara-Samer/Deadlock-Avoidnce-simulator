public class Banker{
    int[] available;
    int[][] maximum;
    int[][] allocated;
    int[][] need;
    Banker(int nResources, int nProcesses){
        available = new int[nResources];
        maximum = new int[nProcesses][nResources];
        allocated = new int[nProcesses][nResources];
        need = new int[nProcesses][nResources];
    }
    public void addResource(){

    }
    public void addMax(){

    }
    public void addNeed(){

    }
    public void addAllocated(){

    }
    public boolean isSafe(){
        //TODO Implement safety Algorithm
        /*
        1.
            Let Work and Finish be vectors of length m and n, respectively.
            Initialize: Work = Available
            Finish [i] = false for i = 0, 1, …, n- 1
        2.
            Find an i such that both:
            (a) Finish [i] = false
            (b) Needi  Work
            If no such i exists, go to step 4
        3.
            Work = Work + Allocationi
            Finish[i] = true
            go to step 2
        4.
            If Finish [i] == true for all i, then the system
            is in a safe state
        */
        return true;
    }
    public boolean canGrantRequest(){
        //TODO Implement Request Algorithm
        /*
            Requesti = request vector for process Pi. If
            Requesti [j] = k then process Pi wants k instances
            of resource type Rj
            1.
                If Requesti  Needi go to step 2. Otherwise, raise error
                condition, since process has exceeded its maximum
                claim
            2.
                If Requesti  Available, go to step 3. Otherwise Pi
                must wait, since resources are not available
            3.
                Pretend to allocate requested resources to Pi by
                modifying the state as follows:
                Available = Available – Requesti;
                Allocationi = Allocationi + Requesti;
                Needi = Needi – Requesti;
             If safe  the resources are allocated to Pi
             If unsafe  Pi must wait, and the old resource-allocation state is
            restored
        */
        return true;
    }
}