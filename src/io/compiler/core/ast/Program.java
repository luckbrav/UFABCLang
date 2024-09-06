package io.compiler.core.ast;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import io.compiler.estruturas.TabelaSimbolos;

public class Program {
    private String name;
    private TabelaSimbolos symbolTable;
    private List<Command> commandList;
    
    public Program() {
        super();
    }
    public Program(String name, TabelaSimbolos symbolTable, List<Command> commandList) {
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
    public TabelaSimbolos getSymbolTable() {
        return symbolTable;
    }
    public void setSymbolTable(TabelaSimbolos symbolTable) {
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

    private String generateJavaFile()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("import java.util.Scanner;\n");
        sb.append("public class ").append(name).append(" { \n");
        sb.append("\tpublic static void main(String args[]) {\n");
        sb.append("\t\tScanner sc = new Scanner(System.in);\n");

        symbolTable.generateList().forEach(x -> sb
                .append("\t\t")
                .append(x.generateJavaDeclarationCode())
                .append("\n"));

        commandList.forEach(x -> sb
                .append("\t\t")
                .append(x.generateJavaCode())
                .append("\n"));

        sb.append("\n");
        sb.append("\t}\n");
        sb.append("}\n");

        return sb.toString();
    }
	
}
