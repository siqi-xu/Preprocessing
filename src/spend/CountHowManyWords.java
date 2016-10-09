package spend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class CountHowManyWords {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileReader file = new FileReader("D:/hownet-MPQA-GI-NRC-positive-RemoveSame.txt");
		BufferedReader br = new BufferedReader(file);  
		FileWriter fw1 = new FileWriter("D:/OneWord-positive.txt",true);
		FileWriter fw2 = new FileWriter("D:/Words-positive.txt",true);
		 
        String s = null;  
        while((s=br.readLine())!=null){ 
        	String[] words = s.split(" ");
        	if(words.length == 1){
        		fw1.write(s+"\n");   
        		fw1.flush();  
        	}
        	else{
        		fw2.write(s+"\n");   
        		fw2.flush();
        	} 
        		
                  
        } 
        fw1.close();
        fw2.close(); 
        br.close();
	}

}
