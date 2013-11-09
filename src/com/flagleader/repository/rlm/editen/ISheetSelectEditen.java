package com.flagleader.repository.rlm.editen;

import com.flagleader.repository.rom.IBusinessObject;

public abstract interface ISheetSelectEditen extends IEditen
{
  public abstract IBusinessObject getSourceSheet();

  public abstract void setSourceSheet(IBusinessObject paramIBusinessObject);
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.editen.ISheetSelectEditen
 * JD-Core Version:    0.6.0
 */