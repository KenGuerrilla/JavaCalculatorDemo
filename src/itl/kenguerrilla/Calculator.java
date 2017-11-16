package itl.kenguerrilla;

public class Calculator {

	private Double sum;
	private String keyingLog=""; // �����p��L�{
	private actionMode mode; //���󪺪��A

	public enum actionMode{
		Add,Sub,Mul,Div,None;	
	}
	
	Calculator(){
		sum = 0.0;
		mode = actionMode.None;
	}
	
	// �ǤJ�ǥX���ƭȬҬ�Double
	// �z�L���󥻨���mode���A�i��P�_�P�p��
	// �Ѽƭp���n�ήɦ^�ǥثe�����G

	public Double checkIn(Double num,actionMode newMode){
		
		if(num.isNaN()){ // �קK�ǤJcal�r�ꬰ�Ŧӵo�ͪ����~
			mode = newMode;
			return Double.NaN;
		}
		else{
			calcula(num);
			mode = newMode;
			show();
			return sum;
		}
				
	}
	
	public String checkIn(String num,actionMode newMode){
		
		if(num==""){ // �קK�ǤJcal�r�ꬰ�Ŧӵo�ͪ����~
			mode = newMode;
			return checkType(sum);
		}
		else{
			calcula(Double.valueOf(num));
			mode = newMode;
			show();
			return checkType(sum);
		}
	}
	
	
	private String checkType(Double sum){
		
		if(sum%1==0){
			//System.out.println("�ഫDouble");
			return String.valueOf(sum.intValue());
		}
		else{
			//System.out.println("���ഫDouble");
			return String.valueOf(sum);
		}

	}
	
	
	private void calcula(Double d){
	
		switch(mode){
		
			case None:
				keyingRecord(checkType(d));
				sum = d;
				break;
				
			case Add:
				keyingRecord("+"+checkType(d));
				sum += d;
				break;				
				
			case Sub:
				keyingRecord("-"+checkType(d));
				sum -= d;
				break;
				
			case Mul:
				keyingRecord("*"+checkType(d));
				sum *= d;
				break;	
				
			case Div:
				keyingRecord("/"+checkType(d));
				sum /= d;
				break;
				
			default:
				throw new Error();		
		}
			 
	}
	
	private void keyingRecord(String s){
		
		keyingLog += s;
		
	}
	
	public String getKeyingLog(){
		
		return keyingLog;
	}
	
	public actionMode getMode(){
		return mode;
	}
	
	public String getResult(){
		
		mode = actionMode.None;
		show();
		return checkType(sum);
	}
	
	public void reset(){
		
        sum = 0.0;
        keyingLog ="";
        mode = actionMode.None;
        show();
        
	}
	
	public void show(){
		System.out.println("-----------Calculator-----------");
		System.out.println("mode="+mode+", keyingLog="+keyingLog);
		System.out.println("--------------------------------");
	}


}
