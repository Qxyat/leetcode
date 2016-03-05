package leetcode;

import java.util.HashMap;

public class MaxPointsonaLine_149 {
	
	public int maxPoints(Point[] points) {
        int res=0;
        HashMap<Integer, HashMap<Integer, Integer>>cache=new HashMap<Integer,HashMap<Integer,Integer>>();
        for(int i=0;i<points.length;i++){
        		cache.clear();
        		int same=0;
        		int max=0;
        		for(int j=i+1;j<points.length;j++){
        			int x=points[j].x-points[i].x;
        			int y=points[j].y-points[i].y;
        			if(x==0&&y==0){
        				same++;
        				continue;
        			}
        			int gcd=generateGCD(x, y);
        			x/=gcd;
        			y/=gcd;
        			if(cache.containsKey(x)){
        				if(cache.get(x).containsKey(y)){
        					cache.get(x).put(y, cache.get(x).get(y)+1);
        				}
        				else{
        					cache.get(x).put(y, 1);
        				}
        			}
        			else{
        				HashMap<Integer, Integer>tmp=new HashMap<Integer,Integer>();
        				tmp.put(y, 1);
        				cache.put(x, tmp);
        			}
        			max=Integer.max(max, cache.get(x).get(y));
        		}
        		res=Integer.max(res, max+same+1);
        }
        return res;
    }
	public int generateGCD(int a,int b){
		if(b==0)
			return a;
		return generateGCD(b, a%b);
	}
}
