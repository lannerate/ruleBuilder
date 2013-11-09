package org.agilemore.agilegrid.samples;

import org.agilemore.agilegrid.G;
import org.agilemore.agilegrid.ad;
import org.agilemore.agilegrid.ae;
import org.agilemore.agilegrid.e;
import org.eclipse.swt.events.MouseEvent;

class z extends ae
{
  z(SamplesGUI paramSamplesGUI, e parame)
  {
    super(parame);
  }

  protected boolean a(ad paramad)
  {
    G localG = (G)paramad.getSource();
    if ((localG.c >= 6) && (localG.c <= 23) && ((localG.d == 15) || (localG.d == 17)) && (paramad.h == 2) && (((MouseEvent)paramad.f).button == 1))
      return true;
    return super.a(paramad);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.samples.z
 * JD-Core Version:    0.6.0
 */