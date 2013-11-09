package com.flagleader.builder.widget.a;

import com.flagleader.util.StringUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Point;

class ai extends KeyAdapter
{
  ai(af paramaf)
  {
  }

  public void keyPressed(KeyEvent paramKeyEvent)
  {
    if (((paramKeyEvent.keyCode == 65) || (paramKeyEvent.keyCode == 97)) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0))
    {
      this.a.e.selectAll();
      paramKeyEvent.doit = false;
    }
    if (((paramKeyEvent.keyCode == 70) || (paramKeyEvent.keyCode == 102)) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0))
    {
      this.a.A();
      paramKeyEvent.doit = false;
    }
    if (paramKeyEvent.keyCode == 16777228)
    {
      this.a.B();
      paramKeyEvent.doit = false;
    }
    if ((paramKeyEvent.keyCode == 16777228) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0))
    {
      this.a.l();
      paramKeyEvent.doit = false;
    }
    if (((paramKeyEvent.keyCode == 90) || (paramKeyEvent.keyCode == 122)) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0))
    {
      this.a.c();
      paramKeyEvent.doit = false;
    }
    if (((paramKeyEvent.keyCode == 89) || (paramKeyEvent.keyCode == 121)) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0))
    {
      this.a.e();
      paramKeyEvent.doit = false;
    }
    if (((paramKeyEvent.keyCode == 84) || (paramKeyEvent.keyCode == 116)) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0))
    {
      this.a.k();
      paramKeyEvent.doit = false;
    }
    if (((paramKeyEvent.keyCode == 66) || (paramKeyEvent.keyCode == 98)) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0) && (this.a.e.getSelectionText() != null) && (this.a.e.getSelectionText().length() > 0))
    {
      String str = this.a.e.getSelectionText();
      if (str.indexOf(StringUtil.newline) > 0)
        str = StringUtil.replace(StringUtil.newline + "\t", StringUtil.newline, str);
      else if (str.indexOf("\n") > 0)
        str = StringUtil.replace("\n\t", "\n", str);
      if (str.startsWith("\t"))
        str = str.substring(1);
      int i = this.a.e.getSelectionRange().x;
      this.a.e.replaceTextRange(i, this.a.e.getSelectionCount(), str);
      paramKeyEvent.doit = false;
      this.a.e.setSelectionRange(i, str.length());
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.a.ai
 * JD-Core Version:    0.6.0
 */