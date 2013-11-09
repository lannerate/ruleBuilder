package com.flagleader.builder.a.g;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class N extends FocusAdapter
{
  N(M paramM, Text paramText)
  {
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    if ((M.a(this.a) != null) && (!M.a(this.a).isDisposed()) && (this.b != null) && (!this.b.isDisposed()))
      this.b.dispose();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.N
 * JD-Core Version:    0.6.0
 */