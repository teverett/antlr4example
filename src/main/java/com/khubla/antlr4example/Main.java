package com.khubla.antlr4example;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;

import com.khubla.antlr4example.Cobol85Parser.StartRuleContext;

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
         InputStream inputStream = Main.class.getResourceAsStream("/example1.txt");
         /*
          * make Lexer
          */
         Lexer lexer = new Cobol85Lexer(CharStreams.fromStream(inputStream));
         /*
          * get a TokenStream on the Lexer
          */
         TokenStream tokenStream = new CommonTokenStream(lexer);
         /*
          * make a Parser on the token stream
          */
         Cobol85Parser parser = new Cobol85Parser(tokenStream);
         /*
          * get the top node of the AST. This corresponds to the topmost rule of equation.q4, "equation"
          */
         @SuppressWarnings("unused")
         StartRuleContext startRuleContext = parser.startRule();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}