package interviewchallenges;

import java.util.List;

public class Amazon {

	class Node {
		Integer data;
		Node left;
		Node right;
	}

	public static boolean isBst(Node root) {
		if (root == null)
			return true;

		return isBstHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean isBstHelper(Node root, int min, int max) {
		if (root == null)
			return true;

		if (root.data > max || root.data < min)
			return false;

		return isBstHelper(root.left, min, root.data) && isBstHelper(root.right, root.data, max);
	}
}

interface ICard {
	// 1 - 13
	Integer getValue();

	// Diamond, hearts, Spade, Clever
	Suit getSuit();

	// 1 -9 , J, Q, K
	String getDisplayValue();
}

enum Suit {
	SPADE(0), DIAMOND(1), HEARTS(2), CLEVER(3);

	Suit(int val) {

	}
}

class Card implements ICard {

	// 1 - 13
	public Integer getValue() {
		return null;
	}

	// Diamond, hearts, Spade, Clever
	public Suit getSuit() {
		return null;
	}

	// 1 -9 , J, Q, K
	public String getDisplayValue() {
		return null;

	}
}

class DeckFactory {

	public Deck createDeck() {
		return null;

	}

}

class Deck {
	List<ICard> cards;

	public void shuffle() {
	}

	public ICard getCard() {
		return null;
	}

	public boolean isEmpty() {
		return false;
	}

}