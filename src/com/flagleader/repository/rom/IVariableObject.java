package com.flagleader.repository.rom;

public abstract interface IVariableObject extends IBusinessObject
{
  public abstract String getVariableName();

  public abstract boolean isLoged();

  public abstract void setLoged(boolean paramBoolean);

  public abstract boolean canSetLoged();

  public abstract String getVarSaveValue();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.IVariableObject
 * JD-Core Version:    0.6.0
 */