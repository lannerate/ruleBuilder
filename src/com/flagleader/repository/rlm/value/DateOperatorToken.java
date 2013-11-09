package com.flagleader.repository.rlm.value;

import com.flagleader.repository.IElement;
import com.flagleader.repository.k;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.JudgeToken;
import com.flagleader.repository.rlm.d;
import com.flagleader.repository.rlm.lang.IOperatorToken;

public class DateOperatorToken extends JudgeToken
  implements IOperatorToken
{
  public static final int NOOPERATOR = 0;
  public static final int ADDOPERATOR = 1;
  public static final int MINUSOPERATOR = 2;
  private static final String[] messages = { "&NoOperator", "&AddOperator" };

  public DateOperatorToken()
  {
    super(0);
  }

  public DateOperatorToken(DateOperatorToken paramDateOperatorToken)
  {
    super(paramDateOperatorToken);
  }

  public DateOperatorToken(int paramInt)
  {
    super(paramInt);
  }

  public String getName()
  {
    return "DateOperatorToken";
  }

  public int getCount()
  {
    return 2;
  }

  public void setTextMessage(String paramString)
  {
    for (int i = 1; i < messages.length; i++)
    {
      if ((!getLanguageName(i).equals(paramString)) && (!getTypeName(i).equals(paramString)))
        continue;
      this.a = i;
      break;
    }
  }

  protected k b(int paramInt)
  {
    return new d(this, paramInt);
  }

  protected String a(int paramInt)
  {
    return messages[paramInt];
  }

  public String getLanguageName(int paramInt)
  {
    String str = "";
    switch (paramInt)
    {
    case 1:
      str = "+";
      break;
    case 2:
      str = "-";
    }
    return str;
  }

  public String getRlmStr()
  {
    return getLanguageName(getType());
  }

  public IElement deepClone()
  {
    return new DateOperatorToken(this);
  }

  public boolean acceptType(g paramg)
  {
    return paramg.v();
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

  public String toString()
  {
    if (this.a == 0)
      return "";
    return super.toString();
  }

  public String getColorType()
  {
    return "operator";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.DateOperatorToken
 * JD-Core Version:    0.6.0
 */