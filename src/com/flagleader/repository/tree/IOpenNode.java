package com.flagleader.repository.tree;

import com.flagleader.repository.IElement;
import java.util.Iterator;
import java.util.List;

public abstract interface IOpenNode extends IElement
{
  public abstract void backup(List paramList);

  public abstract void clearBackup(List paramList);

  public abstract void clearAutoSave();

  public abstract List getAutoSavedPack();

  public abstract boolean recoverAutoSavePack(List paramList);

  public abstract Iterator getRulePackages();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.IOpenNode
 * JD-Core Version:    0.6.0
 */