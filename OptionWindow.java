package v1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionWindow extends JPanel 
{
	private JComboBox<String> bateaux =new JComboBox<String>();
	private JTextField plateau= new JTextField();
	private JLabel label1=new JLabel("Nombre de bateaux");
	private JLabel label2=new JLabel("Taille du plateau (entier entre 5 et 10)");
	
	OptionWindow(MainWindow fen)
	{
		super();
		fen.setTitle("Option de jeu");
		fen.setSize(200,40);
		bateaux.addItem("2");
		bateaux.addItem("3");
		bateaux.addItem("4");
		this.add(label1);
		this.add(bateaux);
		this.add(label2);
		this.add(plateau);
		GridLayout h=new GridLayout(2,3);
		this.setLayout(h);
		
		JButton button_option = new JButton("Chargement...");
		/*BorderLayout main_layout = new BorderLayout();
		this.setLayout(main_layout);*/
		this.add(button_option);
		button_option.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				fen.init();
			}
		});
		fen.setContentPane(this);
	}
}
