package com.gl.lab3;

import java.util.Scanner;
import java.util.Stack;

/* -----------------------------------------------------------------------------------------------------
 * Write a program of Balancing Brackets,
 * use a suitable data structure to print whether the string entered 
 * is a Balanced Brackets or Unbalanced String
 * -----------------------------------------------------------------------------------------------------
*/

public class BalancedBracket {
	private static boolean isBalanced(String s) {
		Stack<Character> stack = new Stack<>();

		char[] array = s.toCharArray();
		for (int i = 0; i < array.length; i++) {
			char c = array[i];

			if (c == '{' || c == '(' || c == '[') {
				stack.push(c);
				continue;
			}
			if (stack.isEmpty()) {
				return false;
			}
			char ch;
			switch (c) {
			case ')':
				ch = (char) stack.pop();
				if (ch == '{' || ch == '[')
					return false;
				break;
			case '}':
				ch = (char) stack.pop();
				if (ch == '(' || ch == '[')
					return false;
				break;
			case ']':
				ch = (char) stack.pop();
				if (ch == '(' || ch == '{')
					return false;
				break;
			default:
				return false;
			}
		}
		return (stack.isEmpty());

	}

	public static void main(String[] args) {
		String s;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the character");
		s = input.nextLine();
		if (isBalanced(s)) {
			System.out.println("The string" + s + " is balanced");
		} else {
			System.out.println("The string" + s + " is not balanced");
		}
		input.close();

	}
}
