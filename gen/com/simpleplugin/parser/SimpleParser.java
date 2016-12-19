// This is a generated file. Not intended for manual editing.
package com.simpleplugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.simpleplugin.psi.SimpleTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class SimpleParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b, 0);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return simpleFile(b, l + 1);
  }

  /* ********************************************************** */
  // (
  //     NEW_SLIDE_HORIZONTAL
  //     |NEW_SLIDE_VERTICAL
  //     |NEW_PRESENTER_NOTES
  //     |NEW_BOOK_NOTES
  //     |WHITESPACE_BOOK_NOTES
  //     |REGULAR_CHARS
  //     |SLIDES_NOTES
  //     |SLIDES_NOTES_BOLD_ITALICS
  //     |SLIDES_NOTES_BOLD
  //     |SLIDES_NOTES_ITALICS
  //     |SLIDES_BOLD_ITALICS
  //     |SLIDES_BOLD
  //     |SLIDES_ITALICS
  //     |SLIDES_HEADER
  //     |SLIDES_NOTES_HEADER
  //     |SLIDES_IMAGEM_OU_LINK
  //     |SLIDES_CODE_SPAN
  //     |SLIDES_REVEAL_HTML_CONFIG
  //     |SLIDES_TUDOMAIS
  // )*
  static boolean simpleFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleFile")) return false;
    int c = current_position_(b);
    while (true) {
      if (!simpleFile_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "simpleFile", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // NEW_SLIDE_HORIZONTAL
  //     |NEW_SLIDE_VERTICAL
  //     |NEW_PRESENTER_NOTES
  //     |NEW_BOOK_NOTES
  //     |WHITESPACE_BOOK_NOTES
  //     |REGULAR_CHARS
  //     |SLIDES_NOTES
  //     |SLIDES_NOTES_BOLD_ITALICS
  //     |SLIDES_NOTES_BOLD
  //     |SLIDES_NOTES_ITALICS
  //     |SLIDES_BOLD_ITALICS
  //     |SLIDES_BOLD
  //     |SLIDES_ITALICS
  //     |SLIDES_HEADER
  //     |SLIDES_NOTES_HEADER
  //     |SLIDES_IMAGEM_OU_LINK
  //     |SLIDES_CODE_SPAN
  //     |SLIDES_REVEAL_HTML_CONFIG
  //     |SLIDES_TUDOMAIS
  private static boolean simpleFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleFile_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NEW_SLIDE_HORIZONTAL);
    if (!r) r = consumeToken(b, NEW_SLIDE_VERTICAL);
    if (!r) r = consumeToken(b, NEW_PRESENTER_NOTES);
    if (!r) r = consumeToken(b, NEW_BOOK_NOTES);
    if (!r) r = consumeToken(b, WHITESPACE_BOOK_NOTES);
    if (!r) r = consumeToken(b, REGULAR_CHARS);
    if (!r) r = consumeToken(b, SLIDES_NOTES);
    if (!r) r = consumeToken(b, SLIDES_NOTES_BOLD_ITALICS);
    if (!r) r = consumeToken(b, SLIDES_NOTES_BOLD);
    if (!r) r = consumeToken(b, SLIDES_NOTES_ITALICS);
    if (!r) r = consumeToken(b, SLIDES_BOLD_ITALICS);
    if (!r) r = consumeToken(b, SLIDES_BOLD);
    if (!r) r = consumeToken(b, SLIDES_ITALICS);
    if (!r) r = consumeToken(b, SLIDES_HEADER);
    if (!r) r = consumeToken(b, SLIDES_NOTES_HEADER);
    if (!r) r = consumeToken(b, SLIDES_IMAGEM_OU_LINK);
    if (!r) r = consumeToken(b, SLIDES_CODE_SPAN);
    if (!r) r = consumeToken(b, SLIDES_REVEAL_HTML_CONFIG);
    if (!r) r = consumeToken(b, SLIDES_TUDOMAIS);
    exit_section_(b, m, null, r);
    return r;
  }

}
