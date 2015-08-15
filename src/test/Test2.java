package test;

import java.util.ArrayList;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> lowerList = new ArrayList<Integer>();
		ArrayList<Integer> upperList = new ArrayList<Integer>();
		 while(scanner.hasNextInt()){
			int lower = scanner.nextInt();
			int upper = scanner.nextInt();
			if(lower > upper) 
				break;
			lowerList.add(lower);
			upperList.add(upper);
		}
		for(int x = 0;x<lowerList.size();x++){
			String output = "";
			for(int i = lowerList.get(x);i<=upperList.get(x);i++){
				int sum = 0;
				Integer n = new Integer(i);
				String s = n.toString();
				for(int j = 0; j < 3; j++){
					sum += Math.pow(Integer.parseInt(s.charAt(j)+""), 3);
				}
				if(sum == i){
					output += i + " ";
				}
			}
			if(0==output.length()){
				output = "no";
			}
			System.out.println(output);
		}		
	}
}
