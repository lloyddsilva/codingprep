package edu.cmu.lloyddsilva;

import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Calculator {
	public static void main(String[] args) {
		System.out.println(calculate("2-4-(8+2-6+(8+4-(1)+8-10))"));
		System.out.println(calculate("(7)-(0)+(4)"));
		System.out.println(calculate("1 + 1"));
		System.out.println(calculate(" 2-1 + 2"));
		System.out.println(calculate("2-(5-6)"));
		System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
		System.out.println(calculate("10 + 11"));
		System.out.println(calculate("2147483647"));
	}
	
	public static int calculate(String s) {
		s = s.replaceAll(" ", "");
		
		StringTokenizer st = new StringTokenizer(s, "+-()", true);

		int total = 0;
		Stack<String> stack = new Stack<String>();
		
		while(st.hasMoreTokens()) {
			String next = st.nextToken();
			switch(next) {
				case "(" : stack.push(next);
					break;
				case ")" :
					ArrayList<String> t = new ArrayList<String>();
					String item = stack.pop();
					while(!stack.empty() && !item.equals("(")) {
						t.add(0,item);
						item = stack.pop();
					}
					stack.push("" + eval(t));
					break;
				case "+" : stack.push(next);
					break;
				case "-" : stack.push(next);
					break;
				default: 
						stack.push(next);
					break;
			}
		}
		
		//Final math should be left to right
		ArrayList<String> t = new ArrayList<String>();
		while (!stack.isEmpty()) {
			String elem = stack.pop();
			t.add(0, elem);
		}
		
		total = eval(t);
		
		return total;
		
	}
	
	public static int eval(ArrayList<String> t) {
		int temp = 0;
		for (int i = t.size() - 1; i > 0; i = i - 2) {
			if (t.get(i - 1).equals("-")) {
				temp += 0 - Integer.valueOf(t.get(i));
			} else {
				temp += Integer.valueOf(t.get(i));
			}
		}
		temp += Integer.valueOf(t.get(0));
		
		return temp;
	}

}
