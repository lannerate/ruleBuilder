package com.flagleader.builder.c;

import com.flagleader.manager.c.c.f;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class o
  implements TraverseListener
{
  o(k paramk, f paramf, Text paramText, TableItem paramTableItem, TableEditor paramTableEditor)
  {
  }

  public void keyTraversed(TraverseEvent paramTraverseEvent)
  {
    if ((paramTraverseEvent.detail == 16) || (paramTraverseEvent.detail == 4))
    {
      if (k.c(this.a) != null)
      {
        k.a(this.a, null);
        if ((!this.b.a().equals(this.c.getText())) && (!this.a.f()))
          if ((this.b.a(this.c.getText())) && (!this.d.isDisposed()))
          {
            this.d.setText(1, this.b.a());
            this.a.update();
          }
          else if (!this.d.isDisposed())
          {
            this.d.setText(1, this.b.a());
          }
      }
      this.e.setEditor(null, null, -1);
      if (this.c != null)
        this.c.dispose();
    }
    if (paramTraverseEvent.detail == 2)
    {
      this.e.setEditor(null, null, -1);
      if (this.c != null)
        this.c.dispose();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.c.o
 * JD-Core Version:    0.6.0
 */