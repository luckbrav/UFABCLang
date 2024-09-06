// Generated from UFABCLang.g4 by ANTLR 4.13.2
package io.compiler.core;

    // import io.compiler.estruturas.*;
	// import io.compiler.types.*;
	// import io.compiler.core.exceptions.*;
    // import io.compiler.core.ast.*;

	// import java.util.ArrayList;
	// import java.util.List;
    // import java.util.Stack;
	// import java.util.HashMap;
	// import java.util.HashSet;
	// import java.util.Set;

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
	 * Enter a parse tree produced by {@link UFABCLangParser#tipoVar}.
	 * @param ctx the parse tree
	 */
	void enterTipoVar(UFABCLangParser.TipoVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFABCLangParser#tipoVar}.
	 * @param ctx the parse tree
	 */
	void exitTipoVar(UFABCLangParser.TipoVarContext ctx);
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
	 * Enter a parse tree produced by {@link UFABCLangParser#cmdSe}.
	 * @param ctx the parse tree
	 */
	void enterCmdSe(UFABCLangParser.CmdSeContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFABCLangParser#cmdSe}.
	 * @param ctx the parse tree
	 */
	void exitCmdSe(UFABCLangParser.CmdSeContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFABCLangParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 */
	void enterCmdEnquanto(UFABCLangParser.CmdEnquantoContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFABCLangParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 */
	void exitCmdEnquanto(UFABCLangParser.CmdEnquantoContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFABCLangParser#cmdRealizeEnquanto}.
	 * @param ctx the parse tree
	 */
	void enterCmdRealizeEnquanto(UFABCLangParser.CmdRealizeEnquantoContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFABCLangParser#cmdRealizeEnquanto}.
	 * @param ctx the parse tree
	 */
	void exitCmdRealizeEnquanto(UFABCLangParser.CmdRealizeEnquantoContext ctx);
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