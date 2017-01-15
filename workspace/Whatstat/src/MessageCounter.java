import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSlider;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.border.TitledBorder;
import javax.swing.DropMode;

public class MessageCounter extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MessageCounter frame = new MessageCounter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MessageCounter() {
		setBackground(Color.GREEN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 418, 501);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOutput = new JLabel("message counter");
		lblOutput.setFont(new Font("Narkisim", Font.PLAIN, 21));
		lblOutput.setBackground(new Color(255, 255, 0));
		lblOutput.setBounds(132, 11, 165, 47);
		contentPane.add(lblOutput);
		
		JButton btnNewButton = new JButton("close");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(172, 415, 73, 23);
		contentPane.add(btnNewButton);
		
	
	
		functionTop top=null;
		String out = top.run("C:/Users/roei/Downloads/ex.txt",1);
		
		JTextArea outi = new JTextArea();
		outi.setBackground(new Color(102, 255, 102));
		outi.setFont(new Font("Arial", Font.BOLD, 16));
		outi.setText(out);
		JScrollPane scrollPane =new JScrollPane(outi);
		scrollPane.setBounds(88, 69, 240, 335);
		contentPane.add(scrollPane);	
		
		
	
		
	   
		
	}
}
