import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.awt.image.*;
import java.io.*;


public class graphics implements ActionListener, ChangeListener{
	//Properties
	JFrame theFrame = new JFrame("Sine Law");
	newpanel1 thehelp = new newpanel1();
	newpanel2 theabout = new newpanel2();
	panel anglePanel = new panel();
	panel sidePanel = new panel();
	Timer theTimer = new Timer(1000/48, this);
	JMenuBar theBar = new JMenuBar();
	JMenu mainMenu = new JMenu("Menu");
	JMenu options = new JMenu("Options");
	BufferedImage equ = null;
	JMenuItem help = new JMenuItem("Help");
	JMenuItem about = new JMenuItem("About");
	JMenuItem twoangle = new JMenuItem("Given 2 angles and a side");
	JMenuItem twoside = new JMenuItem("Given 2 sides and an angle");
	Font text = null;

	// sliders for angle angle side
	JSlider val1 = new JSlider(0, 1, 180, 25);
	JSlider val2 = new JSlider(0, 1, 180, 25);
	JSlider val3 = new JSlider(0, 1, 180, 25);

	// sliders for side side angle
	JSlider value1 = new JSlider(0, 1, 180, 25);
	JSlider value2 = new JSlider(0, 1, 180, 25);
	JSlider value3 = new JSlider(0, 1, 180, 25);

	// labels and buttons for angle angle side
	JLabel angleA = new JLabel ("Angle A: ");
	JLabel angleB = new JLabel ("Angle B: ");
	JLabel sideB = new JLabel ("Side B: ");
	JLabel enter = new JLabel ("Enter 3 Values:");
	JLabel outputSide = new JLabel ("Side A is: ");
	JButton calculate = new JButton("Calculate");

	// labels and buttons for side side angle
	JLabel sideAA = new JLabel ("Side A: ");
	JLabel sideBB = new JLabel ("Side B: ");
	JLabel angleBB = new JLabel("Angle B: ");
	JLabel enters = new JLabel ("Enter 3 Values:");
	JLabel outputAngle = new JLabel ("Angle A is: ");
	JButton calculates = new JButton("Calculate");
	
	// Methods
	public void stateChanged(ChangeEvent e){
		if (e.getSource() == val1){
			int intA;
			int intB;
			int intC;
			int intb;
			int intc;
			intA = val1.getValue();
			intB = val2.getValue();
			intC = 180 - intA - intB;
			intb = val3.getValue();
			angleA.setText("Angle A:  "+intA);
			double dblA = Math.toRadians(intA);
			
			// using a method in tools to find the length of c
			intc = (int)Math.round(tools.sidecalc(intC, intB, intb));
			
			// checks if triangle can be formed
			if(intc < 0){
				// triangle cannot be formed
				sidePanel.drawable = false;
				sidePanel.repaint();
			}else{
				// triangle can be formed
				// setting new end coordinates of side A
				sidePanel.bx = sidePanel.ax + (int)Math.round(intc*Math.cos(dblA));
				sidePanel.by = sidePanel.ay - (int)Math.round(intc*Math.sin(dblA));
				sidePanel.drawable = true;
				sidePanel.repaint();
			}
		}
		if(e.getSource() == val3){
			int intA;
			int intB;
			int intC;
			int intb;
			int intc;
			intb = val3.getValue();
			intB = val2.getValue();
			intA = val1.getValue();
			intC = 180 - intA - intB;
			double dblA = Math.toRadians(intA);

			// using a method in tools to find length of c
			intc = (int)Math.round(tools.sidecalc(intC, intB, intb));

			// checks if a triangle can be formed
			if(intc < 0){
				// triangle cannot be formed
				sidePanel.drawable = false;
				sidePanel.repaint();
			}else{
				// triangle can be formed
				// setting new end coordinates of side A
				sidePanel.bx = sidePanel.ax + (int)Math.round(intc*Math.cos(dblA));
				sidePanel.by = sidePanel.ay - (int)Math.round(intc*Math.sin(dblA));
				sidePanel.drawable = true;
				sidePanel.repaint();
			}
			sideB.setText("Side B:  "+intb);
			sidePanel.cx = sidePanel.ax + intb;
			sidePanel.repaint();
		}
		if(e.getSource() == val2){
			int intA;
			int intB;
			int intC;
			int intb;
			int intc;
			intB = val2.getValue();
			intb = val3.getValue();
			intA = val1.getValue();
			intC = 180 - intA - intB;
			double dblA = Math.toRadians(intA);

			// using a method in tools to find length of c
			intc = (int)Math.round(tools.sidecalc(intC, intB, intb));

			// checks if a triangle can be formed
			if(intc < 0){
				// triangle cannot be formed
				sidePanel.drawable = false;
				sidePanel.repaint();
			}else{
				// triangle can be formed
				// setting new end coordinates of side A
				sidePanel.bx = sidePanel.ax + (int)Math.round(intc*Math.cos(dblA));
				sidePanel.by = sidePanel.ay - (int)Math.round(intc*Math.sin(dblA));
				sidePanel.drawable = true;
				sidePanel.repaint();
			}
			angleB.setText("Angle B:  "+intB);
			sidePanel.repaint();
		}
		if(e.getSource() == value1){
			int inta;
			int intb;
			int intB;
			int intA;
			inta = value1.getValue();
			intb = value2.getValue();
			intB = value3.getValue();

			// using a method in tools to find angle of A
			intA = (int)tools.anglecalc(inta, intb, intB);

			// checks if a triangle can be formed
			if ((intA + intB) > 180 || intA == 0){
				// triangle cannot be formed
				anglePanel.repaint();
				anglePanel.drawable = false;
				
			}else{
				// triangle can be formed
				// setting new end coordinates of side c

				// finds supplementary angle of angle C
				int intTemp = intB + intA;
				double dblTemp = Math.toRadians(intTemp);
				
				// setting new end coordinates of side A
				anglePanel.bx = anglePanel.cx + (int)Math.round(inta * Math.cos(dblTemp));
				anglePanel.by = anglePanel.cy - (int)Math.round(inta * Math.sin(dblTemp));
				anglePanel.drawable = true;
				anglePanel.repaint();
			}
			sideAA.setText("Side A:  "+inta);
		}
		if(e.getSource() == value2){
			int intb;
			int inta;
			int intB;
			int intA;
			intb = value2.getValue();
			inta = value1.getValue();
			intB = value3.getValue();

			// using a method in tools to find angle of A
			intA = (int)tools.anglecalc(inta, intb, intB);

			// checks if a triangle can be formed
			if ((intA + intB) > 180 || intA == 0){
				// triangle cannot be formed
				anglePanel.repaint();
				anglePanel.drawable = false;
			}else{
				// triangle can be formed
				// setting new end coordinates of side c

				// finds supplementary angle of angle C
				int intTemp = intB + intA;
				double dblTemp = Math.toRadians(intTemp);

				// setting new end and starting coordinates of side A
				anglePanel.cx = anglePanel.ax + intb;
				anglePanel.bx = anglePanel.cx + (int)Math.round(inta * Math.cos(dblTemp));
				anglePanel.by = anglePanel.cy - (int)Math.round(inta * Math.sin(dblTemp));
				anglePanel.drawable = true;
				anglePanel.repaint();
			}
			sideBB.setText("Side B:  "+intb);
		}
		if(e.getSource() == value3){
			int intB;
			int inta;
			int intb;
			int intA;
			intB = value3.getValue();
			inta = value1.getValue();
			intb = value2.getValue();

			// using a method in tools to find angle of A
			intA = (int)tools.anglecalc(inta, intb, intB);

			// checks if a triangle can be formed
			if ((intA + intB) > 180 || intA == 0){
				// triangle cannot be formed
				anglePanel.repaint();
				anglePanel.drawable = false;
			}else{
				// triangle can be formed
				// setting new end coordinates of side c

				// finds supplementary angle of angle C
				int temp = intB + intA;
				double dbltemp = Math.toRadians(temp);

				// setting new end coordinates of side A
				anglePanel.bx = anglePanel.cx + (int)Math.round(inta * Math.cos(dbltemp));
				anglePanel.by = anglePanel.cy - (int)Math.round(inta * Math.sin(dbltemp));
				anglePanel.drawable = true;
				anglePanel.repaint();
			}
			angleBB.setText("Angle B:  "+intB);
		}
		
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == theTimer){
		
		}
		if(e.getSource() == help){
			// help option was pressed
			System.out.println("help");
			theFrame.setContentPane(thehelp);
			theFrame.pack();
			theFrame.repaint();
		}
		if(e.getSource() == about){
			// about option was pressed
			System.out.println("about");
			theFrame.setContentPane(theabout);
			theFrame.pack();
			theFrame.repaint();
		}
		if(e.getSource() == twoside){
			// given two sides one angle option was pressed
			System.out.println("given two sides and angle");
			theFrame.setContentPane(anglePanel);
			theFrame.pack();
			theFrame.repaint();
		}
		if(e.getSource() == twoangle){
			// given two angles one side option was pressed
			System.out.println("given two angle and side");
			theFrame.setContentPane(sidePanel);
			theFrame.pack();
			theFrame.repaint();
		}
		if(e.getSource() == calculate){
			// calculate button on the sidePanel was pressed
			int intval1;
			int intval2;
			int intval3;
			double dblresult;
			intval1 = val1.getValue();
			intval2 = val2.getValue();
			intval3 = val3.getValue();

			// using a method in tools to find length of side A
			dblresult = tools.sidecalc(intval1, intval2, intval3);

			// checks if a triangle can be formed
			if(dblresult == 0.0){
				// triangle cannot be formed
				outputSide.setText("Not a triangle");
			}else{
				// triangle can be formed
				outputSide.setText("Side A is: "+dblresult);
			}
		}
		if(e.getSource() == calculates){
			// calculate button on anglePanel was pressed
			int intvalue1;
			int intvalue2;
			int intvalue3;
			double dblresult;
			intvalue1 = value1.getValue();
			intvalue2 = value2.getValue();
			intvalue3 = value3.getValue();

			// using a method in tools to find length of side A
			dblresult = tools.anglecalc(intvalue1, intvalue2, intvalue3);

			// checks if a triangle can be formed
			if(dblresult == 0.0 || (dblresult + intvalue3) > 180){
				// triangle cannot be formed
				outputAngle.setText("Not a triangle");
			}else{
				// triangle can be formed
				outputAngle.setText("Angle A is: "+dblresult);
			}
		}
	}


	//Constructor
	public graphics(){
		text = new Font("arial", Font.BOLD, 20);
		// Menu constructors
		sidePanel.setLayout(null);
		sidePanel.setPreferredSize(new Dimension(960,540));

		anglePanel.setLayout(null);
		anglePanel.setPreferredSize(new Dimension(960, 540));

		thehelp.setLayout(null);
		thehelp.setPreferredSize(new Dimension(960, 540));

		theabout.setLayout(null);
		theabout.setPreferredSize(new Dimension(960, 540));

		// angle angle side constructors
		val1.setSize(350, 20);
		val1.setLocation(570, 300);
		val1.setVisible(true);
		val1.addChangeListener(this);
		
		angleA.setText("Angle A:  "+25);
		angleA.setSize(125,30);
		angleA.setLocation(435, 295);
		angleA.setVisible(true);
		angleA.setFont(text);
		
		val2.setSize(345, 20);
		val2.setLocation(570, 365);
		val2.setVisible(true);
		val2.addChangeListener(this);

		angleB.setText("Angle B:  "+25);
		angleB.setSize(125,30);
		angleB.setLocation(435, 360);
		angleB.setVisible(true);
		angleB.setFont(text);

		val3.setSize(345, 20);
		val3.setLocation(570, 430);
		val3.setVisible(true);
		val3.addChangeListener(this);

		sideB.setText("Side B:  "+25);
		sideB.setSize(125,30);
		sideB.setLocation(435, 425);
		sideB.setVisible(true);
		sideB.setFont(text);

		calculate.setFont(text);
		calculate.setSize(150, 40);
		calculate.setLocation(570, 475);
		calculate.setBackground(Color.GREEN);
		calculate.addActionListener(this);

		enter.setFont(text);
		enter.setSize(200, 40);
		enter.setLocation(670, 240);

		outputSide.setFont (text);
		outputSide.setSize(200, 40);
		outputSide.setLocation(750, 475);

		sidePanel.add(val1);
		sidePanel.add(angleA);
		sidePanel.add(val2);
		sidePanel.add(angleB);
		sidePanel.add(val3);
		sidePanel.add(sideB);
		sidePanel.add(calculate);
		sidePanel.add(enter);
		sidePanel.add(outputSide);


		// side side angle constructors
		value1.setSize(350, 20);
		value1.setLocation(570, 300);
		value1.setVisible(true);
		value1.addChangeListener(this);

		sideAA.setText("Side A:  "+25);
		sideAA.setSize(125,30);
		sideAA.setLocation(435, 295);
		sideAA.setVisible(true);
		sideAA.setFont(text);

		value2.setSize(345, 20);
		value2.setLocation(570, 365);
		value2.setVisible(true);
		value2.addChangeListener(this);

		sideBB.setText("Side B:  "+25);
		sideBB.setSize(125,30);
		sideBB.setLocation(435, 360);
		sideBB.setVisible(true);
		sideBB.setFont(text);

		value3.setSize(345, 20);
		value3.setLocation(570, 430);
		value3.setVisible(true);
		value3.addChangeListener(this);

		angleBB.setText("Angle B:  "+25);
		angleBB.setSize(125,30);
		angleBB.setLocation(435, 425);
		angleBB.setVisible(true);
		angleBB.setFont(text);

		calculates.setFont(text);
		calculates.setSize(150, 40);
		calculates.setLocation(570, 475);
		calculates.setBackground(Color.GREEN);
		calculates.addActionListener(this);

		enters.setFont(text);
		enters.setSize(200, 40);
		enters.setLocation(670, 240);

		outputAngle.setFont(text);
		outputAngle.setSize(200, 40);
		outputAngle.setLocation(750, 475);
		
		anglePanel.add(value1);
		anglePanel.add(sideAA);
		anglePanel.add(value2);
		anglePanel.add(sideBB);
		anglePanel.add(value3);
		anglePanel.add(angleBB);
		anglePanel.add(calculates);
		anglePanel.add(enters);
		anglePanel.add(outputAngle);
		
		// more menu constructors
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

		// frame constructors
		theFrame.setJMenuBar(theBar);
		theFrame.setContentPane(sidePanel);
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
