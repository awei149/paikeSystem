package methodpage;

import java.sql.*;

import java.util.ArrayList;

public class Shujuku
{
	ArrayList<String> list = new ArrayList<String>();
	ArrayList<ArrayList <String>> table= new ArrayList<ArrayList <String>>();
	Connection con=null;
	Connection con1=null;
	ResultSet rs;
	ResultSet rs1;
	Statement sta=null;
	Statement sta1=null;
	PreparedStatement pre;
	int flag;
	int flag1;
	int flag2;
	int i = 0;
	int flag3;
	public Shujuku() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//加载数据库驱动
			System.out.println("Success");
		}catch(Exception e) {
			System.out.println("失败");
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classinfo?characterEncoding=utf8&useSSL=false&serverTimezone=UTC","root","woaijia3344");
			System.out.println("Success aaa");
//			Statement stmt = connec.createStatement();
//			ResultSet rs = stmt.executeQuery("select * from peopelinfo");
//			while(rs.next()) {
//				System.out.println("id: "+rs.getString(2));
//			}
		}catch(Exception e) {
			System.out.println("失败111");
			e.printStackTrace();
		}
	}
	//判断当前时间教师是否已有课
	public void judge(int str1, int str2, String str3, String teachername){
//		String str = new String();
//		String id = "A212";
		try{
			System.out.println("开始读取数据库");
			sta = con.createStatement();
			System.out.println("开始查询教师信息");
//			rs = sta.executeQuery("select teacherID from classtable where severalWeek = "+"'"+str1+"'"+ " " +"and section = "+"'"+str2+"'");
			rs = sta.executeQuery("select teacherName from classtable where teacherID="+"'"+str3+"'"+" and severalWeek="+str1+" and section="+str2);
			System.out.println("查询语句：select teacherName from classtable where teacherID="+"'"+str3+"'"+" and severalWeek="+str1+" and section="+str2);
			System.out.println("查询成功");
//			while(rs.next()){
//				System.out.println("啊啊啊啊");
//				String str = rs.getString(1);
//				if(str.equals(teachername)) {
//					System.out.println("flag值1");
//					flag = 0;
//				}else {
//					flag = 1;
//					System.out.println("flag值0");
//				}
//				System.out.println("flag:"+flag);
//				System.out.println("姓名:"+str);
//			}
			if(rs.next()) {
				String str = rs.getString(1);
				System.out.println("姓名:"+str);
				flag = 1;
			}else {
				flag = 0;
				System.out.println("当前教师没有课程");
			}
			System.out.println("flag:"+flag);
//			con.close();
		}catch(Exception a){
			System.out.println("数据库读取教师id失败");
		}
//		return str;
	}
	//关闭数据库
	public void judgeClassrooom(){
		try {
			con.close();
//			con1.close();
			System.out.println("成功关闭数据库");
		}catch(Exception e) {
			System.out.println("关闭数据库失败");
		}
	}
	//判断当前时间该班级是否已有课
	public void judgeIsClass(int num1, int num2, String str, String classname){
		try{
			sta = con.createStatement();
			System.out.println("开始查询当前班级是否有课");
			rs = sta.executeQuery("select className from classtable where severalWeek = "+num1+" and section = "+num2+" and classID = '"+str+"'");
//			System.out.println("select className from classtable where severalWeek = "+num1+" and section = "+num2+" and classID = '"+str+"'");
//			while(rs.next()) {
//				String name = rs.getString(1);
//				if(name.equals(classname)) {
//					flag1 = 0;
//				}else {
//					flag1 = 1;
//				}
//				System.out.print("flag1:");
//				System.out.println(flag1);
//				System.out.println(name);
//			}
			if(rs.next()) {
				flag1 = 1;
				System.out.println("当前班级已有课程");
			}else {
				System.out.println("当前班级没有课程");
				flag1 = 0;
			}
			System.out.print("flag1:");
			System.out.println(flag1);
//			con.close();
		}catch(Exception a){
			System.out.println("判断当前班级是否有课，数据库读取失败121");
		}
	}
	//获取教室集合
	public ArrayList<String> backClassroom( String str, int num1, int num2){
		try{
			System.out.println("开始获取教室集合");
			sta = con.createStatement();
			sta1 = con.createStatement();
			rs = sta.executeQuery("select classID from classgather where classType = "+"'"+str+"'");
			while(rs.next()){
				String s = rs.getString(1);
//				list.add(s);
				System.out.println(s);
				rs1 = sta1.executeQuery("select className from classtable where classRoomID = "+"'"+s+"' and severalWeek = "+num1+" and section = "+num2);
//				while(rs1.next()) {
//					if(rs1.getInt(1) == 0) {
//						System.out.println("成功获取一个教室");
//						list.add(s);
//					}
//				}
				if(rs1.next()) {
					System.out.println("获取到一个教室"+s+",但已有班级使用");
				}else {
					System.out.println("获取到一个当前时间无人使用的教室");
					list.add(s);
				}
			}
//			flag2 = 1;
//			con.close();
		}catch(Exception a){
			flag2 = 1;
			System.out.println("教室集合获取失败");
		}
		if(list.size() > 0) {
			System.out.println("获取教室集合成功");
			flag2 = 0;
		}else {
			System.out.println("当前时间已无所需教室");
			flag2 = 1;
		}
		System.out.println(list);
		return list;
	}
	//将排课信息插入数据库
	public void InsertClassInfo(String str1,String str2, String courseName,String classroomid, String TeacherName, String TeacherID, String classID, String className, String classroomName){
		try {
			System.out.println("开始插入信息");
//			System.out.println(listinfo.get(0).get(0)+TeacherName);
			sta = con.createStatement();
//			System.out.println("n:"+n);
//			for(int i = 0; i < n; i++) {
//				System.out.println("开始插入第"+i+"条数据");
//				String strsql = "insert into classtable values ('"+classID+"','"+className+"','"+TeacherID+"','"+TeacherName+"',"+listinfo.get(i).get(0).toString()+","+listinfo.get(i).get(1).toString()+",'"+listinfo.get(i).get(2)+"','"+listinfo.get(i).get(3)+"','"+classroomName+"')";
//				System.out.println("sql语句:"+strsql);
//				System.out.println("开始执行sql语句");
//				sta.executeUpdate(strsql);
//				System.out.println("成功插入"+(i+1)+"次");
//			}
			System.out.println("开始插入第"+i+"条数据");
			String strsql = "insert into classtable values ('"+classID+"','"+className+"','"+TeacherID+"','"+TeacherName+"',"+str1+","+str2+",'"+courseName+"','"+classroomid+"','"+classroomName+"')";
			System.out.println("sql语句:"+strsql);
			System.out.println("开始执行sql语句");
			sta.executeUpdate(strsql);
			System.out.println("成功插入1次");
			i ++;
//			con.close();
			
		}catch(Exception e) {
			System.out.println("插入信息失败");
		}
		
	}
	//查询教师课程
	public ArrayList<ArrayList <String>> SelectTeacher(String str) {
		try {
			sta = con.createStatement();
			rs = sta.executeQuery("select severalWeek, section, courseName, classroomID, className from classtable where teacherID = "+"'"+str+"'" );
			while(rs.next()) {
				ArrayList<String> s1 = new ArrayList<String>();
				String severalweek = rs.getString(1);
				s1.add(severalweek);
				String section = rs.getString(2);
				s1.add(section);
				String coursename = rs.getString(3);
				s1.add(coursename);
				String classroomid = rs.getString(4);
				s1.add(classroomid);
				String classname = rs.getString(5);
				s1.add(classname);
				table.add(s1);
				flag3 = 1;
			}
			System.out.println(table);
		}catch(Exception e) {
			flag3 = 0;
			System.out.println("查询失败");
		}
		return table;
	}
	//查询班级课程
	public ArrayList<ArrayList <String>> SelectStudent(String str) {
		try {
			sta = con.createStatement();
			rs = sta.executeQuery("select severalWeek, section, courseName, classroomID, teacherName from classtable where classID = "+"'"+str+"'" );
			while(rs.next()) {
				ArrayList<String> s1 = new ArrayList<String>();
				String severalweek = rs.getString(1);
				s1.add(severalweek);
				String section = rs.getString(2);
				s1.add(section);
				String coursename = rs.getString(3);
				s1.add(coursename);
				String classroomid = rs.getString(4);
				s1.add(classroomid);
				String teachername = rs.getString(5);
				s1.add(teachername);
				table.add(s1);
				flag3 = 1;
			}
			System.out.println(table);
		}catch(Exception e) {
			flag3 = 0;
			System.out.println("查询失败");
		}
		return table;
	}
}
