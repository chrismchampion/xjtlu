package cn.edu.xjtlu.csse.cchampion17.cw1.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cn.edu.xjtlu.csse.cchampion17.cw1.obj.Tweet;

public class DataSet {

	// Member variables
	private static List<Tweet> tweets = new ArrayList<>();
	private static List<Tweet> topUsers = new ArrayList<>();
	protected static List<Tweet> topTweets = new ArrayList<>();

	// Private static helper methods
	/**
	 * Private class method sorts topTweets List Collection using Tweet object's
	 * PopularityComparator. Called in public DataSet.printTopTweets() method.
	 */
	private static void sortTopTweets() {
		// "Top Tweets" list contains only tweets with values > 0 for "favs" and "RTs"
		// Sort using class Comparator
		Collections.sort(topTweets, Tweet.PopularityComparator);
	}

	/**
	 * Private class method creates a copy of the tweets List Collection and sorts
	 * it using Tweet object's UserComparator. Called in public
	 * DataSet.printTopUsers() method.
	 */
	private static void sortTopUsers(int selSize) {
		// Copy all tweets to new "Top Users" collection, then sort it
		topUsers.addAll(tweets);
		Collections.sort(topUsers, Tweet.UserComparator);
		// Remove duplicate user with same or lower number of followers
		int index = 0;
		while (index < selSize) {
			// Get the first/top user from the list
			Tweet t1 = topUsers.get(index);
			// Compare userID with the next tweet in the list
			if (t1.getUserID().equals(topUsers.get(index + 1).getUserID())) {
				// If true, remove the tweet at current index + 1 and re-check values
				topUsers.remove(index + 1);
				// else increment index
			} else {
				index++;
			}
		}
	}

	// Public static helper methods
	/**
	 * Static helper method iterates over tweet List Collection (linear time
	 * complexity) and calls each Tweet object's toString() method.
	 */
	public static void printAllTweets() {
		if (!tweets.isEmpty()) {
			for (Tweet t : tweets) {
				System.out.println(t.toString());
			}
		}
	}

	/**
	 * Prints a list of the following formatted tweet values to the console: user
	 * alias, date, timestamp, number of favorites, number of re-tweets, tweet
	 * message content. If the tweet List Collection is empty or does not contain
	 * any tweets with 'favorites' or 'number of re-tweets' values, prints system
	 * message.
	 * 
	 * @param num an integer value to restrict the number of tweets printed to the
	 *            console
	 */
	public static void printTopTweets(int num) {
		if (num < 1) {
			num = 10;
		}
		System.out.println("-----------------TOP " + num + " TWEETS-----------------");
		System.out.printf("\t%-20s %-20s %-10s %-10s %-10s %-10s\n", "USER", "DATE", "HOUR", "FAVS", "RT", "MESSAGE");
		if (!topTweets.isEmpty()) {
			sortTopTweets();
			for (int rank = 0; rank < num; rank++) {
				Tweet t = topTweets.get(rank);
				System.out.println(rank + 1 + ".\t" + t.topTweetToString());
			}
		} else {
			System.out.println(
					"\nSYS_Msg: Sorry, but the provided data set does not contain the required 'favs' and 'retweet' data to display top tweets.");
		}
	}

	/**
	 * Prints a list of the following formatted tweet values to the console: user
	 * alias, date, timestamp, number of favorites, number of re-tweets, tweet
	 * message content. If the tweet List Collection is empty or does not contain
	 * any tweets with 'favorites' or 'number of re-tweets' values, prints system
	 * message.
	 * 
	 * @param num  an integer value to restrict the number of tweets printed to the
	 *             console
	 * @param date further restrict top tweets displayed using "date" parameter.
	 */
	public static void printTopTweets(int num, String date) {
		if (num < 1) {
			num = 10;
		}
		System.out.println("-----------------TOP " + num + " TWEETS FROM " + date + " -----------------");
		System.out.printf("\t%-20s %-20s %-10s %-10s %-10s %-10s\n", "USER", "DATE", "HOUR", "FAVS", "RT", "MESSAGE");
		if (!topTweets.isEmpty()) {
			ArrayList<Tweet> topTweetsByDate = new ArrayList<Tweet>();
			sortTopTweets();
			for (Tweet topT : topTweets) {
				if (topT.getDate().equals(date)) {
					topTweetsByDate.add(topT);
				}
			}
			for (int rank = 0; rank < num; rank++) {
				System.out.println(rank + 1 + ".\t" + topTweetsByDate.get(rank).topTweetToString());
			}
		} else {
			System.out.println(
					"\nSYS_Msg: Sorry, but the provided data set does not contain the required 'favs' and 'retweet' data to display top tweets.");
		}
	}

	/**
	 * Prints a list of the following formatted tweet values to the console: user
	 * id, user alias, number of followers at the time of tweet, date. If the tweet
	 * List Collection is empty, prints system message.
	 * 
	 * @param num an integer value to restrict the number of tweets printed to the
	 *            console
	 */
	public static void printTopUsers(int num) {
		if (num < 1) {
			num = 10;
		}
		System.out.println("-----------------TOP " + num + " USERS-----------------");
		System.out.printf("\t%-20s %-20s %-10s %-10s\n", "USER NAME", "ALIAS", "FOLLOWERS", "DATE");
		sortTopUsers(num);
		if (!topUsers.isEmpty()) {
			for (int rank = 0; rank < num; rank++) {
				Tweet t = topUsers.get(rank);
				System.out.println(rank + 1 + ".\t" + t.topUserToString());
			}
		} else {
			System.out.println("\nSYS_Msg: Error displaying top users.");
		}
	}

	// Public getter method returns Tweet list for use in package-external Tester
	// class
	/**
	 * @return returns Tweet list Collection for use in package-external Search
	 *         class
	 */
	public static List<Tweet> getTweetList() {
		return tweets;
	}

}
