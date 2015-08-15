package sort;

public class SelectSort {
	public static void main(String[] args) {
		int a[] = {7,4,3,2,1};
		sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+",");
		}
	}

	private static void sort(int[] a) {
		int temp=0,minIndex;
		for(int i=0;i<a.length-1;i++){
			minIndex = i;
			for(int j=i+1;j<a.length;j++){
				if(a[minIndex]>a[j])
					minIndex = j;
				if(minIndex!=i){
					temp=a[minIndex];
					a[minIndex] = a[i];
					a[i] = temp;
				}
			}
		}
	}
}
