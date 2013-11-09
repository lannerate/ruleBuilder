package com.flagleader.builder.a.a;

import com.flagleader.builder.a.c.f;
import com.flagleader.repository.db.ParameterModel;
import com.flagleader.repository.db.ProcedureModel;
import org.eclipse.swt.widgets.TableItem;

class s
  implements f
{
  s(r paramr, TableItem paramTableItem)
  {
  }

  public String a()
  {
    return this.b.getText(4);
  }

  public boolean a(String paramString)
  {
    ParameterModel localParameterModel = (ParameterModel)this.b.getData();
    if (!localParameterModel.getDisplayName().equals(paramString))
    {
      localParameterModel.setDisplayName(paramString);
      o.b(r.a(this.a)).changeParaDisplayName(localParameterModel);
      o.b(r.a(this.a)).setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.s
 * JD-Core Version:    0.6.0
 */