package JIanzhiOffer;

public class P46_223 {
	static class Foo{
        static int res=0;
        public boolean test(int n){
            boolean haha=(n>0)&&(test(n-1));
            res+=n;
            return haha;
        }
    	}
    public int Sum_Solution(int n) {
        Foo foo=new Foo();
        foo.test(n);
        return Foo.res;
    }
}
