package com.flagleader.builder.shell;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.OpenWindowListener;
import org.eclipse.swt.browser.WindowEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

class az
  implements OpenWindowListener
{
  az(Display paramDisplay)
  {
  }

  public void open(WindowEvent paramWindowEvent)
  {
    Shell localShell = new Shell(this.a);
    localShell.setLayout(new FillLayout());
    Browser localBrowser = new Browser(localShell, 0);
    as.a(this.a, localBrowser);
    paramWindowEvent.browser = localBrowser;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.az
 * JD-Core Version:    0.6.0
 */