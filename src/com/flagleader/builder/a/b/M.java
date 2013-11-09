package com.flagleader.builder.a.b;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TreeItem;

class M
  implements Listener
{
  M(K paramK)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    TreeItem localTreeItem = K.a(this.a).i();
    if ((localTreeItem != null) && (!localTreeItem.isDisposed()))
      I.a(K.a(this.a), localTreeItem);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.M
 * JD-Core Version:    0.6.0
 */