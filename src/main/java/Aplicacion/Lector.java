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
	 * Constructor 1 de lector
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
	 * Constructor 2 de lector
	 * Recibe un fichero como parámetro y lo asignacomo el fichero del lector y crea un escáner
	 * para leerlo
	 * @param file - Fichero a asignar
	 * @throws FileNotFoundException
	 */

	public Lector(File file) throws FileNotFoundException {
		super();
		this.file = file;
		this.reader = new Scanner(this.file);
	}

	/**
	 * @return fichero a leer
	 */
	public File getFile() {
		return file;
	}

	/**
	 * @param file - Fichero a asignar
	 */
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * @return el lector  o escáner
	 */
	public Scanner getReader() {
		return reader;
	}

	/**
	 * @param reader - El lector o escáner a configurar
	 */
	public void setReader(Scanner reader) {
		this.reader = reader;
	}







}
