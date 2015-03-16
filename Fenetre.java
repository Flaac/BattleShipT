package v1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Fenetre implements ActionListener
{
	private Plateau p;
	private Button b;

	Fenetre(Plateau p, Button b) {this.p=p;this.b=b; }
	Fenetre(){}
	public void actionPerformed(ActionEvent e)
	{
		p.jouer(b.getID());
	}

}
