package com.flagleader.builder.a.g;

import com.flagleader.repository.tree.CheckRuleInfo;
import com.flagleader.repository.tree.IRuleSet;
import com.flagleader.repository.tree.TestCase;
import java.util.ArrayList;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class i
  implements Listener
{
  i(h paramh, TestCase paramTestCase)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    a.b(h.a(this.a)).getTestInfos().remove(this.b);
    a.b(h.a(this.a)).refreshInit();
    a.f(h.a(this.a)).setModified(true);
    h.a(this.a).update();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.i
 * JD-Core Version:    0.6.0
 */