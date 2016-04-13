package epi.sorting;

import java.util.Collections;
import java.util.List;

public class SalaryThreshold {

	public static Double findSalaryCap(double targetPayroll, List<Double> targetSalaries) 
	{
		Collections.sort(targetSalaries);

		double sum = 0;
		for (int i = 0; i < targetSalaries.size(); i++) {
			// n * c is greater than sum. then calculate c value.
			double remainingsum = targetSalaries.get(i) * (targetSalaries.size() - i);
			if (remainingsum + sum > targetPayroll) {
				return (targetPayroll - sum) / (targetSalaries.size() - i);
			}
			sum = sum + targetSalaries.get(i);
		}
		return -1.0;
	}
}