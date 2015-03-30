//classe permettant de créer le Panel titre. L'avantage de faire une classe pour l'écran titre (plutôt que de l'implémenter 
//directement à la création de la fenêtre principale) est de pouvoir le réobtenir facilement (après une partie, par ex).

package v1;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen extends JPanel 
{
	private JButton nouveau_jeu=new JButton("Start Game");
	public StartScreen(MainWindow f)
	{
		super();
		nouveau_jeu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				f.preinti();
			}
		});
		
		this.setLayout(new BorderLayout());
		JLabel image = new JLabel(new ImageIcon("titre.jpeg") );
		JLabel ct = new JLabel("© C. ABGRALL, R. CABALL, A. KIRCHER, B. LOLLIVIER - 2015");
		JPanel ctf= new JPanel();
		ctf.add("CENTER",ct);
		this.add("North",image);
		this.add("Center",nouveau_jeu);
		this.add("South",ctf);
	}
}
