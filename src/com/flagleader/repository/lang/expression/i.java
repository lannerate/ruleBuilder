package com.flagleader.repository.lang.expression;

import com.flagleader.repository.rlm.action.DebugToken;
import com.flagleader.repository.rlm.action.StatementContainerToken;
import com.flagleader.repository.rlm.action.ThrowToken;

public class i extends a
{
  protected d e;

  public i(StatementSystem paramStatementSystem, String paramString)
  {
    super(paramStatementSystem, paramString);
    e(paramString);
  }

  public void a(StatementContainerToken paramStatementContainerToken)
  {
    if (this.e != null)
      paramStatementContainerToken.addChildElement(this.e.a());
  }

  private void e(String paramString)
  {
    for (int i = 0; i < StatementSystem.b.length; i++)
    {
      if (paramString.indexOf(StatementSystem.b[i]) < 0)
        continue;
      this.e = new p(this.a, paramString);
      return;
    }
    if (paramString.startsWith("java:"))
    {
      this.e = new s(this.a, paramString.substring("java:".length()).trim());
      return;
    }
    if (paramString.startsWith(ThrowToken.THROWINFO))
    {
      this.e = new v(this.a, paramString.substring(ThrowToken.THROWINFO.length()).trim());
      return;
    }
    for (i = 0; i < StatementSystem.l.length; i++)
    {
      if (!paramString.startsWith(StatementSystem.l[i]))
        continue;
      this.e = new u(this.a, StatementSystem.l[i]);
      return;
    }
    for (i = 0; i < StatementSystem.m.length; i++)
    {
      if (!paramString.startsWith(StatementSystem.m[i]))
        continue;
      this.e = new t(this.a, paramString);
      return;
    }
    if (paramString.startsWith(DebugToken.DEBUGINFO))
    {
      this.e = new q(this.a, paramString.substring(DebugToken.DEBUGINFO.length()).trim());
      return;
    }
    for (i = 0; i < StatementSystem.n.length; i++)
    {
      if (!paramString.startsWith(StatementSystem.n[i]))
        continue;
      this.e = new r(this.a, paramString);
      return;
    }
    this.e = new x(this.a, paramString);
  }

  public String toString()
  {
    return this.e.toString();
  }

  public Object a(g paramg)
  {
    return paramg.a(this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.expression.i
 * JD-Core Version:    0.6.0
 */