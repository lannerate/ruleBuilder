package com.flagleader.repository.lang.expression;

import com.flagleader.repository.rlm.action.JavaStatementToken;
import com.flagleader.repository.rlm.lang.IStatementToken;

public class s extends a
  implements d
{
  public s(StatementSystem paramStatementSystem, String paramString)
  {
    super(paramStatementSystem, paramString);
  }

  public IStatementToken a()
  {
    JavaStatementToken localJavaStatementToken = new JavaStatementToken();
    localJavaStatementToken.setText(this.b);
    return localJavaStatementToken;
  }

  public Object a(g paramg)
  {
    return paramg.a(this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.expression.s
 * JD-Core Version:    0.6.0
 */