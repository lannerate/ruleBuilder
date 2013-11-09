package com.flagleader.builder.a.d;

import com.flagleader.builder.a.c.e;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.TableItem;

class l
  implements TraverseListener
{
  l(a parama, e parame, TableItem paramTableItem)
  {
  }

  public void keyTraversed(TraverseEvent paramTraverseEvent)
  {
    if ((paramTraverseEvent.detail == 4) || (paramTraverseEvent.detail == 16))
      if (a.e(this.a).getSelectionIndex() >= 0)
      {
        if (this.b.a(a.e(this.a).getText()))
          this.a.c(this.c);
        this.a.o();
      }
      else
      {
        this.a.o();
      }
    if (paramTraverseEvent.detail == 2)
      this.a.o();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.l
 * JD-Core Version:    0.6.0
 */