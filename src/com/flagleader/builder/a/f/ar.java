package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.b.e;
import com.flagleader.builder.b.p;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.tree.DecisionRule;
import com.flagleader.repository.tree.l;
import java.util.List;
import org.agilemore.agilegrid.G;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class ar
  implements Listener
{
  ar(ah paramah, G paramG)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    Object localObject1;
    if (this.b.c == 1)
    {
      if (this.b.d >= af.a(ah.a(this.a)).getConditionNum())
      {
        localObject1 = new p(af.b(ah.a(this.a)).getShell(), af.b(ah.a(this.a)), af.a(ah.a(this.a)).getFirstConditions());
        if (((p)localObject1).open() == 0)
          ah.a(this.a).update();
      }
    }
    else
    {
      localObject1 = (l)ah.a(this.a).e().get(this.b.c - 2);
      Object localObject2;
      if (this.b.d == 0)
      {
        localObject2 = new p(af.b(ah.a(this.a)).getShell(), af.b(ah.a(this.a)), af.a(ah.a(this.a)).getSecondConditions());
        if (((p)localObject2).open() == 0)
          ah.a(this.a).update();
      }
      else
      {
        localObject2 = new e(af.b(ah.a(this.a)).getShell(), af.b(ah.a(this.a)), af.a(ah.a(this.a)).getRelateCondition((IConditionToken)((l)localObject1).a().get(this.b.d - 1), this.b.d));
        if (((e)localObject2).open() == 0)
          ah.a(this.a).update();
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.ar
 * JD-Core Version:    0.6.0
 */