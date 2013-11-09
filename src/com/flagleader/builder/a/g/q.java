package com.flagleader.builder.a.g;

import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.Text;

class q
  implements TraverseListener
{
  q(o paramo, Text paramText, int paramInt)
  {
  }

  public void keyTraversed(TraverseEvent paramTraverseEvent)
  {
    if ((paramTraverseEvent.detail == 16) || (paramTraverseEvent.detail == 4))
    {
      String str = this.b.getText();
      o.a(this.a, str, this.c, o.a(this.a));
      this.b.dispose();
    }
    if (paramTraverseEvent.detail == 2)
      this.b.dispose();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.q
 * JD-Core Version:    0.6.0
 */