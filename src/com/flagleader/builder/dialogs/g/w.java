package com.flagleader.builder.dialogs.g;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.Text;

class w extends FocusAdapter
{
  w(v paramv)
  {
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    if (!v.a(this.a).getText().equals(v.b(this.a)))
    {
      v.a(this.a, v.a(this.a).getText());
      v.c(this.a);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.g.w
 * JD-Core Version:    0.6.0
 */