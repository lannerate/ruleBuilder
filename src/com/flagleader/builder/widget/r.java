package com.flagleader.builder.widget;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Text;

class r extends KeyAdapter
{
  r(p paramp)
  {
  }

  public void keyPressed(KeyEvent paramKeyEvent)
  {
    if (((paramKeyEvent.keyCode == 65) || (paramKeyEvent.keyCode == 97)) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0))
    {
      p.b(this.a).selectAll();
      paramKeyEvent.doit = false;
    }
    if (((paramKeyEvent.keyCode == 67) || (paramKeyEvent.keyCode == 99)) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0))
    {
      p.b(this.a).copy();
      paramKeyEvent.doit = false;
    }
    if (((paramKeyEvent.keyCode == 86) || (paramKeyEvent.keyCode == 118)) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0))
    {
      p.b(this.a).paste();
      paramKeyEvent.doit = false;
    }
    if (((paramKeyEvent.keyCode == 88) || (paramKeyEvent.keyCode == 120)) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0))
    {
      p.b(this.a).cut();
      paramKeyEvent.doit = false;
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.r
 * JD-Core Version:    0.6.0
 */