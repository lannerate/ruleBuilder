package com.flagleader.repository.rlm.editen;

import com.flagleader.repository.rom.IBusinessObject;

public abstract interface ISheetFieldEditen extends IEditen
{
  public abstract String getDisplayName();

  public abstract boolean canEdit();

  public abstract String getColorType();

  public abstract String getText();

  public abstract void setText(String paramString);

  public abstract boolean checkValue(String paramString);

  public abstract boolean hasHint();

  public abstract String getHint();

  public abstract IBusinessObject[] getSelects();

  public abstract void setSelected(IBusinessObject paramIBusinessObject);

  public abstract boolean hasSelects();

  public abstract IBusinessObject getSelected();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.editen.ISheetFieldEditen
 * JD-Core Version:    0.6.0
 */