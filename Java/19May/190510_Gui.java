//Main

package Main;

import UI.UiTest;

public class GuiMain {
	
	public static void main(String [] args) {
		new UiTest();
	}
}


package UI;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UiTest extends JFrame implements ActionListener{ // 처음 설정 해 줘야함, ActionListener는 다중 상속이 가능함
	private JTextField textField; //여러 변수중에 유일하게 textField만 나와있음
	public UiTest() {
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(94, 27, 116, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uC774\uB984");
		lblNewLabel.setBounds(48, 28, 34, 18);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\uB4F1\uB85D");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(235, 26, 97, 23);
		getContentPane().add(btnNewButton);
		
    btnNewButton.addActionListener(this); //버튼과 리스너를 연결
    
    setDefaultCloseOperation(EXIT_ON_CLOSE); // 작성해야지 종료가 가능해짐
		setSize(387,220); // 크기 설정
		setVisible(true); //마지막에 작성
	}
  
  @Override
	public void actionPerformed(ActionEvent e) { //ActionListener의 모든 행종이 들어 있음
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("등록")) {// ActionListener에 무엇이 있나 확인 할 수있음
			System.out.println(textField.getText()); // 입력하고 등록을 누르면 그 값을 갖고와서 출력
			textField.setText("");
		}	
	}
}

/*Absolut Layout으로 범위 지정
Label, TextField, Button 등을 설정*/
