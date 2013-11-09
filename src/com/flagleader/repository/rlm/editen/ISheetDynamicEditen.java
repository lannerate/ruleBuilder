package com.flagleader.repository.rlm.editen;

import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.IBusinessObject;
import java.util.List;

public abstract interface ISheetDynamicEditen extends IEditen, ISheetSelectEditen
{
  public abstract String getDisplayName();

  public abstract boolean canEdit();

  public abstract String getColorType();

  public abstract String getText();

  public abstract void setText(String paramString);

  public abstract boolean checkValue(String paramString);

  public abstract boolean hasHint();

  public abstract String getHint();

  public abstract List getCanSelectFields();

  public abstract List getCanSelectSourceFields();

  public abstract IBusinessObject getSheetField();

  public abstract IBusinessObject getSheetValue();

  public abstract void setSheetField(IBusinessObject paramIBusinessObject);

  public abstract void setSheetValue(IBusinessObject paramIBusinessObject);

  public abstract List getCanSelectSources();

  public abstract List getSelectedFields();

  public abstract IBusinessObject getSourceSheet();

  public abstract void setSourceSheet(IBusinessObject paramIBusinessObject);

  public abstract void resetFieldMappings();

  public abstract List getSelectedConditions();

  public abstract String[] getTypeFunctions(g paramg);
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.editen.ISheetDynamicEditen
 * JD-Core Version:    0.6.0
 */