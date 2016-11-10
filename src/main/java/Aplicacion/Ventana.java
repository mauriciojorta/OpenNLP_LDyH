package Aplicacion;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JTextField;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 * Interfaz gr√°fica de prueba. Permite cargar un fichero a leer, extraer su contenido y retornar
 * su salida tokenizada en un fichero.
 * @author Mauricio
 *
 */

public class Ventana {

	private JFrame frame;
	private JTextField textField_leer;
	private JTextField textField_salida;
	private Tokenizer tokenizer;
	private String[] tokens;
	private JTextArea textArea;
	private JButton btnSalida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(50, 11, 343, 113);
		frame.getContentPane().add(scrollPane);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane.setViewportView(textArea);


		textField_leer = new JTextField();
		textField_leer.setBounds(23, 145, 86, 20);
		frame.getContentPane().add(textField_leer);
		textField_leer.setColumns(10);

		JButton btnLeer = new JButton("Leer");
		btnLeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

						try
						{
							Lector lector = new Lector("test.txt");
							InputStream modelIn = new FileInputStream( "models/en-token.model" );
							TokenizerModel model = new TokenizerModel( modelIn );

							tokenizer = new TokenizerME(model);

								/* note what happens with the "three depending on which model you use */

							String cadena = "";
							while (lector.getReader().hasNextLine())
							{
								cadena += lector.getReader().nextLine() + " ";
							}
							System.out.println(cadena);
							textArea.setText(cadena);
							tokens = tokenizer.tokenize
									(cadena);
							btnSalida.setEnabled(true);
							textField_salida.setEnabled(true);
						}
						catch( IOException ex )
						{
							ex.printStackTrace();
						}

			}
		});
		btnLeer.setBounds(20, 176, 89, 23);
		frame.getContentPane().add(btnLeer);

		textField_salida = new JTextField();
		textField_salida.setBounds(311, 145, 86, 20);
		frame.getContentPane().add(textField_salida);
		textField_salida.setColumns(10);

		 btnSalida = new JButton("Salida");
		 btnSalida.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		Salida salida;
				try {
					salida = new Salida(textField_salida.getText(), tokens);
					salida.escribirSalida();
					textArea.setText("Fichero tokenizado " + textField_salida.getText() + " creado con Èxito");
					salida.getEscritor().close();
					btnSalida.setEnabled(false);
					textField_salida.setText("");
					textField_salida.setEnabled(false);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

		 	}
		 });
		btnSalida.setBounds(311, 176, 89, 23);
		frame.getContentPane().add(btnSalida);

		btnSalida.setEnabled(false);
		textField_salida.setEnabled(false);
	}
}
