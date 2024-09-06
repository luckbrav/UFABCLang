package io.compiler.core.ast;

import java.util.List;

public class DoWhileCommand implements Command {

    private String expression;
    private List<Command> commandList;

    public DoWhileCommand() {
        super();
    }

    public DoWhileCommand(String expression, List<Command> commandList) {
        this.expression = expression;
        this.commandList = commandList;
    }

    public String getExpression() {
        return expression;
    }
    
    public void setExpression(String expression) {
        this.expression = expression;
    }
    
    public List<Command> getCommandList() {
        return commandList;
    }
    
    public void setCommandList(List<Command> commandList) {
        this.commandList = commandList;
    }
    
    @Override
    public String generateJavaCode()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("do {").append("\n");

        commandList.forEach(x -> sb.append(x.generateJavaCode()).append("\n"));

        sb.append("}").append("while (").append(expression).append(");").append("\n");

        return sb.toString();
    }

}
