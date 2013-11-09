package com.flagleader.repository.rlm.action;

import com.flagleader.repository.IElement;
import com.flagleader.repository.k;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.JudgeToken;
import com.flagleader.repository.rlm.d;
import com.flagleader.repository.rlm.lang.IAssignToken;

public class StringAssignJudgeToken extends JudgeToken
  implements IAssignToken
{
  public static final int EQUALTO = 0;
  public static final int ADDTO = 1;
  private static final String[] messages = { "&AssignTo", "&AddTo" };

  public StringAssignJudgeToken()
  {
    this.a = 0;
  }

  public StringAssignJudgeToken(int paramInt)
  {
    super(paramInt);
  }

  public StringAssignJudgeToken(StringAssignJudgeToken paramStringAssignJudgeToken)
  {
    super(paramStringAssignJudgeToken);
  }

  public String getName()
  {
    return "StringAssignJudgeToken";
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
    return new StringAssignJudgeToken(this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.StringAssignJudgeToken
 * JD-Core Version:    0.6.0
 */