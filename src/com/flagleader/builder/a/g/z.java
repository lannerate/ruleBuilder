package com.flagleader.builder.a.g;

import com.flagleader.repository.tree.TestCase;
import com.flagleader.repository.tree.TestCaseLib;
import java.util.ArrayList;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class z
  implements Listener
{
  z(y paramy, TestCase paramTestCase)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    r.b(y.a(this.a)).getTestInfos().remove(this.b);
    r.b(y.a(this.a)).refreshInit();
    r.b(y.a(this.a)).setModified(true);
    y.a(this.a).update();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.z
 * JD-Core Version:    0.6.0
 */