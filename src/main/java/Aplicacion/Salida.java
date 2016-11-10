package Aplicacion;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Clase para la  generación de ficheros de salida tokenizados
 * @author Mauricio
 *
 */
public class Salida {
	private PrintStream escritor; ///Flujo de salida
	private String[] tokens; ///Tokens a escribir

	/**
	 * Constructor de Salida
	 * Crea un flujo de salida en un nuevo fichero o sobre uno ya existente y recibe un conjunto de
	 * tokens a escribir en él.
	 * @param nfile - Nombre y dirección de fichero
	 * @param tokens - Tokens
	 * @throws FileNotFoundException
	 */
	public Salida(String nfile, String[] tokens) throws FileNotFoundException
	{
		this.escritor = new PrintStream(new FileOutputStream(nfile));
		this.tokens = tokens;
	}

	/**
	 * Escribe los tokens en el fichero de salida
	 */
	public void escribirSalida()
	{
		for( String token : tokens )
		{
			escritor.print(token);
			escritor.println();
		}
	}

	/**
	 * @return el escritor de ficheros
	 */
	public PrintStream getEscritor() {
		return escritor;
	}

	/**
	 * @param escritor - el escritor de ficheros a configurar
	 */
	public void setEscritor(PrintStream escritor) {
		this.escritor = escritor;
	}

	/**
	 * @return la lista de tokens obtenida
	 */
	public String[] getTokens() {
		return tokens;
	}

	/**
	 * @param tokens - la lista de tokens a asignar
	 */
	public void setTokens(String[] tokens) {
		this.tokens = tokens;
	}



}
