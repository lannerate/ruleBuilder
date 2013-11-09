package com.flagleader.repository.rlm.condition;

import com.flagleader.repository.IElement;
import com.flagleader.repository.c.m;
import com.flagleader.repository.k;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.JudgeToken;
import com.flagleader.repository.rlm.d;
import com.flagleader.repository.rlm.lang.IJudgeToken;

public class StringJudgeToken extends JudgeToken
  implements IJudgeToken
{
  public static final int EQUALS = 0;
  public static final int NOTEQUALS = 1;
  public static final int INCLUDE = 2;
  public static final int NOTINCLUDE = 3;
  public static final int STARTWITH = 4;
  public static final int ENDWITH = 5;
  public static final int EXITS = 6;
  public static final int NOTEXITS = 7;
  public static final int NOTEMPTY = 8;
  public static final int EMPTY = 9;
  public static final int STRINGINCLUDE = 10;
  public static final int NOTSTRINGINCLUDE = 11;
  public static final int QITA = 12;
  public static final int NOTSTARTWITH = 13;
  public static final int NOTENDWITH = 14;
  public static final int EQUALSREQULAR = 15;
  public static final int EQUALSNOCASE = 16;
  public static final int EQUALSNOSPACE = 17;
  public static final int EQUALSNOCODE = 19;
  public static final int EQUALSNOPUNCT = 18;
  public static final int EQUALSLOCALPUNCT = 20;
  public static final int COUNT = 21;
  private int snum = 12;
  private static final String[] messages = { "&Equals", "&notEquals", "&Include", "&notInclude", "&startWith", "&endWith", "&exits", "&notExits", "&notEmpty", "&isEmpty", "&stringInclude", "&notStringInclude", "&others", "&notstartwith", "&notendwith", "&equalsreqular", "&equalsnocase", "&equalsnospace", "&equalsnopunct", "&equalsnoascii", "&equalslocalpunct" };

  public StringJudgeToken()
  {
    setType(0);
  }

  public StringJudgeToken(int paramInt)
  {
    setType(paramInt);
  }

  public StringJudgeToken(m paramm, int paramInt)
  {
    this();
    addJudgeTokenListener(paramm);
    this.snum = paramInt;
  }

  public StringJudgeToken(StringJudgeToken paramStringJudgeToken)
  {
    super(paramStringJudgeToken);
  }

  public String getName()
  {
    return "StringJudgeToken";
  }

  public int getCount()
  {
    if ((getParent() != null) && ((getParent() instanceof DecisionConditionToken)))
      return 21;
    return 20;
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

  protected k b(int paramInt)
  {
    if ((getParent() != null) && ((getParent() instanceof DecisionConditionToken)))
      return new d(this, paramInt);
    if (paramInt >= 12)
      return new d(this, paramInt + 1);
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
    return new StringJudgeToken(this);
  }

  protected int d()
  {
    return 21;
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
 * Qualified Name:     com.flagleader.repository.rlm.condition.StringJudgeToken
 * JD-Core Version:    0.6.0
 */