package com.flagleader.repository.rlm.lang;

import com.flagleader.repository.lang.g;

public abstract interface IJudgeToken extends ILangToken
{
  public abstract int getType();

  public abstract boolean acceptType(g paramg);

  public abstract void setType(int paramInt);

  public abstract void setNewType(int paramInt);

  public abstract void setTextMessage(String paramString);
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.lang.IJudgeToken
 * JD-Core Version:    0.6.0
 */