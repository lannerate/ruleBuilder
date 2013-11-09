package com.flagleader.repository.rlm.editen;

import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.IBusinessObject;
import java.util.List;

public abstract interface ISheetFentanEditen extends IEditen
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

  public abstract List getCanSelectSourceFields(boolean paramBoolean);

  public abstract List getCanSelectSources();

  public abstract List getSelectedFields(boolean paramBoolean);

  public abstract IBusinessObject getSourceSheet(boolean paramBoolean);

  public abstract void setSourceSheet(IBusinessObject paramIBusinessObject, boolean paramBoolean);

  public abstract void resetFieldMappings(boolean paramBoolean);

  public abstract List getSelectedConditions();

  public abstract String[] getTypeFunctions(g paramg);

  public abstract void setSourcrField(IBusinessObject paramIBusinessObject, int paramInt);

  public abstract IBusinessObject getSourceField(int paramInt);
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.editen.ISheetFentanEditen
 * JD-Core Version:    0.6.0
 */