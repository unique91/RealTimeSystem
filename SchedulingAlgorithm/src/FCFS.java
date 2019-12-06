public class FCFS {
	private int[]waitTime, turnTime;
	
	public void calcWaitTime(int[] process, int n) {
		waitTime[0] = 0;   // in our case, first process has allways null waiting time
		for(int i = 1; i < n; i++) {
			waitTime[i] = waitTime[i-1] + process[i-1];
		}
	}
	
	public void calcTurnAroundTime(int[] process, int n) {
		for(int i = 0; i < n; i++) {
			turnTime[i] = process[i] + waitTime[i];
		}
	}
	
	public void printAll(char[] procName, int[] process, int n) {
		waitTime = new int[n];
		turnTime = new int[n];
		int sumWait = 0, sumTurn = 0;
		
		calcWaitTime(process, n);
		calcTurnAroundTime(process, n);
		
		System.out.println("Process | Burst-Time | Wait-Time | Turn-Around-Time");
		for(int i = 0; i < n; i++) {
			sumWait += waitTime[i];
			sumTurn += turnTime[i];
			System.out.println("  " + procName[i] + "            " + process[i] +  "           " + waitTime[i] + "              " + turnTime[i]);
		}
		
		float avgWait = (float)sumWait/(float)n;
		float avgTurn = (float)sumTurn/(float)n;
		System.out.println("Average Waiting-Time = " + avgWait);
		System.out.println("Average Turn-Around-Time = " + avgTurn);
	}
}
