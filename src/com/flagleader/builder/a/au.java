package com.flagleader.builder.a;

import com.flagleader.builder.a.c.g;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.TableItem;

class au
  implements TraverseListener
{
  au(an paraman, g paramg, CCombo paramCCombo, TableItem paramTableItem, int paramInt, TableEditor paramTableEditor)
  {
  }

  public void keyTraversed(TraverseEvent paramTraverseEvent)
  {
    if ((paramTraverseEvent.detail == 16) || (paramTraverseEvent.detail == 4))
    {
      if ((!this.b.a().equals(this.c.getText())) && (!this.a.b()))
      {
        this.b.a(this.c.getText());
        this.d.setText(this.e, this.c.getText());
        this.a.a(this.d);
      }
      this.f.dispose();
      this.c.dispose();
    }
    if (paramTraverseEvent.detail == 2)
    {
      this.f.dispose();
      this.c.dispose();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.au
 * JD-Core Version:    0.6.0
 */