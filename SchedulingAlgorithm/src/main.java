import java.nio.channels.NonReadableChannelException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		System.out.println(" __________________________________ ");
		System.out.println("| **** Choose your Algorithm ***** |");
		System.out.println("| 1. First Come First Serve (FCFS) |");
		System.out.println("| 2. Shorted Job First (SJF)       |");
		System.out.println("| 3. Round Robin (RR)              |");
		System.out.println(" __________________________________ ");

		Scanner sc = new Scanner(System.in);
		System.out.print("Choose your Process size = ");
		int n = sc.nextInt();
		
		char c = 'A';
		char[] procName = new char[n];
		int[] process = new int[n];
		System.out.println("Process | Burst-Time");
		for(int i = 0; i < n; i++) {
			procName[i] = c;
			System.out.print("  " + c++ + "           ");
			process[i] = sc.nextInt();
		}
		
		System.out.print("Choose your Algorithm ");
		int choose = sc.nextInt();
		
		System.out.println();
		switch (choose) {
		case 1:
			System.out.println("****** Your choice was FCFS ******");
			FCFS fcfs = new FCFS();
			fcfs.printAll(procName, process, n);
			break;
		case 2:
			break;
		case 3:
			System.out.println("****** Your choice was RR ******");
			RR rr = new RR();
			System.out.print("Quantum = ");
			int q = sc.nextInt();
			rr.printAll(procName, process, n, q);
			break;
		default:
			break;
		}
	}

}
