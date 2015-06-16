import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

//import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.CardLayout;

import javax.swing.JSplitPane;

import java.awt.FlowLayout;

import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;
import javax.swing.BoxLayout;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;

import java.awt.Canvas;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JSlider;
import javax.swing.JTextField;


public class testJFrame extends JFrame {
	private JTextField textField;

	
	class DragPanel extends JPanel{
		private volatile int draggedAtX, draggedAtY;
		public DragPanel(){
			super();
			addMouseListener(new MouseAdapter(){
	            public void mousePressed(MouseEvent e){
	                draggedAtX = e.getX();
	                draggedAtY = e.getY();
	            }
	        });

	        addMouseMotionListener(new MouseMotionAdapter(){
	            public void mouseDragged(MouseEvent e){
	                setLocation(e.getX() - draggedAtX + getLocation().x,
	                        e.getY() - draggedAtY + getLocation().y);
	            }
	        });

		}
		
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testJFrame frame = new testJFrame();
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
	public testJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 487);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 556, 357);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(37, 217, 20, 20);
		panel.add(panel_1);
		
		JPanel panel_2 = new DragPanel();
//		panel_2.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent arg0) {
//				
//			}
//		});
		panel_2.setBackground(Color.GREEN);
//		panel_2.addMouseMotionListener(new MouseMotionAdapter() {
//			@Override
//			public void mouseDragged(MouseEvent arg0) {
//				int x = arg0.getX();
//				int y = arg0.getY();
//				panel_2.setLocation(x, y);
//				
//			}
//		});
		
		
		panel_2.setBounds(37, 25, 20, 20);
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(390, 217, 20, 20);
		panel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setToolTipText("");
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("hihihihihi");
			}
		});
		panel_4.setBounds(390, 25, 20, 20);
		panel_4.setBackground(Color.ORANGE);
		panel.add(panel_4);
		
		JSlider slider = new JSlider();
		slider.setBounds(356, 334, 200, 23);
		panel.add(slider);
		
		JButton btnAddA = new JButton("Add Anchors");
		btnAddA.setBounds(20, 379, 89, 23);
		getContentPane().add(btnAddA);
		
		JButton btnAddTag = new JButton("Add tag");
		btnAddTag.setBounds(119, 379, 89, 23);
		getContentPane().add(btnAddTag);
		
		JButton btnDeleteAnchors = new JButton("Delete Anchors");
		btnDeleteAnchors.setBounds(20, 415, 89, 23);
		getContentPane().add(btnDeleteAnchors);
		
		JButton button = new JButton("Delete tag");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(119, 413, 89, 23);
		getContentPane().add(button);
		
		JTextArea txtrDistanceBtwA = new JTextArea();
		txtrDistanceBtwA.setBackground(UIManager.getColor("Button.background"));
		txtrDistanceBtwA.setEditable(false);
		txtrDistanceBtwA.setText("distance btw A0 and A1");
		txtrDistanceBtwA.setBounds(232, 379, 163, 23);
		getContentPane().add(txtrDistanceBtwA);
		
		textField = new JTextField();
		textField.setBounds(232, 400, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
	

		
		
		
	}
}
