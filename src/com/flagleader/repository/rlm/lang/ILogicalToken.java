package com.flagleader.repository.rlm.lang;

public abstract interface ILogicalToken extends ILangToken
{
  public abstract boolean isNary();

  public abstract IConditionToken getParentCondition();

  public abstract void setNewType(int paramInt);
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.lang.ILogicalToken
 * JD-Core Version:    0.6.0
 */