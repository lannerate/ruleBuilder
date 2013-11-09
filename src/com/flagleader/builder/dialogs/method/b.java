package com.flagleader.builder.dialogs.method;

import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Text;

class b
  implements ModifyListener
{
  b(a parama, Text paramText)
  {
  }

  public void modifyText(ModifyEvent paramModifyEvent)
  {
    Integer localInteger = (Integer)this.b.getData("index");
    this.a.b[localInteger.intValue()] = this.b.getText();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.method.b
 * JD-Core Version:    0.6.0
 */