package com.flagleader.builder.shell;

import org.eclipse.swt.browser.StatusTextEvent;
import org.eclipse.swt.browser.StatusTextListener;
import org.eclipse.swt.widgets.Label;

class aw
  implements StatusTextListener
{
  aw(as paramas, Label paramLabel)
  {
  }

  public void changed(StatusTextEvent paramStatusTextEvent)
  {
    if (!this.b.isDisposed())
      this.b.setText(paramStatusTextEvent.text);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.aw
 * JD-Core Version:    0.6.0
 */