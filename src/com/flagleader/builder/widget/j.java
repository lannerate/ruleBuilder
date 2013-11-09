package com.flagleader.builder.widget;

import com.flagleader.builder.dialogs.M;
import java.util.List;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class j extends MouseAdapter
{
  j(i parami)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    TableItem localTableItem = i.c(this.a).getItem(localPoint);
    if (localTableItem == null)
      return;
    int i = -1;
    for (int j = 0; j < i.c(this.a).getColumnCount(); j++)
    {
      if (!localTableItem.getBounds(j).contains(localPoint))
        continue;
      i = j;
    }
    if (i > 0)
    {
      String str = localTableItem.getText(i);
      if ((str == null) || (str.length() <= 30))
      {
        i.a(this.a, new p().a(i.c(this.a), 4));
        i.d(this.a).setFont(i.c(this.a).getFont());
        i.d(this.a).setText(localTableItem.getText(i));
        i.a(this.a, localTableItem, i.d(this.a), i.e(this.a), i);
        i.d(this.a).setFocus();
      }
      else
      {
        if (localTableItem.getData() != null)
        {
          Object localObject;
          if ((localTableItem.getData() instanceof List))
          {
            localObject = (List)localTableItem.getData();
            if (((List)localObject).size() == i.c(this.a).getColumnCount())
              str = this.a.a(((List)localObject).get(i));
            else if (((List)localObject).size() == i.c(this.a).getColumnCount() - 1)
              str = this.a.a(((List)localObject).get(i - 1));
          }
          else if ((localTableItem.getData() instanceof Object[]))
          {
            localObject = (Object[])localTableItem.getData();
            if (localObject.length == i.c(this.a).getColumnCount())
              str = this.a.a(localObject[i]);
            else if (localObject.length == i.c(this.a).getColumnCount() - 1)
              str = this.a.a(localObject[(i - 1)]);
          }
        }
        new M(this.a.a(str), 0, 1).open();
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.j
 * JD-Core Version:    0.6.0
 */