package Aplicacion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InvalidFormatException;
/**
 * Clase ejecutable principal del programa. Incorpora lectura de ficheros y directorios por
 * parámetros.
 * @author Mauricio
 *
 */
public class Main {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		System.out.println(args[0] + " "+ args[0].matches("d"));
		if (args[0].matches("f"))
		{
		Lector lector = new Lector(args[1]);
InputStream modelIn = new FileInputStream( "models/en-token.model" );
		try
		{
			TokenizerModel model = new TokenizerModel( modelIn );

			Tokenizer tokenizer = new TokenizerME(model);

				/* note what happens with the "three depending on which model you use */

			String cadena = "";
			while (lector.getReader().hasNextLine())
			{
				cadena += lector.getReader().nextLine() + " ";
			}
			System.out.println(cadena);
			String[] tokens = tokenizer.tokenize
					(cadena);
			for( String token : tokens )
			{
				System.out.println( token );
			}
			Salida salida = new Salida("salida.txt", tokens);
			salida.escribirSalida();
			salida.getEscritor().close();


		}
		catch( IOException e )
		{
			e.printStackTrace();
		}
		finally
		{
			if( modelIn != null )
			{
				try
				{
					modelIn.close();
				}
				catch( IOException e )
				{
				}
			}
		}
		System.out.println( "\n-----\ndone" );
		}
		else if (args[0].matches("d"))
		{
			InputStream modelIn = new FileInputStream( "models/en-token.model" );
			TokenizerModel model = new TokenizerModel( modelIn );
			Tokenizer tokenizer = new TokenizerME(model);
			String sDirectorio = args[1];
			File f = new File(sDirectorio);
			if (f.exists()){
				File[] ficheros = f.listFiles();
				for (int x=0;x<ficheros.length;x++)
				  System.out.println(ficheros[x].getName());
				for (int i=0; i<ficheros.length;i++)
				{
					Lector lector = new Lector(ficheros[i]);

						/* note what happens with the "three depending on which model you use */

					String cadena = "";
					while (lector.getReader().hasNextLine())
					{
						cadena += lector.getReader().nextLine() + " ";
					}
					System.out.println(cadena);
					String[] tokens = tokenizer.tokenize
							(cadena);
					for( String token : tokens )
					{
						System.out.println( token );
					}
					System.out.println( "\n-----\ndone" );

				}

				}
				else {

				}

		}



	}

}
