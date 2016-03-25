package hihoCoder;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		//while (in.hasNext()) {
			double x=in.nextDouble();
			double y=in.nextDouble();
			double r=in.nextDouble();
			int maxX=(int)Math.floor(x+r);
			int minX=(int)Math.ceil(x-r);

			double res=0;
			int resX=0;
			int resY=0;
			for(int xPos=maxX;xPos>=minX;xPos--){
				double yoffset=Math.sqrt(Math.pow(r, 2)-Math.pow(xPos-x,2));
				int maxY=(int)Math.floor(y+yoffset);
				int minY=(int)Math.ceil(y-yoffset);
				double tmpRes=Math.pow(maxY-y, 2)+Math.pow(xPos-x, 2);
				if(tmpRes>res){
					res=tmpRes;
					resX=xPos;
					resY=maxY;
				}
				tmpRes=Math.pow(minY-y, 2)+Math.pow(xPos-x, 2);
				if(tmpRes>res){
					res=tmpRes;
					resX=xPos;
					resY=minY;
				}
			}
			System.out.println(resX+" "+resY);	
		//}
		in.close();
		
	}
}

