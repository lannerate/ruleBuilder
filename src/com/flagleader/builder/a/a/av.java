package com.flagleader.builder.a.a;

import com.flagleader.builder.dialogs.b.m;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.db.TableFunction;
import com.flagleader.repository.rom.MethodParam;
import java.util.List;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

class av
  implements Listener
{
  av(au paramau, TableFunction paramTableFunction)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    m localm = new m(new Shell(), this.b);
    if ((localm.open() == 0) && (localm.c().length() > 0) && (localm.a().length() > 0))
    {
      this.b.setValueName("setWhereObject(" + localm.a() + ")");
      this.b.setDisplayName(localm.c());
      this.b.setVariableName("setWhereObject(\"" + localm.a() + "\",{arg1})");
      this.b.getParams().set(0, new MethodParam(localm.b(), 0));
      this.a.K().setModified(true);
      this.a.update();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.av
 * JD-Core Version:    0.6.0
 */