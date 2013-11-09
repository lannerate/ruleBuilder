package com.flagleader.repository.rlm.action;

import com.flagleader.repository.c.a;

class E extends a
{
  E(StatementContainerToken paramStatementContainerToken)
  {
  }

  public void a()
  {
    StatementContainerToken.access$0(this.a);
    this.a.addChildElement(new JavaStatementToken());
    StatementContainerToken.access$1(this.a);
    this.a.update();
  }

  public String c()
  {
    return "&javaStatement";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.E
 * JD-Core Version:    0.6.0
 */