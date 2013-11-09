package com.flagleader.builder.actions.c;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.actions.bl;
import com.flagleader.builder.dialogs.e.h;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.Rule;
import java.util.List;

public class b extends bl
{
  public b(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    Rule localRule = (Rule)paramITreeNode;
    h localh = new h(this.a.getShell(), localRule.getEnvionment());
    if (localh.open() == 0)
    {
      List localList = localh.a();
      int i = 0;
      for (int j = 0; j < localList.size(); j++)
      {
        IVariableObject localIVariableObject = (IVariableObject)localList.get(j);
        if (!localRule.addVariableInit(localIVariableObject))
          continue;
        i = 1;
      }
      if (i != 0)
      {
        IElementViewer localIElementViewer = this.a.getRuleEditor().e();
        if (localIElementViewer != null)
          localIElementViewer.update();
        localRule.setModified(true);
      }
    }
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof Rule;
  }

  public String a()
  {
    return "AddInit";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.c.b
 * JD-Core Version:    0.6.0
 */