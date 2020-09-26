package practice;

public enum MyEnum {

	RED("STOP"), ORANGE("SLOW DOWN"), GREEN("GO");

	 String action;

	String getAction() {
		return this.action;
	}

	MyEnum(String action) {
		this.action = action;
	}

	public static void main(String[] args) {
		for (MyEnum e : MyEnum.values()) {
			System.out.println(e.name() + " : " + (e.action));
		}
	}

}
