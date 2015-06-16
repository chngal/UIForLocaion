import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;


public class TestCircle extends Canvas implements MouseListener,MouseMotionListener  {
	private int x1, y1, x2, y2;
	public TestCircle(){
		
		
	}
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		//int input =0;
		g.setColor(Color.GREEN);
		g.drawOval(20, 20, 20, 20);
//		Scanner in = new Scanner(System.in);
//		int input = in.nextInt();
//		while(input!=0){
//			g.drawOval(100, 100, input, input);
//			input = in.nextInt();
//		}
//		for(int i = 10 ; i<500; i+=20){
//			g.drawOval(100, 100, i, i);
//			g.drawOval(700-i, 100+(i/15), i, i);
//		}
		
	}
	public void drawCircle(Graphics g, int x1, int y1){
		g.setColor(Color.RED);
		g.drawOval(x1, y1, 200, 200);
	}
	public static void main(String[] args) {
		JFrame jf = new JFrame("Testing");
		
		TestCircle t = new TestCircle();
		//setTitle("Testing");
		jf.setSize(960,960);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(t);
		//Graphics hihi = new Gra
		//t.paint(null);
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		x1 = arg0.getX();
		y1 = arg0.getY();
		drawCircle(null,x1,y1);
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		x1 = arg0.getX();
		y1 = arg0.getY();
		drawCircle(null,x1,y1);
		

	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
