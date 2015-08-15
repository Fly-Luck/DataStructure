package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Test5 {
	public static void main(String[] args) {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> strList = new ArrayList<String>();
		int count = 0;
		try {
			count = Integer.parseInt(br.readLine());
			for(int i=0;i<count;i++){
				String string = br.readLine();
				strList.add(string);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i=0;i<count;i++){
			String str = strList.get(i);
			char firstChar = str.charAt(0);
			for(int j=0;j<str.length();j++){
				char ch = str.charAt(j);
				boolean isFirst = true;
				for(int k=j;k<str.length();k++){
					if(ch == str.charAt(k)){
						isFirst = false;
					}
				}
				if(isFirst){
					firstChar = ch;
					break;
				}
			}
			System.out.println(firstChar);
		}
	}
}
