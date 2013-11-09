package org.agilemore.agilegrid.samples;

import com.a.c;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ToolItem;

class l extends SelectionAdapter
{
  l(k paramk)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    k.a(this.a).setText("Send Mail: " + k.b(this.a).toString());
    k.c(this.a).setImage(c.b(k.class, "/icons/browser.png"));
    k.d(this.a).setEnabled(false);
    k.e(this.a).setEnabled(true);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.samples.l
 * JD-Core Version:    0.6.0
 */