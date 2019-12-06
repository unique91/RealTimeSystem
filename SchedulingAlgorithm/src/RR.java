public class RR {
	private int[] waitTime, turnTime;
	
	public void calcWaitTime(int[] process, int n, int q) {
		int[] copyBurst = new int[n];
		for(int i = 0; i < n; i++)
			copyBurst[i] = process[i];
		
		int time = 0;
		while(true) {
			boolean flag = true;
			for(int i = 0; i < n; i++) {
				if(copyBurst[i] > 0) {
					flag = false;
					if(copyBurst[i] > q) {
						time += q;
						copyBurst[i] -= q;
					} else {
						waitTime[i] = copyBurst[i] + time;
						copyBurst[i] = q - time;
						copyBurst[i] = 0;
					}
				}
				if(flag)
					break;
			}
		}
	}
	
	public void calcTurnTime(int[] process, int n) {
		for(int i = 0; i < n; i++) {
			turnTime[i] = process[i] + waitTime[i];
		}
	}
	
	public void printAll(char[] procName, int[] process, int n, int q) {
		int sumWait = 0, sumTurn = 0;
		waitTime = new int[n];
		turnTime = new int[n];
		calcWaitTime(process, n, q);
		
		System.out.println("Process | Burst-Time | Wait-Time | Turn-Around-Time");
		for(int i = 0; i < n; i++) {
			System.out.println("   " + procName[i] + "        " + process[i] + "            " + waitTime[i] + "             " + turnTime[i]);
			sumWait += waitTime[i];
			sumTurn += turnTime[i];
		}
		
		
	}
}
