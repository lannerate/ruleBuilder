package com.flagleader.builder.shell;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;

class n
  implements MouseMoveListener
{
  n(ClassInfoEditor paramClassInfoEditor)
  {
  }

  public void mouseMove(MouseEvent paramMouseEvent)
  {
    try
    {
      int i = ClassInfoEditor.d(this.a).getLineAtOffset(ClassInfoEditor.d(this.a).getOffsetAtLocation(new Point(paramMouseEvent.x, paramMouseEvent.y)));
      if ((i < ClassInfoEditor.h(this.a).length) && (ClassInfoEditor.h(this.a)[i] >= 0))
        ClassInfoEditor.d(this.a).setCursor(Display.getCurrent().getSystemCursor(21));
      else
        ClassInfoEditor.d(this.a).setCursor(null);
    }
    catch (RuntimeException localRuntimeException)
    {
      ClassInfoEditor.d(this.a).setCursor(null);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.n
 * JD-Core Version:    0.6.0
 */