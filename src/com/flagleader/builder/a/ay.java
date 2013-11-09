package com.flagleader.builder.a;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableColumn;

class ay extends SelectionAdapter
{
  ay(ax paramax, TableColumn paramTableColumn, int paramInt)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    ax.d(this.a);
    if ((this.b.getData("order") == null) || (this.b.getData("order").toString().equals("down")))
      this.b.setData("order", "up");
    else
      this.b.setData("order", "down");
    this.a.a(this.c, this.b.getData("order").toString().equals("up"));
    if (this.a.p() == null)
      this.a.update();
    if (this.b.getData("order").toString().equals("up"))
      this.b.setImage(ax.x());
    else
      this.b.setImage(ax.y());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.ay
 * JD-Core Version:    0.6.0
 */