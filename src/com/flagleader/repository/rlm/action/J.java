package com.flagleader.repository.rlm.action;

import com.flagleader.repository.c.a;

class J extends a
{
  J(StatementContainerToken paramStatementContainerToken)
  {
  }

  public void a()
  {
    StatementContainerToken.access$0(this.a);
    this.a.addChildElement(new TableFunctionToken());
    StatementContainerToken.access$1(this.a);
    this.a.update();
  }

  public String c()
  {
    return "&setTable";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.J
 * JD-Core Version:    0.6.0
 */