package com.flagleader.builder.c;

import com.flagleader.manager.c.c.g;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.TableItem;

class s
  implements TraverseListener
{
  s(k paramk, TableItem paramTableItem, CCombo paramCCombo, int paramInt, g paramg)
  {
  }

  public void keyTraversed(TraverseEvent paramTraverseEvent)
  {
    if ((paramTraverseEvent.detail == 16) || (paramTraverseEvent.detail == 4))
      k.a(this.a, this.b, this.c, this.d, this.e);
    if (paramTraverseEvent.detail == 2)
      k.a(this.a, this.c);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.c.s
 * JD-Core Version:    0.6.0
 */