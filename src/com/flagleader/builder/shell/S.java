package com.flagleader.builder.shell;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

class S extends KeyAdapter
{
  S(M paramM)
  {
  }

  public void keyPressed(KeyEvent paramKeyEvent)
  {
    if (((paramKeyEvent.keyCode == 67) || (paramKeyEvent.keyCode == 99)) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0))
    {
      if (this.a.b())
        this.a.f();
      paramKeyEvent.doit = false;
    }
    if (((paramKeyEvent.keyCode == 86) || (paramKeyEvent.keyCode == 118)) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0))
    {
      if (this.a.e())
        this.a.i();
      paramKeyEvent.doit = false;
    }
    if (((paramKeyEvent.keyCode == 88) || (paramKeyEvent.keyCode == 120)) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0))
    {
      if (this.a.c())
        this.a.g();
      paramKeyEvent.doit = false;
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.S
 * JD-Core Version:    0.6.0
 */