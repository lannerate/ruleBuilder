package com.flagleader.repository.tree;

import com.flagleader.repository.rom.IVariableObject;

public abstract interface IDebugNode extends ITreeNode
{
  public abstract boolean addVariableDebug(IVariableObject paramIVariableObject);

  public abstract boolean clearDebug();

  public abstract Envionment getEnvionment();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.IDebugNode
 * JD-Core Version:    0.6.0
 */