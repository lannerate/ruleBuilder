package com.flagleader.builder.dialogs.d;

import com.flagleader.builder.widget.p;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class y extends MouseAdapter
{
  y(v paramv)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    if (v.b(this.a) != null)
    {
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      v.a(this.a, v.a(this.a).getItem(localPoint));
      if (v.c(this.a) == null)
        return;
      for (int i = 1; i <= 2; i++)
      {
        Rectangle localRectangle = v.c(this.a).getBounds(i);
        if (!localRectangle.contains(localPoint))
          continue;
        Text localText = new p().a(v.a(this.a), 4);
        localText.setText(v.c(this.a).getText(i));
        v.a(this.a, v.c(this.a), localText, v.d(this.a), i);
        localText.setFocus();
      }
    }
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 1)
    {
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      TableItem localTableItem = v.a(this.a).getItem(localPoint);
      if (localTableItem == null)
        v.a(this.a).setSelection(new TableItem[0]);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.d.y
 * JD-Core Version:    0.6.0
 */