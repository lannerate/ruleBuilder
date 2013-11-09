package com.flagleader.repository.lang.expression;

import com.flagleader.repository.rlm.action.ThrowToken;
import com.flagleader.repository.rlm.lang.IStatementToken;
import com.flagleader.repository.rlm.value.ValueToken;

public class v extends a
  implements d
{
  k e;

  public v(StatementSystem paramStatementSystem, String paramString)
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
    ThrowToken localThrowToken = new ThrowToken();
    ValueToken localValueToken = new ValueToken(1, "string", "");
    localThrowToken.addChildElement(localValueToken);
    if (this.e != null)
      this.e.a(localValueToken, "string");
    return localThrowToken;
  }

  public Object a(g paramg)
  {
    return paramg.a(this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.expression.v
 * JD-Core Version:    0.6.0
 */