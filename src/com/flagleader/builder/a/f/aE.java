package com.flagleader.builder.a.f;

import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.ILangToken;
import com.flagleader.repository.rom.ConstantEnum;
import com.flagleader.repository.tree.DecisionRule;
import java.util.List;
import org.agilemore.agilegrid.a.d;
import org.agilemore.agilegrid.e;

class aE extends d
{
  aE(aC paramaC, e parame, int paramInt, List paramList, ILangToken paramILangToken)
  {
    super(parame, paramInt);
  }

  protected void a()
  {
    if ((this.o != null) && (O() >= 0))
    {
      ((IConditionToken)this.p).setValue((ConstantEnum)this.o.get(O()));
      af.a(aC.a(this.a)).setModified(true);
    }
    super.a();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.aE
 * JD-Core Version:    0.6.0
 */