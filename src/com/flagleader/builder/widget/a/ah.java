package com.flagleader.builder.widget.a;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Menu;

class ah extends MouseAdapter
{
  ah(af paramaf)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 3)
    {
      if (this.a.e.getSelectionText().length() > 0)
      {
        af.b(this.a, true);
        af.c(this.a, true);
        af.d(this.a, true);
      }
      else
      {
        af.b(this.a, false);
        af.c(this.a, false);
        af.d(this.a, false);
      }
      af.a(this.a, true);
      Menu localMenu = this.a.i();
      localMenu.setVisible(true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.a.ah
 * JD-Core Version:    0.6.0
 */