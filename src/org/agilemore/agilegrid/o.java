package org.agilemore.agilegrid;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.ScrollBar;

class o extends SelectionAdapter
{
  o(e parame, ScrollBar paramScrollBar)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    int i = this.a.e;
    this.a.e = this.b.getSelection();
    int j = e.a(this.a).a();
    if (this.a.e + e.i(this.a) - 1 >= j)
      this.a.e = (j - e.j(this.a));
    if (i != this.a.e)
      this.a.redraw();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.o
 * JD-Core Version:    0.6.0
 */