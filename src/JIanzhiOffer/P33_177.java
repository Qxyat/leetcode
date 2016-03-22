package JIanzhiOffer;

import java.util.Arrays;
import java.util.Comparator;

public class P33_177 {
	public String PrintMinNumber(int [] numbers) {
		String[] data=new String[numbers.length];
		for(int i=0;i<numbers.length;i++)
			data[i]=Integer.toString(numbers[i]);
		Arrays.sort(data, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				String tmp1=o1+o2;
				String tmp2=o2+o1;
				return tmp1.compareTo(tmp2);
			}});
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<numbers.length;i++){
			sb.append(data[i]);
		}
		return sb.toString();
    }
}
