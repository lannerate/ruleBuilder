package org.agilemore.agilegrid.samples;

import org.agilemore.agilegrid.G;
import org.agilemore.agilegrid.e;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class g extends SelectionAdapter
{
  g(a parama)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    i locali = (i)this.a.m();
    if (locali == null)
      locali = new i();
    locali.a(new j("Enter Name", "...", false));
    a.a(this.a).b(new G(a.a(this.a), locali.a() - 1, 0));
    a.a(this.a).a(true);
    a.a(this.a).redraw();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.samples.g
 * JD-Core Version:    0.6.0
 */