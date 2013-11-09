package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.builder.d;
import java.util.Hashtable;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;

class aK extends MouseAdapter
{
  aK(aq paramaq)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    try
    {
      int i = aq.g(this.a).getLineAtOffset(aq.g(this.a).getOffsetAtLocation(new Point(paramMouseEvent.x, paramMouseEvent.y)));
      String str = (String)aq.h(this.a).get(String.valueOf(i));
      if (str != null)
        aq.e(this.a).getProjectTree().b(str);
    }
    catch (RuntimeException localRuntimeException)
    {
      aq.g(this.a).setCursor(null);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.aK
 * JD-Core Version:    0.6.0
 */