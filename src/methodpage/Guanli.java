package methodpage;
import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
public class Guanli extends JFrame implements ActionListener
{
//	ImageIcon ima=new ImageIcon("D:\\图片\\iii.jpg");
	private JPanel jp=new HomePanel1();
	JTextField zhanghao=new JTextField();//账号框
	JPasswordField mima=new JPasswordField();//密码框
	JLabel name=new JLabel("账号");
	JLabel password=new JLabel("密码");
	JLabel js[]= {name,password};
	JButton anniu1=new JButton("教师登录");
	JButton anniu2=new JButton("重置");
	JButton administrator = new JButton("管理员登录");
	JButton a[]= {anniu1,anniu2};
	JButton zhuce = new JButton("注册");
	//设置布局
		public Guanli()
		{
			jp.setLayout(null);
			zhanghao.setOpaque(false);
			mima.setOpaque(false);
			for(int i=0;i<2;i++)
			{
				js[i].setBounds(100,20+40*i,100,20);
				js[i].setFont(new Font("宋体",Font.PLAIN,16));
				jp.add(js[i]);
			}
			a[0].setBounds(100,100,200,30);
			a[0].setFont(new Font("宋体",Font.PLAIN,16));
			a[0].setForeground(Color.BLACK);
			a[0].setContentAreaFilled(false);
			a[0].addActionListener(this);
			jp.add(a[0]);
			a[1].setBounds(100,200,200,30);
			a[1].setFont(new Font("宋体",Font.PLAIN,16));
			a[1].setForeground(Color.BLACK);
			a[1].setContentAreaFilled(false);
			a[1].addActionListener(this);
			jp.add(a[1]);
			
			administrator.setBounds(100,150,200,30);
			administrator.setFont(new Font("宋体",Font.PLAIN,16));
			jp.add(administrator);
			administrator.setForeground(Color.BLACK);
			administrator.setContentAreaFilled(false);
			administrator.addActionListener(this);
			
			zhuce.setBounds(100,250,200,30);
			zhuce.setFont(new Font("宋体",Font.PLAIN,16));
			zhuce.setForeground(Color.black);
			zhuce.setContentAreaFilled(false);
			zhuce.addActionListener(this);
			jp.add(zhuce);
			
			zhanghao.setBounds(150,10,150,30);
			jp.add(zhanghao);
			zhanghao.addActionListener(this);
			mima.setBounds(150,60,150,30);
			jp.add(mima);
			mima.setEchoChar('*');
			mima.addActionListener(this);
			zhanghao.setFont(new Font("宋体",Font.BOLD,16));
			mima.setFont(new Font("宋体",Font.BOLD,16));
			this.add(jp);
//			getContentPane().add(jp); 
			this.setTitle("登录窗口");
			this.setBounds(400, 400, 400, 400);
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
			
		public void actionPerformed(ActionEvent e)
		{
			// TODO Auto-generated method stub
			if(e.getSource() == zhuce) {
				this.setExtendedState(JFrame.ICONIFIED);
				Zhuce zc = new Zhuce();
			}else {
				if(e.getSource()==zhanghao)
				{
					//如果事件源为文本切换焦点到密码框
					mima.requestFocus();
				}
				else if(e.getSource()==a[1])
				{
					//清空文本密码框，交点钱回到文本框
					zhanghao.setText("");
					mima.setText("");
					zhanghao.requestFocus();
				}
				else
				{
					if(e.getSource() == administrator) {
						Shujuku sk = new Shujuku();
						int flag = 0;
						try {
							sk.sta=sk.con.createStatement();
							sk.rs=sk.sta.executeQuery("select * from adminiinfo ");
							while(sk.rs.next()) {
								String str1=sk.rs.getString(1);
								String str2=sk.rs.getString(2);
								if(zhanghao.getText().equals(str1) && String.valueOf(mima.getPassword()).equals(str2))
								{
									flag = 1;
								}
							}
							if(flag == 0) {
								JOptionPane.showMessageDialog(null, "账号或密码错误", "错误提示", JOptionPane.ERROR_MESSAGE);
							}else {
								this.setExtendedState(JFrame.ICONIFIED);
								Classroom cs = new Classroom();
							}
						}catch(Exception a) {
							System.out.println("数据库读取失败");
							
						}
					}else {
						Shujuku sk = new Shujuku();
						int flag1 = 0;
						try {
							sk.sta=sk.con.createStatement();
							sk.rs=sk.sta.executeQuery("select * from teacherinfo ");
							while(sk.rs.next()) {
								String str1=sk.rs.getString(1);
								String str2=sk.rs.getString(2);
								if(zhanghao.getText().equals(str1) && String.valueOf(mima.getPassword()).equals(str2))
								{
									flag1 = 1;
								}
							}
							if(flag1 == 0) {
								JOptionPane.showMessageDialog(null, "账号或密码错误", "错误提示", JOptionPane.ERROR_MESSAGE);
							}else {
								this.setExtendedState(JFrame.ICONIFIED);
								TeacherControl tc = new TeacherControl();
							}
							
						}catch(Exception a) {
							System.out.println("数据库读取失败");
							
						}
					}
				}
			}
			
		}
		

	}

