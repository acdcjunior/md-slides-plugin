package com.simpleplugin;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.*;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.intellij.xdebugger.ui.DebuggerColors;
import com.simpleplugin.psi.SimpleTypes;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class SimpleSyntaxHighlighter extends SyntaxHighlighterBase {

    static final TextAttributesKey SEPARATOR =
            createTextAttributesKey("SIMPLE_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);

    static final TextAttributesKey KEY =
            createTextAttributesKey("SIMPLE_KEY", DefaultLanguageHighlighterColors.KEYWORD);

    static final TextAttributesKey REGULAR_CHAR =
            createTextAttributesKey("SIMPLE_REGULAR_CHAR", DefaultLanguageHighlighterColors.IDENTIFIER);

    private static final TextAttributesKey HIGHLIGHT_SLIDES_BOLD_ITALICS = createTextAttributesKey("SLIDES_BOLD_ITALICS", DefaultLanguageHighlighterColors.KEYWORD);
    static final TextAttributesKey HIGHLIGHT_SLIDES_BOLD = createTextAttributesKey("SLIDES_BOLD", DefaultLanguageHighlighterColors.KEYWORD);
    static final TextAttributesKey HIGHLIGHT_SLIDES_ITALICS = createTextAttributesKey("SLIDES_ITALICS", DefaultLanguageHighlighterColors.KEYWORD);

    private static final TextAttributesKey HIGHLIGHT_SLIDES_NOTES_BOLD_ITALICS = createTextAttributesKey("SLIDES_NOTES_BOLD_ITALICS", DefaultLanguageHighlighterColors.KEYWORD);
    private static final TextAttributesKey HIGHLIGHT_SLIDES_NOTES_BOLD = createTextAttributesKey("SLIDES_NOTES_BOLD", DefaultLanguageHighlighterColors.KEYWORD);
    private static final TextAttributesKey HIGHLIGHT_SLIDES_NOTES_ITALICS = createTextAttributesKey("SLIDES_NOTES_ITALICS", DefaultLanguageHighlighterColors.KEYWORD);

    private static final TextAttributesKey HIGHLIGHT_HEADER = createTextAttributesKey("SLIDES_HEADER", DefaultLanguageHighlighterColors.KEYWORD);
    private static final TextAttributesKey HIGHLIGHT_SLIDES_NOTES_HEADER = createTextAttributesKey("SLIDES_NOTES_HEADER", DefaultLanguageHighlighterColors.BLOCK_COMMENT);

    private static final TextAttributesKey HIGHLIGHT_SLIDES_IMAGEM_OU_LINK = createTextAttributesKey("SLIDES_IMAGEM_OU_LINK", DefaultLanguageHighlighterColors.KEYWORD);
    private static final TextAttributesKey HIGHLIGHT_SLIDE_NOTES = createTextAttributesKey("SLIDES_NOTES", DefaultLanguageHighlighterColors.BLOCK_COMMENT);
    private static final TextAttributesKey HIGHLIGHT_SLIDES_REVEAL_HTML_CONFIG = createTextAttributesKey("SLIDES_REVEAL_HTML_CONFIG", DefaultLanguageHighlighterColors.BLOCK_COMMENT);

    private static final TextAttributesKey HIGHLIGHT_NEW_SLIDE_HORIZONTAL = createTextAttributesKey("NEW_SLIDE_HORIZONTAL", DebuggerColors.BREAKPOINT_ATTRIBUTES);
    private static final TextAttributesKey HIGHLIGHT_NEW_SLIDE_VERTICAL = createTextAttributesKey("NEW_SLIDE_VERTICAL", DebuggerColors.BREAKPOINT_ATTRIBUTES);
    private static final TextAttributesKey HIGHLIGHT_NEW_PRESENTER_NOTES = createTextAttributesKey("NEW_PRESENTER_NOTES", DebuggerColors.BREAKPOINT_ATTRIBUTES);
    private static final TextAttributesKey HIGHLIGHT_NEW_BOOK_NOTES = createTextAttributesKey("NEW_BOOK_NOTES", DefaultLanguageHighlighterColors.BLOCK_COMMENT);


    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    private static final Map<IElementType, TextAttributesKey[]> elementToAttrKey = new HashMap<IElementType, TextAttributesKey[]>() {{
        put(SimpleTypes.SLIDES_TUDOMAIS, criarParaHighlight(REGULAR_CHAR));
        put(SimpleTypes.REGULAR_CHARS, criarParaHighlight(REGULAR_CHAR));

        put(SimpleTypes.SLIDES_NOTES, criarParaHighlight(HIGHLIGHT_SLIDE_NOTES));
        put(SimpleTypes.SLIDES_NOTES_BOLD_ITALICS, criarParaHighlight(HIGHLIGHT_SLIDES_NOTES_BOLD_ITALICS));
        put(SimpleTypes.SLIDES_NOTES_BOLD, criarParaHighlight(HIGHLIGHT_SLIDES_NOTES_BOLD));
        put(SimpleTypes.SLIDES_NOTES_ITALICS, criarParaHighlight(HIGHLIGHT_SLIDES_NOTES_ITALICS));

        put(SimpleTypes.SLIDES_BOLD_ITALICS, criarParaHighlight(HIGHLIGHT_SLIDES_BOLD_ITALICS));
        put(SimpleTypes.SLIDES_BOLD, criarParaHighlight(HIGHLIGHT_SLIDES_BOLD));
        put(SimpleTypes.SLIDES_ITALICS, criarParaHighlight(HIGHLIGHT_SLIDES_ITALICS));

        put(SimpleTypes.SLIDES_HEADER, criarParaHighlight(HIGHLIGHT_HEADER));
        put(SimpleTypes.SLIDES_NOTES_HEADER, criarParaHighlight(HIGHLIGHT_SLIDES_NOTES_HEADER));

        put(SimpleTypes.SLIDES_IMAGEM_OU_LINK, criarParaHighlight(HIGHLIGHT_SLIDES_IMAGEM_OU_LINK));
        put(SimpleTypes.SLIDES_CODE_BLOCK, criarParaHighlight(createTextAttributesKey("SLIDES_CODE_BLOCK", DefaultLanguageHighlighterColors.KEYWORD)));

        put(SimpleTypes.SLIDES_REVEAL_HTML_CONFIG, criarParaHighlight(HIGHLIGHT_SLIDES_REVEAL_HTML_CONFIG));

        put(SimpleTypes.NEW_SLIDE_HORIZONTAL, criarParaHighlight(HIGHLIGHT_NEW_SLIDE_HORIZONTAL));
        put(SimpleTypes.NEW_SLIDE_VERTICAL, criarParaHighlight(HIGHLIGHT_NEW_SLIDE_VERTICAL));
        put(SimpleTypes.NEW_PRESENTER_NOTES, criarParaHighlight(HIGHLIGHT_NEW_PRESENTER_NOTES));
        put(SimpleTypes.NEW_BOOK_NOTES, criarParaHighlight(HIGHLIGHT_NEW_BOOK_NOTES));

        put(SimpleTypes.WHITESPACE_BOOK_NOTES, criarParaHighlight(createTextAttributesKey("WHITESPACE_BOOK_NOTES", DefaultLanguageHighlighterColors.BLOCK_COMMENT)));
        put(SimpleTypes.SLIDES_COMANDO_ESPECIAL, criarParaHighlight(createTextAttributesKey("SLIDES_COMANDO_ESPECIAL", DefaultLanguageHighlighterColors.BLOCK_COMMENT)));
    }};

    @NotNull
    private static TextAttributesKey[] criarParaHighlight(TextAttributesKey highlightItalics) {
        return new TextAttributesKey[]{highlightItalics};
    }

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new SimpleLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        TextAttributesKey[] textAttributesKeys = elementToAttrKey.get(tokenType);
        if (textAttributesKeys == null) {
            return EMPTY_KEYS;
        }
        return textAttributesKeys;
    }

}