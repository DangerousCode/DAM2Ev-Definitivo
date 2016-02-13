package servidor;

import java.awt.TextArea;

import javax.swing.JFrame;

public class Ventanas {
	JFrame ventana=new JFrame();
	TextArea texto_ventana=new TextArea();
	
	Ventanas(String nombre){
		ventana.setName(nombre);
		ventana.setTitle(nombre);
		ventana.setSize(500, 400);
		ventana.setVisible(true);
		ventana.add(texto_ventana);
	}
	public void escribecadena(String texto){
		texto_ventana.setText(texto_ventana.getText()+texto+"\n");
	}
}
