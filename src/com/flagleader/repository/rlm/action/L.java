package com.flagleader.repository.rlm.action;

import com.flagleader.repository.c.a;

class L extends a
{
  L(StatementContainerToken paramStatementContainerToken)
  {
  }

  public void a()
  {
    StatementContainerToken.access$0(this.a);
    this.a.addChildElement(new FunctionDBToken());
    StatementContainerToken.access$1(this.a);
    this.a.update();
  }

  public String c()
  {
    return "&setDB";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.L
 * JD-Core Version:    0.6.0
 */