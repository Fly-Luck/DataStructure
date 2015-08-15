package test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> srcList = new ArrayList<Integer>();
		ArrayList<Integer> countList = new ArrayList<Integer>();
		while(scanner.hasNextInt()){
			int src = scanner.nextInt();
			int count = scanner.nextInt();
			srcList.add(src);
			countList.add(count);
		}
		DecimalFormat format = new DecimalFormat(".00");
		for(int i=0;i<srcList.size();i++){
			double srcDbl = srcList.get(i);
			double sum = 0;
			for(int j=0;j<countList.get(i);j++){
				sum += srcDbl;
				srcDbl = Math.sqrt(srcDbl);
			}
			System.out.println(format.format(sum));
		}
		scanner.close();
	}
}
