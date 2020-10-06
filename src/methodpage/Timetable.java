package methodpage;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
public class Timetable extends JFrame
{
	private JPanel jp=new HomePanel1();
	JLabel monday = new JLabel("周一");
	JLabel tuesday = new JLabel("周二");
	JLabel wednesday = new JLabel("周三");
	JLabel thursday = new JLabel("周四");
	JLabel friday = new JLabel("周五");
	JLabel saturday = new JLabel("周六");
	JLabel sunday = new JLabel("周日");
	JLabel week[] = {monday,tuesday,wednesday,thursday,friday,saturday,sunday};
	JLabel one = new JLabel("第一节");
	JLabel two = new JLabel("第二节");
	JLabel three = new JLabel("第三节");
	JLabel four = new JLabel("第四节");
	JLabel five = new JLabel("第五节");
	JLabel six = new JLabel("第六节");
	JLabel seven = new JLabel("第七节");
	JLabel eight = new JLabel("第八节");
	JLabel nine = new JLabel("第九节");
	JLabel ten = new JLabel("第十节");
	JLabel eleven = new JLabel("第十一节");
	JLabel time[] = {one, two, three, four, five, six, seven, eight, nine, ten, eleven};
	JTextArea [][]arr = new JTextArea[7][11];
	Border border = BorderFactory.createLineBorder(Color.BLACK); 
	public Timetable() {
		jp.setLayout(null);
		for(int i = 0; i < 7; i ++) {
			for(int j = 0; j < 11; j ++) {
				JTextArea jf = new JTextArea();
				arr[i][j] = jf;
				arr[i][j].setBounds(120 + 200 * i,30 + 80 * j,200,80);
				arr[i][j].setBorder(BorderFactory.createCompoundBorder(border, 
					      BorderFactory.createEmptyBorder(10, 10, 10, 10)));
				arr[i][j].setOpaque(false);
				arr[i][j].setFont(new Font("宋体",Font.BOLD,14));
				jp.add(arr[i][j]);
			}
			
		}
		for(int i = 0; i < week.length; i ++) {
			week[i].setBounds(120+200*i,5,200,30);
			week[i].setFont(new Font("宋体",Font.PLAIN,16));
			week[i].setHorizontalAlignment(JTextField.CENTER);
			jp.add(week[i]);
		}
		for(int i = 0; i < time.length; i ++) {
			time[i].setBounds(20,30+80*i,100,80);
			time[i].setFont(new Font("宋体",Font.BOLD,16));
			time[i].setHorizontalAlignment(JTextField.CENTER);
			jp.add(time[i]);
		}
		this.add(jp);
		this.setTitle("课程表窗口");
		this.setBounds(50, 50, 1600, 1000);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void courseTable(ArrayList<ArrayList<String> > list) {
		for(int i = 0; i < list.size(); i++) {
			arr[Integer.parseInt(list.get(i).get(0))-1][Integer.parseInt(list.get(i).get(1))-1].setText(list.get(i).get(2)+"("+list.get(i).get(3)+")"
					+"\n"+"("+list.get(i).get(4)+")");
		}
	}
	public void teachercourseTable(ArrayList<ArrayList<String> > list) {
		for(int i = 0; i < list.size(); i++) {
			arr[Integer.parseInt(list.get(i).get(0))-1][Integer.parseInt(list.get(i).get(1))-1].setText(list.get(i).get(2)+"("+list.get(i).get(3)+")"
					+"\n"+"("+list.get(i).get(4)+")");
		}
	}
}
