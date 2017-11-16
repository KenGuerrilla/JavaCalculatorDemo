package itl.kenguerrilla;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UI extends JFrame {
	
	/**
	 * Test git remote rebase
	 * 
	 * add line for test remote
	 * 
	 * add line for test2 remote
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JMenuBar menuBar;
	private JMenu aboutMenu;
	private JMenuItem aboutMe;
	
	private String initLabel="0.";

	private JFrame frm = new JFrame("Java Calculator Beta01");
	
	private JPanel numberPanel = new JPanel(new GridLayout(4,3)); // 數字鍵
	private JPanel functionPanel = new JPanel(new GridLayout(5,1)); // 功能鍵
	
	private JLabel labProcess = new JLabel(initLabel, JLabel.RIGHT); // 運算過程
	private JLabel labResult = new JLabel(initLabel, JLabel.RIGHT); // 運算結果
	
	private JButton btnNumber[], btnDot, btnAdd, btnSub, btnMul, btnDiv, btnClear, btnEqual; 
	
	private Font font = new Font("細明體",Font.PLAIN,18);
	private Font sFont = new Font("細明體",Font.PLAIN,14);
	
	
	public UI(){
		
		initFrame();
		initLab();
		initKey();
		initAboutMenu();
		initMenuBar();
		
	}
	
	// init MenuBar
	private void initMenuBar() {
		// TODO Auto-generated method stub
		menuBar = new JMenuBar();
		menuBar.add(aboutMenu);
		frm.setJMenuBar(menuBar);
	}
	
	// init AboutMenu
	private void initAboutMenu() {
		// TODO Auto-generated method stub
		
		aboutMenu = new JMenu("關於");
		aboutMe = new JMenuItem("關於我");
		aboutMenu.add(aboutMe);
		
		aboutMe.addActionListener(event -> {
			JOptionPane.showOptionDialog(
					null,
					"由KenGuerrilla撰寫",
					"關於CalculatorDemo",
					JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE,
					null,
					null,
					null);
		});	

	}

	// init Frame
	private void initFrame() {
		// TODO Auto-generated method stub
		frm.setLayout(null);
		frm.setSize(245, 400);
		frm.getContentPane().setBackground(Color.GRAY);
		
		frm.setResizable(false);
		
		frm.add(labProcess);
		frm.add(labResult);
		frm.add(numberPanel);
		frm.add(functionPanel);
		
		frm.setVisible(true);
	}

	// init Label
	private void initLab() {
		// TODO Auto-generated method stub
		labProcess.setBounds(20, 40, 200, 30);
		labProcess.setOpaque(true); // 透明效果
		labProcess.setBackground(Color.WHITE); // 背景顏色
		labProcess.setForeground(Color.BLACK); // 前景顏色
		labProcess.setFont(sFont);
		
		labResult.setBounds(20, 70, 200, 30);
		labResult.setOpaque(true); // 透明效果
		labResult.setBackground(Color.WHITE); // 背景顏色
		labResult.setForeground(Color.BLACK); // 前景顏色
		labResult.setFont(font);
		
	}
	
	// init Number Button and Function Button
	private void initKey() {
		// TODO Auto-generated method stub
		functionPanel.setBounds(170,120,50,200);
		numberPanel.setBounds(20, 120, 150, 200);
		
		
		btnNumber = new JButton[10];
		
		for(int i = 1;i < 10; i++){
			btnNumber[i] = new JButton(String.valueOf(i));
		}
		
		for(int i = 1;i < 10; i++){
			numberPanel.add(btnNumber[i]).setFont(font);
		}
		
		btnNumber[0] = new JButton("0");
		btnDot = new JButton(".");
		btnEqual = new JButton("=");
		btnAdd = new JButton("+");
		btnSub = new JButton("-");
		btnMul = new JButton("*");
		btnDiv = new JButton("/");
		btnClear = new JButton("C");
		
		numberPanel.add(btnDot).setFont(font);
		numberPanel.add(btnNumber[0]).setFont(font);
		numberPanel.add(btnEqual).setFont(font);
		functionPanel.add(btnAdd).setFont(font);
		functionPanel.add(btnSub).setFont(font);
		functionPanel.add(btnMul).setFont(font);
		functionPanel.add(btnDiv).setFont(font);
		functionPanel.add(btnClear).setFont(font);
		
	}

	// set Listener
	public void setListener(ActionListener al) {
		
		for(int i = 1;i < 10; i++){
			btnNumber[i].addActionListener(al);
		}
		
		btnNumber[0].addActionListener(al);
		btnDot.addActionListener(al);
		btnAdd.addActionListener(al);
		btnSub.addActionListener(al);
		btnMul.addActionListener(al);
		btnDiv.addActionListener(al);
		btnEqual.addActionListener(al);
		btnClear.addActionListener(al);
		
	}

	
	public void setLabProcess(String s){
		
		labProcess.setText(s);
		
	}
	
	public void resetUI(){
		
		labProcess.setText(initLabel);
		labResult.setText(initLabel);
		
	}
	
	
	public void setLabResult(String s){
		
		labResult.setText(s);
		
	}

	
	public JButton getBut(int i) {
		return btnNumber[i];
	}

	public JButton getBtnDot() {
		return btnDot;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JButton getBtnSub() {
		return btnSub;
	}

	public JButton getBtnMul() {
		return btnMul;
	}

	public JButton getBtnDiv() {
		return btnDiv;
	}

	public JButton getBtnClear() {
		return btnClear;
	}

	public JButton getBtnEqual() {
		return btnEqual;
	}


	
	
	
}

	


