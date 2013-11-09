package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.b.e;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.tree.DecisionRule;
import com.flagleader.repository.tree.l;
import java.util.List;
import org.agilemore.agilegrid.G;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class as
  implements Listener
{
  as(ah paramah, G paramG)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    l locall = (l)ah.a(this.a).e().get(this.b.c - 2);
    e locale = new e(af.b(ah.a(this.a)).getShell(), af.b(ah.a(this.a)), af.a(ah.a(this.a)).getRelateCondition((IConditionToken)locall.a().get(this.b.d), this.b.d + 1));
    if (locale.open() == 0)
    {
      if (af.a(ah.a(this.a)).getConditionNum() <= this.b.d + 1)
      {
        af.a(ah.a(this.a)).setConditionNum(af.a(ah.a(this.a)).getConditionNum() + 1);
        af.a(ah.a(this.a)).setModified(true);
      }
      ah.a(this.a).update();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.as
 * JD-Core Version:    0.6.0
 */