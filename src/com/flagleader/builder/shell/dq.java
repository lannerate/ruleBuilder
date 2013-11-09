package com.flagleader.builder.shell;

import com.flagleader.engine.RuleEngineFactory;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class dq extends SelectionAdapter
{
  dq(df paramdf)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (df.d(this.a) != null)
    {
      TableItem[] arrayOfTableItem = df.c(this.a).getItems();
      for (int i = 0; i < arrayOfTableItem.length; i++)
      {
        if (!arrayOfTableItem[i].getChecked())
          continue;
        df.d(this.a).activePack(arrayOfTableItem[i].getText(1), 1);
        arrayOfTableItem[i].setText(4, "false");
        arrayOfTableItem[i].setChecked(false);
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.dq
 * JD-Core Version:    0.6.0
 */