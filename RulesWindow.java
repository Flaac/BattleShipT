package v1;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class RulesWindow extends JFrame 
{
	RulesWindow()
	{
		this.setTitle("Règles du jeu");
		this.setSize(800, 500);
		JPanel rule_pane = (JPanel)this.getContentPane();
		JTextPane textarea = new JTextPane();
		rule_pane.setLayout(new BorderLayout());
		rule_pane.add(textarea);
		textarea.setContentType("text/html");
		textarea.setEditable(false);
		textarea.setText("<html> Coucou les règles du <strong>jeu</strong> sont : </html>");	
	}
}
