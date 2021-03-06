package com.flagleader.repository.rlm.value;

import com.flagleader.repository.IElement;
import com.flagleader.repository.k;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.JudgeToken;
import com.flagleader.repository.rlm.d;
import com.flagleader.repository.rlm.lang.IOperatorToken;

public class NumberOperatorToken extends JudgeToken
  implements IOperatorToken
{
  public static final int NOOPERATOR = 0;
  public static final int ADDOPERATOR = 1;
  public static final int MINUSOPERATOR = 2;
  public static final int MULTIPLYOPERATOR = 3;
  public static final int DIVIDEOPERATOR = 4;
  public static final int MODOPERATOR = 5;
  private static final String[] messages = { "&NoOperator", "&AddOperator", "&MinusOperator", "&MultiplyOperator", "&DivideOperator", "%" };

  public NumberOperatorToken()
  {
    super(0);
  }

  public NumberOperatorToken(NumberOperatorToken paramNumberOperatorToken)
  {
    super(paramNumberOperatorToken);
  }

  public NumberOperatorToken(int paramInt)
  {
    super(paramInt);
  }

  public String getName()
  {
    return "NumberOperatorToken";
  }

  public int getCount()
  {
    return 6;
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
      break;
    case 3:
      str = "*";
      break;
    case 4:
      str = "/";
      break;
    case 5:
      str = "%";
    }
    return str;
  }

  public String getRlmStr()
  {
    String str = "";
    switch (getType())
    {
    case 1:
      str = "+";
      break;
    case 2:
      str = "-";
      break;
    case 3:
      str = "*";
      break;
    case 4:
      str = "/";
      break;
    case 5:
      str = "%";
    }
    return str;
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

  public IElement deepClone()
  {
    return new NumberOperatorToken(this);
  }

  public boolean acceptType(g paramg)
  {
    return (paramg.b()) || (paramg.d()) || (paramg.j());
  }

  public boolean isNoOperator()
  {
    return (getType() == 0) || (getType() == -1);
  }

  public boolean isAddOperator()
  {
    return getType() == 1;
  }

  public boolean isMultiplyOperator()
  {
    return getType() >= 3;
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

  public static String[] getLocalMessages()
  {
    String[] arrayOfString = new String[messages.length];
    for (int i = 0; i < messages.length; i++)
    {
      String str = messages[i];
      if ((str != null) && (str.length() > 0) && (str.charAt(0) == '&'))
        str = getLocalString(str.substring(1) + ".edit", str.substring(1));
      arrayOfString[i] = str;
    }
    return arrayOfString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.NumberOperatorToken
 * JD-Core Version:    0.6.0
 */