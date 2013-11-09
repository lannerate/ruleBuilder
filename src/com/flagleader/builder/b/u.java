package com.flagleader.builder.b;

import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

class u extends KeyAdapter
{
  u(r paramr)
  {
  }

  public void keyReleased(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.character == '\033')
      this.a.c();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.b.u
 * JD-Core Version:    0.6.0
 */