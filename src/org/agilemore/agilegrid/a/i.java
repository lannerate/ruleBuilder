package org.agilemore.agilegrid.a;

import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

class i extends KeyAdapter
{
  i(g paramg)
  {
  }

  public void keyReleased(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.character == '\033')
      g.d(this.a);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.a.i
 * JD-Core Version:    0.6.0
 */