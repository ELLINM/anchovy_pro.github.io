import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingObserverExample {
	JFrame frame;
	
	public static void main(String [] args) {
		SwingObserverExample example = new SwingObserverExample();
		example.go();
	}
	
	public void go() {
		frame = new JFrame();
		JButton button = new JButton("정말 해도될까?");
		button.addActionListener(new AngelListener());
		button.addActionListener(new DevilListener());
		//AngelListener와 DevilListener를 Observer로 만듬
		frame.getContentPane().add(BorderLayout.CENTER, button);
		frame.setSize(200, 200);
		frame.setVisible(true);
	}
	
	
	//Observer Class들은 내부 class형태로 정의
	class AngelListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("안돼. nononono");
		}
	}
	
	class DevilListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("당연하지. gogogo");
		}
	}
	//여기에서는 주제의 상태가 변경 되었을 때 update()가 아닌 actionPerformed() Method가 
}
