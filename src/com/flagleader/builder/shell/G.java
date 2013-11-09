package com.flagleader.builder.shell;

import com.flagleader.builder.widget.p;
import com.flagleader.repository.lang.info.InfoParameter;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class G extends MouseAdapter
{
  G(F paramF, TableEditor paramTableEditor)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    TableItem localTableItem = this.a.a.getItem(localPoint);
    if (localTableItem == null)
      return;
    int i = -1;
    for (int j = 0; j < this.a.a.getColumnCount(); j++)
    {
      if (!localTableItem.getBounds(j).contains(localPoint))
        continue;
      i = j;
    }
    if (i > 0)
    {
      InfoParameter localInfoParameter = (InfoParameter)localTableItem.getData();
      F.a(this.a, new p().a(this.a.a, 4));
      F.a(this.a).setFont(this.a.a.getFont());
      F.a(this.a).setText(localTableItem.getText(i));
      F.a(this.a).selectAll();
      this.b.horizontalAlignment = 16384;
      this.b.grabHorizontal = true;
      this.b.setEditor(F.a(this.a), localTableItem, i);
      int k = i;
      F.a(this.a).addFocusListener(new H(this, localTableItem, k));
      F.a(this.a).addTraverseListener(new I(this, localTableItem, k));
      F.a(this.a).setFocus();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.G
 * JD-Core Version:    0.6.0
 */