package com.flagleader.repository.export;

import com.flagleader.export.IExportElement;
import com.flagleader.repository.IElement;

public abstract interface IPageElement extends IExportElement, IElement
{
  public abstract String getDisplayName();

  public abstract boolean isEmptyProp(String paramString);

  public abstract boolean isPropValue(String paramString1, String paramString2);

  public abstract boolean isPropValueNoCase(String paramString1, String paramString2);

  public abstract String getPropertyValue(String paramString);
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.export.IPageElement
 * JD-Core Version:    0.6.0
 */