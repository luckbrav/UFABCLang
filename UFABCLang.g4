grammar UFABCLang;

@header {
    import io.compiler.estruturas.*;
	import io.compiler.core.exceptions.*;
    import io.compiler.core.ast.*;

	import java.util.ArrayList;
	import java.util.List;
    import java.util.Stack;
	import java.util.HashMap;
	import java.util.HashSet;
	import java.util.Set;
}

@members 
{	
	private int tipoVar;
	private Integer tipoExprEsquerda, tipoExprDireita = null;

	private String nomeVar, nomeVarExprEsquerda , strExpr;

	private Simbolo simboloAtual;
    private TabelaSimbolos tabelaSimbolos = new TabelaSimbolos();

    private Variavel variavelAtual;

    private IfCommand comandoSeAtual;
    private DoWhileCommand comandoRealizeEnquantoAtual;
    private WhileCommand comandoRealizeAtual;

    private Stack<List<Command>> stack = new Stack<>();

    private Program program = new Program();

	public void adicionarSimbolo() {
		if (tabelaSimbolos.exists(nomeVar)) {
			throw new SemanticException("variavel '" + nomeVar + "' redeclarada");
		}
		
		tabelaSimbolos.add(new Variavel(tipoVar, nomeVar, false, false));
	}
	
	public void verificarIdentificador() {
		if (!tabelaSimbolos.exists(nomeVar)) {
			throw new SemanticException("Variavel '" + nomeVar + "' não declarada");
		}
	}

	public void checaSeInicializado() {
		Variavel variavelAtual = (Variavel) tabelaSimbolos.get(nomeVar);

        if (!variavelAtual.isInitialized()) {
			throw new SemanticException("Variavel '" + nomeVar + "' pode não ter sido inicializada");
        }
	}

	public void setAsUsed() {
	    Variavel variavelAtual = (Variavel) tabelaSimbolos.get(nomeVar);
		variavelAtual.setUsed(true);
	}

	public void checaListaNaoInicializada() {
        List<String> listaNaoInicializada = tabelaSimbolos
                                            .generateUninitializedList()
                                            .stream()
                                            .map(x -> x.getName())
                                            .toList();

        if (listaNaoInicializada.size() > 0) {
            System.out.println("Atenção: variaveis não inicializadas: " + listaNaoInicializada);
        }
	}

	public void checaVariaveisNaoUtilizadas() {
        if(tabelaSimbolos.generateUnusedList().size() > 0) {
            System.out.println("Atenção: variáveis não usadas: " + tabelaSimbolos.generateUnusedList()
                                                                                .stream()
                                                                                .map(x -> x.getName())
                                                                                .toList());
        }
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
                checaListaNaoInicializada();
                checaVariaveisNaoUtilizadas();

                program.setSymbolTable(tabelaSimbolos);
                program.setCommandList(stack.pop());

                program.generateTarget();
               }
			;
						
declaravar	: 'declarar' tipoVar  ID  {
				nomeVar = _input.LT(-1).getText();
				adicionarSimbolo();
			} 
            ( VIRG ID{
				    nomeVar = _input.LT(-1).getText();
				    adicionarSimbolo();
            })*	 
               PV
			;

tipoVar			: 'inteiro' {tipoVar = Variavel.INTEIRO;}
				| 'real' {tipoVar = Variavel.REAL;}
				| 'texto' {tipoVar = Variavel.TEXTO;}
			 	;

comando     :  cmdAttrib
		    |  cmdLeitura
	        |  cmdEscrita
            |  cmdSe
            |  cmdEnquanto
            |  cmdRealizeEnquanto
            ;					
			
cmdAttrib   : ID {
                    nomeVar = _input.LT(-1).getText();
                    nomeVarExprEsquerda = nomeVar;
                    verificarIdentificador();
                    variavelAtual = (Variavel) tabelaSimbolos.get(_input.LT(-1).getText());
                    tipoExprEsquerda = variavelAtual.getType();
				} 
              OP_AT {strExpr = "";}
              expr 
              PV    {
					    if (tipoExprEsquerda != tipoExprDireita) {

                            throw new SemanticException("Atribuição de tipo incompatível na variável '" + nomeVarExprEsquerda + "'");
                        }

                        variavelAtual.setInitialized(true);

                        stack.peek().add(new AttributeCommand(nomeVar, strExpr));
					}
			;			
			
cmdLeitura  : 'leia' AP 
               ID   {
						nomeVar = _input.LT(-1).getText();
						verificarIdentificador();
						setAsUsed();
                        Variavel var = (Variavel) tabelaSimbolos.get(nomeVar);
                        var.setInitialized(true);

					    stack.peek().add(new ReadCommand((Variavel) tabelaSimbolos.get(nomeVar)));

					}
               FP 
               PV 
			;
			
cmdEscrita  : 'escreva' AP (
                TEXTO {
                    stack.peek().add(new WriteCommand(_input.LT(-1).getText()));
                }
				| 
                ID {
                    nomeVar = _input.LT(-1).getText();
                    verificarIdentificador();
                    checaSeInicializado();
                    setAsUsed();

                    stack.peek().add(new WriteCommand(nomeVar));
				})
                FP 
                PV
			;				

cmdSe			:   'se' {
                            stack.push(new ArrayList<>());
                            strExpr = "";
                            comandoSeAtual = new IfCommand();
                        }
                    AP 
                    expr 
                    OP_REL { strExpr += _input.LT(-1).getText(); }
                    expr 
                    FP { comandoSeAtual.setExpression(strExpr); }
                    'entao' 
                    AC 
                    (comando)+   
                    FC {comandoSeAtual.setTrueList(stack.pop());}
                    ( 'senao'  
                        { stack.push(new ArrayList<>()); }
                        AC
                        comando+
                        FC
                        {comandoSeAtual.setFalseList(stack.pop());}  
                    )? 
                    {
                        stack.peek().add(comandoSeAtual);
                    }  			   
                ;

cmdEnquanto		: 'enquanto'{
                        stack.push(new ArrayList<>());
                        comandoRealizeAtual = new WhileCommand();
                        strExpr = "";
                    } AP expr OP_REL {strExpr += _input.LT(-1).getText();} expr FP{comandoRealizeAtual.setExpression(strExpr);}
						AC (comando)+ FC {
                        comandoRealizeAtual.setCommandList(stack.pop());
                        stack.peek().add(comandoRealizeAtual);
                    }
				;

cmdRealizeEnquanto  : 'realize'{
                        stack.push(new ArrayList<>());
                        comandoRealizeEnquantoAtual = new DoWhileCommand();
                    }  AC (comando)+ FC
                      'enquanto'{strExpr = "";} AP expr OP_REL{strExpr += _input.LT(-1).getText();} expr FP {comandoRealizeEnquantoAtual.setExpression(strExpr);} 
                      PV{
                        comandoRealizeEnquantoAtual.setCommandList(stack.pop());
                        stack.peek().add(comandoRealizeEnquantoAtual);
                    }
                    ; 

expr		: termo
                    ((MAIS | MENOS) {
                        strExpr += _input.LT(-1).getText();
                    }
                    termo
                    )*	
			;
			
termo		: fator {
                        strExpr += _input.LT(-1).getText();
                    }
                    ((VEZES | DIV) {
                        strExpr += _input.LT(-1).getText();
                    }
                    fator {
                        strExpr += _input.LT(-1).getText();
                    }
                    )*
			;

fator				: NUM {
                        String stringNumero = _input.LT(-1).getText();
                        if (stringNumero.contains(".")) {
                            tipoExprDireita = Variavel.REAL;
                        } else {
                            tipoExprDireita = Variavel.INTEIRO;
                        }
                    }
                    | TEXTO {
                        tipoExprDireita = Variavel.TEXTO;
                    }
					| ID {
						nomeVar = _input.LT(-1).getText();
						verificarIdentificador();
						checaSeInicializado();
						setAsUsed();

                        Variavel var = (Variavel) tabelaSimbolos.get(_input.LT(-1).getText());
                        tipoExprDireita = var.getType();
					}
					| AP expr FP
					;

MAIS        : '+'
            ;

MENOS       : '-'
            ;

VEZES       : '*'
            ;

DIV         : '/'
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