package methodpage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TeacherControl extends JFrame implements ActionListener
{
	private JPanel jp=new HomePanel1();
	JButton button1 = new JButton("前往排课");
	JButton button2 = new JButton("查看教师课表");
	JButton button3 = new JButton("查看班级课表");
	JButton but[] = {button1,button2,button3};
	public TeacherControl(){
		jp.setLayout(null);
		for(int i = 0; i < 3; i ++) {
			but[i].setBounds(50,10+40*i,150,30);
			but[i].setFont(new Font("宋体",Font.PLAIN,16));
			but[i].setForeground(Color.BLACK);
			but[i].setContentAreaFilled(false);
			but[i].addActionListener(this);
			jp.add(but[i]);
		}
		this.add(jp);
		this.setTitle("教师选择窗口");
		this.setBounds(550, 500, 250, 250);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if(e.getSource() == but[0]) {
			this.setExtendedState(JFrame.ICONIFIED);
			Thacherinfo cs = new Thacherinfo();
		}
		if(e.getSource() == but[1]) {
			this.setExtendedState(JFrame.ICONIFIED);
			TeacherClasstable stu = new TeacherClasstable();
		}
		if(e.getSource() == but[2]) {
			this.setExtendedState(JFrame.ICONIFIED);
			StudentClasstable stu = new StudentClasstable();
		}
		
	}

}
