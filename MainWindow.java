package v1;


import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.util.Vector;


public class MainWindow extends JFrame
{
	private Plateau matrice1, matrice2;
	Button plateauB1[][];
	Button plateauB2[][];
	JButton button_launch;
	private OptionWindow fenOp;
	//private StartScreen fenStart;
	private boolean choix_bateau;
	
	
	
	
	
	
	public MainWindow(Plateau plateau1, Plateau plateau2)
	{
		this.matrice1 = plateau1;
		this.matrice2 = plateau2;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("BattleShip");
		this.setSize(1200, 600);
		this.setContentPane(new StartScreen(this));
		this.pack();
	}
	
	public void preinti()
	{
		this.getContentPane().removeAll();
		fenOp = new OptionWindow(this);
		this.revalidate();
	}
	
	
	
	public void init() 
	{
		this.getContentPane().removeAll();
		int colonne = 8;
		choix_bateau = false;
		int ligne = 8;
		int nbcase = ligne*colonne;
		plateauB1 = new Button[ligne][colonne];
		plateauB2 = new Button[ligne][colonne];
		
		
		
		// Main panel
		JPanel main_pane = (JPanel)this.getContentPane();
		
		//JPanel accessories

		
		
		//Add layout
		BorderLayout main_layout = new BorderLayout(5,5);
		GridLayout center_layout = new GridLayout(1,2,5,5); //Layout Center
		GridLayout plateau1 = new GridLayout(8,8); // First board
		GridLayout plateau2 = new GridLayout(8,8); // Second board
		GridLayout option_player1= new GridLayout(6,1);
		GridLayout option_player2= new GridLayout(6,1);
		FlowLayout north_layout= new FlowLayout(FlowLayout.CENTER);
		north_layout.setVgap(30);
		FlowLayout south_layout= new FlowLayout();
		south_layout.setHgap(10);
		south_layout.setVgap(10);
		FlowLayout south_east_layout = new FlowLayout(FlowLayout.RIGHT);
		south_layout.setHgap(10);
		south_layout.setVgap(10);
		FlowLayout south_west_layout = new FlowLayout(FlowLayout.LEFT);
		south_layout.setHgap(10);
		south_layout.setVgap(10);
		JPanel pane_player1 = new JPanel();
		JPanel pane_player2 = new JPanel();
		JPanel center_pane = new JPanel();
		JPanel east_pane = new JPanel();
		JPanel west_pane = new JPanel();
		JPanel south_pane = new JPanel();
		JPanel south_east_pane = new JPanel();
		JPanel south_west_pane = new JPanel();
		JPanel north_pane = new JPanel();
		
		//SetLayout
		pane_player1.setLayout(plateau1);
		pane_player2.setLayout(plateau2);
		center_pane.setLayout(center_layout);
		main_pane.setLayout(main_layout);
		east_pane.setLayout(option_player2);
		west_pane.setLayout(option_player1);
		south_pane.setLayout(south_layout);
		north_pane.setLayout(north_layout);
		south_east_pane.setLayout(south_east_layout);
		south_west_pane.setLayout(south_west_layout);
		
		//Concatenation components

		JLabel label_nomjoueur1 = new JLabel("Nom_du_joueur1               ");
		JLabel label_nbHit1 = new JLabel("nb_Hit : ");
		JLabel label_nbCoupJoue1 = new JLabel("nb_coup : ");
		JLabel label_turn1 = new JLabel("Tour_joueur : ");
		east_pane.add(label_nomjoueur1);
		east_pane.add(label_nbHit1);
		east_pane.add(label_nbCoupJoue1);
		east_pane.add(label_turn1);
		
		JLabel label_nomjoueur2 = new JLabel("Nom_du_joueur1               ");
		JLabel label_nbHit2 = new JLabel("nb_Hit : ");
		JLabel label_nbCoupJoue2 = new JLabel("nb_coup : ");
		JLabel label_turn2 = new JLabel("Tour_joueur : ");
		west_pane.add(label_nomjoueur2);
		west_pane.add(label_nbHit2);
		west_pane.add(label_nbCoupJoue2);
		west_pane.add(label_turn2);
		
		
		
		
		
		JLabel label_welcome = new JLabel("Bienvenue sur BattleShip !");
		north_pane.add(label_welcome);
		JButton button_about = new JButton("A propos...");
		JButton button_rule = new JButton("Règles");
		JButton button_quit = new JButton("Quitter");
		button_launch = new JButton("Placer les bateaux");
		button_launch.addActionListener(new Button_Launch_Listener());
		button_quit.addActionListener(new Button_Quit_Listener());
		button_rule.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				RulesWindow rule_fen = new RulesWindow();
				rule_fen.setVisible(true);
			}
		});
		button_about.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				AboutWindow about_fen = new AboutWindow();
				about_fen.setVisible(true);
			}
		});
		south_east_pane.add(button_launch);
		south_east_pane.add(button_quit);
		south_west_pane.add(button_rule);
		south_west_pane.add(button_about);
		south_pane.add(south_west_pane);
		south_pane.add(south_east_pane);
		
		
		
		
		main_pane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10)); // Creation Border
		center_pane.add(pane_player1);
		center_pane.add(pane_player2);
		
		// Final concatenation
		main_pane.add("North",north_pane);
		main_pane.add("South",south_pane);
		main_pane.add("Center",center_pane);
		main_pane.add("East",east_pane);
		main_pane.add("West",west_pane);
		
	

		matrice1.init(ligne, colonne);
		matrice2.init(ligne, colonne);
		
		
		for(int i=0;i<nbcase;i++)
		{
			//Implementation for player 1
			Button j = new Button(matrice1,i);
			pane_player1.add(j);
			int k = i%8;
			int a = i;a-=k;a/=8;
			plateauB1[a][k] = j;
			plateauB1[a][k].setEnabled(false);
			plateauB1[a][k].addActionListener(new Button_Listener(matrice1,plateauB1[a][k]));
			
			//Implementation for player 2
			j = new Button(matrice2,i);
			pane_player2.add(j);
			plateauB2[a][k] = j;
			plateauB2[a][k].setEnabled(false);
			plateauB2[a][k].addActionListener(new Button_Listener(matrice2,plateauB2[a][k]));
		}
		this.setContentPane(main_pane);
		this.revalidate();
		
	}
	
	//Class interne pour lancer la fenetre option quand on lance une partie
	class Button_Launch_Listener implements ActionListener
	{
		//Choix des bateaux à placer
		public void actionPerformed(ActionEvent e)
		{
			for(int i=0;i<8;i++)
			{
				for(int j=0;j<8;j++)
				{
					plateauB1[i][j].setEnabled(true);
				}
			}
			choix_bateau = true;
		}
	}
		
	class Button_Quit_Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
	
	private int num_bateau;
	private int long_bateau;
	private int bateau[] = {3,4,5};
	//10 bateaux
	//exemple shéma classique 3 bateaux longueurs 3,4,5
	Vector<Integer> bateau_choisi = new Vector<>();
	//private int bateau_choisi[] = new int[12];
	class Button_Listener implements ActionListener
	{
		private Plateau p;
		private Button b;
		Button_Listener(Plateau p, Button b) 
		{
			this.p=p;
			this.b=b;
			num_bateau = 0;
			long_bateau = 0;
		}
		public void actionPerformed(ActionEvent e)
		{
			if(choix_bateau)
			{
				
				if(long_bateau<bateau[num_bateau])
				{
					//Recup le nombre de bateau et leurs longueur
					//Données dans un vecteur int bateau[]
					//p.placerBateau(b.getID());
					long_bateau++;
					bateau_choisi.add(b.getID());
					if(long_bateau==1)
					{
						desactiver_autour(b.getID());	
					}
					else
					{
						continu();
					}
									
				}
				if(long_bateau==bateau[num_bateau])
				{
					//Incremente la nouvelle valeur du bateau
					if(num_bateau!=bateau.length-1)
					{
						num_bateau++;
						long_bateau = 0;
						reinit_bateau();
					}
					else
					{
						choix_bateau = false;
						for(int i=0;i<8;i++)
						{
							for(int j=0;j<8;j++)
							{
								plateauB1[i][j].setEnabled(true);
							}
						}
						p.placer_bateau(bateau, bateau_choisi);
						button_launch.setText("Lancer la partie !");
					}
				}
			}
			else
			{
				
				p.jouer(b.getID());
			}
		}
		
		//Active les cases autorisé&e autour
		//Premier coup
		public void desactiver_autour(int a)
		{
			for(int i=0;i<8;i++)
			{
				for(int j=0;j<8;j++)
				{
					plateauB1[i][j].setEnabled(false);
				}
			}
			int k = a%8;
			int l= a-k;l/=8;
			if(k!=0)
			{
				plateauB1[l][k-1].setEnabled(true);
			}
			if(k!=7)
			{
				plateauB1[l][k+1].setEnabled(true);
			}			
			if(l!=0)
			{
				plateauB1[l-1][k].setEnabled(true);
			}			
			if(l!=7)
			{
				plateauB1[l+1][k].setEnabled(true);
			}
			desactiver_case_clique();
		}
		
		//Evite de superposé avec des bateaux déja crée
		public void desactiver_case_clique()
		{
			for(int i=0;i<bateau_choisi.size();i++)
			{
				int k = bateau_choisi.get(i)%8;
				int l = bateau_choisi.get(i) - k;l/=8;
				plateauB1[l][k].setEnabled(false);
			}
		}
		
		//Réactive toute les cases quandon change de bateau
		public void reinit_bateau()
		{
			for(int i=0;i<8;i++)
			{
				for(int j=0;j<8;j++)
				{
					plateauB1[i][j].setEnabled(true);
				}
			}
			desactiver_case_clique();
		}
		
		//Propose les cases autorisées pour positionner son bateau
		public void continu()
		{
			int a = bateau_choisi.size();
			int previous_ID = bateau_choisi.get(a-2);
			int recent_ID = b.getID();
			int k1 = previous_ID%8;
			int k2 = recent_ID%8;
			int l1 = previous_ID - k1;l1/=8;
			int l2 = recent_ID - k2;l2/=8;
			if(k1==k2) //Direction verticale
			{
				plateauB1[l2][k2].setEnabled(false);
				if(l2!=0)
				{
					if(k2!=0)
					{
						plateauB1[l2-1][k2-1].setEnabled(false);
					}
					if(k2!=7)
					{
						plateauB1[l2-1][k2+1].setEnabled(false);
					}
				}
				if(l2!=7)
				{
					if(k2!=0)
					{
						plateauB1[l2+1][k2-1].setEnabled(false);
					}
					if(k2!=7)
					{
						plateauB1[l2+1][k2+1].setEnabled(false);
					}
				}
				if(l2!=0)
				{
					plateauB1[l2-1][k2].setEnabled(true);
				}
				if(l2!=7)
				{
					plateauB1[l2+1][k2].setEnabled(true);
				}
				
				
			}
			else if(l1==l2) //Direction horizontale
			{
				plateauB1[l2][k2].setEnabled(false);
				if(l2!=0)
				{
					if(k2!=0)
					{
						plateauB1[l2-1][k2-1].setEnabled(false);
					}
					if(k2!=7)
					{
						plateauB1[l2-1][k2+1].setEnabled(false);
					}
				}
				if(l2!=7)
				{
					if(k2!=0)
					{
						plateauB1[l2+1][k2-1].setEnabled(false);
					}
					if(k2!=7)
					{
						plateauB1[l2+1][k2+1].setEnabled(false);
					}
				}
				if(k2!=0)
				{
					plateauB1[l2][k2-1].setEnabled(true);
				}
				if(k2!=7)
				{
					plateauB1[l2][k2+1].setEnabled(true);
				}
				
			}
			desactiver_case_clique();
		}
	
	}

	public void debut_de_partie()
	{
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				plateauB1[i][j].setEnabled(false);
				plateauB2[i][j].setEnabled(true);
				plateauB2[i][j].setText(" ");
				refresh(0,i,j);
			}
		}
	}
	
	public void refresh(int ID, int i, int j)
	{
		int a = 0;
		if( ID==0 )
		{
			a = matrice1.getPlateau(i, j);
		}
		else if (ID == 1)
		{
			a = matrice2.getPlateau(i, j);
		}
		switch(a)
		{
		case 0: //Case vierge
			if(ID == 0)
			{
				plateauB1[i][j].setText("  ");
			}
			else if (ID == 1)
			{
				plateauB2[i][j].setText("   ");
			}
			break;
		case 1: //Case jouée et non touchée par joueur 1
			if(ID == 0)
			{
				plateauB1[i][j].setEnabled(false);
				plateauB1[i][j].setText(" O ");
			}
			else if (ID == 1)
			{
				plateauB2[i][j].setEnabled(false);
				plateauB2[i][j].setText(" O ");
			}
			break;
		case 2: // Case jouée et touché par joueur 1
			if(ID == 0)
			{
				plateauB1[i][j].setEnabled(false);
				plateauB1[i][j].setText(" T ");
			}
			else if (ID == 1)
			{
				plateauB2[i][j].setEnabled(false);
				plateauB2[i][j].setText(" T ");
			}
			break;
		case 3: //Case jouée et touchée, le bateau dessus est coulé !
			if(ID == 0)
			{
				plateauB1[i][j].setEnabled(false);
				plateauB1[i][j].setText(" X ");
			}
			else if (ID == 1)
			{
				plateauB2[i][j].setEnabled(false);
				plateauB2[i][j].setText(" X ");
			}
			break;
		default :
			break;
		}
	}
}
