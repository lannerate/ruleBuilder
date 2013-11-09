package com.flagleader.repository.rlm.condition;

import com.flagleader.repository.IElement;
import com.flagleader.repository.k;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.JudgeToken;
import com.flagleader.repository.rlm.d;
import com.flagleader.repository.rlm.lang.IJudgeToken;

public class BooleanJudgeToken extends JudgeToken
  implements IJudgeToken
{
  public static final int YES = 0;
  public static final int NO = 1;
  private static final String[] messages = { "&yes", "&no" };

  public BooleanJudgeToken()
  {
    setType(0);
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

  public BooleanJudgeToken(BooleanJudgeToken paramBooleanJudgeToken)
  {
    super(paramBooleanJudgeToken);
  }

  public BooleanJudgeToken(int paramInt)
  {
    super(paramInt);
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
    for (int i = 0; i < messages.length; i++)
    {
      if (!getTypeName(i).equals(paramString))
        continue;
      this.a = i;
      break;
    }
  }

  public boolean acceptType(g paramg)
  {
    return paramg.e();
  }

  public IElement deepClone()
  {
    return new BooleanJudgeToken(this);
  }

  public String getName()
  {
    return "BooleanJudgeToken";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.condition.BooleanJudgeToken
 * JD-Core Version:    0.6.0
 */