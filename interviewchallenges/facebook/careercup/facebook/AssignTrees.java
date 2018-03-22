package careercup.facebook;

import java.util.ArrayList;
import java.util.HashMap;

/**
Given a list/array of "Assign" trees with integers, operators and variables, return the result of the requested "Result" tree expression. 

Example:


"Assign"
  /  \
"x"  "+"
    /   \ 
   2     3

"Assign"
  /  \
"y"  "-"
    /   \ 
  5000  30

"Assign"
  /  \
"z"  "*"
    /   \ 
  50     x

"Return"
  \
  "-"
  /  \    
 z   "*"
     / \
    1   y
 */
public class AssignTrees {
	static class node {
		public String value;
		public node L, R;

		public node(String value) {
			this.value = value;
		}

		public int getInt() {
			return Integer.valueOf(value);
		}
	}

	static HashMap<String, Integer> lookup = new HashMap<String, Integer>();

	static int eval(node n) {
		if (n == null)
			return 0;
		if (n.L == null && n.R == null) {
			try {
				return n.getInt();
			} catch (NumberFormatException e) {
				// lookup symbol table
				return lookup.get(n.value);
			}
		}

		if (isOperator(n)) {
			int l = eval(n.L);
			int r = eval(n.R);
			switch (n.value.charAt(0)) {
			case '+':
				return l + r;
			case '-':
				return l - r;
			case '*':
				return l * r;
			case '/':
				return l / r;
			}
		} else if (n.value.equals("Assign")) {
			lookup.put(n.L.value, eval(n.R));
			return 0;
		} else if (n.value.equals("Return")) {
			int result = eval(n.R);
			System.out.println(result);
			return result;
		}

		throw new IllegalArgumentException("unknown node value " + n.value);
	}

	static boolean isOperator(node n) {
		return n.value.equals("+") || n.value.equals("-") || n.value.equals("*") || n.value.equals("/");
	}

	public static void main(String... args) {
		ArrayList<node> list = get();
		for (node n : list) {
			eval(n);
		}
	}

	static ArrayList<node> get() {
		ArrayList<node> nodes = new ArrayList<node>();
		node assign1 = new node("Assign");
		assign1.L = new node("x");
		assign1.R = new node("+");
		assign1.R.L = new node("2");
		assign1.R.R = new node("3");
		nodes.add(assign1);

		node assign2 = new node("Assign");
		assign2.L = new node("y");
		assign2.R = new node("-");
		assign2.R.L = new node("5000");
		assign2.R.R = new node("30");
		nodes.add(assign2);

		node assign3 = new node("Assign");
		assign3.L = new node("z");
		assign3.R = new node("*");
		assign3.R.L = new node("50");
		assign3.R.R = new node("x");
		nodes.add(assign3);

		node result = new node("Return");
		result.R = new node("-");
		result.R.L = new node("z");
		result.R.R = new node("*");
		result.R.R.L = new node("1");
		result.R.R.R = new node("y");
		nodes.add(result);

		return nodes;
	}

}
