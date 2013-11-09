package com.flagleader.repository.rlm.action;

import com.flagleader.repository.c.a;

class G extends a
{
  G(StatementContainerToken paramStatementContainerToken)
  {
  }

  public void a()
  {
    StatementContainerToken.access$0(this.a);
    this.a.addChildElement(new ExeExpressionToken().init());
    StatementContainerToken.access$1(this.a);
    this.a.update();
  }

  public String c()
  {
    return "&setExpression";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.G
 * JD-Core Version:    0.6.0
 */