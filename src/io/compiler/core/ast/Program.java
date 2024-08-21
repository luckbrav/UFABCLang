package io.compiler.core.ast;

import java.util.HashMap;
import java.util.ArrayList;

import io.compiler.types.Types;
import io.compiler.types.Var;

public class Program {
    private String name;
    private HashMap<String, Var> symbolTable;
    private ArrayList<Command> commandList;
    
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
    public ArrayList<Command> getCommandList() {
        return commandList;
    }
    public void setCommandList(ArrayList<Command> commandList) {
        this.commandList = commandList;
    }

    public String generateTarget(){
        StringBuilder str = new StringBuilder();
        str.append("public Class "+name+"{ \n");
        str.append("    public static void main(String[] args) { \n");
        for (String varId : symbolTable.keySet()) {
            Var var = symbolTable.get(varId);
            if (var.getType() == Types.INTEIRO) {
                str.append("    int");
            } else if (var.getType() == Types.REAL) {
                str.append("    float");
            } else {
                str.append("    String");
            }
            str.append(var.getId()+";\n");
        }
        str.append("    }");
        str.append("}");

        return str.toString();
    }

}
