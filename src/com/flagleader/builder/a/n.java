package com.flagleader.builder.a;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

class n extends MouseAdapter
{
  n(b paramb)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    try
    {
      b.a(this.a, paramMouseEvent);
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      this.a.a.g();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.n
 * JD-Core Version:    0.6.0
 */