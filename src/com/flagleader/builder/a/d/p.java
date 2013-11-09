package com.flagleader.builder.a.d;

import com.flagleader.builder.a.c.c;
import com.flagleader.builder.a.c.d;
import com.flagleader.builder.a.c.e;
import com.flagleader.repository.IElement;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

class p extends SelectionAdapter
{
  p(o paramo, TreeColumn paramTreeColumn, int paramInt)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if ((this.a.f() > 1) && (paramSelectionEvent.widget != null) && (paramSelectionEvent.widget.equals(this.b)))
    {
      TreeItem localTreeItem = this.a.e.getSelection()[0];
      if ((localTreeItem.getData() != null) && ((localTreeItem.getData() instanceof IElement)))
      {
        c localc = this.a.a((IElement)localTreeItem.getData(), this.c, true);
        if ((localc != null) && ((localc instanceof e)))
          o.a(this.a, localTreeItem, this.c, (e)localc);
        else if ((localc != null) && ((localc instanceof d)))
          o.a(this.a, localTreeItem, this.c, (d)localc);
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.p
 * JD-Core Version:    0.6.0
 */