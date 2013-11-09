package com.flagleader.builder.dialogs.method;

import com.flagleader.builder.ResourceTools;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

class L extends SelectionAdapter
{
  L(I paramI)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (!this.a.j.a())
    {
      MessageBox localMessageBox = new MessageBox(this.a.a, 32802);
      localMessageBox.setText(this.a.a.getText());
      localMessageBox.setMessage(ResourceTools.formatMessage("canfind.SearchDialog", new String[] { this.a.b.getText() }));
      localMessageBox.open();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.method.L
 * JD-Core Version:    0.6.0
 */