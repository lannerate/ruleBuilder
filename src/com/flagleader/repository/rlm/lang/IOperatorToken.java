package com.flagleader.repository.rlm.lang;

import com.flagleader.repository.c.m;

public abstract interface IOperatorToken extends ILangToken
{
  public abstract boolean isNoOperator();

  public abstract void addJudgeTokenListener(m paramm);

  public abstract void setType(int paramInt);

  public abstract void setNewType(int paramInt);

  public abstract int getType();

  public abstract boolean isAddOperator();

  public abstract int getAddType();

  public abstract void setTextMessage(String paramString);
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.lang.IOperatorToken
 * JD-Core Version:    0.6.0
 */