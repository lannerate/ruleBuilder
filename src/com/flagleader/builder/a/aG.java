package com.flagleader.builder.a;

import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;

class aG
  implements TraverseListener
{
  aG(ax paramax, CCombo paramCCombo, int paramInt)
  {
  }

  public void keyTraversed(TraverseEvent paramTraverseEvent)
  {
    if ((paramTraverseEvent.detail == 4) || (paramTraverseEvent.detail == 16))
      this.a.a(this.b.getText(), this.c);
    if (paramTraverseEvent.detail == 2)
      this.a.s();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.aG
 * JD-Core Version:    0.6.0
 */