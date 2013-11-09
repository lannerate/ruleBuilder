package com.flagleader.repository.rlm.editen;

import com.flagleader.repository.IElement;

public abstract interface ILineEditen extends IEditen
{
  public abstract boolean canPasteElement(IElement paramIElement);

  public abstract boolean canCut();

  public abstract boolean canCopy();

  public abstract IElement copyElement();

  public abstract boolean pasteElement(IElement paramIElement);

  public abstract IElement cutElement();

  public abstract boolean isChanged();

  public abstract String getJavaCode();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.editen.ILineEditen
 * JD-Core Version:    0.6.0
 */