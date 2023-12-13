import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    private final JRadioButton radioButton2;
    private final JRadioButton radioButton3;
    JRadioButton radioButton;
    JLabel label, title;
    JButton button;

    MyFrame() {
        this.setTitle("Quiz");
        this.setSize(600, 600);
        this.setLocationRelativeTo(null); //sets frame pop up center of screen
        this.setLayout(null); // sets choices according to bounds below

        title = new JLabel("Question 1: What is the capital on New York State?");
        title.setBounds(150, 100, 400, 35);

        // JRadioButton creates button for choices
        radioButton = new JRadioButton("New York City");
        radioButton.setBounds(250, 150, 300, 25);

        radioButton2 = new JRadioButton("Albany");
        radioButton2.setBounds(250, 200, 300, 25);

        radioButton3 = new JRadioButton("Kingston");
        radioButton3.setBounds(250, 250, 300, 25);

        ButtonGroup bg = new ButtonGroup(); // assures only one option can be selected
        bg.add(radioButton);
        bg.add(radioButton2);
        bg.add(radioButton3);

        //create the submit button
        button = new JButton("Submit");
        button.setBounds(250, 320, 100, 25);
        button.setForeground(Color.blue);
        button.addActionListener(this);

        this.add(radioButton);
        this.add(radioButton2);
        this.add(radioButton3);
        this.setVisible(true); // allows JPane pop up to appear on screen
        this.add(title);
        this.add(button);
    }

    // this creates action for the corresponding message to appear when "submit" button is clicked with selected choice
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (radioButton.isSelected()) {
            JOptionPane.showMessageDialog(this, "Your answer is incorrect.Try again");
        }
        if (radioButton2.isSelected()) {
            JOptionPane.showMessageDialog(this, "Your answer is correct.Try again");
        }
        if (radioButton2.isSelected()) {
            JOptionPane.showMessageDialog(this, "Your answer is correct.Try again");
        }

    }
}
