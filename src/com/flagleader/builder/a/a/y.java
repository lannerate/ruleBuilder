package com.flagleader.builder.a.a;

import com.flagleader.repository.db.ParameterModel;
import com.flagleader.repository.db.ProcedureModel;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class y
  implements Listener
{
  y(r paramr)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    TableItem[] arrayOfTableItem = o.a(r.a(this.a)).getSelection();
    for (int i = 0; i < arrayOfTableItem.length; i++)
    {
      if ((arrayOfTableItem[i].getData() == null) || (!(arrayOfTableItem[i].getData() instanceof ParameterModel)))
        continue;
      o.b(r.a(this.a)).deleteParaModel((ParameterModel)arrayOfTableItem[i].getData());
    }
    o.b(r.a(this.a)).setModified(true);
    r.a(this.a).update();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.y
 * JD-Core Version:    0.6.0
 */