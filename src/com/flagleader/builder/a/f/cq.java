package com.flagleader.builder.a.f;

import com.flagleader.repository.rlm.IRuleObject;
import com.flagleader.repository.rlm.e;
import com.flagleader.repository.rlm.lang.ILangToken;
import com.flagleader.repository.tree.Rule;
import java.util.List;
import org.agilemore.agilegrid.G;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class cq
  implements Listener
{
  cq(cm paramcm, G paramG)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    int i = this.b.c - 1;
    if ((cm.a(this.a).e().size() > i) && (i >= 0))
    {
      e locale = (e)cm.a(this.a).e().get(i);
      if (locale.e() == 1)
      {
        locale.f().dispose();
        cm.a(this.a).update();
      }
      else if (locale.e() == 2)
      {
        ck.a(cm.a(this.a)).setSupportEnter(false);
        cm.a(this.a).update();
      }
      else if (locale.e() == 3)
      {
        ck.a(cm.a(this.a)).setSupportInit(false);
        cm.a(this.a).update();
      }
      else if (locale.e() == 5)
      {
        ck.a(cm.a(this.a)).setSupportCatch(false);
        cm.a(this.a).update();
      }
      else if (locale.e() == 4)
      {
        ck.a(cm.a(this.a)).setSupportElse(false);
        cm.a(this.a).update();
      }
      else if ((locale.e() == 0) && (this.b.d == 0))
      {
        locale.a(this.b.d).dispose();
        cm.a(this.a).update();
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.cq
 * JD-Core Version:    0.6.0
 */