package com.flagleader.builder.dialogs;

import com.flagleader.database.ConnectionFactory;
import java.util.HashMap;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;

class i
  implements ModifyListener
{
  i(h paramh, Combo paramCombo)
  {
  }

  public void modifyText(ModifyEvent paramModifyEvent)
  {
    if (h.a(this.a).containsKey(this.b.getText()))
    {
      this.a.c.setText((String)h.a(this.a).get(this.b.getText()));
      if (!ConnectionFactory.driverAvailable(this.b.getText()))
        this.a.c.setEditable(false);
      else
        this.a.c.setEditable(true);
    }
    else
    {
      this.a.c.setText("");
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.i
 * JD-Core Version:    0.6.0
 */