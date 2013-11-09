package com.flagleader.builder.widget;

import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;

class m
  implements TraverseListener
{
  m(i parami)
  {
  }

  public void keyTraversed(TraverseEvent paramTraverseEvent)
  {
    if ((paramTraverseEvent.detail == 16) || (paramTraverseEvent.detail == 4))
      i.g(this.a);
    if (paramTraverseEvent.detail == 2)
      i.g(this.a);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.m
 * JD-Core Version:    0.6.0
 */