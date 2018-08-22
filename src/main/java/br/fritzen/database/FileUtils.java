package br.fritzen.database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;



public class FileUtils {

	private static final Logger LOG = Logger.getLogger(FileUtils.class.getName());
	
	
	public static String loadTextFile(final String filename) throws IOException {
		
		long time = System.currentTimeMillis();
		
		InputStream inputStream = FileUtils.class.getResourceAsStream(filename);
		InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
		BufferedReader reader = new BufferedReader(streamReader);
		StringBuilder sb = new StringBuilder();
		String line;
		
		while ((line = reader.readLine()) != null) {
			sb.append(line).append("\n");
		}
		
		reader.close();
		
		time = System.currentTimeMillis() - time;
		 
		LOG.info("O arquivo " + filename + " foi lido em " + time + "ms");
		
		
		return sb.toString();
		
	}
}
