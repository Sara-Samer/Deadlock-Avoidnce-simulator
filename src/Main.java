import java.util.Scanner;

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
    		if(bn.isSafe()) System.out.println("No DeadLock");
    		//else	System.out.println("DeadLock");
    		//bn.addNeed();
    		
    		
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
}