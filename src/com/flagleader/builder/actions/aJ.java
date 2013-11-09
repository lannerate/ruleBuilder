package com.flagleader.builder.actions;

import java.util.Hashtable;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;

class aJ
  implements MouseMoveListener
{
  aJ(aq paramaq)
  {
  }

  public void mouseMove(MouseEvent paramMouseEvent)
  {
    try
    {
      int i = aq.g(this.a).getLineAtOffset(aq.g(this.a).getOffsetAtLocation(new Point(paramMouseEvent.x, paramMouseEvent.y)));
      if (aq.h(this.a).get(String.valueOf(i)) != null)
        aq.g(this.a).setCursor(Display.getCurrent().getSystemCursor(21));
      else
        aq.g(this.a).setCursor(null);
    }
    catch (RuntimeException localRuntimeException)
    {
      aq.g(this.a).setCursor(null);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.aJ
 * JD-Core Version:    0.6.0
 */