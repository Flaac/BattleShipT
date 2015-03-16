package v1;


import javax.swing.*;
import java.awt.*;


public class MainWindow 
{
public static void main(String argd[]) 
{
	JFrame f = new JFrame("BattleShip");
	
	int colonne = 8;
	int ligne = 8;
	int nbcase = ligne*colonne;
	
	
	
	
	// Main panel
	JPanel p = (JPanel)f.getContentPane();
	
	//JPanel accessories
	JPanel paneInt1 = new JPanel();
	JPanel paneInt2 = new JPanel();
	//Add layout
	GridLayout psec = new GridLayout(2,2);
	GridLayout plateau1 = new GridLayout(8,8);
	GridLayout plateau2 = new GridLayout(8,8);
	
	p.setLayout(psec);
	
	//Concatenation components
	paneInt1.setLayout(plateau1);
	paneInt2.setLayout(plateau2);
	JButton button_quit = new JButton("Quitter");
	JButton button_launch = new JButton("Afficher le plateau");
	p.add(button_quit);
	p.add(button_launch);
	p.add(paneInt1);
	p.add(paneInt2);
	

	
	//Ajout des boutons
	
	Button plateauB1[][] = new Button[nbcase][nbcase];
	Button plateauB2[][] = new Button[nbcase][nbcase];
	
	//
	Plateau matrice1 = new Plateau(ligne,colonne);
	Plateau matrice2 = new Plateau(ligne,colonne);
	
	
	for(int i=0;i<nbcase;i++)
	{
		//Implementation for player 1
		Button j = new Button(i,30);
		paneInt1.add(j);
		int k = i%8;
		int a = i;a-=k;a/=8;
		plateauB1[k][a] = j;
		plateauB1[k][a].addActionListener(new Fenetre(matrice1,plateauB1[k][a]));
		//Implementation for player 2
		
		j = new Button(i,30);
		paneInt2.add(j);
		plateauB2[k][a] = j;
		plateauB2[k][a].addActionListener(new Fenetre(matrice2,plateauB2[k][a]));
	}
	
	for(int i=0;i<8;i++)
	{
		for(int j=0;j<8;j++)
		{
			if(matrice1.getPlateau(i,j)==1)
			{
				plateauB1[i][j].setEnabled(false);
			}
		}
	}
	
	p.setSize(500,500);
	f.pack();
	f.setVisible(true);
	}
	
	public void jeu(Plateau matrice1)
	{

	}
}
