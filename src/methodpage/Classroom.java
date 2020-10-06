package methodpage;
import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Classroom extends JFrame implements ActionListener
{
	JPanel jp=new Homepane2();
	JButton add;
	JButton delete;
	JButton change;
	JLabel number1;//教室编号文本
	JTextField number;//教室编号
	JLabel name1;//教室类型文本
	JTextField name;//教室编号
	JLabel xianshi;
	JTextArea jieguo;
	JTextField jt;
	JLabel mn;
	JButton fanhui;
	public Classroom() {
		jp.setLayout(null);
		add=new JButton("增加");
		delete=new JButton("删除");
		change=new JButton("修改");
		fanhui=new JButton("返回");

		add.setFont(new Font("宋体",Font.PLAIN,16));
		change.setFont(new Font("宋体",Font.PLAIN,16));
		delete.setFont(new Font("宋体",Font.PLAIN,16));
		fanhui.setFont(new Font("宋体",Font.PLAIN,16));
		add.setContentAreaFilled(false);
		change.setContentAreaFilled(false);
		delete.setContentAreaFilled(false);
		fanhui.setContentAreaFilled(false);
		
		add.setBounds(300, 50, 80, 30);
		delete.setBounds(300,180,80,30);
		change.setBounds(300, 310, 80, 30);
		fanhui.setBounds(300,410,80,30);
		add.addActionListener(this);
		delete.addActionListener(this);
		change.addActionListener(this);
		fanhui.addActionListener(this);
		jp.add(add);
		jp.add(delete);
		jp.add(change);
		jp.add(fanhui);
		
		number1=new JLabel("教室编号");
		number=new JTextField(50);
		number.setOpaque(false);
		number1.setBounds(10,50,100,30);
		number.setBounds(100, 50, 100, 20);
		jp.add(number1);
		jp.add(number);
		number1.setFont(new Font("宋体",Font.PLAIN,16));
		number.setFont(new Font("宋体",Font.BOLD,16));
		
		name1=new JLabel("教室类型");
		name=new JTextField(50);
		name.setOpaque(false);
		name1.setBounds(10,100,100,30);
		name.setBounds(100, 100, 100, 20);
		jp.add(name1);
		jp.add(name);
		name1.setFont(new Font("宋体",Font.PLAIN,16));
		name.setFont(new Font("宋体",Font.BOLD,16));
		
//		sex1=new JLabel("性别");
//		sex=new JTextField(50);
//		sex.setOpaque(false);
//		sex1.setBounds(10,150,50,30);
//		sex.setBounds(100,150,100,20);
//		jp.add(sex1);
//		jp.add(sex);
//		sex1.setFont(new Font("宋体",Font.PLAIN,16));
//		sex.setFont(new Font("宋体",Font.BOLD,16));
		
//		birthday1=new JLabel("出生日期");
//		birthday=new JTextField(50);
//		birthday.setOpaque(false);
//		birthday1.setBounds(10,200,100,30);
//		birthday.setBounds(100, 200, 100, 20);
//		jp.add(birthday1);
//		jp.add(birthday);
//		birthday1.setFont(new Font("宋体",Font.PLAIN,16));
//		birthday.setFont(new Font("宋体",Font.BOLD,16));
		
//		classid1=new JLabel("班级编号");
//		classid=new JTextField(50);
//		classid.setOpaque(false);
//		classid1.setBounds(10,250,100,30);
//		classid.setBounds(100,250,100,20);
//		jp.add(classid1);
//		jp.add(classid);
//		classid1.setFont(new Font("宋体",Font.PLAIN,16));
//		classid.setFont(new Font("宋体",Font.BOLD,16));
		
		xianshi=new JLabel("操作结果");
		xianshi.setBounds(10,380,100,30);
		jieguo=new JTextArea();
		jieguo.setOpaque(false);
		jieguo.setBounds(100,380,100,30);
		jp.add(xianshi);
		jp.add(jieguo);
		xianshi.setFont(new Font("宋体",Font.PLAIN,16));
		jieguo.setFont(new Font("宋体",Font.BOLD,16));
		
		mn=new JLabel("更改编号");
		jt=new JTextField(50);
		jt.setOpaque(false);
		mn.setBounds(10,300,100,30);
		jt.setBounds(100,300,100,20);
		jp.add(mn);
		jp.add(jt);
		mn.setFont(new Font("宋体",Font.PLAIN,16));
		
		this.add(jp);
		this.setTitle("管理员窗口");
		this.setBounds(200,200,600,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if(e.getSource().equals(add))
		{
			Shujuku s=new Shujuku();
			try {
				s.sta=s.con.createStatement();
				
//				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
//				String date=birthday.getText();
//				Date da=format.parse(date);
//				String dat=format.format(da);
				
				String vue1=String.valueOf(number.getText().toCharArray());
				String vue2=String.valueOf(name.getText().toCharArray());
//				String vue3=String.valueOf(sex.getText().toCharArray());
//				String vue4=String.valueOf(classid.getText().toCharArray());
				String str="insert into ClassGather values"+"("+"'"+vue1+"'"+","+"'"+vue2+"'"+")";
				s.sta.executeUpdate(str);
				s.con.close();
				String j="插入成功";
				jieguo.setText(j);
			}catch(Exception j)
			{
				// TODO Auto-generated catch block
				String faildma = "插入失败";
				jieguo.setText(faildma);
				j.printStackTrace();
			}
			
			
		}
		if(e.getSource()==delete)
		{
			Shujuku ku=new Shujuku();
			try {
				ku.sta=ku.con.createStatement();
				String del=number.getText();
				String de="delete from ClassGather where classID="+del;
				ku.sta.executeUpdate(de);
				ku.con.close();
				String js="删除成功!!!";
				jieguo.setText(js);
			}catch(Exception a) {} 
			
		}
		if(e.getSource()==change)
		{
			Shujuku ju = new Shujuku();
			try {
				ju.sta=ju.con.createStatement();
				String up1;
				String up="update ClassGather set classID="+"'"+number.getText()+"'"+","+"classType="+
				"'"+name.getText()+"'"+" where classID="+"'"+jt.getText()+"'";
				ju.sta.executeUpdate(up);
				ju.con.close();
				String v="更改成功!!!";
				jieguo.setText(v);
			}catch(Exception m) {}
			
		}
		if(e.getSource()==fanhui)
		{
//			Student stu=new Student();
			Guanli gu = new Guanli();
			this.setExtendedState(JFrame.ICONIFIED);
		}
		
		
	}
}
