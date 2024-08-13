package io.compiler.estruturas;

public class Variavel extends Simbolo {
	// public static final int INTEIRO = 0;
	// public static final int REAL   = 1;
	// public static final int TEXTO  = 2;
	
	private String nome;
	private int type;
	private boolean initialized;
	
	public Variavel(int varType, String varName, boolean initialized)
	{
		super();
		
		this.nome = varName;
		this.type = varType;
		this.initialized = initialized;
	}

	public Variavel(String varName)
	{
		super();
		
		this.nome = varName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean isInitialized() {
		return initialized;
	}
	
	public void setInitialized(boolean initialized) {
		this.initialized = initialized;
	}

	@Override
	public String toString()
	{
		return "Variavel{" +
				"name='" + name + '\'' +
				", initialized=" + initialized +
				", type=" + type +
				'}';
	}
}
