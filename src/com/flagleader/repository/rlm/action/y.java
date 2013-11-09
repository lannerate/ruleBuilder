package com.flagleader.repository.rlm.action;

import com.flagleader.repository.c.a;

class y extends a
{
  y(StatementContainerToken paramStatementContainerToken)
  {
  }

  public void a()
  {
    StatementContainerToken.access$0(this.a);
    this.a.addChildElement(new ExcuteRuleToken().init());
    StatementContainerToken.access$1(this.a);
    this.a.update();
  }

  public String c()
  {
    return "&setRun";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.y
 * JD-Core Version:    0.6.0
 */