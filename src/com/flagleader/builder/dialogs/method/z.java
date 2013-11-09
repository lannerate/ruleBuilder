package com.flagleader.builder.dialogs.method;

import java.util.ResourceBundle;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

class z extends SelectionAdapter
{
  z(MethodShell paramMethodShell)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    MessageBox localMessageBox = new MessageBox(MethodShell.k(this.a), 0);
    localMessageBox.setText(MethodShell.a().getString("About_1") + MethodShell.k(this.a).getText());
    localMessageBox.setMessage(MethodShell.k(this.a).getText() + MethodShell.a().getString("About_2"));
    localMessageBox.open();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.method.z
 * JD-Core Version:    0.6.0
 */