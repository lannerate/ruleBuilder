package com.flagleader.repository.rom;

public abstract interface ISubFunction extends IFunctionObject
{
  public abstract IBusinessObject getParentObject();

  public abstract IBusinessObject getRootMember();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.ISubFunction
 * JD-Core Version:    0.6.0
 */