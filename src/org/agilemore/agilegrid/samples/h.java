package org.agilemore.agilegrid.samples;

import org.agilemore.agilegrid.G;
import org.agilemore.agilegrid.e;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class h extends SelectionAdapter
{
  h(a parama)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    i locali = (i)this.a.m();
    if ((locali == null) || (locali.a() <= 0))
      return;
    G localG = a.a(this.a).A();
    if ((localG == null) || (localG == G.b))
      return;
    locali.b(locali.a(localG.c));
    if (localG.c >= locali.a())
      localG.c = (locali.a() - 1);
    if (localG.c < 0)
      localG = G.b;
    a.a(this.a).b(localG);
    a.a(this.a).a(true);
    a.a(this.a).redraw();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.samples.h
 * JD-Core Version:    0.6.0
 */