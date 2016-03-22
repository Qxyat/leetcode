package leetcode;

public class SuperUglyNumber_313 {
	public int nthSuperUglyNumber(int n, int[] primes) {
		long[] res=new long[n];
		int[] pointers=new int[primes.length];
		res[0]=1;
		int count=0;
		while(count<n-1){
			long min=Long.MAX_VALUE;
			for(int i=0;i<primes.length;i++){
				min=Long.min(min, res[pointers[i]]*primes[i]);
			}
			for(int i=0;i<primes.length;i++){
				if(res[pointers[i]]*primes[i]==min){
					pointers[i]++;
				}
			}
			
			count++;			
			res[count]=min;
		}
		
		return (int)res[n-1];
    }
}
