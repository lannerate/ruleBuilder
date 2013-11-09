package com.flagleader.builder.dialogs.method;

import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

class K
  implements ModifyListener
{
  K(I paramI)
  {
  }

  public void modifyText(ModifyEvent paramModifyEvent)
  {
    boolean bool = this.a.b.getCharCount() != 0;
    this.a.h.setEnabled(bool);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.method.K
 * JD-Core Version:    0.6.0
 */