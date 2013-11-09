package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.rlm.action.AbstractPackageField;
import com.flagleader.repository.rlm.editen.ISelectRulePackageEditen;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class Q
  implements TraverseListener
{
  Q(C paramC, Text paramText, TableItem paramTableItem, int paramInt)
  {
  }

  public void keyTraversed(TraverseEvent paramTraverseEvent)
  {
    if ((paramTraverseEvent.detail == 16) || (paramTraverseEvent.detail == 4))
    {
      String str = this.b.getText();
      if ((this.c != null) && (!this.c.isDisposed()) && (!str.equals(this.c.getText(this.d))))
      {
        AbstractPackageField localAbstractPackageField = (AbstractPackageField)this.c.getData();
        if (this.d == 0)
          localAbstractPackageField.setFuncName(str);
        else if (this.d == 1)
          localAbstractPackageField.setNaryType(str);
        else if (this.d == 2)
          localAbstractPackageField.setDisplayName(str);
        this.c.setText(this.d, str);
        C.a(this.a).setModified(true);
      }
      this.b.dispose();
      C.k(this.a).setEditor(null, null, -1);
    }
    if (paramTraverseEvent.detail == 2)
    {
      this.b.dispose();
      C.k(this.a).setEditor(null, null, -1);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.Q
 * JD-Core Version:    0.6.0
 */