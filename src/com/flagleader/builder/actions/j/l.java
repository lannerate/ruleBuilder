package com.flagleader.builder.actions.j;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.ITreeNode;

public class l extends bl
{
  public l(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public boolean a(ITreeNode paramITreeNode)
  {
    return this.a.getRulesManager().a() != null;
  }

  public void b(ITreeNode paramITreeNode)
  {
    if (this.a.getRulesManager().a() != null)
    {
      this.a.getRulesManager().a(null, 0, 0);
      this.a.showSuccess(c.b("logtou.LoginDialog"));
    }
  }

  public String a()
  {
    return "logoutServer";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.j.l
 * JD-Core Version:    0.6.0
 */