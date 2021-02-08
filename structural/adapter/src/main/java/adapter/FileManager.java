package adapter;

public interface FileManager {
	Status open(String filename);
	Status close();
	Status read(int offset, int length, byte[] bytes);
	Status write(int offset, int length, byte[] bytes);
}
