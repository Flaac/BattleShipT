package v1;

import java.awt.Dimension;

import javax.swing.*;

public class Button extends JButton 
{
	private int ID;
	Button(int ID)
	{
		super(Integer.toString(ID));
		this.setPreferredSize(new Dimension(20,20));
		this.ID = ID;
	}
	Button(int ID, int size)
	{
		super(Integer.toString(ID));
		this.setPreferredSize(new Dimension(size,size));
		this.ID = ID;
	}
	
	public int getID()
	{
		return ID;
	}
	

}
