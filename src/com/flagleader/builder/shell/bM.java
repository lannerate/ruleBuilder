package com.flagleader.builder.shell;

import com.flagleader.util.filesystem.FileUtil;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;

class bM extends MouseAdapter
{
  bM(bu parambu)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    try
    {
      int i = bu.a(this.a).getLineAtOffset(bu.a(this.a).getOffsetAtLocation(new Point(paramMouseEvent.x, paramMouseEvent.y)));
      if ((i < bu.f(this.a).length) && (bu.f(this.a)[i] >= 0))
        this.a.c.setSelection(bu.f(this.a)[i], this.a.c.getText().indexOf(FileUtil.newline, bu.f(this.a)[i]));
    }
    catch (RuntimeException localRuntimeException)
    {
      bu.a(this.a).setCursor(null);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.bM
 * JD-Core Version:    0.6.0
 */