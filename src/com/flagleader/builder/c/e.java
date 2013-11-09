package com.flagleader.builder.c;

import com.flagleader.repository.tree.Envionment;
import java.util.List;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class e
  implements Listener
{
  e(b paramb)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    if (a.b(b.a(this.a)).getSelectionIndex() >= 0)
    {
      a.a(b.a(this.a)).getClassDirVector().remove(a.b(b.a(this.a)).getSelection()[0].getText());
      a.b(b.a(this.a)).getSelection()[0].dispose();
      a.a(b.a(this.a)).setModified(true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.c.e
 * JD-Core Version:    0.6.0
 */