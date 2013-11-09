package com.flagleader.repository.tree;

import com.flagleader.repository.IElement;
import com.flagleader.repository.j;

public abstract interface IRuleContainer extends IElement, j
{
  public abstract void setModified(boolean paramBoolean);

  public abstract boolean isEmpty();

  public abstract boolean paste(IElement paramIElement);

  public abstract boolean isChangeLine(String paramString);

  public abstract IPackageElement getRuleTree();

  public abstract void setNeedSave();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.IRuleContainer
 * JD-Core Version:    0.6.0
 */