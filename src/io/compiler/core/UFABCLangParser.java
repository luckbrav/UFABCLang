// Generated from UFABCLang.g4 by ANTLR 4.13.2
package io.compiler.core;

	import java.util.ArrayList;
    import java.util.Stack;
	import java.util.HashMap;
	import io.compiler.types.*;
	import io.compiler.core.exceptions.*;
    import io.compiler.core.ast.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class UFABCLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, OP=17, 
		OP_AT=18, OP_REL=19, ID=20, NUM=21, TEXTO=22, VIRG=23, PV=24, AP=25, FP=26, 
		AC=27, FC=28, DP=29, WS=30;
	public static final int
		RULE_programa = 0, RULE_declaravar = 1, RULE_tipoVar = 2, RULE_comando = 3, 
		RULE_cmdAttrib = 4, RULE_cmdLeitura = 5, RULE_cmdEscrita = 6, RULE_cmdSe = 7, 
		RULE_cmdEnquanto = 8, RULE_cmdRealizeEnquanto = 9, RULE_expr = 10, RULE_termo = 11, 
		RULE_exprl = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "declaravar", "tipoVar", "comando", "cmdAttrib", "cmdLeitura", 
			"cmdEscrita", "cmdSe", "cmdEnquanto", "cmdRealizeEnquanto", "expr", "termo", 
			"exprl"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'inicio'", "'fim'", "'fimprog'", "'declarar'", "'inteiro'", 
			"'real'", "'texto'", "'leia'", "'escreva'", "'se'", "'entao'", "'senao'", 
			"'fimse'", "'enquanto'", "'realize'", null, "'='", null, null, null, 
			null, "','", "';'", "'('", "')'", "'{'", "'}'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "OP", "OP_AT", "OP_REL", "ID", "NUM", "TEXTO", 
			"VIRG", "PV", "AP", "FP", "AC", "FC", "DP", "WS"
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


	    private HashMap<String,Var> symbolTable = new HashMap<String, Var>();
	    private ArrayList<Var> currentDecl = new ArrayList<Var>();
	    private Types currentType;
	    private Types leftType=null, rightType=null;
	    private Program program = new Program();
	    private String strExpr = "";
	    private IfCommand currentIfCommand;

	    private Stack<ArrayList<Command>> stack = new Stack<ArrayList<Command>>();
	    
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1150464L) != 0) );
			setState(40);
			match(T__2);
			setState(41);
			match(T__3);

			                  program.setSymbolTable(symbolTable);
			                  program.setCommandList(stack.pop());
			               
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
			 currentDecl.clear(); 
			setState(46);
			tipoVar();
			setState(47);
			match(ID);
			 currentDecl.add(new Var(_input.LT(-1).getText()));
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRG) {
				{
				{
				setState(49);
				match(VIRG);
				setState(50);
				match(ID);
				 currentDecl.add(new Var(_input.LT(-1).getText()));
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 updateType(); 
			setState(58);
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
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				match(T__5);
				currentType = Types.INTEIRO;
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				match(T__6);
				currentType = Types.REAL;
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				match(T__7);
				currentType = Types.TEXTO;
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
			setState(74);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				cmdAttrib();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				cmdLeitura();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				cmdEscrita();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 4);
				{
				setState(71);
				cmdSe();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 5);
				{
				setState(72);
				cmdEnquanto();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 6);
				{
				setState(73);
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
			setState(76);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
			                       throw new UFABCSemanticException("Undeclared Variable: "+_input.LT(-1).getText());
			                   }
			                   symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                   leftType = symbolTable.get(_input.LT(-1).getText()).getType();
			                 
			setState(78);
			match(OP_AT);
			setState(79);
			expr();
			setState(80);
			match(PV);

			                 System.out.println("Left  Side Expression Type = "+leftType);
			                 System.out.println("Right Side Expression Type = "+rightType);
			                 if (leftType.getValue() < rightType.getValue()){
			                    throw new UFABCSemanticException("Type Mismatchig on Assignment");
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
			setState(83);
			match(T__8);
			setState(84);
			match(AP);
			setState(85);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
			                       throw new UFABCSemanticException("Undeclared Variable: "+_input.LT(-1).getText());
			                    }
			                    symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                  
			setState(87);
			match(FP);
			setState(88);
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
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
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
			setState(90);
			match(T__9);
			setState(91);
			match(AP);
			{
			setState(92);
			termo();
			 Command cmdWrite = new WriteCommand(_input.LT(-1).getText());
			                         stack.peek().add(cmdWrite);
			                       
			}
			setState(95);
			match(FP);
			setState(96);
			match(PV);
			 rightType = null;
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
		public TerminalNode AC() { return getToken(UFABCLangParser.AC, 0); }
		public TerminalNode FC() { return getToken(UFABCLangParser.FC, 0); }
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
			setState(99);
			match(T__10);
			 stack.push(new ArrayList<Command>());
			                             strExpr = "";
			                             currentIfCommand = new IfCommand();
			                        
			setState(101);
			match(AP);
			setState(102);
			expr();
			setState(103);
			match(OP_REL);
			 strExpr += _input.LT(-1).getText(); 
			setState(105);
			expr();
			setState(106);
			match(FP);
			 currentIfCommand.setExpression(strExpr); 
			setState(108);
			match(T__11);
			setState(109);
			match(AC);
			setState(111); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(110);
				comando();
				}
				}
				setState(113); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1150464L) != 0) );
			currentIfCommand.setTrueList(stack.pop());
			setState(116);
			match(FC);
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(117);
				match(T__12);
				 stack.push(new ArrayList<Command>()); 
				setState(120); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(119);
					comando();
					}
					}
					setState(122); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1150464L) != 0) );

				                        currentIfCommand.setFalseList(stack.pop());
				                        
				}
			}

			setState(128);
			match(T__13);

			                        stack.peek().add(currentIfCommand);
			                    
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
			setState(131);
			match(T__14);
			setState(132);
			match(AP);
			setState(133);
			expr();
			setState(134);
			match(OP_REL);
			setState(135);
			expr();
			setState(136);
			match(FP);
			setState(137);
			match(AC);
			setState(139); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(138);
				comando();
				}
				}
				setState(141); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1150464L) != 0) );
			setState(143);
			match(FC);
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
			setState(145);
			match(T__15);
			setState(146);
			match(AC);
			setState(148); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(147);
				comando();
				}
				}
				setState(150); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1150464L) != 0) );
			setState(152);
			match(FC);
			setState(153);
			match(T__14);
			setState(154);
			match(AP);
			setState(155);
			expr();
			setState(156);
			match(OP_REL);
			setState(157);
			expr();
			setState(158);
			match(FP);
			setState(159);
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
	public static class ExprContext extends ParserRuleContext {
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public ExprlContext exprl() {
			return getRuleContext(ExprlContext.class,0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			termo();
			 strExpr += _input.LT(-1).getText(); 
			setState(163);
			exprl();
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
		public TerminalNode ID() { return getToken(UFABCLangParser.ID, 0); }
		public TerminalNode NUM() { return getToken(UFABCLangParser.NUM, 0); }
		public TerminalNode TEXTO() { return getToken(UFABCLangParser.TEXTO, 0); }
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
		try {
			setState(171);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				match(ID);
				 if (!isDeclared(_input.LT(-1).getText())) {
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
				break;
			case NUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				match(NUM);
				  
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
				break;
			case TEXTO:
				enterOuterAlt(_localctx, 3);
				{
				setState(169);
				match(TEXTO);
				  
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
	public static class ExprlContext extends ParserRuleContext {
		public List<TerminalNode> OP() { return getTokens(UFABCLangParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(UFABCLangParser.OP, i);
		}
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public ExprlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCLangListener ) ((UFABCLangListener)listener).enterExprl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCLangListener ) ((UFABCLangListener)listener).exitExprl(this);
		}
	}

	public final ExprlContext exprl() throws RecognitionException {
		ExprlContext _localctx = new ExprlContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_exprl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(173);
				match(OP);
				 strExpr += _input.LT(-1).getText(); 
				setState(175);
				termo();
				 strExpr += _input.LT(-1).getText(); 
				}
				}
				setState(182);
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

	public static final String _serializedATN =
		"\u0004\u0001\u001e\u00b8\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0004"+
		"\u0000\u001f\b\u0000\u000b\u0000\f\u0000 \u0001\u0000\u0001\u0000\u0004"+
		"\u0000%\b\u0000\u000b\u0000\f\u0000&\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u00015\b\u0001\n\u0001\f\u0001"+
		"8\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002C\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003K\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0004\u0007p\b\u0007\u000b\u0007\f\u0007q\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0004\u0007y\b\u0007\u000b"+
		"\u0007\f\u0007z\u0001\u0007\u0001\u0007\u0003\u0007\u007f\b\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0004\b\u008c\b\b\u000b\b\f\b\u008d\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0004\t\u0095\b\t\u000b\t\f\t\u0096\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0003\u000b\u00ac\b\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0005\f\u00b3\b\f\n\f\f\f\u00b6\t\f\u0001\f\u0000\u0000"+
		"\r\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u0000"+
		"\u0000\u00bc\u0000\u001a\u0001\u0000\u0000\u0000\u0002,\u0001\u0000\u0000"+
		"\u0000\u0004B\u0001\u0000\u0000\u0000\u0006J\u0001\u0000\u0000\u0000\b"+
		"L\u0001\u0000\u0000\u0000\nS\u0001\u0000\u0000\u0000\fZ\u0001\u0000\u0000"+
		"\u0000\u000ec\u0001\u0000\u0000\u0000\u0010\u0083\u0001\u0000\u0000\u0000"+
		"\u0012\u0091\u0001\u0000\u0000\u0000\u0014\u00a1\u0001\u0000\u0000\u0000"+
		"\u0016\u00ab\u0001\u0000\u0000\u0000\u0018\u00b4\u0001\u0000\u0000\u0000"+
		"\u001a\u001b\u0005\u0001\u0000\u0000\u001b\u001c\u0005\u0014\u0000\u0000"+
		"\u001c\u001e\u0006\u0000\uffff\uffff\u0000\u001d\u001f\u0003\u0002\u0001"+
		"\u0000\u001e\u001d\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000\u0000"+
		" \u001e\u0001\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000!\"\u0001\u0000"+
		"\u0000\u0000\"$\u0005\u0002\u0000\u0000#%\u0003\u0006\u0003\u0000$#\u0001"+
		"\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000"+
		"&\'\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000()\u0005\u0003\u0000"+
		"\u0000)*\u0005\u0004\u0000\u0000*+\u0006\u0000\uffff\uffff\u0000+\u0001"+
		"\u0001\u0000\u0000\u0000,-\u0005\u0005\u0000\u0000-.\u0006\u0001\uffff"+
		"\uffff\u0000./\u0003\u0004\u0002\u0000/0\u0005\u0014\u0000\u000006\u0006"+
		"\u0001\uffff\uffff\u000012\u0005\u0017\u0000\u000023\u0005\u0014\u0000"+
		"\u000035\u0006\u0001\uffff\uffff\u000041\u0001\u0000\u0000\u000058\u0001"+
		"\u0000\u0000\u000064\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u0000"+
		"79\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u00009:\u0006\u0001\uffff"+
		"\uffff\u0000:;\u0005\u0018\u0000\u0000;\u0003\u0001\u0000\u0000\u0000"+
		"<=\u0005\u0006\u0000\u0000=C\u0006\u0002\uffff\uffff\u0000>?\u0005\u0007"+
		"\u0000\u0000?C\u0006\u0002\uffff\uffff\u0000@A\u0005\b\u0000\u0000AC\u0006"+
		"\u0002\uffff\uffff\u0000B<\u0001\u0000\u0000\u0000B>\u0001\u0000\u0000"+
		"\u0000B@\u0001\u0000\u0000\u0000C\u0005\u0001\u0000\u0000\u0000DK\u0003"+
		"\b\u0004\u0000EK\u0003\n\u0005\u0000FK\u0003\f\u0006\u0000GK\u0003\u000e"+
		"\u0007\u0000HK\u0003\u0010\b\u0000IK\u0003\u0012\t\u0000JD\u0001\u0000"+
		"\u0000\u0000JE\u0001\u0000\u0000\u0000JF\u0001\u0000\u0000\u0000JG\u0001"+
		"\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000JI\u0001\u0000\u0000\u0000"+
		"K\u0007\u0001\u0000\u0000\u0000LM\u0005\u0014\u0000\u0000MN\u0006\u0004"+
		"\uffff\uffff\u0000NO\u0005\u0012\u0000\u0000OP\u0003\u0014\n\u0000PQ\u0005"+
		"\u0018\u0000\u0000QR\u0006\u0004\uffff\uffff\u0000R\t\u0001\u0000\u0000"+
		"\u0000ST\u0005\t\u0000\u0000TU\u0005\u0019\u0000\u0000UV\u0005\u0014\u0000"+
		"\u0000VW\u0006\u0005\uffff\uffff\u0000WX\u0005\u001a\u0000\u0000XY\u0005"+
		"\u0018\u0000\u0000Y\u000b\u0001\u0000\u0000\u0000Z[\u0005\n\u0000\u0000"+
		"[\\\u0005\u0019\u0000\u0000\\]\u0003\u0016\u000b\u0000]^\u0006\u0006\uffff"+
		"\uffff\u0000^_\u0001\u0000\u0000\u0000_`\u0005\u001a\u0000\u0000`a\u0005"+
		"\u0018\u0000\u0000ab\u0006\u0006\uffff\uffff\u0000b\r\u0001\u0000\u0000"+
		"\u0000cd\u0005\u000b\u0000\u0000de\u0006\u0007\uffff\uffff\u0000ef\u0005"+
		"\u0019\u0000\u0000fg\u0003\u0014\n\u0000gh\u0005\u0013\u0000\u0000hi\u0006"+
		"\u0007\uffff\uffff\u0000ij\u0003\u0014\n\u0000jk\u0005\u001a\u0000\u0000"+
		"kl\u0006\u0007\uffff\uffff\u0000lm\u0005\f\u0000\u0000mo\u0005\u001b\u0000"+
		"\u0000np\u0003\u0006\u0003\u0000on\u0001\u0000\u0000\u0000pq\u0001\u0000"+
		"\u0000\u0000qo\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rs\u0001"+
		"\u0000\u0000\u0000st\u0006\u0007\uffff\uffff\u0000t~\u0005\u001c\u0000"+
		"\u0000uv\u0005\r\u0000\u0000vx\u0006\u0007\uffff\uffff\u0000wy\u0003\u0006"+
		"\u0003\u0000xw\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000zx\u0001"+
		"\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000"+
		"|}\u0006\u0007\uffff\uffff\u0000}\u007f\u0001\u0000\u0000\u0000~u\u0001"+
		"\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000"+
		"\u0000\u0000\u0080\u0081\u0005\u000e\u0000\u0000\u0081\u0082\u0006\u0007"+
		"\uffff\uffff\u0000\u0082\u000f\u0001\u0000\u0000\u0000\u0083\u0084\u0005"+
		"\u000f\u0000\u0000\u0084\u0085\u0005\u0019\u0000\u0000\u0085\u0086\u0003"+
		"\u0014\n\u0000\u0086\u0087\u0005\u0013\u0000\u0000\u0087\u0088\u0003\u0014"+
		"\n\u0000\u0088\u0089\u0005\u001a\u0000\u0000\u0089\u008b\u0005\u001b\u0000"+
		"\u0000\u008a\u008c\u0003\u0006\u0003\u0000\u008b\u008a\u0001\u0000\u0000"+
		"\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000"+
		"\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000"+
		"\u0000\u008f\u0090\u0005\u001c\u0000\u0000\u0090\u0011\u0001\u0000\u0000"+
		"\u0000\u0091\u0092\u0005\u0010\u0000\u0000\u0092\u0094\u0005\u001b\u0000"+
		"\u0000\u0093\u0095\u0003\u0006\u0003\u0000\u0094\u0093\u0001\u0000\u0000"+
		"\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000"+
		"\u0000\u0096\u0097\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000"+
		"\u0000\u0098\u0099\u0005\u001c\u0000\u0000\u0099\u009a\u0005\u000f\u0000"+
		"\u0000\u009a\u009b\u0005\u0019\u0000\u0000\u009b\u009c\u0003\u0014\n\u0000"+
		"\u009c\u009d\u0005\u0013\u0000\u0000\u009d\u009e\u0003\u0014\n\u0000\u009e"+
		"\u009f\u0005\u001a\u0000\u0000\u009f\u00a0\u0005\u0018\u0000\u0000\u00a0"+
		"\u0013\u0001\u0000\u0000\u0000\u00a1\u00a2\u0003\u0016\u000b\u0000\u00a2"+
		"\u00a3\u0006\n\uffff\uffff\u0000\u00a3\u00a4\u0003\u0018\f\u0000\u00a4"+
		"\u0015\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005\u0014\u0000\u0000\u00a6"+
		"\u00ac\u0006\u000b\uffff\uffff\u0000\u00a7\u00a8\u0005\u0015\u0000\u0000"+
		"\u00a8\u00ac\u0006\u000b\uffff\uffff\u0000\u00a9\u00aa\u0005\u0016\u0000"+
		"\u0000\u00aa\u00ac\u0006\u000b\uffff\uffff\u0000\u00ab\u00a5\u0001\u0000"+
		"\u0000\u0000\u00ab\u00a7\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000"+
		"\u0000\u0000\u00ac\u0017\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005\u0011"+
		"\u0000\u0000\u00ae\u00af\u0006\f\uffff\uffff\u0000\u00af\u00b0\u0003\u0016"+
		"\u000b\u0000\u00b0\u00b1\u0006\f\uffff\uffff\u0000\u00b1\u00b3\u0001\u0000"+
		"\u0000\u0000\u00b2\u00ad\u0001\u0000\u0000\u0000\u00b3\u00b6\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000"+
		"\u0000\u0000\u00b5\u0019\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000"+
		"\u0000\u0000\f &6BJqz~\u008d\u0096\u00ab\u00b4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}