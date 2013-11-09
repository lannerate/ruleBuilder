package com.flagleader.repository.rlm.editen;

import com.flagleader.repository.IElement;
import com.flagleader.repository.l;

public abstract interface ISelectorEditen extends IEditen
{
  public abstract String getDisplayName();

  public abstract boolean canEdit();

  public abstract String getColorType();

  public abstract String getText();

  public abstract void setText(String paramString);

  public abstract boolean checkValue(String paramString);

  public abstract boolean hasHint();

  public abstract String getHint();

  public abstract l[] getLeftPopupMenus();

  public abstract boolean hasLeftPopupMenus();

  public abstract IElement getBusinessObject();

  public abstract boolean acceptBusinessObject(Object paramObject);

  public abstract boolean pasteBusinessObject(Object paramObject);
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.editen.ISelectorEditen
 * JD-Core Version:    0.6.0
 */