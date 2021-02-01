package cn.edu.xjtlu.csse.cchampion17.cw1.data;

import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler;
import org.apache.poi.xssf.usermodel.XSSFComment;

import cn.edu.xjtlu.csse.cchampion17.cw1.obj.Tweet;

public class XLSXSheetContentHandler implements SheetContentsHandler {

	// Private member variable
	private Tweet tweet;

	// Concrete implementations of SheetContentsHandler abstract methods
	@Override
	/**
	 * Concrete implementation of interface SheetContentsHandler.startRow() method.
	 * Instantiates a new Tweet object at the beginning or each row of the parsed-in
	 * .XLSX spreadsheet.
	 * 
	 * @param an integer value representing the row number for each row of the
	 *           parsed .XLSX spreadsheet
	 */
	public void startRow(int rowNum) {
		// For each row instantiate a new Tweet object
		tweet = new Tweet("");
	}

	@Override
	/**
	 * Concrete implementation of interface SheetContentsHandler.cell() method.
	 * Extracts content from each cell of each row of the parsed-in .XLSX
	 * spreadsheet and assigns the cell content to a Tweet object attribute.
	 * 
	 * @param index   the corresponding cell index from the .XLSX spreadsheet
	 * @param content the String contents of the cell
	 * @param arg2    possible XSSFComment attached to the cell (may be null)
	 */
	public void cell(String index, String content, XSSFComment arg2) {
		// Get cell content for each column of each row, skipping header row
		if (index.startsWith("A") && !index.equals("A1")) {
			tweet.setTweetID(content.trim());
		}
		if (index.startsWith("B") && !index.equals("B1")) {
			tweet.setDate(content.trim());
		}
		if (index.startsWith("C") && !index.equals("C1")) {
			tweet.setHour(content.trim());
		}
		if (index.startsWith("D") && !index.equals("D1")) {
			tweet.setUserAlias(content.trim());
		}
		if (index.startsWith("E") && !index.equals("E1")) {
			tweet.setUserID(content.trim());
		}
		if (index.startsWith("F") && !index.equals("F1")) {
			// replace newlines and carriage returns with blank space displays message on
			// one line
			content = content.replaceAll("(?:\\n|\\r)", "");
			tweet.setMsgContent(content.trim());
		}
		if (index.startsWith("G") && !index.equals("G1")) {
			tweet.setFavs(Integer.parseInt(content.trim()));
		}
		if (index.startsWith("H") && !index.equals("H1")) {
			tweet.setRetweets(Integer.parseInt(content.trim()));
		}
		if (index.startsWith("I") && !index.equals("I1")) {
			tweet.setLatitude(content.trim());
		}
		if (index.startsWith("J") && !index.equals("J1")) {
			tweet.setLongitude(content.trim());
		}
		if (index.startsWith("K") && !index.equals("K1")) {
			tweet.setFollowers(Integer.parseInt(content.trim()));
		}
	}

	@Override
	/**
	 * Concrete implementation of interface SheetContentsHandler.endRow() method.
	 * Adds each populated Tweet object instance to the data set at the end of reach
	 * row. Considers the first row of the .XLSX spreadsheet to be a header row,
	 * thus skips it. Checks if Tweet object contains relevant 'favorites' and
	 * 'number of re-tweets' data and adds it to the data set's "top tweets"
	 * collection accordingly.
	 * 
	 * @param rowNum an integer value representing the row number for each row of
	 *               the parsed .XLSX spreadsheet
	 */
	public void endRow(int rowNum) {
		// Add populated Tweet object to data set
		// Skip blank Tweet object instantiated in startRow(rowNum=0)
		if (rowNum > 0) { // just added these curly brackets...why missing?
			DataSet.getTweetList().add(tweet);
			// Add tweet to list of "top tweets" if it contains 'favs' and/or 're-tweets'
			if ((tweet.getNumFavs() + tweet.getNumRetweets()) > 0) {
				DataSet.topTweets.add(tweet);
			}
		}
	}
}
