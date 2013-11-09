package com.flagleader.builder.shell;

import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class ag
  implements TraverseListener
{
  ag(aa paramaa, TableItem paramTableItem, Text paramText, int paramInt)
  {
  }

  public void keyTraversed(TraverseEvent paramTraverseEvent)
  {
    if ((paramTraverseEvent.detail == 16) || (paramTraverseEvent.detail == 4))
      aa.a(this.a, this.b, this.c, this.d);
    if (paramTraverseEvent.detail == 2)
      aa.g(this.a);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.ag
 * JD-Core Version:    0.6.0
 */