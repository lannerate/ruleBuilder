package com.flagleader.builder.shell;

import com.flagleader.builder.ResourceTools;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class u extends MouseAdapter
{
  u(ClassInfoEditor paramClassInfoEditor, TableEditor paramTableEditor)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if ((paramMouseEvent.button == 3) && (ClassInfoEditor.k(this.a).getSelectionCount() >= 1))
    {
      if ((this.a.i != null) && (!this.a.i.isDisposed()))
        this.a.i.dispose();
      this.a.i = new Menu(ClassInfoEditor.k(this.a).getShell(), 8);
      MenuItem localMenuItem = new MenuItem(this.a.i, 8);
      localMenuItem.setText(ResourceTools.getMessage("delete.popup", "delete"));
      localMenuItem.addListener(13, new v(this));
      this.a.i.setEnabled(true);
      this.a.i.setVisible(true);
    }
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    TableItem localTableItem = ClassInfoEditor.k(this.a).getItem(localPoint);
    if (localTableItem == null)
      return;
    int i = -1;
    for (int j = 0; j < ClassInfoEditor.k(this.a).getColumnCount(); j++)
    {
      if (!localTableItem.getBounds(j).contains(localPoint))
        continue;
      i = j;
    }
    if (i == 0)
    {
      Text localText = new Text(ClassInfoEditor.k(this.a), 4);
      localText.setFont(ClassInfoEditor.k(this.a).getFont());
      localText.setText(localTableItem.getText(i));
      ClassInfoEditor.a(this.a, localTableItem, localText, this.b, i);
      localText.setFocus();
    }
    else if (i == 3)
    {
      ClassInfoEditor.l(this.a);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.u
 * JD-Core Version:    0.6.0
 */