package sort;

public class InsertSort {

	public static void main(String[] args) {
		int a[] = {6,3,5,8,4,9,1,2};
		sort(a);
		//[6],3,5,8,4,9,1,2
		//3,[6],5,8,4,9,1,2
		//3,5,[6],8,4,9,1,2
		//3,5,6,[8],4,9,1,2
		//3,4,5,6,8,[9],1,2
		//3,4,5,6,8,9,[1],2
		//1,3,4,5,6,8,9,[2]
		//1,2,3,4,5,6,8,9
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+",");
		}
	}

	private static void sort(int[] a) {
		int i,j,temp;
		for(i=1;i<a.length;i++){
			j=i;
			temp=a[i]; 
			while(j>0 && temp<a[j-1]){
				a[j] = a[j-1];
				j--;
			}
			a[j] = temp;
		}
			
	}
}
