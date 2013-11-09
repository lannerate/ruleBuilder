package com.flagleader.builder.c;

import com.flagleader.repository.tree.Envionment;
import java.util.List;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class g
  implements Listener
{
  g(b paramb)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    int i = a.b(b.a(this.a)).getSelectionIndex();
    if ((i > -1) && (a.b(b.a(this.a)).getItemCount() > 1) && (i < a.b(b.a(this.a)).getItemCount() - 1))
    {
      TableItem localTableItem = a.b(b.a(this.a)).getItem(i + 1);
      String str = localTableItem.getText(0);
      localTableItem.setText(0, a.b(b.a(this.a)).getItem(i).getText(0));
      a.b(b.a(this.a)).getItem(i).setText(0, str);
      a.b(b.a(this.a)).update();
      a.b(b.a(this.a)).select(i + 1);
      Object localObject = a.a(b.a(this.a)).getClassDirVector().remove(i);
      a.a(b.a(this.a)).getClassDirVector().add(i + 1, localObject);
      a.a(b.a(this.a)).setModified(true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.c.g
 * JD-Core Version:    0.6.0
 */