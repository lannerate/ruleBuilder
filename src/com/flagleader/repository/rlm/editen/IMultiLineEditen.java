package com.flagleader.repository.rlm.editen;

import com.flagleader.repository.IElement;
import com.flagleader.repository.tree.IRuleContainer;
import java.util.Iterator;

public abstract interface IMultiLineEditen extends ILineEditen
{
  public abstract Iterator getMultiLine();

  public abstract boolean paste(IElement paramIElement);

  public abstract IRuleContainer getRoot();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.editen.IMultiLineEditen
 * JD-Core Version:    0.6.0
 */