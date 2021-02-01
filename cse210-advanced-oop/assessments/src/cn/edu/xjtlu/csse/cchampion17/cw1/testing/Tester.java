package cn.edu.xjtlu.csse.cchampion17.cw1.testing;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.xml.sax.SAXException;

import cn.edu.xjtlu.csse.cchampion17.cw1.data.XLSXSheetParser;

public class Tester {

	/**
	 * Test class contains program main method. Takes .XLSX file as an argument and
	 * parses the file. Then displays parse time and console menu.
	 * 
	 * @param args Include path to .XLSX file as args[0] in Run Configurations >
	 *             Program arguments, e.g. C:\Users\name\Downloads\file.xlsx
	 * @throws InvalidOperationException
	 * @throws IOException
	 * @throws SAXException
	 * @throws OpenXML4JException
	 * @throws ParseException
	 */
	public static void main(String[] args)
			throws InvalidOperationException, IOException, SAXException, OpenXML4JException, ParseException {

		Instant start = Instant.now();

		// Include path to .XLSX file in Run Configurations > Program arguments
		File xlsxFile = new File(args[0]);

		if (!xlsxFile.exists()) {
			System.err.println("Not found or not a file: " + xlsxFile.getPath());
			return;
		}

		try (OPCPackage pkg = OPCPackage.open(xlsxFile.getPath(), PackageAccess.READ)) {
			System.out.println("Accessing file " + xlsxFile.getPath());
			// Now that file is opened as OPCPackage, parse the data.
			XLSXSheetParser parser = new XLSXSheetParser(pkg, System.out);
			parser.process();
		}

		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		System.out.println("Data set parse time: " + timeElapsed + "ms");

		ConsoleMenu.displayMenu();
	}
}
