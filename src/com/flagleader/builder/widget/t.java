package com.flagleader.builder.widget;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

class t extends KeyAdapter
{
  t(s params)
  {
  }

  public void keyPressed(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.keyCode == 16777228)
    {
      this.a.b();
      paramKeyEvent.doit = false;
    }
    else if (((paramKeyEvent.keyCode == 70) || (paramKeyEvent.keyCode == 102)) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0))
    {
      this.a.a();
      paramKeyEvent.doit = false;
    }
    else if (paramKeyEvent.keyCode == 16777227)
    {
      this.a.c();
      paramKeyEvent.doit = false;
    }
    else if (((paramKeyEvent.keyCode == 76) || (paramKeyEvent.keyCode == 108)) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0))
    {
      this.a.d();
      paramKeyEvent.doit = false;
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.t
 * JD-Core Version:    0.6.0
 */