package leetcode;

import java.util.HashMap;

public class MaxPointsonaLine_149 {
	public class Pair{
		double k;
		double b;
		int x;
		public Pair(double k,double b,int x) {
			this.k=k;
			this.b=b;
			this.x=x;
		}
	}
	public int maxPoints(Point[] points) {
        if(points.length<2)
        	return points.length;
        HashMap<Pair, Integer> cache=new HashMap<Pair,Integer>();
        int res=0;
        for(int i=1;i<points.length;i++){
        	for(int j=0;j<i;j++){
        		Pair pair=GeneratePair(points[j], points[i]);
        		int tmp;
        		if(cache.containsKey(pair)){
        			tmp=cache.get(pair);
        			tmp++;
        		}
        		else{
        			tmp=2;
        		}
        		res=Integer.max(res, tmp);
    			cache.put(pair, tmp);
        	}
        }
        return res;
    }
	public Pair GeneratePair(Point p1,Point p2){
		if(p1.x==p2.x){
			return new Pair(0, 0, p1.x);
		}
		double k=((double)p1.y-p2.y)/(p1.x-p2.x);
		double b=p1.y-k*p1.x;
		return new Pair(k, b, 0);
	}
}
