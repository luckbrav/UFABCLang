package io.compiler.core.ast;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import io.compiler.types.Types;
import io.compiler.types.Var;

public class Program {
    private String name;
    private HashMap<String, Var> symbolTable;
    private List<Command> commandList;
    
    public Program() {
        super();
    }
    public Program(String name, HashMap<String, Var> symbolTable, List<Command> commandList) {
        this.name = name;
        this.symbolTable = symbolTable;
        this.commandList = commandList;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public HashMap<String, Var> getSymbolTable() {
        return symbolTable;
    }
    public void setSymbolTable(HashMap<String, Var> symbolTable) {
        this.symbolTable = symbolTable;
    }
    public List<Command> getCommandList() {
        return commandList;
    }
    public void setCommandList(List<Command> commandList) {
        this.commandList = commandList;
    }

    public void generateTarget()
    {
        try
        {
            String s = generateJavaFile();

            System.out.println(s);

            FileWriter writer = new FileWriter(name + ".java");
            writer.write(s);
            writer.close();
        }
        catch (IOException ignored)
        {

        }
    }

	public String generateJavaFile() {
		StringBuilder str = new StringBuilder();
		str.append("import java.util.Scanner;\n");
        str.append("import java.util.*; \n");
		str.append("public class "+name+"{ \n");
		str.append("   public static void main(String args[]){ \n");
		str.append("   Scanner _scTrx = new Scanner(System.in);\n");
		for (String varId: symbolTable.keySet()) {
			Var var = symbolTable.get(varId);
			if (var.getType() == Types.INTEIRO) {
				str.append("    int ");
			} else if (var.getType() == Types.REAL) {
				str.append("    int ");
			}
			else {
				str.append("    String ");				
			}
			str.append(var.getId()+";\n");
		}
		
		for(Command cmd: commandList) {
			str.append(cmd.generateTarget());
		}
		str.append("   }\n");
		str.append("}");
		return str.toString();
	}
	
}
