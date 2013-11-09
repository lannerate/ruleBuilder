package com.flagleader.builder.shell;

import com.flagleader.builder.widget.a.X;
import com.flagleader.repository.export.Tag;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;

class cB
  implements ModifyListener
{
  cB(cA paramcA)
  {
  }

  public void modifyText(ModifyEvent paramModifyEvent)
  {
    if (cA.a(this.a))
    {
      cA.b(this.a).setPreCode(cA.c(this.a).m().getText());
      bX.a(cA.d(this.a), true);
    }
    else
    {
      cA.b(this.a).setPostCode(cA.c(this.a).m().getText());
      bX.a(cA.d(this.a), true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.cB
 * JD-Core Version:    0.6.0
 */