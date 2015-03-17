package v1;
public class Plateau
{
  private int ESSAIS[][]; //matrice qui donne les cases essayées '1=essayé'
  private int BATEAUX[][]; //matrice qui stocke la localisation des bateaux '1=bout de bateau'
  private int MER [][]; //matrice qui donne les emplacements de la mer -> si vide me jeu est fini et si touché la case redevient de la mer
  private int nbligne;
  private int nbcolonne;
  private Boat bateau1; //ajoute un bateau dans le plateau (est ce qu'on le met la ou on les ajoute après avoir créé le plateau avec add bateau?)
  Plateau(int nbligne, int nbcolonne)
  {
    this.nbligne = nbligne;
    this.nbcolonne = nbcolonne;
    ESSAIS = new int[nbligne][nbcolonne]; //initialisation de la matrice ESSAIS
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
  {
    BATEAUX [bateau1.get_xDebut()+i*bateau1.getDirection()] [bateau1.get_yDebut()+i*(1-bateau1.getDirection())]=1;
    //On incrémente l'abscisse si horizontal et l'ordonnée si vertical, pour remplir la matrice
  } 
    MER = new int[nbligne][nbcolonne]; //initialisation de la matrice MER
    for(int i=0;i<nbligne;i++)
    {
      for(int j=0;j<nbcolonne;j++)
      {
        MER[i][j] = 0;
      }
    }
}
public void add_boat (Boat b) //ajoute un bateau sur le plateau erreur si deux bateaux sont au même endroit
{
for (int i=0;i<b.getSize();i++)
{BATEAUX [b.get_xDebut()+i*b.getDirection()] [b.get_yDebut()+i*(1-b.getDirection())]=1; //On incrémente l'abscisse si horizontal et l'ordonnée si vertical, pour remplir la matrice BATEAUX
 MER [b.get_xDebut()+i*b.getDirection()] [b.get_yDebut()+i*(1-b.getDirection())]=1; //On incrémente l'abscisse si horizontal et l'ordonnée si vertical, pour remplir la matrice MER
}
}
public void jouer(int N)
{
int j = N%nbligne;
int i = N - j; i/=nbcolonne;
if(ESSAIS[i][j]==0)
{
System.out.println(Integer.toString(ESSAIS[i][j]));
ESSAIS[i][j]=1;
System.out.println(Integer.toString(ESSAIS[i][j]));
System.out.println("Ca change !");
}
if(MER[i][j]==1) //si il y a quelque chose sur la mer
{
System.out.println("Touché");
System.out.println(Integer.toString(MER[i][j]));
MER[i][j]=0; //on l'enlève
System.out.println(Integer.toString(MER[i][j]));
//il faut pouvoir remonter au bateau et vérifier si il est encore la -> touché ou coulé (par le nom)

}
}
public int getPlateau(int x, int y)
{
System.out.println("Essai");
return ESSAIS[x][y];
}
}
