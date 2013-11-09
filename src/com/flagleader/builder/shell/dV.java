package com.flagleader.builder.shell;

import com.flagleader.engine.Property;
import java.util.Date;
import org.eclipse.swt.widgets.TableItem;

class dV
  implements Runnable
{
  dV(RuleServerTray paramRuleServerTray, String paramString1, String paramString2, String paramString3, int paramInt)
  {
  }

  public void run()
  {
    try
    {
      TableItem localTableItem = new TableItem(this.a.g, 0);
      localTableItem.setText(1, this.b);
      localTableItem.setText(2, Property.getInstance().formatDatetime(new Date()));
      localTableItem.setText(3, this.c);
      localTableItem.setText(4, this.d);
      localTableItem.setText(0, this.e);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.dV
 * JD-Core Version:    0.6.0
 */