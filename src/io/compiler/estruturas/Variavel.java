package io.compiler.estruturas;

import java.util.Objects;

import io.compiler.core.exceptions.*;

public class Variavel extends Simbolo {

	public static final int INTEIRO = 0;
	public static final int REAL   = 1;
	public static final int TEXTO  = 2;
	
	private int 	type;
	private boolean initialized;
	private boolean used;

	public Variavel() {
		super();
	}

	public Variavel(int varType, String varName, boolean initialized, boolean used)
	{
		super(varName);

		this.type = varType;
		this.initialized = initialized;
		this.used = used;
	}

	public static int getReal() {
		return REAL;
	}

	public static int getTexto() {
		return TEXTO;
	}

	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public boolean isInitialized() {
		return initialized;
	}
	
	public void setInitialized(boolean initialized) {
		this.initialized = initialized;
	}
	
	public boolean isUsed() {
		return used;
	}
	
	public void setUsed(boolean used) {
		this.used = used;
	}
	
    @Override
    public boolean equals(Object o) {
		if (this == o) return true;
        if (!(o instanceof Variavel)) return false;
        if (!super.equals(o)) return false; // Chama o equals da superclasse
		
        Variavel variavel = (Variavel) o;
        return type == variavel.type &&
		initialized == variavel.initialized &&
		used == variavel.used;
    }
	
    @Override
    public int hashCode() {
		return Objects.hash(super.hashCode(), type, initialized, used); // Inclui o hashCode da superclasse
    }
	
	@Override
	public String generateJavaDeclarationCode()
	{
		StringBuilder sb = new StringBuilder();
	
		switch (type)
		{
			case Variavel.INTEIRO -> sb.append("int ");
			case Variavel.REAL  -> sb.append("double ");
			case Variavel.TEXTO  -> sb.append("String ");
	
			default -> throw new UFABCSemanticException("Tipo não reconhecido");
		}
	
		sb.append(name).append(";");
	
		return sb.toString();
	}
	
	@Override
	public String toString()
	{
		return "Variable{" +
				"type=" + type +
				", initialized=" + initialized +
				", used=" + used +
				", name='" + name + '\'' +
				'}';
	}
	
	public static int getInteiro() {
		return INTEIRO;
	}
}
