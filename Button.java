package v1;

import java.awt.Dimension;

import javax.swing.*;

public class Button extends JButton 
{
	private int ID;
	private Plateau p;
	Button(Plateau p, int ID)
	{
		super(Integer.toString(ID));
		this.setPreferredSize(new Dimension(20,20));
		this.ID = ID;
		this.p = p;
	}
	Button(Plateau p, int ID, int size)
	{
		super(Integer.toString(ID));
		this.setPreferredSize(new Dimension(size,size));
		this.ID = ID;
		this.p = p;
	}
	
	public int getID()
	{
		return ID;
	}
	

}
