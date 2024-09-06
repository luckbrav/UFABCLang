package io.compiler.core.ast;

import java.util.List;

public class WhileCommand extends Command {

    private String expression;
    private List<Command> commandList;

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
    public String generateTarget()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("while (").append(expression).append(") {").append("\n");

        commandList.forEach(x -> sb.append(x.generateTarget()).append("\n"));

        sb.append("}").append("\n");

        return sb.toString();
    }
    
}
