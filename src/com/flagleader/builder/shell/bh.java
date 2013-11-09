package com.flagleader.builder.shell;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;

class bh
  implements MouseMoveListener
{
  bh(aQ paramaQ)
  {
  }

  public void mouseMove(MouseEvent paramMouseEvent)
  {
    try
    {
      int i = aQ.c(this.a).getLineAtOffset(aQ.c(this.a).getOffsetAtLocation(new Point(paramMouseEvent.x, paramMouseEvent.y)));
      if ((i < aQ.h(this.a).length) && (aQ.h(this.a)[i] >= 0))
        aQ.c(this.a).setCursor(Display.getCurrent().getSystemCursor(21));
      else
        aQ.c(this.a).setCursor(null);
    }
    catch (RuntimeException localRuntimeException)
    {
      aQ.c(this.a).setCursor(null);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.bh
 * JD-Core Version:    0.6.0
 */