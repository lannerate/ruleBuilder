package com.flagleader.builder.a.g;

import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.Text;

class S
  implements TraverseListener
{
  S(Q paramQ, Text paramText, int paramInt)
  {
  }

  public void keyTraversed(TraverseEvent paramTraverseEvent)
  {
    if ((paramTraverseEvent.detail == 16) || (paramTraverseEvent.detail == 4))
    {
      String str = this.b.getText();
      Q.a(this.a, str, this.c, Q.a(this.a));
      this.b.dispose();
    }
    if (paramTraverseEvent.detail == 2)
      this.b.dispose();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.S
 * JD-Core Version:    0.6.0
 */