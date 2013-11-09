package com.flagleader.repository.rlm.action;

import com.flagleader.repository.IElement;
import com.flagleader.repository.c.a;

class u extends a
{
  u(StatementContainerToken paramStatementContainerToken)
  {
  }

  public void a()
  {
    if (this.a.getParent() != null)
    {
      int i = this.a.getParent().getElementPos(this.a);
      StatementContainerToken.access$0(this.a);
      this.a.getParent().addChildElement(new StatementContainerToken(), i);
      StatementContainerToken.access$1(this.a);
      if ((this.a.getParent() instanceof MultiActionToken))
        ((MultiActionToken)this.a.getParent()).update();
      else
        this.a.update();
    }
  }

  public String c()
  {
    return "&insertAction";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.u
 * JD-Core Version:    0.6.0
 */