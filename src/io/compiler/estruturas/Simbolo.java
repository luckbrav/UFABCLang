package io.compiler.estruturas;

public abstract class Simbolo
{
	public Simbolo(String name) {
		this.name = name;
	}

	protected String name;

	public Simbolo() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract String generateJavaDeclarationCode();

	@Override
	public String toString() {
		return "Simbolo [name=" + name + "]";
	}
}
