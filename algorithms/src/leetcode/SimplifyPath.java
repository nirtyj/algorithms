package leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class SimplifyPath {

	/**
	 * Leetcode verified
	 * @param path
	 * @return
	 */
	public String simplifyPath(String path) {
		Deque<String> stack = new LinkedList<>();
		Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
		// split on the slashes
		for (String dir : path.split("/")) {
			// if its .. and stack is not empty, go back a dir
			if (dir.equals("..") && !stack.isEmpty())
				stack.pop();
			// if its not part of skip, push it
			else if (!skip.contains(dir))
				stack.push(dir);
		}
		String res = "";
		// stack is in the back order. so, append in the reverse
		for (String dir : stack)
			res = "/" + dir + res;
		return res.isEmpty() ? "/" : res;
	}
}
