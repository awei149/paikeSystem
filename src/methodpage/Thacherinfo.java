package methodpage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Thacherinfo extends JFrame implements ActionListener
{
	private JPanel jp=new HomePanel1();
	JComboBox<String> classroomName = new JComboBox<String>();//教室类型
	JTextField classid=new JTextField();//班级编号
	JTextField classname=new JTextField();//班级名称
	JTextField kemu=new JTextField();//科目
	JTextField num=new JTextField();//每周几节
	JTextField teachername = new JTextField();
	JTextField teacherid = new JTextField();
	JTextField tx[] = {classid,classname,kemu,num,teachername,teacherid};
	JLabel classidT=new JLabel("班级编号");
	JLabel classnameT=new JLabel("班级名称");
	JLabel kemuT=new JLabel("科目");
	JLabel numT=new JLabel("节数");
	JLabel thname = new JLabel("教师姓名");
	JLabel thid = new JLabel("教师编号");
	JLabel classroomNa = new JLabel("教室类型");
	JLabel js[]= {classidT,classnameT,kemuT,numT,thname,thid};
	JButton anniu1=new JButton("开始排课");
	JButton anniu2=new JButton("重置");
	JButton a[]= {anniu1,anniu2};
	public Thacherinfo() {
		jp.setLayout(null);
		classroomNa.setBounds(80, 260, 100, 30);
		classroomNa.setFont(new Font("宋体",Font.PLAIN,16));
		jp.add(classroomNa);
		classroomName.addItem("请选择");
		classroomName.addItem("普通教室");
		classroomName.addItem("实验教室");
		classroomName.setBounds(200, 260, 150, 30);
		classroomName.setOpaque(false);
		jp.add(classroomName);
		for(int i=0;i<js.length;i++)
		{
			js[i].setBounds(80,20+40*i,100,30);
			js[i].setFont(new Font("宋体",Font.PLAIN,16));
			tx[i].setBounds(200,20+40*i,150,30);
			tx[i].setOpaque(false);
			jp.add(js[i]);
			jp.add(tx[i]);
		}
		for(int j = 0; j < 2; j ++) {
			a[j].setBounds(40+160*j,350,150,30);
			a[j].setFont(new Font("宋体",Font.PLAIN,16));
			a[j].setForeground(Color.BLACK);
			a[j].setContentAreaFilled(false);
			a[j].addActionListener(this);
			jp.add(a[j]);
		}
		this.add(jp);
		this.setTitle("排课信息窗口");
		this.setBounds(550, 500, 450, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if(e.getSource() == a[0]) {
			this.setExtendedState(JFrame.ICONIFIED);
			CourseScheduling cs = new CourseScheduling();//调用排课类
			cs.classID = classid.getText();//赋值班级id
			System.out.print(cs.classID);
			cs.className = classname.getText();//赋值班级名称
			cs.classroomName = classroomName.getSelectedItem().toString();//赋值教室类型
			cs.courseName = kemu.getText();//赋值课程名称
			cs.TeacherID = teacherid.getText();//赋值教师id
			cs.TeacherName = teachername.getText();//赋值教师名字
			System.out.println("完成");
			cs.n = Integer.parseInt(num.getText());//赋值每周几节
			cs.coverText();
//			cs.courseScheduling();
		}else {
			for(int i = 0; i < 7; i ++) {
				tx[i].setText("");
			}
		}
		
	}

}
