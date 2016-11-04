package Aplicacion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Lector lector = new Lector(args[0]);
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

}
