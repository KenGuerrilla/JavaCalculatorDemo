package itl.kenguerrilla;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UI extends JFrame implements ActionListener {
	
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
	
	private String resultBuffer="";
	private String keyingBuffer="";
	private String initLabel="0.";

	JFrame frm = new JFrame("Java Calculator Beta01");
	
	JPanel numberPanel = new JPanel(new GridLayout(4,3)); // 數字鍵
	JPanel functionPanel = new JPanel(new GridLayout(5,1)); // 功能鍵
	
	JLabel labProcess = new JLabel(initLabel, JLabel.RIGHT); // 運算過程
	JLabel labResult = new JLabel(initLabel, JLabel.RIGHT); // 運算結果
	
	JButton but[], btnDot, btnAdd, btnSub, btnMul, btnDiv, btnClear, btnEqual;
	
	String numberKey[] = {"0","1","2","3","4","5","6","7","8","9"};
	
	
	Font font = new Font("細明體",Font.PLAIN,18);
	
	Font sFont = new Font("細明體",Font.PLAIN,14);
	
	Calculator cal = new Calculator();
	
	
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
		
		
		but = new JButton[10];
		
		for(int i = 1;i < 10; i++){
			but[i] = new JButton(String.valueOf(i));
		}
		
		for(int i = 1;i < 10; i++){
			numberPanel.add(but[i]).setFont(font);
			but[i].addActionListener(this);
			
		}
		
		but[0] = new JButton("0");
		btnDot = new JButton(".");
		btnEqual = new JButton("=");
		btnAdd = new JButton("+");
		btnSub = new JButton("-");
		btnMul = new JButton("*");
		btnDiv = new JButton("/");
		btnClear = new JButton("C");
		
		but[0].addActionListener(this);
		btnDot.addActionListener(this);
		btnEqual.addActionListener(this);
		btnAdd.addActionListener(this);
		btnSub.addActionListener(this);
		btnMul.addActionListener(this);
		btnDiv.addActionListener(this);
		btnClear.addActionListener(this);
		

		numberPanel.add(btnDot).setFont(font);
		numberPanel.add(but[0]).setFont(font);
		numberPanel.add(btnEqual).setFont(font);
		functionPanel.add(btnAdd).setFont(font);
		functionPanel.add(btnSub).setFont(font);
		functionPanel.add(btnMul).setFont(font);
		functionPanel.add(btnDiv).setFont(font);
		functionPanel.add(btnClear).setFont(font);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		final Object source = e.getSource();
		
		for(int i=0; i<10;i++){	
			if(source == but[i]){
				keyingNumber(String.valueOf(i));
				showBuffer();
			}
		}
		
		if(source == btnDot){
		
			keyingNumber(".");
			showBuffer();
			
		}
		
		if(source == btnAdd){
			
			writer(Calculator.actionMode.Add);

		}
			
		if(source == btnSub){
			
			writer(Calculator.actionMode.Sub);

		}
		
		if(source == btnMul){

			writer(Calculator.actionMode.Mul);
			
		}
		
		if(source == btnDiv){

			writer(Calculator.actionMode.Div);

		}
		
		if(source == btnClear){
			
			resetUI();
			
		}
		
		if(source == btnEqual){
			
			writer(Calculator.actionMode.None);
			
		}
		
	}
	
	private void keyingNumber(String s) {
		// TODO Auto-generated method stub
		
		keyingBuffer += s;
		labResult.setText(keyingBuffer);
		
	}


	private void writer(Calculator.actionMode mode){
				
		resultBuffer = cal.checkIn(keyingBuffer, mode);
		setLabel();
		showBuffer();
		
	}
	
	private void setLabel(){
		
		keyingBuffer="";
		labResult.setText(resultBuffer);
		labProcess.setText(cal.getProcessString());
	}
	
	private void resetUI(){
		
		cal.reset();
		keyingBuffer = "";
		resultBuffer ="";
		labProcess.setText(initLabel);
		labResult.setText(initLabel);
		showBuffer();
		
	}
    
    private void showBuffer(){
    	System.out.println("-----------UI-----------");
    	System.out.print("resultBuffer:"+resultBuffer);
    	System.out.println(" keyingBuffer:"+keyingBuffer);
    	System.out.println("------------------------");
    	
    }
	

}

	


