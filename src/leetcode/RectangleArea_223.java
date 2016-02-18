package leetcode;

public class RectangleArea_223 {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int width=get_length(A,C,E,G);
		int height=get_length(B,D,F,H);
		return (C-A)*(D-B)+(G-E)*(H-F)-width*height;
    }
	public int get_length(int r1b,int r1u,int r2b,int r2u){
		if(r1b<=r2b){
			if(r1u<=r2b){
				return 0;
			}
			else{
				return Integer.min(r1u-r2b, r2u-r2b);
			}
		}
		else{
			return get_length(r2b, r2u, r1b, r1u);
		}
	}
}
