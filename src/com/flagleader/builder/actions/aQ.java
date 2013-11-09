package com.flagleader.builder.actions;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeItem;

class aQ extends FocusAdapter
{
  aQ(aO paramaO, TreeItem paramTreeItem)
  {
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    if ((aO.b(this.a) == null) && (aO.b(this.a).isDisposed()))
      return;
    String str = aO.b(this.a).getText();
    aO.a(this.a, str, this.b);
    aO.b(this.a).dispose();
    aO.a(this.a, null);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.aQ
 * JD-Core Version:    0.6.0
 */