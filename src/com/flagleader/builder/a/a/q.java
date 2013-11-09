package com.flagleader.builder.a.a;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

class q extends SelectionAdapter
{
  q(p paramp)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    int i = p.f(this.a).getSelectionIndex();
    if (i >= 0)
    {
      p.g(this.a).setItems(o.v[i]);
      if (p.g(this.a).getItemCount() < 20)
        p.g(this.a).setVisibleItemCount(p.g(this.a).getItemCount());
      else
        p.g(this.a).setVisibleItemCount(20);
      p.g(this.a).setText(o.u[i]);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.q
 * JD-Core Version:    0.6.0
 */