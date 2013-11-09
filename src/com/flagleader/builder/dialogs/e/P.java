package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.rlm.action.AbstractPackageField;
import com.flagleader.repository.rlm.editen.ISelectRulePackageEditen;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class P extends FocusAdapter
{
  P(C paramC, Text paramText, TableItem paramTableItem, int paramInt)
  {
  }

  public void focusLost(FocusEvent paramFocusEvent)
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
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.P
 * JD-Core Version:    0.6.0
 */