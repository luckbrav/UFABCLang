// Generated from c:/Users/T-GAMER/OneDrive/�rea de Trabalho/UFABCLang/UFABCLang.g4 by ANTLR 4.13.1

    import io.compiler.estruturas.*;
	import io.compiler.core.exceptions.*;
    import io.compiler.core.ast.*;

	import java.util.ArrayList;
	import java.util.List;
    import java.util.Stack;
	import java.util.HashMap;
	import java.util.HashSet;
	import java.util.Set;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class UFABCLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, MAIS=16, MENOS=17, 
		VEZES=18, DIV=19, OP_AT=20, OP_REL=21, ID=22, NUM=23, TEXTO=24, VIRG=25, 
		PV=26, AP=27, FP=28, AC=29, FC=30, DP=31, WS=32;
	public static final int
		RULE_programa = 0, RULE_declaravar = 1, RULE_tipoVar = 2, RULE_comando = 3, 
		RULE_cmdAttrib = 4, RULE_cmdLeitura = 5, RULE_cmdEscrita = 6, RULE_cmdSe = 7, 
		RULE_cmdEnquanto = 8, RULE_cmdRealizeEnquanto = 9, RULE_expr = 10, RULE_termo = 11, 
		RULE_fator = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "declaravar", "tipoVar", "comando", "cmdAttrib", "cmdLeitura", 
			"cmdEscrita", "cmdSe", "cmdEnquanto", "cmdRealizeEnquanto", "expr", "termo", 
			"fator"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'inicio'", "'fim'", "'fimprog'", "'declarar'", "'inteiro'", 
			"'real'", "'texto'", "'leia'", "'escreva'", "'se'", "'entao'", "'senao'", 
			"'enquanto'", "'realize'", "'+'", "'-'", "'*'", "'/'", "'='", null, null, 
			null, null, "','", "';'", "'('", "')'", "'{'", "'}'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "MAIS", "MENOS", "VEZES", "DIV", "OP_AT", "OP_REL", 
			"ID", "NUM", "TEXTO", "VIRG", "PV", "AP", "FP", "AC", "FC", "DP", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "UFABCLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

		
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

	public UFABCLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(UFABCLangParser.ID, 0); }
		public List<DeclaravarContext> declaravar() {
			return getRuleContexts(DeclaravarContext.class);
		}
		public DeclaravarContext declaravar(int i) {
			return getRuleContext(DeclaravarContext.class,i);
		}
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCLangListener ) ((UFABCLangListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCLangListener ) ((UFABCLangListener)listener).exitPrograma(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			match(T__0);
			setState(27);
			match(ID);
			 program.setName(_input.LT(-1).getText());
			                               stack.push(new ArrayList<Command>()); 
			                            
			setState(30); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(29);
				declaravar();
				}
				}
				setState(32); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
			setState(34);
			match(T__1);
			setState(36); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(35);
				comando();
				}
				}
				setState(38); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4247040L) != 0) );
			setState(40);
			match(T__2);
			setState(41);
			match(T__3);

			                checaListaNaoInicializada();
			                checaVariaveisNaoUtilizadas();

			                program.setSymbolTable(tabelaSimbolos);
			                program.setCommandList(stack.pop());

			                program.generateTarget();
			               
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaravarContext extends ParserRuleContext {
		public TipoVarContext tipoVar() {
			return getRuleContext(TipoVarContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(UFABCLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(UFABCLangParser.ID, i);
		}
		public TerminalNode PV() { return getToken(UFABCLangParser.PV, 0); }
		public List<TerminalNode> VIRG() { return getTokens(UFABCLangParser.VIRG); }
		public TerminalNode VIRG(int i) {
			return getToken(UFABCLangParser.VIRG, i);
		}
		public DeclaravarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaravar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCLangListener ) ((UFABCLangListener)listener).enterDeclaravar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCLangListener ) ((UFABCLangListener)listener).exitDeclaravar(this);
		}
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(T__4);
			setState(45);
			tipoVar();
			setState(46);
			match(ID);

							nomeVar = _input.LT(-1).getText();
							adicionarSimbolo();
						
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRG) {
				{
				{
				setState(48);
				match(VIRG);
				setState(49);
				match(ID);

								    nomeVar = _input.LT(-1).getText();
								    adicionarSimbolo();
				            
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(56);
			match(PV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TipoVarContext extends ParserRuleContext {
		public TipoVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipoVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCLangListener ) ((UFABCLangListener)listener).enterTipoVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCLangListener ) ((UFABCLangListener)listener).exitTipoVar(this);
		}
	}

	public final TipoVarContext tipoVar() throws RecognitionException {
		TipoVarContext _localctx = new TipoVarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tipoVar);
		try {
			setState(64);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				match(T__5);
				tipoVar = Variavel.INTEIRO;
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				match(T__6);
				tipoVar = Variavel.REAL;
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(62);
				match(T__7);
				tipoVar = Variavel.TEXTO;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComandoContext extends ParserRuleContext {
		public CmdAttribContext cmdAttrib() {
			return getRuleContext(CmdAttribContext.class,0);
		}
		public CmdLeituraContext cmdLeitura() {
			return getRuleContext(CmdLeituraContext.class,0);
		}
		public CmdEscritaContext cmdEscrita() {
			return getRuleContext(CmdEscritaContext.class,0);
		}
		public CmdSeContext cmdSe() {
			return getRuleContext(CmdSeContext.class,0);
		}
		public CmdEnquantoContext cmdEnquanto() {
			return getRuleContext(CmdEnquantoContext.class,0);
		}
		public CmdRealizeEnquantoContext cmdRealizeEnquanto() {
			return getRuleContext(CmdRealizeEnquantoContext.class,0);
		}
		public ComandoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comando; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCLangListener ) ((UFABCLangListener)listener).enterComando(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCLangListener ) ((UFABCLangListener)listener).exitComando(this);
		}
	}

	public final ComandoContext comando() throws RecognitionException {
		ComandoContext _localctx = new ComandoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_comando);
		try {
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				cmdAttrib();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				cmdLeitura();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 3);
				{
				setState(68);
				cmdEscrita();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 4);
				{
				setState(69);
				cmdSe();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 5);
				{
				setState(70);
				cmdEnquanto();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 6);
				{
				setState(71);
				cmdRealizeEnquanto();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdAttribContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(UFABCLangParser.ID, 0); }
		public TerminalNode OP_AT() { return getToken(UFABCLangParser.OP_AT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PV() { return getToken(UFABCLangParser.PV, 0); }
		public CmdAttribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdAttrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCLangListener ) ((UFABCLangListener)listener).enterCmdAttrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCLangListener ) ((UFABCLangListener)listener).exitCmdAttrib(this);
		}
	}

	public final CmdAttribContext cmdAttrib() throws RecognitionException {
		CmdAttribContext _localctx = new CmdAttribContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cmdAttrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(ID);

			                    nomeVar = _input.LT(-1).getText();
			                    nomeVarExprEsquerda = nomeVar;
			                    verificarIdentificador();
			                    variavelAtual = (Variavel) tabelaSimbolos.get(_input.LT(-1).getText());
			                    tipoExprEsquerda = variavelAtual.getType();
							
			setState(76);
			match(OP_AT);
			strExpr = "";
			setState(78);
			expr();
			setState(79);
			match(PV);

								    if (tipoExprEsquerda != tipoExprDireita) {

			                            throw new SemanticException("Atribuição de tipo incompatível na variável '" + nomeVarExprEsquerda + "'");
			                        }

			                        variavelAtual.setInitialized(true);

			                        stack.peek().add(new AttributeCommand(nomeVar, strExpr));
								
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdLeituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(UFABCLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(UFABCLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(UFABCLangParser.FP, 0); }
		public TerminalNode PV() { return getToken(UFABCLangParser.PV, 0); }
		public CmdLeituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdLeitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCLangListener ) ((UFABCLangListener)listener).enterCmdLeitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCLangListener ) ((UFABCLangListener)listener).exitCmdLeitura(this);
		}
	}

	public final CmdLeituraContext cmdLeitura() throws RecognitionException {
		CmdLeituraContext _localctx = new CmdLeituraContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmdLeitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(T__8);
			setState(83);
			match(AP);
			setState(84);
			match(ID);

									nomeVar = _input.LT(-1).getText();
									verificarIdentificador();
									setAsUsed();
			                        Variavel var = (Variavel) tabelaSimbolos.get(nomeVar);
			                        var.setInitialized(true);

								    stack.peek().add(new ReadCommand((Variavel) tabelaSimbolos.get(nomeVar)));

								
			setState(86);
			match(FP);
			setState(87);
			match(PV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdEscritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(UFABCLangParser.AP, 0); }
		public TerminalNode FP() { return getToken(UFABCLangParser.FP, 0); }
		public TerminalNode PV() { return getToken(UFABCLangParser.PV, 0); }
		public TerminalNode TEXTO() { return getToken(UFABCLangParser.TEXTO, 0); }
		public TerminalNode ID() { return getToken(UFABCLangParser.ID, 0); }
		public CmdEscritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdEscrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCLangListener ) ((UFABCLangListener)listener).enterCmdEscrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCLangListener ) ((UFABCLangListener)listener).exitCmdEscrita(this);
		}
	}

	public final CmdEscritaContext cmdEscrita() throws RecognitionException {
		CmdEscritaContext _localctx = new CmdEscritaContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdEscrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(T__9);
			setState(90);
			match(AP);
			setState(95);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEXTO:
				{
				setState(91);
				match(TEXTO);

				                    stack.peek().add(new WriteCommand(_input.LT(-1).getText()));
				                
				}
				break;
			case ID:
				{
				setState(93);
				match(ID);

				                    nomeVar = _input.LT(-1).getText();
				                    verificarIdentificador();
				                    checaSeInicializado();
				                    setAsUsed();

				                    stack.peek().add(new WriteCommand(nomeVar));
								
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(97);
			match(FP);
			setState(98);
			match(PV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdSeContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(UFABCLangParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP_REL() { return getToken(UFABCLangParser.OP_REL, 0); }
		public TerminalNode FP() { return getToken(UFABCLangParser.FP, 0); }
		public List<TerminalNode> AC() { return getTokens(UFABCLangParser.AC); }
		public TerminalNode AC(int i) {
			return getToken(UFABCLangParser.AC, i);
		}
		public List<TerminalNode> FC() { return getTokens(UFABCLangParser.FC); }
		public TerminalNode FC(int i) {
			return getToken(UFABCLangParser.FC, i);
		}
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public CmdSeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdSe; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCLangListener ) ((UFABCLangListener)listener).enterCmdSe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCLangListener ) ((UFABCLangListener)listener).exitCmdSe(this);
		}
	}

	public final CmdSeContext cmdSe() throws RecognitionException {
		CmdSeContext _localctx = new CmdSeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdSe);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(T__10);

			                            stack.push(new ArrayList<>());
			                            strExpr = "";
			                            comandoSeAtual = new IfCommand();
			                        
			setState(102);
			match(AP);
			setState(103);
			expr();
			setState(104);
			match(OP_REL);
			 strExpr += _input.LT(-1).getText(); 
			setState(106);
			expr();
			setState(107);
			match(FP);
			 comandoSeAtual.setExpression(strExpr); 
			setState(109);
			match(T__11);
			setState(110);
			match(AC);
			setState(112); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(111);
				comando();
				}
				}
				setState(114); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4247040L) != 0) );
			setState(116);
			match(FC);
			comandoSeAtual.setTrueList(stack.pop());
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(118);
				match(T__12);
				 stack.push(new ArrayList<>()); 
				setState(120);
				match(AC);
				setState(122); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(121);
					comando();
					}
					}
					setState(124); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4247040L) != 0) );
				setState(126);
				match(FC);
				comandoSeAtual.setFalseList(stack.pop());
				}
			}


			                        stack.peek().add(comandoSeAtual);
			                    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdEnquantoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(UFABCLangParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP_REL() { return getToken(UFABCLangParser.OP_REL, 0); }
		public TerminalNode FP() { return getToken(UFABCLangParser.FP, 0); }
		public TerminalNode AC() { return getToken(UFABCLangParser.AC, 0); }
		public TerminalNode FC() { return getToken(UFABCLangParser.FC, 0); }
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public CmdEnquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdEnquanto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCLangListener ) ((UFABCLangListener)listener).enterCmdEnquanto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCLangListener ) ((UFABCLangListener)listener).exitCmdEnquanto(this);
		}
	}

	public final CmdEnquantoContext cmdEnquanto() throws RecognitionException {
		CmdEnquantoContext _localctx = new CmdEnquantoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdEnquanto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(T__13);

			                        stack.push(new ArrayList<>());
			                        comandoRealizeAtual = new WhileCommand();
			                        strExpr = "";
			                    
			setState(135);
			match(AP);
			setState(136);
			expr();
			setState(137);
			match(OP_REL);
			strExpr += _input.LT(-1).getText();
			setState(139);
			expr();
			setState(140);
			match(FP);
			comandoRealizeAtual.setExpression(strExpr);
			setState(142);
			match(AC);
			setState(144); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(143);
				comando();
				}
				}
				setState(146); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4247040L) != 0) );
			setState(148);
			match(FC);

			                        comandoRealizeAtual.setCommandList(stack.pop());
			                        stack.peek().add(comandoRealizeAtual);
			                    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdRealizeEnquantoContext extends ParserRuleContext {
		public TerminalNode AC() { return getToken(UFABCLangParser.AC, 0); }
		public TerminalNode FC() { return getToken(UFABCLangParser.FC, 0); }
		public TerminalNode AP() { return getToken(UFABCLangParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP_REL() { return getToken(UFABCLangParser.OP_REL, 0); }
		public TerminalNode FP() { return getToken(UFABCLangParser.FP, 0); }
		public TerminalNode PV() { return getToken(UFABCLangParser.PV, 0); }
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public CmdRealizeEnquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdRealizeEnquanto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCLangListener ) ((UFABCLangListener)listener).enterCmdRealizeEnquanto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCLangListener ) ((UFABCLangListener)listener).exitCmdRealizeEnquanto(this);
		}
	}

	public final CmdRealizeEnquantoContext cmdRealizeEnquanto() throws RecognitionException {
		CmdRealizeEnquantoContext _localctx = new CmdRealizeEnquantoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdRealizeEnquanto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(T__14);

			                        stack.push(new ArrayList<>());
			                        comandoRealizeEnquantoAtual = new DoWhileCommand();
			                    
			setState(153);
			match(AC);
			setState(155); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(154);
				comando();
				}
				}
				setState(157); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4247040L) != 0) );
			setState(159);
			match(FC);
			setState(160);
			match(T__13);
			strExpr = "";
			setState(162);
			match(AP);
			setState(163);
			expr();
			setState(164);
			match(OP_REL);
			strExpr += _input.LT(-1).getText();
			setState(166);
			expr();
			setState(167);
			match(FP);
			comandoRealizeEnquantoAtual.setExpression(strExpr);
			setState(169);
			match(PV);

			                        comandoRealizeEnquantoAtual.setCommandList(stack.pop());
			                        stack.peek().add(comandoRealizeEnquantoAtual);
			                    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> MAIS() { return getTokens(UFABCLangParser.MAIS); }
		public TerminalNode MAIS(int i) {
			return getToken(UFABCLangParser.MAIS, i);
		}
		public List<TerminalNode> MENOS() { return getTokens(UFABCLangParser.MENOS); }
		public TerminalNode MENOS(int i) {
			return getToken(UFABCLangParser.MENOS, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCLangListener ) ((UFABCLangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCLangListener ) ((UFABCLangListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			termo();
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MAIS || _la==MENOS) {
				{
				{
				setState(173);
				_la = _input.LA(1);
				if ( !(_la==MAIS || _la==MENOS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}

				                        strExpr += _input.LT(-1).getText();
				                    
				setState(175);
				termo();
				}
				}
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermoContext extends ParserRuleContext {
		public List<FatorContext> fator() {
			return getRuleContexts(FatorContext.class);
		}
		public FatorContext fator(int i) {
			return getRuleContext(FatorContext.class,i);
		}
		public List<TerminalNode> VEZES() { return getTokens(UFABCLangParser.VEZES); }
		public TerminalNode VEZES(int i) {
			return getToken(UFABCLangParser.VEZES, i);
		}
		public List<TerminalNode> DIV() { return getTokens(UFABCLangParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(UFABCLangParser.DIV, i);
		}
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCLangListener ) ((UFABCLangListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCLangListener ) ((UFABCLangListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_termo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			fator();

			                        strExpr += _input.LT(-1).getText();
			                    
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VEZES || _la==DIV) {
				{
				{
				setState(183);
				_la = _input.LA(1);
				if ( !(_la==VEZES || _la==DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}

				                        strExpr += _input.LT(-1).getText();
				                    
				setState(185);
				fator();

				                        strExpr += _input.LT(-1).getText();
				                    
				}
				}
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FatorContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(UFABCLangParser.NUM, 0); }
		public TerminalNode TEXTO() { return getToken(UFABCLangParser.TEXTO, 0); }
		public TerminalNode ID() { return getToken(UFABCLangParser.ID, 0); }
		public TerminalNode AP() { return getToken(UFABCLangParser.AP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FP() { return getToken(UFABCLangParser.FP, 0); }
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCLangListener ) ((UFABCLangListener)listener).enterFator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCLangListener ) ((UFABCLangListener)listener).exitFator(this);
		}
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_fator);
		try {
			setState(203);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				match(NUM);

				                        String stringNumero = _input.LT(-1).getText();
				                        if (stringNumero.contains(".")) {
				                            tipoExprDireita = Variavel.REAL;
				                        } else {
				                            tipoExprDireita = Variavel.INTEIRO;
				                        }
				                    
				}
				break;
			case TEXTO:
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
				match(TEXTO);

				                        tipoExprDireita = Variavel.TEXTO;
				                    
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(197);
				match(ID);

										nomeVar = _input.LT(-1).getText();
										verificarIdentificador();
										checaSeInicializado();
										setAsUsed();

				                        Variavel var = (Variavel) tabelaSimbolos.get(_input.LT(-1).getText());
				                        tipoExprDireita = var.getType();
									
				}
				break;
			case AP:
				enterOuterAlt(_localctx, 4);
				{
				setState(199);
				match(AP);
				setState(200);
				expr();
				setState(201);
				match(FP);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001 \u00ce\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000"+
		"\u001f\b\u0000\u000b\u0000\f\u0000 \u0001\u0000\u0001\u0000\u0004\u0000"+
		"%\b\u0000\u000b\u0000\f\u0000&\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0005\u00014\b\u0001\n\u0001\f\u00017\t\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002A\b\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003I\b\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0003\u0006`\b\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0004\u0007q\b\u0007\u000b\u0007\f\u0007r\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0004\u0007"+
		"{\b\u0007\u000b\u0007\f\u0007|\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007\u0082\b\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0004\b\u0091"+
		"\b\b\u000b\b\f\b\u0092\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0004\t\u009c\b\t\u000b\t\f\t\u009d\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00b1\b\n\n\n\f\n\u00b4\t\n"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0005\u000b\u00bd\b\u000b\n\u000b\f\u000b\u00c0\t\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0003\f\u00cc\b\f\u0001\f\u0000\u0000\r\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0010\u0012\u0014\u0016\u0018\u0000\u0002\u0001\u0000\u0010\u0011"+
		"\u0001\u0000\u0012\u0013\u00d5\u0000\u001a\u0001\u0000\u0000\u0000\u0002"+
		",\u0001\u0000\u0000\u0000\u0004@\u0001\u0000\u0000\u0000\u0006H\u0001"+
		"\u0000\u0000\u0000\bJ\u0001\u0000\u0000\u0000\nR\u0001\u0000\u0000\u0000"+
		"\fY\u0001\u0000\u0000\u0000\u000ed\u0001\u0000\u0000\u0000\u0010\u0085"+
		"\u0001\u0000\u0000\u0000\u0012\u0097\u0001\u0000\u0000\u0000\u0014\u00ac"+
		"\u0001\u0000\u0000\u0000\u0016\u00b5\u0001\u0000\u0000\u0000\u0018\u00cb"+
		"\u0001\u0000\u0000\u0000\u001a\u001b\u0005\u0001\u0000\u0000\u001b\u001c"+
		"\u0005\u0016\u0000\u0000\u001c\u001e\u0006\u0000\uffff\uffff\u0000\u001d"+
		"\u001f\u0003\u0002\u0001\u0000\u001e\u001d\u0001\u0000\u0000\u0000\u001f"+
		" \u0001\u0000\u0000\u0000 \u001e\u0001\u0000\u0000\u0000 !\u0001\u0000"+
		"\u0000\u0000!\"\u0001\u0000\u0000\u0000\"$\u0005\u0002\u0000\u0000#%\u0003"+
		"\u0006\u0003\u0000$#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000"+
		"&$\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000"+
		"\u0000()\u0005\u0003\u0000\u0000)*\u0005\u0004\u0000\u0000*+\u0006\u0000"+
		"\uffff\uffff\u0000+\u0001\u0001\u0000\u0000\u0000,-\u0005\u0005\u0000"+
		"\u0000-.\u0003\u0004\u0002\u0000./\u0005\u0016\u0000\u0000/5\u0006\u0001"+
		"\uffff\uffff\u000001\u0005\u0019\u0000\u000012\u0005\u0016\u0000\u0000"+
		"24\u0006\u0001\uffff\uffff\u000030\u0001\u0000\u0000\u000047\u0001\u0000"+
		"\u0000\u000053\u0001\u0000\u0000\u000056\u0001\u0000\u0000\u000068\u0001"+
		"\u0000\u0000\u000075\u0001\u0000\u0000\u000089\u0005\u001a\u0000\u0000"+
		"9\u0003\u0001\u0000\u0000\u0000:;\u0005\u0006\u0000\u0000;A\u0006\u0002"+
		"\uffff\uffff\u0000<=\u0005\u0007\u0000\u0000=A\u0006\u0002\uffff\uffff"+
		"\u0000>?\u0005\b\u0000\u0000?A\u0006\u0002\uffff\uffff\u0000@:\u0001\u0000"+
		"\u0000\u0000@<\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000A\u0005"+
		"\u0001\u0000\u0000\u0000BI\u0003\b\u0004\u0000CI\u0003\n\u0005\u0000D"+
		"I\u0003\f\u0006\u0000EI\u0003\u000e\u0007\u0000FI\u0003\u0010\b\u0000"+
		"GI\u0003\u0012\t\u0000HB\u0001\u0000\u0000\u0000HC\u0001\u0000\u0000\u0000"+
		"HD\u0001\u0000\u0000\u0000HE\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000"+
		"\u0000HG\u0001\u0000\u0000\u0000I\u0007\u0001\u0000\u0000\u0000JK\u0005"+
		"\u0016\u0000\u0000KL\u0006\u0004\uffff\uffff\u0000LM\u0005\u0014\u0000"+
		"\u0000MN\u0006\u0004\uffff\uffff\u0000NO\u0003\u0014\n\u0000OP\u0005\u001a"+
		"\u0000\u0000PQ\u0006\u0004\uffff\uffff\u0000Q\t\u0001\u0000\u0000\u0000"+
		"RS\u0005\t\u0000\u0000ST\u0005\u001b\u0000\u0000TU\u0005\u0016\u0000\u0000"+
		"UV\u0006\u0005\uffff\uffff\u0000VW\u0005\u001c\u0000\u0000WX\u0005\u001a"+
		"\u0000\u0000X\u000b\u0001\u0000\u0000\u0000YZ\u0005\n\u0000\u0000Z_\u0005"+
		"\u001b\u0000\u0000[\\\u0005\u0018\u0000\u0000\\`\u0006\u0006\uffff\uffff"+
		"\u0000]^\u0005\u0016\u0000\u0000^`\u0006\u0006\uffff\uffff\u0000_[\u0001"+
		"\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000"+
		"ab\u0005\u001c\u0000\u0000bc\u0005\u001a\u0000\u0000c\r\u0001\u0000\u0000"+
		"\u0000de\u0005\u000b\u0000\u0000ef\u0006\u0007\uffff\uffff\u0000fg\u0005"+
		"\u001b\u0000\u0000gh\u0003\u0014\n\u0000hi\u0005\u0015\u0000\u0000ij\u0006"+
		"\u0007\uffff\uffff\u0000jk\u0003\u0014\n\u0000kl\u0005\u001c\u0000\u0000"+
		"lm\u0006\u0007\uffff\uffff\u0000mn\u0005\f\u0000\u0000np\u0005\u001d\u0000"+
		"\u0000oq\u0003\u0006\u0003\u0000po\u0001\u0000\u0000\u0000qr\u0001\u0000"+
		"\u0000\u0000rp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000st\u0001"+
		"\u0000\u0000\u0000tu\u0005\u001e\u0000\u0000u\u0081\u0006\u0007\uffff"+
		"\uffff\u0000vw\u0005\r\u0000\u0000wx\u0006\u0007\uffff\uffff\u0000xz\u0005"+
		"\u001d\u0000\u0000y{\u0003\u0006\u0003\u0000zy\u0001\u0000\u0000\u0000"+
		"{|\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000"+
		"\u0000}~\u0001\u0000\u0000\u0000~\u007f\u0005\u001e\u0000\u0000\u007f"+
		"\u0080\u0006\u0007\uffff\uffff\u0000\u0080\u0082\u0001\u0000\u0000\u0000"+
		"\u0081v\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082"+
		"\u0083\u0001\u0000\u0000\u0000\u0083\u0084\u0006\u0007\uffff\uffff\u0000"+
		"\u0084\u000f\u0001\u0000\u0000\u0000\u0085\u0086\u0005\u000e\u0000\u0000"+
		"\u0086\u0087\u0006\b\uffff\uffff\u0000\u0087\u0088\u0005\u001b\u0000\u0000"+
		"\u0088\u0089\u0003\u0014\n\u0000\u0089\u008a\u0005\u0015\u0000\u0000\u008a"+
		"\u008b\u0006\b\uffff\uffff\u0000\u008b\u008c\u0003\u0014\n\u0000\u008c"+
		"\u008d\u0005\u001c\u0000\u0000\u008d\u008e\u0006\b\uffff\uffff\u0000\u008e"+
		"\u0090\u0005\u001d\u0000\u0000\u008f\u0091\u0003\u0006\u0003\u0000\u0090"+
		"\u008f\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092"+
		"\u0090\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000\u0000\u0000\u0093"+
		"\u0094\u0001\u0000\u0000\u0000\u0094\u0095\u0005\u001e\u0000\u0000\u0095"+
		"\u0096\u0006\b\uffff\uffff\u0000\u0096\u0011\u0001\u0000\u0000\u0000\u0097"+
		"\u0098\u0005\u000f\u0000\u0000\u0098\u0099\u0006\t\uffff\uffff\u0000\u0099"+
		"\u009b\u0005\u001d\u0000\u0000\u009a\u009c\u0003\u0006\u0003\u0000\u009b"+
		"\u009a\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d"+
		"\u009b\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000\u009e"+
		"\u009f\u0001\u0000\u0000\u0000\u009f\u00a0\u0005\u001e\u0000\u0000\u00a0"+
		"\u00a1\u0005\u000e\u0000\u0000\u00a1\u00a2\u0006\t\uffff\uffff\u0000\u00a2"+
		"\u00a3\u0005\u001b\u0000\u0000\u00a3\u00a4\u0003\u0014\n\u0000\u00a4\u00a5"+
		"\u0005\u0015\u0000\u0000\u00a5\u00a6\u0006\t\uffff\uffff\u0000\u00a6\u00a7"+
		"\u0003\u0014\n\u0000\u00a7\u00a8\u0005\u001c\u0000\u0000\u00a8\u00a9\u0006"+
		"\t\uffff\uffff\u0000\u00a9\u00aa\u0005\u001a\u0000\u0000\u00aa\u00ab\u0006"+
		"\t\uffff\uffff\u0000\u00ab\u0013\u0001\u0000\u0000\u0000\u00ac\u00b2\u0003"+
		"\u0016\u000b\u0000\u00ad\u00ae\u0007\u0000\u0000\u0000\u00ae\u00af\u0006"+
		"\n\uffff\uffff\u0000\u00af\u00b1\u0003\u0016\u000b\u0000\u00b0\u00ad\u0001"+
		"\u0000\u0000\u0000\u00b1\u00b4\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001"+
		"\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3\u0015\u0001"+
		"\u0000\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b5\u00b6\u0003"+
		"\u0018\f\u0000\u00b6\u00be\u0006\u000b\uffff\uffff\u0000\u00b7\u00b8\u0007"+
		"\u0001\u0000\u0000\u00b8\u00b9\u0006\u000b\uffff\uffff\u0000\u00b9\u00ba"+
		"\u0003\u0018\f\u0000\u00ba\u00bb\u0006\u000b\uffff\uffff\u0000\u00bb\u00bd"+
		"\u0001\u0000\u0000\u0000\u00bc\u00b7\u0001\u0000\u0000\u0000\u00bd\u00c0"+
		"\u0001\u0000\u0000\u0000\u00be\u00bc\u0001\u0000\u0000\u0000\u00be\u00bf"+
		"\u0001\u0000\u0000\u0000\u00bf\u0017\u0001\u0000\u0000\u0000\u00c0\u00be"+
		"\u0001\u0000\u0000\u0000\u00c1\u00c2\u0005\u0017\u0000\u0000\u00c2\u00cc"+
		"\u0006\f\uffff\uffff\u0000\u00c3\u00c4\u0005\u0018\u0000\u0000\u00c4\u00cc"+
		"\u0006\f\uffff\uffff\u0000\u00c5\u00c6\u0005\u0016\u0000\u0000\u00c6\u00cc"+
		"\u0006\f\uffff\uffff\u0000\u00c7\u00c8\u0005\u001b\u0000\u0000\u00c8\u00c9"+
		"\u0003\u0014\n\u0000\u00c9\u00ca\u0005\u001c\u0000\u0000\u00ca\u00cc\u0001"+
		"\u0000\u0000\u0000\u00cb\u00c1\u0001\u0000\u0000\u0000\u00cb\u00c3\u0001"+
		"\u0000\u0000\u0000\u00cb\u00c5\u0001\u0000\u0000\u0000\u00cb\u00c7\u0001"+
		"\u0000\u0000\u0000\u00cc\u0019\u0001\u0000\u0000\u0000\u000e &5@H_r|\u0081"+
		"\u0092\u009d\u00b2\u00be\u00cb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}