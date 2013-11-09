package com.flagleader.builder.widget;

import com.flagleader.manager.e.z;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class H extends SelectionAdapter
{
  H(F paramF)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    TableItem[] arrayOfTableItem = E.a(F.a(this.a)).getItems();
    for (int i = 0; i < arrayOfTableItem.length; i++)
    {
      if ((arrayOfTableItem[i].getData() == null) || (!(arrayOfTableItem[i].getData() instanceof z)))
        continue;
      TableEditor localTableEditor = (TableEditor)arrayOfTableItem[i].getData("edit");
      localTableEditor.getEditor().dispose();
      localTableEditor.setEditor(null, arrayOfTableItem[i], 2);
      arrayOfTableItem[i].dispose();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.H
 * JD-Core Version:    0.6.0
 */