package com.flagleader.repository;

import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IPackageElement;
import java.util.Iterator;
import java.util.List;

public abstract interface IBusinessObjectContainer extends j, IPackageElement
{
  public abstract Iterator getEditens();

  public abstract List getAllEditens();

  public abstract boolean canCreateEditen();

  public abstract IBusinessObjectEditen createSubEditen(String paramString);

  public abstract Envionment getEnvionment();

  public abstract boolean pasteElement(IElement paramIElement, int paramInt);

  public abstract void sortBy(int paramInt, String paramString, boolean paramBoolean);

  public abstract void replaceVariables(List paramList1, List paramList2, List paramList3, List paramList4);
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.IBusinessObjectContainer
 * JD-Core Version:    0.6.0
 */