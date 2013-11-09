package com.flagleader.builder.actions.i;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.builder.actions.bm;
import com.flagleader.manager.builder.d;
import com.flagleader.repository.tree.ITreeNode;

public class m extends bl
{
  public m(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    this.a.getWindowsManager().b(true);
    this.a.getWindowsManager().a();
    this.a.getProjectTree().j();
  }

  public String a()
  {
    return "PropertiesItem";
  }

  public boolean a(ITreeNode paramITreeNode)
  {
    return paramITreeNode != null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.i.m
 * JD-Core Version:    0.6.0
 */