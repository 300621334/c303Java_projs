package c303Assign1;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.*;
/*Group#3 members:
Shafiq-Ur-Rehman
Sahil Mahajan
Atul Sharma
Nirojan Jeyandhran
*/

public class _3CoinFliperGUIDriver extends JFrame 
{
	//constructor
	public _3CoinFliperGUIDriver()
	{
		super("Count Coin Flips using JLabels");
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridLayout(5, 1));
		
		//Arrange 5 threads
		ExecutorService tasks = Executors.newFixedThreadPool(5);
		
		//create 5 labels & place them inside JFrame
		for (int i = 0; i < 5; i++) 
		{
			JLabel label = new JLabel("Label" + i);//Label1, Label2 etc
			label.setFont(new Font("SansSerif", Font.PLAIN, 30));
			
			//Pass label to coin-flipper class
			tasks.execute(new _3CoinFliperGUI(label, i+1));
			
			//Place label in JFrame
			contentPane.add(label);
		}
		setSize(400,  400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		new _3CoinFliperGUIDriver();
	}
}
