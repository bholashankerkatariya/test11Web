package utils;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

public class CSVDataReader {

public static CSVReader csvreader;
	
	private static final String COMMENT_PREFIX = "--";

	public static Object[][] DDTReader(String csvPath) throws Exception {
		try {
			FileReader fr = new FileReader(csvPath);
			csvreader = new CSVReader(fr);
			List<String[]> complete = csvreader.readAll();
			complete.remove(0); 

			//Ignore commented out rows from CSV
			Iterator<String[]> iter = complete.iterator();
			while (iter.hasNext()) {
				String[] row = iter.next();
				if (row[0].startsWith(COMMENT_PREFIX)) {
					iter.remove();
				}
			}

			Object[][] arrayResp = new Object[complete.size()][];
			for (int i = 0; i < complete.size(); i++) {
				arrayResp[i] = complete.get(i);
			}
			return arrayResp;
		} catch (FileNotFoundException ex) {
			System.out.println(ex);
		} 
		return new Object[][] {};
	}
 }
