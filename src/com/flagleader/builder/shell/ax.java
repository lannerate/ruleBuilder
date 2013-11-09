package com.flagleader.builder.shell;

import org.eclipse.swt.browser.TitleEvent;
import org.eclipse.swt.browser.TitleListener;
import org.eclipse.swt.widgets.Shell;

class ax
  implements TitleListener
{
  ax(as paramas, Shell paramShell)
  {
  }

  public void changed(TitleEvent paramTitleEvent)
  {
    this.b.setText(paramTitleEvent.title + " - " + as.a("window.title"));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.ax
 * JD-Core Version:    0.6.0
 */