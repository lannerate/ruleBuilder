package com.flagleader.builder.shell;

import com.flagleader.builder.dialogs.q;
import java.sql.ResultSet;
import java.sql.Statement;
import org.eclipse.swt.widgets.Display;

class fT
  implements Runnable
{
  fT(fE paramfE, ResultSet paramResultSet, q paramq)
  {
  }

  public void run()
  {
    try
    {
      if (fE.a(this.a, this.b))
      {
        this.c.close();
        if (this.a.f != null)
          this.a.f.close();
        Display.getCurrent().timerExec(-1, this);
      }
      else
      {
        Display.getCurrent().timerExec(0, this);
      }
    }
    catch (Exception localException)
    {
      this.c.close();
      Display.getCurrent().timerExec(-1, this);
      localException.printStackTrace();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.fT
 * JD-Core Version:    0.6.0
 */