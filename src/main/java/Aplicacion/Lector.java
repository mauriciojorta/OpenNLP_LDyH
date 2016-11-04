package Aplicacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Clase para la lectura de ficheros
 * @author Mauricio
 *
 */
public class Lector {
	private File file; /// Fichero a leer
	private Scanner reader; ///Lector de fichero

	/**
	 * Constructor de lector
	 * Recibe el nombre y la dirección de un fichero y crea un lector para leerlo
	 * @param nfile - Nombre y dirección de fichero
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
