package cn.edu.xjtlu.csse.cchampion17.cw1.obj;

import java.util.Comparator;

public class Tweet {

	// Private member variables
	private String userAlias;
	private String userID;
	private String tweetID;
	private String date;
	private String hour, msgContent;
	private int numFavs, numRetweets, numFollowersAtTimeOfTweet;
	private String gpsLat, gpsLong;

	/**
	 * Comparator for comparing Tweet objects based on the sum of the number of
	 * users who like the tweet (Favs) and the number of users who re-tweet the
	 * tweet (RTs).
	 */
	public static Comparator<Tweet> PopularityComparator = new Comparator<Tweet>() {

		@Override
		/**
		 * Concrete implementation of Comparator compare() method.
		 * 
		 * @return returns negative int if the first argument is less than the second
		 *         one, zero if they are equal, and a positive int if the first argument
		 *         is greater than the second one.
		 */
		public int compare(Tweet tweet1, Tweet tweet2) {
			int tweet1Popularity = tweet1.numFavs + tweet1.numRetweets;
			// returns negative int if the first argument is less than the second one,
			// returns zero if they are equal,
			// returns positive int if the first argument is greater than the second one.
			return ((tweet2.numFavs + tweet2.numRetweets) - tweet1Popularity);
		}
	};

	/**
	 * Comparator for comparing Tweet objects based on the number of followers at
	 * the time of the tweet.
	 */
	public static Comparator<Tweet> UserComparator = new Comparator<Tweet>() {

		@Override
		/**
		 * Concrete implementation of Comparator compare() method.
		 * 
		 * @return returns negative int if the first argument is less than the second
		 *         one, zero if they are equal, and a positive int if the first argument
		 *         is greater than the second one.
		 */
		public int compare(Tweet tweet1, Tweet tweet2) {
			return tweet2.numFollowersAtTimeOfTweet - tweet1.numFollowersAtTimeOfTweet;
		}
	};

	/**
	 * Constructor for tweet object.
	 * 
	 * @param pTweetID Requires 18-digit tweet id as String to instantiate Tweet
	 *                 object.
	 */
	public Tweet(String pTweetID) {
		this.tweetID = pTweetID;
	}

	// Public getter methods
	/**
	 * Public getter method for accessing private member variable 'tweetID'.
	 * 
	 * @return tweet id as String
	 */
	public String getTweetID() {
		return tweetID;
	}

	/**
	 * Public getter method for accessing private member variable 'userID'.
	 * 
	 * @return user id, e.g. the "@" twitter handle, as String
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * Public getter method for accessing private member variable 'userAlias'.
	 * 
	 * @return user alias as String
	 */
	public String getUserAlias() {
		return userAlias;
	}

	/**
	 * Public getter method for accessing private member variable 'date'.
	 * 
	 * @return date of tweet as String
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Public getter method for accessing private member variable 'hour'.
	 * 
	 * @return timestamp of tweet as String
	 */
	public String getHour() {
		return hour;
	}

	/**
	 * Public getter method for accessing private member variable 'msgContent'.
	 * 
	 * @return tweet message content as String
	 */
	public String getMessage() {
		return msgContent;
	}

	/**
	 * Public getter method for accessing private member variable 'numFavs'.
	 * 
	 * @return number of favorites as String
	 */
	public int getNumFavs() {
		return numFavs;
	}

	/**
	 * Public getter method for accessing private member variable 'numRetweets'.
	 * 
	 * @return number of re-tweets as String
	 */
	public int getNumRetweets() {
		return numRetweets;
	}

	/**
	 * Public getter method for accessing private member variable
	 * 'numFollowersAtTimeOfTweet'.
	 * 
	 * @return the user's number of followers at the time of the tweet as String
	 */
	public int getNumFollowers() {
		return numFollowersAtTimeOfTweet;
	}

	/**
	 * Public getter method for accessing private member variable 'gpsLat'.
	 * 
	 * @return the user's location (gps latitude) coordinates at the place of tweet
	 *         as String
	 */
	public String getLat() {
		return gpsLat;
	}

	/**
	 * Public getter method for accessing private member variable 'gpsLong'.
	 * 
	 * @return the user's location (gps longitude) coordinates at the place of tweet
	 *         as String
	 */
	public String getLong() {
		return gpsLong;
	}

	// Public setter methods
	// Called to set Tweet instance values when extracting text data from each cell
	// in
	// a row in SheetContentsHandler concrete implementation.
	/**
	 * Public setter method used to assign cell content as Tweet object attribute
	 * value when extracting data in SheetContentsHandler concrete implementation.
	 * 
	 * @param pTweetID tweet id as String
	 */
	public void setTweetID(String pTweetID) {
		this.tweetID = pTweetID;
	}

	/**
	 * Public setter method used to assign cell content as Tweet object attribute
	 * value when extracting data in SheetContentsHandler concrete implementation.
	 * 
	 * @param pDate date as String
	 */
	public void setDate(String pDate) {
		this.date = pDate;
	}

	/**
	 * Public setter method used to assign cell content as Tweet object attribute
	 * value when extracting data in SheetContentsHandler concrete implementation.
	 * 
	 * @param pHour tweet timestamp as String
	 */
	public void setHour(String pHour) {
		this.hour = pHour;
	}

	/**
	 * Public setter method used to assign cell content as Tweet object attribute
	 * value when extracting data in SheetContentsHandler concrete implementation.
	 * 
	 * @param pUserAlias user alias as String
	 */
	public void setUserAlias(String pUserAlias) {
		this.userAlias = pUserAlias;
	}

	/**
	 * Public setter method used to assign cell content as Tweet object attribute
	 * value when extracting data in SheetContentsHandler concrete implementation.
	 * 
	 * @param pUserID user id, e.g. user's "@" twitter handle, as String
	 */
	public void setUserID(String pUserID) {
		this.userID = pUserID;
	}

	/**
	 * Public setter method used to assign cell content as Tweet object attribute
	 * value when extracting data in SheetContentsHandler concrete implementation.
	 * 
	 * @param pMsgContent tweet message content as String
	 */
	public void setMsgContent(String pMsgContent) {
		this.msgContent = pMsgContent;
	}

	/**
	 * Public setter method used to assign cell content as Tweet object attribute
	 * value when extracting data in SheetContentsHandler concrete implementation.
	 * 
	 * @param pNumFavs number of users who like the tweet (Favs) as int
	 */
	public void setFavs(int pNumFavs) {
		this.numFavs = pNumFavs;
	}

	/**
	 * Public setter method used to assign cell content as Tweet object attribute
	 * value when extracting data in SheetContentsHandler concrete implementation.
	 * 
	 * @param pNumRetweets number of users who re-tweet the tweet (RTs) as int
	 */
	public void setRetweets(int pNumRetweets) {
		this.numRetweets = pNumRetweets;
	}

	/**
	 * Public setter method used to assign cell content as Tweet object attribute
	 * value when extracting data in SheetContentsHandler concrete implementation.
	 * 
	 * @param pLatitude user's GPS location data (latitude coordinate) at time of
	 *                  tweet as String
	 */
	public void setLatitude(String pLatitude) {
		this.gpsLat = pLatitude;
	}

	/**
	 * Public setter method used to assign cell content as Tweet object attribute
	 * value when extracting data in SheetContentsHandler concrete implementation.
	 * 
	 * @param pLongitude user's GPS location data (latitude coordinate) at time of
	 *                   tweet as String
	 */
	public void setLongitude(String pLongitude) {
		this.gpsLong = pLongitude;
	}

	/**
	 * Public setter method used to assign cell content as Tweet object attribute
	 * value when extracting data in SheetContentsHandler concrete implementation.
	 * 
	 * @param pNumFollowers user's number of followers at time of tweet as int
	 */
	public void setFollowers(int pNumFollowers) {
		this.numFollowersAtTimeOfTweet = pNumFollowers;
	}

	// Public methods return custom String representations of Tweet object
	/**
	 * 
	 * @return returns formatted String representation of tweet: user alias, date,
	 *         hour, number of favorites, number of retweets
	 */
	public String topTweetToString() {
		return String.format("%-20s %-20s %-10s %-10s %-10s %-10s", userAlias, date, hour, numFavs, numRetweets,
				msgContent);
	}

	/**
	 * 
	 * @return returns formatted String representation of tweet: user id, user
	 *         alias, number of followers at the time of tweet, date
	 */
	public String topUserToString() {
		return String.format("%-20s %-20s %-10s %-10s", userID, userAlias, numFollowersAtTimeOfTweet, date);
	}

	// Override Object toString() method
	@Override
	/**
	 * Overwrites Object toString() method
	 * 
	 * @return returns formatted String representation of tweet: tweet id, date,
	 *         hour, user id, tweet message content
	 */
	public String toString() {
		return String.format("%-20s %-15s %-10s", tweetID, date, hour) + String.format("%-30s", userID)
				+ String.format("%-300s", msgContent);

	}

}
