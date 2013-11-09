package com.flagleader.repository.rlm.action;

import com.flagleader.repository.c.a;

class z extends a
{
  z(StatementContainerToken paramStatementContainerToken)
  {
  }

  public void a()
  {
    StatementContainerToken.access$0(this.a);
    this.a.addChildElement(new ExeRuleToken().init());
    StatementContainerToken.access$1(this.a);
    this.a.update();
  }

  public String c()
  {
    return "&setExe";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.z
 * JD-Core Version:    0.6.0
 */