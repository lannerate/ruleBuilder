package com.flagleader.builder.a.g;

import com.flagleader.repository.tree.TestCase;
import com.flagleader.repository.tree.TestCaseLib;
import java.util.ArrayList;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class J
  implements Listener
{
  J(I paramI, TestCase paramTestCase)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    B.b(I.a(this.a)).getTestInfos().remove(this.b);
    B.b(I.a(this.a)).refreshInit();
    B.b(I.a(this.a)).setModified(true);
    I.a(this.a).update();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.J
 * JD-Core Version:    0.6.0
 */