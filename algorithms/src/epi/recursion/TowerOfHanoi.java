package epi.recursion;

import java.util.Stack;

public class TowerOfHanoi {

	private static int numSteps;

	public static int computeTowerHanoi(int numRings) {

		numSteps = 0;
		Stack<Integer> tower1 = new Stack<Integer>();
		Stack<Integer> tower2 = new Stack<Integer>();
		Stack<Integer> tower3 = new Stack<Integer>();

		for (int i = numRings; i > 0; i--)
			tower1.push(i);

		towerOfHanoi(numRings, tower1, tower2, tower3);

		return numSteps;
	}

	public static void towerOfHanoi(int numberOfRings, Stack<Integer> from, Stack<Integer> to, Stack<Integer> use) {
		if (numberOfRings == 0)
			return;

		towerOfHanoi(numberOfRings - 1, from, use, to);
		to.push(from.pop());
		numSteps++;
		towerOfHanoi(numberOfRings - 1, use, to, from);
	}

	@SuppressWarnings("unused")
	private static void printTowers(Stack<Integer> from, Stack<Integer> to, Stack<Integer> use) {

		int maxSize = Math.max(Math.max(from.size(), to.size()), use.size());
		System.out.println("-------------------------------------");
		for (int i = maxSize; i >= 0; i--) {
			String print = "";
			if (i > from.size() - 1)
				print += "-";
			else
				print += from.get(i);

			print += "\t";
			if (i > to.size() - 1)
				print += "-";
			else
				print += to.get(i);

			print += "\t";

			if (i > use.size() - 1)
				print += "-";
			else
				print += use.get(i);

			print += "\t";

			System.out.println(print);
		}
		System.out.println("-------------------------------------");

	}
}
