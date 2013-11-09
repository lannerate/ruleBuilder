package com.flagleader.builder.a.a;

import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.db.ProcedureModel;
import org.eclipse.swt.widgets.Composite;

public class n extends B
  implements IElementViewer
{
  private static final String q = "columns.ProcedureFieldView";

  public n(ProcedureModel paramProcedureModel, Composite paramComposite, bu parambu)
  {
    super(paramProcedureModel, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new n((ProcedureModel)this.c, paramComposite, this.a);
  }

  public String getCompositeUuid()
  {
    return super.getCompositeUuid() + "field";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.n
 * JD-Core Version:    0.6.0
 */