import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;


public class graphics implements ActionListener, KeyListener, MouseListener, MouseMotionListener{
	//Properties
	JFrame theFrame = new JFrame("graphics!!");
	newpanel thePanel = new newpanel();
	Timer theTimer = new Timer(1000/30, this);
	int intXDef = 0;
	int intYDef = 0;

	//Methods
	public void mouseMoved(MouseEvent e){
		thePanel.intHomerX = e.getX();
                thePanel.intHomerY = e.getY();
	}

	public void mouseDragged(MouseEvent e){

	}//thePanel.intHomerX = e.getX();
                //thePanel.intHomerY = e.getY();

	public void mouseExited(MouseEvent e){
        
        }

        public void mouseEntered(MouseEvent e){
        
        }

        public void mouseReleased(MouseEvent e){

        }

        public void mousePressed(MouseEvent e){

        }

        public void mouseClicked(MouseEvent e){
        	//thePanel.intHomerX = e.getX();
		//thePanel.intHomerY = e.getY();
        }       

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == theTimer){
			thePanel.intRectY = thePanel.intRectY + intYDef;
			thePanel.intRectX = thePanel.intRectX + intXDef;
			thePanel.repaint();
		}
	}

	public void keyReleased(KeyEvent evt){
		if(evt.getKeyChar() == 'w'){
                        intYDef = 0;
                }
                if(evt.getKeyChar() == 's'){
                        intYDef = 0;
                 }
                if(evt.getKeyChar() == 'a'){
                        intXDef = 0;
                }
                if(evt.getKeyChar() == 'd'){
                        intXDef = 0;
                }
	}

	public void keyPressed(KeyEvent evt){
		//System.out.println("Key was pressed");
		if(evt.getKeyChar() == 'w'){
			intYDef = -7;
                }
		if(evt.getKeyChar() == 's'){
               		intYDef = 7;
		 }
		if(evt.getKeyChar() == 'a'){
			intXDef = -5;
                }
		if(evt.getKeyChar() == 'd'){
			intXDef = 5;
                }
	}

	public void keyTyped(KeyEvent evt){

	}

	//Constructor
	public graphics(){
		thePanel.setPreferredSize(new Dimension(600,600));
		thePanel.addMouseListener(this);
		thePanel.addMouseMotionListener(this);
		theFrame.addKeyListener(this);
		theFrame.setContentPane(thePanel);
		theFrame.pack();
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setVisible(true);
		theTimer.start();
	}

	//Main Method
	public static void main(String[] args){
		new graphics();
	}
}
