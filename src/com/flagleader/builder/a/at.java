package com.flagleader.builder.a;

import com.flagleader.builder.a.c.g;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.TableItem;

class at extends FocusAdapter
{
  at(an paraman, g paramg, CCombo paramCCombo, TableItem paramTableItem, int paramInt, TableEditor paramTableEditor)
  {
  }

  public void focusLost(FocusEvent paramFocusEvent)
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
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.at
 * JD-Core Version:    0.6.0
 */