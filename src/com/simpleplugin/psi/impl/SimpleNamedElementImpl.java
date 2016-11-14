package com.simpleplugin.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.simpleplugin.psi.SimpleNamedElement;
import org.jetbrains.annotations.NotNull;

// por fora 2
public abstract class SimpleNamedElementImpl extends ASTWrapperPsiElement implements SimpleNamedElement {
  public SimpleNamedElementImpl(@NotNull ASTNode node) {
    super(node);
  }
}