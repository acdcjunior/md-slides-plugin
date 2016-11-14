package com.simpleplugin.gutter.split;

import com.intellij.codeHighlighting.BackgroundEditorHighlighter;
import com.intellij.ide.structureView.StructureViewBuilder;
import com.intellij.openapi.editor.ex.EditorGutterComponentEx;
import com.intellij.openapi.fileEditor.*;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.util.Pair;
import com.intellij.openapi.util.UserDataHolderBase;
import com.intellij.openapi.wm.IdeFocusManager;
import com.intellij.ui.JBSplitter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;

public abstract class SplitFileEditor<E1 extends FileEditor> extends UserDataHolderBase implements FileEditor {
  public static final Key<SplitFileEditor> PARENT_SPLIT_KEY = Key.create("parentSplit");

  private static final String MY_PROPORTION_KEY = "SplitFileEditor.Proportion";

  @NotNull
  protected final E1 myMainEditor;

  @NotNull
  private final JComponent myComponent;
  @NotNull
  private SplitEditorLayout mySplitEditorLayout = SplitEditorLayout.FIRST;
  @NotNull
  private final MyListenersMultimap myListenersGenerator = new MyListenersMultimap();

  private SplitEditorToolbar myToolbarWrapper;

  public SplitFileEditor(@NotNull E1 mainEditor) {
    myMainEditor = mainEditor;

    myComponent = createComponent();

    if (myMainEditor instanceof TextEditor) {
      myMainEditor.putUserData(PARENT_SPLIT_KEY, this);
    }
  }

  @NotNull
  private JComponent createComponent() {
    final JBSplitter splitter = new JBSplitter(false, 0.5f, 0.15f, 0.85f);
    splitter.setSplitterProportionKey(MY_PROPORTION_KEY);
    splitter.setFirstComponent(myMainEditor.getComponent());


    myToolbarWrapper = new SplitEditorToolbar(splitter);
    if (myMainEditor instanceof TextEditor) {
      myToolbarWrapper.addGutterToTrack(((EditorGutterComponentEx)((TextEditor)myMainEditor).getEditor().getGutter()));
    }

    final JPanel result = new JPanel(new BorderLayout());
    result.add(myToolbarWrapper, BorderLayout.NORTH);
    result.add(splitter, BorderLayout.CENTER);
    adjustEditorsVisibility();

    return result;
  }

  private void invalidateLayout() {
    adjustEditorsVisibility();
    myToolbarWrapper.refresh();
    myComponent.repaint();

    IdeFocusManager.findInstanceByComponent(myComponent).requestFocus(myComponent, true);
  }

  private void adjustEditorsVisibility() {
    myMainEditor.getComponent().setVisible(true);
  }

  @NotNull
  public E1 getMainEditor() {
    return myMainEditor;
  }

  @NotNull
  @Override
  public JComponent getComponent() {
    return myComponent;
  }

  @Nullable
  @Override
  public JComponent getPreferredFocusedComponent() {
    return myMainEditor.getPreferredFocusedComponent();
  }

  @NotNull
  @Override
  public FileEditorState getState(@NotNull FileEditorStateLevel level) {
    return new MyFileEditorState(mySplitEditorLayout.name(), myMainEditor.getState(level), null);
  }

  @Override
  public void setState(@NotNull FileEditorState state) {
    if (state instanceof MyFileEditorState) {
      final MyFileEditorState compositeState = (MyFileEditorState)state;
      if (compositeState.getFirstState() != null) {
        myMainEditor.setState(compositeState.getFirstState());
      }
      if (compositeState.getSplitLayout() != null) {
        mySplitEditorLayout = SplitEditorLayout.valueOf(compositeState.getSplitLayout());
        invalidateLayout();
      }
    }
  }

  @Override
  public boolean isModified() {
    return myMainEditor.isModified();
  }

  @Override
  public boolean isValid() {
    return myMainEditor.isValid();
  }

  @Override
  public void selectNotify() {
    myMainEditor.selectNotify();
  }

  @Override
  public void deselectNotify() {
    myMainEditor.deselectNotify();
  }

  @Override
  public void addPropertyChangeListener(@NotNull PropertyChangeListener listener) {
    myMainEditor.addPropertyChangeListener(listener);

    final DoublingEventListenerDelegate delegate = myListenersGenerator.addListenerAndGetDelegate(listener);
    myMainEditor.addPropertyChangeListener(delegate);
  }

  @Override
  public void removePropertyChangeListener(@NotNull PropertyChangeListener listener) {
    myMainEditor.removePropertyChangeListener(listener);

    final DoublingEventListenerDelegate delegate = myListenersGenerator.removeListenerAndGetDelegate(listener);
    if (delegate != null) {
      myMainEditor.removePropertyChangeListener(delegate);
    }
  }

  @Nullable
  @Override
  public BackgroundEditorHighlighter getBackgroundHighlighter() {
    return myMainEditor.getBackgroundHighlighter();
  }

  @Nullable
  @Override
  public FileEditorLocation getCurrentLocation() {
    return myMainEditor.getCurrentLocation();
  }

  @Nullable
  @Override
  public StructureViewBuilder getStructureViewBuilder() {
    return myMainEditor.getStructureViewBuilder();
  }

  @Override
  public void dispose() {
    Disposer.dispose(myMainEditor);
  }

  static class MyFileEditorState implements FileEditorState {
    @Nullable
    private final String mySplitLayout;
    @Nullable
    private final FileEditorState myFirstState;
    @Nullable
    private final FileEditorState mySecondState;

    public MyFileEditorState(@Nullable String splitLayout, @Nullable FileEditorState firstState, @Nullable FileEditorState secondState) {
      mySplitLayout = splitLayout;
      myFirstState = firstState;
      mySecondState = secondState;
    }

    @Nullable
    public String getSplitLayout() {
      return mySplitLayout;
    }

    @Nullable
    public FileEditorState getFirstState() {
      return myFirstState;
    }

    @Nullable
    public FileEditorState getSecondState() {
      return mySecondState;
    }

    @Override
    public boolean canBeMergedWith(FileEditorState otherState, FileEditorStateLevel level) {
      return otherState instanceof MyFileEditorState
             && (myFirstState == null || myFirstState.canBeMergedWith(((MyFileEditorState)otherState).myFirstState, level))
             && (mySecondState == null || mySecondState.canBeMergedWith(((MyFileEditorState)otherState).mySecondState, level));
    }
  }

  private class DoublingEventListenerDelegate implements PropertyChangeListener {
    @NotNull
    private final PropertyChangeListener myDelegate;

    private DoublingEventListenerDelegate(@NotNull PropertyChangeListener delegate) {
      myDelegate = delegate;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
      myDelegate.propertyChange(new PropertyChangeEvent(SplitFileEditor.this, evt.getPropertyName(), evt.getOldValue(), evt.getNewValue()));
    }
  }

  private class MyListenersMultimap {
    private final Map<PropertyChangeListener, Pair<Integer, DoublingEventListenerDelegate>> myMap =
      new HashMap<PropertyChangeListener, Pair<Integer, DoublingEventListenerDelegate>>();

    @NotNull
    public DoublingEventListenerDelegate addListenerAndGetDelegate(@NotNull PropertyChangeListener listener) {
      if (!myMap.containsKey(listener)) {
        myMap.put(listener, Pair.create(1, new DoublingEventListenerDelegate(listener)));
      }
      else {
        final Pair<Integer, DoublingEventListenerDelegate> oldPair = myMap.get(listener);
        myMap.put(listener, Pair.create(oldPair.getFirst() + 1, oldPair.getSecond()));
      }

      return myMap.get(listener).getSecond();
    }

    @Nullable
    public DoublingEventListenerDelegate removeListenerAndGetDelegate(@NotNull PropertyChangeListener listener) {
      final Pair<Integer, DoublingEventListenerDelegate> oldPair = myMap.get(listener);
      if (oldPair == null) {
        return null;
      }

      if (oldPair.getFirst() == 1) {
        myMap.remove(listener);
      }
      else {
        myMap.put(listener, Pair.create(oldPair.getFirst() - 1, oldPair.getSecond()));
      }
      return oldPair.getSecond();
    }
  }

  public enum SplitEditorLayout {
    FIRST(true, false, "markdown.layout.editor.only");

        public final boolean showFirst;
    public final boolean showSecond;
    public final String presentationName;

    SplitEditorLayout(boolean showFirst, boolean showSecond, String presentationName) {
      this.showFirst = showFirst;
      this.showSecond = showSecond;
      this.presentationName = presentationName;
    }

    @Override
    public String toString() {
      return presentationName;
    }
  }
}
