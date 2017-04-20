package com.pzj.base.common.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpressionUtil implements Serializable {

	/**
     * 
     */
	private static final long serialVersionUID = -7827383998292693417L;

	public double eval(String exp) {
		if (!exp.endsWith("#")) {
			exp = exp + "#";
		}
		List<String> list = infixExpToPostExp(exp);
		return doEval(list);
	}

	private double doEval(List<String> list) {
		Stack<String> stack = new Stack<String>();
		String element;
		double n1, n2, result;
		try {
			for (int i = 0; i < list.size(); i++) {
				element = list.get(i);
				if (isOperator(element)) {
					n1 = Double.parseDouble(stack.pop());
					n2 = Double.parseDouble(stack.pop());
					result = doOperate(n2, n1, element);
					stack.push(new Double(result).toString());
				} else {
					stack.push(element);
				}
			}
			return Double.parseDouble(stack.pop());
		} catch (RuntimeException e) {
			throw new IllegalExpressionException(e.getMessage());
		}
	}

	private double doOperate(double n1, double n2, String operator) {
		if (operator.equals("+"))
			return n1 + n2;
		else if (operator.equals("-"))
			return n1 - n2;
		else if (operator.equals("*"))
			return n1 * n2;
		else
			return n1 / n2;
	}

	private boolean isOperator(String str) {
		return str.equals("+") || str.equals("-") || str.equals("*")
				|| str.equals("/");
	}

	private List<String> infixExpToPostExp(String exp) {
		List<String> postExp = new ArrayList<String>();
		StringBuffer numBuffer = new StringBuffer();
		Stack<Character> opStack = new Stack<Character>();
		char ch, preChar;
		opStack.push('#');
		try {
			for (int i = 0; i < exp.length();) {
				ch = exp.charAt(i);
				switch (ch) {
				case '+':
				case '-':
					if (i - 1 < 0) {
						numBuffer.append(ch);
						ch = exp.charAt(++i);
						break;
					} else {
						char c = exp.charAt(i - 1);
						if (!Character.isDigit(c)) {
							numBuffer.append(ch);
							ch = exp.charAt(++i);
							break;
						}
					}
				case '*':
				case '/':
					preChar = opStack.peek();
					while (priority(preChar) >= priority(ch)) {
						postExp.add("" + preChar);
						opStack.pop();
						preChar = opStack.peek();
					}
					opStack.push(ch);
					i++;
					break;
				case '(':
					opStack.push(ch);
					i++;
					break;
				case ')':
					char c = opStack.pop();
					while (c != '(') {
						postExp.add("" + c);
						c = opStack.pop();
					}
					i++;
					break;
				case '#':
					char c1;
					while (!opStack.isEmpty()) {
						c1 = opStack.pop();
						if (c1 != '#')
							postExp.add("" + c1);
					}
					i++;
					break;
				case ' ':
				case '\t':
					i++;
					break;
				default:
					if ('.' == ch || Character.isDigit(ch)) {
						while (Character.isDigit(ch)) {
							numBuffer.append(ch);
							ch = exp.charAt(++i);
						}
						if ('.' == ch) {
							numBuffer.append('.');
							ch = exp.charAt(++i);
						} else {
							postExp.add(numBuffer.toString());
							numBuffer = new StringBuffer();
						}
					} else {
						throw new IllegalExpressionException("illegal operator");
					}
				}
			}
		} catch (RuntimeException e) {
			throw new IllegalExpressionException(e.getMessage());
		}
		return postExp;
	}

	private int priority(char op) {
		switch (op) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '(':
		case '#':
			return 0;
		}
		throw new IllegalExpressionException("Illegal operator");
	}

	public static void main(String[] args) {
		System.out.println("AB+AB-BC+ABC*DAB+AB".replaceAll("\\bAB\\b", "1"));
		ExpressionUtil eval = new ExpressionUtil();
		double result = eval.eval("0/3#");
		System.out.println(result);
	}

	class IllegalExpressionException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public IllegalExpressionException() {

		}

		public IllegalExpressionException(String info) {
			super(info);
		}
	}
}
