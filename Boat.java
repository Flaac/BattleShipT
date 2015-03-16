package v1;

public class Boat 
{
	private int size; //cette ligne crée l'attribut taille
	private int debut_X, debut_Y; //case de début
	private int fin_X, fin_Y; //case de fin
	private boolean etat[]; //vecteur qui donne l'etat du bateau 1=neuf 0=touché
	Boat(int size, int debut_X, int debut_Y, int fin_X, int fin_Y)
	{
		this.size = size;
		this.debut_X = debut_X;
		this.debut_Y = debut_Y;
		this.fin_X = fin_X;
		this.fin_Y = fin_Y;
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
	
	
}
