package leetcode;

public class IntegertoEnglishWords_273 {
	int billion=1000000000;
    int million=1000000;
    int thousand=1000;
    int hundred=100;
    int ten=10;
    String[] tenStr=new String[]{"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    String[] geStr=new String[]{"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
    							"Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
	public String numberToWords(int num) {
		if(num/billion!=0){
			int before=num/billion;
			int after=num%billion;
			if(after!=0)
				return numberToWords(before)+" Billion "+numberToWords(after);
			else 
				return numberToWords(before)+" Billion";
		}
		else if(num/million!=0){
			int before=num/million;
			int after=num%million;
			if(after!=0)
				return numberToWords(before)+" Million "+numberToWords(after);
			else
				return numberToWords(before)+" Million";
		}
		else if(num/thousand!=0){
			int before=num/thousand;
			int after=num%thousand;
			if(after!=0)
				return numberToWords(before)+" Thousand "+numberToWords(after);
			else
				return numberToWords(before)+" Thousand";
		}
		else if(num/hundred!=0){
			int before=num/hundred;
			int after=num%hundred;
			if(after!=0)
				return numberToWords(before)+" Hundred "+numberToWords(after);
			else
				return numberToWords(before)+" Hundred";
		}
		else if(num/ten!=0){
			if(num<20){
				return geStr[num];
			}
			int before=num/10;
			int after=num%10;
			if(after!=0)
				return tenStr[before]+" "+geStr[after];
			else
				return tenStr[before];
		}
		else if(num!=0){
			return geStr[num];
		}
		else{
			return "Zero";
		}
    }
}
