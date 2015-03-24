//classe test pour l'implémentation de chgScr

package v1;

import java.awt.BorderLayout;
import javax.swing.*;

public class Jeu extends JPanel{int colonne = 8;
	public Jeu(){
		setLayout(new BorderLayout());
		add("North", new JLabel("UN"));
		add("Center", new JLabel("DEUX"));
		add("South", new JButton("TROIS"));
	}
}
