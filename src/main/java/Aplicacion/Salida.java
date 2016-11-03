package Aplicacion;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Salida {
	private PrintStream escritor;
	private String[] tokens;

	public Salida(String nfile, String[] tokens) throws FileNotFoundException
	{
		this.escritor = new PrintStream(new FileOutputStream(nfile));
		this.tokens = tokens;
	}

	public void escribirSalida()
	{
		for( String token : tokens )
		{
			escritor.print(token);
			escritor.println();
		}
	}

	/**
	 * @return the escritor
	 */
	public PrintStream getEscritor() {
		return escritor;
	}

	/**
	 * @param escritor the escritor to set
	 */
	public void setEscritor(PrintStream escritor) {
		this.escritor = escritor;
	}

	/**
	 * @return the tokens
	 */
	public String[] getTokens() {
		return tokens;
	}

	/**
	 * @param tokens the tokens to set
	 */
	public void setTokens(String[] tokens) {
		this.tokens = tokens;
	}



}
