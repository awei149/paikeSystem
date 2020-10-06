package methodpage;
import java.awt.Image;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class Homepane2 extends JPanel
{
	ImageIcon icon;
	Image img;
	public Homepane2()
	{
		icon=new ImageIcon("D:\\图片\\iii.jpg");
		 img = icon.getImage();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//下面这行是为了背景图片可以跟随窗口自行调整大小，可以自己设置成固定大小
		g.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), this);
	}

}
