/* The following code was generated by JFlex 1.7.0-SNAPSHOT tweaked for IntelliJ platform */

package com.simpleplugin;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.simpleplugin.psi.SimpleTypes;
import com.intellij.psi.TokenType;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0-SNAPSHOT
 * from the specification file <tt>Simple.flex</tt>
 */
class SimpleLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int INSIDE_NOTES = 2;
  public static final int INSIDE_HEADER = 4;
  public static final int INSIDE_NOTES_HEADER = 6;
  public static final int INSIDE_BOOK = 8;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3,  3,  4, 4
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [9, 6, 6]
   * Total runtime size is 3744 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[(ZZ_CMAP_Z[ch>>12]<<6)|((ch>>6)&0x3f)]<<6)|(ch&0x3f)];
  }

  /* The ZZ_CMAP_Z table has 272 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\1\1\2\7\3\1\4\4\3\1\5\1\6\1\7\4\3\1\10\6\3\1\11\362\3");

  /* The ZZ_CMAP_Y table has 640 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\1\2\26\3\1\4\1\3\1\5\3\3\1\6\5\3\1\7\1\3\1\7\1\3\1\7\1\3\1\7\1\3"+
    "\1\7\1\3\1\7\1\3\1\7\1\3\1\7\1\3\1\7\1\3\1\7\1\3\1\10\1\3\1\10\1\4\4\3\1\6"+
    "\1\10\34\3\1\4\1\10\4\3\1\11\1\3\1\10\2\3\1\12\2\3\1\10\1\5\2\3\1\12\16\3"+
    "\1\13\227\3\1\4\12\3\1\10\1\6\2\3\1\14\1\3\1\10\5\3\1\5\114\3\1\10\25\3\1"+
    "\4\56\3\1\7\1\3\1\5\1\15\2\3\1\10\3\3\1\5\7\3\1\10\5\3\1\10\1\3\1\6\1\5\6"+
    "\3\1\4\105\3\1\4\3\3\1\10\61\3\1\16\40\3");

  /* The ZZ_CMAP_A table has 960 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\3\1\2\1\13\1\5\1\1\22\0\1\7\1\21\1\0\1\26\4\0\1\22\1\23\1\4\1\0\1"+
    "\16\2\0\1\12\12\15\1\6\1\0\1\24\1\0\1\25\34\0\1\14\1\0\1\17\1\11\1\0\1\20"+
    "\35\0\1\10\6\0\1\13\232\0\12\15\106\0\12\15\6\0\12\15\134\0\12\15\40\0\12"+
    "\15\54\0\12\15\60\0\12\15\6\0\12\15\116\0\2\13\46\0\12\15\26\0\12\15\74\0"+
    "\12\15\16\0\62\15");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\5\0\1\1\1\0\1\2\7\1\1\3\1\4\1\0"+
    "\10\4\1\5\1\6\1\0\1\7\6\6\1\10\1\0"+
    "\1\11\7\10\1\12\1\0\10\12\11\0\1\13\7\0"+
    "\1\14\1\0\1\15\3\0\1\16\10\0\1\17\4\0"+
    "\1\20\1\0\1\20\2\21\3\0\1\22\2\0\1\23"+
    "\1\0\1\24\2\0\1\25";

  private static int [] zzUnpackAction() {
    int [] result = new int[110];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\27\0\56\0\105\0\134\0\163\0\212\0\163"+
    "\0\241\0\270\0\317\0\346\0\375\0\u0114\0\u012b\0\u0142"+
    "\0\163\0\u0159\0\u0170\0\241\0\270\0\317\0\346\0\375"+
    "\0\u0114\0\u012b\0\u0187\0\163\0\u019e\0\163\0\241\0\317"+
    "\0\346\0\375\0\u0114\0\u012b\0\163\0\u01b5\0\163\0\241"+
    "\0\317\0\346\0\375\0\u0114\0\u012b\0\u0142\0\163\0\u01cc"+
    "\0\u01e3\0\241\0\270\0\317\0\346\0\375\0\u0114\0\u012b"+
    "\0\u01fa\0\u0211\0\u0228\0\u023f\0\346\0\u0256\0\u026d\0\u0284"+
    "\0\u029b\0\163\0\u02b2\0\u02c9\0\u02e0\0\u02f7\0\u030e\0\u0325"+
    "\0\u033c\0\163\0\u0353\0\163\0\u036a\0\u0381\0\u0398\0\163"+
    "\0\u03af\0\u03c6\0\u03dd\0\u03f4\0\u040b\0\u0422\0\u0439\0\u0450"+
    "\0\163\0\u0467\0\u047e\0\u0495\0\u04ac\0\u03f4\0\u04c3\0\163"+
    "\0\346\0\163\0\u04da\0\u04f1\0\u0508\0\163\0\u051f\0\u0536"+
    "\0\163\0\u054d\0\163\0\u0564\0\u057b\0\163";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[110];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\6\1\7\2\10\1\11\1\10\1\12\1\10\1\6"+
    "\1\13\1\6\1\0\1\14\3\6\1\15\1\16\2\6"+
    "\1\17\1\6\1\20\1\21\1\22\2\23\1\24\1\23"+
    "\1\25\1\23\1\21\1\26\1\21\1\0\1\27\3\21"+
    "\1\30\1\31\2\21\1\32\1\21\1\33\1\34\1\35"+
    "\1\36\1\34\1\37\1\10\3\34\1\40\1\34\1\0"+
    "\1\41\3\34\1\42\1\43\2\34\1\44\1\34\1\20"+
    "\1\45\1\46\1\47\1\45\1\50\1\10\3\45\1\51"+
    "\1\45\1\0\1\52\3\45\1\53\1\54\2\45\1\55"+
    "\1\45\1\56\1\57\1\60\2\61\1\62\1\61\1\63"+
    "\1\61\1\57\1\64\1\57\1\0\1\65\3\57\1\66"+
    "\1\67\2\57\1\70\1\57\1\20\31\0\1\10\24\0"+
    "\1\71\2\0\1\71\1\72\1\0\12\71\1\0\6\71"+
    "\6\0\1\73\31\0\1\74\15\0\1\75\2\0\2\75"+
    "\1\0\5\75\1\0\3\75\1\76\7\75\20\77\1\100"+
    "\6\77\14\0\1\75\12\0\25\101\1\0\1\101\26\0"+
    "\1\20\2\0\1\23\25\0\1\22\2\23\1\0\1\23"+
    "\1\0\1\23\45\0\1\33\2\0\1\36\26\0\1\47"+
    "\26\0\1\61\25\0\1\60\2\61\1\0\1\61\1\0"+
    "\1\61\17\0\1\71\2\0\1\71\1\102\1\0\12\71"+
    "\1\0\6\71\1\103\2\0\1\103\1\104\1\0\12\103"+
    "\1\0\6\103\6\0\1\105\1\106\31\0\1\107\1\0"+
    "\1\110\12\0\1\75\2\0\2\75\1\0\5\75\1\0"+
    "\3\75\1\76\2\75\1\111\4\75\20\77\1\112\6\77"+
    "\20\0\1\113\6\0\25\101\1\114\1\101\1\103\2\0"+
    "\1\103\1\115\1\0\12\103\1\0\6\103\1\116\2\0"+
    "\1\116\2\0\12\116\1\0\6\116\1\0\1\117\1\120"+
    "\3\0\1\121\1\0\1\122\24\0\1\123\20\0\1\124"+
    "\2\0\2\124\1\0\5\124\1\0\13\124\15\0\1\125"+
    "\11\0\1\126\2\127\2\126\1\127\5\126\1\127\7\126"+
    "\1\75\3\126\20\130\1\0\6\130\4\0\1\131\22\0"+
    "\1\116\2\0\1\116\1\132\1\0\12\116\1\0\6\116"+
    "\2\0\1\120\32\0\1\133\30\0\1\134\24\0\1\135"+
    "\20\0\1\124\2\0\2\124\1\0\4\124\1\136\1\0"+
    "\13\124\15\0\1\125\1\137\1\140\7\0\1\126\2\127"+
    "\2\126\1\127\5\126\1\127\7\126\1\141\3\126\23\127"+
    "\1\142\3\127\20\130\1\143\6\130\4\0\1\144\23\0"+
    "\1\145\1\146\34\0\1\147\17\0\1\150\1\151\33\0"+
    "\1\110\5\0\1\125\31\0\1\152\12\0\1\153\24\0"+
    "\1\146\34\0\1\154\20\0\1\151\44\0\1\112\7\0"+
    "\1\155\1\156\26\0\1\156\24\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[1426];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\5\0\1\11\1\0\1\11\10\1\1\11\1\0\11\1"+
    "\1\11\1\0\1\11\6\1\1\11\1\0\1\11\7\1"+
    "\1\11\1\0\10\1\11\0\1\11\7\0\1\11\1\0"+
    "\1\11\3\0\1\11\10\0\1\11\4\0\1\1\1\0"+
    "\1\11\1\1\1\11\3\0\1\11\2\0\1\11\1\0"+
    "\1\11\2\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[110];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    public boolean isInsideNotes() {
        return yystate() == INSIDE_NOTES || yystate() == INSIDE_NOTES_HEADER;
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  SimpleLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        zzDoEOF();
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return SimpleTypes.SLIDES_TUDOMAIS;
            }
          case 22: break;
          case 2: 
            { return TokenType.WHITE_SPACE;
            }
          case 23: break;
          case 3: 
            { yybegin(INSIDE_HEADER); return SimpleTypes.SLIDES_HEADER;
            }
          case 24: break;
          case 4: 
            { return SimpleTypes.SLIDES_NOTES;
            }
          case 25: break;
          case 5: 
            { yybegin(INSIDE_NOTES_HEADER); return SimpleTypes.SLIDES_NOTES_HEADER;
            }
          case 26: break;
          case 6: 
            { return SimpleTypes.SLIDES_HEADER;
            }
          case 27: break;
          case 7: 
            { yybegin(YYINITIAL);
            }
          case 28: break;
          case 8: 
            { return SimpleTypes.SLIDES_NOTES_HEADER;
            }
          case 29: break;
          case 9: 
            { yybegin(INSIDE_NOTES);
            }
          case 30: break;
          case 10: 
            { return SimpleTypes.WHITESPACE_BOOK_NOTES;
            }
          case 31: break;
          case 11: 
            { return (isInsideNotes() ? SimpleTypes.SLIDES_NOTES_ITALICS      : SimpleTypes.SLIDES_ITALICS);
            }
          case 32: break;
          case 12: 
            { return SimpleTypes.SLIDES_CODE_BLOCK;
            }
          case 33: break;
          case 13: 
            { return SimpleTypes.SLIDES_REVEAL_HTML_CONFIG;
            }
          case 34: break;
          case 14: 
            { yybegin(INSIDE_NOTES); return SimpleTypes.NEW_PRESENTER_NOTES;
            }
          case 35: break;
          case 15: 
            { return (isInsideNotes() ? SimpleTypes.SLIDES_NOTES_BOLD         : SimpleTypes.SLIDES_BOLD);
            }
          case 36: break;
          case 16: 
            { return SimpleTypes.SLIDES_COMANDO_ESPECIAL;
            }
          case 37: break;
          case 17: 
            { return SimpleTypes.SLIDES_IMAGEM_OU_LINK;
            }
          case 38: break;
          case 18: 
            { yybegin(YYINITIAL); return SimpleTypes.NEW_SLIDE_HORIZONTAL;
            }
          case 39: break;
          case 19: 
            { yybegin(YYINITIAL); return SimpleTypes.NEW_SLIDE_VERTICAL;
            }
          case 40: break;
          case 20: 
            { return (isInsideNotes() ? SimpleTypes.SLIDES_NOTES_BOLD_ITALICS : SimpleTypes.SLIDES_BOLD_ITALICS);
            }
          case 41: break;
          case 21: 
            { yybegin(INSIDE_BOOK); return SimpleTypes.NEW_BOOK_NOTES;
            }
          case 42: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
