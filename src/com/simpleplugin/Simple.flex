package com.simpleplugin;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.simpleplugin.psi.SimpleTypes;
import com.intellij.psi.TokenType;

%%

%class SimpleLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

%{
    public boolean isInsideNotes() {
        return yystate() == INSIDE_NOTES || yystate() == INSIDE_NOTES_HEADER;
    }
%}

CRLF=\r?\n
WHITE_SPACE=[\ \n\t\f]

WHITE_SPACE_CRLF=({CRLF}|{WHITE_SPACE})+

REGULAR_CHARS=[^`*\r\n\f]+

NEW_SLIDE_HORIZONTAL=":::::"\r?\n
NEW_SLIDE_VERTICAL=":: ::"\r?\n
NEW_PRESENTER_NOTES=":::"\r?\n
NEW_BOOK_NOTES=":::~~~~"\r?\n


%state INSIDE_NOTES INSIDE_HEADER INSIDE_NOTES_HEADER INSIDE_BOOK

%%

<YYINITIAL, INSIDE_NOTES, INSIDE_BOOK> {
    {NEW_SLIDE_HORIZONTAL}                      { yybegin(YYINITIAL); return SimpleTypes.NEW_SLIDE_HORIZONTAL; }
    {NEW_SLIDE_VERTICAL}                        { yybegin(YYINITIAL); return SimpleTypes.NEW_SLIDE_VERTICAL; }
    {NEW_BOOK_NOTES}                            { yybegin(INSIDE_BOOK); return SimpleTypes.NEW_BOOK_NOTES; }
    {NEW_PRESENTER_NOTES}                       { yybegin(INSIDE_NOTES); return SimpleTypes.NEW_PRESENTER_NOTES; }
}

```[^`]+```                                     { return SimpleTypes.SLIDES_CODE_BLOCK; }
\^\^\/.+\/                                      { return SimpleTypes.SLIDES_COMANDO_ESPECIAL; }
\!?\[.*?\]\([^\)]+\)                            { return SimpleTypes.SLIDES_IMAGEM_OU_LINK; }
\<[^>]+>                                        { return SimpleTypes.SLIDES_REVEAL_HTML_CONFIG; }
`[^`]+`                                         { return SimpleTypes.SLIDES_CODE_BLOCK; }
\*\*\*{REGULAR_CHARS}\*\*\*                     { return (isInsideNotes() ? SimpleTypes.SLIDES_NOTES_BOLD_ITALICS : SimpleTypes.SLIDES_BOLD_ITALICS); }
\*\*{REGULAR_CHARS}\*\*                         { return (isInsideNotes() ? SimpleTypes.SLIDES_NOTES_BOLD         : SimpleTypes.SLIDES_BOLD); }
\*{REGULAR_CHARS}\*                             { return (isInsideNotes() ? SimpleTypes.SLIDES_NOTES_ITALICS      : SimpleTypes.SLIDES_ITALICS); }

<INSIDE_NOTES> #+                               { yybegin(INSIDE_NOTES_HEADER); return SimpleTypes.SLIDES_NOTES_HEADER; }
<INSIDE_NOTES_HEADER> {
    .                                           { return SimpleTypes.SLIDES_NOTES_HEADER; }
    {CRLF}                                      { yybegin(INSIDE_NOTES); }
}

#+                                              { yybegin(INSIDE_HEADER); return SimpleTypes.SLIDES_HEADER; }
<INSIDE_HEADER> {
    .                                           { return SimpleTypes.SLIDES_HEADER; }
    {CRLF}                                      { yybegin(YYINITIAL); }
}
<INSIDE_NOTES> {
     {WHITE_SPACE_CRLF}                         { return SimpleTypes.SLIDES_NOTES; }
     .                                          { return SimpleTypes.SLIDES_NOTES; }
}
<INSIDE_BOOK> {
     {WHITE_SPACE_CRLF}                         { return SimpleTypes.WHITESPACE_BOOK_NOTES; }
     .                                          { return SimpleTypes.WHITESPACE_BOOK_NOTES; }
}

{WHITE_SPACE}                                   { return TokenType.WHITE_SPACE; }
{CRLF}                                          { return TokenType.WHITE_SPACE; }
<YYINITIAL> .                                   { return SimpleTypes.SLIDES_TUDOMAIS; }
