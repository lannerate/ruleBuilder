package com.flagleader.builder.shell;

import com.flagleader.builder.dialogs.AboutLicenseDialog1;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class cD extends SelectionAdapter
{
  cD(RuleExecuteViewer paramRuleExecuteViewer)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    AboutLicenseDialog1 localAboutLicenseDialog1 = new AboutLicenseDialog1(RuleExecuteViewer.a(this.a));
    localAboutLicenseDialog1.open();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.cD
 * JD-Core Version:    0.6.0
 */