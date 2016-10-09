package spend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class SpendWords {
	
	public static void isContain(String s1) throws Exception{
		FileWriter fileWriter=new FileWriter("D:/level-RB.txt",true);
		//String s2 = s1.substring(s1.indexOf("word1=")+6, s1.indexOf(" pos1="));
		
		if(s1.contains("RB")){
			String s2 = s1.substring(0, s1.indexOf("\t\tRB"));
			fileWriter.write(s2.toLowerCase()+"\n");
		}
		fileWriter.flush(); 
		fileWriter.close();
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileReader file = new FileReader("D:/level.txt");
		BufferedReader reader = new BufferedReader(file);

		for (String line = reader.readLine(); line != null; line = reader.readLine()) {
			System.out.println(line);
			isContain(line);
		}		   
		reader.close();

	}

}
