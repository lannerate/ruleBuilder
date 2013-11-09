package com.flagleader.repository.excel;

import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElementEditor;
import com.flagleader.repository.rom.IBusinessObjectEditen;

public abstract interface IExcelObject extends IBusinessObjectContainer, IBusinessObjectEditen
{
  public abstract void setElementEditor(IElementEditor paramIElementEditor);
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.excel.IExcelObject
 * JD-Core Version:    0.6.0
 */