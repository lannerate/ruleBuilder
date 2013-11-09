package org.agilemore.agilegrid.samples;

import org.agilemore.agilegrid.J;
import org.agilemore.agilegrid.ac;
import org.agilemore.agilegrid.ag;
import org.agilemore.agilegrid.e;
import org.eclipse.swt.widgets.MessageBox;

class y extends ac
{
  y(SamplesGUI paramSamplesGUI)
  {
  }

  public void b(ag paramag)
  {
    J localJ = paramag.b;
    if ((paramag.a) && (!localJ.y()))
    {
      MessageBox localMessageBox = new MessageBox(SamplesGUI.b(this.a).getShell(), 1);
      localMessageBox.setMessage(localJ.j());
      localMessageBox.open();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.samples.y
 * JD-Core Version:    0.6.0
 */