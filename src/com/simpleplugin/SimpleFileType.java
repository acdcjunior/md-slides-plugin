package com.simpleplugin;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.*;

import javax.swing.*;

public class SimpleFileType extends LanguageFileType {
  static final SimpleFileType INSTANCE = new SimpleFileType();

  private SimpleFileType() {
    super(SimpleLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public String getName() {
    return "MD Slides";
  }

  @NotNull
  @Override
  public String getDescription() {
    return "Arquivo MD Slides";
  }

  @NotNull
  @Override
  public String getDefaultExtension() {
    return "md";
  }

  @Nullable
  @Override
  public Icon getIcon() {
    return SimpleIcons.FILE;
  }
}