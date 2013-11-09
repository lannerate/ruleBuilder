package com.flagleader.builder.shell;

import com.flagleader.util.filesystem.FileUtil;
import java.util.ArrayList;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;

class aJ extends MouseAdapter
{
  aJ(StyledText paramStyledText1, ArrayList paramArrayList, StyledText paramStyledText2)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    try
    {
      int i = this.a.getLineAtOffset(this.a.getOffsetAtLocation(new Point(paramMouseEvent.x, paramMouseEvent.y)));
      if (((Integer)this.b.get(i)).intValue() >= 0)
        this.c.setSelection(((Integer)this.b.get(i)).intValue(), this.c.getText().indexOf(FileUtil.newline, ((Integer)this.b.get(i)).intValue() + 1));
    }
    catch (RuntimeException localRuntimeException)
    {
      this.a.setCursor(null);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.aJ
 * JD-Core Version:    0.6.0
 */