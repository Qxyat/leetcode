package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII_229 {
	public List<Integer> majorityElement(int[] nums) {
        List<Integer> res=new ArrayList<Integer>();
        int count1=0,count2=0,num1=0,num2=0;
        for(int tmp:nums){
        	if(count1==0&&tmp!=num2){
        		num1=tmp;
        		count1++;
        	}
        	else if(count2==0&&tmp!=num1){
        		num2=tmp;
        		count2++;
        	}
        	else{
        		if(tmp==num1){
        			count1++;
        			
        		}
        		else if(tmp==num2){
        			count2++;
        			
        		}
        		else{
        			count1--;
        			count2--;
        		}
        	}
        }
        
        if(count1!=0){
        	int num=0;
            for(int tmp:nums){
            	if(tmp==num1)
            		num++;
            }
            if(num>nums.length/3)
            	res.add(num1);
        }
        if(count2!=0){
        	int num=0;
            for(int tmp:nums){
            	if(tmp==num2)
            		num++;
            }
            if(num>nums.length/3)
            	res.add(num2);
        }
        return res;
    }
}
