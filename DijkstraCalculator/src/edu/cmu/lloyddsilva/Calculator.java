package edu.cmu.lloyddsilva;

import java.util.Scanner;
import java.util.Stack;

public class Calculator {
	public static void main(String[] args) {
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			String s = in.next();
			if(s.equals("(")) {
				
			} else if(s.equals("+")) {
				ops.push(s);
			} else if(s.equals("*")) {
				ops.push(s);
			} else if(s.equals(")")) {
				String op = ops.pop();
				if(op.equals("+")) {
					vals.push(vals.pop() + vals.pop());
				} else if(op.equals("*")) {
					vals.push(vals.pop() * vals.pop());
				}
			} else if(s.equals("|")) {
				break;
			} else {
				vals.push(Double.parseDouble(s));
			}

		}
		
		System.out.println(vals.pop());
		in.close();
		
	}
}
