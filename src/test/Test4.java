package test;

public class Test4 {
	public static void main(String[] args) {
		int x = 65535;
		while(x>0){
			x = x&(x-1);
			System.out.println(x);
		}
	}
}
