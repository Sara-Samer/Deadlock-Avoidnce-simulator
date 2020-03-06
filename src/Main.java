import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
    		System.out.println("Processes Number: ");
    		Scanner sc = new Scanner(System.in);
    		int nProcess = sc.nextInt();
    		System.out.print("Resources Number: ");
    		sc.reset();
    		int nResources = sc.nextInt();
    		Banker bn = new Banker(nResources, nProcess);
    		
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
    		
    		System.out.println("Add Available:");
    		//----------------------------------------------------------------------
    		for(int i = 0; i < nResources; i++) {
    			System.out.print("R" + (i+1) + " : ");
    			sc.reset();
    			bn.addResource(i, sc.nextInt());
    		}
    		
    		//bn.addNeed();
    		
    		
    		//--------------------------------------------------------------------
    		/*System.out.print("   ");
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
    		}*/
    }
}