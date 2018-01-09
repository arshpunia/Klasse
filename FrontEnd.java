import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class FrontEnd extends JFrame implements ActionListener
{
	JButton button;
	JButton button2;
	JTextField text;
	JTextField text2;
	JTextField text3;
	JTextField text4;
	String directory;
	JLabel label2;
	JLabel label3;
	static JTextArea miniConsole;
	boolean searchButtonPressed = false;
	
	public FrontEnd()
	{
		JFrame frame = new JFrame("Score Predictor");
		JPanel p = new JPanel();
		p.setSize(500, 800);
		p.setLayout(new GridLayout(10,2));
		
		/* Input field for class average before the final exam.
		 */
		JLabel label = new JLabel("Enter the class average before the exam: ");
		label.setFont(new Font("Serif", Font.CENTER_BASELINE, 25));
		p.add(label);
		text = new JTextField(10);
		text.setFont(new Font("Serif", Font.CENTER_BASELINE, 25));
		p.add(text);
		
		// Input field for the user's average before the exam.
		JLabel label2 = new JLabel("Enter your average before the exam: ");
		label2.setFont(new Font("Serif", Font.CENTER_BASELINE, 25));
		p.add(label2);
		text2 = new JTextField(10);
		text2.setFont(new Font("Serif", Font.CENTER_BASELINE, 25));
		p.add(text2);
		
		// Input field for the class average on the final exam
		label3 = new JLabel("Enter the class average on the final exam: ");
		label3.setFont(new Font("Serif", Font.CENTER_BASELINE, 25));
		p.add(label3);
		text3 = new JTextField(10);
		text3.setFont(new Font("Serif", Font.CENTER_BASELINE, 25));
		p.add(text3);
		
		//Input field for the weight of the final exam.
		JLabel label4 = new JLabel("Enter the weightage of your final exam: ");
		label4.setFont(new Font("Serif", Font.CENTER_BASELINE, 25));
		p.add(label4);
		text4 = new JTextField(10);
		text4.setFont(new Font("Serif", Font.CENTER_BASELINE, 25));
		p.add(text4);
		
		//JButton to view the predicted numbers
		String buttonText = "Calculate";
		button = new JButton();
		button.setText(buttonText);
		button.setFont(new Font("Monospace", Font.CENTER_BASELINE, 25));
		button.setSize(10, 1);
		p.add(button);
		
		
		// Console for display of the predicted numbers
		miniConsole = new JTextArea(50,50);
		miniConsole.setEditable(false);
		p.add(miniConsole);

		// Scrolling bar for text field
		JScrollPane txt_more_info_pane = new JScrollPane(miniConsole);  
        txt_more_info_pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        txt_more_info_pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		p.add(txt_more_info_pane);

		button.addActionListener(this);
		
		
		frame.add(p);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(400, 100);
		frame.setSize(800, 800);
		frame.setResizable(true);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		if(source.equals(button))
		{
			try
			{
				
				String classInput = text.getText();
				if(classInput.isEmpty())
				{
					miniConsole.setFont(new Font("Monospaced", Font.CENTER_BASELINE,16));
					miniConsole.append("Please enter a value for the class average");
				}
				else
				{
				double classAverage = Double.valueOf(classInput);
				
				
				String preExam = text2.getText();
				if(preExam.isEmpty())
				{
					miniConsole.setFont(new Font("Monospaced", Font.CENTER_BASELINE,16));
					miniConsole.append("Please enter a value for your average");
				}
				else
				{
				double yourAverage = Double.valueOf(preExam);
				
				String examAv = text3.getText();
				if(examAv.isEmpty())
				{
					miniConsole.setFont(new Font("Monospaced", Font.CENTER_BASELINE,16));
					miniConsole.append("Please enter a value for the class average on the exam");
				}
				else
				{
				double examAverage = Double.valueOf(examAv);
				
				String weight = text4.getText();
				if(weight.isEmpty())
				{
					miniConsole.setFont(new Font("Monospaced", Font.CENTER_BASELINE,16));
					miniConsole.append("Please enter a value for the weightage of the final exam");
				}
				else
				{
				double weightage = Double.valueOf(weight);
				//Creating a MarkPredictor Object from the passed in parameters
				MarkPredictor predictor = new MarkPredictor(classAverage,yourAverage,examAverage);
				double markOnExam = predictor.examMark();
				String examPerformance = String.format("%.2f", markOnExam);
				double finalMark = predictor.finalMark(weightage);
				//String inTheEnd = String.valueOf(finalMark);
				String inTheEnd = String.format("%.2f",finalMark);
				miniConsole.setFont(new Font("Monospaced", Font.CENTER_BASELINE,16));
				miniConsole.append("Your predicted mark on the exam is "+examPerformance+"% \n");
				miniConsole.append("Your predicted mark on the course is "+inTheEnd+"% \n\n");
				}
				}
				}
				}	
			} catch (Exception e3)
			{
				e3.printStackTrace();
			}
			
		} 
	}
	

	public static void main(String[] args)
	{
		new FrontEnd();
	}
}