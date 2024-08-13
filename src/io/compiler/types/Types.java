package io.compiler.types;

public enum Types {
	INTEIRO(1),
	REAL(2),
	TEXTO(3);
	
	private int value;
	
	private  Types(int valueNumber) {
		this.value = valueNumber;
	}
	public Integer getValue() {
		return this.value;
	}
}
