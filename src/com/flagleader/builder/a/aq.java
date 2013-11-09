package com.flagleader.builder.a;

import com.flagleader.repository.IElement;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableItem;

class aq extends SelectionAdapter
{
  aq(an paraman)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    TableItem localTableItem = (TableItem)paramSelectionEvent.item;
    if ((localTableItem != null) && ((localTableItem.getData() instanceof IElement)))
    {
      if (this.a.b())
      {
        localTableItem.setChecked(!localTableItem.getChecked());
        return;
      }
      if (this.a.a((IElement)localTableItem.getData(), localTableItem.getChecked()));
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.aq
 * JD-Core Version:    0.6.0
 */