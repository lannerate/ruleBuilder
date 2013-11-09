package com.flagleader.builder.actions.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.builder.dialogs.b.A;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.xml.TreeValueNode;
import java.util.List;
import org.eclipse.swt.widgets.Shell;

public class d extends bl
{
  public d(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof TreeValueNode)))
    {
      TreeValueNode localTreeValueNode = (TreeValueNode)paramITreeNode;
      A localA = new A(new Shell(), localTreeValueNode);
      if ((localA.open() == 0) && (localA.a().size() > 0))
      {
        if (localA.b())
          localTreeValueNode.addInsertFunction(localA.a());
        else
          localTreeValueNode.addUpdateFunction(localA.a());
        localTreeValueNode.updateViewer();
      }
    }
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof TreeValueNode;
  }

  protected boolean d()
  {
    return true;
  }

  public String a()
  {
    return "AddTreeInserts";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.b.d
 * JD-Core Version:    0.6.0
 */