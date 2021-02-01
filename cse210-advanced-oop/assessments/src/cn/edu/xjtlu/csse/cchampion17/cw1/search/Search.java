package cn.edu.xjtlu.csse.cchampion17.cw1.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

import cn.edu.xjtlu.csse.cchampion17.cw1.data.DataSet;
import cn.edu.xjtlu.csse.cchampion17.cw1.obj.Tweet;

@SuppressWarnings("deprecation")
public class Search {

	private static List<Tweet> searchResults;

	// limited to one keyword for simple search
	/**
	 * Simple search that searches Tweet object message content; limited to one
	 * keyword.
	 * 
	 * @param pWord keyword for searching Tweet message content
	 * @return returns List Collection of Tweet objects with matching query results
	 *         based on tweet message content query
	 */
	public static List<Tweet> singleWordQuery(String pWord) {
		searchResults = new ArrayList<>();
		for (Tweet t : DataSet.getTweetList()) {
			if (t.getMessage().contains(" " + pWord.toLowerCase().trim() + " ")
					|| t.getMessage().contains(" " + pWord.toUpperCase().trim() + " ") || t.getMessage()
							.contains(" " + pWord.substring(0, 1).toUpperCase() + pWord.substring(1).trim() + " ")) {
				searchResults.add(t);
			}
		}
		return searchResults;
	}

	/**
	 * Basic implementation of Apache Lucene API enables full-text searching of
	 * Tweet message content. 1. Uses standard analyzer for indexing when documents
	 * are added to the IndexWriter and at query time. Used for tokenizing text,
	 * indexing, and searching. 2. Creates the index used by Lucene to search
	 * instead of searching the text directly; results in fast search responses. 3.
	 * Creates configuration for IndexWriter. 4. Creates IndexWriter. 5. Defines
	 * which content to search by specifying the Tweet object fields that Lucene
	 * should index 6. Lucene classic query parser takes "message" String argument
	 * as the default field for query terms and analyzer object used to find terms
	 * in the query text. Then parses user input string. 7. Specifies how many
	 * results to display. Finally, prints query results as formatted string to the
	 * console.
	 * 
	 * @param searchStr the user input string containing search query
	 * @throws IOException    thrown by Lucene API IndexWriter
	 * @throws ParseException thrown by Lucene API search QueryParser
	 */
	public static void luceneSearch(String searchStr) throws IOException, ParseException {

		// 1. Use standard analyzer for indexing when documents are added to the
		// IndexWriter and at query time.
		// Used for tokenizing text, indexing, and searching.
		StandardAnalyzer analyzer = new StandardAnalyzer();

		// 2. Create the index used by Lucene to search instead of searching the text
		// directly; results in fast search responses.
		// RAMDirectory deprecated due to inefficient synchronization.
		// Usage discouraged in favor of NMapDirectory.
//		Directory index = new MMapDirectory();
		Directory index = new RAMDirectory();

		// 3. Create configuration for IndexWriter
		IndexWriterConfig config = new IndexWriterConfig(analyzer);

		// 4. Create IndexWriter
		IndexWriter writer = new IndexWriter(index, config); // throws IOException

		// 5. Define which content to search by specifying the Tweet object fields that
		// Lucene should index
		for (Tweet t : DataSet.getTweetList()) {
			addDoc(writer, t.getTweetID(), t.getDate(), t.getHour(), t.getUserID(), t.getMessage());
		}
		writer.close(); // close the IndexWriter

		// 6. Lucene classic query parser takes "message" String argument as the default
		// field for query terms and analyzer object used to find terms in the query
		// text. Then parses user input string.
		Query q = new QueryParser("message", analyzer).parse(searchStr);

		// 7. Specify how many results to display
		int hitsPerPage = 20;
		IndexReader reader = DirectoryReader.open(index);
		IndexSearcher searcher = new IndexSearcher(reader);
		// Query results stored in TopDocs object
		TopDocs topDocs = searcher.search(q, hitsPerPage);
		ScoreDoc[] hits = topDocs.scoreDocs;

		// 8. Print query results as formatted string to the console
		System.out.println("Found " + hits.length + " hits.");
		for (int i = 0; i < hits.length; ++i) {
			int docId = hits[i].doc;
			Document d = searcher.doc(docId);
			String tweetID = d.get("tweetID");
			String date = d.get("date");
			String hour = d.get("hour");
			String userAlias = d.get("userID");
			String msgContent = d.get("message");
			String result = String.format("%-20s %-15s %-10s", tweetID, date, hour) + String.format("%-30s", userAlias)
					+ String.format("%-300s", msgContent);
			System.out.println(result);
		}

		// IndexReader may only be closed when there is no longer any need to access the
		// Document object.
		reader.close(); // close the IndexReader
	}

	private static void addDoc(IndexWriter writer, String pTweetID, String pDate, String pHour, String pUserID,
			String pTweetContent) throws IOException {
		Document doc = new Document();
		doc.add(new StoredField("tweetID", pTweetID));
		doc.add(new StoredField("date", pDate));
		doc.add(new StoredField("hour", pHour));
		doc.add(new StoredField("userID", pUserID));
		doc.add(new TextField("message", pTweetContent, Field.Store.YES));
		// throws IOException
		writer.addDocument(doc);
	}

	/**
	 * Called in ConsoleMenu for displaying number of hits for simple keyword search
	 * query results.
	 * 
	 * @return returns size of simple keyword search List representing number of
	 *         hits found
	 */
	public static int getResultsSize() {
		return searchResults.size();
	}

}
