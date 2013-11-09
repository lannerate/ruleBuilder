package com.flagleader.repository.lang.expression;

import com.flagleader.repository.rlm.action.ReturnToken;
import com.flagleader.repository.rlm.lang.IStatementToken;

public class u extends a
  implements d
{
  private int e = 0;

  public u(StatementSystem paramStatementSystem, String paramString)
  {
    super(paramStatementSystem, paramString);
    e(paramString);
  }

  private void e(String paramString)
  {
    for (int i = 0; i < StatementSystem.l.length; i++)
    {
      if (!paramString.startsWith(StatementSystem.l[i]))
        continue;
      this.e = i;
      return;
    }
  }

  public IStatementToken a()
  {
    ReturnToken localReturnToken = new ReturnToken();
    localReturnToken.setReturnType(this.e);
    return localReturnToken;
  }

  public Object a(g paramg)
  {
    return paramg.a(this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.expression.u
 * JD-Core Version:    0.6.0
 */