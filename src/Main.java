import java.util.Scanner;

enum Flag{MAX_CLAIM_EXCEEDED, PROCESS_WAITING, REQUEST_IS_NOT_SAFE, RESOURCES_ALLOCATED};

public class Main{
    public static void main(String[] args) {
    		System.out.print("Processes Number: ");
    		Scanner sc = new Scanner(System.in);
    		int nProcess = sc.nextInt();
    		System.out.print("Resources Number: ");
    		sc.reset();
    		int nResources = sc.nextInt();
    		Banker bn = new Banker(nResources, nProcess);
    		System.out.println("-----------------------------------");
    		System.out.println("Add Allocation:");
    		//--------------------------------------------------------------------
    		System.out.print("   ");
    		for(int i = 0 ; i < nResources; i++) {
    			System.out.print("R" + (i+1) + " ");
    		}
    		System.out.println();
    		for(int i = 0; i < nProcess ; i++) {
    			System.out.print("P" + i + " ");
    			for(int j = 0 ; j < nResources; j++) {
    				sc.reset();
    				bn.addAllocated(i, j, sc.nextInt());    				
    			}
    		}
    		System.out.println("-----------------------------------");
    		System.out.println("Add Max:");
    		//--------------------------------------------------------------------
    		System.out.print("   ");
    		for(int i = 0 ; i < nResources; i++) {
    			System.out.print("R" + (i+1) + " ");
    		}
    		System.out.println();
    		for(int i = 0; i < nProcess ; i++) {
    			System.out.print("P" + i + " ");
    			for(int j = 0 ; j < nResources; j++) {
    				sc.reset();
    				bn.addMax(i, j, sc.nextInt());    				
    			}
    		}
    		System.out.println("-----------------------------------");
    		System.out.println("Add Available:");
    		//----------------------------------------------------------------------
    		for(int i = 0; i < nResources; i++) {
    			System.out.print("R" + (i+1) + " : ");
    			sc.reset();
    			bn.addResource(i, sc.nextInt());
    		}
    		System.out.println("-----------------------------------");
    		if(bn.isSafe()){
				System.out.println("No DeadLock");
				printSequence(nProcess, bn.getSequence());
			}else{
				System.out.println("DeadLock");
			}
			
    		
    		
    		//--------------------------------------------------------------------
    		/*System.out.print("All:");
    		for(int i = 0 ; i < nResources; i++) {
    			System.out.print("R" + (i+1) + " ");
    		}
    		System.out.println();
    		for(int i = 0; i < nProcess ; i++) {
    			System.out.print("P" + i + " ");
    			for(int j = 0 ; j < nResources; j++) {
    				System.out.print(bn.allocated[i][j]+ "  ");    				
    			}
    			System.out.println();
    		}
    		System.out.print("Max:");
    		for(int i = 0 ; i < nResources; i++) {
    			System.out.print("R" + (i+1) + " ");
    		}
    		System.out.println();
    		for(int i = 0; i < nProcess ; i++) {
    			System.out.print("P" + i + " ");
    			for(int j = 0 ; j < nResources; j++) {
    				System.out.print(bn.maximum[i][j]+ "  ");    				
    			}
    			System.out.println();
    		}
    		System.out.print("Need");
    		for(int i = 0 ; i < nResources; i++) {
    			System.out.print("R" + (i+1) + " ");
    		}
    		System.out.println();
    		for(int i = 0; i < nProcess ; i++) {
    			System.out.print("P" + i + " ");
    			for(int j = 0 ; j < nResources; j++) {
    				System.out.print(bn.need[i][j]+ "  ");    				
    			}
    			System.out.println();
    		}
    		System.out.print("avail:");
    		for(int i = 0 ; i < nResources; i++) {
    			System.out.print("R" + (i+1) + " ");
    		}
    		System.out.println();
    		for(int i = 0; i < nResources ; i++) {
    				System.out.print(bn.available[i]+ "  ");    				
    			
    			System.out.println();
    		}
    		*/
	}
	public static void printSequence(int count, int[] processSequence){
			System.out.println("The sequence to satisfy the safety criteria: ");
			for(int i = 0 ; i < count ; i++) {
				System.out.print("P" + processSequence[i]);
				if(i != count - 1)	System.out.print(", ");
			}
			System.out.println();
			// if we finish all the array we can say "we are at the safe state "
	}
	public static void requestMore(Banker bn){
		System.out.println("Do you want to make more requests?");
			String addAnother = "y";
			Scanner sc = new Scanner(System.in);
			while(addAnother.equals("y")){
				System.out.println("Enter Process number: ");
				int num = sc.nextInt();
				num--;
				if(num >)
			}
	}
}