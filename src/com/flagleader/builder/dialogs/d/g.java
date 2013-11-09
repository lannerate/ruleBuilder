package com.flagleader.builder.dialogs.d;

import com.flagleader.builder.widget.p;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class g extends MouseAdapter
{
  g(a parama)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (a.d(this.a) != null)
    {
      localObject1 = new Point(paramMouseEvent.x, paramMouseEvent.y);
      a.a(this.a, a.c(this.a).getItem((Point)localObject1));
      if (a.e(this.a) == null)
        return;
      localObject2 = a.e(this.a).getBounds(1);
      if (((Rectangle)localObject2).contains((Point)localObject1))
      {
        localObject3 = new p().a(a.c(this.a), 4);
        ((Text)localObject3).setText(a.e(this.a).getText(1));
        a.a(this.a, a.e(this.a), (Text)localObject3, a.f(this.a), 1);
        ((Text)localObject3).setFocus();
      }
      else
      {
        localObject3 = new n(this.a, a.d(this.a).getText(0), a.d(this.a).getText(1), a.d(this.a).getText(2));
        if ((((n)localObject3).open() == 0) && (((n)localObject3).a().length() > 0))
        {
          StringBuffer localStringBuffer = new StringBuffer(((n)localObject3).b());
          a.a(this.a, localStringBuffer);
          if ((!((n)localObject3).a().equals(a.d(this.a).getText(0))) || (!localStringBuffer.toString().equals(a.d(this.a).getText(1))))
          {
            a.d(this.a).setText(0, ((n)localObject3).a());
            a.d(this.a).setText(1, localStringBuffer.toString());
            a.d(this.a).setText(2, ((n)localObject3).c());
            a.a(this.a, true);
          }
        }
      }
    }
    else
    {
      localObject1 = new n(this.a);
      if ((((n)localObject1).open() == 0) && (((n)localObject1).a().length() > 0))
      {
        localObject2 = new StringBuffer(((n)localObject1).b());
        a.a(this.a, (StringBuffer)localObject2);
        localObject3 = new TableItem(a.c(this.a), 0);
        ((TableItem)localObject3).setText(new String[] { ((n)localObject1).a(), ((StringBuffer)localObject2).toString(), ((n)localObject1).c() });
        a.a(this.a, true);
      }
    }
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 1)
    {
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      TableItem localTableItem = a.c(this.a).getItem(localPoint);
      if (localTableItem == null)
        a.c(this.a).setSelection(new TableItem[0]);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.d.g
 * JD-Core Version:    0.6.0
 */