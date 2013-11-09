package com.flagleader.builder.actions.j;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.d.p;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.tree.ITreeNode;

public class f extends x
{
  public f(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if (!e())
      return;
    if ((paramITreeNode == null) || (!(paramITreeNode instanceof IPage)))
      return;
    IPage localIPage = (IPage)paramITreeNode;
    new p(this.a, localIPage).open();
  }

  public String a()
  {
    return "DeployPage";
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof IPage;
  }

  protected boolean d()
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.j.f
 * JD-Core Version:    0.6.0
 */