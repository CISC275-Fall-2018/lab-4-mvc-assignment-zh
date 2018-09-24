import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
//Zhihao Zhang

/**
 * View: Contains everything about graphics and images
 * Know size of world, which images to load etc
 *
 * has methods to
 * provide boundaries
 * use proper images for direction
 * load images for all direction (an image should only be loaded once!!! why?)
 **/

public class View extends JPanel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final int frameCount = 10;
    int picNum = 0;
    BufferedImage[][] pics;
    int xloc = 0;
    int yloc = 0;
    int xdir = 1;
    int ydir = 0;
    int direction = 0;
    final int xIncr = 8;
    final int yIncr = 2;
    final static int frameWidth = 500;
    final static int frameHeight = 300;
    final static int imgWidth = 165;
    final static int imgHeight = 165;
	private JFrame frame = null;
	private boolean initFrame = false;
	
	
    public View() {
    	pics = new BufferedImage[8][10];
    	for(int i = 0; i < 8; i++) {
	    	BufferedImage img = createImage(i);
         	pics[i] = new BufferedImage[10];
	    	for(int j = 0; j < frameCount; j++)
	    		pics[i][j] = img.getSubimage(imgWidth*j, 0, imgWidth, imgHeight);
	    	
	    	// TODO: Change this constructor so that at least eight orc animation pngs are loaded
    	}
    }  
    
    private BufferedImage createImage(int dir) {
    	BufferedImage bufferedImage;
    	try {
    		if(dir == 0) {
    			bufferedImage = ImageIO.read(new File("images/orc/orc_forward_north.png"));
    			return bufferedImage;
    		}
    		if(dir == 1) {
    			bufferedImage = ImageIO.read(new File("images/orc/orc_forward_northeast.png"));
    			return bufferedImage;
    		}
    		if(dir == 2) {
    			bufferedImage = ImageIO.read(new File("images/orc/orc_forward_east.png"));
    			return bufferedImage;
    		}
    		if(dir == 3) {
    			bufferedImage = ImageIO.read(new File("images/orc/orc_forward_southeast.png"));
    			return bufferedImage;
    		}
    		if(dir == 4) {
    			bufferedImage = ImageIO.read(new File("images/orc/orc_forward_south.png"));
    			return bufferedImage;
    		}
    		if(dir == 5) {
    			bufferedImage = ImageIO.read(new File("images/orc/orc_forward_southwest.png"));
    			return bufferedImage;
    		}
    		if(dir == 6) {
    			bufferedImage = ImageIO.read(new File("images/orc/orc_forward_west.png"));
    			return bufferedImage;
    		}
    		if(dir == 7) {
    			bufferedImage = ImageIO.read(new File("images/orc/orc_forward_northwest.png"));
    			return bufferedImage;
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    	
    	// TODO: Change this method so you can load other orc animation bitmaps
    }

	public int getWidth() {
		// TODO Auto-generated method stub
		return frameWidth;
	}

	public int getHeight() {
		// TODO Auto-generated method stub
		return frameHeight;
	}

	public int getImageWidth() {
		// TODO Auto-generated method stub
		return imgWidth;
	}

	public void update(int newX, int newY, int newDir) {
		if (!initFrame) {
			frame = new JFrame();
			frame.getContentPane().add(this);
			frame.setBackground(Color.gray);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(frameWidth, frameHeight);
			frame.setVisible(true);
			initFrame=true;}
		
		xloc = newX;
		yloc = newY;
		direction = newDir;
		frame.repaint();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}

	public int getImageHeight() {
		// TODO Auto-generated method stub
		return imgHeight;
	}
	
	public void paint(Graphics g) {
	picNum = (picNum + 1) % frameCount;
	g.drawImage(pics[direction][picNum],xloc+=xIncr, yloc+=yIncr, Color.gray, this);
	
}
}
