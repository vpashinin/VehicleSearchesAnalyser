import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


public class ReadFile {

	
	public List<String> openFile(String fileName) throws IOException{

		InputStreamReader is = new InputStreamReader(new FileInputStream(fileName), Charset.forName("latin1"));
		BufferedReader textReader = new BufferedReader(is);
	
		List<String> textData = new ArrayList<>();
		 
		String line = textReader.readLine(); 
		while (line != null) {
			textData.add(line);
			line = textReader.readLine();	
		}
		
		textReader.close();
		return textData;
	}
		
}



	



