package com.flagleader.repository.tree;

public abstract interface IDecision extends IRule
{
  public abstract boolean isValidConditoin(String paramString);

  public abstract boolean isValidElement(String paramString);

  public abstract boolean isValidElement2(String paramString);
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.IDecision
 * JD-Core Version:    0.6.0
 */