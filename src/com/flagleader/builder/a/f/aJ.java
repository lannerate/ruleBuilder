package com.flagleader.builder.a.f;

import com.flagleader.builder.widget.h;
import com.flagleader.repository.tree.DecisionRule;
import org.agilemore.agilegrid.b.g;
import org.agilemore.agilegrid.e;

class aJ extends g
{
  aJ(aI paramaI, e parame)
  {
    super(parame);
  }

  protected void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 1) || (paramInt2 < af.a(aI.a(this.a)).getConditionNum()))
      this.O = h.a;
    else
      this.O = h.g;
    super.a(paramInt1, paramInt2);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.aJ
 * JD-Core Version:    0.6.0
 */