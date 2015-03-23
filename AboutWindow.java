package v1;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class AboutWindow extends JFrame
{
	AboutWindow()
	{
		this.setTitle("A propos");
		this.setSize(800, 500);
		JPanel about_pane = (JPanel)this.getContentPane();
		JTextPane textarea = new JTextPane();
		about_pane.setLayout(new BorderLayout());
		about_pane.add(textarea);
		textarea.setContentType("text/html");
		textarea.setEditable(false);
		textarea.setText("<html> <h1> Titre </h1> <p> Cette application a été réalisée par : </p> </html>");
	}
}
