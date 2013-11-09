package com.flagleader.builder.a;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

class D extends MouseAdapter
{
  D(b paramb)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 1)
    {
      Control[] arrayOfControl;
      int i;
      if ((paramMouseEvent.stateMask & SWT.MOD1) != 0)
      {
        arrayOfControl = b.a(this.a).getChildren();
        for (i = 0; i < arrayOfControl.length; i++)
        {
          if ((!arrayOfControl[i].getBounds().contains(paramMouseEvent.x, paramMouseEvent.y)) || (!(arrayOfControl[i] instanceof Composite)))
            continue;
          b.a(this.a, (Composite)arrayOfControl[i]);
        }
      }
      else
      {
        arrayOfControl = b.a(this.a).getChildren();
        for (i = 0; i < arrayOfControl.length; i++)
        {
          if (!(arrayOfControl[i] instanceof Composite))
            continue;
          b.a(this.a, (Composite)arrayOfControl[i]);
        }
      }
    }
    b.a(this.a, paramMouseEvent);
  }

  public void mouseUp(MouseEvent paramMouseEvent)
  {
    this.a.setChanged();
    this.a.notifyObservers();
    super.mouseUp(paramMouseEvent);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.D
 * JD-Core Version:    0.6.0
 */