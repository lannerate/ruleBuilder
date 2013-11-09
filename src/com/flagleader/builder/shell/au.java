package com.flagleader.builder.shell;

import org.eclipse.swt.browser.LocationEvent;
import org.eclipse.swt.browser.LocationListener;
import org.eclipse.swt.widgets.Text;

class au
  implements LocationListener
{
  au(as paramas)
  {
  }

  public void changed(LocationEvent paramLocationEvent)
  {
    this.a.b = true;
    if (paramLocationEvent.top)
      this.a.c.setText(paramLocationEvent.location);
  }

  public void changing(LocationEvent paramLocationEvent)
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.au
 * JD-Core Version:    0.6.0
 */