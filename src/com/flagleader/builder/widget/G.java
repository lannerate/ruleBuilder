package com.flagleader.builder.widget;

import com.flagleader.manager.e.z;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TableItem;

class G extends SelectionAdapter
{
  G(F paramF, TableItem paramTableItem)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if ((this.b.getData() instanceof z))
    {
      TableEditor localTableEditor = (TableEditor)this.b.getData("edit");
      localTableEditor.getEditor().dispose();
      localTableEditor.setEditor(null, this.b, 2);
      this.b.dispose();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.G
 * JD-Core Version:    0.6.0
 */