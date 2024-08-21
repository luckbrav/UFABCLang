package io.compiler.main;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;


import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStreams;

import io.compiler.core.UFABCLangLexer;
import io.compiler.core.UFABCLangParser;
import io.compiler.core.ast.Program;

public class MainClass {
	public static void main(String[] args) {
		try {
			UFABCLangLexer lexer;
			UFABCLangParser parser;
			
			// crio o analisador léxico a partir da leitura de um arquivo
			lexer = new UFABCLangLexer(CharStreams.fromFileName("program.in"));
			
			// agora a partir do analisador lexico, obtenho um fluxo de tokens
			CommonTokenStream tokenStream = new CommonTokenStream(lexer);
			
			// crio o parser a partir do tokenStream
			parser = new UFABCLangParser(tokenStream);
			
			
			// agora eu quero chamar do meu jeito
			System.out.println("UFABC Compiler");
			parser.programa();
			System.out.println("Compilation Successfully - Good Job");
			// parser.exibirVar();

			Program program = parser.getProgram();

			System.out.println(program.generateTarget());

			try {
				File f = new File (program.getName()+".java");
				FileWriter fr = new FileWriter(f);
				PrintWriter pr = new PrintWriter(fr);
				pr.println(program.generateTarget());
				pr.close();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
		catch(Exception ex) {
			System.err.println("Error: "+ex.getMessage());
			//ex.printStackTrace();
		}
	}
}
