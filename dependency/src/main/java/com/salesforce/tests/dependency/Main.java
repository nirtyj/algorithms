package com.salesforce.tests.dependency;

import java.util.Scanner;

import com.salesforce.application.DependencyManager;

/**
 * The entry point for the Test program
 */
public class Main {

	public static void main(String[] args) {

		// read input from stdin
		Scanner scan = new Scanner(System.in);

		DependencyManager manager = new DependencyManager();

		while (true) {
			String line = scan.nextLine();

			// no action for empty input
			if (line == null || line.length() == 0) {
				continue;
			}

			// the END command to stop the program
			if ("END".equals(line)) {
				System.out.println("END");
				break;
			}

			// print the input command
			System.out.println(line);
			// process each input and print the result
			String value = manager.processCommand(line);
			if(value !=null && !value.isEmpty())
				System.out.println(value);
		}
	}
}