package cn.edu.xjtlu.csse.cchampion17.cw1.testing;

import java.io.IOException;
import java.util.Scanner;

import org.apache.lucene.queryparser.classic.ParseException;

import cn.edu.xjtlu.csse.cchampion17.cw1.data.DataSet;
import cn.edu.xjtlu.csse.cchampion17.cw1.obj.Tweet;
import cn.edu.xjtlu.csse.cchampion17.cw1.search.Search;

public class ConsoleMenu {

	// Constants
	private final static String OPT_ONE = "1.\tPrint All Tweets";
	private final static String OPT_TWO = "2.\tPrint Top Tweets";
	private final static String OPT_THREE = "3.\tPrint Top Users";
	private final static String OPT_FOUR = "4.\tKeyword Search";
	private final static String OPT_FIVE = "5.\tFull-text Search (Lucene)";
	private final static String OPT_SIX = "6.\tQuit";

	private static void printMenu() {
		System.out.println();
		System.out.println(OPT_ONE);
		System.out.println(OPT_TWO);
		System.out.println(OPT_THREE);
		System.out.println(OPT_FOUR);
		System.out.println(OPT_FIVE);
		System.out.println(OPT_SIX);
		System.out.println();
	}

	/**
	 * Called in Tester.main() for displaying program menu and switching user input.
	 */
	protected static void displayMenu() {

		printMenu();

		boolean exit = false;

		while (!exit) {
			int choice = -1;
			while (choice == -1) {
				// Error handling for menu choice integer input
				try {
					choice = Integer.parseInt(getString("Please choose an option (Enter 0 for menu): "));
				} catch (NumberFormatException nfEx) {
					System.out.println("You did not enter a number.");
				}
			}

			// switch user input
			switch (choice) {

			case 0:
				displayMenu();
				break;
			case 1:
				DataSet.printAllTweets();
				break;
			case 2:
				boolean validIn = false;
				String numTweets = getString("Please enter number of tweets (default 10): ");
				int num = 0;
				if (numTweets.trim().equals("")) {
					validIn = true;
				}
				while (!validIn) {
					try {
						num = Integer.parseInt(numTweets);
						validIn = true;
					} catch (NumberFormatException nfEx) {
						System.out.println("Please enter an integer.");
						numTweets = getString("Please enter number of tweets (default 10): ");
						if (numTweets.trim().equals("")) {
							validIn = true;
						}
					}
				}
				DataSet.printTopTweets(num);
				break;
			case 3:
				boolean validIn2 = false;
				String numUsers = getString("Please enter number of users (default 10): ");
				int num2 = 0;
				if (numUsers.trim().equals("")) {
					validIn2 = true;
				}
				while (!validIn2) {
					try {
						num2 = Integer.parseInt(numUsers);
						validIn2 = true;
					} catch (NumberFormatException nfEx) {
						System.out.println("Please enter an integer.");
						numUsers = getString("Please enter number of tweets (default 10): ");
						if (numUsers.trim().equals("")) {
							validIn2 = true;
						}
					}
				}
				DataSet.printTopUsers(num2);
				break;
			case 4:
				String keyword = getString("Please enter a keyword: ");
				for (Tweet t : Search.singleWordQuery(keyword)) {
					System.out.println(t.toString());
				}
				System.out.println(Search.getResultsSize() + " query results");
				break;
			case 5:
				String queryStr = getString("Please enter a text query: ");
				try {
					Search.luceneSearch(queryStr);
				} catch (IOException | ParseException e) {
					System.out.println("Error searching index");
				}
				break;
			case 6:
				System.out.println("Goodbye! See you next time.");
				exit = true;
				break;
			default:
				System.out.println("Please choose from the available options.");
				break;
			}
		}
	}

	private static String getString(String question) {
		// Prints 'question' to the console and returns user input as string
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println(question);

		String userInput = scanner.nextLine();
		return userInput;
	}
}
