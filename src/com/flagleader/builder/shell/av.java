package com.flagleader.builder.shell;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.browser.ProgressListener;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.ToolItem;

class av
  implements ProgressListener
{
  av(as paramas, ProgressBar paramProgressBar, ToolItem paramToolItem1, ToolItem paramToolItem2)
  {
  }

  public void changed(ProgressEvent paramProgressEvent)
  {
    if (paramProgressEvent.total == 0)
      return;
    int i = paramProgressEvent.current * 100 / paramProgressEvent.total;
    this.b.setSelection(i);
    this.a.b = (paramProgressEvent.current != paramProgressEvent.total);
    if (!this.a.b)
      this.a.a = 0;
  }

  public void completed(ProgressEvent paramProgressEvent)
  {
    this.c.setEnabled(this.a.d.isBackEnabled());
    this.d.setEnabled(this.a.d.isForwardEnabled());
    this.b.setSelection(0);
    this.a.b = false;
    this.a.a = 0;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.av
 * JD-Core Version:    0.6.0
 */