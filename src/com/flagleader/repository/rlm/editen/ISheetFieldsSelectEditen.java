package com.flagleader.repository.rlm.editen;

import com.flagleader.repository.rom.IBusinessObject;
import java.util.List;

public abstract interface ISheetFieldsSelectEditen extends IEditen
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

  public abstract void setSelected(List paramList);

  public abstract boolean hasSelects();

  public abstract List getSelectedElements();

  public abstract IBusinessObject getMemberElement();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.editen.ISheetFieldsSelectEditen
 * JD-Core Version:    0.6.0
 */