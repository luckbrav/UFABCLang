package io.compiler.core.ast;

// import io.compiler.types.Types;
import io.compiler.types.Var;

public class ReadCommand extends Command {

	private Var var;

	public ReadCommand() {
		super();
	}

	public ReadCommand(Var var) {
		super();
		this.var = var;
	}

	public Var getVar() {
		return var;
	}

	public void setVar(Var var) {
		this.var = var;
	}

	@Override
	// public String generateTarget() {
	// 	
	// 	return var.getId() + " = " + ((var.getType()==Types.INTEIRO)?"_scTrx.nextInt();":"_scTrx.nextLine();")+"\n";
	// }
    public String generateTarget() {
        
        String leitura;
        
        switch (var.getType()) {
            case INTEIRO:
                leitura = "_scTrx.nextInt();";
                break;
            case REAL:
                leitura = "_scTrx.nextDouble();";
                break;
            case TEXTO:
                leitura = "_scTrx.nextLine();";
                break;
            default:
                leitura = "_scTrx.nextLine();"; // Valor padrão
        }
        
        return var.getId() + " = " + leitura + "\n";
    }

}