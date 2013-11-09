package com.flagleader.builder.a.g;

import com.flagleader.builder.widget.p;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class M extends MouseAdapter
{
  private TableItem b;

  public M(L paramL)
  {
    L.a(paramL, new TableEditor(L.a(paramL)));
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    this.b = L.a(this.a).getItem(localPoint);
    L.a(this.a, this.b);
    if (this.b == null)
      return;
    if (this.b != L.b(this.a))
    {
      L.b(this.a, this.b);
      return;
    }
    for (int i = 1; i <= L.c(this.a); i++)
      a(this.b, localPoint, i);
  }

  private void a(TableItem paramTableItem, Point paramPoint, int paramInt)
  {
    Rectangle localRectangle = paramTableItem.getBounds(paramInt);
    if (localRectangle.contains(paramPoint))
    {
      Text localText = new p(L.d(this.a)).a(L.a(this.a), 4);
      localText.setText(paramTableItem.getText(paramInt));
      a(L.a(this.a), localText, L.e(this.a), paramInt);
      localText.setFocus();
    }
  }

  private void a(Table paramTable, Text paramText, TableEditor paramTableEditor, int paramInt)
  {
    paramText.setFont(paramTable.getFont());
    paramText.selectAll();
    paramTableEditor.horizontalAlignment = 16384;
    paramTableEditor.grabHorizontal = true;
    paramTableEditor.setEditor(paramText, this.b, paramInt);
    paramText.addFocusListener(new N(this, paramText));
    paramText.addTraverseListener(new O(this, paramText));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.M
 * JD-Core Version:    0.6.0
 */