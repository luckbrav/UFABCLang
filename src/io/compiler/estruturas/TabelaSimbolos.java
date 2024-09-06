package io.compiler.estruturas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import java.util.List;

public class TabelaSimbolos
{
	private Map<String, Simbolo> symbolsMap = new HashMap<>();

	public TabelaSimbolos() {
		super();
	}

	public TabelaSimbolos(Map<String, Simbolo> symbolsMap) {
		this.symbolsMap = symbolsMap;
	}

	public void add(Simbolo symbol) 
	{
		this.symbolsMap.put(symbol.getName(), symbol);
	}

	public Simbolo get(String symbolName)
	{
		return this.symbolsMap.get(symbolName);
	}

	public Variavel getVariable(String symbolName)
	{
		return (Variavel) this.symbolsMap.get(symbolName);
	}

	public void iterate()
	{
		symbolsMap.keySet().forEach(x -> System.out.println(symbolsMap.get(x)));
	}

	public List<Variavel> generateList()
	{
		return new ArrayList<>(symbolsMap.keySet().stream().map(x -> (Variavel) this.symbolsMap.get(x)).toList());
	}

	public List<Variavel> generateUninitializedList()
	{
		return this.generateList().stream().filter(x -> !x.isInitialized()).toList();
	}
	
	public boolean exists(String symbolName)
	{
		return this.symbolsMap.containsKey(symbolName);
	}

	public Map<String, Simbolo> getSymbolsMap() {
		return symbolsMap;
	}

	public void setSymbolsMap(Map<String, Simbolo> symbolsMap) {
		this.symbolsMap = symbolsMap;
	}


}
