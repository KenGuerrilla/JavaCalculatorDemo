package itl.kenguerrilla;

public class Calculator {
	
	
//#######################
//
//	º»Æ…¿¡∏m 
//
//#######################
	
	private Double sum1=0.0,buffer=0.0;
	private actionMode mode = actionMode.None;
	
	
	public enum actionMode{
		Add,Sub,Mul,Div,None		
	}
	
	
	public void show(){
		
		System.out.println("Status: sum1="+sum1+", mode@@@="+mode);
	}
	
	public Double checkIn(actionMode newMode,Double num){
		
		if(mode == actionMode.None){
			
			sum1 = num;
			mode = newMode;
			System.out.println("num="+num);
			return Double.NaN;
			
		}
		else{
			buffer = num;
			sum1 = functionAct();
			mode = newMode;
			return sum1;
			
		}
		
	}
	
	
	public Double functionAct(){
		
		show();
		
		switch(mode){
			
			case Add:
				System.out.println("num="+buffer);
			return sum1 += buffer;
			
			case Sub:
				System.out.println("num="+buffer);
			return sum1 -= buffer;

			
			case Mul:
				System.out.println("num="+buffer);
			return sum1 *= buffer;

			
			case Div:
				System.out.println("num="+buffer);
			return sum1 /= buffer;
			
			default:

			throw new Error();

		}
	}
	
	public Double reset(){
		
        sum1 = 0.0;
        buffer = 0.0;
        mode = actionMode.None;

        return Double.NaN;
	}
	
	
	public Double anser(Double num){
		
		return checkIn(actionMode.None, num);
	}
	



}
