package io.compiler.main;

// import java.io.File;
// import java.io.FileWriter;
// import java.io.PrintWriter;
// import java.io.IOException;


import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStreams;

import io.compiler.core.UFABCLangLexer;
import io.compiler.core.UFABCLangParser;
// import io.compiler.core.ast.Program;
import io.compiler.core.exceptions.SemanticException;

public class MainClass {
	public static void main(String[] args) {
		try
		{
			UFABCLangLexer lexer;
			UFABCLangParser parser;
			CommonTokenStream commonTokenStream;

			lexer = new UFABCLangLexer(CharStreams.fromFileName("program.in"));
			commonTokenStream = new CommonTokenStream(lexer);
			parser = new UFABCLangParser(commonTokenStream);

			System.out.println("Compilação começou....");

			parser.programa();

			System.out.println("Compilação bem sucedida");
		} catch (SemanticException e)
		{
			System.err.println("Erro semântico: " + e.getMessage());
		} catch (Exception e)
		{
			System.err.println("Erro genérico: " + e.getMessage());
		}
	}

	public static Object run()
	{
		return null;
	}
	
}
