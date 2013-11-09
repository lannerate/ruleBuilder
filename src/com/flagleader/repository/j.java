package com.flagleader.repository;

public abstract interface j
{
  public abstract boolean undo();

  public abstract boolean canUndo();

  public abstract boolean canRedo();

  public abstract boolean redo();

  public abstract void takeSnapshot();

  public abstract void initUndoable();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.j
 * JD-Core Version:    0.6.0
 */