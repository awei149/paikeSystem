package methodpage;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Zhuce extends JFrame implements ActionListener
{
	private JPanel jp=new HomePanel1();
	JTextField zhanghao=new JTextField();//账号框
	JPasswordField mima=new JPasswordField();//密码框
	JLabel name=new JLabel("账号");
	JLabel password=new JLabel("密码");
	JLabel js[]= {name,password};
	JButton teacher = new JButton("教师注册");
	JButton admini = new JButton("管理员注册");
	JButton arr[] = {teacher,admini};
	public Zhuce() {
		jp.setLayout(null);
		zhanghao.setOpaque(false);
		mima.setOpaque(false);
		zhanghao.setBounds(150,10,150,30);
		jp.add(zhanghao);
		zhanghao.addActionListener(this);
		mima.setBounds(150,60,150,30);
		jp.add(mima);
		mima.setEchoChar('*');
		mima.addActionListener(this);
		zhanghao.setFont(new Font("宋体",Font.BOLD,16));
		mima.setFont(new Font("宋体",Font.BOLD,16));
		for(int i = 0; i < 2; i ++) {
			js[i].setBounds(100,10+50*i,100,30);
			js[i].setFont(new Font("宋体",Font.PLAIN,16));
			jp.add(js[i]);
			arr[i].setBounds(30+160*i,120,150,30);
			arr[i].setFont(new Font("宋体",Font.PLAIN,16));
			arr[i].setForeground(Color.BLACK);
			arr[i].setContentAreaFilled(false);
			arr[i].addActionListener(this);
			jp.add(arr[i]);
		}
		this.add(jp);
		this.setTitle("注册窗口");
		this.setBounds(400, 400, 400, 250);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if(e.getSource() == arr[0]) {
			Shujuku ku = new Shujuku();
			try {
				ku.sta=ku.con.createStatement();
				
//				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
//				String date=birthday.getText();
//				Date da=format.parse(date);
//				String dat=format.format(da);
				
				String vue1=String.valueOf(zhanghao.getText().toCharArray());
				String vue2=String.valueOf(mima.getPassword());
//				String vue3=String.valueOf(sex.getText().toCharArray());
//				String vue4=String.valueOf(classid.getText().toCharArray());
				String str="insert into teacherinfo values"+"("+"'"+vue1+"'"+","+"'"+vue2+"'"+")";
				ku.sta.executeUpdate(str);
				ku.con.close();
				System.out.println("注册成功");
			}catch(Exception a) {
				System.out.print("注册失败");
				a.printStackTrace();
			}

		}else {
			Shujuku su = new Shujuku();
			try {
				su.sta=su.con.createStatement();
				String vue1=String.valueOf(zhanghao.getText().toCharArray());
				String vue2=String.valueOf(mima.getPassword());
//				String vue3=String.valueOf(sex.getText().toCharArray());
//				String vue4=String.valueOf(classid.getText().toCharArray());
				String str="insert into adminiinfo values"+"("+"'"+vue1+"'"+","+"'"+vue2+"'"+")";
				su.sta.executeUpdate(str);
				su.con.close();
				System.out.println("注册成功");
			}catch(Exception m) {
				System.out.print("注册失败");
				m.printStackTrace();
			}
		}
		
	}

}
