package leetcode;

public class BullsandCows_299 {
	public String getHint(String secret, String guess) {
		int []secretDigits=new int[10];
		int []guessDigits=new int[10];
		int bullCount=0;
		int cowCount=0;
		for(int i=0;i<secret.length();i++){
			 int secretDigit=secret.charAt(i)-'0';
			 int guessDigit=guess.charAt(i)-'0';
			 if(secretDigit==guessDigit){
				 bullCount++;
			 }else{
				 secretDigits[secretDigit]++;
				 guessDigits[guessDigit]++;
			 }
		}
		for(int i=0;i<10;i++){
			cowCount+=Integer.min(secretDigits[i], guessDigits[i]);
		}
		return bullCount+"A"+cowCount+"B";
    }
}
