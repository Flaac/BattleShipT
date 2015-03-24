//classe permettant de créer le Panel titre. L'avantage de faire une classe pour l'écran titre (plutôt que de l'implémenter 
//directement à la création de la fenêtre principale) est de pouvoir le réobtenir facilement (après une partie, par ex).

package v1;

import javax.swing.*;
import java.awt.*;

public class StartScreen extends JPanel {
	private JButton nouveau_jeu=new JButton("Start Game");
	public StartScreen(JFrame f){
		super();
		this.nouveau_jeu.addActionListener(new chgScr(f,new Jeu()));
		setLayout(new BorderLayout());
		JLabel image = new JLabel(new ImageIcon("titre.jpeg") );
		JLabel ct = new JLabel("© C. ABGRALL, R. CABALL, A. KIRCHER, B. LOLLIVIER - 2015");
		JPanel ctf= new JPanel();
		ctf.add("CENTER",ct);
	    add("North",image);
		add("Center",nouveau_jeu);
		add("South",ctf);
	}
}
