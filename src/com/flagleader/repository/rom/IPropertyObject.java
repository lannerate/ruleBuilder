package com.flagleader.repository.rom;

public abstract interface IPropertyObject extends IVariableObject
{
  public abstract String getGetMethodName();

  public abstract String getSetMethodPreName();

  public abstract String getSetMethodSufName();

  public abstract String getGroupName();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.IPropertyObject
 * JD-Core Version:    0.6.0
 */