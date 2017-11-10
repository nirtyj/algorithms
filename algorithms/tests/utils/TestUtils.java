package utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestUtils {
	public static Set<String> arrayToSet(String[] dictArr) {
		Set<String> dict = new HashSet<>();
		for(String w: dictArr)
		{
			dict.add(w);
		}
		return dict;
	}
	
	public static List<String> arrayToList(String[] dictArr) {
		List<String> dict = new ArrayList<>();
		for(String w: dictArr)
		{
			dict.add(w);
		}
		return dict;
	}
}
