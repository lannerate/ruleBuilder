package com.flagleader.repository.rlm.action;

import com.flagleader.repository.c.a;

class O extends a
{
  O(StatementContainerToken paramStatementContainerToken)
  {
  }

  public void a()
  {
    StatementContainerToken.access$0(this.a);
    this.a.addChildElement(new FunctionSoapToken());
    StatementContainerToken.access$1(this.a);
    this.a.update();
  }

  public String c()
  {
    return "&setSoap";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.O
 * JD-Core Version:    0.6.0
 */