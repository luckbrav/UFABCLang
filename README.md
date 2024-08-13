# Simple Parser

Pequeno exemplo de um parser usando ANTLR. Nossa gramática permite:
- declarar variáveis de 3 tipos (inteiro, real ou texto)
- Atribuir valores a variávies
- Imprimir variáveis
- expressões aritméticas com 4 operadores + - * /
- estruturas de condição e repetição (if else, while e do while)
- não tratamos precedência (ainda)


## como usar

- você precisa baixa o Antlr no site oficial (https://www.antlr.org/download/antlr-4.13.2-complete.jar)
- você deve referenciar este JAR como biblioteca do seu projeto
- para gerar os arquivos JAVA a partir do arquivo G4, o comando é este:
``` java -cp .\antlr-4.13.2-complete.jar org.antlr.v4.Tool UFABCLang.g4 -o .\src\io\compiler\core -package io.compiler.core ```
