package com.flagleader.builder.shell;

import com.flagleader.builder.widget.p;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class U extends MouseAdapter
{
  U(M paramM)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (M.e(this.a) != null)
    {
      localObject1 = new Point(paramMouseEvent.x, paramMouseEvent.y);
      M.a(this.a, M.d(this.a).getItem((Point)localObject1));
      if (M.f(this.a) == null)
        return;
      localObject2 = M.f(this.a).getBounds(1);
      if (((Rectangle)localObject2).contains((Point)localObject1))
      {
        localObject3 = new p().a(M.d(this.a), 4);
        ((Text)localObject3).setText(M.f(this.a).getText(1));
        M.a(this.a, M.f(this.a), (Text)localObject3, M.g(this.a), 1);
        ((Text)localObject3).setFocus();
      }
      else
      {
        localObject3 = new Z(this.a, M.e(this.a).getText(0), M.e(this.a).getText(1), M.e(this.a).getText(2));
        if ((((Z)localObject3).open() == 0) && (((Z)localObject3).a().length() > 0))
        {
          StringBuffer localStringBuffer = new StringBuffer(((Z)localObject3).b());
          if ((!((Z)localObject3).a().equals(M.e(this.a).getText(0))) || (!localStringBuffer.toString().equals(M.e(this.a).getText(1))))
          {
            M.e(this.a).setText(0, ((Z)localObject3).a());
            M.e(this.a).setText(1, localStringBuffer.toString());
            M.a(this.a, true);
          }
        }
      }
    }
    else
    {
      localObject1 = new Z(this.a);
      if ((((Z)localObject1).open() == 0) && (((Z)localObject1).a().length() > 0))
      {
        localObject2 = new StringBuffer(((Z)localObject1).b());
        localObject3 = new TableItem(M.d(this.a), 0);
        ((TableItem)localObject3).setText(new String[] { ((Z)localObject1).a(), ((StringBuffer)localObject2).toString() });
        M.a(this.a, true);
      }
    }
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 1)
    {
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      TableItem localTableItem = M.d(this.a).getItem(localPoint);
      if (localTableItem == null)
        M.d(this.a).setSelection(new TableItem[0]);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.U
 * JD-Core Version:    0.6.0
 */