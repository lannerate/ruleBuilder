package org.agilemore.agilegrid.samples;

import org.agilemore.agilegrid.G;
import org.agilemore.agilegrid.e;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.ToolBar;

class t extends SelectionAdapter
{
  t(q paramq, ToolBar paramToolBar)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    q.a(this.a).a.a(q.a(this.a).c, q.a(this.a).d, new Integer(1));
    this.b.setVisible(false);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.samples.t
 * JD-Core Version:    0.6.0
 */