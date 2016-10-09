package spend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class JudgeEmotions {
	
	public static void isContain(String s1) throws Exception{
		FileWriter fileWriter1=new FileWriter("D:/nrcPositive.txt",true);
		FileWriter fileWriter2=new FileWriter("D:/nrcNegative.txt",true);
		if(s1.contains("positive")) fileWriter1.write(s1+"\n");
		else if(s1.contains("negative")) fileWriter2.write(s1+"\n");
		fileWriter1.flush(); 
		fileWriter2.flush(); 
		fileWriter1.close();
		fileWriter2.close();
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileReader file = new FileReader("D:/nrc1.txt");
		BufferedReader reader = new BufferedReader(file);

		for (String line = reader.readLine(); line != null; line = reader.readLine()) {
			System.out.println(line);
			isContain(line);
		}		   
		reader.close();

	}

}
