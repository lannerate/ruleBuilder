package com.flagleader.builder.actions.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.builder.dialogs.b.h;
import com.flagleader.repository.db.SheetMap;
import com.flagleader.repository.tree.BOContainerGroup;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.widgets.Shell;

public class t extends bl
{
  public t(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof BOContainerGroup;
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof BOContainerGroup)))
    {
      h localh = new h(new Shell());
      if (localh.open() == 0)
      {
        BOContainerGroup localBOContainerGroup = (BOContainerGroup)paramITreeNode;
        SheetMap localSheetMap = new SheetMap("", localh.a(), localh.b());
        localBOContainerGroup.addChildElement(localSheetMap);
        localBOContainerGroup.setModified(true);
        localBOContainerGroup.updateTree();
      }
    }
  }

  public String a()
  {
    return "NewSheetMap";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.b.t
 * JD-Core Version:    0.6.0
 */