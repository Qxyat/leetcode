package leetcode;

public class GasStation_134 {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		
		for(int i=0;i<gas.length;){
			int count=0;
			int start=i;
			int pos=start;
			int rest=0;
			while(count<gas.length&&rest+gas[pos]-cost[pos]>=0){
				rest=rest+gas[pos]-cost[pos];
				i=i+1;
				pos=i%gas.length;
				count++;
			}
			if(count==gas.length)
				return start;
			i++;
			if(i>=gas.length)
				return -1;
		}
		return -1;
    }
}
