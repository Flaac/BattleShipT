package v1;

public class Plateau 
{
	private int matrice[][];
	private int ligne;
	private int colonne;
	
	Plateau(int ligne, int colonne)
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
	
	public void jouer(int N)
	{
		int j = N%ligne;
		int i = N - j; i/=colonne;
		if(matrice[i][j]==0)
		{
			System.out.println(Integer.toString(matrice[i][j]));
			matrice[i][j]=1;
			System.out.println(Integer.toString(matrice[i][j]));
			System.out.println("Ca change !");
		}
	}
	
	public int getPlateau(int x, int y)
	{
		return matrice[x][y];
	}
}
