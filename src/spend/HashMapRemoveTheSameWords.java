package spend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class HashMapRemoveTheSameWords {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
  
			 FileReader file = new FileReader("D:/OneWord-positive-NN.txt");
			 BufferedReader br = new BufferedReader(file);  
             FileWriter fw = new FileWriter("D:/OneWord-positive-NN-RemoveSame.txt",true);  
             HashMap<String, Integer> hm = new HashMap<String, Integer>();  
             String s = null;  
             while((s=br.readLine())!=null){  
                 if(!hm.containsKey(s)){  //���hmû�а���s������ʣ����s���뵽hm��ͬʱд���ļ�.txt��  
                     hm.put(s, 1);  
                     //������ļ�  
                     fw.write(s+"\n");   
                     fw.flush();  
                 }  
                       
             }  
             fw.close();  
	}
}
