package com.flagleader.repository.rlm.lang;

import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.editen.ISelectorEditen;

public abstract interface IValueContainerToken extends ILangToken
{
  public abstract ISelectorEditen getSelector();

  public abstract int getLeftParenthesisNumber();

  public abstract int getRightParenthesisNumber();

  public abstract IValueToken getValueElement();

  public abstract IOperatorToken getOperator();

  public abstract IValueContainerToken getNextValue();

  public abstract String getValueType();

  public abstract void changeValueType(String paramString);

  public abstract g getJavaType();

  public abstract boolean pasteBusinessObject(Object paramObject);

  public abstract boolean canPasteObject(Object paramObject);

  public abstract boolean checkOperator();

  public abstract boolean isEmpty();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.lang.IValueContainerToken
 * JD-Core Version:    0.6.0
 */