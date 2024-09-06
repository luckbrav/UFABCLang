package io.compiler.core.ast;

public class AttributeCommand implements Command
{
    private String id;
    private String expression;

    public AttributeCommand() {
        super();
    }

    public AttributeCommand(String id, String expression) {
        this.id = id;
        this.expression = expression;
    }

    @Override
    public String generateJavaCode()
    {
        return id + " = " + expression + ";";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}


