package com.flagleader.repository.rlm.condition;

import com.flagleader.repository.IElement;
import com.flagleader.repository.c.m;
import com.flagleader.repository.k;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.d;

public class DecisionStringJudgeToken extends StringJudgeToken
{
  public static final int QITA = 12;
  private static final String[] messages = { "&Equals", "&notEquals", "&Include", "&notInclude", "&startWith", "&endWith", "&exits", "&notExits", "&notEmpty", "&isEmpty", "&stringInclude", "&notStringInclude", "&others" };

  public DecisionStringJudgeToken()
  {
    setType(0);
  }

  public DecisionStringJudgeToken(m paramm)
  {
    this();
    addJudgeTokenListener(paramm);
  }

  public DecisionStringJudgeToken(StringJudgeToken paramStringJudgeToken)
  {
    super(paramStringJudgeToken);
  }

  public String getName()
  {
    return "DecisionStringJudgeToken";
  }

  public int getCount()
  {
    return 13;
  }

  protected k b(int paramInt)
  {
    return new d(this, paramInt);
  }

  protected String a(int paramInt)
  {
    return messages[paramInt];
  }

  public boolean acceptType(g paramg)
  {
    return paramg.m();
  }

  public IElement deepClone()
  {
    return new DecisionStringJudgeToken(this);
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
 * Qualified Name:     com.flagleader.repository.rlm.condition.DecisionStringJudgeToken
 * JD-Core Version:    0.6.0
 */