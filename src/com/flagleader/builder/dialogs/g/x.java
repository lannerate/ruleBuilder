package com.flagleader.builder.dialogs.g;

import com.flagleader.util.NumberUtil;
import java.util.List;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

class x extends SelectionAdapter
{
  x(v paramv)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    List localList = (List)this.a.a.get(v.d(this.a).getSelectionIndex());
    v.a(this.a, NumberUtil.getInt(localList.get(0)));
    v.b(this.a, String.valueOf(localList.get(1)));
    super.widgetSelected(paramSelectionEvent);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.g.x
 * JD-Core Version:    0.6.0
 */