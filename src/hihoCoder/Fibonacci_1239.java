package hihoCoder;

import java.util.Scanner;

public class Fibonacci_1239 {
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int[] data=new int[n];
		int[] fi=new int[30];
		for(int i=0;i<n;i++){
			data[i]=scanner.nextInt();	
		}
		scanner.close();
		for(int i=0;i<30;i++){
			if(i<=1){
				fi[i]=1;
			}
			else{
				fi[i]=fi[i-1]+fi[i-2];
			}
		}
		int[][] res=new int[31][n+1];
		int one_count=0;
		for(int j=1;j<=n;j++){
			int tmpData=data[j-1];
			if(tmpData==1){
				res[1][j]=++one_count;
			}
			else{
				res[1][j]=res[1][j-1];
			}
		}
		for(int i=2;i<=30;i++){
			for(int j=1;j<=n;j++){
				int tmpData=data[j-1];
				int tmpFi=fi[i-1];
				
				if(tmpData==tmpFi){
					res[i][j]=res[i][j-1]+res[i-1][j-1];
				}
				else {
					res[i][j]=res[i][j-1];
				}
			}
		}
		int result=0;
		for(int i=30;i>=1;i--){
			result+=res[i][n];
		}
		System.out.println(result);
	}
}
