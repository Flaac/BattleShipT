package v1;

public class Boat 
{
	private int size;
	private int debut_X, debut_Y;
	private int fin_X, fin_Y;
	private boolean etat[];
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
