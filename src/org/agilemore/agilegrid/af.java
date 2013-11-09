package org.agilemore.agilegrid;

import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;

class af
  implements KeyListener
{
  af(ae paramae)
  {
  }

  public void keyPressed(KeyEvent paramKeyEvent)
  {
    G localG = this.a.a();
    if (localG != null)
      ae.a(this.a).a(new ad(localG, null, paramKeyEvent), null);
  }

  public void keyReleased(KeyEvent paramKeyEvent)
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.af
 * JD-Core Version:    0.6.0
 */