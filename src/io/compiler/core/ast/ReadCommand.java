package io.compiler.core.ast;

// import io.compiler.types.Types;
// import io.compiler.types.Var;
import io.compiler.estruturas.Variavel;

public class ReadCommand implements Command {

	private Variavel var;

	public ReadCommand() {
		super();
	}

	public ReadCommand(Variavel var) {
		super();
		this.var = var;
	}

	public Variavel getVar() {
		return var;
	}

	public void setVar(Variavel var) {
		this.var = var;
	}

    @Override
    public String generateJavaCode()
    {
        StringBuilder sb = new StringBuilder();

        sb.append(var.getName()).append(" = ");

        switch (var.getType()) {
            case Variavel.INTEIRO -> sb.append("_sc.nextInt(); _sc.nextLine();");
            case Variavel.REAL  -> sb.append("_sc.nextDouble(); _sc.nextLine();");
            case Variavel.TEXTO  -> sb.append("_sc.nextLine();");
        }


        return sb.toString();
    }

}