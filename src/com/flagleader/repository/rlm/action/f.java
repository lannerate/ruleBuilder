package com.flagleader.repository.rlm.action;

import com.flagleader.repository.IElement;
import com.flagleader.repository.rom.IBusinessObject;

class f extends com.flagleader.repository.c.g
{
  public f(AssignToken paramAssignToken)
  {
  }

  public void a(IElement paramIElement)
  {
    if ((paramIElement == null) || (!(paramIElement instanceof IBusinessObject)))
      return;
    com.flagleader.repository.lang.g localg = ((IBusinessObject)paramIElement).getJavaType();
    AssignToken.access$0(this.a);
    this.a.changeFieldType(localg);
    AssignToken.access$1(this.a);
    this.a.update();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.f
 * JD-Core Version:    0.6.0
 */