package com.flagleader.builder.shell;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;

class bL
  implements MouseMoveListener
{
  bL(bu parambu)
  {
  }

  public void mouseMove(MouseEvent paramMouseEvent)
  {
    try
    {
      int i = bu.a(this.a).getLineAtOffset(bu.a(this.a).getOffsetAtLocation(new Point(paramMouseEvent.x, paramMouseEvent.y)));
      if ((i < bu.f(this.a).length) && (bu.f(this.a)[i] >= 0))
        bu.a(this.a).setCursor(Display.getCurrent().getSystemCursor(21));
      else
        bu.a(this.a).setCursor(null);
    }
    catch (RuntimeException localRuntimeException)
    {
      bu.a(this.a).setCursor(null);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.bL
 * JD-Core Version:    0.6.0
 */