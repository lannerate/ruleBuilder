package com.flagleader.builder.a.e;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TreeItem;

class v
  implements Listener
{
  v(s params)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    TreeItem localTreeItem = s.a(this.a).g();
    if ((localTreeItem != null) && (!localTreeItem.isDisposed()))
      q.a(s.a(this.a), localTreeItem);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.e.v
 * JD-Core Version:    0.6.0
 */