package com.flagleader.repository.lang.expression;

import com.flagleader.repository.rlm.action.MultiActionToken;
import com.flagleader.repository.rlm.action.StatementContainerToken;
import com.flagleader.repository.rlm.lang.IMultiActionToken;
import com.flagleader.util.StringUtil;

public class b extends a
{
  i[] e = e(paramString);

  public b(StatementSystem paramStatementSystem, String paramString)
  {
    super(paramStatementSystem, paramString);
  }

  public i[] e(String paramString)
  {
    String str = StringUtil.replace("\r", "", paramString);
    int i = StatementSystem.a(str, 0);
    if (i > 0)
      str = str.substring(0, i);
    String[] arrayOfString = str.trim().split("[\r\n]");
    i[] arrayOfi = new i[arrayOfString.length];
    for (int j = 0; j < arrayOfi.length; j++)
      arrayOfi[j] = new i(this.a, arrayOfString[j].trim());
    return arrayOfi;
  }

  public IMultiActionToken b()
  {
    MultiActionToken localMultiActionToken = new MultiActionToken(0);
    localMultiActionToken.setParent(this.a.c());
    for (int i = 0; i < this.e.length; i++)
    {
      if (this.e[i].b_())
        continue;
      StatementContainerToken localStatementContainerToken = new StatementContainerToken();
      localMultiActionToken.addChildElement(localStatementContainerToken);
      this.e[i].a(localStatementContainerToken);
    }
    return localMultiActionToken;
  }

  public Object a(g paramg)
  {
    return paramg.a(this);
  }

  public i[] c()
  {
    return this.e;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.expression.b
 * JD-Core Version:    0.6.0
 */