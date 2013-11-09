package com.flagleader.builder.a.d;

import com.flagleader.builder.a.c.e;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.TreeItem;

class z
  implements TraverseListener
{
  z(o paramo, e parame, TreeItem paramTreeItem)
  {
  }

  public void keyTraversed(TraverseEvent paramTraverseEvent)
  {
    if ((paramTraverseEvent.detail == 4) || (paramTraverseEvent.detail == 16))
    {
      if (this.b.a(o.e(this.a).getText()))
        this.a.c(this.c);
      this.a.o();
    }
    if (paramTraverseEvent.detail == 2)
      this.a.o();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.z
 * JD-Core Version:    0.6.0
 */