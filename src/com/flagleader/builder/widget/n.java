package com.flagleader.builder.widget;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

class n extends SelectionAdapter
{
  n(i parami, TableColumn paramTableColumn, String[] paramArrayOfString, int paramInt)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    i.h(this.a);
    if ((this.b.getData("order") == null) || (this.b.getData("order").toString().equals("down")))
      this.b.setData("order", "up");
    else
      this.b.setData("order", "down");
    if ((this.c != null) && (this.d < this.c.length))
      this.a.a(this.d, this.c[this.d], this.b.getData("order").toString().equals("up"));
    else
      this.a.a(this.d, "string", this.b.getData("order").toString().equals("up"));
    if (this.b.getData("order").toString().equals("down"))
    {
      i.c(this.a).setSortColumn(this.b);
      i.c(this.a).setSortDirection(128);
    }
    else
    {
      i.c(this.a).setSortColumn(this.b);
      i.c(this.a).setSortDirection(1024);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.n
 * JD-Core Version:    0.6.0
 */