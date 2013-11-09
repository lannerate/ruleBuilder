package com.flagleader.repository.rom;

public abstract interface ISubVariable extends IVariableObject
{
  public abstract IBusinessObject getParentObject();

  public abstract IBusinessObject getRootMember();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.ISubVariable
 * JD-Core Version:    0.6.0
 */