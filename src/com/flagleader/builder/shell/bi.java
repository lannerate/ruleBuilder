package com.flagleader.builder.shell;

import com.flagleader.util.filesystem.FileUtil;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;

class bi extends MouseAdapter
{
  bi(aQ paramaQ)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    try
    {
      int i = aQ.c(this.a).getLineAtOffset(aQ.c(this.a).getOffsetAtLocation(new Point(paramMouseEvent.x, paramMouseEvent.y)));
      if ((i < aQ.h(this.a).length) && (aQ.h(this.a)[i] >= 0))
        aQ.i(this.a).setSelection(aQ.h(this.a)[i], aQ.i(this.a).getText().indexOf(FileUtil.newline, aQ.h(this.a)[i]));
    }
    catch (RuntimeException localRuntimeException)
    {
      aQ.c(this.a).setCursor(null);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.bi
 * JD-Core Version:    0.6.0
 */