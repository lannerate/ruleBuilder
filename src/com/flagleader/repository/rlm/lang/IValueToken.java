package com.flagleader.repository.rlm.lang;

import com.flagleader.repository.lang.g;

public abstract interface IValueToken extends ILangToken
{
  public abstract String getValueType();

  public abstract g getJavaType();

  public abstract void setValueType(String paramString);
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.lang.IValueToken
 * JD-Core Version:    0.6.0
 */