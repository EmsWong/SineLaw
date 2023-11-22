import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;


public class graphics implements ActionListener, KeyListener, MouseListener, MouseMotionListener{
	//Properties
	JFrame theFrame = new JFrame("Sine Law");
	JPanel thePanel = new JPanel();
	Timer theTimer = new Timer(960/20, this);
	JMenuBar theBar = new JMenuBar();
	JMenu mainMenu = new JMenu("Menu");
	JMenu options = new JMenu("Options");
	JMenuItem help = new JMenuItem("Help");
	JMenuItem about = new JMenuItem("About");
	JMenuItem twoangle = new JMenuItem("Given 2 angles and a side");
	JMenuItem twoside = new JMenuItem("Given 2 sides and an angle");

	//Methods

	public void mouseMoved(MouseEvent e){

	}

	public void mouseDragged(MouseEvent e){

	}

	public void mouseExited(MouseEvent e){
        
    }

    public void mouseEntered(MouseEvent e){
        
    }

    public void mouseReleased(MouseEvent e){

    }

    public void mousePressed(MouseEvent e){

    }

    public void mouseClicked(MouseEvent e){
        	
    }       

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == theTimer){
			thePanel.repaint();
		}
		if(e.getSource() == help){
			System.out.println("help");
		}
	}

	public void keyReleased(KeyEvent e){
		
	}

	public void keyPressed(KeyEvent e){
		
	}

	public void keyTyped(KeyEvent e){

	}

	//Constructor
	public graphics(){
		thePanel.setPreferredSize(new Dimension(960,540));
		thePanel.addMouseListener(this);
		thePanel.addMouseMotionListener(this);
		
		theBar.add(mainMenu);
		theBar.add(options);

		mainMenu.add(help);
		mainMenu.add(about);
		help.addActionListener(this);
		about.addActionListener(this);

		options.add(twoangle);
		options.add(twoside);
		twoangle.addActionListener(this);
		twoside.addActionListener(this);

		theFrame.setJMenuBar(theBar);
		theFrame.addKeyListener(this);
		theFrame.setContentPane(thePanel);
		theFrame.pack();
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setVisible(true);
		theFrame.setResizable(false);
		theTimer.start();
	}

	//Main Method
	public static void main(String[] args){
		new graphics();
	}
}
