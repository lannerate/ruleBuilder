package com.flagleader.builder.widget;

import org.eclipse.swt.widgets.Display;

class I
  implements Runnable
{
  I(E paramE)
  {
  }

  public void run()
  {
    E.c(this.a);
    Display.getCurrent().timerExec(1000, this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.I
 * JD-Core Version:    0.6.0
 */