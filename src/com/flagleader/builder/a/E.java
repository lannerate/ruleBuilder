package com.flagleader.builder.a;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

class E
  implements MouseMoveListener
{
  E(b paramb)
  {
  }

  public void mouseMove(MouseEvent paramMouseEvent)
  {
    if ((paramMouseEvent.stateMask & 0x80000) != 0)
    {
      Control[] arrayOfControl = b.a(this.a).getChildren();
      for (int i = 0; i < arrayOfControl.length; i++)
      {
        if ((!arrayOfControl[i].getBounds().contains(paramMouseEvent.x, paramMouseEvent.y)) || (!(arrayOfControl[i] instanceof Composite)) || (arrayOfControl[i].getData() == null))
          continue;
        b.b(this.a, (Composite)arrayOfControl[i]);
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.E
 * JD-Core Version:    0.6.0
 */