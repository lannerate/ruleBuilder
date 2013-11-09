package com.flagleader.repository.rlm;

import com.flagleader.repository.IElement;
import com.flagleader.repository.c.a;

public class b extends a
{
  private IElement b;

  public void a()
  {
    this.a.h();
    this.a.setMemberElement(this.b);
    this.a.g();
    this.a.update();
  }

  public b(AbstractElementToken paramAbstractElementToken, IElement paramIElement)
  {
    this.b = paramIElement;
  }

  public String d()
  {
    if (this.b != null)
      return this.b.getDisplayName();
    return super.d();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.b
 * JD-Core Version:    0.6.0
 */