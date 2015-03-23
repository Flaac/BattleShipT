package v1;

public class Plateau
{
//private int ESSAIS[][]; //matrice qui donne les cases essayées '1=essayé'
//private int BATEAUX[][]; //matrice qui stocke la localisation des bateaux '1=bout de bateau'
//private int MER [][]; //matrice qui donne les emplacements de la mer -> si vide me jeu est fini et si touché la case redevient de la mer
private int CASES[][]; //matrice qui donne l'etat des cases '0 = mer non essayée' '1 = mer essayée' '2 = bateau non essayé' '3 = bateau essayé'
private int nbligne;
private int nbcolonne;
private Boat bateaux []; //crée le vecteur de bateaux qui stocke les bateaux
Plateau(int nbligne, int nbcolonne)
{
this.nbligne = nbligne;
this.nbcolonne = nbcolonne;
CASES = new int[nbligne][nbcolonne]; //initialisation de la matrice bateaux
bateaux = new Boat[13]; //initialisation de la matrice bateaux (13 utilisé par la suite)
Boat bateau1 = new Boat(4,1,2,2,"Titanic");
for (int i=0;i<bateau1.getSize();i++)
	{
	CASES [bateau1.get_xDebut()+i*bateau1.getDirection()] [bateau1.get_yDebut()+i*(1-bateau1.getDirection())]=2;
	}

/*for(int i=0;i<nbligne;i++)
{
	for(int j=0;j<nbcolonne;j++)
	{
		CASES[i][j] = 0;
		for(int m=0;m<bateaux.length;m++)
		{
		CASES [bateaux[m].get_xDebut()+i*bateaux[m].getDirection()] [bateaux[m].get_yDebut()+i*(1-bateaux[m].getDirection())]=2;
		}
	}
}*/

/*ESSAIS = new int[nbligne][nbcolonne]; //initialisation de la matrice ESSAIS
for(int i=0;i<nbligne;i++)
{
for(int j=0;j<nbcolonne;j++)
{
ESSAIS[i][j] = 0;
}
}
BATEAUX = new int[nbligne][nbcolonne]; //initialisation de la matrice bateaux
for(int i=0;i<nbligne;i++)
{
for(int j=0;j<nbcolonne;j++)
{
BATEAUX[i][j] = 0;
}
}
Boat bateau1 = new Boat(4,1,2,2,"Titanic");
for (int i=0;i<bateau1.getSize();i++)
{BATEAUX [bateau1.get_xDebut()+i*bateau1.getDirection()] [bateau1.get_yDebut()+i*(1-bateau1.getDirection())]=1;} //On incrémente l'abscisse si horizontal et l'ordonnée si vertical, pour remplir la matrice
MER = new int[nbligne][nbcolonne]; //initialisation de la matrice MER
for(int i=0;i<nbligne;i++)
{
for(int j=0;j<nbcolonne;j++)
{
MER[i][j] = 0;
}
}*/
}

public void add_boat (Boat b) //ajoute un bateau sur le plateau erreur si deux bateaux sont au même endroit
{
for (int i=0;i<b.getSize();i++)
	{
	CASES [b.get_xDebut()+i*b.getDirection()] [b.get_yDebut()+i*(1-b.getDirection())]=2; //On incrémente l'abscisse si horizontal et l'ordonnée si vertical, pour remplir la matrice BATEAUX
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
	bateaux[l]=b;
	}
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
	for(int p=0;p>bateaux.length;p++) //but de la double-boucle : chercher quel bateau a été touché
		{
		for (int k=0;k<bateaux[p].getSize();k++)
		{
		if(((bateaux[p].get_xDebut()+k*bateaux[p].getDirection())*j+(bateaux[p].get_yDebut()+k*(1-bateaux[p].getDirection()))*i)==N)
			{
			String n = bateaux[p].getNom();
			System.out.println("Vous avez touché le bateau : "+n);
			bateaux[p].setEtat(k,true);
			int h=0;
			for (int f=0;f<bateaux[p].getSize();f++) //déterminer si tout les bouts du bateau sont touchés
				{
				boolean test[];
				test = new boolean[bateaux[p].getSize()];
				boolean t = bateaux[p].getEtat()[f];
				//h=h+t; //on peut considérer que true = 1?
				}
			if (h==bateaux[p].getSize())
				{}
			//arrêter la boucle
			}
		}
		}
	
}

/*if(MER[i][j]==1) //si il y a quelque chose sur la mer
{
System.out.println("Touché");
System.out.println(Integer.toString(MER[i][j]));
MER[i][j]=0; //on l'enlève
System.out.println(Integer.toString(MER[i][j]));
//il faut pouvoir remonter au bateau et vérifier si il est encore la -> touché ou coulé (par le nom)

}*/
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
