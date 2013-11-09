package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.rlm.editen.ISheetDynamicEditen;
import com.flagleader.repository.tree.IRuleContainer;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class aW
  implements TraverseListener
{
  aW(aK paramaK, Text paramText, TableItem paramTableItem, int paramInt, TableEditor paramTableEditor)
  {
  }

  public void keyTraversed(TraverseEvent paramTraverseEvent)
  {
    if ((paramTraverseEvent.detail == 16) || (paramTraverseEvent.detail == 4))
    {
      String str = this.b.getText();
      if ((this.c != null) && (!this.c.isDisposed()) && (!str.equals(this.c.getText(this.d))))
      {
        this.c.setText(this.d, str);
        aK.a(this.a).getRoot().setModified(true);
      }
      this.b.dispose();
      this.e.setEditor(null, null, -1);
    }
    if (paramTraverseEvent.detail == 2)
    {
      this.b.dispose();
      this.e.setEditor(null, null, -1);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.aW
 * JD-Core Version:    0.6.0
 */