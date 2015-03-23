package v1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionWindow extends JPanel 
{
	private MainWindow fen;
	
	OptionWindow(MainWindow fen)
	{
		this.fen = fen;
		JButton button_option = new JButton("Chargement...");
		BorderLayout main_layout = new BorderLayout();
		fen.setLayout(main_layout);
		fen.add(button_option);
		button_option.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				fen.init();
			}
		});
	}
}
