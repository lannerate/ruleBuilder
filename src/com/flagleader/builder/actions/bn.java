package com.flagleader.builder.actions;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

class bn extends MouseAdapter
{
  bn(bm parambm, String paramString)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (this.b.equals("ProjectWindowTitle"))
    {
      if (bm.a(this.a))
      {
        this.a.a();
        bm.a(this.a, !bm.a(this.a));
      }
      else
      {
        this.a.d(false);
      }
    }
    else if (this.b.equals("MessageWidowTitle"))
    {
      if (bm.b(this.a))
      {
        this.a.a();
        bm.b(this.a, !bm.b(this.a));
      }
      else
      {
        this.a.c(false);
      }
    }
    else if (this.b.equals("EditWindowTitle"))
    {
      if (bm.c(this.a))
      {
        this.a.a();
        bm.c(this.a, !bm.c(this.a));
      }
      else
      {
        this.a.a(false);
      }
    }
    else if (this.b.equals("PropWindowTitle"))
      if (bm.d(this.a))
      {
        this.a.a();
        bm.d(this.a, !bm.d(this.a));
      }
      else
      {
        this.a.b(false);
      }
    this.a.a();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.bn
 * JD-Core Version:    0.6.0
 */