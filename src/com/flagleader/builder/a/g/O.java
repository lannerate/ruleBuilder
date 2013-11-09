package com.flagleader.builder.a.g;

import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.Text;

class O
  implements TraverseListener
{
  O(M paramM, Text paramText)
  {
  }

  public void keyTraversed(TraverseEvent paramTraverseEvent)
  {
    if ((paramTraverseEvent.detail == 16) || (paramTraverseEvent.detail == 4))
      this.b.dispose();
    if (paramTraverseEvent.detail == 2)
      this.b.dispose();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.O
 * JD-Core Version:    0.6.0
 */