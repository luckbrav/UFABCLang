package io.compiler.core.ast;

public class WriteCommand implements Command{
    
    private String content;
    
    public WriteCommand() {
        super();
    }
    
    public WriteCommand(String content) {
        super();
        this.content = content;
    }

    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    @Override
    public String generateJavaCode()
    {
        return "System.out.println(" + content + ");";
    }
}
