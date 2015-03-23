package v1;

public class Boat
{
private int size; //cette ligne crée l'attribut taille
private int debut_X, debut_Y; //case de début
private int direction; //donne la direction du bateau 'horizontal = 1' 'vertical=0' erreur si direction différent de 0 ou 1
private boolean etat[]; //vecteur qui donne l'etat des cases du bateau bateau 0=neuf 1=touché
private boolean coule; //0=neuf 1=coulé
private String nom;

Boat(int size, int direction, int debut_X, int debut_Y, String nom)
{
	this.size = size;
	this.nom = nom;
	this.direction = direction;
	this.debut_X = debut_X;
	this.debut_Y = debut_Y;
	etat = new boolean[size];
	for(int i=0;i<size;i++)
	{
		etat[i] = true;
	}
}
public int getSize()
{
	return size;
}
public String getNom()
{
	return nom;
}
public int getDirection()
{
	return direction;
}

public int get_xDebut()
{
	return debut_X;
}
public int get_yDebut()
{
	return debut_Y;
}
public boolean getCoule()
{
	return coule;
}
public boolean[] getEtat()
{
	return etat;
}
void setCoule(boolean i)
{
	coule=i;
}
void setEtat(int j, boolean i)
{
	etat[j]=i;
}
}
