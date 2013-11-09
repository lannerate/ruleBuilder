package com.flagleader.repository.rlm.condition;

import com.flagleader.repository.IElement;
import com.flagleader.repository.c.g;
import com.flagleader.repository.rom.IBusinessObject;

class d extends g
{
  public d(ConditionToken paramConditionToken)
  {
  }

  public void a(IElement paramIElement)
  {
    if ((paramIElement == null) || (!(paramIElement instanceof IBusinessObject)))
      return;
    if (this.a.isForceOperationType())
      return;
    this.a.b(paramIElement);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.condition.d
 * JD-Core Version:    0.6.0
 */