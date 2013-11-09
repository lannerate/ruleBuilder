package com.flagleader.repository.lang.expression;

import com.flagleader.repository.rlm.action.ExeRuleToken;
import com.flagleader.repository.rlm.action.SelectRulePackageToken;
import com.flagleader.repository.rlm.lang.IStatementToken;

public class r extends a
  implements d
{
  String e;
  private int f = 0;

  public r(StatementSystem paramStatementSystem, String paramString)
  {
    super(paramStatementSystem, paramString);
    e(paramString);
  }

  private void e(String paramString)
  {
    for (int i = 0; i < StatementSystem.n.length; i++)
    {
      if (!paramString.startsWith(StatementSystem.n[i]))
        continue;
      this.f = i;
      this.e = paramString.substring(StatementSystem.n[i].length()).trim();
      return;
    }
  }

  public IStatementToken a()
  {
    ExeRuleToken localExeRuleToken = new ExeRuleToken();
    localExeRuleToken.setReturnType(this.f);
    localExeRuleToken.init();
    localExeRuleToken.getRuleNameToken().setExeRuleName(this.e);
    return localExeRuleToken;
  }

  public Object a(g paramg)
  {
    return paramg.a(this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.expression.r
 * JD-Core Version:    0.6.0
 */