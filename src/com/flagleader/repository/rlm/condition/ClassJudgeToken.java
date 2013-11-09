package com.flagleader.repository.rlm.condition;

import com.flagleader.repository.IElement;
import com.flagleader.repository.k;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.JudgeToken;
import com.flagleader.repository.rlm.d;
import com.flagleader.repository.rlm.lang.IJudgeToken;

public class ClassJudgeToken extends JudgeToken
  implements IJudgeToken
{
  public static final int EXITS = 0;
  public static final int NOTEXITS = 1;
  private static final String[] messages = { "&exits", "&notExits" };

  public ClassJudgeToken()
  {
    setType(0);
  }

  public ClassJudgeToken(ClassJudgeToken paramClassJudgeToken)
  {
    super(paramClassJudgeToken);
  }

  public String getName()
  {
    return "ClassJudgeToken";
  }

  public int getCount()
  {
    return 2;
  }

  public boolean acceptType(g paramg)
  {
    return (paramg.p()) || (paramg.z());
  }

  protected k b(int paramInt)
  {
    return new d(this, paramInt);
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

  protected String a(int paramInt)
  {
    return messages[paramInt];
  }

  public IElement deepClone()
  {
    return new ClassJudgeToken(this);
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
 * Qualified Name:     com.flagleader.repository.rlm.condition.ClassJudgeToken
 * JD-Core Version:    0.6.0
 */