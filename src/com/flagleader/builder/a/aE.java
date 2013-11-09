package com.flagleader.builder.a;

import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.Text;

class aE
  implements TraverseListener
{
  aE(ax paramax, Text paramText, int paramInt)
  {
  }

  public void keyTraversed(TraverseEvent paramTraverseEvent)
  {
    if ((paramTraverseEvent.detail == 16) || (paramTraverseEvent.detail == 4))
      this.a.a(this.b.getText(), this.c);
    if (paramTraverseEvent.detail == 2)
      this.a.s();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.aE
 * JD-Core Version:    0.6.0
 */