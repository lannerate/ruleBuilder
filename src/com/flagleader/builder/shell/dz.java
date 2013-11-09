package com.flagleader.builder.shell;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

class dz extends SelectionAdapter
{
  dz(ds paramds, int paramInt)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (ds.d(this.a)[(this.b - 2)] == null)
    {
      ds.a(this.a, new HashMap());
      ds.d(this.a)[(this.b - 2)] = ds.e(this.a);
      for (int i = 0; i < ds.c(this.a).getItemCount(); i++)
        ds.a(this.a, ds.c(this.a).getItems()[i], this.b);
    }
    else
    {
      ds.a(this.a, ds.d(this.a)[(this.b - 2)]);
    }
    Iterator localIterator = ds.e(this.a).keySet().iterator();
    while (localIterator.hasNext())
    {
      TreeItem localTreeItem = (TreeItem)localIterator.next();
      localTreeItem.setExpanded(true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.dz
 * JD-Core Version:    0.6.0
 */