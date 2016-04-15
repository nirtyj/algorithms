package epi.searching;

import java.util.List;

public class FindMaxAndMin {

	public static class MinMax {
		int min;
		int max;

		public MinMax(Integer min, Integer max) {
			this.min = min;
			this.max = max;
		}
	}

	public static MinMax findMinMax(List<Integer> arr) {

		MinMax globalMinMax = new MinMax(arr.get(0), arr.get(1));
		for (int i = 2; i + 1 < arr.size(); i += 2) {
			int min = Math.min(arr.get(i), arr.get(i + 1));
			int max = Math.max(arr.get(i), arr.get(i + 1));
			globalMinMax.min = Math.min(min, globalMinMax.min);
			globalMinMax.max = Math.max(max, globalMinMax.max);
		}
		if (arr.size() % 2 != 0) {
			globalMinMax.min = Math.min(arr.get(arr.size() - 1), globalMinMax.min);
			globalMinMax.max = Math.max(arr.get(arr.size() - 1), globalMinMax.max);
		}
		return globalMinMax;
	}

}
