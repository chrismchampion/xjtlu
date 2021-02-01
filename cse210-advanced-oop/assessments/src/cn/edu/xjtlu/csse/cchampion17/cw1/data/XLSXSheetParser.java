package cn.edu.xjtlu.csse.cchampion17.cw1.data;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.apache.poi.ooxml.util.SAXHelper;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFReader.SheetIterator;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.model.StylesTable;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class XLSXSheetParser {

	private final OPCPackage XLSX_PKG;
	private final PrintStream OUTPUT;

	/**
	 * Constructor for parsing .XLSX sheets called in the program's Tester.main()
	 * method.
	 * 
	 * @param pkg open, writable package used as a container to store data objects
	 * @param out java.io PrintStream for printing output to the console
	 */
	public XLSXSheetParser(OPCPackage pkg, PrintStream out) {
		this.XLSX_PKG = pkg;
		this.OUTPUT = out;
	}

	/**
	 * Get the sheets shared strings data (contains sheet content) from .XLSX file
	 * in OPCPackage container in read-only mode to conserve memory. Uses XSSFReader
	 * for reading data from XLSX package. Iterates over sheet data using XSSFReader
	 * helper method and prints information about the sheet (name) to the console.
	 * Finally passes read-only shared strings data and concrete instance of
	 * SheetContentsHandler implementation to Class private processSheet() method.
	 * 
	 * @throws IOException        thrown by read-only shared strings table upon
	 *                            reading contents from .XLSX file, e.g. file not
	 *                            found or corrupt
	 * @throws SAXException       thrown by read-only shared strings table. Returns
	 *                            basic error or warning information fromeither the
	 *                            XML parser or the application
	 * @throws OpenXML4JException thrown by XSSFReader upon error reading contents
	 *                            from OPCPackage
	 */
	public void process() throws IOException, SAXException, OpenXML4JException {
		System.out.println("Processing spreadsheet...");
		// Get the sheets shared strings data (contains sheet content) in read-only mode
		// to conserve memory.
		// Throws IO- and SAXException
		ReadOnlySharedStringsTable roSST = new ReadOnlySharedStringsTable(this.XLSX_PKG);
		// Instantiate Apache POI XSSFReader for reading data from XLSX package
		// Throws OpenXML4JException
		XSSFReader xssfReader = new XSSFReader(this.XLSX_PKG);
		// Get styles table: shared across all sheets in the XLSX workbook.
		StylesTable sheetStyle = xssfReader.getStylesTable();
		// Get sheet iterator to iterate over each sheet in the workbook.
		SheetIterator sheetIter = (SheetIterator) xssfReader.getSheetsData();
		// Start at workbook sheet index 0
		// Each sheet's InputStream is only opened when fetched from the Iterator.
		// Must close each InputStreams after completing sheet processing.
		try (InputStream inStream = sheetIter.next()) {
			String sheetName = sheetIter.getSheetName();
			this.OUTPUT.println();
			this.OUTPUT.println("Sheet name: " + sheetName);
			// process the sheet
			processSheet(sheetStyle, roSST, new XLSXSheetContentHandler(), inStream);
		}
	}

	/**
	 * Formats and reads in sheet data.
	 * 
	 * @param sheetStyle              org.apache.poi.xssf.model.StylesTable
	 * @param roSST                   org.apache.poi.xssf.usereventmodel.ReadOnlySharedStringsTable
	 * @param xlsxSheetContentHandler concrete implementation of
	 *                                org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler
	 * @param inStream                java.io InputStream for reading in byte stream
	 */
	private void processSheet(StylesTable sheetStyle, ReadOnlySharedStringsTable roSST,
			XLSXSheetContentHandler xlsxSheetContentHandler, InputStream inStream) {
		// Instantiate Apache POI DataFormatter to access methods for formatting the
		// value stored in an Cell.
		DataFormatter formatter = new DataFormatter();
		// Create a new SAX input source with a byte stream.
		InputSource sheetSource = new InputSource(inStream);
		try {
			XMLReader sheetParser = SAXHelper.newXMLReader();
			ContentHandler handler = new XSSFSheetXMLHandler(sheetStyle, null, roSST, xlsxSheetContentHandler,
					formatter, false);
			sheetParser.setContentHandler(handler);
			sheetParser.parse(sheetSource);
		} catch (Exception e) {
			throw new RuntimeException("XML document parsing failure: " + e);
		}

	}
}
