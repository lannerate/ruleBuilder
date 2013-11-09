package org.agilemore.agilegrid.samples;

import org.agilemore.agilegrid.G;
import org.agilemore.agilegrid.ah;
import org.agilemore.agilegrid.at;
import org.eclipse.jface.action.StatusLineManager;

class w
  implements at
{
  w(SamplesGUI paramSamplesGUI)
  {
  }

  public void a(ah paramah)
  {
    StatusLineManager localStatusLineManager = SamplesGUI.a(this.a);
    G localG = paramah.a();
    localStatusLineManager.setMessage("Cell [" + localG.c + ", " + localG.d + "] is focused.");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.samples.w
 * JD-Core Version:    0.6.0
 */