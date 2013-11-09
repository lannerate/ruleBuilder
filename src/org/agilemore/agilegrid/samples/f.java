package org.agilemore.agilegrid.samples;

import org.agilemore.agilegrid.G;
import org.agilemore.agilegrid.ad;
import org.agilemore.agilegrid.ae;
import org.agilemore.agilegrid.e;
import org.eclipse.swt.events.MouseEvent;

class f extends ae
{
  f(a parama, e parame)
  {
    super(parame);
  }

  protected boolean a(ad paramad)
  {
    G localG = (G)paramad.getSource();
    if ((localG.d == 0) && (paramad.h == 2) && (((MouseEvent)paramad.f).button == 1))
      return true;
    return super.a(paramad);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.samples.f
 * JD-Core Version:    0.6.0
 */