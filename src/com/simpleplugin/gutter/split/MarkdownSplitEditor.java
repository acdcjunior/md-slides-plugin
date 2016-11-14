package com.simpleplugin.gutter.split;

import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.TextEditor;
import com.intellij.pom.Navigatable;
import org.jetbrains.annotations.NotNull;

public class MarkdownSplitEditor extends SplitFileEditor<TextEditor> implements TextEditor {
  public MarkdownSplitEditor(@NotNull TextEditor mainEditor) {
    super(mainEditor);


  }

  @NotNull
  @Override
  public String getName() {
    return "Markdown split editor";
  }

  @NotNull
  @Override
  public Editor getEditor() {
    return getMainEditor().getEditor();
  }

  @Override
  public boolean canNavigateTo(@NotNull Navigatable navigatable) {
    return getMainEditor().canNavigateTo(navigatable);
  }

  @Override
  public void navigateTo(@NotNull Navigatable navigatable) {
    getMainEditor().navigateTo(navigatable);
  }


}
