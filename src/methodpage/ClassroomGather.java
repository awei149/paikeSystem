package methodpage;
import java.util.ArrayList;
import java.sql.*;
public class ClassroomGather {
//	ArrayList<ArrayList<String> > list=new ArrayList<ArrayList<String> >();
	ArrayList<String> list = new ArrayList<String>();
	Shujuku sk = new Shujuku();
	int flag = 0;
	ResultSet rs1;
	public ClassroomGather(){
		
	}
	//获取教室集合
	public ArrayList backClassroom( String str, int num1, int num2){
		try{
			sk.sta = sk.con.createStatement();
			sk.rs = sk.sta.executeQuery("select classID from classgather where classType = "+str);
			while(sk.rs.next()){
				String s = sk.rs.getString(1);
				System.out.print(s);
				rs1 = sk.sta.executeQuery("select ifnull((select classRoomName  from classtable where classRoomID = "+"'"+s+"'"+" and severalWeek = "+"'"+num1+"'"+" and section = "+"'"+num2+"'"+ "limit 1 ), 0)");
				if(rs1.getInt(1) == 0){
					list.add(s);
					System.out.println("成功获取到一个教室");
				}
			}
			System.out.println("获取教室集合成功");
			flag = 1;
		}catch(Exception a){
			System.out.println("教室集合获取失败");
		}
		System.out.println(list);
		return list;
	}
	public void putclass(){
		System.out.println(list);
	}
}
