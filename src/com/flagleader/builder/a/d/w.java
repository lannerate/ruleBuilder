package com.flagleader.builder.a.d;

import com.flagleader.builder.a.c.f;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeItem;

class w extends FocusAdapter
{
  w(o paramo, f paramf, TreeItem paramTreeItem)
  {
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    if ((o.d(this.a) != null) && (!o.d(this.a).isDisposed()) && (this.b.a(o.d(this.a).getText())))
      this.a.c(this.c);
    this.a.o();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.w
 * JD-Core Version:    0.6.0
 */