package com.flagleader.builder.c;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.bu;
import com.flagleader.manager.c.b;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

public class x extends k
{
  b a = null;

  public x(ITreeNode paramITreeNode, Composite paramComposite, bu parambu)
  {
    super(paramITreeNode, paramComposite, parambu);
    this.a = parambu.i().getRulesManager().a(this, this.d);
  }

  protected void a(Table paramTable)
  {
    this.a.a();
  }

  public String getCompositeUuid()
  {
    return d().getEditUuid() + "props1";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.c.x
 * JD-Core Version:    0.6.0
 */