package test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		ArrayList<Double> pointList = new ArrayList<Double>();
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			double x1 = scanner.nextDouble();
			double y1 = scanner.nextDouble();
			double x2 = scanner.nextDouble();
			double y2 = scanner.nextDouble();
			pointList.add(x1);
			pointList.add(y1);
			pointList.add(x2);
			pointList.add(y2);
		}
		DecimalFormat format = new DecimalFormat(".00");
		for(int i = 0;i<pointList.size();i+=4){
			double xDis = Math.abs( 
				Math.pow(pointList.get(i), 2) - Math.pow(pointList.get(i+2), 2) );
			double yDis = Math.abs(
				Math.pow(pointList.get(i+1), 2) - Math.pow(pointList.get(i+3), 2 ));
			System.out.println(format.format(Math.sqrt(xDis+yDis)));
		}
	}
}
