package com.flagleader.builder.a.d;

import com.flagleader.builder.a.c.d;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.TreeItem;

class r
  implements TraverseListener
{
  r(o paramo, d paramd, TreeItem paramTreeItem)
  {
  }

  public void keyTraversed(TraverseEvent paramTraverseEvent)
  {
    if ((paramTraverseEvent.detail == 4) || (paramTraverseEvent.detail == 16))
      if (o.e(this.a).getSelectionIndex() >= 0)
      {
        if (this.b.a(o.e(this.a).getSelectionIndex()))
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
 * Qualified Name:     com.flagleader.builder.a.d.r
 * JD-Core Version:    0.6.0
 */