package org.agilemore.agilegrid.a;

import java.text.MessageFormat;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;

class j extends SelectionAdapter
{
  j(g paramg)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    g.a(this.a).removeFocusListener(g.e(this.a));
    Object localObject = this.a.a(g.f(this.a));
    g.a(this.a).addFocusListener(g.e(this.a));
    if (localObject != null)
    {
      boolean bool = g.a(this.a, localObject);
      if (bool)
      {
        g.g(this.a);
        this.a.a(localObject);
      }
      else
      {
        g.a(this.a, MessageFormat.format(this.a.j(), new Object[] { localObject.toString() }));
      }
      g.h(this.a);
    }
    else
    {
      g.d(this.a);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.a.j
 * JD-Core Version:    0.6.0
 */