package com.flagleader.builder.dialogs.d;

import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class z extends FocusAdapter
{
  z(v paramv, Text paramText, TableItem paramTableItem, int paramInt, TableEditor paramTableEditor)
  {
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    String str = this.b.getText();
    if ((this.c != null) && (!this.c.isDisposed()) && (!str.equals(this.c.getText(this.d))))
    {
      this.c.setText(this.d, str);
      v.a(this.a, true);
    }
    this.b.dispose();
    this.e.setEditor(null, null, -1);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.d.z
 * JD-Core Version:    0.6.0
 */