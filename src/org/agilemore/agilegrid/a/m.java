package org.agilemore.agilegrid.a;

import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

class m extends KeyAdapter
{
  m(l paraml)
  {
  }

  public void keyReleased(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.character == '\033')
      l.a(this.a);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.a.m
 * JD-Core Version:    0.6.0
 */