package com.flagleader.repository.rlm.action;

import com.flagleader.repository.c.a;

class H extends a
{
  H(StatementContainerToken paramStatementContainerToken)
  {
  }

  public void a()
  {
    StatementContainerToken.access$0(this.a);
    this.a.addChildElement(new ExeDecisionToken().init());
    StatementContainerToken.access$1(this.a);
    this.a.update();
  }

  public String c()
  {
    return "&setDecision";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.H
 * JD-Core Version:    0.6.0
 */