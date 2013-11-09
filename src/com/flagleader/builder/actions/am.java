package com.flagleader.builder.actions;

import org.eclipse.swt.widgets.Display;

class am
  implements Runnable
{
  am(al paramal)
  {
  }

  public void run()
  {
    if (!al.a(this.a))
    {
      al.a(this.a, true);
      this.a.b();
    }
    Display.getCurrent().timerExec(800, this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.am
 * JD-Core Version:    0.6.0
 */