package com.flagleader.builder.a.a;

import com.flagleader.repository.db.ParameterModel;
import com.flagleader.repository.db.ProcedureModel;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class x
  implements Listener
{
  x(r paramr)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    p localp = new p(r.a(this.a));
    if ((localp.open() == 0) && (localp.a().length() > 0))
    {
      ParameterModel localParameterModel = new ParameterModel();
      for (int i = 0; i < o.t.length; i++)
      {
        if (!o.t[i].equals(p.a(localp)))
          continue;
        localParameterModel.setIType(o.s[i]);
      }
      for (i = 0; i < o.r.length; i++)
      {
        if (!o.r[i].equals(p.b(localp)))
          continue;
        localParameterModel.setModetype(o.q[i]);
      }
      localParameterModel.setValueType(p.c(localp));
      localParameterModel.setPos(Integer.parseInt(p.d(localp)));
      localParameterModel.setDisplayName(p.e(localp));
      o.b(r.a(this.a)).addParaModel(localParameterModel);
      o.b(r.a(this.a)).setModified(true);
      r.a(this.a).update();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.x
 * JD-Core Version:    0.6.0
 */