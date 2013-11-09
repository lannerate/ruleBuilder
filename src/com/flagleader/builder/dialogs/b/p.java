package com.flagleader.builder.dialogs.b;

import com.flagleader.database.ConnectionFactory;
import java.util.HashMap;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;

class p
  implements ModifyListener
{
  p(n paramn, Combo paramCombo)
  {
  }

  public void modifyText(ModifyEvent paramModifyEvent)
  {
    if (n.a(this.a).containsKey(this.b.getText()))
    {
      this.a.d.setText((String)n.a(this.a).get(this.b.getText()));
      if (!ConnectionFactory.driverAvailable(this.b.getText()))
        this.a.d.setEditable(false);
      else
        this.a.d.setEditable(true);
    }
    else
    {
      this.a.d.setText("");
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.b.p
 * JD-Core Version:    0.6.0
 */