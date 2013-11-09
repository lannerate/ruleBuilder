package com.flagleader.builder.actions.c;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.dialogs.e.h;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.tree.IDebugNode;
import com.flagleader.repository.tree.ITreeNode;
import java.util.List;

public class a extends r
{
  public a(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode == null) || (paramITreeNode.isLocked()) || (!(paramITreeNode instanceof IDebugNode)))
      return;
    IDebugNode localIDebugNode = (IDebugNode)paramITreeNode;
    h localh = new h(this.a.getShell(), localIDebugNode.getEnvionment());
    if (localh.open() == 0)
    {
      List localList = localh.a();
      int i = 0;
      for (int j = 0; j < localList.size(); j++)
      {
        IVariableObject localIVariableObject = (IVariableObject)localList.get(j);
        if (!localIDebugNode.addVariableDebug(localIVariableObject))
          continue;
        i = 1;
      }
      if (i != 0)
      {
        IElementViewer localIElementViewer = this.a.getRuleEditor().e();
        if (localIElementViewer != null)
          localIElementViewer.update();
        localIDebugNode.setModified(true);
      }
    }
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof IDebugNode;
  }

  public String a()
  {
    return "AddDebug";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.c.a
 * JD-Core Version:    0.6.0
 */