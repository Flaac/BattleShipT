package v1;

public class Main
{
	public static void main(String[] args)
	{

		MainWindow fen;
		Plateau p1 = new Plateau();
		Plateau p2 = new Plateau();
		
		fen = new MainWindow(p1,p2);
		p1.preInit(fen);
		p2.preInit(fen);
		fen.setVisible(true);
	}
}
