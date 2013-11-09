package com.flagleader.repository.rlm.action;

import com.flagleader.repository.c.a;

class v extends a
{
  v(StatementContainerToken paramStatementContainerToken)
  {
  }

  public void a()
  {
    StatementContainerToken.access$0(this.a);
    this.a.addChildElement(new XmlFunctionToken());
    StatementContainerToken.access$1(this.a);
    this.a.update();
  }

  public String c()
  {
    return "&setXml";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.v
 * JD-Core Version:    0.6.0
 */