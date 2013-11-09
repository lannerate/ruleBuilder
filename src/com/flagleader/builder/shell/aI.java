package com.flagleader.builder.shell;

import java.util.ArrayList;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;

class aI
  implements MouseMoveListener
{
  aI(StyledText paramStyledText, ArrayList paramArrayList)
  {
  }

  public void mouseMove(MouseEvent paramMouseEvent)
  {
    try
    {
      int i = this.a.getLineAtOffset(this.a.getOffsetAtLocation(new Point(paramMouseEvent.x, paramMouseEvent.y)));
      if (((Integer)this.b.get(i)).intValue() >= 0)
        this.a.setCursor(Display.getCurrent().getSystemCursor(21));
      else
        this.a.setCursor(null);
    }
    catch (RuntimeException localRuntimeException)
    {
      this.a.setCursor(null);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.aI
 * JD-Core Version:    0.6.0
 */