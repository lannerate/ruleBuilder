package com.flagleader.builder.actions;

import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeItem;

class aP
  implements TraverseListener
{
  aP(aO paramaO, TreeItem paramTreeItem)
  {
  }

  public void keyTraversed(TraverseEvent paramTraverseEvent)
  {
    if ((aO.b(this.a) == null) && (aO.b(this.a).isDisposed()))
      return;
    if ((paramTraverseEvent.detail == 16) || (paramTraverseEvent.detail == 4))
    {
      String str = aO.b(this.a).getText();
      aO.a(this.a, str, this.b);
      aO.b(this.a).dispose();
      aO.a(this.a, null);
    }
    if (paramTraverseEvent.detail == 2)
    {
      aO.b(this.a).dispose();
      aO.a(this.a, null);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.aP
 * JD-Core Version:    0.6.0
 */