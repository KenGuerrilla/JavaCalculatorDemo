package itl.kenguerrilla;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UI extends JFrame implements ActionListener {
	
	/**
	 *  UI排版模組
	 */
	
	private static final long serialVersionUID = 1L;
	
	private JMenuBar menuBar;
	private JMenu aboutMenu;
	private JMenuItem menuAbout;

	JFrame frm = new JFrame("Java Calculator Beta01");
	
	JPanel number_pnl = new JPanel(new GridLayout(4,3)); // 數字鍵
	JPanel function_pnl = new JPanel(new GridLayout(5,1)); // 功能鍵
	
	JLabel process_lab = new JLabel("0. ", JLabel.RIGHT); // 運算過程
	JLabel result_lab = new JLabel("0. ", JLabel.RIGHT); // 運算結果
	
	JButton but[], btn_dot, btn_add, btn_sub, btn_mul, btn_div, btn_clear, btn_equal;
	
	String numbleKey[] = {"0","1","2","3","4","5","6","7","8","9"};
	
	boolean firstKeying = true;
	boolean keyingLocked = false;
	
	Font font = new Font("細明體",Font.PLAIN,18);
	
	Font sFont = new Font("細明體",Font.PLAIN,14);
	
	Calculator cal = new Calculator();
	
	//double sum =0,sumBuffer =0;
	
	
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
		menuAbout = new JMenuItem("關於JavaCalDemo");
		aboutMenu.add(menuAbout);
		
	}

	// init Frame
	private void initFrame() {
		// TODO Auto-generated method stub
		frm.setLayout(null);
		frm.setSize(245, 400);
		frm.getContentPane().setBackground(Color.GRAY);
		
		frm.setResizable(false);
		
		frm.add(process_lab);
		frm.add(result_lab);
		frm.add(number_pnl);
		frm.add(function_pnl);
		
		frm.setVisible(true);
	}


	// init Label
	private void initLab() {
		// TODO Auto-generated method stub
		process_lab.setBounds(20, 40, 200, 30);
		process_lab.setOpaque(true); // 透明效果
		process_lab.setBackground(Color.WHITE); // 背景顏色
		process_lab.setForeground(Color.BLACK); // 前景顏色
		process_lab.setFont(sFont);
		
		result_lab.setBounds(20, 70, 200, 30);
		result_lab.setOpaque(true); // 透明效果
		result_lab.setBackground(Color.WHITE); // 背景顏色
		result_lab.setForeground(Color.BLACK); // 前景顏色
		result_lab.setFont(font);
		
	}
	
	// init Number Button and Function Button
	private void initKey() {
		// TODO Auto-generated method stub
		function_pnl.setBounds(170,120,50,200);
		number_pnl.setBounds(20, 120, 150, 200);
		
		/*
		for(int i = 1;i <=9; i++){
			number_pnl.add(new JButton(Integer.toString(i))).setFont(font);
		}
		
		*/
		
		
		but = new JButton[10];
		
		for(int i = 1;i < 10; i++){
			but[i] = new JButton(String.valueOf(i));
		}
		
		
		for(int i = 1;i < 10; i++){
			number_pnl.add(but[i]).setFont(font);
			but[i].addActionListener(this);
			
		}
		
		but[0] = new JButton("0");
		btn_dot = new JButton(".");
		btn_equal = new JButton("=");
		btn_add = new JButton("+");
		btn_sub = new JButton("-");
		btn_mul = new JButton("*");
		btn_div = new JButton("/");
		btn_clear = new JButton("C");
		
		but[0].addActionListener(this);
		btn_dot.addActionListener(this);
		btn_equal.addActionListener(this);
		btn_add.addActionListener(this);
		btn_sub.addActionListener(this);
		btn_mul.addActionListener(this);
		btn_div.addActionListener(this);
		btn_clear.addActionListener(this);
		
		
		number_pnl.add(btn_dot).setFont(font);
		number_pnl.add(but[0]).setFont(font);
		number_pnl.add(btn_equal).setFont(font);
		function_pnl.add(btn_add).setFont(font);
		function_pnl.add(btn_sub).setFont(font);
		function_pnl.add(btn_mul).setFont(font);
		function_pnl.add(btn_div).setFont(font);
		function_pnl.add(btn_clear).setFont(font);
		

		

		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		final Object source = e.getSource();
		
		if(firstKeying == true){
			process_lab.setText("");
			result_lab.setText("");
			firstKeying = false;
		}
		
		
		//boolean keyingLocked = false;
		for(int i=0; i<10;i++){	
			if(source == but[i]){
				
				if(keyingLocked){
					
				}
				process_lab.setText(process_lab.getText() + numbleKey[i]);
				result_lab.setText(result_lab.getText() + numbleKey[i]);
			}
	
		}
		
		if(source == btn_dot){
		
		}
		
		if(source == btn_add){
						
			process_lab.setText(process_lab.getText() +"+");
			
			writer(cal.checkIn(Calculator.actionMode.Add, reader()));
			
		}
			
		if(source == btn_sub){
			
			process_lab.setText(process_lab.getText() +"-");
			//cal.functionAct(actionMod.Sub, reader());

		}
		
		if(source == btn_mul){
			
			process_lab.setText(process_lab.getText() +"*");
			//cal.functionAct(actionMod.Mul, reader());
			
		}
		
		if(source == btn_div){
			
			process_lab.setText(process_lab.getText() +"/");
			//cal.functionAct(actionMod.Div, reader());

		}
		
		
		if(source == btn_clear){

		}
		
		if(source == btn_equal){
			
			
			writer(cal.anser(reader()));		
			
			cal.show();
			
		}
	}
	
	private Double reader(){
		
		String str = result_lab.getText();
		
		Double buf = Double.valueOf(str);
		
		result_lab.setText("");
		
		return buf;
	}
	
    public void writer(final Double num) {
        if (Double.isNaN(num)) {
            result_lab.setText("");
        } else {
        	result_lab.setText(Double.toString(num));
        }
}
	

}

	


