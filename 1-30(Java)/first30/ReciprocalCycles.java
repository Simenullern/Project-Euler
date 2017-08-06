package first30;

public class ReciprocalCycles {

	public static void main(String [] args){
		int max=0,maxNum=0,chain;
		for(int i=1;i<1000;i++){
			chain=countCycle(i);
			if(chain>max){
				max=chain;
				maxNum=i;
			}
		}
		System.out.println(maxNum);
		System.out.println(max);
	}
	public static int countCycle(int num){
		int [] arr=new int [num];
		int count=0,i;
		for(i=10;i/num==0;i=i*10);
		while(i%num!=0){
			if(arr[i%num]==1)
				return count;
			arr[i%num]=1;
			i=(i%num)*10;
			count++;
		}
		return 0;
	}
}

