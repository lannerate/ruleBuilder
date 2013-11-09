package com.flagleader.builder.a.d;

import com.flagleader.builder.a.c.f;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeItem;

class x
  implements TraverseListener
{
  x(o paramo, f paramf, TreeItem paramTreeItem)
  {
  }

  public void keyTraversed(TraverseEvent paramTraverseEvent)
  {
    if ((paramTraverseEvent.detail == 16) || (paramTraverseEvent.detail == 4))
    {
      if (this.b.a(o.d(this.a).getText()))
        this.a.c(this.c);
      this.a.o();
    }
    if (paramTraverseEvent.detail == 2)
      this.a.o();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.x
 * JD-Core Version:    0.6.0
 */