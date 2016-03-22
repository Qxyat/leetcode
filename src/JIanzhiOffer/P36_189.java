package JIanzhiOffer;

public class P36_189 {
	public int InversePairs(int [] array) {
		if(array==null||array.length==0)
			return 0;
		return	sort(array,0,array.length-1);
    }
	public int sort(int[] array,int left,int right){
		if(left==right)
			return 0;
		int mid=(left+right)>>1;
		int leftRes=sort(array, left, mid);
		int rightRes=sort(array, mid+1, right);
		int curRes=0;
		int[] tmp=new int[right-left+1];
		int leftLen=mid-left+1;
		int rightLen=right-mid;
		int posLeft=0;
		int posRight=0;
		while(posLeft<leftLen&&posRight<rightLen){
			if(array[left+posLeft]<array[mid+1+posRight]){
				tmp[posLeft+posRight]=array[left+posLeft];
				curRes=curRes+posRight;
				posLeft++;
			}
			else if(array[left+posLeft]>array[mid+1+posRight]){
				tmp[posLeft+posRight]=array[mid+1+posRight];
				//curRes=curRes+leftLen-posLeft;
				posRight++;
			}
            else{
            	int tmpPos=posRight;
                int curVal=array[posLeft+left];
                while(posLeft<leftLen&&array[posLeft+left]==curVal){
                    tmp[posLeft+posRight]=array[left+posLeft];
                    posLeft++;
                    curRes+=tmpPos;
                }
                while(posRight<rightLen&&array[posRight+mid+1]==curVal){
                    tmp[posLeft+posRight]=array[posRight+mid+1];
                    posRight++;
                }
            }
		}
		while(posLeft<leftLen){
			tmp[posLeft+posRight]=array[left+posLeft];
			curRes=curRes+posRight;
			posLeft++;
		}
		while(posRight<rightLen) {
			tmp[posLeft+posRight]=array[mid+1+posRight];
			//curRes=curRes+leftLen-posLeft;
			posRight++;
			
		}
		for(int i=0;i<leftLen+rightLen;i++){
			array[left+i]=tmp[i];
		}
		return leftRes+rightRes+curRes;
	}   
}
