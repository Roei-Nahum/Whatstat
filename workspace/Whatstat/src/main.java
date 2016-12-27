/* Roei Nahum 2016, all right reserved
 * main.java of Whatstat project
 */

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.BoxLayout;
import java.awt.Canvas;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths; 



public class main {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 255, 0));
		frame.setBounds(100, 100, 584, 414);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("I wan't it all!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel lblValidPath = new JLabel("");
		lblValidPath.setBackground(new Color(255, 0, 0));
		lblValidPath.setBounds(151, 89, 101, 17);
		frame.getContentPane().add(lblValidPath);
		
		JLabel MessageCounterLabel = new JLabel("");
		MessageCounterLabel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				MessageCounter ms= new MessageCounter();
				ms.setVisible(true);
			}
		});
		Image messageCounterImg = new ImageIcon(this.getClass().getResource("/messageCounter.png")).getImage();
		
		JLabel lblTheSmartest = new JLabel("the smartest");
		lblTheSmartest.setBounds(440, 124, 101, 17);
		frame.getContentPane().add(lblTheSmartest);
		
		JLabel smartestLabel = new JLabel("");
		smartestLabel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Smartest sm= new Smartest();
				sm.setVisible(true);
			}
		});
		Image smartestImage = new ImageIcon(this.getClass().getResource("/smartest.png")).getImage();
		smartestLabel.setIcon(new ImageIcon(smartestImage));
		smartestLabel.setBounds(450, 148, 64, 64);
		frame.getContentPane().add(smartestLabel);
		
		
		
		MessageCounterLabel.setIcon(new ImageIcon(messageCounterImg));
		MessageCounterLabel.setBounds(62, 153, 64, 64);
		frame.getContentPane().add(MessageCounterLabel);
		btnNewButton.setBounds(219, 332, 138, 32);
		frame.getContentPane().add(btnNewButton);
		
		JLabel title = new JLabel("Conversation path:");
		title.setBounds(41, 64, 113, 26);
		frame.getContentPane().add(title);
		
		textField = new JTextField();
		textField.setBounds(151, 67, 332, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		
		JLabel fileLabel = new JLabel("");
		Image fileImage = new ImageIcon(this.getClass().getResource("/file.png")).getImage();
		fileLabel.setIcon(new ImageIcon(fileImage));
		fileLabel.setBounds(7, 58, 32, 32);
		frame.getContentPane().add(fileLabel);

		
		JLabel whatstatLabel = new JLabel("");
		Image whatstatImg = new ImageIcon(this.getClass().getResource("/whatstat.png")).getImage();
		whatstatLabel.setIcon(new ImageIcon(whatstatImg));
		whatstatLabel.setBounds(186, 0, 217, 77);
		frame.getContentPane().add(whatstatLabel);
		
		JLabel lblMessageCounter = new JLabel("Message Counter");
		lblMessageCounter.setBounds(41, 124, 101, 17);
		frame.getContentPane().add(lblMessageCounter);
		
		JLabel funniestLabel = new JLabel("");
		funniestLabel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Funniest fun= new Funniest();
				fun.setVisible(true);
			}
		});
		Image funniestImg = new ImageIcon(this.getClass().getResource("/funniest.png")).getImage();
		funniestLabel.setIcon(new ImageIcon(funniestImg));
		funniestLabel.setBounds(256, 148, 64, 64);
		frame.getContentPane().add(funniestLabel);
		
		JLabel lblTheFunniest = new JLabel("the funniest");
		lblTheFunniest.setBounds(256, 124, 101, 17);
		frame.getContentPane().add(lblTheFunniest);
		
		JLabel lblQuestions = new JLabel("");
		lblQuestions.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Asker ask=new Asker();
				ask.setVisible(true);
			}
		});
		Image questionsImg = new ImageIcon(this.getClass().getResource("/questions.png")).getImage();
		lblQuestions.setIcon(new ImageIcon(questionsImg));
		lblQuestions.setBounds(62, 251, 64, 64);
		frame.getContentPane().add(lblQuestions);
		
		JLabel lblTheAsker = new JLabel("the asker");
		lblTheAsker.setBounds(62, 233, 101, 17);
		frame.getContentPane().add(lblTheAsker);
	
		JLabel initiatorlbl = new JLabel("");
		initiatorlbl.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Initiator init= new Initiator();
				init.setVisible(true);
			}
		});
		Image initiatorImg = new ImageIcon(this.getClass().getResource("/initiator.png")).getImage();
		initiatorlbl.setIcon(new ImageIcon(initiatorImg));
		initiatorlbl.setBounds(453, 251, 64, 64);
		frame.getContentPane().add(initiatorlbl);
		
		JLabel lblInitiator = new JLabel("the initiator");
		lblInitiator.setBounds(452, 233, 101, 17);
		frame.getContentPane().add(lblInitiator);
		
		JLabel lblEmojiUser = new JLabel("emoji user");
		lblEmojiUser.setBounds(256, 224, 101, 17);
		frame.getContentPane().add(lblEmojiUser);
		
		JLabel emojilbl = new JLabel("");
		emojilbl.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Emoji em= new Emoji();
				em.setVisible(true);
			}
		});
		Image emojiImg = new ImageIcon(this.getClass().getResource("/emoji.png")).getImage();
		emojilbl.setIcon(new ImageIcon(emojiImg));
		emojilbl.setBounds(256, 251, 64, 64);
		frame.getContentPane().add(emojilbl);
		
		
		
		JButton btnSave = new JButton("save");
		btnSave.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				Path conPath = Paths.get(textField.getText());
				Boolean valid=true;
				if(Files.notExists(conPath)) valid=false;
				try {
					String mimeType = Files.probeContentType(conPath);
					if(mimeType!="text/plain") valid=false; 
				} catch (IOException e) {
					e.printStackTrace();
				}
				if(valid){
				lblValidPath.setText("valid path!");
				lblValidPath.setForeground(new Color(0, 255, 255));
				}
				else{
					lblValidPath.setText("non valid path!");
					lblValidPath.setForeground(new Color(255, 0, 0));
				}
			}
		});
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSave.setBounds(485, 67, 68, 20);
		frame.getContentPane().add(btnSave);
		
		
		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setForeground(Color.BLACK);
		Image backgroundImg = new ImageIcon(this.getClass().getResource("/background.jpg")).getImage();
		backgroundLabel.setIcon(new ImageIcon(backgroundImg));
		backgroundLabel.setBounds(0, 0, 568, 376);
		frame.getContentPane().add(backgroundLabel);
		
		
		

		
	
		
	
		

		
		
		
		
		
		
		
		
		
	}
}
