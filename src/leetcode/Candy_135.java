package leetcode;

public class Candy_135 {
	
	public int candy(int[] ratings) {
		int[] first=new int[ratings.length];
		int[] last=new int[ratings.length];
		
		first[0]=1;
		for(int i=1;i<ratings.length;i++){
			if(ratings[i]>ratings[i-1])
				first[i]=first[i-1]+1;
			else
				first[i]=1;
		}
		last[ratings.length-1]=1;
		for(int i=ratings.length-2;i>=0;i--){
			if(ratings[i]>ratings[i+1])
				last[i]=last[i+1]+1;
			else
				last[i]=1;
		}
		int result=0;
		for(int i=0;i<ratings.length;i++){
			result+=Integer.max(first[i], last[i]);
		}
		return result;
    }
}
