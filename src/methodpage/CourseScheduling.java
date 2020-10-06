package methodpage;
import java.util.ArrayList;
import java.util.Iterator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CourseScheduling extends JFrame implements ActionListener{
	private JPanel jp=new HomePanel1();
	JButton button1 = new JButton("开始排课");
	JButton button2 = new JButton("查看排课信息");
	JButton button3 = new JButton("返回继续排课");
	JButton button[] = {button1,button2,button3};
	JTextArea info = new JTextArea();
	String classroomID;//教室编号
	String classroomName;//教室类型
	String courseName;//课程名称
	String TeacherName;//教师姓名
	String TeacherID;//教师编号
	String classID;//班级编号
	String className;//班级名称
	int n;//每周几节
	int num1;
	int num2;
	int course[] = new int[2];
	Shujuku sk;
	ArrayList<ArrayList<String> > list = new ArrayList<ArrayList<String> >();
//	ArrayList<ArrayList<String> > list1 = new ArrayList<ArrayList<String> >();
	ClassroomGather cg;
//	Thacherinfo ta = new Thacherinfo();
	public CourseScheduling(){
		jp.setLayout(null);
		for(int i = 0; i < 3; i ++) {
			button[i].setBounds(150, 300+50*i, 150, 30);
			button[i].setFont(new Font("宋体",Font.PLAIN,16));
			button[i].setForeground(Color.black);
			button[i].setContentAreaFilled(false);
			button[i].addActionListener(this);
			jp.add(button[i]);
		}
		
		info=new JTextArea();
		info.setFont(new Font("宋体",Font.PLAIN,20));
		info.setOpaque(false);
		info.setBounds(125,10,200,250);
		jp.add(info);
		
//		 button.addActionListener(this);
//		 jp.add(button);
		 this.add(jp);
		 this.setTitle("准备排课信息表");
		 this.setBounds(550, 500, 450, 500);
		 this.setVisible(true);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		classID = ta.classid.getText();//获取班级编号
//		className = ta.classname.getText();//获取班级名称
//		TeacherName = ta.teachername.getText();//获取教师名字
//		TeacherID = ta.teacherid.getText();//获取教师id
//		courseName = ta.kemu.getText();//获取课程名字
//		n = Integer.parseInt(ta.num.getText());//获取每周多少节
	}
	public void coverText(){
		String info1 = "班级编号:"+classID+"\n"+"班级名称:"+className+"\n"+"教师id:"+TeacherID+"\n"+"教师姓名:"+TeacherName+"\n"+"所教课程:"+courseName+"\n"+"每周几节:"+n+"\n"+"教室类型:"+classroomName;
		info.setText(info1);
	}
	//生成随机数来表示教师的课在第几周和第几节
	public int mathcourse(){
		int n1 = (int)(Math.random()*5 + 1);//课排在第几周
		int n2 = (int)(Math.random()*10 + 1);//课排在第几节
		course[0] = n1;
		course[1] = n2;
		System.out.println("周"+n1+"第"+n2+"节");
		sk.judge(n1, n2,TeacherID,TeacherName);
		sk.judgeIsClass(n1, n2, classID, className);
		if(sk.flag == 1 || sk.flag1 == 1) {
			System.out.println("当前时间该教师已经有课或当前该班级已经有课,继续使用递归算法继续排课");
			return mathcourse();
		}else {
//			return course;
			return 0;
		}
	}
	//获取上课教室方法
	public String getClassroom(int num1, int num2){
//		int n = 0;//用于统计教室的数目
		System.out.print("教室:"+classroomName);
		int n1 = sk.backClassroom(classroomName,num1,num2).size();
		System.out.print("n1:");
		System.out.println(n1);
		int radomNum = (int) (Math.random()*n1);//生成随机数用于读取教室数组的索引
		System.out.println("radomNum:" + radomNum);
		return sk.list.get(radomNum);
	}
	//排一节课
	public ArrayList<ArrayList<String> > oneclass(){
		mathcourse();
		ArrayList<String> s1 = new ArrayList<String>();//创建一个动态数组用于存放排课信息
		String str1 = Integer.toString(course[0]);//将第几周转化为String类型
		String str2 = Integer.toString(course[1]);//将第几节转化为String类型
//		s1.add(str1);//将周存入s1数组中
//		s1.add(str2);//将节存入s1数组中
//		s1.add(courseName);//将课程名字存入s1数组中
		String room = getClassroom(course[0],course[1]);
		if(sk.flag2 == 1){
			System.out.println("未能获取到教室，使用递归算法继续排课");
			return oneclass();
		}else {
			s1.add(str1);//将周存入s1数组中
			s1.add(str2);//将节存入s1数组中
			s1.add(courseName);//将课程名字存入s1数组中
			s1.add(room);//将教室存入s1数组中
			s1.add(className);
			list.add(s1);//将s1数组存入list数组中
//			list1.add(s1);//将s1数组存入list1数组中
			System.out.println(list);
			sk.InsertClassInfo(str1,str2,courseName,room, TeacherName, TeacherID, classID, className, classroomName);
			System.out.println("成功排课一次");
			return list;
		}
	}
	//排课方法
	public void courseScheduling(){
		for(int i = 0; i < n; i ++){
			oneclass();
//			System.out.println("开始清除list");
//			list.get(0).clear();
//			list.clear();
			System.out.println("开始清除数据库里面的list");
			sk.list.clear();//清楚每次lisi里面的教室集合
			System.out.println("清楚完成");
		}
		sk.i = 0;
		info.setText("排课完成");
		System.out.println(list);
//		sk.InsertClassInfo(list, TeacherName, TeacherID, classID, className, classroomName, n);
		
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==button[0]) {
			info.setText("排课所需时间较长请稍等....");
			System.out.println(TeacherName);
			sk = new Shujuku();
			courseScheduling();
			sk.judgeClassrooom();
		}else if(e.getSource()==button[1]) {
			this.setExtendedState(JFrame.ICONIFIED);
			Timetable tm = new Timetable();
			tm.courseTable(list);
		}else {
			this.setExtendedState(JFrame.ICONIFIED);
			Thacherinfo ta = new Thacherinfo();
		}
		
	}
}
