package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.widget.h;
import com.flagleader.manager.d.b;
import com.flagleader.repository.e;
import java.util.List;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

class aL
  implements Runnable
{
  aL(aq paramaq, boolean paramBoolean, List paramList)
  {
  }

  public void run()
  {
    if (!this.b)
      aq.i(this.a).removeAll();
    if (this.c == null)
      return;
    for (int i = 0; i < this.c.size(); i++)
    {
      e locale = (e)this.c.get(i);
      if ((!aq.e(this.a).getConfigManager().E()) && (locale.d() != 1) && (locale.d() != 0) && (locale.d() != 10))
        continue;
      TableItem localTableItem = new TableItem(aq.i(this.a), 0);
      localTableItem.setText(new String[] { locale.a(), locale.c() == null ? "" : locale.c().toString(), locale.b() });
      if ((locale.d() == 1) || (locale.d() == 0))
        localTableItem.setForeground(0, h.g);
      else if (locale.d() == 2)
        localTableItem.setForeground(0, h.a);
      else if (locale.d() == 10)
        localTableItem.setForeground(0, h.g);
      else if (locale.d() == 3)
        localTableItem.setForeground(0, h.j);
      localTableItem.setData(locale.c());
    }
    for (i = 0; i < aq.i(this.a).getColumnCount(); i++)
      aq.i(this.a).getColumns()[i].pack();
    if (aq.i(this.a).getItemCount() > 0)
      aq.j(this.a).setSelection(0);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.aL
 * JD-Core Version:    0.6.0
 */