// Generated from c:/Users/T-GAMER/OneDrive/�rea de Trabalho/UFABCLang/UFABCLang.g4 by ANTLR 4.13.1

	import java.util.ArrayList;
	import java.util.HashMap;
	import io.compiler.types.*;
	import io.compiler.core.exceptions.*;

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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, OP=16, OP_AT=17, 
		OP_REL=18, ID=19, NUM=20, TEXTO=21, VIRG=22, PV=23, AP=24, FP=25, AC=26, 
		FC=27, DP=28, WS=29;
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
			"'enquanto'", "'realize'", null, "'='", null, null, null, null, "','", 
			"';'", "'('", "')'", "'{'", "'}'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "OP", "OP_AT", "OP_REL", "ID", "NUM", "TEXTO", 
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
	    
	    public boolean isDeclared(String id){
	    	return symbolTable.get(id) != null;
	    }

	public UFABCLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
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
			setState(28); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(27);
				declaravar();
				}
				}
				setState(30); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
			setState(32);
			match(T__1);
			setState(34); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(33);
				comando();
				}
				}
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 577024L) != 0) );
			setState(38);
			match(T__2);
			setState(39);
			match(T__3);
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
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(T__4);
			 currentDecl.clear(); 
			setState(43);
			tipoVar();
			setState(44);
			match(ID);
			 currentDecl.add(new Var(_input.LT(-1).getText()));
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRG) {
				{
				{
				setState(46);
				match(VIRG);
				setState(47);
				match(ID);
				 currentDecl.add(new Var(_input.LT(-1).getText()));
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 updateType(); 
			setState(55);
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
	}

	public final TipoVarContext tipoVar() throws RecognitionException {
		TipoVarContext _localctx = new TipoVarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tipoVar);
		try {
			setState(63);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				match(T__5);
				currentType = Types.INTEIRO;
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				match(T__6);
				currentType = Types.REAL;
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(61);
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
	}

	public final ComandoContext comando() throws RecognitionException {
		ComandoContext _localctx = new ComandoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_comando);
		try {
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				cmdAttrib();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				cmdLeitura();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				cmdEscrita();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 4);
				{
				setState(68);
				cmdSe();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 5);
				{
				setState(69);
				cmdEnquanto();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 6);
				{
				setState(70);
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
	}

	public final CmdAttribContext cmdAttrib() throws RecognitionException {
		CmdAttribContext _localctx = new CmdAttribContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cmdAttrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
			                       throw new UFABCSemanticException("Undeclared Variable: "+_input.LT(-1).getText());
			                   }
			                   symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                   leftType = symbolTable.get(_input.LT(-1).getText()).getType();
			                 
			setState(75);
			match(OP_AT);
			setState(76);
			expr();
			setState(77);
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
	}

	public final CmdLeituraContext cmdLeitura() throws RecognitionException {
		CmdLeituraContext _localctx = new CmdLeituraContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmdLeitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(T__8);
			setState(81);
			match(AP);
			setState(82);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
			                       throw new UFABCSemanticException("Undeclared Variable: "+_input.LT(-1).getText());
			                    }
			                    symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                  
			setState(84);
			match(FP);
			setState(85);
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
	}

	public final CmdEscritaContext cmdEscrita() throws RecognitionException {
		CmdEscritaContext _localctx = new CmdEscritaContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdEscrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(T__9);
			setState(88);
			match(AP);
			{
			setState(89);
			termo();
			}
			setState(90);
			match(FP);
			setState(91);
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
	}

	public final CmdSeContext cmdSe() throws RecognitionException {
		CmdSeContext _localctx = new CmdSeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdSe);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(T__10);
			setState(95);
			match(AP);
			setState(96);
			expr();
			setState(97);
			match(OP_REL);
			setState(98);
			expr();
			setState(99);
			match(FP);
			setState(100);
			match(T__11);
			setState(101);
			match(AC);
			setState(103); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(102);
				comando();
				}
				}
				setState(105); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 577024L) != 0) );
			setState(107);
			match(FC);
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(108);
				match(T__12);
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
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 577024L) != 0) );
				setState(115);
				match(FC);
				}
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
	}

	public final CmdEnquantoContext cmdEnquanto() throws RecognitionException {
		CmdEnquantoContext _localctx = new CmdEnquantoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdEnquanto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(T__13);
			setState(120);
			match(AP);
			setState(121);
			expr();
			setState(122);
			match(OP_REL);
			setState(123);
			expr();
			setState(124);
			match(FP);
			setState(125);
			match(AC);
			setState(127); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(126);
				comando();
				}
				}
				setState(129); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 577024L) != 0) );
			setState(131);
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
	}

	public final CmdRealizeEnquantoContext cmdRealizeEnquanto() throws RecognitionException {
		CmdRealizeEnquantoContext _localctx = new CmdRealizeEnquantoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdRealizeEnquanto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(T__14);
			setState(134);
			match(AC);
			setState(136); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(135);
				comando();
				}
				}
				setState(138); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 577024L) != 0) );
			setState(140);
			match(FC);
			setState(141);
			match(T__13);
			setState(142);
			match(AP);
			setState(143);
			expr();
			setState(144);
			match(OP_REL);
			setState(145);
			expr();
			setState(146);
			match(FP);
			setState(147);
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
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			termo();
			setState(150);
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
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_termo);
		try {
			setState(158);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
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
				setState(154);
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
				setState(156);
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
	}

	public final ExprlContext exprl() throws RecognitionException {
		ExprlContext _localctx = new ExprlContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_exprl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(160);
				match(OP);
				setState(161);
				termo();
				}
				}
				setState(166);
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
		"\u0004\u0001\u001d\u00a8\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0001\u0000\u0001\u0000\u0004\u0000\u001d\b\u0000\u000b"+
		"\u0000\f\u0000\u001e\u0001\u0000\u0001\u0000\u0004\u0000#\b\u0000\u000b"+
		"\u0000\f\u0000$\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0005\u00012\b\u0001\n\u0001\f\u00015\t\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002@\b\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003H\b\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0004"+
		"\u0007h\b\u0007\u000b\u0007\f\u0007i\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0004\u0007p\b\u0007\u000b\u0007\f\u0007q\u0001\u0007\u0001"+
		"\u0007\u0003\u0007v\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0004\b\u0080\b\b\u000b\b\f\b\u0081\u0001\b\u0001\b"+
		"\u0001\t\u0001\t\u0001\t\u0004\t\u0089\b\t\u000b\t\f\t\u008a\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u009f\b\u000b\u0001\f\u0001\f\u0005\f\u00a3\b"+
		"\f\n\f\f\f\u00a6\t\f\u0001\f\u0000\u0000\r\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0010\u0012\u0014\u0016\u0018\u0000\u0000\u00ac\u0000\u001a\u0001"+
		"\u0000\u0000\u0000\u0002)\u0001\u0000\u0000\u0000\u0004?\u0001\u0000\u0000"+
		"\u0000\u0006G\u0001\u0000\u0000\u0000\bI\u0001\u0000\u0000\u0000\nP\u0001"+
		"\u0000\u0000\u0000\fW\u0001\u0000\u0000\u0000\u000e^\u0001\u0000\u0000"+
		"\u0000\u0010w\u0001\u0000\u0000\u0000\u0012\u0085\u0001\u0000\u0000\u0000"+
		"\u0014\u0095\u0001\u0000\u0000\u0000\u0016\u009e\u0001\u0000\u0000\u0000"+
		"\u0018\u00a4\u0001\u0000\u0000\u0000\u001a\u001c\u0005\u0001\u0000\u0000"+
		"\u001b\u001d\u0003\u0002\u0001\u0000\u001c\u001b\u0001\u0000\u0000\u0000"+
		"\u001d\u001e\u0001\u0000\u0000\u0000\u001e\u001c\u0001\u0000\u0000\u0000"+
		"\u001e\u001f\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000\u0000 \""+
		"\u0005\u0002\u0000\u0000!#\u0003\u0006\u0003\u0000\"!\u0001\u0000\u0000"+
		"\u0000#$\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000$%\u0001\u0000"+
		"\u0000\u0000%&\u0001\u0000\u0000\u0000&\'\u0005\u0003\u0000\u0000\'(\u0005"+
		"\u0004\u0000\u0000(\u0001\u0001\u0000\u0000\u0000)*\u0005\u0005\u0000"+
		"\u0000*+\u0006\u0001\uffff\uffff\u0000+,\u0003\u0004\u0002\u0000,-\u0005"+
		"\u0013\u0000\u0000-3\u0006\u0001\uffff\uffff\u0000./\u0005\u0016\u0000"+
		"\u0000/0\u0005\u0013\u0000\u000002\u0006\u0001\uffff\uffff\u00001.\u0001"+
		"\u0000\u0000\u000025\u0001\u0000\u0000\u000031\u0001\u0000\u0000\u0000"+
		"34\u0001\u0000\u0000\u000046\u0001\u0000\u0000\u000053\u0001\u0000\u0000"+
		"\u000067\u0006\u0001\uffff\uffff\u000078\u0005\u0017\u0000\u00008\u0003"+
		"\u0001\u0000\u0000\u00009:\u0005\u0006\u0000\u0000:@\u0006\u0002\uffff"+
		"\uffff\u0000;<\u0005\u0007\u0000\u0000<@\u0006\u0002\uffff\uffff\u0000"+
		"=>\u0005\b\u0000\u0000>@\u0006\u0002\uffff\uffff\u0000?9\u0001\u0000\u0000"+
		"\u0000?;\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000@\u0005\u0001"+
		"\u0000\u0000\u0000AH\u0003\b\u0004\u0000BH\u0003\n\u0005\u0000CH\u0003"+
		"\f\u0006\u0000DH\u0003\u000e\u0007\u0000EH\u0003\u0010\b\u0000FH\u0003"+
		"\u0012\t\u0000GA\u0001\u0000\u0000\u0000GB\u0001\u0000\u0000\u0000GC\u0001"+
		"\u0000\u0000\u0000GD\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000"+
		"GF\u0001\u0000\u0000\u0000H\u0007\u0001\u0000\u0000\u0000IJ\u0005\u0013"+
		"\u0000\u0000JK\u0006\u0004\uffff\uffff\u0000KL\u0005\u0011\u0000\u0000"+
		"LM\u0003\u0014\n\u0000MN\u0005\u0017\u0000\u0000NO\u0006\u0004\uffff\uffff"+
		"\u0000O\t\u0001\u0000\u0000\u0000PQ\u0005\t\u0000\u0000QR\u0005\u0018"+
		"\u0000\u0000RS\u0005\u0013\u0000\u0000ST\u0006\u0005\uffff\uffff\u0000"+
		"TU\u0005\u0019\u0000\u0000UV\u0005\u0017\u0000\u0000V\u000b\u0001\u0000"+
		"\u0000\u0000WX\u0005\n\u0000\u0000XY\u0005\u0018\u0000\u0000YZ\u0003\u0016"+
		"\u000b\u0000Z[\u0005\u0019\u0000\u0000[\\\u0005\u0017\u0000\u0000\\]\u0006"+
		"\u0006\uffff\uffff\u0000]\r\u0001\u0000\u0000\u0000^_\u0005\u000b\u0000"+
		"\u0000_`\u0005\u0018\u0000\u0000`a\u0003\u0014\n\u0000ab\u0005\u0012\u0000"+
		"\u0000bc\u0003\u0014\n\u0000cd\u0005\u0019\u0000\u0000de\u0005\f\u0000"+
		"\u0000eg\u0005\u001a\u0000\u0000fh\u0003\u0006\u0003\u0000gf\u0001\u0000"+
		"\u0000\u0000hi\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000ij\u0001"+
		"\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000ku\u0005\u001b\u0000\u0000"+
		"lm\u0005\r\u0000\u0000mo\u0005\u001a\u0000\u0000np\u0003\u0006\u0003\u0000"+
		"on\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000"+
		"\u0000qr\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000st\u0005\u001b"+
		"\u0000\u0000tv\u0001\u0000\u0000\u0000ul\u0001\u0000\u0000\u0000uv\u0001"+
		"\u0000\u0000\u0000v\u000f\u0001\u0000\u0000\u0000wx\u0005\u000e\u0000"+
		"\u0000xy\u0005\u0018\u0000\u0000yz\u0003\u0014\n\u0000z{\u0005\u0012\u0000"+
		"\u0000{|\u0003\u0014\n\u0000|}\u0005\u0019\u0000\u0000}\u007f\u0005\u001a"+
		"\u0000\u0000~\u0080\u0003\u0006\u0003\u0000\u007f~\u0001\u0000\u0000\u0000"+
		"\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000"+
		"\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000"+
		"\u0083\u0084\u0005\u001b\u0000\u0000\u0084\u0011\u0001\u0000\u0000\u0000"+
		"\u0085\u0086\u0005\u000f\u0000\u0000\u0086\u0088\u0005\u001a\u0000\u0000"+
		"\u0087\u0089\u0003\u0006\u0003\u0000\u0088\u0087\u0001\u0000\u0000\u0000"+
		"\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000"+
		"\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000"+
		"\u008c\u008d\u0005\u001b\u0000\u0000\u008d\u008e\u0005\u000e\u0000\u0000"+
		"\u008e\u008f\u0005\u0018\u0000\u0000\u008f\u0090\u0003\u0014\n\u0000\u0090"+
		"\u0091\u0005\u0012\u0000\u0000\u0091\u0092\u0003\u0014\n\u0000\u0092\u0093"+
		"\u0005\u0019\u0000\u0000\u0093\u0094\u0005\u0017\u0000\u0000\u0094\u0013"+
		"\u0001\u0000\u0000\u0000\u0095\u0096\u0003\u0016\u000b\u0000\u0096\u0097"+
		"\u0003\u0018\f\u0000\u0097\u0015\u0001\u0000\u0000\u0000\u0098\u0099\u0005"+
		"\u0013\u0000\u0000\u0099\u009f\u0006\u000b\uffff\uffff\u0000\u009a\u009b"+
		"\u0005\u0014\u0000\u0000\u009b\u009f\u0006\u000b\uffff\uffff\u0000\u009c"+
		"\u009d\u0005\u0015\u0000\u0000\u009d\u009f\u0006\u000b\uffff\uffff\u0000"+
		"\u009e\u0098\u0001\u0000\u0000\u0000\u009e\u009a\u0001\u0000\u0000\u0000"+
		"\u009e\u009c\u0001\u0000\u0000\u0000\u009f\u0017\u0001\u0000\u0000\u0000"+
		"\u00a0\u00a1\u0005\u0010\u0000\u0000\u00a1\u00a3\u0003\u0016\u000b\u0000"+
		"\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a3\u00a6\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000"+
		"\u00a5\u0019\u0001\u0000\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000"+
		"\f\u001e$3?Giqu\u0081\u008a\u009e\u00a4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}