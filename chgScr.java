//Cette classe écouteuse permet de changer la disposition d'une fenêtre ( remplacer le fond de w par nouvw). 
//Pour l'instant, elle permet juste de passer du StartScreen à une classe test Jeu dans la fenêtre principale, mais Jeu 
// sera à terme remplacée par une fenêtre Paramètres. Cette même classe permettra sans doute de passer ensuite de Paramètres à 
//Plateau.

import javax.swing.*;
import java.awt.event.*;

public class chgScr implements ActionListener {
	private JFrame w;
	private	JPanel nouvw;
	public chgScr(JFrame w,JPanel nouvw){
		this.w=w;
		this.nouvw=nouvw;
	}
	public void actionPerformed(ActionEvent e){
		w.setContentPane(nouvw);
		w.validate();
	}
}
