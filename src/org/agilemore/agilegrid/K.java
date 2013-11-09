package org.agilemore.agilegrid;

import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

class K extends KeyAdapter
{
  K(J paramJ)
  {
  }

  public void keyPressed(KeyEvent paramKeyEvent)
  {
    try
    {
      this.a.a(paramKeyEvent);
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.K
 * JD-Core Version:    0.6.0
 */