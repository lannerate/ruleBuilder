package com.flagleader.repository.rlm.action;

import com.flagleader.repository.IElement;
import com.flagleader.repository.k;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.JudgeToken;
import com.flagleader.repository.rlm.d;
import com.flagleader.repository.rlm.lang.IAssignToken;

public class NumberAssignJudgeToken extends JudgeToken
  implements IAssignToken
{
  public static final int EQUALTO = 0;
  public static final int ADDTO = 1;
  public static final int MINUSTO = 2;
  public static final int PLUSTO = 3;
  public static final int DIVIDETO = 4;
  public static final int DIVTO = 5;
  private static final String[] messages = { "&AssignTo", "&AddTo", "&MinusTo", "&MultiplyTo", "&DivideTo", "&DivTo" };

  public NumberAssignJudgeToken()
  {
    this.a = 0;
  }

  public NumberAssignJudgeToken(int paramInt)
  {
    super(paramInt);
  }

  public NumberAssignJudgeToken(NumberAssignJudgeToken paramNumberAssignJudgeToken)
  {
    super(paramNumberAssignJudgeToken);
  }

  public String getName()
  {
    return "NumberAssignJudgeToken";
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
      str = "=";
      break;
    case 1:
      str = "+=";
      break;
    case 2:
      str = "-=";
      break;
    case 3:
      str = "*=";
      break;
    case 4:
      str = "/=";
      break;
    case 5:
      str = "%=";
    }
    return str;
  }

  public String getRlmStr()
  {
    return getLanguageName(getType());
  }

  public boolean acceptType(g paramg)
  {
    return true;
  }

  public IElement deepClone()
  {
    return new NumberAssignJudgeToken(this);
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
 * Qualified Name:     com.flagleader.repository.rlm.action.NumberAssignJudgeToken
 * JD-Core Version:    0.6.0
 */