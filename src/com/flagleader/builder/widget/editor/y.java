package com.flagleader.builder.widget.editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

class y extends KeyAdapter
{
  y(s params, StyledText paramStyledText)
  {
  }

  public void keyPressed(KeyEvent paramKeyEvent)
  {
    if (((paramKeyEvent.keyCode == 65) || (paramKeyEvent.keyCode == 97)) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0))
    {
      this.b.selectAll();
      paramKeyEvent.doit = false;
    }
    else if (((paramKeyEvent.keyCode == 70) || (paramKeyEvent.keyCode == 102)) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0))
    {
      this.a.A();
      paramKeyEvent.doit = false;
    }
    else if (((paramKeyEvent.keyCode == 82) || (paramKeyEvent.keyCode == 114)) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0))
    {
      this.a.z();
      paramKeyEvent.doit = false;
    }
    else if ((paramKeyEvent.keyCode == 16777227) || ((paramKeyEvent.keyCode == 16777228) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0)))
    {
      this.a.C();
      paramKeyEvent.doit = false;
    }
    else if (paramKeyEvent.keyCode == 16777228)
    {
      this.a.B();
      paramKeyEvent.doit = false;
    }
    else if (((paramKeyEvent.keyCode == 90) || (paramKeyEvent.keyCode == 122)) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0))
    {
      this.a.c();
      paramKeyEvent.doit = false;
    }
    else if (((paramKeyEvent.keyCode == 89) || (paramKeyEvent.keyCode == 121)) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0))
    {
      this.a.e();
      paramKeyEvent.doit = false;
    }
    else if (((paramKeyEvent.keyCode == 84) || (paramKeyEvent.keyCode == 116)) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0))
    {
      this.a.G();
      paramKeyEvent.doit = false;
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.y
 * JD-Core Version:    0.6.0
 */