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

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class UFABCLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, MAIS=16, MENOS=17, 
		VEZES=18, DIV=19, OP_AT=20, OP_REL=21, ID=22, NUM=23, TEXTO=24, VIRG=25, 
		PV=26, AP=27, FP=28, AC=29, FC=30, DP=31, WS=32;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "MAIS", "MENOS", 
			"VEZES", "DIV", "OP_AT", "OP_REL", "ID", "NUM", "TEXTO", "VIRG", "PV", 
			"AP", "FP", "AC", "FC", "DP", "WS"
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


	public UFABCLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "UFABCLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000 \u00ea\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014"+
		"\u00ba\b\u0014\u0001\u0015\u0001\u0015\u0005\u0015\u00be\b\u0015\n\u0015"+
		"\f\u0015\u00c1\t\u0015\u0001\u0016\u0004\u0016\u00c4\b\u0016\u000b\u0016"+
		"\f\u0016\u00c5\u0001\u0016\u0001\u0016\u0004\u0016\u00ca\b\u0016\u000b"+
		"\u0016\f\u0016\u00cb\u0003\u0016\u00ce\b\u0016\u0001\u0017\u0001\u0017"+
		"\u0005\u0017\u00d2\b\u0017\n\u0017\f\u0017\u00d5\t\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001"+
		"\u001a\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001"+
		"\u001d\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0000\u0000 \u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t"+
		"\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f"+
		"\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014"+
		")\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e"+
		"=\u001f? \u0001\u0000\u0006\u0002\u0000<<>>\u0001\u0000az\u0003\u0000"+
		"09AZaz\u0001\u000009\u0005\u0000  ,.09AZaz\u0003\u0000\t\n\r\r  \u00f2"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000"+
		"\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000"+
		"\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/"+
		"\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000"+
		"\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000"+
		"\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0000="+
		"\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000\u0000\u0001A\u0001\u0000"+
		"\u0000\u0000\u0003J\u0001\u0000\u0000\u0000\u0005Q\u0001\u0000\u0000\u0000"+
		"\u0007U\u0001\u0000\u0000\u0000\t]\u0001\u0000\u0000\u0000\u000bf\u0001"+
		"\u0000\u0000\u0000\rn\u0001\u0000\u0000\u0000\u000fs\u0001\u0000\u0000"+
		"\u0000\u0011y\u0001\u0000\u0000\u0000\u0013~\u0001\u0000\u0000\u0000\u0015"+
		"\u0086\u0001\u0000\u0000\u0000\u0017\u0089\u0001\u0000\u0000\u0000\u0019"+
		"\u008f\u0001\u0000\u0000\u0000\u001b\u0095\u0001\u0000\u0000\u0000\u001d"+
		"\u009e\u0001\u0000\u0000\u0000\u001f\u00a6\u0001\u0000\u0000\u0000!\u00a8"+
		"\u0001\u0000\u0000\u0000#\u00aa\u0001\u0000\u0000\u0000%\u00ac\u0001\u0000"+
		"\u0000\u0000\'\u00ae\u0001\u0000\u0000\u0000)\u00b9\u0001\u0000\u0000"+
		"\u0000+\u00bb\u0001\u0000\u0000\u0000-\u00c3\u0001\u0000\u0000\u0000/"+
		"\u00cf\u0001\u0000\u0000\u00001\u00d8\u0001\u0000\u0000\u00003\u00da\u0001"+
		"\u0000\u0000\u00005\u00dc\u0001\u0000\u0000\u00007\u00de\u0001\u0000\u0000"+
		"\u00009\u00e0\u0001\u0000\u0000\u0000;\u00e2\u0001\u0000\u0000\u0000="+
		"\u00e4\u0001\u0000\u0000\u0000?\u00e6\u0001\u0000\u0000\u0000AB\u0005"+
		"p\u0000\u0000BC\u0005r\u0000\u0000CD\u0005o\u0000\u0000DE\u0005g\u0000"+
		"\u0000EF\u0005r\u0000\u0000FG\u0005a\u0000\u0000GH\u0005m\u0000\u0000"+
		"HI\u0005a\u0000\u0000I\u0002\u0001\u0000\u0000\u0000JK\u0005i\u0000\u0000"+
		"KL\u0005n\u0000\u0000LM\u0005i\u0000\u0000MN\u0005c\u0000\u0000NO\u0005"+
		"i\u0000\u0000OP\u0005o\u0000\u0000P\u0004\u0001\u0000\u0000\u0000QR\u0005"+
		"f\u0000\u0000RS\u0005i\u0000\u0000ST\u0005m\u0000\u0000T\u0006\u0001\u0000"+
		"\u0000\u0000UV\u0005f\u0000\u0000VW\u0005i\u0000\u0000WX\u0005m\u0000"+
		"\u0000XY\u0005p\u0000\u0000YZ\u0005r\u0000\u0000Z[\u0005o\u0000\u0000"+
		"[\\\u0005g\u0000\u0000\\\b\u0001\u0000\u0000\u0000]^\u0005d\u0000\u0000"+
		"^_\u0005e\u0000\u0000_`\u0005c\u0000\u0000`a\u0005l\u0000\u0000ab\u0005"+
		"a\u0000\u0000bc\u0005r\u0000\u0000cd\u0005a\u0000\u0000de\u0005r\u0000"+
		"\u0000e\n\u0001\u0000\u0000\u0000fg\u0005i\u0000\u0000gh\u0005n\u0000"+
		"\u0000hi\u0005t\u0000\u0000ij\u0005e\u0000\u0000jk\u0005i\u0000\u0000"+
		"kl\u0005r\u0000\u0000lm\u0005o\u0000\u0000m\f\u0001\u0000\u0000\u0000"+
		"no\u0005r\u0000\u0000op\u0005e\u0000\u0000pq\u0005a\u0000\u0000qr\u0005"+
		"l\u0000\u0000r\u000e\u0001\u0000\u0000\u0000st\u0005t\u0000\u0000tu\u0005"+
		"e\u0000\u0000uv\u0005x\u0000\u0000vw\u0005t\u0000\u0000wx\u0005o\u0000"+
		"\u0000x\u0010\u0001\u0000\u0000\u0000yz\u0005l\u0000\u0000z{\u0005e\u0000"+
		"\u0000{|\u0005i\u0000\u0000|}\u0005a\u0000\u0000}\u0012\u0001\u0000\u0000"+
		"\u0000~\u007f\u0005e\u0000\u0000\u007f\u0080\u0005s\u0000\u0000\u0080"+
		"\u0081\u0005c\u0000\u0000\u0081\u0082\u0005r\u0000\u0000\u0082\u0083\u0005"+
		"e\u0000\u0000\u0083\u0084\u0005v\u0000\u0000\u0084\u0085\u0005a\u0000"+
		"\u0000\u0085\u0014\u0001\u0000\u0000\u0000\u0086\u0087\u0005s\u0000\u0000"+
		"\u0087\u0088\u0005e\u0000\u0000\u0088\u0016\u0001\u0000\u0000\u0000\u0089"+
		"\u008a\u0005e\u0000\u0000\u008a\u008b\u0005n\u0000\u0000\u008b\u008c\u0005"+
		"t\u0000\u0000\u008c\u008d\u0005a\u0000\u0000\u008d\u008e\u0005o\u0000"+
		"\u0000\u008e\u0018\u0001\u0000\u0000\u0000\u008f\u0090\u0005s\u0000\u0000"+
		"\u0090\u0091\u0005e\u0000\u0000\u0091\u0092\u0005n\u0000\u0000\u0092\u0093"+
		"\u0005a\u0000\u0000\u0093\u0094\u0005o\u0000\u0000\u0094\u001a\u0001\u0000"+
		"\u0000\u0000\u0095\u0096\u0005e\u0000\u0000\u0096\u0097\u0005n\u0000\u0000"+
		"\u0097\u0098\u0005q\u0000\u0000\u0098\u0099\u0005u\u0000\u0000\u0099\u009a"+
		"\u0005a\u0000\u0000\u009a\u009b\u0005n\u0000\u0000\u009b\u009c\u0005t"+
		"\u0000\u0000\u009c\u009d\u0005o\u0000\u0000\u009d\u001c\u0001\u0000\u0000"+
		"\u0000\u009e\u009f\u0005r\u0000\u0000\u009f\u00a0\u0005e\u0000\u0000\u00a0"+
		"\u00a1\u0005a\u0000\u0000\u00a1\u00a2\u0005l\u0000\u0000\u00a2\u00a3\u0005"+
		"i\u0000\u0000\u00a3\u00a4\u0005z\u0000\u0000\u00a4\u00a5\u0005e\u0000"+
		"\u0000\u00a5\u001e\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005+\u0000\u0000"+
		"\u00a7 \u0001\u0000\u0000\u0000\u00a8\u00a9\u0005-\u0000\u0000\u00a9\""+
		"\u0001\u0000\u0000\u0000\u00aa\u00ab\u0005*\u0000\u0000\u00ab$\u0001\u0000"+
		"\u0000\u0000\u00ac\u00ad\u0005/\u0000\u0000\u00ad&\u0001\u0000\u0000\u0000"+
		"\u00ae\u00af\u0005=\u0000\u0000\u00af(\u0001\u0000\u0000\u0000\u00b0\u00ba"+
		"\u0007\u0000\u0000\u0000\u00b1\u00b2\u0005<\u0000\u0000\u00b2\u00ba\u0005"+
		"=\u0000\u0000\u00b3\u00b4\u0005>\u0000\u0000\u00b4\u00ba\u0005=\u0000"+
		"\u0000\u00b5\u00b6\u0005!\u0000\u0000\u00b6\u00ba\u0005=\u0000\u0000\u00b7"+
		"\u00b8\u0005=\u0000\u0000\u00b8\u00ba\u0005=\u0000\u0000\u00b9\u00b0\u0001"+
		"\u0000\u0000\u0000\u00b9\u00b1\u0001\u0000\u0000\u0000\u00b9\u00b3\u0001"+
		"\u0000\u0000\u0000\u00b9\u00b5\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001"+
		"\u0000\u0000\u0000\u00ba*\u0001\u0000\u0000\u0000\u00bb\u00bf\u0007\u0001"+
		"\u0000\u0000\u00bc\u00be\u0007\u0002\u0000\u0000\u00bd\u00bc\u0001\u0000"+
		"\u0000\u0000\u00be\u00c1\u0001\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000"+
		"\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0,\u0001\u0000\u0000"+
		"\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c2\u00c4\u0007\u0003\u0000"+
		"\u0000\u00c3\u00c2\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000"+
		"\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001\u0000\u0000"+
		"\u0000\u00c6\u00cd\u0001\u0000\u0000\u0000\u00c7\u00c9\u0005.\u0000\u0000"+
		"\u00c8\u00ca\u0007\u0003\u0000\u0000\u00c9\u00c8\u0001\u0000\u0000\u0000"+
		"\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000"+
		"\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc\u00ce\u0001\u0000\u0000\u0000"+
		"\u00cd\u00c7\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000"+
		"\u00ce.\u0001\u0000\u0000\u0000\u00cf\u00d3\u0005\"\u0000\u0000\u00d0"+
		"\u00d2\u0007\u0004\u0000\u0000\u00d1\u00d0\u0001\u0000\u0000\u0000\u00d2"+
		"\u00d5\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d3"+
		"\u00d4\u0001\u0000\u0000\u0000\u00d4\u00d6\u0001\u0000\u0000\u0000\u00d5"+
		"\u00d3\u0001\u0000\u0000\u0000\u00d6\u00d7\u0005\"\u0000\u0000\u00d70"+
		"\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005,\u0000\u0000\u00d92\u0001\u0000"+
		"\u0000\u0000\u00da\u00db\u0005;\u0000\u0000\u00db4\u0001\u0000\u0000\u0000"+
		"\u00dc\u00dd\u0005(\u0000\u0000\u00dd6\u0001\u0000\u0000\u0000\u00de\u00df"+
		"\u0005)\u0000\u0000\u00df8\u0001\u0000\u0000\u0000\u00e0\u00e1\u0005{"+
		"\u0000\u0000\u00e1:\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005}\u0000\u0000"+
		"\u00e3<\u0001\u0000\u0000\u0000\u00e4\u00e5\u0005:\u0000\u0000\u00e5>"+
		"\u0001\u0000\u0000\u0000\u00e6\u00e7\u0007\u0005\u0000\u0000\u00e7\u00e8"+
		"\u0001\u0000\u0000\u0000\u00e8\u00e9\u0006\u001f\u0000\u0000\u00e9@\u0001"+
		"\u0000\u0000\u0000\t\u0000\u00b9\u00bd\u00bf\u00c5\u00cb\u00cd\u00d1\u00d3"+
		"\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}