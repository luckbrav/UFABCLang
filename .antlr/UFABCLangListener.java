// Generated from c:/Users/T-GAMER/OneDrive/�rea de Trabalho/SimpleParser/UFABCLang.g4 by ANTLR 4.13.1

	// import java.util.ArrayList;
	// import java.util.HashMap;
	// import io.compiler.types.*;
	// import io.compiler.core.exceptions.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link UFABCLangParser}.
 */
public interface UFABCLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link UFABCLangParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(UFABCLangParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFABCLangParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(UFABCLangParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFABCLangParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void enterDeclaravar(UFABCLangParser.DeclaravarContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFABCLangParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void exitDeclaravar(UFABCLangParser.DeclaravarContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFABCLangParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterComando(UFABCLangParser.ComandoContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFABCLangParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitComando(UFABCLangParser.ComandoContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFABCLangParser#cmdAttrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdAttrib(UFABCLangParser.CmdAttribContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFABCLangParser#cmdAttrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdAttrib(UFABCLangParser.CmdAttribContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFABCLangParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdLeitura(UFABCLangParser.CmdLeituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFABCLangParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdLeitura(UFABCLangParser.CmdLeituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFABCLangParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdEscrita(UFABCLangParser.CmdEscritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFABCLangParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdEscrita(UFABCLangParser.CmdEscritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFABCLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(UFABCLangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFABCLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(UFABCLangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFABCLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(UFABCLangParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFABCLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(UFABCLangParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFABCLangParser#exprl}.
	 * @param ctx the parse tree
	 */
	void enterExprl(UFABCLangParser.ExprlContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFABCLangParser#exprl}.
	 * @param ctx the parse tree
	 */
	void exitExprl(UFABCLangParser.ExprlContext ctx);
}