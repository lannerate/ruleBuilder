package com.flagleader.repository.rlm.condition;

import com.flagleader.repository.IElement;
import com.flagleader.repository.c.m;
import com.flagleader.repository.k;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.JudgeToken;
import com.flagleader.repository.rlm.d;
import com.flagleader.repository.rlm.lang.IJudgeToken;

public class DateJudgeToken extends JudgeToken
  implements IJudgeToken
{
  public static final int EQUALTO = 0;
  public static final int NOTEQUALTO = 1;
  public static final int MORETHAN = 2;
  public static final int MOREANDEQUAL = 3;
  public static final int LESSTHAN = 4;
  public static final int LESSANDEQUAL = 5;
  public static final int EXITS = 6;
  public static final int NOTEXITS = 7;
  public static final int EQUALSYEAR = 8;
  public static final int EQUALSQUARTER = 9;
  public static final int EQUALSMONTH = 10;
  public static final int EQUALSDAYS = 11;
  private static final String[] messages = { "&EqualsTo", "&NotEqualsTo", "&MoreThan", "&MoreAndEqual", "&LessThan", "&LessAndEqual", "&exits", "&notExits", "&EqualsYear", "&EqualsQuarter", "&EqualsMonth", "&EqualsDay" };

  public DateJudgeToken()
  {
    setType(0);
  }

  public DateJudgeToken(DateJudgeToken paramDateJudgeToken)
  {
    super(paramDateJudgeToken);
  }

  public DateJudgeToken(m paramm)
  {
    this();
    addJudgeTokenListener(paramm);
  }

  public int getCount()
  {
    return 12;
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

  public boolean acceptType(g paramg)
  {
    return (paramg.v()) || (paramg.w()) || (paramg.x());
  }

  public IElement deepClone()
  {
    return new DateJudgeToken(this);
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

  public String getName()
  {
    return "DateJudgeToken";
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
 * Qualified Name:     com.flagleader.repository.rlm.condition.DateJudgeToken
 * JD-Core Version:    0.6.0
 */