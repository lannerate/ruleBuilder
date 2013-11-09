package com.flagleader.builder.a.f;

import com.flagleader.builder.widget.p;
import com.flagleader.repository.tree.DecisionRule;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class aO extends MouseAdapter
{
  aO(aN paramaN)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    if ((aN.d(this.a)) || (aN.b(this.a).getMemberElement() == null))
      return;
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    TableItem localTableItem1 = aN.a(this.a).getItem(localPoint);
    TableItem localTableItem2 = localTableItem1;
    if (localTableItem2 == null)
      return;
    int i = aN.b(this.a).getMaxX();
    int j = -1;
    for (int k = 0; k < i; k++)
    {
      if (!localTableItem2.getBounds(k + 1).contains(localPoint))
        continue;
      j = k + 1;
    }
    k = j;
    if ((k > 0) && (localTableItem2.getData("y") != null))
    {
      aN.a(this.a, new p(aN.c(this.a)).a(aN.a(this.a), 4));
      aN.e(this.a).setFont(aN.a(this.a).getFont());
      aN.e(this.a).setText(localTableItem2.getText(k));
      aN.e(this.a).selectAll();
      aN.f(this.a).setEditor(aN.e(this.a), localTableItem2, k);
      aN.e(this.a).addFocusListener(new aP(this, localTableItem2, k));
      aN.e(this.a).addTraverseListener(new aQ(this, localTableItem2, k));
      aN.e(this.a).setFocus();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.aO
 * JD-Core Version:    0.6.0
 */