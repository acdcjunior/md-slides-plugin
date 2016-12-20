// This is a generated file. Not intended for manual editing.
package com.simpleplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.simpleplugin.psi.impl.*;

public interface SimpleTypes {


  IElementType NEW_BOOK_NOTES = new SimpleTokenType("NEW_BOOK_NOTES");
  IElementType NEW_PRESENTER_NOTES = new SimpleTokenType("NEW_PRESENTER_NOTES");
  IElementType NEW_SLIDE_HORIZONTAL = new SimpleTokenType("NEW_SLIDE_HORIZONTAL");
  IElementType NEW_SLIDE_VERTICAL = new SimpleTokenType("NEW_SLIDE_VERTICAL");
  IElementType REGULAR_CHARS = new SimpleTokenType("REGULAR_CHARS");
  IElementType SLIDES_BOLD = new SimpleTokenType("SLIDES_BOLD");
  IElementType SLIDES_BOLD_ITALICS = new SimpleTokenType("SLIDES_BOLD_ITALICS");
  IElementType SLIDES_CODE_BLOCK = new SimpleTokenType("SLIDES_CODE_BLOCK");
  IElementType SLIDES_COMANDO_ESPECIAL = new SimpleTokenType("SLIDES_COMANDO_ESPECIAL");
  IElementType SLIDES_HEADER = new SimpleTokenType("SLIDES_HEADER");
  IElementType SLIDES_IMAGEM_OU_LINK = new SimpleTokenType("SLIDES_IMAGEM_OU_LINK");
  IElementType SLIDES_ITALICS = new SimpleTokenType("SLIDES_ITALICS");
  IElementType SLIDES_NOTES = new SimpleTokenType("SLIDES_NOTES");
  IElementType SLIDES_NOTES_BOLD = new SimpleTokenType("SLIDES_NOTES_BOLD");
  IElementType SLIDES_NOTES_BOLD_ITALICS = new SimpleTokenType("SLIDES_NOTES_BOLD_ITALICS");
  IElementType SLIDES_NOTES_HEADER = new SimpleTokenType("SLIDES_NOTES_HEADER");
  IElementType SLIDES_NOTES_ITALICS = new SimpleTokenType("SLIDES_NOTES_ITALICS");
  IElementType SLIDES_REVEAL_HTML_CONFIG = new SimpleTokenType("SLIDES_REVEAL_HTML_CONFIG");
  IElementType SLIDES_TUDOMAIS = new SimpleTokenType("SLIDES_TUDOMAIS");
  IElementType WHITESPACE_BOOK_NOTES = new SimpleTokenType("WHITESPACE_BOOK_NOTES");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
