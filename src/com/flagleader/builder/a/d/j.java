package com.flagleader.builder.a.d;

import com.flagleader.builder.a.c.f;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class j
  implements TraverseListener
{
  j(a parama, f paramf, TableItem paramTableItem)
  {
  }

  public void keyTraversed(TraverseEvent paramTraverseEvent)
  {
    if ((paramTraverseEvent.detail == 16) || (paramTraverseEvent.detail == 4))
    {
      if (this.b.a(a.d(this.a).getText()))
        this.a.c(this.c);
      this.a.o();
    }
    if (paramTraverseEvent.detail == 2)
      this.a.o();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.j
 * JD-Core Version:    0.6.0
 */