package com.flagleader.repository.rom;

import java.util.List;

public abstract interface IFunctionObject extends IBusinessObject
{
  public abstract String getFunctionName();

  public abstract int getParamCount();

  public abstract List getParams();

  public abstract String getGroupName();

  public abstract void setGroupName(String paramString);

  public abstract void changeParams();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.IFunctionObject
 * JD-Core Version:    0.6.0
 */