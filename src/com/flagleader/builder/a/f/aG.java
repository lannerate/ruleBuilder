package com.flagleader.builder.a.f;

import com.flagleader.repository.rom.ConstantEnum;
import com.flagleader.repository.tree.DecisionRule;
import com.flagleader.repository.tree.DecisionValue;
import java.util.List;
import org.agilemore.agilegrid.a.d;
import org.agilemore.agilegrid.e;

class aG extends d
{
  aG(aC paramaC, e parame, int paramInt, List paramList, DecisionValue paramDecisionValue)
  {
    super(parame, paramInt);
  }

  protected void a()
  {
    if ((this.o != null) && (O() >= 0))
    {
      this.p.setValue((ConstantEnum)this.o.get(O()));
      af.a(aC.a(this.a)).setModified(true);
    }
    super.a();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.aG
 * JD-Core Version:    0.6.0
 */