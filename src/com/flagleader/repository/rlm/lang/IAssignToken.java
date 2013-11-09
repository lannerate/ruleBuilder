package com.flagleader.repository.rlm.lang;

public abstract interface IAssignToken extends ILangToken
{
  public abstract int getType();

  public abstract void setType(int paramInt);

  public abstract void setTextMessage(String paramString);
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.lang.IAssignToken
 * JD-Core Version:    0.6.0
 */