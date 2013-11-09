package com.flagleader.builder.shell;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolItem;

class at
  implements Listener
{
  at(as paramas, ToolItem paramToolItem1, ToolItem paramToolItem2, ToolItem paramToolItem3, ToolItem paramToolItem4, ToolItem paramToolItem5)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    ToolItem localToolItem = (ToolItem)paramEvent.widget;
    if (localToolItem == this.b)
      this.a.d.back();
    else if (localToolItem == this.c)
      this.a.d.forward();
    else if (localToolItem == this.d)
      this.a.d.stop();
    else if (localToolItem == this.e)
      this.a.d.refresh();
    else if (localToolItem == this.f)
      this.a.d.setUrl(this.a.c.getText());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.at
 * JD-Core Version:    0.6.0
 */