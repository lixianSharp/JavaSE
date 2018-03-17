package c_java_IO.Reader_Writer.c_BufferedReader_BufferedWriter;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * ���󣺸��ƶ༫�ļ���
 * 
 * ����Դ��C:\Users\��Ԫ\Desktop\html+css+js\day05
 * Ŀ�ĵأ�d:\\
 * 
 * ������
 * 		A:��װ����ԴFile
 * 		B:��װĿ�ĵ�File
 * 		C:�жϸ�File���ļ��л����ļ�
 * 			a:���ļ���
 * 				����Ŀ�ĵ�Ŀ¼�´������ļ���
 * 				��ȡ��File�����µ������ļ������ļ���File����
 * 				�����õ�ÿһ��File����
 * 				�ص�C
 * 			b:���ļ�
 * 				�͸���(�ֽ���)
 */
public class CopyFoldersDemo {
	public static void main(String[] args) throws IOException {
		// ��װ����ԴFile
		File srcFile = new File("C:\\Users\\��Ԫ\\Desktop\\html+css+js\\day05");
		// ��װĿ�ĵ�File
		File destFile = new File("d:\\");

		// �����ļ��еĹ���
		copyFolder(srcFile, destFile);
	}
	//�����ļ���
	private static void copyFolder(File srcFile, File destFile)
			throws IOException {
		// �жϸ�File���ļ��л����ļ�
		if (srcFile.isDirectory()) {
			// �ļ���
			File newFolder = new File(destFile, srcFile.getName());
			newFolder.mkdir();

			// ��ȡ��File�����µ������ļ������ļ���File����
			File[] fileArray = srcFile.listFiles();
			for (File file : fileArray) {
				copyFolder(file, newFolder);
			}
		} else {
			// �ļ�
			File newFile = new File(destFile, srcFile.getName());
			copyFile(srcFile, newFile);
		}
	}

	//�����ļ� ��srcFile���Ƶ�newFile��
	private static void copyFile(File srcFile, File newFile) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
				srcFile));
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(newFile));

		byte[] bys = new byte[1024];
		int len = 0;
		while ((len = bis.read(bys)) != -1) {
			bos.write(bys, 0, len);
		}

		bos.close();
		bis.close();
	}
}