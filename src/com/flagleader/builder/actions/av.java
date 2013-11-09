package com.flagleader.builder.actions;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.d;
import com.flagleader.builder.widget.h;
import com.flagleader.repository.IElement;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class av extends MouseAdapter
{
  av(aq paramaq, Table paramTable)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    TableItem localTableItem = this.b.getItem(new Point(paramMouseEvent.x, paramMouseEvent.y));
    if ((localTableItem != null) && (localTableItem.getData() != null) && ((localTableItem.getData() instanceof IElement)))
    {
      IElement localIElement = (IElement)localTableItem.getData();
      new Clipboard(Display.getCurrent()).setContents(new Object[] { localIElement }, new Transfer[] { d.a() });
    }
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (this.b.getItem(new Point(paramMouseEvent.x, paramMouseEvent.y)) != null)
    {
      TableItem localTableItem = this.b.getItem(new Point(paramMouseEvent.x, paramMouseEvent.y));
      if ((paramMouseEvent.button == 3) && (localTableItem.getData() != null) && ((localTableItem.getData() instanceof IElement)))
      {
        IElement localIElement = (IElement)localTableItem.getData();
        aq.a(this.a, h.a());
        MenuItem localMenuItem = new MenuItem(aq.f(this.a), 8);
        localMenuItem.setText(ResourceTools.getMessage("copy.popup"));
        localMenuItem.addSelectionListener(new aw(this, localIElement));
        aq.f(this.a).setVisible(true);
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.av
 * JD-Core Version:    0.6.0
 */