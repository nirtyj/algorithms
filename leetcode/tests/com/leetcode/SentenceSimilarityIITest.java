package com.leetcode;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.leetcode.disjointsets.SentenceSimilarityII;

public class SentenceSimilarityIITest {

	@Test
	public void test() {
		String[] words1 = { "great", "acting", "skills" };
		String[] words2 = { "fine", "drama", "talent" };
		String[][] pairs = { { "great", "good" }, { "fine", "good" }, { "drama", "acting" }, { "skills", "talent" } };
		assertTrue(SentenceSimilarityII.areSentencesSimilarTwo(words1, words2, pairs));
	}

	@Test
	public void test2() {
		String[] words1 = { "this", "summer", "thomas", "get", "really", "very", "rich", "and", "have", "any",
				"actually", "wonderful", "and", "good", "truck", "every", "morning", "he", "drives", "an",
				"extraordinary", "truck", "around", "the", "nice", "city", "to", "eat", "some", "extremely",
				"extraordinary", "food", "as", "his", "meal", "but", "he", "only", "entertain", "an", "few", "well",
				"fruits", "as", "single", "lunch", "he", "wants", "to", "eat", "single", "single", "and", "really",
				"healthy", "life" };
		String[] words2 = { "this", "summer", "thomas", "get", "very", "extremely", "rich", "and", "possess", "the",
				"actually", "great", "and", "wonderful", "vehicle", "every", "morning", "he", "drives", "unique",
				"extraordinary", "automobile", "around", "unique", "fine", "city", "to", "drink", "single", "extremely",
				"nice", "meal", "as", "his", "super", "but", "he", "only", "entertain", "a", "few", "extraordinary",
				"food", "as", "some", "brunch", "he", "wants", "to", "take", "any", "some", "and", "really", "healthy",
				"life" };
		String[][] pairs = { { "good", "nice" }, { "good", "excellent" }, { "good", "well" }, { "good", "great" },
				{ "fine", "nice" }, { "fine", "excellent" }, { "fine", "well" }, { "fine", "great" },
				{ "wonderful", "nice" }, { "wonderful", "excellent" }, { "wonderful", "well" },
				{ "wonderful", "great" }, { "extraordinary", "nice" }, { "extraordinary", "excellent" },
				{ "extraordinary", "well" }, { "extraordinary", "great" }, { "one", "a" }, { "one", "an" },
				{ "one", "unique" }, { "one", "any" }, { "single", "a" }, { "single", "an" }, { "single", "unique" },
				{ "single", "any" }, { "the", "a" }, { "the", "an" }, { "the", "unique" }, { "the", "any" },
				{ "some", "a" }, { "some", "an" }, { "some", "unique" }, { "some", "any" }, { "car", "vehicle" },
				{ "car", "automobile" }, { "car", "truck" }, { "auto", "vehicle" }, { "auto", "automobile" },
				{ "auto", "truck" }, { "wagon", "vehicle" }, { "wagon", "automobile" }, { "wagon", "truck" },
				{ "have", "take" }, { "have", "drink" }, { "eat", "take" }, { "eat", "drink" }, { "entertain", "take" },
				{ "entertain", "drink" }, { "meal", "lunch" }, { "meal", "dinner" }, { "meal", "breakfast" },
				{ "meal", "fruits" }, { "super", "lunch" }, { "super", "dinner" }, { "super", "breakfast" },
				{ "super", "fruits" }, { "food", "lunch" }, { "food", "dinner" }, { "food", "breakfast" },
				{ "food", "fruits" }, { "brunch", "lunch" }, { "brunch", "dinner" }, { "brunch", "breakfast" },
				{ "brunch", "fruits" }, { "own", "have" }, { "own", "possess" }, { "keep", "have" },
				{ "keep", "possess" }, { "very", "super" }, { "very", "actually" }, { "really", "super" },
				{ "really", "actually" }, { "extremely", "super" }, { "extremely", "actually" } };

		assertTrue(SentenceSimilarityII.areSentencesSimilarTwo(words1, words2, pairs));
	}
}
