package com.flagleader.builder.actions.d;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.builder.dialogs.a.d;
import com.flagleader.repository.soap.SoapService;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import java.util.List;

public class m extends bl
{
  public m(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof Envionment)))
    {
      d locald = new d(this.a.getShell());
      if (locald.open() == 0)
      {
        List localList = locald.a();
        for (int i = 0; i < localList.size(); i++)
        {
          if (!(localList.get(i) instanceof SoapService))
            continue;
          ((Envionment)paramITreeNode).addChildElement((SoapService)localList.get(i));
          ((SoapService)localList.get(i)).updateFunction();
          ((SoapService)localList.get(i)).setModified(true);
        }
        ((Envionment)paramITreeNode).updateTree();
      }
    }
  }

  protected boolean d()
  {
    return true;
  }

  public String a()
  {
    return "LoadSoapService";
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof Envionment;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.d.m
 * JD-Core Version:    0.6.0
 */