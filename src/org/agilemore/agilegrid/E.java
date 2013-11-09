package org.agilemore.agilegrid;

import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;

class E
  implements TraverseListener
{
  E(A paramA)
  {
  }

  public void keyTraversed(TraverseEvent paramTraverseEvent)
  {
    if ((A.a(this.a) & 0x1) != 1)
      this.a.a(A.b(this.a), paramTraverseEvent);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.E
 * JD-Core Version:    0.6.0
 */