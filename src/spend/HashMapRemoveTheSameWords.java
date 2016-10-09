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
                 if(!hm.containsKey(s)){  //如果hm没有包含s这个单词，则把s加入到hm，同时写入文件.txt中  
                     hm.put(s, 1);  
                     //输出到文件  
                     fw.write(s+"\n");   
                     fw.flush();  
                 }  
                       
             }  
             fw.close();  
	}
}
