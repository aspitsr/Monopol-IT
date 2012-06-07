package Monopoly;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ActionHandler implements KeyListener, MouseListener, MouseMotionListener {

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

	public void mousePressed(MouseEvent e) {
		if(Screen.isGame) {
			Screen.gui.click(e.getButton());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			int key = e.getKeyCode();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Screen.mse = new Point((e.getX()) - ((Frame.size.width - Screen.myWidth)/2), ((e.getY()) - ((Frame.size.height - (Screen.myHeight))-(Frame.size.width - Screen.myWidth)/2)));
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Screen.mse = new Point((e.getX()) - ((Frame.size.width - Screen.myWidth)/2), ((e.getY()) - ((Frame.size.height - (Screen.myHeight))-(Frame.size.width - Screen.myWidth)/2)));
	}

}
