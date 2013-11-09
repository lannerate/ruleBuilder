package com.flagleader.builder.a.g;

import com.flagleader.builder.widget.p;
import com.flagleader.repository.tree.TestCase;
import com.flagleader.repository.tree.TestCaseLib;
import com.flagleader.repository.tree.TestObjectInfo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class Q extends MouseAdapter
{
  private TableItem b;

  public Q(P paramP)
  {
    P.a(paramP, new TableEditor(P.a(paramP)));
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    this.b = P.a(this.a).getItem(localPoint);
    P.a(this.a, this.b);
    if (this.b == null)
      return;
    if (this.b != P.b(this.a))
    {
      P.b(this.a, this.b);
      return;
    }
    for (int i = 1; i <= P.c(this.a); i++)
      a(this.b, localPoint, i);
  }

  private void a(TableItem paramTableItem, Point paramPoint, int paramInt)
  {
    Rectangle localRectangle = paramTableItem.getBounds(paramInt);
    if (localRectangle.contains(paramPoint))
    {
      Text localText = new p(P.d(this.a)).a(P.a(this.a), 4);
      localText.setText(paramTableItem.getText(paramInt));
      a(P.a(this.a), localText, P.e(this.a), paramInt);
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
    paramText.addFocusListener(new R(this, paramText, paramInt));
    paramText.addTraverseListener(new S(this, paramText, paramInt));
  }

  private void a(String paramString, int paramInt, TableItem paramTableItem)
  {
    TestCase localTestCase = (TestCase)paramTableItem.getData();
    TestObjectInfo localTestObjectInfo = localTestCase.getMatchTestObjectInfo(P.a(this.a).getColumn(paramInt).getText());
    if ((localTestObjectInfo != null) && (!localTestObjectInfo.getExpectValue().equals(paramString)) && ((paramString.length() == 0) || (localTestObjectInfo.checkValue(paramString))))
    {
      paramTableItem.setText(paramInt, paramString);
      localTestObjectInfo.setExpectValue(paramString);
      P.f(this.a).refreshInit();
      P.f(this.a).setModified(true);
      this.a.update();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.Q
 * JD-Core Version:    0.6.0
 */