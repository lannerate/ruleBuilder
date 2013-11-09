package com.flagleader.repository.lang.expression;

import com.flagleader.repository.rlm.action.LogRecordToken;
import com.flagleader.repository.rlm.lang.IStatementToken;
import com.flagleader.repository.rlm.value.ValueToken;

public class t extends a
  implements d
{
  k e;
  private int f = 0;

  public t(StatementSystem paramStatementSystem, String paramString)
  {
    super(paramStatementSystem, paramString);
    e(paramString);
  }

  private void e(String paramString)
  {
    for (int i = 0; i < StatementSystem.m.length; i++)
    {
      if (!paramString.startsWith(StatementSystem.m[i]))
        continue;
      this.f = i;
      this.e = new k(this.a, paramString.substring(StatementSystem.m[i].length()).trim());
      return;
    }
  }

  public IStatementToken a()
  {
    LogRecordToken localLogRecordToken = new LogRecordToken();
    localLogRecordToken.setReturnType(this.f);
    ValueToken localValueToken = new ValueToken(1, "string", "");
    localLogRecordToken.addChildElement(localValueToken);
    if (this.e != null)
      this.e.a(localValueToken, "string");
    return localLogRecordToken;
  }

  public Object a(g paramg)
  {
    return paramg.a(this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.expression.t
 * JD-Core Version:    0.6.0
 */