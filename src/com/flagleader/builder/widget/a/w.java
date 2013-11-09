package com.flagleader.builder.widget.a;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;

class w
  implements ModifyListener
{
  w(v paramv, StyledText paramStyledText)
  {
  }

  public void modifyText(ModifyEvent paramModifyEvent)
  {
    v.a(this.a).a(this.b.getText());
    this.a.e.redraw();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.a.w
 * JD-Core Version:    0.6.0
 */