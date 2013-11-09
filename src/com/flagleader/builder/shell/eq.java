package com.flagleader.builder.shell;

import com.flagleader.builder.dialogs.AboutLicenseDialog1;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Shell;

class eq
  implements SelectionListener
{
  eq(RuleThreadServerTray paramRuleThreadServerTray, Shell paramShell)
  {
  }

  public void widgetDefaultSelected(SelectionEvent paramSelectionEvent)
  {
    AboutLicenseDialog1 localAboutLicenseDialog1 = new AboutLicenseDialog1(this.b);
    localAboutLicenseDialog1.open();
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    widgetDefaultSelected(paramSelectionEvent);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.eq
 * JD-Core Version:    0.6.0
 */