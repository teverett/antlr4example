package com.khubla.antlr4example;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.arithmetic.arithmeticLexer;
import org.antlr.arithmetic.arithmeticParser;
import org.antlr.arithmetic.arithmeticParser.EquationContext;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;

/**
 * @author Tom Everett
 */
class Main {
   public static void main(String[] args) {
      System.out.println("Antlr4 Example");
      try {
         /*
          * get the input file as an InputStream
          */
         InputStream inputStream = Main.class.getResourceAsStream("/pyth.txt");
         /*
          * make Lexer
          */
         Lexer lexer = new arithmeticLexer(CharStreams.fromStream(inputStream));
         /*
          * get a TokenStream on the Lexer
          */
         TokenStream tokenStream = new CommonTokenStream(lexer);
         /*
          * make a Parser on the token stream
          */
         arithmeticParser parser = new arithmeticParser(tokenStream);
         /*
          * get the top node of the AST. This corresponds to the topmost rule of equation.q4, "equation"
          */
         @SuppressWarnings("unused")
         EquationContext equationContext = parser.equation();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}