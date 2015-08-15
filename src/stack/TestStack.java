package stack;

public class TestStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(convert(1348, 8));
		System.out.println(isBracketsLegal("{[]}"));
		
	}
	
	public static String convert(int src, int t){
		ArrayStack<Integer> stack = new ArrayStack<Integer>();
		while(0 != src){
			stack.push(src%t);
			src = src/t;
		}
		StringBuilder builder = new StringBuilder();
		while(!stack.isEmpty()){
			builder.append(stack.pop());
		}
		return builder.toString();
	}
	
	public static boolean isBracketsLegal(String src){
		ArrayStack<Character> stack = new ArrayStack<Character>();
		for(int i=0;i<src.length();i++){
			char c = src.charAt(i);
			if(c!='['&&c!=']'&&c!='('&&c!=')'&&c!='{'&&c!='}'){
				return false;
			}
			if(c=='['||c=='('||c=='{'){
				stack.push(c);
			}
			if(c==']'||c==')'||c=='}'){
				if(stack.isEmpty())
					return false;
				char last = stack.pop();
				switch(c){
				case ']':
					if(last!='[') return false;
					break;
				case ')':
					if(last!='(') return false;
					break;
				case '}':
					if(last!='{') return false;
					break;
				}
			}
		}
		return stack.isEmpty();
	}

}
