grammar UFABCLang;

@header {
    import io.compiler.estruturas.*;
	import io.compiler.types.*;
	import io.compiler.core.exceptions.*;
    import io.compiler.core.ast.*;

	import java.util.ArrayList;
	import java.util.List;
    import java.util.Stack;
	import java.util.HashMap;
	import java.util.HashSet;
	import java.util.Set;
}

@members {
    private HashMap<String,Var> symbolTable = new HashMap<String, Var>();

    private ArrayList<Var> currentDecl = new ArrayList<Var>();

    private Types currentType;

    private Types leftType=null, rightType=null;

    private String strExpr = "";

    private IfCommand currentIfCommand;
    private DoWhileCommand currentDoWhileCommand;
    private WhileCommand currentWhileCommand;

    private Stack<ArrayList<Command>> stack = new Stack<ArrayList<Command>>();
    
    private Program program = new Program();

    public void updateType(){
    	for(Var v: currentDecl){
    	   v.setType(currentType);
    	   symbolTable.put(v.getId(), v);
    	}
    }
    public void exibirVar(){
        for (String id: symbolTable.keySet()){
        	System.out.println(symbolTable.get(id));
        }
    }

    public Program getProgram(){
    return this.program;
    }
    
    public boolean isDeclared(String id){
    	return symbolTable.get(id) != null;
    }
}

programa	: 'programa' ID { program.setName(_input.LT(-1).getText());
                               stack.push(new ArrayList<Command>()); 
                            }
               declaravar+
               'inicio'
               comando+
               'fim'
               'fimprog'

               {
                  program.setSymbolTable(symbolTable);
                  program.setCommandList(stack.pop());

               }
			;
						
declaravar	: 'declarar' { currentDecl.clear(); } tipoVar  ID  { 
                        currentDecl.add(new Var(_input.LT(-1).getText()));
                }
               ( VIRG ID                
              		 { currentDecl.add(new Var(_input.LT(-1).getText()));}
               )*	 
               { updateType(); } 
               PV
			;

tipoVar			: 'inteiro' {currentType = Types.INTEIRO;}
				| 'real' {currentType = Types.REAL;}
				| 'texto' {currentType = Types.TEXTO;}
			 	;

comando     :  cmdAttrib
		    |  cmdLeitura
	        |  cmdEscrita
            |  cmdSe
            |  cmdEnquanto
            |  cmdRealizeEnquanto
            ;					
			
cmdAttrib   : ID { if (!isDeclared(_input.LT(-1).getText())) {
                       throw new UFABCSemanticException("Undeclared Variable: "+_input.LT(-1).getText());
                   }
                   symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
                   leftType = symbolTable.get(_input.LT(-1).getText()).getType();
                 }
              OP_AT 
              expr 
              PV
              
              {
                 System.out.println("Left  Side Expression Type = "+leftType);
                 System.out.println("Right Side Expression Type = "+rightType);
                 if (leftType.getValue() < rightType.getValue()){
                    throw new UFABCSemanticException("Type Mismatchig on Assignment");
                 }
              }
			;			
			
cmdLeitura  : 'leia' AP 
               ID { if (!isDeclared(_input.LT(-1).getText())) {
                       throw new UFABCSemanticException("Undeclared Variable: "+_input.LT(-1).getText());
                    }
                    symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
                  } 
               FP 
               PV 
			;
			
cmdEscrita  : 'escreva' AP 
              ( termo  { Command cmdWrite = new WriteCommand(_input.LT(-1).getText());
                         stack.peek().add(cmdWrite);
                       } 
              ) 
              FP PV { rightType = null;}
			;				

cmdSe			:   'se' { stack.push(new ArrayList<Command>());
                             strExpr = "";
                             currentIfCommand = new IfCommand();
                        }  
                    AP 
                    expr 
                    OP_REL { strExpr += _input.LT(-1).getText(); }
                    expr 
                    FP { currentIfCommand.setExpression(strExpr); }
                    'entao' 
                    AC 
                    (comando)+ {currentIfCommand.setTrueList(stack.pop());}  
                    FC 
                    ( 'senao'  
                        { stack.push(new ArrayList<Command>()); }
                        comando+
                        {
                        currentIfCommand.setFalseList(stack.pop());
                        }  
                    )? 
                    'fimse' 
                    {
                        stack.peek().add(currentIfCommand);
                    }  			   
                ;

cmdEnquanto		: 'enquanto' AP expr OP_REL expr FP
						AC (comando)+ FC
				;

cmdRealizeEnquanto  : 'realize' AC (comando)+ FC
                      'enquanto' AP expr OP_REL expr FP PV
                    ; 

expr		:  termo  { strExpr += _input.LT(-1).getText(); } exprl 			
			;
			
termo		: ID  { if (!isDeclared(_input.LT(-1).getText())) {
                       throw new UFABCSemanticException("Undeclared Variable: "+_input.LT(-1).getText());
                    }
                    if (!symbolTable.get(_input.LT(-1).getText()).isInitialized()){
                       throw new UFABCSemanticException("Variable "+_input.LT(-1).getText()+" has no value assigned");
                    }
                    if (rightType == null){
                       rightType = symbolTable.get(_input.LT(-1).getText()).getType();
                       //System.out.println("Encontrei pela 1a vez uma variavel = "+rightType);
                    }
                    else{
                       if (symbolTable.get(_input.LT(-1).getText()).getType().getValue() > rightType.getValue()){
                          rightType = symbolTable.get(_input.LT(-1).getText()).getType();
                          //System.out.println("Ja havia tipo declarado e mudou para = "+rightType);
                          
                       }
                    }
                  }   
			| NUM    {  
                    String numText = _input.LT(-1).getText();
                    if (numText.contains(".")) {  // Verifica se é um número real
                        if (rightType == null) {
                            rightType = Types.REAL;
                            //System.out.println("Encontrei um numero REAL pela 1a vez "+rightType);
                        } else {
                            if (rightType.getValue() < Types.REAL.getValue()){			                    
                                rightType = Types.REAL;
                                //System.out.println("Mudei o tipo para real = "+rightType);
                            }
                        }
                    } else {  // Se não tiver ponto decimal, é um inteiro
                        if (rightType == null) {
                            rightType = Types.INTEIRO;
                            //System.out.println("Encontrei um numero INTEIRO pela 1a vez "+rightType);
                        } else {
                            if (rightType.getValue() < Types.INTEIRO.getValue()){			                    
                                rightType = Types.INTEIRO;
                                //System.out.println("Mudei o tipo para Inteiro = "+rightType);
                            }
                        }
                    }
			         }
			| TEXTO  {  
                     String text = _input.LT(-1).getText();
                     if (rightType == null) {
			 				rightType = Types.TEXTO;
			 				//System.out.println("Encontrei pela 1a vez um texto ="+ rightType);
			            }
			            else{
			                if (rightType.getValue() < Types.TEXTO.getValue()){			                    
			                	rightType = Types.TEXTO;
			                	//System.out.println("Mudei o tipo para TEXTO = "+rightType);
			                	
			                }
			            }
                  }  
			;
			
exprl		: ( OP { strExpr += _input.LT(-1).getText(); } 
                termo { strExpr += _input.LT(-1).getText(); } 
              ) *
			;		
			
OP			: '+' | '-' | '*' | '/' 
			;	
			
OP_AT	    : '='
		    ;			

OP_REL 	    : '<' | '>' | '<=' | '>=' | '!=' | '==' 
			;

ID			: [a-z] ( [a-z] | [A-Z] | [0-9] )*		
			;
			
NUM			: [0-9]+ ('.' [0-9]+ )?
			;			
			
TEXTO       : '"' ( [a-z] | [A-Z] | [0-9] | ',' | '.' | ' ' | '-' )* '"'
			;		

VIRG		: ','
			;
						
PV			: ';'
            ;			
            
AP			: '('
			;            
						
FP			: ')'
			;

AC			: '{'
			;   

FC			: '}'
			;
									
DP			: ':'
		    ;
		    
		    			
WS			: (' ' | '\n' | '\r' | '\t' ) -> skip
			;