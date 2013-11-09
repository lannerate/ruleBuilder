package com.flagleader.builder.a;

import com.flagleader.builder.a.c.f;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class as
  implements TraverseListener
{
  as(an paraman, TableItem paramTableItem, Text paramText, int paramInt, f paramf, TableEditor paramTableEditor)
  {
  }

  public void keyTraversed(TraverseEvent paramTraverseEvent)
  {
    if ((paramTraverseEvent.detail == 16) || (paramTraverseEvent.detail == 4))
      an.a(this.a, this.b, this.c, this.d, this.e, this.f);
    if (paramTraverseEvent.detail == 2)
      an.a(this.a, this.c, this.f);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.as
 * JD-Core Version:    0.6.0
 */