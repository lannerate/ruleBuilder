package com.flagleader.builder.shell;

import java.io.File;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.FileDialog;

class cN extends SelectionAdapter
{
  cN(RuleExecuteViewer paramRuleExecuteViewer)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    try
    {
      FileDialog localFileDialog = new FileDialog(RuleExecuteViewer.a(this.a), 8192);
      localFileDialog.setFilterExtensions(new String[] { "*.rei" });
      if (this.a.a != null)
      {
        localFileDialog.setFilterPath(new File(this.a.a).getParent());
        localFileDialog.setFileName(new File(this.a.a).getName());
      }
      this.a.a = localFileDialog.open();
      this.a.c(this.a.a);
    }
    catch (Exception localException)
    {
      MessageDialog.openError(null, "", localException.getLocalizedMessage());
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.cN
 * JD-Core Version:    0.6.0
 */