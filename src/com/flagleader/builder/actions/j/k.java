package com.flagleader.builder.actions.j;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.ITreeNode;

public class k extends bl
{
  public k(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public boolean a(ITreeNode paramITreeNode)
  {
    return this.a.getRulesManager().a() == null;
  }

  public void b(ITreeNode paramITreeNode)
  {
    try
    {
      String str = this.a.getUserServer();
      int i = this.a.getUserType();
      int j = this.a.getUserid();
      if ((str != null) && (j != 0) && (i >= 1))
        this.a.showSuccess(c.b("success.LoginDialog"));
    }
    catch (Exception localException)
    {
      this.a.showError(localException.getMessage());
    }
  }

  public String a()
  {
    return "loginServer";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.j.k
 * JD-Core Version:    0.6.0
 */