package Aplicacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lector {
	private File file;
	private Scanner reader;

	/**
	 * @param file
	 * @throws FileNotFoundException
	 */
	public Lector(String nfile) throws FileNotFoundException {
		super();
		this.file = new File(nfile);
		this.reader = new Scanner(this.file);
	}

	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * @return the reader
	 */
	public Scanner getReader() {
		return reader;
	}

	/**
	 * @param reader the reader to set
	 */
	public void setReader(Scanner reader) {
		this.reader = reader;
	}







}
