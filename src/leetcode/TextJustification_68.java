package leetcode;

import java.util.ArrayList;
import java.util.List;

public class TextJustification_68 {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res=new ArrayList<String>();
		List<Integer> words_len=new ArrayList<Integer>();
		
		for(int i=0;i<words.length;i++){
			words_len.add(words[i].length());
		}
		int begin=0;
		int end=0;
		int numOfCharacters=0;
		int countOfCharacter=0;
		int numOfWhitespaces=0;
		int countOfWhitespaces=0;
		while(begin<words.length){
			end=begin+1;
			numOfCharacters=words[begin].length();
			countOfCharacter=1;
			numOfWhitespaces=0;
			countOfWhitespaces=0;
			while(end<words.length&&numOfCharacters+words[end].length()+1<=maxWidth-numOfWhitespaces){
				numOfCharacters+=words[end].length();
				countOfCharacter++;
				numOfWhitespaces+=1;
				end++;			
			}
			numOfWhitespaces=maxWidth-numOfCharacters;
			countOfWhitespaces=(countOfCharacter==1?1:countOfCharacter-1);
			StringBuffer one_res=new StringBuffer();
			
			for(int i=begin;i<end;i++){
				one_res.append(words[i]);
				int tmpWhitespace=0;
				if(countOfWhitespaces!=0){
					if(numOfWhitespaces%countOfWhitespaces==0){
						tmpWhitespace=numOfWhitespaces/countOfWhitespaces;
					}
					else{
						tmpWhitespace=numOfWhitespaces/countOfWhitespaces+1;
					}
					numOfWhitespaces-=tmpWhitespace;
					countOfWhitespaces--;
					one_res.append(getWhitespaceString(tmpWhitespace));
				}
			}
			res.add(one_res.toString());
			begin=end;
		}
		res.remove(res.size()-1);
		begin=end-countOfCharacter;
		StringBuffer tmp=new StringBuffer();
		numOfCharacters=words[begin].length();
		numOfWhitespaces=0;
		tmp.append(words[begin]);
		for(int i=begin+1;i<end;i++){
			tmp.append(" ");
			tmp.append(words[i]);
			numOfCharacters+=words[i].length();
			numOfWhitespaces+=1;
		}
		int restWhitespaces=maxWidth-numOfCharacters-numOfWhitespaces;
		tmp.append(getWhitespaceString(restWhitespaces));
		res.add(tmp.toString());
		return res;
    }
	String getWhitespaceString(int count){
		StringBuffer stringBuffer=new StringBuffer();
		for(int i=0;i<count;i++)
			stringBuffer.append(" ");
		return stringBuffer.toString();
	}
}
