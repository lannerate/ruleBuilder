package com.flagleader.builder.shell;

import com.flagleader.repository.lang.info.InfoClass;
import com.flagleader.repository.lang.info.InfoMember;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class v
  implements Listener
{
  v(u paramu)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    TableItem[] arrayOfTableItem = ClassInfoEditor.k(u.a(this.a)).getSelection();
    for (int i = 0; i < arrayOfTableItem.length; i++)
    {
      InfoMember localInfoMember = (InfoMember)arrayOfTableItem[i].getData();
      localInfoMember.getInfoClass().setModified(true);
      localInfoMember.dispose();
    }
    for (i = 0; i < arrayOfTableItem.length; i++)
      arrayOfTableItem[i].dispose();
    u.a(this.a).d();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.v
 * JD-Core Version:    0.6.0
 */