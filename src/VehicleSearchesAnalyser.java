import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
                                                                                  //vehicleselections.txt
                                                                                 //make;model 
                                                                                //TD-VM-121;TD-505
import java.util.List;
//import java.util.Map;



 public class VehicleSearchesAnalyser {    //Поиски Автомобиля Анализатор
        	
   	    public static void main(String[] args)throws IOException {
   	    	VehicleSearchesAnalyser vsa = new VehicleSearchesAnalyser();
   	    	
   	    	
   	    	
	        File destinationFile = new File("/home/vpashinin/vehicle_selections.csv");	   	
	        FileOutputStream fos = new FileOutputStream(destinationFile);
			
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			
			File currentDir = new File("/home/vpashinin/accesslogs"); // current directory // programma  vivodit file na displey
			File[] files = currentDir.listFiles();
	     
			for (File file : files) {
	 		     String fileName = file.getCanonicalPath(); 
				 vsa.readLogfile(bw, fileName); 
	     
			 
			} 
			bw.flush();
			   			    	         	    
     	    bw.close();
     
        }  
   	    
   	         
 	      public void  readLogfile(BufferedWriter bw, String fileName) throws IOException {
 	           bw.write("make; series");
 	           bw.newLine();
 	           
       	        ReadFile file = new ReadFile ();         
       	        List<String> lines = file.openFile(fileName); 
       	        for (String line : lines){ 
		           if (line.contains("make=")&& line.contains("series=")&& line.contains("GET /vehicle/types")) {
		    	 		    	  	       
			           int positionOfMake = line.indexOf("make");  
			           String pieceMake = line.substring(positionOfMake+5);		          
			           int positionOfAnd = pieceMake.indexOf("&");
			           String make = pieceMake.substring(0, positionOfAnd); 
			           System.out.println(make);
			          		                  
		   	           int positionOfSeries = line.indexOf("series");  
			           String pieceSeries = line.substring(positionOfSeries+7);	 	
			           int positionOfSer = pieceSeries.indexOf(" ");
			           String series = pieceSeries.substring(0, positionOfSer);  
			           System.out.println(series);     
		             
			           bw.write(make+";"+series);
			           bw.newLine();
			    }
		   }
	    
      }      	   					         				         				         				         				         				         				         				     				        
}		






