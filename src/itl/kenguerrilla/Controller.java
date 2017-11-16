package itl.kenguerrilla;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller {

	private Calculator modelCalculator = new Calculator();
	private UI viewUI = new UI();
	
	private String keyingBuffer="";
	private String resultBuffer="";
	
	Controller(){
		
		viewUI.setListener(new ViewListener());
		
	}
	
	private void keyingNumber(String s){
		
		keyingBuffer += s;
		viewUI.setLabResult(keyingBuffer);
		
	}
	
	private void writer(Calculator.actionMode mode){
		
		resultBuffer = modelCalculator.checkIn(keyingBuffer, mode);
		viewUI.setLabProcess(modelCalculator.getKeyingLog());
		viewUI.setLabResult(resultBuffer);
		keyingBuffer="";
		showBuffer();
		
	}
	
	private void reset() {
		
		modelCalculator.reset();
		viewUI.resetUI();
		keyingBuffer="";
		resultBuffer="";
		
	}
	
    private void showBuffer(){
	System.out.println("-----------UI-----------");
	System.out.print("resultBuffer:"+resultBuffer);
	System.out.println(" keyingBuffer:"+keyingBuffer);
	System.out.println(" Calculaotr Mode:"+modelCalculator.getMode());
	System.out.println("------------------------");
}
	
	


	class ViewListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			final Object source = e.getSource();
			
			for(int i=0; i<10;i++){	
				if(source == viewUI.getBut(i)){
					
					keyingNumber(String.valueOf(i));

				}
			}
			
			if(source == viewUI.getBtnDot()){
			
				keyingNumber(".");
			
			}
			
			if(source == viewUI.getBtnAdd()){	
				
				writer(Calculator.actionMode.Add);
				
			}
				
			if(source == viewUI.getBtnSub()){
				
				writer(Calculator.actionMode.Sub);
				
			}
			
			if(source == viewUI.getBtnMul()){

				writer(Calculator.actionMode.Mul);
				
			}
			
			if(source == viewUI.getBtnDiv()){

				writer(Calculator.actionMode.Div);

			}
			
			if(source == viewUI.getBtnClear()){

				reset();

			}
			
			if(source == viewUI.getBtnEqual()){

				writer(Calculator.actionMode.None);
				
			}
			
		}

	}
	
}


