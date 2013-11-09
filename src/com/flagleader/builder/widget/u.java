package com.flagleader.builder.widget;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TreeColumn;

class u extends SelectionAdapter
{
  u(s params, TreeColumn paramTreeColumn, String[] paramArrayOfString, int paramInt)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    s.d(this.a);
    if ((this.b.getData("order") == null) || (this.b.getData("order").toString().equals("down")))
      this.b.setData("order", "up");
    else
      this.b.setData("order", "down");
    if ((this.c != null) && (this.d < this.c.length))
      this.a.a(this.d, this.c[this.d], this.b.getData("order").toString().equals("up"));
    else
      this.a.a(this.d, "string", this.b.getData("order").toString().equals("up"));
    if (this.b.getData("order").toString().equals("up"))
      this.b.setImage(s.e());
    else
      this.b.setImage(s.f());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.u
 * JD-Core Version:    0.6.0
 */