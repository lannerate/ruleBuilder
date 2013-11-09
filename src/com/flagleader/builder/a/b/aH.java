package com.flagleader.builder.a.b;

import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.Text;

class aH
  implements TraverseListener
{
  aH(aF paramaF, Text paramText, int paramInt)
  {
  }

  public void keyTraversed(TraverseEvent paramTraverseEvent)
  {
    if ((paramTraverseEvent.detail == 16) || (paramTraverseEvent.detail == 4))
    {
      String str = this.b.getText();
      aF.a(this.a, str, this.c, aF.a(this.a));
      this.b.dispose();
    }
    if (paramTraverseEvent.detail == 2)
      this.b.dispose();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.aH
 * JD-Core Version:    0.6.0
 */