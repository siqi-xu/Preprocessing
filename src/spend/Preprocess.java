package spend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Preprocess {
	public void doProcess(String strDir) throws IOException {
		File fileDir = new File(strDir);
		if (!fileDir.exists()) {
			System.out.println("File not exist:" + strDir);
			return;
		}
		String subStrDir = strDir.substring(strDir.lastIndexOf("/")); //获取文件夹名
		String dirTarget = "D:/english" + subStrDir;
		if (!new File("D:/english").exists()) {
			new File("D:/english").mkdir();
		}
		File fileTarget = new File(dirTarget);
		if (!fileTarget.exists()) {
			fileTarget.mkdir();
		}
		File[] srcFiles = fileDir.listFiles();
		String[] stemFileNames = new String[srcFiles.length];
		for (int i = 0; i < srcFiles.length; i++) {
			String fileFullName = srcFiles[i].getCanonicalPath(); //get路径全部
			String fileShortName = srcFiles[i].getName(); //get fileName或文件夹名
			if (!new File(fileFullName).isDirectory()) {
				System.out.println("Begin preprocess:" + fileFullName);
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append(dirTarget + "/" + fileShortName);
				createProcessFile(fileFullName, stringBuilder.toString());
				stemFileNames[i] = stringBuilder.toString();
			} else {
				fileFullName = fileFullName.replace("\\", "/");
				doProcess(fileFullName);
			}
		}
	}
	
	private static void createProcessFile(String srcDir, String targetDir)
			throws IOException {
		// TODO Auto-generated method stub
		FileReader srcFileReader = new FileReader(srcDir);
		FileWriter targetFileWriter = new FileWriter(targetDir);
		BufferedReader srcFileBR = new BufferedReader(srcFileReader);

		for (String line = srcFileBR.readLine(); line != null; line = srcFileBR.readLine()) {
			targetFileWriter.write(line.replaceAll("[\\p{P}\\p{M}\\p{S}\\p{N}]+", ""));
			System.out.println(line.replaceAll("[\\p{P}\\p{M}\\p{S}\\p{N}]+", ""));
			
	}
		targetFileWriter.flush();
		targetFileWriter.close();
		srcFileReader.close();
		srcFileBR.close();
	}
	
	public  static void main(String []args) throws IOException {
		// TODO Auto-generated method stub
		Preprocess dataPrePro = new Preprocess();
		dataPrePro.doProcess("D:/Translate");
	}
	
}
