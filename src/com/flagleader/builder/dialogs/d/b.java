package com.flagleader.builder.dialogs.d;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

class b extends KeyAdapter
{
  b(a parama)
  {
  }

  public void keyPressed(KeyEvent paramKeyEvent)
  {
    if (((paramKeyEvent.keyCode == 67) || (paramKeyEvent.keyCode == 99)) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0))
    {
      if (this.a.g())
        this.a.k();
      paramKeyEvent.doit = false;
    }
    if (((paramKeyEvent.keyCode == 86) || (paramKeyEvent.keyCode == 118)) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0))
    {
      if (this.a.j())
        this.a.n();
      paramKeyEvent.doit = false;
    }
    if (((paramKeyEvent.keyCode == 88) || (paramKeyEvent.keyCode == 120)) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0))
    {
      if (this.a.h())
        this.a.l();
      paramKeyEvent.doit = false;
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.d.b
 * JD-Core Version:    0.6.0
 */