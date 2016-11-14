package com.simpleplugin.gutter;

import com.intellij.psi.tree.IElementType;
import com.simpleplugin.psi.SimpleTypes;
import org.jetbrains.annotations.NotNull;

public class ToggleItalicAction extends BaseToggleStateAction {
  @NotNull
  protected String getBoundString(@NotNull CharSequence text, int selectionStart, int selectionEnd) {
    return isWord(text, selectionStart, selectionEnd) ? "_" : "*";
  }

  protected boolean shouldMoveToWordBounds() {
    return true;
  }

  @NotNull
  protected IElementType getTargetNodeType() {
    return SimpleTypes.VALUE;
  }

  private static boolean isWord(@NotNull CharSequence text, int from, int to) {
    return (from == 0 || !Character.isLetterOrDigit(text.charAt(from - 1)))
           && (to == text.length() || !Character.isLetterOrDigit(text.charAt(to)));
  }
}
