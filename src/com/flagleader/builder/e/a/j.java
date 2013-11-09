package com.flagleader.builder.e.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.TableItem;

class j
  implements TraverseListener
{
  j(g paramg, CCombo paramCCombo, TableItem paramTableItem)
  {
  }

  public void keyTraversed(TraverseEvent paramTraverseEvent)
  {
    if ((paramTraverseEvent.detail == 4) || (paramTraverseEvent.detail == 16))
    {
      if (this.b.getSelectionIndex() >= 0)
      {
        Object localObject = this.c.getData();
        g.c(this.a).put(g.d(this.a).get(this.b.getSelectionIndex()), localObject);
        this.a.a.put(localObject, g.d(this.a).get(this.b.getSelectionIndex()));
        this.c.setText(3, g.a(this.a, g.d(this.a).get(this.b.getSelectionIndex())));
      }
      this.b.dispose();
      g.e(this.a).setEditor(null, null, -1);
    }
    if (paramTraverseEvent.detail == 2)
    {
      this.b.dispose();
      g.e(this.a).setEditor(null, null, -1);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.e.a.j
 * JD-Core Version:    0.6.0
 */