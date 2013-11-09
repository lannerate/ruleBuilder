package com.flagleader.repository.rlm.value;

import com.flagleader.repository.IElement;
import com.flagleader.repository.k;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.JudgeToken;
import com.flagleader.repository.rlm.d;
import com.flagleader.repository.rlm.lang.IOperatorToken;

public class StringOperatorToken extends JudgeToken
  implements IOperatorToken
{
  public static final int NOOPERATOR = 0;
  public static final int ADDOPERATOR = 1;
  private static final String[] messages = { "&NoOperator", "&AddOperator" };

  public StringOperatorToken()
  {
    super(0);
  }

  public StringOperatorToken(StringOperatorToken paramStringOperatorToken)
  {
    super(paramStringOperatorToken);
  }

  public StringOperatorToken(int paramInt)
  {
    super(paramInt);
  }

  public String getName()
  {
    return "StringOperatorToken";
  }

  public int getCount()
  {
    return 2;
  }

  protected k b(int paramInt)
  {
    return new d(this, paramInt);
  }

  protected String a(int paramInt)
  {
    return messages[paramInt];
  }

  public void setTextMessage(String paramString)
  {
    for (int i = 1; i < messages.length; i++)
    {
      if ((!"+".equals(paramString)) && (!getTypeName(i).equals(paramString)))
        continue;
      this.a = i;
      break;
    }
  }

  public String getRlmStr()
  {
    String str = "";
    switch (getType())
    {
    case 1:
      str = "+";
    }
    return str;
  }

  public IElement deepClone()
  {
    return new StringOperatorToken(this);
  }

  public boolean acceptType(g paramg)
  {
    return paramg.m();
  }

  public boolean isNoOperator()
  {
    return (getType() == 0) || (getType() == -1);
  }

  public boolean isAddOperator()
  {
    return getType() == 1;
  }

  public int getAddType()
  {
    return 1;
  }

  public String getColorType()
  {
    return "operator";
  }

  public String toString()
  {
    if (this.a == 0)
      return "";
    return super.toString();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.StringOperatorToken
 * JD-Core Version:    0.6.0
 */