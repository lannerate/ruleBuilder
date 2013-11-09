package com.flagleader.builder.a.d;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class aJ extends KeyAdapter
{
  aJ(aI paramaI)
  {
  }

  public void keyPressed(KeyEvent paramKeyEvent)
  {
    if (aI.a(this.a).getSelectionCount() == 1)
    {
      TableItem localTableItem = aI.a(this.a).getSelection()[0];
      if ((paramKeyEvent.keyCode == 16777217) && ((paramKeyEvent.stateMask & SWT.MOD3) != 0))
      {
        aI.b(this.a);
        paramKeyEvent.doit = false;
      }
      else if ((paramKeyEvent.keyCode == 16777218) && ((paramKeyEvent.stateMask & SWT.MOD3) != 0))
      {
        aI.c(this.a);
        paramKeyEvent.doit = false;
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.aJ
 * JD-Core Version:    0.6.0
 */