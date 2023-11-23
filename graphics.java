import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.awt.image.*;
import java.io.*;


public class graphics implements ActionListener, KeyListener, MouseListener, MouseMotionListener{
	//Properties
	JFrame theFrame = new JFrame("Sine Law");
	panel thePanel = new panel();
	Timer theTimer = new Timer(1000/48, this);
	JMenuBar theBar = new JMenuBar();
	JMenu mainMenu = new JMenu("Menu");
	JMenu options = new JMenu("Options");
	BufferedImage equ = null;
	JMenuItem help = new JMenuItem("Help");
	JMenuItem about = new JMenuItem("About");
	JMenuItem twoangle = new JMenuItem("Given 2 angles and a side");
	JMenuItem twoside = new JMenuItem("Given 2 sides and an angle");
	JSlider val1 = new JSlider(0, 1, 180, 1);
	JSlider val2 = new JSlider(0, 1, 180, 1);
	JSlider val3 = new JSlider(0, 1, 180, 1);
	JLabel angleA = new JLabel ("Angle A: 180");
	JLabel angleB = new JLabel ("Angle B");
	JLabel sideA = new JLabel ("Side A");
	JLabel sideB = new JLabel ("Side B");
	Font text = tools.loadFont("CabinSketch-Bold.ttf", 50);
	private TextArea theArea;
	
	//Methods
	public void setTextFont(Font theFont){
		this.theArea.setFont(theFont); 
	  }
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
			int intval1;
			int intval2;
			int intval3;
			intval1 = val1.getValue();
			intval2 = val2.getValue();
			intval3 = val3.getValue();
			System.out.println(""+intval1+intval2+intval3);
			thePanel.repaint();
		}
		if(e.getSource() == help){
			System.out.println("help");
		}
		if(e.getSource() == about){
			System.out.println("about");		
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
		thePanel.setLayout(null);
		thePanel.setPreferredSize(new Dimension(960,540));
		thePanel.addMouseListener(this);
		thePanel.addMouseMotionListener(this);

		val1.setSize(345, 20);
		val1.setLocation(570, 300);
		val1.setVisible(true);
		angleA.setSize(115,20);
		angleA.setLocation(490, 299);
		angleA.setVisible(true);
		angleA.setFont(text);
		thePanel.add(val1);
		thePanel.add(angleA);

		val2.setSize(345, 20);
		val2.setLocation(570, 365);
		val2.setVisible(true);
		thePanel.add(val2);

		val3.setSize(345, 20);
		val3.setLocation(570, 430);
		val3.setVisible(true);
		thePanel.add(val3);
		
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
