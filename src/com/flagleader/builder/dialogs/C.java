package com.flagleader.builder.dialogs;

import com.flagleader.database.ConnectionFactory;
import java.util.HashMap;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;

class C
  implements ModifyListener
{
  C(z paramz, Combo paramCombo)
  {
  }

  public void modifyText(ModifyEvent paramModifyEvent)
  {
    if (z.a().containsKey(this.b.getText()))
    {
      z.l(this.a).setText((String)z.a().get(this.b.getText()));
      if (!ConnectionFactory.driverAvailable(this.b.getText()))
        z.l(this.a).setEditable(false);
      else
        z.l(this.a).setEditable(true);
    }
    else
    {
      z.l(this.a).setText("");
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.C
 * JD-Core Version:    0.6.0
 */