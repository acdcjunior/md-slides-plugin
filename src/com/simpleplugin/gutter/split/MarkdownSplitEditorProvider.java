package com.simpleplugin.gutter.split;

import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.TextEditor;
import com.intellij.openapi.fileEditor.impl.text.PsiAwareTextEditorProvider;
import org.jetbrains.annotations.NotNull;

public class MarkdownSplitEditorProvider extends SplitTextEditorProvider {
  public MarkdownSplitEditorProvider() {
    super(new PsiAwareTextEditorProvider());
  }

  @Override
  protected FileEditor createSplitEditor(@NotNull final FileEditor firstEditor) {
    if (!(firstEditor instanceof TextEditor)) {
      throw new IllegalArgumentException("Main editor should be TextEditor");
    }
    return new MarkdownSplitEditor(((TextEditor)firstEditor));
  }


}
