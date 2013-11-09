package com.flagleader.repository.rlm.action;

import com.flagleader.repository.c.a;

class D extends a
{
  D(StatementContainerToken paramStatementContainerToken)
  {
  }

  public void a()
  {
    StatementContainerToken.access$0(this.a);
    this.a.addChildElement(new LogRecordToken().init());
    StatementContainerToken.access$1(this.a);
    this.a.update();
  }

  public String c()
  {
    return "&setLog";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.D
 * JD-Core Version:    0.6.0
 */