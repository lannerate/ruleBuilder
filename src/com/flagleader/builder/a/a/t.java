package com.flagleader.builder.a.a;

import com.flagleader.builder.a.c.f;
import com.flagleader.repository.db.ParameterModel;
import com.flagleader.repository.db.ProcedureModel;
import org.eclipse.swt.widgets.TableItem;

class t
  implements f
{
  t(r paramr, TableItem paramTableItem)
  {
  }

  public String a()
  {
    return this.b.getText(0);
  }

  public boolean a(String paramString)
  {
    ParameterModel localParameterModel = (ParameterModel)this.b.getData();
    if (localParameterModel.getPos() != Integer.parseInt(paramString))
    {
      localParameterModel.setPos(Integer.parseInt(paramString));
      o.b(r.a(this.a)).changeParaPos(localParameterModel, Integer.parseInt(paramString));
      o.b(r.a(this.a)).setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.t
 * JD-Core Version:    0.6.0
 */