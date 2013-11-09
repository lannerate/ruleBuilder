package com.flagleader.builder.c;

import com.flagleader.manager.c.c.e;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.TableItem;

class r
  implements TraverseListener
{
  r(k paramk, TableItem paramTableItem, CCombo paramCCombo, int paramInt, e parame)
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
 * Qualified Name:     com.flagleader.builder.c.r
 * JD-Core Version:    0.6.0
 */