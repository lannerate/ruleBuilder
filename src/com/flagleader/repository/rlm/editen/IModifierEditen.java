package com.flagleader.repository.rlm.editen;

import com.flagleader.repository.IElement;
import com.flagleader.repository.k;

public abstract interface IModifierEditen extends IEditen
{
  public abstract k getEvent();

  public abstract String getNote();

  public abstract String getImageName();

  public abstract boolean canPasteElement(IElement paramIElement);

  public abstract boolean canCut();

  public abstract boolean canCopy();

  public abstract IElement copyElement();

  public abstract boolean pasteElement(IElement paramIElement);

  public abstract IElement cutElement();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.editen.IModifierEditen
 * JD-Core Version:    0.6.0
 */