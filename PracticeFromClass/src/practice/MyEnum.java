package practice;

public enum MyEnum {

	RED("STOP"), ORANGE("SLOW DOWN"), GREEN("GO");
	
	private String action; 
	
	public String getAction() {
		return this.action; 
	}

	MyEnum(String action) {
		this.action = action; 
	}

}
