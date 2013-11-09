package com.flagleader.builder.a.a;

import com.flagleader.builder.dialogs.M;
import com.flagleader.builder.widget.h;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.TableModel;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class ao extends MouseAdapter
{
  private ao(an paraman)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    TableItem localTableItem = an.b(this.a).getItem(localPoint);
    if (localTableItem == null)
      return;
    if (localTableItem.getBounds(9).contains(localPoint))
      an.a(this.a, localTableItem, 9, new ap(this, localTableItem));
    else if (localTableItem.getBounds(3).contains(localPoint))
      an.a(this.a, localTableItem, 3, new aq(this, localTableItem));
    else if (localTableItem.getBounds(6).contains(localPoint))
      an.a(this.a, localTableItem, 6, new ar(this, localTableItem));
    else if (localTableItem.getBounds(8).contains(localPoint))
      an.a(this.a, localTableItem, 8, new as(this, localTableItem));
    a(localTableItem, localPoint, 10);
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    TableItem localTableItem = an.b(this.a).getItem(localPoint);
    if (localTableItem == null)
      return;
    if (paramMouseEvent.button == 3)
    {
      Menu localMenu = h.a();
      an.a(this.a, localMenu, "delete");
      new MenuItem(localMenu, 2);
      an.a(this.a, localMenu, "copy");
      localMenu.setEnabled(true);
      localMenu.setVisible(true);
    }
  }

  public void mouseUp(MouseEvent paramMouseEvent)
  {
    an.d(this.a);
    this.a.notifyObservers();
  }

  private void a(TableItem paramTableItem, Point paramPoint, int paramInt)
  {
    Rectangle localRectangle = paramTableItem.getBounds(paramInt);
    FieldModel localFieldModel = (FieldModel)paramTableItem.getData();
    if (localRectangle.contains(paramPoint))
    {
      M localM = new M(paramTableItem.getText(paramInt), 0);
      if ((localM.open() == 0) && (!localFieldModel.getDocument().equals(localM.a())))
      {
        localFieldModel.setDocument(localM.a());
        an.c(this.a).setModified(true);
        paramTableItem.setText(paramInt, localM.a());
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.ao
 * JD-Core Version:    0.6.0
 */