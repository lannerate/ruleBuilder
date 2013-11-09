package com.flagleader.builder.a.f;

import java.util.HashMap;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;

class bL
  implements MouseMoveListener
{
  bL(bK parambK, StyledText paramStyledText)
  {
  }

  public void mouseMove(MouseEvent paramMouseEvent)
  {
    try
    {
      int i = this.b.getOffsetAtLocation(new Point(paramMouseEvent.x, paramMouseEvent.y));
      int j = this.b.getLineAtOffset(i);
      if (bK.a(this.a).get(String.valueOf(j + 1)) != null)
        this.b.setCursor(Display.getCurrent().getSystemCursor(21));
      else
        this.b.setCursor(null);
    }
    catch (RuntimeException localRuntimeException)
    {
      this.b.setCursor(null);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.bL
 * JD-Core Version:    0.6.0
 */