package io.compiler.estruturas;

public enum Tipos {
	INTEIRO(1),
	REAL(2),
	TEXTO(3);
	
	private int value;
	
	private Tipos(int valueNumber) {
		this.value = valueNumber;
	}
	public Integer getValue() {
		return this.value;
	}
}
