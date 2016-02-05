package leetcode;

public class CompareVersionNumbers_165 {
	 public int compareVersion(String version1, String version2) {
		 int i=0,j=0;
		 while(i<version1.length()&&j<version2.length()){
			 int res1=0;
			 while(i<version1.length()&&version1.charAt(i)!='.'){
				 int tmp1=version1.charAt(i)-'0';
				 res1=res1*10+tmp1;
				 i++;
			 }
			 int res2=0;
			 while(j<version2.length()&&version2.charAt(j)!='.'){
				 int  tmp2=version2.charAt(j)-'0';
				 res2=res2*10+tmp2;
				 j++;
			 }
			 if(res1>res2)
				 return 1;
			 else if(res1<res2)
				 return -1;
			 if(i<version1.length()&&version1.charAt(i)=='.')
				 i++;
			 if(j<version2.length()&&version2.charAt(j)=='.')
				 j++;
		 }
		 if(i==version1.length()&&j==version2.length())
			 return 0;
		 int res=0;
		 String string="";
		 int pos=0;
		 if(i!=version1.length()){
			 res=1;
			 pos=i;
			 string=version1;
		 }
		 else{
			 res=-1;
			 pos=j;
			 string=version2;
		 }
		 
		 while(pos<string.length()){
			 int res1=0;
			 while(pos<string.length()&&string.charAt(pos)!='.'){
				 int tmp1=string.charAt(pos)-'0';
				 res1=res1*10+tmp1;
				 pos++;
			 }
			 if(res1!=0){
				 return res;
			 }
			 if(pos<string.length()&&string.charAt(pos)=='.')
				 pos++;
		 }
		 return 0;
	 }
}
