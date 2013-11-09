package com.flagleader.repository.rlm.lang;

import com.flagleader.repository.rlm.IRuleObject;

public abstract interface ILangToken extends IRuleObject
{
  public abstract boolean isIgniorString();

  public abstract int getDatenulltype();

  public abstract String getText();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.lang.ILangToken
 * JD-Core Version:    0.6.0
 */