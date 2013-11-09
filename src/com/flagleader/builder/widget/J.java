package com.flagleader.builder.widget;

import com.flagleader.manager.e.A;
import com.flagleader.manager.e.z;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class J
  implements A
{
  J(E paramE, TableItem paramTableItem, ProgressBar paramProgressBar, z paramz)
  {
  }

  public void a(z paramz)
  {
    E.a(this.a).getDisplay().asyncExec(new K(this, this.b, this.c, this.d));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.J
 * JD-Core Version:    0.6.0
 */