package com.flagleader.repository.lang.expression;

import com.flagleader.repository.rlm.action.DebugToken;
import com.flagleader.repository.rlm.lang.IStatementToken;
import com.flagleader.repository.rlm.value.ValueToken;

public class q extends a
  implements d
{
  k e;

  public q(StatementSystem paramStatementSystem, String paramString)
  {
    super(paramStatementSystem, paramString);
    e(paramString);
  }

  private void e(String paramString)
  {
    this.e = new k(this.a, paramString);
  }

  public IStatementToken a()
  {
    DebugToken localDebugToken = new DebugToken();
    ValueToken localValueToken = new ValueToken(1, "string", "");
    localDebugToken.addChildElement(localValueToken);
    if (this.e != null)
      this.e.a(localValueToken, "string");
    return localDebugToken;
  }

  public Object a(g paramg)
  {
    return paramg.a(this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.expression.q
 * JD-Core Version:    0.6.0
 */