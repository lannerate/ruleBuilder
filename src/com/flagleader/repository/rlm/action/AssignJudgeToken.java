package com.flagleader.repository.rlm.action;

import com.flagleader.repository.IElement;
import com.flagleader.repository.k;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.JudgeToken;
import com.flagleader.repository.rlm.d;
import com.flagleader.repository.rlm.lang.IAssignToken;

public class AssignJudgeToken extends JudgeToken
  implements IAssignToken
{
  public static final int EQUALTO = 0;
  private static final String[] messages = { "&AssignTo" };

  public AssignJudgeToken()
  {
    this.a = 0;
  }

  public AssignJudgeToken(int paramInt)
  {
    super(paramInt);
  }

  public AssignJudgeToken(AssignJudgeToken paramAssignJudgeToken)
  {
    super(paramAssignJudgeToken);
  }

  public String getName()
  {
    return "AssignJudgeToken";
  }

  public int getCount()
  {
    return 1;
  }

  protected k b(int paramInt)
  {
    return new d(this, paramInt);
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
    }
    return str;
  }

  protected String a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getCount()))
      return "&noType";
    return messages[paramInt];
  }

  public String getRlmStr()
  {
    String str = "";
    switch (getType())
    {
    case 0:
      str = "=";
    }
    return str;
  }

  public boolean acceptType(g paramg)
  {
    return true;
  }

  public IElement deepClone()
  {
    return new AssignJudgeToken(this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.AssignJudgeToken
 * JD-Core Version:    0.6.0
 */