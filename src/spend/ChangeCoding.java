package spend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

//�ı��ļ����룬windows��Ĭ�ϱ���ΪGBK���ĳ�UTF-8������google translateʱ�Ų�������
public class ChangeCoding {

	public static void main(String[] args) throws Exception {
		String fileName;
		for(int i = 0; i <= 999;i++){
			fileName = "D:/ChnSentiCorp_htl_ba_2000/pos/pos." + i + ".txt";
			convert(fileName,"GBK", "UTF-8", new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.endsWith("txt");
				}
			}
	);
		}
		
	}

	/**
	 * ��ָ���ļ���Ŀ¼ת����ָ���ı���
	 * 
	 * @param fileName
	 *            Ҫת�����ļ�
	 * @param fromCharsetName
	 *            Դ�ļ��ı���
	 * @param toCharsetName
	 *            Ҫת���ı���
	 * @throws Exception
	 */
	public static void convert(String fileName, String fromCharsetName,
			String toCharsetName) throws Exception {
		convert(new File(fileName), fromCharsetName, toCharsetName, null);
	}

	/**
	 * ��ָ���ļ���Ŀ¼ת����ָ���ı���
	 * 
	 * @param file
	 *            Ҫת�����ļ���Ŀ¼
	 * @param fromCharsetName
	 *            Դ�ļ��ı���
	 * @param toCharsetName
	 *            Ҫת���ı���
	 * @throws Exception
	 */
	public static void convert(File file, String fromCharsetName,
			String toCharsetName) throws Exception {
		convert(file, fromCharsetName, toCharsetName, null);
	}

	/**
	 * ��ָ���ļ���Ŀ¼ת����ָ���ı���
	 * 
	 * @param file
	 *            Ҫת�����ļ���Ŀ¼
	 * @param fromCharsetName
	 *            Դ�ļ��ı���
	 * @param toCharsetName
	 *            Ҫת���ı���
	 * @param filter
	 *            �ļ���������
	 * @throws Exception
	 */
	public static void convert(String fileName, String fromCharsetName,
			String toCharsetName, FilenameFilter filter) throws Exception {
		convert(new File(fileName), fromCharsetName, toCharsetName, filter);
	}

	/**
	 * ��ָ���ļ���Ŀ¼ת����ָ���ı���
	 * 
	 * @param file
	 *            Ҫת�����ļ���Ŀ¼
	 * @param fromCharsetName
	 *            Դ�ļ��ı���
	 * @param toCharsetName
	 *            Ҫת���ı���
	 * @param filter
	 *            �ļ���������
	 * @throws Exception
	 */
	public static void convert(File file, String fromCharsetName,
			String toCharsetName, FilenameFilter filter) throws Exception {
		if (file.isDirectory()) {
			File[] fileList = null;
			if (filter == null) {
				fileList = file.listFiles();
			} else {
				fileList = file.listFiles(filter);
			}
			for (File f : fileList) {
				convert(f, fromCharsetName, toCharsetName, filter);
			}
		} else {
			if (filter == null
					|| filter.accept(file.getParentFile(), file.getName())) {
				String fileContent = getFileContentFromCharset(file,
						fromCharsetName);
				saveFile2Charset(file, toCharsetName, fileContent);
			}
		}
	}

	/**
	 * ��ָ�����뷽ʽ��ȡ�ļ��������ļ�����
	 *
	 * @param file
	 *            Ҫת�����ļ�
	 * @param fromCharsetName
	 *            Դ�ļ��ı���
	 * @return
	 * @throws Exception
	 */
	public static String getFileContentFromCharset(File file,
			String fromCharsetName) throws Exception {
		if (!Charset.isSupported(fromCharsetName)) {
			throw new UnsupportedCharsetException(fromCharsetName);
		}
		InputStream inputStream = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(inputStream,
				fromCharsetName);
		char[] chs = new char[(int) file.length()];
		reader.read(chs);
		String str = new String(chs).trim();
		reader.close();
		return str;
	}

	/**
	 * ��ָ�����뷽ʽд�ı��ļ������ڻḲ��
	 * 
	 * @param file
	 *            Ҫд����ļ�
	 * @param toCharsetName
	 *            Ҫת���ı���
	 * @param content
	 *            �ļ�����
	 * @throws Exception
	 */
	public static void saveFile2Charset(File file, String toCharsetName,
			String content) throws Exception {
		if (!Charset.isSupported(toCharsetName)) {
			throw new UnsupportedCharsetException(toCharsetName);
		}
		OutputStream outputStream = new FileOutputStream(file);
		OutputStreamWriter outWrite = new OutputStreamWriter(outputStream,
				toCharsetName);
		outWrite.write(content);
		outWrite.close();
	}
}
