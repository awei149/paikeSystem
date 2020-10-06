package methodpage;
import java.awt.*;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
public class TeacherClasstable extends JFrame implements ActionListener
{
	private JPanel jp=new HomePanel1();
	JLabel teacherid;
	JTextField teaID;
	JButton btn1 = new JButton("查询");
	JButton btn2 = new JButton("返回");
	JButton btn[] = {btn1,btn2};
	ArrayList<ArrayList <String>> list = new ArrayList<ArrayList <String>>();
	public TeacherClasstable() {
		jp.setLayout(null);
		teacherid = new JLabel("请输入教师编号");
		teaID = new JTextField();
		teacherid.setBounds(50, 20, 150, 30);
		teacherid.setFont(new Font("宋体",Font.PLAIN,16));
		teaID.setBounds(190, 20, 150, 30);
		teaID.setOpaque(false);
		for(int i = 0; i < 2; i++) {
			btn[i].setBounds(50+190*i, 80, 150, 30);
			btn[i].setFont(new Font("宋体",Font.PLAIN,16));
			btn[i].setForeground(Color.BLACK);
			btn[i].setContentAreaFilled(false);
			btn[i].addActionListener(this);
			jp.add(btn[i]);
		}
		jp.add(teaID);
		jp.add(teacherid);
		this.add(jp);
		this.setTitle("排课信息窗口");
		this.setBounds(550, 500, 450, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if(e.getSource() == btn[0]) {
			Shujuku sk = new Shujuku();
			list = sk.SelectTeacher(teaID.getText());
			if(sk.flag3 == 1) {
				this.setExtendedState(JFrame.ICONIFIED);
				Timetable ta = new Timetable();
				ta.teachercourseTable(list);
				sk.table.clear();
			}
		}
		if(e.getSource() == btn[1]) {
			TeacherControl tea = new TeacherControl();
		}
		
	}

}
