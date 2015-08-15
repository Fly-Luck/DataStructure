package sort;

public class BubbleSort {
	public static void main(String[] args) {
		int a[] = {3,1,5,4,2,7,8,11,10,6};
		sort(a);
		//1,3,4,2,5,7,8,10,6,[11]
		//1,3,2,4,5,7,8,6,[10],11
		//1,2,3,4,5,7,6,[8],10,11
		//1,2,3,4,5,6,[7],8,10,11
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+",");
		}
	}
	private static void sort(int a[]){
		int temp = 0;

		for(int i=a.length-1;i>0;i--){
			for(int j=0;j<i;j++){
				if(a[j]>a[j+1]){
					temp=a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
}
