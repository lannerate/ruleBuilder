package com.flagleader.repository.rlm.condition;

import com.flagleader.repository.IElement;
import com.flagleader.repository.k;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.JudgeToken;
import com.flagleader.repository.rlm.d;
import com.flagleader.repository.rlm.lang.IJudgeToken;

public class NumberJudgeToken extends JudgeToken
  implements IJudgeToken
{
  public static final int EQUALTO = 0;
  public static final int NOTEQUALTO = 1;
  public static final int MORETHAN = 2;
  public static final int MOREANDEQUAL = 3;
  public static final int LESSTHAN = 4;
  public static final int LESSANDEQUAL = 5;
  private static final String[] messages = { "&EqualsTo", "&NotEqualsTo", "&MoreThan", "&MoreAndEqual", "&LessThan", "&LessAndEqual" };

  public NumberJudgeToken()
  {
    setType(0);
  }

  public NumberJudgeToken(NumberJudgeToken paramNumberJudgeToken)
  {
    super(paramNumberJudgeToken);
  }

  public String getName()
  {
    return "NumberJudgeToken";
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
    if ((paramInt < 0) || (paramInt >= getCount()))
      return "&noType";
    return messages[paramInt];
  }

  public void setTextMessage(String paramString)
  {
    for (int i = 0; i < messages.length; i++)
    {
      if ((!getLanguageName(i).equals(paramString)) && (!getTypeName(i).equals(paramString)))
        continue;
      this.a = i;
      break;
    }
  }

  public String getLanguageName(int paramInt)
  {
    String str = "";
    switch (paramInt)
    {
    case 0:
      str = "==";
      break;
    case 1:
      str = "!=";
      break;
    case 2:
      str = ">";
      break;
    case 3:
      str = ">=";
      break;
    case 4:
      str = "<";
      break;
    case 5:
      str = "<=";
    }
    return str;
  }

  public String getRlmStr()
  {
    String str = "";
    switch (getType())
    {
    case 0:
      str = "==";
      break;
    case 1:
      str = "!=";
      break;
    case 2:
      str = ">";
      break;
    case 3:
      str = ">=";
      break;
    case 4:
      str = "<";
      break;
    case 5:
      str = "<=";
    }
    return str;
  }

  public boolean acceptType(g paramg)
  {
    return (paramg.b()) || (paramg.d());
  }

  public IElement deepClone()
  {
    return new NumberJudgeToken(this);
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
 * Qualified Name:     com.flagleader.repository.rlm.condition.NumberJudgeToken
 * JD-Core Version:    0.6.0
 */