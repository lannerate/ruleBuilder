package com.flagleader.repository;

public abstract interface IElementViewer
{
  public abstract void update();

  public abstract boolean needUpdate();

  public abstract void dispose();

  public abstract void copy();

  public abstract void cut();

  public abstract boolean paste();

  public abstract boolean canCut();

  public abstract boolean canCopy();

  public abstract boolean canDelete();

  public abstract boolean canPaste();

  public abstract void delete();

  public abstract void selectAll();

  public abstract boolean isCanSelectAll();

  public abstract boolean isCanFind();

  public abstract void find();

  public abstract void findNext();

  public abstract boolean canRedo();

  public abstract boolean canUndo();

  public abstract boolean redo();

  public abstract boolean undo();

  public abstract String getCompositeUuid();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.IElementViewer
 * JD-Core Version:    0.6.0
 */