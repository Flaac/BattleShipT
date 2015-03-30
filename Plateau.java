package v1;

import java.util.Vector;

public class Plateau
{
private int CASES[][]; //matrice qui donne l'etat des cases '0 = mer non essayée' '1 = mer essayée' '2 = bateau non essayé' '3 = bateau essayé'
private int nbligne;
private int nbcolonne;
private Boat bateaux []; //crée le vecteur de bateaux qui stocke les bateaux
private int fin; //si 'fin=nombre de bateaux', alors tous les bateaux sont coulés
Plateau(int nbligne, int nbcolonne)
{
this.nbligne = nbligne;
this.nbcolonne = nbcolonne;
CASES = new int[nbligne][nbcolonne]; //initialisation de la matrice bateaux
bateaux = new Boat[1]; //initialisation de la matrice bateaux (13 utilisé par la suite)
Boat bateau1 = new Boat(4,1,2,3,"Titanic");
for (int i=0;i<bateau1.getSize();i++)
	{
	CASES [bateau1.get_yDebut()-1+i*(1-bateau1.getDirection())] [bateau1.get_xDebut()-1+i*(bateau1.getDirection())]=2;
	}
bateaux[0]=bateau1; //le bateau1 est un test
}

public void add_boat (Boat b) //ajoute un bateau sur le plateau erreur si deux bateaux sont au même endroit
{
System.out.println(bateaux.length);
for (int i=0;i<b.getSize();i++)
	{
	CASES [b.get_yDebut()-1+i*(1-b.getDirection())] [b.get_xDebut()-1+i*(b.getDirection())]=2; //On incrémente l'abscisse si horizontal et l'ordonnée si vertical, pour remplir la matrice BATEAUX
	}
Boat bato [];
bato = bateaux;
int l;
if (bato.length==13) //on aura jamais 13 bateaux, ça permet de voir si le vecteur est "vide" ou pas
	{l=0;}
else {l=bato.length;}

bateaux = new Boat[l+1]; //initialisation de la matrice bateaux
for(int n=0;n<l;n++)
	{
	bateaux[n]=bato[n];
	}
bateaux[l]=b;
System.out.println("Vous avez ajouté un bateau");
System.out.println(bateaux.length);
}

public void jouer(int N)
{
int j = N%nbligne; //donne le numéro de colonne
int i = N - j; i/=nbcolonne; //donne le numéro de colonne
if(CASES[i][j]==1)
{
	System.out.println(Integer.toString(CASES[i][j]));
	System.out.println("La mer reste la mer !");
}
if(CASES[i][j]==0)
{
	System.out.println(Integer.toString(CASES[i][j]));
	CASES[i][j]=1;
	System.out.println(Integer.toString(CASES[i][j]));
	System.out.println("A l'eau !");
}
if(CASES[i][j]==3)
{
	System.out.println(Integer.toString(CASES[i][j]));
	System.out.println("Un bateau a déja été touché ici !");
}
if(CASES[i][j]==2)
{
	System.out.println(Integer.toString(CASES[i][j]));
	CASES[i][j]=3;
	System.out.println(Integer.toString(CASES[i][j]));
	System.out.println("Touché !");
	for(int p=0;p<bateaux.length;p++) //but de la double-boucle : chercher quel bateau a été touché
		{
		Boat b = bateaux[p];
		int s = b.getSize();
		for (int k=0;k<s;k++)
		{
		if((b.get_yDebut()-1+k*(1-b.getDirection()))==i & (b.get_xDebut()-1+k*(b.getDirection()))==j) //testé et approuvé
			{
			String n = bateaux[p].getNom();
			System.out.println("Vous avez touché le bateau : "+n);
			bateaux[p].setEtat(k,true);
			int h=0;
			for (int f=0;f<bateaux[p].getSize();f++) //déterminer si tout les bouts du bateau sont touchés
				{
				boolean t = bateaux[p].getEtat()[f]; //l'etat 1 est l'état coulé
				if (t== true)
					{h=h+1;}
				}
			if (h==bateaux[p].getSize()) //alors le bateau est coulé
				{
				bateaux[p].setCoule();
				System.out.println("Vous avez coulé le bateau : "+n);
				fin = fin+1;
				if (fin==bateaux.length)
						{
						System.out.println("Tous les bateaux ont été coulés");
						//enchainer sur la fin su jeu
						}
				}
				System.out.println("A l'adversaire");
				}
			//passer à l'autre joueur
			}
		}
		}
	
}


public int getPlateau(int x, int y)
{
System.out.println("Essai");
return CASES[x][y];
}

/* A partir d'ici ce sont des méthodes que j'ai rajouté pour que mon code compile mais qui seront enlevées
par la suite quand tu auras fini de tout coder 
Normalement elle ne rentre pas en conflit avec ce que tu as fait
Si jamais c'était le cas, met mes fonctions en commentaire
---Flac---
*/
/*
static private int compteur=0; //Variable qui compte le nombre de plateau créé en tout
private int ID;			//Identité du plateau
	
Plateau()
{
	ID = compteur;
	compteur++;
}
	public void init(int ligne, int colonne)
	{
		this.ligne = ligne;
		this.colonne = colonne;
		matrice = new int[ligne][colonne];
		for(int i=0;i<ligne;i++)
		{
			for(int j=0;j<colonne;j++)
			{
				matrice[i][j] = 0;
			}		
		}
	}
	
	public void preInit(MainWindow fen)
	{
		this.fen = fen;
	}
	
	public void placer_bateau(int[] taille_bateau, Vector<Integer> case_occupees)
	{
		int l = case_occupees.size();
		for(int i=0;i<l;i++)
		{
			int j = case_occupees.get(i)%8;
			int k = case_occupees.get(i) - j;k/=8;
			matrice[k][j]=2;
			fen.refresh(ID,k,j);
		}
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				fen.debut_de_partie();
			}
		}
		
	}
	
	/*
	public void jouer(int N)
	{
		int j = N%ligne;
		int i = N - j; i/=colonne;
		if(matrice[i][j]==0)
		{
			matrice[i][j]=1;
		}
		fen.refresh(ID,i,j);
	}
	*/
}
