package com.flagleader.builder.a.g;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.d.v;
import com.flagleader.repository.tree.CheckRuleInfo;
import com.flagleader.repository.tree.IRuleSet;
import com.flagleader.repository.tree.TestCase;
import com.flagleader.repository.tree.TestObjectInfo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

class h extends MouseAdapter
{
  private TableItem b;

  public h(a parama)
  {
    a.a(parama, new TableEditor(a.e(parama)));
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    this.b = a.e(this.a).getItem(localPoint);
    if (this.b == null)
      return;
    TestCase localTestCase = (TestCase)this.b.getData();
    if (localTestCase != null)
    {
      v localv = new v(localTestCase);
      if (localv.open() == 0)
      {
        a.b(this.a).refreshInit();
        a.f(this.a).setModified(true);
        this.a.update();
      }
    }
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 3)
    {
      if (a.d(this.a))
        return;
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      this.b = a.e(this.a).getItem(localPoint);
      if (this.b == null)
        return;
      TestCase localTestCase = (TestCase)this.b.getData();
      if (localTestCase != null)
      {
        Menu localMenu = com.flagleader.builder.widget.h.a();
        if (!a.d(this.a))
        {
          MenuItem localMenuItem = new MenuItem(localMenu, 64);
          localMenuItem.setText(ResourceTools.getMessage("delete.popup"));
          localMenuItem.addListener(13, new i(this, localTestCase));
        }
        localMenu.setEnabled(true);
        localMenu.setVisible(true);
      }
    }
  }

  private void a(String paramString, int paramInt, TableItem paramTableItem)
  {
    TestCase localTestCase = (TestCase)paramTableItem.getData();
    TestObjectInfo localTestObjectInfo = localTestCase.getMatchTestObjectInfo(a.e(this.a).getColumn(paramInt).getText());
    if ((localTestObjectInfo != null) && (!localTestObjectInfo.getInitialValue().equals(paramString)) && ((paramString.length() == 0) || (localTestObjectInfo.checkValue(paramString))))
    {
      paramTableItem.setText(paramInt, paramString);
      localTestObjectInfo.setInitialValue(paramString);
      a.f(this.a).setModified(true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.h
 * JD-Core Version:    0.6.0
 */