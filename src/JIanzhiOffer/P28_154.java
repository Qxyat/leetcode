package JIanzhiOffer;

import java.util.*;
public class P28_154 {
    public ArrayList<String> Permutation(String str) {
      ArrayList<String>res=new ArrayList<String>();
      if(str==null||str.length()==0)
          return res;
       char[] data=str.toCharArray();
       Arrays.sort(data);
        StringBuffer sb=new StringBuffer(new String(data));
        
        getResult(res,sb,0);
        
        return res;
  }
  public void getResult(ArrayList<String>res,StringBuffer sb,int pos){
      if(pos>sb.length()-2){
          res.add(sb.toString());
          return ;
      }
      getResult(res, sb, pos+1);
      String originalStr=sb.substring(pos,pos+1);
      for(int i=pos+1;i<sb.length();i++){
          String replaceStr=sb.substring(i,i+1);
          if(!originalStr.equals(replaceStr)){
              sb.replace(pos,pos+1,replaceStr);
              sb.replace(i,i+1,originalStr);
              getResult(res,sb,pos+1);
              sb.replace(pos,pos+1,originalStr);
              sb.replace(i,i+1,replaceStr);
          }
      }
  }
}
