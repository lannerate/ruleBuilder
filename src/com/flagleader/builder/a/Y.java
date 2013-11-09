package com.flagleader.builder.a;

import com.flagleader.builder.dialogs.e.bA;
import com.flagleader.repository.rlm.editen.ISheetFieldEditen;
import com.flagleader.repository.tree.IRuleContainer;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

class Y extends MouseAdapter
{
  Y(b paramb, Label paramLabel, ISheetFieldEditen paramISheetFieldEditen)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 1)
    {
      Shell localShell = new Shell(16);
      localShell.setLocation(this.b.getLocation());
      bA localbA = new bA(localShell, this.c);
      if (localbA.open() == 0)
      {
        this.c.getRoot().setModified(true);
        this.c.setSelected(localbA.a());
        this.c.update();
      }
    }
    else
    {
      b.a(this.a, paramMouseEvent);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.Y
 * JD-Core Version:    0.6.0
 */