import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

	JTextField countText;

	JLabel counterLabel;

	JButton countButton;
	JButton resetButton; 

	// create the count variable
  int count = 0;

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Counter Program");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
		//initialize the main Jpanel
	  mainPanel = new JPanel();
	  //disable any layout helpers 
	  mainPanel.setLayout(null);
    
		//Create side labels 
    counterLabel = new JLabel("Counter:");

		//set the size and location
		counterLabel.setBounds(100,170,100,25);

		//create text boxs for user output 
    countText = new JTextField();

		//set the location and size
		countText.setBounds(195,160,128,35);

		//make the output text box not allowing any input making it just a display box
		countText.setEnabled(false);

		//count the button
		countButton = new JButton("Count");
		//set the size and location of this
		countButton.setBounds(100,100,100,35);
		//Add an action listener to this 
		countButton.addActionListener(this);
		//set the action commands to the button
		countButton.setActionCommand("count");

		//reset the button
		resetButton = new JButton("Reset");
		//set the size and location of this
		resetButton.setBounds(220,100,100,35);
		//Add an action listener to this 
		resetButton.addActionListener(this);
		//set the action commands to the button
		resetButton.setActionCommand("reset");


		//add it to the mainPanel
		mainPanel.add(counterLabel);
		mainPanel.add(countText);
		mainPanel.add(countButton);
		mainPanel.add(resetButton);

		//add the mainPanel to the frame
		frame.add(mainPanel);
    

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();
		// find out what button was pressed
    if (command.equals("reset")) {
      // set count to 0
      count = 0;
			// reset the count in the counterField to 0
      countText.setText("0");

    } else if (command.equals("count")) {
      // it works only if the count is less than 10
      if (count < 10) {
				//increase the value of count by an increment of 1
        count += 1;
				//set the value of count as 1
        countText.setText("" + count);
      }
    }
  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
