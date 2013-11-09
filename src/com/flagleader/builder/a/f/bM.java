package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.builder.d;
import java.util.HashMap;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;

class bM extends MouseAdapter
{
  bM(bK parambK, StyledText paramStyledText)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    try
    {
      int i = this.b.getOffsetAtLocation(new Point(paramMouseEvent.x, paramMouseEvent.y));
      int j = this.b.getLineAtOffset(i);
      if (bK.a(this.a).get(String.valueOf(j + 1)) != null)
        bK.b(this.a).getProjectTree().c((String)bK.a(this.a).get(String.valueOf(j + 1)));
    }
    catch (RuntimeException localRuntimeException)
    {
      this.b.setCursor(null);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.bM
 * JD-Core Version:    0.6.0
 */