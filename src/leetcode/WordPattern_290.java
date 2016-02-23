package leetcode;

import java.util.HashMap;

public class WordPattern_290 {
	public boolean wordPattern(String pattern, String str) {
       HashMap<Character, String>data=new HashMap<Character,String>();
       HashMap<String, Character>data2=new HashMap<String, Character>();
       int strpos=0;
       for(int i=0;i<pattern.length();i++){
    	   char tmp=pattern.charAt(i);
    	   StringBuffer stringBuffer=new StringBuffer();
    	   while(strpos<str.length()&&str.charAt(strpos)!=' '){
    		   stringBuffer.append(str.charAt(strpos));
    		   strpos++;
    	   }
    	   if(strpos<str.length())
    		   strpos++;
    	   if(data.containsKey(tmp)){
    		   if(!data.get(tmp).equals(stringBuffer.toString())){
    			   return false;
    		   }
    	   }
    	   else{
    		   if(data2.containsKey(stringBuffer.toString()))
    			   return false;
    		  
    	   }
    	   data2.put(stringBuffer.toString(), tmp);
    	   data.put(tmp, stringBuffer.toString());
       }
       if(strpos<str.length())
    	   return false;
       return true;
    }
}
