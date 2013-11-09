package org.agilemore.agilegrid;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.ScrollBar;

class g extends SelectionAdapter
{
  g(e parame, ScrollBar paramScrollBar)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    int i = this.a.f;
    this.a.f = this.b.getSelection();
    int j = e.a(this.a).b();
    if (this.a.f + e.j(this.a) - 1 >= j)
      this.a.f = (j - e.j(this.a));
    if (i != this.a.f)
      this.a.redraw();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.g
 * JD-Core Version:    0.6.0
 */