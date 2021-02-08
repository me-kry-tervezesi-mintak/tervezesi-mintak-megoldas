package adapter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public interface FileManagerUtil {
	boolean openFile(String filename);
	boolean closeFile();
	boolean writeToFile(String text, int offset, int length);
	String readFromFile(int offset, int length);
}
