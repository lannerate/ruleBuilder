package com.flagleader.builder.widget.a;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;

class ax
  implements ModifyListener
{
  ax(aw paramaw, StyledText paramStyledText)
  {
  }

  public void modifyText(ModifyEvent paramModifyEvent)
  {
    aw.a(this.a).a(this.b.getText());
    this.a.e.redraw();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.a.ax
 * JD-Core Version:    0.6.0
 */