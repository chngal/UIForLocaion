import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

//import test.testUI;


public class UIforLocation 	{
	JFrame jf = new JFrame("testing");
	JPanel jp1 = new drawing();
	JPanel jp2 = new JPanel();
	JButton addAnchors = new JButton("Add Anchors");
	JButton addTag = new JButton("Add Tag");
	JButton deleteAnchors = new JButton("Delete Anchors");
	JTextArea[] distanceOfAnchorsText = new JTextArea[6];
	JTextField[] distanceOfAnchorsField = new JTextField[6];
	JButton[] setLocationButton  = new JButton[6];
	boolean[] activationOfCircle = {false,false,false, false};
	CirclePanel[] circle = new CirclePanel[4];
	private static int activationAnchorsCounter = 0;
	int MaxOfAnchors = 4;
	
	class addAnchorsListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//System.out.println("ADD Anchors Button!!!!!");
			if(activationAnchorsCounter < MaxOfAnchors){
				activationOfCircle[activationAnchorsCounter] = true;
				circle[activationAnchorsCounter].setVisible(true);
				//circle[activationAnchorsCounter].setName("A"+activationAnchorsCounter);
				activationAnchorsCounter++;
			}
			else{
				JOptionPane.showMessageDialog(jf, "You cannot add more than 4 Anchors");
				//System.out.println("You cannot add more than 4 Anchors");
				}
		}
		
	}
	class deleteAnchorsListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//System.out.println("Delete Anchors Button~~~~");
			if(activationAnchorsCounter > 0 ){
				activationAnchorsCounter--;
				activationOfCircle[activationAnchorsCounter] = false;
				circle[activationAnchorsCounter].setVisible(false);
				circle[activationAnchorsCounter].setLocation(0, 0);
				
			int AnchorsCounter = choose(activationAnchorsCounter+1,2);
				for (int i = 0; i< AnchorsCounter ;i++){
					distanceOfAnchorsText[i].setVisible(false);
					distanceOfAnchorsField[i].setVisible(false);
					setLocationButton[i].setVisible(false);
				}
				AnchorsCounter = 0;
        		for(int i = 0; i<MaxOfAnchors;i++ ){
        			for(int j = i+1; j< MaxOfAnchors; j++){
        				if(activationOfCircle[i]==true && activationOfCircle[j]==true){
        					distanceOfAnchorsText[AnchorsCounter].setVisible(true);
        					distanceOfAnchorsField[AnchorsCounter].setVisible(true);
        					setLocationButton[AnchorsCounter].setVisible(true);
        					distanceOfAnchorsText[AnchorsCounter].setText("Distance between Anchors["+ i +"] and Anchors[" + j + "] is " + 
        							calDistance(circle[i].getX(), circle[i].getY(), circle[j].getX(),circle[j].getY()) );
        					AnchorsCounter++;
        				}
        			}
        		}
				
			}
			else{
				JOptionPane.showMessageDialog(jf, "There are no Anchors can be deleted");
				
				}		
		}
		
	}
	class addTagListener implements ActionListener{

	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("ADD TAG Button");
		}
		
	}
	
	
	
	//Create the UI of the main Frame
	public UIforLocation() {
		
		// TODO Auto-generated constructor stub
		final DrawingClass dc = new DrawingClass();
		
		jf.setSize(960,960);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.setLayout(new GridLayout(1, 2));
		

		MyPanel myPanel = new MyPanel();
		myPanel.setLayout(null);
		jf.add(myPanel);

//		CirclePanel testPanel = new CirclePanel();
//		testPanel.setBackground(Color.WHITE);
//		testPanel.setBounds(0, 0, 20, 20);
//		myPanel.add(testPanel);
		
		for (int i = 0;i<MaxOfAnchors;i++){
			circle[i] = new CirclePanel();
			circle[i].setBackground(Color.WHITE);
			circle[i].setBounds(0, 0, 20, 20);
			circle[i].add(new JLabel("A"+i));	
		}
		for (int i = 0;i<MaxOfAnchors;i++){
			myPanel.add(circle[i]);
		}
		
		jp2.setLayout(null);
		addAnchors.setBounds(20, 20, 140, 50);
		deleteAnchors.setBounds(170, 20, 140, 50);
		addTag.setBounds(20,80,140,50);
		addAnchors.addActionListener(new addAnchorsListener());
		addTag.addActionListener(new addTagListener());
		deleteAnchors.addActionListener(new deleteAnchorsListener());
		
		for(int i =0; i<6;i++){
			distanceOfAnchorsText[i] = new JTextArea();
			distanceOfAnchorsText[i].setEditable(false);
			distanceOfAnchorsText[i].setBounds(20,180+i*60 ,350 , 20);
			distanceOfAnchorsText[i].setVisible(false);
			distanceOfAnchorsText[i].setBackground(new Color(238,238,238));
			distanceOfAnchorsField[i] = new JTextField();
			distanceOfAnchorsField[i].setBounds(20,210+i*60,350,20);
			distanceOfAnchorsField[i].setVisible(false);
			setLocationButton[i] = new setLocationButton("Set", i);
			setLocationButton[i].setName("Set");
			setLocationButton[i].setBounds(380, 210+i*60, 70, 20);
			setLocationButton[i].setVisible(false);
			
			jp2.add(distanceOfAnchorsText[i]);
			jp2.add(distanceOfAnchorsField[i]);
			jp2.add(setLocationButton[i]);
			
		}
		
		jp2.add(addAnchors);
		jp2.add(addTag);
		jp2.add(deleteAnchors);
		jf.add(jp2);
		//jf.addMouseListener(this);
		//jf.add(t);
		
		
	}

	public static void main(String[] args) {
		UIforLocation ui = new UIforLocation();
		
	}
	

	
	class DrawingClass {

	    public void draw(Graphics2D g2d, int w, int h) {
	        g2d.setColor(Color.BLUE);
	        g2d.fillOval(5, 5, w / 2, h / 2);
	    }
	}
	
	class MyPanel extends JPanel
	{
		int xCor, yCor;
	    MyPanel()
	    {
	        setBackground(Color.WHITE);
	        setPreferredSize(new Dimension(250,250));
	        addMouseListener(new MouseAdapter() {
			
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					System.out.println("x = " + e.getX() + " y = " + e.getY() );
					xCor = e.getX();
					yCor = e.getY();
					repaint();
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
				}
				
			});
	    }
	    
	    public void paintComponent(Graphics page)
	    {
	        super.paintComponent(page);
	        drawCircle(page,xCor,yCor,10);
	    }

	    private void drawCircle(Graphics g, int x, int y, int radius)
	    {	
	    	g.setColor(Color.ORANGE);
	        g.fillOval(x - radius, y - radius, radius*2, radius*2);
	    }
	    
		
	}
	class setLocationButton extends JButton{
		int index = 0;
		public setLocationButton(String name, int index){
			super(name);
			this.index = index;
			addMouseListener(new MouseAdapter(){
	            public void mouseClicked(MouseEvent e){
	            	try{
	            		int distanceApart =Integer.parseInt((distanceOfAnchorsField[index].getText()))*10;
	            		
	            		int[] indexOfAnchors = findTheIndexOfAnchors(index);
		            	if(indexOfAnchors[1]<2){
		            		
		            		circle[indexOfAnchors[1]].setLocation(circle[indexOfAnchors[0]].getX()-distanceApart,circle[indexOfAnchors[0]].getY() );
		            	}
		            	else{
		            		circle[indexOfAnchors[1]].setLocation(circle[indexOfAnchors[0]].getX(),circle[indexOfAnchors[0]].getY()-distanceApart );
		            	}
	            	}catch(Exception ex){
	            		System.err.println("Input not an integer: " + ex.getMessage());
	            	}
	            	updateDistanceOfAnchors();
	            	
	               
	                

	            }
			});
		}
	}
	class CirclePanel extends JPanel{
		boolean activate = false;
		//int xCor = 20, yCor = 20;
		
		
		private volatile int draggedAtX, draggedAtY;
		public CirclePanel(){
			super();
			setVisible(false);
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
	                
	        		int AnchorsCounter = 0;
	        		for(int i = 0; i<MaxOfAnchors;i++ ){
	        			for(int j = i+1; j< MaxOfAnchors; j++){
	        				if(activationOfCircle[i]==true && activationOfCircle[j]==true){
	        					distanceOfAnchorsText[AnchorsCounter].setVisible(true);
	        					distanceOfAnchorsField[AnchorsCounter].setVisible(true);
	        					setLocationButton[AnchorsCounter].setVisible(true);
	        					distanceOfAnchorsText[AnchorsCounter].setText("Distance between Anchors["+ i +"] and Anchors[" + j + "] is " + 
	        							calDistance(circle[i].getX(), circle[i].getY(), circle[j].getX(),circle[j].getY()) );
	        					//System.out.println(" From Anchors["+ i +"] to Anchors[" + j + "] the distance is " + 
	        						//	calDistance(circle[i].getX(), circle[i].getY(), circle[j].getX(),circle[j].getY()) );
	        					AnchorsCounter++;
	        				}
	        			}
	        		}
	            }
	        });
	        addMouseMotionListener(new MouseAdapter(){
	        	public void mouseReleased(MouseEvent e){
	        		System.out.println("Released!!!!!!!");
	        		//MaxOfAnchors -> activationAnchorsCounter
	        		int AnchorsCounter = 0;
	        		for(int i = 0; i<MaxOfAnchors;i++ ){
	        			for(int j = i+1; j< MaxOfAnchors; j++){
	        				if(activationOfCircle[i]==true && activationOfCircle[j]==true){
	        					distanceOfAnchorsText[AnchorsCounter].setText("From Anchors["+ i +"] to Anchors[" + j + "] the distance is " + 
	        							calDistance(circle[i].getX(), circle[i].getY(), circle[j].getX(),circle[j].getY()) );
	        					System.out.println(" From Anchors["+ i +"] to Anchors[" + j + "] the distance is " + 
	        							calDistance(circle[i].getX(), circle[i].getY(), circle[j].getX(),circle[j].getY()) );
	        					AnchorsCounter++;
	        				}
	        			}
	        		}
	        	}
	        });
	        
		}
		 public void paintComponent(Graphics page)
		    {
		        super.paintComponent(page);
		        drawCircle(page,10,10,10);
		    }

		    private void drawCircle(Graphics g, int x, int y, int radius)
		    {	
		    	g.setColor(Color.PINK);
		        g.fillOval(x - radius, y - radius, radius*2, radius*2);
		    }
		
	}
	
	private float calDistance(float x1, float y1, float x2, float y2){
		
		
		return (float) (Math.sqrt(Math.pow(x1-x2, 2)+ Math.pow(y1 - y2, 2)))/10;
	}
	
	private static int choose(int x, int y) {
	    if (y < 0 || y > x) return 0;
	    if (y > x/2) {
	        // choose(n,k) == choose(n,n-k), 
	        // so this could save a little effort
	        y = x - y;
	    }

	    double denominator = 1.0, numerator = 1.0;
	    for (int i = 1; i <= y; i++) {
	        denominator *= i;
	        numerator *= (x + 1 - i);
	    }
	    return  (int) (numerator / denominator);
	}

	private static int[] findTheIndexOfAnchors(int index){
		int counter = 0;
		int[] ans = new int[2];
		for(int i = 0; i< activationAnchorsCounter; i++){
			for(int j = i+1; j< activationAnchorsCounter; j++){
				
				if(counter==index){
					ans[0]=i;
					ans[1]=j;
					return ans;
				}
				counter++;
			}
		}
		ans[0] =-1;
		ans[1] = -1;
		return ans;	
	}

	private  void updateDistanceOfAnchors(){
		int AnchorsCounter = 0;
		for(int i = 0; i<MaxOfAnchors;i++ ){
			for(int j = i+1; j< MaxOfAnchors; j++){
				if(activationOfCircle[i]==true && activationOfCircle[j]==true){
					distanceOfAnchorsText[AnchorsCounter].setText("Distance between Anchors["+ i +"] and Anchors[" + j + "] is " + 
							calDistance(circle[i].getX(), circle[i].getY(), circle[j].getX(),circle[j].getY()) );
					
					AnchorsCounter++;
				}
			}
		}
	}
}
