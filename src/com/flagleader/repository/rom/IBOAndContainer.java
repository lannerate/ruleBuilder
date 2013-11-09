package com.flagleader.repository.rom;

import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElementEditor;
import java.util.List;

public abstract interface IBOAndContainer extends IBusinessObjectContainer, IBusinessObjectEditen
{
  public abstract String getValueName();

  public abstract String getValueType();

  public abstract List getAllEditens();

  public abstract void setElementEditor(IElementEditor paramIElementEditor);
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.IBOAndContainer
 * JD-Core Version:    0.6.0
 */