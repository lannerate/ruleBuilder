package com.flagleader.builder.actions;

import org.eclipse.swt.widgets.Display;

class an
  implements Runnable
{
  an(al paramal)
  {
  }

  public void run()
  {
    if (!al.a(this.a))
    {
      al.a(this.a, true);
      this.a.b();
    }
    Display.getCurrent().timerExec(500, this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.an
 * JD-Core Version:    0.6.0
 */