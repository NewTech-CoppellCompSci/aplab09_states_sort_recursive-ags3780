package sortState;

import java.util.*;
import java.io.*; 

public class UnitedStates
{
	// instance variables
	private ArrayList <State> states;
	
	public UnitedStates()
	{
	   states = new ArrayList <State> ();
	   
	   readFile();
	   printStates();
	   
	   System.out.println();
	   System.out.println("=========================");
	   System.out.println("  Sorted by State");
	   System.out.println("=========================");
	   printStates();	
	   
	   menu();
	}
	
	
	
	/*
	 * Merge Sort
	 * 
	 * Use a merge sort to order the ArrayList
	 * by the state's name
	 */
	public void sortStates(int front, int back) {
		if (l < r) {
	        int m = l + (r - l) / 2;
	        mergeSort(arr, l, m);
	        mergeSort(arr, m + 1, r);
	        merge(arr, l, m, r);
	    }
	}

	public static void merge(int[] arr, int l, int m, int r) {
	    int n1 = m - l + 1;
	    int n2 = r - m;
	    int[] L = new int[n1];
	    int[] R = new int[n2];
	    for (int i = 0; i < n1; ++i)
	    	L[i] = arr[l + i];
	    for (int j = 0; j < n2; ++j)
	    		R[j] = arr[m + 1 + j];
	   int i = 0, j = 0;
	   int k = l;
	    while (i < n1 && j < n2) {
	    	if (L[i] <= R[j]) {
	        		arr[k] = L[i];
	        			i++;
	        } else {
	        		arr[k] = R[j];
	            j++;
	        }
	        k++;
	    }
	    while (i < n1) {
	        arr[k] = L[i];
	        	i++;
	        k++;
	    }
	    while (j < n2) {
	        arr[k] = R[j];
	        	j++;
	        k++;
	    }
	}

		
		
		
		
		
		
		
		
	
	
	
	/*
	 * Quick Sort
	 * 
	 * Use a selection sort to order the ArrayList
	 * by the state's capital
	 */
	public void sortCapitals(int low, int high) {
		if (low < high) {
            int pivotIndex = partition(states, low, high);
            quickSort(states, low, pivotIndex-1);
            quickSort(states, pivotIndex+1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
	
		
		
		
		
		
		
	
	
	
	
	
	

    public void menu()
	{
		
		boolean quitSelected = false;
		
		while (!quitSelected) {
			Scanner inKey = new Scanner(System.in);
			
			System.out.println("\n");
			System.out.println("=========================");
			System.out.println("          Menu");
			System.out.println("=========================");
			System.out.println("  1 - Sort by State");
			System.out.println("  2 - Sort by Capital");
			System.out.println("  3 - Exit");
			System.out.print("\n   Enter Selection: ");
			
			
			int choice = inKey.nextInt();
			
			
			switch (choice) {
			case (1):
	
				System.out.println("\n");
				System.out.println("=========================");
				System.out.println("  Sorted by State");
				System.out.println("=========================");
				sortStates(0, states.size() - 1);
				printStates();
				
				break;
			case (2):
	
				System.out.println("\n");
				System.out.println("=========================");
				System.out.println("  Sorted by Capital");
				System.out.println("=========================");
				sortCapitals(0, states.size() - 1);
				printStates();	
				
				break;
			case (3):
				System.out.println("\n\nGoodbye!");
				quitSelected = true;
				break;
			default:
				System.out.println("\nNot a valid Choice:");
				
	
			}
		
		}
		

	}
	
	
	
	
	
	public void printStates()
	{
		for(State s : states)
		{
			System.out.printf("%-15s", s.getName());
			System.out.printf("%-15s", s.getCapital());
			System.out.printf("%-25s", s.getNickname());
			System.out.printf("%10s\n", s.getPopulation());	
		}
	}
	
	public void readFile()
	{
		Scanner scan = null;
		try
		{
			scan = new Scanner(new File("states.txt"));
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("File not Found!");
		}
		
		String name;
		String capital;
		String nickname;
		int population;
		while(scan.hasNextLine())
		{
			name = scan.nextLine();
			capital = scan.nextLine();
			nickname = scan.nextLine();
			population = scan.nextInt();
			if(scan.hasNextLine())
			{
			   String dummy = scan.nextLine();	
			}
			  
			
			State state = new State(name, capital, nickname, population);
			states.add(state);
		}
		
		
		
	}
}